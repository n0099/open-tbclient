package com.baidu.ar.child;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CropAlgo lL;
    public HandlerThread lM;
    public Handler lN;
    public InterfaceC1715a lO;
    public boolean lP;
    public boolean lQ;
    public d lR;
    public int mInputHeight;
    public int mInputWidth;

    /* renamed from: com.baidu.ar.child.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1715a {
        void a(long j, byte[] bArr, int i);
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c lS;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, c cVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, cVar};
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
            this.lS = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (cVar = this.lS) == null) {
                return;
            }
            cVar.handleMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void handleMessage(Message message);
    }

    /* loaded from: classes3.dex */
    public class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a lT;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lT = aVar;
        }

        @Override // com.baidu.ar.child.a.c
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1002) {
                    if (i != 1003) {
                        return;
                    }
                    this.lT.clear();
                    if (this.lT.lN != null) {
                        this.lT.lN.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
                com.baidu.ar.child.b bVar = (com.baidu.ar.child.b) message.obj;
                if (bVar != null) {
                    com.baidu.ar.child.a.a cR = bVar.cR();
                    long cY = bVar.cT().cY();
                    com.baidu.ar.child.c cVar = new com.baidu.ar.child.c();
                    cVar.w(cR.getDegree());
                    cVar.f(cR.cW());
                    cVar.c(bVar.cT().cZ());
                    cVar.d(bVar.cT().cV());
                    cVar.c(bVar.cS());
                    cVar.setHandle(cY);
                    cVar.u(bVar.cR().cX());
                    cVar.setWidth(this.lT.mInputWidth);
                    cVar.setHeight(this.lT.mInputHeight);
                    byte[] a = this.lT.a(cVar);
                    this.lT.lQ = true;
                    if (this.lT.lO != null) {
                        this.lT.lO.a(cY, a, cR.getDegree());
                    }
                }
            }
        }
    }

    public a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lP = true;
        this.mInputHeight = i2;
        this.mInputWidth = i;
        HandlerThread handlerThread = new HandlerThread("ChildAlgoController");
        this.lM = handlerThread;
        handlerThread.start();
        if (this.lR == null) {
            this.lR = new d(this);
        }
        this.lN = new b(this.lM.getLooper(), this.lR);
        if (this.lL == null) {
            this.lL = new CropAlgo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(com.baidu.ar.child.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar)) == null) {
            if (cVar.getHandle() <= 0 || b(cVar.cU()) || b(cVar.cV())) {
                return null;
            }
            return this.lL.nativeCorpFace(cVar);
        }
        return (byte[]) invokeL.objValue;
    }

    private boolean b(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, fArr)) == null) ? fArr == null || fArr.length <= 0 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        CropAlgo cropAlgo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            HandlerThread handlerThread = this.lM;
            if (handlerThread != null) {
                handlerThread.getLooper().quit();
                this.lM = null;
            }
            if (this.lQ && (cropAlgo = this.lL) != null) {
                cropAlgo.nativeClear();
                this.lL = null;
            }
            this.lQ = false;
            this.lO = null;
            if (this.lN != null) {
                this.lN = null;
            }
        }
    }

    public long a(long j, byte[] bArr) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, bArr)) == null) {
            if (j <= 0) {
                return 0L;
            }
            return this.lL.nativeWriteFaceDataToHandel(j, bArr);
        }
        return invokeJL.longValue;
    }

    public long a(long j, byte[] bArr, int i, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            if (j <= 0) {
                return 0L;
            }
            return this.lL.nativeWriteCameraDataToHandel(j, bArr, i, i2, f2);
        }
        return invokeCommon.longValue;
    }

    public void a(InterfaceC1715a interfaceC1715a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1715a) == null) {
            this.lO = interfaceC1715a;
        }
    }

    public void a(com.baidu.ar.child.b bVar) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (handler = this.lN) != null && this.lP) {
            handler.removeMessages(1002);
            Handler handler2 = this.lN;
            handler2.sendMessage(handler2.obtainMessage(1002, bVar));
        }
    }

    public void cQ() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.lN) == null) {
            return;
        }
        handler.removeMessages(1003);
        Handler handler2 = this.lN;
        handler2.sendMessage(handler2.obtainMessage(1003));
    }

    public float[] i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            if (j <= 0) {
                return null;
            }
            return this.lL.nativeTrackingPoints(j);
        }
        return (float[]) invokeJ.objValue;
    }

    public float[] j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (j <= 0) {
                return null;
            }
            return this.lL.nativeGetFaceBoxList(j);
        }
        return (float[]) invokeJ.objValue;
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || j <= 0) {
            return;
        }
        this.lL.nativeWriteTypeToHandle(j);
    }
}
