package com.baidu.ar.vo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.c;
import com.baidu.ar.d.l;
import com.baidu.ar.h.r;
import com.baidu.ar.imu.f;
import com.baidu.ar.imu.g;
import com.baidu.ar.imu.i;
import com.baidu.ar.vo.b.d;
import com.baidu.ar.vo.b.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class VOAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VOAR";
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.lua.c rN;
    public g si;
    public com.baidu.ar.vo.a.b yk;
    public e yl;
    public com.baidu.ar.d.e ym;
    public com.baidu.ar.vo.b.c yn;
    public b yo;
    public f yp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1399232075, "Lcom/baidu/ar/vo/VOAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1399232075, "Lcom/baidu/ar/vo/VOAR;");
        }
    }

    public VOAR() {
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

    private com.baidu.ar.vo.c.g a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar)) == null) {
            com.baidu.ar.vo.c.g gVar = new com.baidu.ar.vo.c.g(r(), this.yk, this.yn, new a(this) { // from class: com.baidu.ar.vo.VOAR.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VOAR yr;

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
                    this.yr = this;
                }

                @Override // com.baidu.ar.vo.a
                public void b(int i2, HashMap<String, Object> hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        this.yr.b(i2, hashMap);
                    }
                }

                @Override // com.baidu.ar.vo.a
                public void d(HashMap<String, Object> hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                        this.yr.d(hashMap);
                    }
                }
            });
            gVar.setPreviewSize(dVar.yQ, dVar.yR);
            return gVar;
        }
        return (com.baidu.ar.vo.c.g) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2, int i3, HashMap<String, Object> hashMap) {
        b bVar;
        com.baidu.ar.vo.c.b s;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(65546, this, i2, i3, hashMap) == null) || (bVar = this.yo) == null) {
            return;
        }
        if (i2 == 401) {
            if (bVar == null || hashMap == null || !(hashMap.get("app_type") instanceof String)) {
                return;
            }
            this.yo.U("None".equals((String) hashMap.get("app_type")));
            return;
        }
        if (i2 != 1901) {
            if (i2 != 4100) {
                return;
            }
            s = s(hashMap);
            z = false;
        } else if (hashMap == null) {
            return;
        } else {
            int a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
            if (4100 != a2) {
                if (4200 == a2) {
                    this.yo.start();
                    return;
                }
                return;
            }
            s = s(hashMap);
            z = true;
        }
        s.za = z;
        this.yo.a(s);
    }

    private d gX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            d dVar = new d();
            dVar.yQ = 1280;
            dVar.yR = 720;
            dVar.yS = new d.a(this) { // from class: com.baidu.ar.vo.VOAR.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VOAR yr;

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
                    this.yr = this;
                }

                @Override // com.baidu.ar.vo.b.d.a
                public float getAngle() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.yr.hc() : invokeV2.floatValue;
                }

                @Override // com.baidu.ar.vo.b.d.a
                public float[] hb() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.yr.hb() : (float[]) invokeV2.objValue;
                }
            };
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    private void gY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            a(this.yl);
            com.baidu.ar.lua.c cVar = this.rN;
            if (cVar != null) {
                b(cVar);
                this.rN = null;
            }
            g gVar = this.si;
            if (gVar != null) {
                a(gVar);
                this.si = null;
            }
            this.yl = null;
            this.ym = null;
            b bVar = this.yo;
            if (bVar != null) {
                bVar.release();
                this.yo = null;
            }
            com.baidu.ar.vo.b.c cVar2 = this.yn;
            if (cVar2 != null) {
                cVar2.release();
                this.yn = null;
            }
        }
    }

    private com.baidu.ar.lua.c gZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? new com.baidu.ar.lua.c(this) { // from class: com.baidu.ar.vo.VOAR.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VOAR yr;

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
                this.yr = this;
            }

            @Override // com.baidu.ar.lua.c
            public void a(int i2, int i3, HashMap<String, Object> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, hashMap) == null) {
                    r.runOnUiThread(new Runnable(this, i2, i3, hashMap) { // from class: com.baidu.ar.vo.VOAR.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int ys;
                        public final /* synthetic */ int yt;
                        public final /* synthetic */ HashMap yu;
                        public final /* synthetic */ AnonymousClass5 yv;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), hashMap};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.yv = this;
                            this.ys = i2;
                            this.yt = i3;
                            this.yu = hashMap;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.yv.yr.c(this.ys, this.yt, this.yu);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(401);
                    arrayList.add(4100);
                    arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
                    return arrayList;
                }
                return (List) invokeV2.objValue;
            }
        } : (com.baidu.ar.lua.c) invokeV.objValue;
    }

    private void ha() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            i iVar = new i();
            iVar.b(com.baidu.ar.imu.b.rD);
            iVar.N(0);
            iVar.G(false);
            iVar.H(true);
            g gVar = new g(this) { // from class: com.baidu.ar.vo.VOAR.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VOAR yr;

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
                    this.yr = this;
                }

                @Override // com.baidu.ar.imu.g
                public void onImuUpdate(f fVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar) == null) {
                        this.yr.yp = fVar;
                    }
                }
            };
            this.si = gVar;
            a(iVar, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] hb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            f fVar = this.yp;
            if (fVar == null) {
                return null;
            }
            return fVar.getMatrix();
        }
        return (float[]) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float hc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            f fVar = this.yp;
            return (fVar == null ? null : Float.valueOf(fVar.getAngle())).floatValue();
        }
        return invokeV.floatValue;
    }

    private com.baidu.ar.vo.c.b s(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, hashMap)) == null) {
            com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
            bVar.x = ((Float) hashMap.get("x")).floatValue();
            bVar.y = ((Float) hashMap.get("y")).floatValue();
            bVar.type = ((Integer) hashMap.get("type")).intValue();
            bVar.yZ = ((Float) hashMap.get("distance")).floatValue();
            bVar.za = true;
            return bVar;
        }
        return (com.baidu.ar.vo.c.b) invokeL.objValue;
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ha();
            r().l(true);
            r().m(true);
            r().setFieldOfView(56.144978f);
            r().initWorldAxis();
            r().a(new ARPDataInteraction.b(this) { // from class: com.baidu.ar.vo.VOAR.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VOAR yr;

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
                    this.yr = this;
                }

                @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.b
                public void a(float f2, float f3, float f4) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) || this.yr.yo == null) {
                        return;
                    }
                    this.yr.yo.c(f2, f3, f4);
                }
            });
            a(this.yl, this.ym);
        }
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gY();
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            super.setup(hashMap);
            this.yk = com.baidu.ar.vo.a.a.aW(r().bx());
            d gX = gX();
            this.yn = new com.baidu.ar.vo.b.c(gX);
            this.yl = new e(this.yk, this.yn);
            this.ym = new com.baidu.ar.d.e(this) { // from class: com.baidu.ar.vo.VOAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int yq;
                public final /* synthetic */ VOAR yr;

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
                    this.yr = this;
                    this.yq = 0;
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) || this.yr.yo == null || bVar == null || !(bVar instanceof com.baidu.ar.vo.b.f)) {
                        return;
                    }
                    int i2 = this.yq;
                    if (i2 < 3) {
                        this.yq = i2 + 1;
                        return;
                    }
                    this.yr.yo.a((com.baidu.ar.vo.b.f) bVar, this.yr.hb());
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        this.yq = 0;
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            };
            this.yo = new b(a(gX), this.yk, this.yn, gX);
            com.baidu.ar.lua.c gZ = gZ();
            this.rN = gZ;
            a(gZ);
        }
    }
}
