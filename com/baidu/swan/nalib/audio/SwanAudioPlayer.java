package com.baidu.swan.nalib.audio;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public class SwanAudioPlayer {
    private static final int DEFAULT_BUFFER_SIZE_IN_FRAMES = 192;
    private static final int DEFAULT_SAMPLE_RATE = 44100;
    public static final int HANDLE_EVENT_AUDIO_DATA = 101;
    public static final int HANDLE_EVENT_CALLBACK = 100;
    public static final int HANDLE_EVENT_ERROR = -1;
    public static final int HANDLE_EVENT_PAUSED = 5;
    public static final int HANDLE_EVENT_PLAY_COMPLETE = 4;
    public static final int HANDLE_EVENT_PREPARE = 1;
    public static final int HANDLE_EVENT_SEEK_COMPLETE = 3;
    public static final int HANDLE_EVENT_UPDATE = 2;
    public static final int STATE_DESTROY = 6;
    public static final int STATE_DILE = 0;
    public static final int STATE_END = 5;
    public static final int STATE_PAUSED = 3;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PREPARE = 1;
    public static final int STATE_STOPPED = 4;
    private static final String TAG = "AudioPlayer";
    private static volatile SwanAudioPlayer instance;
    private b mAudioRecordListener;
    private a mEventHandler;
    public static int mSampleRate = 44100;
    public static int mSampleBufSize = 192;
    private SparseArray<MediaPlayer.OnSeekCompleteListener> mSeekMap = new SparseArray<>();
    private SparseArray<MediaPlayer.OnErrorListener> mErrorMap = new SparseArray<>();
    private SparseArray<MediaPlayer.OnPreparedListener> mPreparedMap = new SparseArray<>();
    private SparseArray<MediaPlayer.OnCompletionListener> mEndMap = new SparseArray<>();
    private SparseArray<c> mPausedMap = new SparseArray<>();

    private native void destroy(int i);

    private static native void init(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void postRunnable(long j);

    public static native void release();

    public native int getDuration(int i);

    public native int getPosition(int i);

    public native int getState(int i);

    public native boolean isAudioPlayer();

    public native void pause(int i);

    public native void pauseAll();

    public native void play(int i, float f, boolean z);

    public native void prepare(int i);

    public native void resume();

    public native void seek(int i, int i2);

    public native void setAudioRecord(boolean z);

    public native int setDataSource(AssetManager assetManager, String str);

    public native int setDataSource(String str, int i);

    public native void setLoop(int i, boolean z);

    public native void setVolume(int i, float f);

    public native void stop(int i);

    public native void stopAll();

    public static SwanAudioPlayer getInstance() {
        if (instance == null) {
            synchronized (SwanAudioPlayer.class) {
                if (instance == null) {
                    instance = new SwanAudioPlayer();
                }
            }
        }
        return instance;
    }

    private SwanAudioPlayer() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new a(myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new a(mainLooper);
        } else {
            this.mEventHandler = null;
        }
    }

    public void setOnPreparedListener(int i, MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mPreparedMap.put(i, onPreparedListener);
    }

    public void setOnSeekCompleteListener(int i, MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mSeekMap.put(i, onSeekCompleteListener);
    }

    public void setOnErrorListener(int i, MediaPlayer.OnErrorListener onErrorListener) {
        this.mErrorMap.put(i, onErrorListener);
    }

    public void setOnCompletionListener(int i, MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mEndMap.put(i, onCompletionListener);
    }

    public void setOnPauseListener(int i, c cVar) {
        this.mPausedMap.put(i, cVar);
    }

    public void setOnAudioRecordListener(b bVar) {
        this.mAudioRecordListener = bVar;
    }

    public synchronized void release(int i) {
        this.mErrorMap.remove(i);
        this.mEndMap.remove(i);
        this.mSeekMap.remove(i);
        this.mPreparedMap.remove(i);
        this.mPausedMap.remove(i);
    }

    public void postEventFromNative(int i, int i2, int i3, Object obj) {
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i, i2, i3, obj));
    }

    public void postRunnableFromNative(long j) {
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(100, 0, 0, Long.valueOf(j)));
    }

    public void postAudioData(byte[] bArr, long j) {
        if (bArr != null) {
            com.baidu.swan.nalib.audio.a aVar = new com.baidu.swan.nalib.audio.a();
            aVar.data = bArr;
            aVar.size = j;
            aVar.time = System.nanoTime();
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(101, aVar));
        }
    }

    /* loaded from: classes4.dex */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case -1:
                    MediaPlayer.OnErrorListener onErrorListener = (MediaPlayer.OnErrorListener) SwanAudioPlayer.this.mErrorMap.get(message.arg1);
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 1:
                    MediaPlayer.OnPreparedListener onPreparedListener = (MediaPlayer.OnPreparedListener) SwanAudioPlayer.this.mPreparedMap.get(message.arg1);
                    if (onPreparedListener != null) {
                        onPreparedListener.onPrepared(null);
                        return;
                    }
                    return;
                case 3:
                    MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = (MediaPlayer.OnSeekCompleteListener) SwanAudioPlayer.this.mSeekMap.get(message.arg1);
                    if (onSeekCompleteListener != null) {
                        onSeekCompleteListener.onSeekComplete(null);
                        return;
                    }
                    return;
                case 4:
                    MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) SwanAudioPlayer.this.mEndMap.get(message.arg1);
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(null);
                        return;
                    }
                    return;
                case 5:
                    c cVar = (c) SwanAudioPlayer.this.mPausedMap.get(message.arg1);
                    if (cVar != null) {
                        cVar.onPause();
                        return;
                    }
                    return;
                case 100:
                    SwanAudioPlayer.this.postRunnable(Long.parseLong(message.obj.toString()));
                    return;
                case 101:
                    com.baidu.swan.nalib.audio.a aVar = (com.baidu.swan.nalib.audio.a) message.obj;
                    if (SwanAudioPlayer.this.mAudioRecordListener != null) {
                        SwanAudioPlayer.this.mAudioRecordListener.a(aVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static final void settingNativeAudioParameters(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        String property2 = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        try {
            mSampleRate = Integer.parseInt(property);
        } catch (NumberFormatException e) {
        }
        try {
            mSampleBufSize = Integer.parseInt(property2);
        } catch (NumberFormatException e2) {
        }
        init(mSampleRate, mSampleBufSize);
    }
}
