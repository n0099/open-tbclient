package com.baidu.ar.hand;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class HandAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HandAR";
    public transient /* synthetic */ FieldHolder $fh;
    public AlgoHandleController cb;
    public e mv;
    public HandDetector qu;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1298110997, "Lcom/baidu/ar/hand/HandAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1298110997, "Lcom/baidu/ar/hand/HandAR;");
        }
    }

    public HandAR() {
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
        this.cb = null;
    }

    private void b(long j) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) || (algoHandleController = this.cb) == null || j <= 0) {
            return;
        }
        long handleType = algoHandleController.getHandleType(j);
        HandDetector handDetector = this.qu;
        if (handDetector == null || handleType != 19) {
            return;
        }
        handDetector.b(j);
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            super.a(j);
            if (j <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j) != 19) {
                return;
            }
            b(j);
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HandDetector handDetector = this.qu;
            if (handDetector != null) {
                handDetector.a((AlgoHandleController) null);
                this.qu.av();
                a(this.qu);
            }
            AlgoHandleController algoHandleController = this.cb;
            if (algoHandleController != null) {
                algoHandleController.release();
                this.cb = null;
            }
            l r = r();
            if (r != null) {
                r.q(19);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            super.setup(hashMap);
            if (this.cb == null) {
                this.cb = new AlgoHandleController();
            }
            HandDetector handDetector = new HandDetector();
            this.qu = handDetector;
            handDetector.a(this.cb);
            e eVar = new e(this) { // from class: com.baidu.ar.hand.HandAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HandAR qv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.qv = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        long de = bVar.de();
                        l r = this.qv.r();
                        if (r == null || de <= 0) {
                            return;
                        }
                        r.a(de, "ability_hand_skeleton");
                        this.qv.a(de);
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        String str = HandAR.TAG;
                        com.baidu.ar.h.b.c(str, "onSetup result = " + lVar.isSuccess());
                        l r = this.qv.r();
                        if (r == null || this.qv.qu == null) {
                            return;
                        }
                        r.b(lVar.dk(), this.qv.qu.dj());
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                        String str = HandAR.TAG;
                        com.baidu.ar.h.b.c(str, "onRelease result = " + lVar.isSuccess());
                    }
                }
            };
            this.mv = eVar;
            a(this.qu, eVar);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            this.qu.b((Bundle) null);
        }
    }
}
