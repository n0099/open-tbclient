package com.baidu.ar.child;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.child.a;
import com.baidu.ar.child.a.d;
import com.baidu.ar.child.a.e;
import com.baidu.ar.child.b.b;
import com.baidu.ar.d.k;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class ChildAR extends com.baidu.ar.c implements LuaMsgListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bD;
    public AlgoHandleController cb;
    public com.baidu.ar.child.a.b lA;
    public com.baidu.ar.child.b.b lB;
    public boolean lC;
    public e lD;
    public com.baidu.ar.d.e lE;
    public a lz;

    public ChildAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bD = null;
        this.cb = null;
        this.lE = new com.baidu.ar.d.e(this) { // from class: com.baidu.ar.child.ChildAR.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChildAR lF;

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
                this.lF = this;
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    if (this.lF.lz == null || this.lF.lC) {
                        if (this.lF.cb != null) {
                            this.lF.cb.destroyHandle(bVar.de());
                            return;
                        }
                        return;
                    }
                    if (this.lF.cb.getHandleType(bVar.de()) == 10) {
                        long createHandle = this.lF.cb.createHandle();
                        this.lF.lD = new e();
                        if (this.lF.lz != null) {
                            this.lF.lD.e(this.lF.lz.j(bVar.de()));
                            this.lF.lD.d(this.lF.lz.i(bVar.de()));
                            this.lF.lD.g(createHandle);
                        }
                    }
                    if (this.lF.cb != null && !this.lF.lC) {
                        this.lF.cb.destroyHandle(bVar.de());
                    }
                    this.lF.cP();
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                }
            }
        };
    }

    private void a(float f2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), dVar}) == null) {
            a(dVar, new com.baidu.ar.d.e(this, f2, dVar) { // from class: com.baidu.ar.child.ChildAR.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChildAR lF;
                public final /* synthetic */ float lI;
                public final /* synthetic */ d lJ;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f2), dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lF = this;
                    this.lI = f2;
                    this.lJ = dVar;
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        if (bVar != null && (bVar instanceof com.baidu.ar.child.a.c)) {
                            com.baidu.ar.child.a.c cVar = (com.baidu.ar.child.a.c) bVar;
                            if (cVar == null || cVar.cW() == null) {
                                return;
                            }
                            long createHandle = this.lF.cb.createHandle();
                            this.lF.lz.k(createHandle);
                            this.lF.lz.a(createHandle, cVar.cW(), this.lF.mInputHeight, this.lF.mInputWidth, this.lI);
                            com.baidu.ar.arrender.l r = this.lF.r();
                            if (r != null && createHandle > 0 && this.lF.cb != null) {
                                if (this.lF.lC) {
                                    return;
                                }
                                this.lF.cb.sendHandleToRenderer(createHandle, r, "ability_face_child");
                            }
                        }
                        this.lF.b(this.lJ);
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            });
        }
    }

    private void a(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(AdIconUtil.BAIDU_LOGO_ID, this, str, f2) == null) {
            d dVar = new d();
            dVar.v(str);
            cO();
            b(f2);
            a(f2, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, long j2) {
        a aVar;
        int i2;
        com.baidu.ar.arrender.l r;
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65543, this, bArr, j2) == null) || (aVar = this.lz) == null || this.lC || j2 <= 0) {
            return;
        }
        aVar.a(j2, bArr);
        if (TextUtils.isEmpty(this.bD) || (r = r()) == null || i2 <= 0 || (algoHandleController = this.cb) == null) {
            return;
        }
        algoHandleController.sendHandleToRenderer(j2, r, "ability_face_child");
    }

    private void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65544, this, f2) == null) {
            com.baidu.ar.child.a.b bVar = new com.baidu.ar.child.a.b();
            this.lA = bVar;
            a(bVar, new com.baidu.ar.d.e(this, f2) { // from class: com.baidu.ar.child.ChildAR.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChildAR lF;
                public final /* synthetic */ float lI;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lF = this;
                    this.lI = f2;
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) || this.lF.lC || this.lF.lz == null || this.lF.lD == null || !(bVar2 instanceof com.baidu.ar.child.a.a)) {
                        return;
                    }
                    this.lF.lz.k(this.lF.lD.cY());
                    b bVar3 = new b((com.baidu.ar.child.a.a) bVar2, this.lI);
                    bVar3.a(this.lF.lD);
                    this.lF.lz.a(bVar3);
                    ChildAR childAR = this.lF;
                    childAR.b(childAR.lA);
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, kVar) == null) || kVar == null) {
            return;
        }
        new Thread(new Runnable(this, kVar) { // from class: com.baidu.ar.child.ChildAR.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChildAR lF;
            public final /* synthetic */ k lK;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, kVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.lF = this;
                this.lK = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.lF.a(this.lK);
                }
            }
        }).start();
    }

    private void cO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            a("FaceDetector", this.lE, (HashMap<String, Object>) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP() {
        com.baidu.ar.d.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (eVar = this.lE) == null) {
            return;
        }
        a("FaceDetector", eVar);
    }

    private void i(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, hashMap) == null) && hashMap.containsKey("case_texture")) {
            String str = (String) hashMap.get("case_texture");
            if (hashMap.containsKey("excute_frame")) {
                float floatValue = ((Float) hashMap.get("excute_frame")).floatValue();
                if (hashMap.containsKey("index")) {
                    float floatValue2 = ((Float) hashMap.get("index")).floatValue();
                    if (floatValue != 1.0f || TextUtils.isEmpty(str)) {
                        return;
                    }
                    a(str, floatValue2);
                }
            }
        }
    }

    @Override // com.baidu.ar.c
    public void a(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.a(j2);
            if (j2 <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j2) != 20) {
                return;
            }
            this.cb.destroyHandle(j2);
        }
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.adjust(hashMap);
        }
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public List<String> getMsgKeyListened() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("event_name");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public void onLuaMessage(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) || this.lC || hashMap == null || hashMap.keySet().size() < 1) {
            return;
        }
        i(hashMap);
    }

    @Override // com.baidu.ar.c
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.pause();
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.release();
            this.lC = !this.lC;
            if (this.lA != null) {
                this.lA = null;
            }
            AlgoHandleController algoHandleController = this.cb;
            if (algoHandleController != null) {
                algoHandleController.release();
                this.cb = null;
            }
            a aVar = this.lz;
            if (aVar != null && !this.lC) {
                aVar.a((a.InterfaceC1632a) null);
                this.lz.cQ();
                this.lz = null;
            }
            com.baidu.ar.arrender.l r = r();
            if (r != null) {
                r.q(20);
            }
        }
    }

    @Override // com.baidu.ar.c
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.resume();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            if (this.cb == null) {
                this.cb = new AlgoHandleController();
            }
            this.bD = (String) hashMap.get("ability_name");
            this.lz = new a(this.mInputWidth, this.mInputHeight);
            this.lB = new com.baidu.ar.child.b.b();
            this.lz.a(new a.InterfaceC1632a(this) { // from class: com.baidu.ar.child.ChildAR.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChildAR lF;

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
                    this.lF = this;
                }

                @Override // com.baidu.ar.child.a.InterfaceC1632a
                public void a(long j2, byte[] bArr, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), bArr, Integer.valueOf(i2)}) == null) || bArr == null || bArr.length <= 0) {
                        return;
                    }
                    this.lF.lB.a(bArr, i2, new b.a(this, j2) { // from class: com.baidu.ar.child.ChildAR.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long lG;
                        public final /* synthetic */ AnonymousClass2 lH;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Long.valueOf(j2)};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.lH = this;
                            this.lG = j2;
                        }

                        @Override // com.baidu.ar.child.b.b.a
                        public void e(byte[] bArr2) {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, bArr2) == null) || bArr2 == null) {
                                return;
                            }
                            StatisticApi.onEvent(StatisticConstants.EVENT_FACE2CHILD_CASEUSE);
                            this.lH.lF.a(bArr2, this.lG);
                        }
                    });
                }
            });
            a((LuaMsgListener) this);
            com.baidu.ar.arrender.l r = r();
            if (r != null) {
                r.b(20, false);
            }
        }
    }
}
