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
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l.a.b;
import c.a.p0.l.a.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
@Keep
/* loaded from: classes6.dex */
public class SwanAudioPlayer {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public b mAudioRecordListener;
    public SparseArray<MediaPlayer.OnCompletionListener> mEndMap;
    public SparseArray<MediaPlayer.OnErrorListener> mErrorMap;
    public a mEventHandler;
    public SparseArray<c> mPausedMap;
    public SparseArray<MediaPlayer.OnPreparedListener> mPreparedMap;
    public SparseArray<MediaPlayer.OnSeekCompleteListener> mSeekMap;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAudioPlayer f47329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAudioPlayer swanAudioPlayer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAudioPlayer, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47329a = swanAudioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == -1) {
                    MediaPlayer.OnErrorListener onErrorListener = (MediaPlayer.OnErrorListener) this.f47329a.mErrorMap.get(message.arg1);
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, message.arg1, message.arg2);
                    }
                } else if (i2 == 1) {
                    MediaPlayer.OnPreparedListener onPreparedListener = (MediaPlayer.OnPreparedListener) this.f47329a.mPreparedMap.get(message.arg1);
                    if (onPreparedListener != null) {
                        onPreparedListener.onPrepared(null);
                    }
                } else if (i2 == 3) {
                    MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = (MediaPlayer.OnSeekCompleteListener) this.f47329a.mSeekMap.get(message.arg1);
                    if (onSeekCompleteListener != null) {
                        onSeekCompleteListener.onSeekComplete(null);
                    }
                } else if (i2 == 4) {
                    MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) this.f47329a.mEndMap.get(message.arg1);
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(null);
                    }
                } else if (i2 == 5) {
                    c cVar = (c) this.f47329a.mPausedMap.get(message.arg1);
                    if (cVar != null) {
                        cVar.onPause();
                    }
                } else if (i2 == 100) {
                    this.f47329a.postRunnable(Long.parseLong(message.obj.toString()));
                } else if (i2 != 101) {
                } else {
                    c.a.p0.l.a.a aVar = (c.a.p0.l.a.a) message.obj;
                    if (this.f47329a.mAudioRecordListener != null) {
                        this.f47329a.mAudioRecordListener.a(aVar);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(735843163, "Lcom/baidu/swan/nalib/audio/SwanAudioPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(735843163, "Lcom/baidu/swan/nalib/audio/SwanAudioPlayer;");
        }
    }

    public SwanAudioPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSeekMap = new SparseArray<>();
        this.mErrorMap = new SparseArray<>();
        this.mPreparedMap = new SparseArray<>();
        this.mEndMap = new SparseArray<>();
        this.mPausedMap = new SparseArray<>();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new a(this, myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new a(this, mainLooper);
        } else {
            this.mEventHandler = null;
        }
    }

    private native void destroy(int i2);

    public static SwanAudioPlayer getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (instance == null) {
                synchronized (SwanAudioPlayer.class) {
                    if (instance == null) {
                        instance = new SwanAudioPlayer();
                    }
                }
            }
            return instance;
        }
        return (SwanAudioPlayer) invokeV.objValue;
    }

    public static native void init(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void postRunnable(long j2);

    public static native void release();

    public static final void settingNativeAudioParameters(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
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
    }

    public native int getDuration(int i2);

    public native int getPosition(int i2);

    public native int getState(int i2);

    public native boolean isAudioPlayer();

    public native void pause(int i2);

    public native void pauseAll();

    public native void play(int i2, float f2, boolean z);

    public void postAudioData(byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, bArr, j2) == null) || bArr == null) {
            return;
        }
        c.a.p0.l.a.a aVar = new c.a.p0.l.a.a();
        aVar.f11845a = bArr;
        aVar.f11846b = j2;
        aVar.f11847c = System.nanoTime();
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(101, aVar));
    }

    public void postEventFromNative(int i2, int i3, int i4, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj}) == null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i2, i3, i4, obj));
        }
    }

    public void postRunnableFromNative(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(100, 0, 0, Long.valueOf(j2)));
        }
    }

    public native void prepare(int i2);

    public synchronized void release(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            synchronized (this) {
                this.mErrorMap.remove(i2);
                this.mEndMap.remove(i2);
                this.mSeekMap.remove(i2);
                this.mPreparedMap.remove(i2);
                this.mPausedMap.remove(i2);
            }
        }
    }

    public native void resume();

    public native void seek(int i2, int i3);

    public native void setAudioRecord(boolean z);

    public native int setDataSource(AssetManager assetManager, String str);

    public native int setDataSource(String str, int i2);

    public native void setLoop(int i2, boolean z);

    public void setOnAudioRecordListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.mAudioRecordListener = bVar;
        }
    }

    public void setOnCompletionListener(int i2, MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i2, onCompletionListener) == null) {
            this.mEndMap.put(i2, onCompletionListener);
        }
    }

    public void setOnErrorListener(int i2, MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, onErrorListener) == null) {
            this.mErrorMap.put(i2, onErrorListener);
        }
    }

    public void setOnPauseListener(int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, cVar) == null) {
            this.mPausedMap.put(i2, cVar);
        }
    }

    public void setOnPreparedListener(int i2, MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, onPreparedListener) == null) {
            this.mPreparedMap.put(i2, onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(int i2, MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, onSeekCompleteListener) == null) {
            this.mSeekMap.put(i2, onSeekCompleteListener);
        }
    }

    public native void setVolume(int i2, float f2);

    public native void stop(int i2);

    public native void stopAll();
}
