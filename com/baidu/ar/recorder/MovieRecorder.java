package com.baidu.ar.recorder;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.record.MovieRecorderCallback;
import com.baidu.ar.record.b;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import com.baidu.ar.recorder.b.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class MovieRecorder implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_ON_START = 4001;
    public static final int ERROR_CODE_ON_STOP = 4002;
    public static final String TAG = "MovieRecorder";
    public static volatile int uf;
    public static volatile boolean up;
    public static volatile MovieRecorder uw;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public EncoderParams tW;
    public MovieRecorderCallback tX;
    public int ug;
    public boolean uh;
    public HandlerThread ui;
    public volatile boolean uj;
    public boolean uk;
    public a ul;
    public com.baidu.ar.recorder.a um;
    public d un;
    public e uo;
    public com.baidu.ar.recorder.a.a uq;
    public c ur;
    public volatile boolean us;
    public com.baidu.ar.recorder.a.b ut;
    public c uu;
    public volatile boolean uv;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MovieRecorder ux;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MovieRecorder movieRecorder, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {movieRecorder, looper};
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
            this.ux = movieRecorder;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 7000:
                        if (this.ux.tX != null) {
                            this.ux.tX.onRecorderInit((Surface) message.obj);
                            break;
                        }
                        break;
                    case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                        if (this.ux.tX != null) {
                            this.ux.tX.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.ux.uj = false;
                        break;
                    case 7002:
                        if (this.ux.tX != null) {
                            this.ux.tX.onRecorderProcess(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7003:
                        if (this.ux.tX != null) {
                            this.ux.tX.onRecorderComplete(((Boolean) message.obj).booleanValue(), this.ux.tW != null ? this.ux.tW.getOutputFile() : null);
                            break;
                        }
                        break;
                    case 7004:
                        if (this.ux.tX != null) {
                            this.ux.tX.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7005:
                        this.ux.fw();
                        break;
                    case 7006:
                        this.ux.uj = false;
                        this.ux.stopRecorder();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(29878574, "Lcom/baidu/ar/recorder/MovieRecorder;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(29878574, "Lcom/baidu/ar/recorder/MovieRecorder;");
        }
    }

    public MovieRecorder() {
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
        this.ug = 0;
        this.uh = false;
        this.uj = false;
        this.uk = false;
        this.us = false;
        this.uv = false;
    }

    public static void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            up = z;
        }
    }

    public static void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            uf = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = TAG;
                com.baidu.ar.h.b.k(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
                f(i, z);
                String str2 = TAG;
                com.baidu.ar.h.b.k(str2, "checkMovieRecordStartState sMovieRecordState = " + uf);
                if (fE()) {
                    this.ul.sendMessage(this.ul.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(fF())));
                }
            }
        }
    }

    private void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                uf = i | uf;
            }
            this.ug++;
        }
    }

    private boolean fA() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            com.baidu.ar.recorder.a.a aVar = this.uq;
            if (aVar == null || !aVar.isRunning()) {
                z = true;
            } else {
                com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
                this.uq.stopRecording();
                this.uq.fJ();
                z = false;
            }
            com.baidu.ar.recorder.a.b bVar = this.ut;
            if (bVar != null && bVar.isRunning()) {
                com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
                this.ut.stopRecording();
                this.ut.fJ();
                z = false;
            }
            EncoderParams encoderParams = this.tW;
            if (encoderParams == null || this.un.a(encoderParams.getOutputFile(), this.tW.getOutputFormat(), this.uo)) {
                return z;
            }
            com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return invokeV.booleanValue;
    }

    private void fB() {
        com.baidu.ar.recorder.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (aVar = this.uq) == null) {
            return;
        }
        aVar.a(this.tW, this.un, this.ur);
    }

    private void fC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.ut.a(this.tW, this.un, this.uu);
        }
    }

    private void fD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            String str = TAG;
            com.baidu.ar.h.b.k(str, "restartRecorder mRestartTried = " + this.uk);
            a aVar = this.ul;
            if (aVar != null) {
                this.uk = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(7005), 500L);
            }
        }
    }

    private boolean fE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            EncoderParams encoderParams = this.tW;
            if (encoderParams == null) {
                return false;
            }
            if (encoderParams.isAudioIncluded()) {
                if (this.ug == 3) {
                    return true;
                }
            } else if (this.ug == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private synchronized boolean fF() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            synchronized (this) {
                String str = TAG;
                com.baidu.ar.h.b.k(str, "isMovieRecordStarted sMovieRecordState = " + uf);
                int i = (uf ^ 1) ^ 2;
                if (this.tW != null) {
                    if (this.tW.isAudioIncluded()) {
                        i ^= 4;
                    }
                }
                z = i == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private boolean fG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) ? this.ug == 0 : invokeV.booleanValue;
    }

    private synchronized boolean fH() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            synchronized (this) {
                z = uf == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            fy();
            fz();
            if (fA()) {
                fB();
                fC();
            } else if (this.uk) {
                fx();
            } else {
                fD();
            }
        }
    }

    private void fx() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || (aVar = this.ul) == null) {
            return;
        }
        aVar.sendMessageDelayed(aVar.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.FALSE), 500L);
    }

    private void fy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.un = new d();
            }
            if (this.tW.isAudioIncluded()) {
                this.uq = new com.baidu.ar.recorder.a.a();
            } else {
                up = true;
            }
            this.ut = new com.baidu.ar.recorder.a.b();
            this.ug = 0;
            if (!this.uh && this.ui == null) {
                HandlerThread handlerThread = new HandlerThread(TAG);
                this.ui = handlerThread;
                handlerThread.start();
            }
            a aVar = this.ul;
            if (aVar == null) {
                this.ul = this.ui != null ? new a(this, this.ui.getLooper()) : new a(this, this.mContext.getMainLooper());
            } else {
                aVar.removeCallbacksAndMessages(null);
            }
            this.um = new com.baidu.ar.recorder.a(this.tW.getOutputTotalMs());
        }
    }

    private void fz() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            this.uu = new c(this) { // from class: com.baidu.ar.recorder.MovieRecorder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MovieRecorder ux;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ux = this;
                }

                @Override // com.baidu.ar.recorder.b.c
                public void L(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.ux.uv = z;
                        this.ux.e(2, z);
                    }
                }

                @Override // com.baidu.ar.recorder.b.c
                public void M(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    }
                }

                @Override // com.baidu.ar.recorder.b.c
                public void N(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (this.ux.ut != null) {
                            this.ux.ut.fJ();
                            this.ux.ut = null;
                        }
                        this.ux.uu = null;
                        this.ux.g(2, z);
                    }
                }

                @Override // com.baidu.ar.recorder.b.c
                public void a(boolean z, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeZL(1048579, this, z, obj) == null) && z) {
                        if (this.ux.ul != null) {
                            this.ux.ul.sendMessage(this.ux.ul.obtainMessage(7000, obj));
                        }
                        if (this.ux.ut != null) {
                            this.ux.ut.startRecording();
                        }
                    }
                }
            };
            this.ur = new c(this) { // from class: com.baidu.ar.recorder.MovieRecorder.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MovieRecorder ux;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ux = this;
                }

                @Override // com.baidu.ar.recorder.b.c
                public void L(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.ux.us = z;
                        this.ux.e(4, z);
                    }
                }

                @Override // com.baidu.ar.recorder.b.c
                public void M(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                        boolean unused = MovieRecorder.up = z;
                    }
                }

                @Override // com.baidu.ar.recorder.b.c
                public void N(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        this.ux.uq.fJ();
                        this.ux.uq = null;
                        this.ux.ur = null;
                        this.ux.g(4, z);
                    }
                }

                @Override // com.baidu.ar.recorder.b.c
                public void a(boolean z, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeZL(1048579, this, z, obj) == null) && z) {
                        this.ux.uq.startRecording();
                    }
                }
            };
            this.uo = new e(this) { // from class: com.baidu.ar.recorder.MovieRecorder.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MovieRecorder ux;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ux = this;
                }

                @Override // com.baidu.ar.recorder.b.e
                public void O(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.ux.e(1, z);
                    }
                }

                @Override // com.baidu.ar.recorder.b.e
                public void P(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.ux.un.fX();
                            this.ux.un = null;
                        }
                        this.ux.uo = null;
                        this.ux.g(1, z);
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = TAG;
                com.baidu.ar.h.b.k(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
                h(i, z);
                String str2 = TAG;
                com.baidu.ar.h.b.k(str2, "checkMovieRecordStopState sMovieRecordState = " + uf);
                if (fG() && this.ul != null) {
                    this.ul.sendMessage(this.ul.obtainMessage(7003, Boolean.valueOf(fH())));
                }
            }
        }
    }

    public static MovieRecorder getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            if (uw == null) {
                synchronized (MovieRecorder.class) {
                    if (uw == null) {
                        uw = new MovieRecorder();
                    }
                }
            }
            return uw;
        }
        return (MovieRecorder) invokeV.objValue;
    }

    private void h(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                uf = i ^ uf;
            }
            this.ug--;
        }
    }

    public static void releaseInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, null) == null) {
            uw = null;
        }
    }

    private void s(long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65577, this, j) == null) {
            if (!this.um.fI()) {
                this.um.t(j);
                return;
            }
            int u = this.um.u(j);
            if (u <= 0 || (aVar = this.ul) == null) {
                return;
            }
            aVar.sendMessage(aVar.obtainMessage(7002, Integer.valueOf(u)));
        }
    }

    @Override // com.baidu.ar.record.b
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        com.baidu.ar.recorder.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.us && (aVar = this.uq) != null && aVar.isRunning()) {
            this.uq.a(byteBuffer, i, j);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.um = null;
            this.mContext = null;
            this.tW = null;
            this.tX = null;
            P(0);
            releaseInstance();
            a aVar = this.ul;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
                this.ul = null;
            }
            HandlerThread handlerThread = this.ui;
            if (handlerThread != null) {
                handlerThread.quit();
                this.ui = null;
            }
        }
    }

    @Override // com.baidu.ar.record.b
    public void onVideoFrameAvailable(long j) {
        com.baidu.ar.recorder.a.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && (bVar = this.ut) != null && bVar.isRunning() && this.uv && up) {
            this.ut.v(j);
            s(j / 1000000);
        }
    }

    @Override // com.baidu.ar.record.b
    public void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, encoderParams, movieRecorderCallback) == null) {
            String str = TAG;
            com.baidu.ar.h.b.k(str, "startRecorder mStarting = " + this.uj);
            if (this.uj) {
                fx();
                return;
            }
            this.uj = true;
            this.mContext = context;
            this.tW = encoderParams;
            this.tX = movieRecorderCallback;
            fw();
        }
    }

    @Override // com.baidu.ar.record.b
    public void stopRecorder() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String str = TAG;
            com.baidu.ar.h.b.k(str, "stopRecorder mStarting = " + this.uj);
            if (this.uj) {
                if (!fF() && (aVar = this.ul) != null) {
                    aVar.sendMessage(aVar.obtainMessage(7004, 4002));
                }
                com.baidu.ar.h.b.c(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
                a aVar2 = this.ul;
                if (aVar2 != null) {
                    aVar2.sendMessageDelayed(aVar2.obtainMessage(7006), 500L);
                    return;
                }
                return;
            }
            this.us = false;
            this.uv = false;
            com.baidu.ar.recorder.a.a aVar3 = this.uq;
            if (aVar3 != null && aVar3.isRunning()) {
                this.uq.stopRecording();
            }
            com.baidu.ar.recorder.a.b bVar = this.ut;
            if (bVar != null && bVar.isRunning()) {
                this.ut.stopRecording();
            }
            J(false);
        }
    }
}
