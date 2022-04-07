package com.baidu.ar.recorder.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import com.baidu.ar.recorder.b.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread uI;
    public Handler uJ;
    public f uK;
    public volatile boolean ua;
    public d un;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b uL;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
            this.uL = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.uL.a((EncoderParams) message.obj);
                        return;
                    case 1002:
                        this.uL.fK();
                        return;
                    case 1003:
                        this.uL.w((message.arg1 << 32) | (message.arg2 & 4294967295L));
                        return;
                    case 1004:
                        this.uL.fO();
                        return;
                    case 1005:
                        this.uL.fP();
                        return;
                    case 1006:
                        this.uL.cn();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750702824, "Lcom/baidu/ar/recorder/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750702824, "Lcom/baidu/ar/recorder/a/b;");
        }
    }

    public b() {
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
        this.ua = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, encoderParams) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uK.a(encoderParams, this.un);
    }

    private void a(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, dVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
            this.uI = handlerThread;
            handlerThread.start();
            this.uJ = new a(this, this.uI.getLooper());
            if (Build.VERSION.SDK_INT >= 18) {
                f fVar = new f();
                this.uK = fVar;
                fVar.a(cVar);
                this.un = dVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Handler handler = this.uJ;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.uJ = null;
            }
            HandlerThread handlerThread = this.uI;
            if (handlerThread != null) {
                handlerThread.quit();
                this.uI = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uK.fT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uK.Q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uK.fS();
        this.uK.fR();
        this.uK = null;
        this.un = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65550, this, j) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uK.Q(false);
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, encoderParams, dVar, cVar)) == null) {
            if (isRunning()) {
                com.baidu.ar.h.b.b(TAG, "setupRecorder error! As last video recorder thread is alive!");
                return false;
            }
            a(dVar, cVar);
            Handler handler = this.uJ;
            handler.sendMessage(handler.obtainMessage(1001, encoderParams));
            this.ua = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void fJ() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.uJ) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.uJ;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.uJ;
        handler3.sendMessage(handler3.obtainMessage(1006));
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HandlerThread handlerThread = this.uI;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void startRecording() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (handler = this.uJ) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void stopRecording() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.uJ != null && this.ua) {
            this.ua = false;
            Handler handler = this.uJ;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            int i = (int) (j >> 32);
            int i2 = (int) j;
            if (this.uJ == null || !this.ua) {
                return;
            }
            Handler handler = this.uJ;
            handler.sendMessage(handler.obtainMessage(1003, i, i2));
        }
    }
}
