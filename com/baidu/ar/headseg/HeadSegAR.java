package com.baidu.ar.headseg;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HeadSegAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HeadSegAR";
    public transient /* synthetic */ FieldHolder $fh;
    public String bD;
    public AlgoHandleController cb;
    public e lE;
    public HeadSegDetector qy;
    public e qz;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1061492735, "Lcom/baidu/ar/headseg/HeadSegAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1061492735, "Lcom/baidu/ar/headseg/HeadSegAR;");
        }
    }

    public HeadSegAR() {
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
        this.bD = "ability_head_segmentation";
        this.cb = null;
        this.qz = new e(this) { // from class: com.baidu.ar.headseg.HeadSegAR.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeadSegAR qA;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.qA = this;
            }

            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    long de = bVar.de();
                    l r = this.qA.r();
                    if (r == null || de <= 0 || this.qA.cb == null) {
                        return;
                    }
                    this.qA.cb.sendHandleToRenderer(de, r, "ability_head_segmentation");
                    this.qA.a(de);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
                l r;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) || (r = this.qA.r()) == null || this.qA.qy == null || lVar == null) {
                    return;
                }
                r.b(lVar.dk(), this.qA.qy.dj());
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                }
            }
        };
        this.lE = new e(this) { // from class: com.baidu.ar.headseg.HeadSegAR.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeadSegAR qA;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.qA = this;
            }

            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    long de = bVar.de();
                    if (this.qA.cb == null) {
                        ARMdlInterfaceJNI.updateLastFaceInfo(0L);
                    } else if (this.qA.cb.getHandleType(de) == 10) {
                        ARMdlInterfaceJNI.updateLastFaceInfo(de);
                    }
                    AlgoHandleAdapter.destroyHandle(de);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                }
            }
        };
    }

    private void b(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2) == null) || (algoHandleController = this.cb) == null || j2 <= 0) {
            return;
        }
        long handleType = algoHandleController.getHandleType(j2);
        HeadSegDetector headSegDetector = this.qy;
        if (headSegDetector == null || handleType != 22) {
            return;
        }
        headSegDetector.b(j2);
    }

    @Override // com.baidu.ar.c
    public void a(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.a(j2);
            if (j2 <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j2) != 22) {
                return;
            }
            b(j2);
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b(false);
            HeadSegDetector headSegDetector = this.qy;
            if (headSegDetector != null) {
                headSegDetector.a((AlgoHandleController) null);
                this.qy.av();
                a(this.qy);
            }
            AlgoHandleController algoHandleController = this.cb;
            if (algoHandleController != null) {
                algoHandleController.release();
                this.cb = null;
            }
            l r = r();
            if (r != null) {
                r.q(22);
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
            HeadSegDetector headSegDetector = new HeadSegDetector();
            this.qy = headSegDetector;
            headSegDetector.a(this.cb);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("ability_name", this.bD);
            a("FaceDetector", this.lE, hashMap2);
            b(true);
            a(this.qy, this.qz);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            this.qy.b((Bundle) null);
        }
    }
}
