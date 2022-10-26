package com.baidu.ar.face.detector;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.face.detector.FaceDetector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends com.baidu.ar.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public i oA;
    public ByteBuffer oe;
    public boolean oi;
    public String oj;
    public int orientation;
    public FaceDetector.a oy;
    public boolean oz;
    public long timestamp;
    public int width;

    public h(ByteBuffer byteBuffer, int i, int i2, long j, boolean z, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.oj = "face_detect";
        this.oe = byteBuffer;
        this.width = i;
        this.height = i2;
        this.timestamp = j;
        this.oi = z;
        this.orientation = i3;
        this.oz = z2;
        setPriority(10);
    }

    private e dU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            e eVar = new e(this.oe);
            eVar.a(this.oA);
            eVar.a(this.width, this.height, this.oi, this.orientation, this.oz, this.timestamp);
            eVar.dH();
            if (eVar.mf <= 0) {
                String tag = getTag();
                com.baidu.ar.h.b.b(tag, "create handle illegal:" + eVar.mf);
                return null;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public void a(FaceDetector.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.oy = aVar;
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
            this.oA = iVar;
        }
    }

    public void aa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.oj = str;
        }
    }

    public void b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            if (fVar == null) {
                this.oy.f(null);
            }
            this.oy.f(com.baidu.ar.face.c.a(fVar.ob, fVar.og, fVar.mf, fVar.oh, fVar.oe, this.timestamp, this.oi));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dT */
    public f ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.oA.a(this.oi, this.orientation)) {
                return null;
            }
            com.baidu.ar.h.b.c(getTag(), "detect_frame track task executed");
            e dU = dU();
            if (dU == null) {
                com.baidu.ar.h.b.b(getTag(), "create faceHandle failed");
                b(null);
                return null;
            }
            f fVar = new f(this.oe);
            fVar.a(this.oA);
            fVar.a(dU.ob);
            fVar.g(dU.cY());
            fVar.p(dU.dN());
            fVar.setFrontCamera(this.oi);
            fVar.setTimestamp(this.timestamp);
            fVar.oj = this.oj;
            fVar.dJ();
            if (this.oA.dX().dO()) {
                com.baidu.ar.h.b.l("hjm", "check_skip detect");
                fVar.dH();
                if (this.oA.dX().a(fVar)) {
                    b(fVar);
                    return null;
                }
            } else {
                com.baidu.ar.h.b.l("hjm", "check_skip skip");
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.oj : (String) invokeV.objValue;
    }
}
