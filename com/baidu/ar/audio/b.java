package com.baidu.ar.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "b";
    public static volatile b iF;
    public transient /* synthetic */ FieldHolder $fh;
    public c iC;
    public HandlerThread iD;
    public Handler iE;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b iG;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
            this.iG = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.iG.a((AudioParams) message.obj);
                        return;
                    case 1002:
                        this.iG.ck();
                        return;
                    case 1003:
                        this.iG.cl();
                        return;
                    case 1004:
                        this.iG.cm();
                        return;
                    case 1005:
                        this.iG.cn();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1725836610, "Lcom/baidu/ar/audio/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1725836610, "Lcom/baidu/ar/audio/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AudioParams audioParams) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, audioParams) == null) || (cVar = this.iC) == null) {
            return;
        }
        cVar.b(audioParams);
    }

    public static b cf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (iF == null) {
                synchronized (b.class) {
                    if (iF == null) {
                        iF = new b();
                    }
                }
            }
            return iF;
        }
        return (b) invokeV.objValue;
    }

    private void cg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioHandlerThread");
            this.iD = handlerThread;
            handlerThread.start();
            this.iE = new a(this, this.iD.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (cVar = this.iC) == null) {
            return;
        }
        cVar.co();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (cVar = this.iC) == null) {
            return;
        }
        cVar.cp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            c cVar = this.iC;
            if (cVar != null) {
                cVar.cq();
            }
            this.iC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            releaseInstance();
            Handler handler = this.iE;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.iE = null;
            }
            HandlerThread handlerThread = this.iD;
            if (handlerThread != null) {
                handlerThread.quit();
                this.iD = null;
            }
        }
    }

    public static void releaseInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            iF = null;
        }
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, audioParams, aVar)) == null) {
            if (isRunning()) {
                com.baidu.ar.h.b.b(TAG, "setupAudio error! As last audio thread is alive!");
                return false;
            }
            if (this.iC == null) {
                this.iC = new c();
            }
            this.iC.a(aVar);
            cg();
            Handler handler = this.iE;
            handler.sendMessage(handler.obtainMessage(1001, audioParams));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void ch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cl();
        }
    }

    public void ci() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.iE) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.iE;
        handler2.sendMessage(handler2.obtainMessage(1004));
        Handler handler3 = this.iE;
        handler3.sendMessage(handler3.obtainMessage(1005));
    }

    public AudioParams cj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.iC;
            if (cVar != null) {
                return cVar.cj();
            }
            return null;
        }
        return (AudioParams) invokeV.objValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HandlerThread handlerThread = this.iD;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, volumeListener) == null) || volumeListener == null) {
            return;
        }
        if (this.iC == null) {
            this.iC = new c();
        }
        this.iC.setVolumeListener(volumeListener);
    }

    public void startAudio() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (handler = this.iE) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }
}
