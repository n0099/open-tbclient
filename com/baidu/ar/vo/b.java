package com.baidu.ar.vo;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.vo.b.g;
import com.baidu.ar.vo.c.c;
import com.baidu.ar.vo.c.d;
import com.baidu.ar.vo.c.e;
import com.baidu.ar.vo.c.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean yA;
    public volatile boolean yB;
    public d yw;
    public c yx;
    public com.baidu.ar.vo.b.d yy;
    public volatile boolean yz;

    public b(d dVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.b.d dVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, bVar, aVar, dVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.yz = false;
        this.yA = true;
        this.yB = false;
        this.yw = dVar;
        this.yy = dVar2;
        if (bVar != null) {
            this.yA = bVar.hh();
        }
        this.yx = a(bVar, aVar);
    }

    private c a(com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, bVar, aVar)) == null) {
            if (bVar == null) {
                d dVar = this.yw;
                com.baidu.ar.vo.b.d dVar2 = this.yy;
                return new com.baidu.ar.vo.c.a(dVar, dVar2.yQ, dVar2.yR);
            } else if (bVar.hd() == 1) {
                d dVar3 = this.yw;
                com.baidu.ar.vo.b.d dVar4 = this.yy;
                f fVar = new f(dVar3, bVar, dVar4.yQ, dVar4.yR);
                fVar.a(aVar);
                return fVar;
            } else if (bVar.hd() == 0) {
                d dVar5 = this.yw;
                com.baidu.ar.vo.b.d dVar6 = this.yy;
                return new e(dVar5, bVar, dVar6.yQ, dVar6.yR);
            } else {
                return null;
            }
        }
        return (c) invokeLL.objValue;
    }

    private float[] a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, gVar)) == null) {
            ArrayList<TrackModel> hk = gVar.hk();
            return (hk == null || hk.isEmpty()) ? new float[0] : hk.get(0).getPose();
        }
        return (float[]) invokeL.objValue;
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.yB = z;
        }
    }

    public void a(com.baidu.ar.vo.b.f fVar, float[] fArr) {
        float[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, fArr) == null) && this.yA && !this.yB) {
            g hj = fVar.hj();
            if (this.yz) {
                if (hj == null || (a = a(hj)) == null || a.length <= 0) {
                    return;
                }
                this.yw.r(a);
                return;
            }
            c cVar = this.yx;
            if (cVar != null) {
                this.yz = cVar.q(fArr);
                if (this.yz) {
                    this.yw.ho();
                    StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
                }
            }
        }
    }

    public void a(com.baidu.ar.vo.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.yw.a(bVar);
        }
    }

    public void c(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
            bVar.x = f2;
            bVar.y = f3;
            bVar.yZ = f4;
            bVar.type = 2;
            a(bVar);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d dVar = this.yw;
            if (dVar != null) {
                dVar.release();
                this.yw = null;
            }
            this.yx = null;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.yA = true;
        }
    }
}
