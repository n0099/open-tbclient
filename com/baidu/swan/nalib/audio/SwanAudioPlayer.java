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
import d.a.h0.j.a.b;
import d.a.h0.j.a.c;
import org.webrtc.MediaStreamTrack;
@Keep
/* loaded from: classes3.dex */
public class SwanAudioPlayer {
    public static final int DEFAULT_BUFFER_SIZE_IN_FRAMES = 192;
    public static final int DEFAULT_SAMPLE_RATE = 44100;
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
    public static final String TAG = "AudioPlayer";
    public static volatile SwanAudioPlayer instance = null;
    public static int mSampleBufSize = 192;
    public static int mSampleRate = 44100;
    public b mAudioRecordListener;
    public a mEventHandler;
    public SparseArray<MediaPlayer.OnSeekCompleteListener> mSeekMap = new SparseArray<>();
    public SparseArray<MediaPlayer.OnErrorListener> mErrorMap = new SparseArray<>();
    public SparseArray<MediaPlayer.OnPreparedListener> mPreparedMap = new SparseArray<>();
    public SparseArray<MediaPlayer.OnCompletionListener> mEndMap = new SparseArray<>();
    public SparseArray<c> mPausedMap = new SparseArray<>();

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -1) {
                MediaPlayer.OnErrorListener onErrorListener = (MediaPlayer.OnErrorListener) SwanAudioPlayer.this.mErrorMap.get(message.arg1);
                if (onErrorListener != null) {
                    onErrorListener.onError(null, message.arg1, message.arg2);
                }
            } else if (i2 == 1) {
                MediaPlayer.OnPreparedListener onPreparedListener = (MediaPlayer.OnPreparedListener) SwanAudioPlayer.this.mPreparedMap.get(message.arg1);
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(null);
                }
            } else if (i2 == 3) {
                MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = (MediaPlayer.OnSeekCompleteListener) SwanAudioPlayer.this.mSeekMap.get(message.arg1);
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete(null);
                }
            } else if (i2 == 4) {
                MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) SwanAudioPlayer.this.mEndMap.get(message.arg1);
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(null);
                }
            } else if (i2 == 5) {
                c cVar = (c) SwanAudioPlayer.this.mPausedMap.get(message.arg1);
                if (cVar != null) {
                    cVar.onPause();
                }
            } else if (i2 == 100) {
                SwanAudioPlayer.this.postRunnable(Long.parseLong(message.obj.toString()));
            } else if (i2 != 101) {
            } else {
                d.a.h0.j.a.a aVar = (d.a.h0.j.a.a) message.obj;
                if (SwanAudioPlayer.this.mAudioRecordListener != null) {
                    SwanAudioPlayer.this.mAudioRecordListener.a(aVar);
                }
            }
        }
    }

    public SwanAudioPlayer() {
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

    private native void destroy(int i2);

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

    public static native void init(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void postRunnable(long j);

    public static native void release();

    public static final void settingNativeAudioParameters(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        String property2 = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        try {
            mSampleRate = Integer.parseInt(property);
        } catch (NumberFormatException unused) {
        }
        try {
            mSampleBufSize = Integer.parseInt(property2);
        } catch (NumberFormatException unused2) {
        }
        init(mSampleRate, mSampleBufSize);
    }

    public native int getDuration(int i2);

    public native int getPosition(int i2);

    public native int getState(int i2);

    public native boolean isAudioPlayer();

    public native void pause(int i2);

    public native void pauseAll();

    public native void play(int i2, float f2, boolean z);

    public void postAudioData(byte[] bArr, long j) {
        if (bArr != null) {
            d.a.h0.j.a.a aVar = new d.a.h0.j.a.a();
            aVar.f47103a = bArr;
            aVar.f47104b = j;
            aVar.f47105c = System.nanoTime();
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(101, aVar));
        }
    }

    public void postEventFromNative(int i2, int i3, int i4, Object obj) {
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i2, i3, i4, obj));
    }

    public void postRunnableFromNative(long j) {
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(100, 0, 0, Long.valueOf(j)));
    }

    public native void prepare(int i2);

    public synchronized void release(int i2) {
        this.mErrorMap.remove(i2);
        this.mEndMap.remove(i2);
        this.mSeekMap.remove(i2);
        this.mPreparedMap.remove(i2);
        this.mPausedMap.remove(i2);
    }

    public native void resume();

    public native void seek(int i2, int i3);

    public native void setAudioRecord(boolean z);

    public native int setDataSource(AssetManager assetManager, String str);

    public native int setDataSource(String str, int i2);

    public native void setLoop(int i2, boolean z);

    public void setOnAudioRecordListener(b bVar) {
        this.mAudioRecordListener = bVar;
    }

    public void setOnCompletionListener(int i2, MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mEndMap.put(i2, onCompletionListener);
    }

    public void setOnErrorListener(int i2, MediaPlayer.OnErrorListener onErrorListener) {
        this.mErrorMap.put(i2, onErrorListener);
    }

    public void setOnPauseListener(int i2, c cVar) {
        this.mPausedMap.put(i2, cVar);
    }

    public void setOnPreparedListener(int i2, MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mPreparedMap.put(i2, onPreparedListener);
    }

    public void setOnSeekCompleteListener(int i2, MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mSeekMap.put(i2, onSeekCompleteListener);
    }

    public native void setVolume(int i2, float f2);

    public native void stop(int i2);

    public native void stopAll();
}
