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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread uB;
    public Handler uC;
    public com.baidu.ar.recorder.b.a uD;
    public volatile boolean ua;
    public d un;

    /* renamed from: com.baidu.ar.recorder.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1594a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer uE;
        public int uF;
        public long uG;
        public final /* synthetic */ a uH;

        public C1594a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uH = aVar;
            this.uE = byteBuffer;
            this.uF = i2;
            this.uG = j;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a uH;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
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
            this.uH = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.uH.a((EncoderParams) message.obj);
                        return;
                    case 1002:
                        this.uH.fK();
                        return;
                    case 1003:
                        C1594a c1594a = (C1594a) message.obj;
                        this.uH.b(c1594a.uE, c1594a.uF, c1594a.uG);
                        return;
                    case 1004:
                        this.uH.fL();
                        return;
                    case 1005:
                        this.uH.fM();
                        return;
                    case 1006:
                        this.uH.fN();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750702793, "Lcom/baidu/ar/recorder/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750702793, "Lcom/baidu/ar/recorder/a/a;");
        }
    }

    public a() {
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
        this.ua = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, encoderParams) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uD.a(encoderParams, this.un);
    }

    private void a(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, dVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
            this.uB = handlerThread;
            handlerThread.start();
            this.uC = new b(this, this.uB.getLooper());
            com.baidu.ar.recorder.b.a aVar = new com.baidu.ar.recorder.b.a();
            this.uD = aVar;
            this.un = dVar;
            if (Build.VERSION.SDK_INT >= 18) {
                aVar.a(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ByteBuffer byteBuffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uD.a(false, byteBuffer, i2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uD.fT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uD.a(true, (ByteBuffer) null, 0, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.uD.fS();
        this.uD.fR();
        this.uD = null;
        this.un = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            Handler handler = this.uC;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.uC = null;
            }
            HandlerThread handlerThread = this.uB;
            if (handlerThread != null) {
                handlerThread.quit();
                this.uB = null;
            }
        }
    }

    public void a(ByteBuffer byteBuffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || byteBuffer == null || i2 <= 0) {
            return;
        }
        C1594a c1594a = new C1594a(this, byteBuffer, i2, j);
        if (this.uC == null || !this.ua) {
            return;
        }
        Handler handler = this.uC;
        handler.sendMessage(handler.obtainMessage(1003, c1594a));
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encoderParams, dVar, cVar)) == null) {
            if (isRunning()) {
                com.baidu.ar.h.b.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
                return false;
            }
            a(dVar, cVar);
            Handler handler = this.uC;
            handler.sendMessage(handler.obtainMessage(1001, encoderParams));
            this.ua = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void fJ() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.uC) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.uC;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.uC;
        handler3.sendMessage(handler3.obtainMessage(1006));
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HandlerThread handlerThread = this.uB;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void startRecording() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.uC) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void stopRecording() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.uC != null && this.ua) {
            this.ua = false;
            Handler handler = this.uC;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
