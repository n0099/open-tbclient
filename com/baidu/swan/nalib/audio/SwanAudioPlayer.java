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
import com.baidu.tieba.aa4;
import com.baidu.tieba.ba4;
import com.baidu.tieba.z94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
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
    public aa4 mAudioRecordListener;
    public SparseArray<MediaPlayer.OnCompletionListener> mEndMap;
    public SparseArray<MediaPlayer.OnErrorListener> mErrorMap;
    public a mEventHandler;
    public SparseArray<ba4> mPausedMap;
    public SparseArray<MediaPlayer.OnPreparedListener> mPreparedMap;
    public SparseArray<MediaPlayer.OnSeekCompleteListener> mSeekMap;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAudioPlayer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAudioPlayer swanAudioPlayer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAudioPlayer, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAudioPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == -1) {
                    MediaPlayer.OnErrorListener onErrorListener = (MediaPlayer.OnErrorListener) this.a.mErrorMap.get(message.arg1);
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, message.arg1, message.arg2);
                    }
                } else if (i == 1) {
                    MediaPlayer.OnPreparedListener onPreparedListener = (MediaPlayer.OnPreparedListener) this.a.mPreparedMap.get(message.arg1);
                    if (onPreparedListener != null) {
                        onPreparedListener.onPrepared(null);
                    }
                } else if (i == 3) {
                    MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = (MediaPlayer.OnSeekCompleteListener) this.a.mSeekMap.get(message.arg1);
                    if (onSeekCompleteListener != null) {
                        onSeekCompleteListener.onSeekComplete(null);
                    }
                } else if (i == 4) {
                    MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) this.a.mEndMap.get(message.arg1);
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(null);
                    }
                } else if (i == 5) {
                    ba4 ba4Var = (ba4) this.a.mPausedMap.get(message.arg1);
                    if (ba4Var != null) {
                        ba4Var.onPause();
                    }
                } else if (i == 100) {
                    this.a.postRunnable(Long.parseLong(message.obj.toString()));
                } else if (i != 101) {
                } else {
                    z94 z94Var = (z94) message.obj;
                    if (this.a.mAudioRecordListener != null) {
                        this.a.mAudioRecordListener.a(z94Var);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private native void destroy(int i);

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

    public static native void init(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void postRunnable(long j);

    public static native void release();

    public static final void settingNativeAudioParameters(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
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

    public native int getDuration(int i);

    public native int getPosition(int i);

    public native int getState(int i);

    public native boolean isAudioPlayer();

    public native void pause(int i);

    public native void pauseAll();

    public native void play(int i, float f, boolean z);

    public void postAudioData(byte[] bArr, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, bArr, j) == null) || bArr == null) {
            return;
        }
        z94 z94Var = new z94();
        z94Var.a = bArr;
        z94Var.b = j;
        z94Var.c = System.nanoTime();
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(101, z94Var));
    }

    public void postEventFromNative(int i, int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i, i2, i3, obj));
        }
    }

    public void postRunnableFromNative(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(100, 0, 0, Long.valueOf(j)));
        }
    }

    public native void prepare(int i);

    public synchronized void release(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            synchronized (this) {
                this.mErrorMap.remove(i);
                this.mEndMap.remove(i);
                this.mSeekMap.remove(i);
                this.mPreparedMap.remove(i);
                this.mPausedMap.remove(i);
            }
        }
    }

    public native void resume();

    public native void seek(int i, int i2);

    public native void setAudioRecord(boolean z);

    public native int setDataSource(AssetManager assetManager, String str);

    public native int setDataSource(String str, int i);

    public native void setLoop(int i, boolean z);

    public void setOnAudioRecordListener(aa4 aa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aa4Var) == null) {
            this.mAudioRecordListener = aa4Var;
        }
    }

    public void setOnCompletionListener(int i, MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, onCompletionListener) == null) {
            this.mEndMap.put(i, onCompletionListener);
        }
    }

    public void setOnErrorListener(int i, MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i, onErrorListener) == null) {
            this.mErrorMap.put(i, onErrorListener);
        }
    }

    public void setOnPauseListener(int i, ba4 ba4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i, ba4Var) == null) {
            this.mPausedMap.put(i, ba4Var);
        }
    }

    public void setOnPreparedListener(int i, MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i, onPreparedListener) == null) {
            this.mPreparedMap.put(i, onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(int i, MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i, onSeekCompleteListener) == null) {
            this.mSeekMap.put(i, onSeekCompleteListener);
        }
    }

    public native void setVolume(int i, float f);

    public native void stop(int i);

    public native void stopAll();
}
