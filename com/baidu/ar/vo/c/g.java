package com.baidu.ar.vo.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public com.baidu.ar.vo.a.b zb;
    public com.baidu.ar.vo.b.a zc;
    public l zd;
    public com.baidu.ar.vo.a ze;
    public boolean zf;
    public int zg;
    public volatile Runnable zh;

    public g(l lVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, bVar, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zf = true;
        this.zg = 0;
        this.zd = lVar;
        this.zb = bVar;
        this.zc = aVar;
        this.ze = aVar2;
    }

    private boolean hp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.zg == 0) {
                this.zg = this.zd.isDriverdByARPVersion() ? 1 : -1;
            }
            return this.zg == 1;
        }
        return invokeV.booleanValue;
    }

    private void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", 4101);
            hashMap.put("guideDirection", Integer.valueOf(i2));
            hashMap.put("switchGuide", Integer.valueOf(i));
            this.ze.d(hashMap);
        }
    }

    private float[] s(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, fArr)) == null) {
            if (fArr == null || fArr.length != 16) {
                return null;
            }
            Matrixf4x4 matrixf4x4 = new Matrixf4x4();
            Matrixf4x4 matrixf4x42 = new Matrixf4x4();
            Matrix.invertM(matrixf4x4.getMatrix(), 0, fArr, 0);
            matrixf4x42.setMatrixValues(matrixf4x4.getMatrix());
            Quaternion quaternion = new Quaternion();
            quaternion.setAxisAngle(new Vector3f(1.0f, 0.0f, 0.0f), -90.0f);
            Matrix.multiplyMM(matrixf4x4.getMatrix(), quaternion.getMatrix4x4().getMatrix(), matrixf4x42.getMatrix());
            Matrixf4x4 matrixf4x43 = new Matrixf4x4();
            Matrix.invertM(matrixf4x43.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
            return matrixf4x43.getMatrix();
        }
        return (float[]) invokeL.objValue;
    }

    @Override // com.baidu.ar.vo.c.d
    public String a(com.baidu.ar.vo.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? (bVar == null || TextUtils.isEmpty(bVar.getId())) ? "slam_model_1" : bVar.getId() : (String) invokeL.objValue;
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(b bVar) {
        float f;
        float f2;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.za) {
            int[] b = b(bVar.x, bVar.y);
            f = b[0];
            f2 = b[1];
        } else {
            f = bVar.x;
            f2 = bVar.y;
        }
        String a = a(this.zb);
        int i = bVar.type;
        if (i == 3) {
            this.zc.hi();
            a(a, (int) f, (int) f2, null, (int) bVar.yZ);
            runnable = new Runnable(this) { // from class: com.baidu.ar.vo.c.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g zi;

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
                    this.zi = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.zi.zd == null) {
                        return;
                    }
                    this.zi.zd.sceneRotateToCamera();
                }
            };
        } else if (i != 2) {
            return;
        } else {
            this.zc.hi();
            a(a, (int) f, (int) f2, null, (int) bVar.yZ);
            runnable = new Runnable(this) { // from class: com.baidu.ar.vo.c.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g zi;

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
                    this.zi = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.zi.zd == null) {
                        return;
                    }
                    this.zi.zd.sceneWorldPositionToOrigin();
                }
            };
        }
        this.zh = runnable;
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(String str, int i, int i2, float[] fArr, float f) {
        com.baidu.ar.vo.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), fArr, Float.valueOf(f)}) == null) || (aVar = this.zc) == null) {
            return;
        }
        aVar.insertModel(str, i, i2, fArr, f);
    }

    @Override // com.baidu.ar.vo.c.d
    public int[] b(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            int[] iArr = new int[2];
            if (this.mPreviewWidth != 0) {
                iArr[1] = this.mPreviewHeight - ((int) (f * 720.0f));
                iArr[0] = (int) (f2 * 1280.0f);
            } else {
                iArr[1] = 640;
                iArr[0] = 360;
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    @Override // com.baidu.ar.vo.c.d
    public void hl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k(1, 0);
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void hm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k(1, 1);
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void hn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k(0, 1);
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void ho() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.zd.setOffScreenGuideWork(true);
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void r(float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fArr) == null) || this.zd == null || fArr == null || fArr.length != 16) {
            return;
        }
        if (this.zh != null) {
            this.zh.run();
            this.zh = null;
        }
        this.zd.a(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, fArr);
        if (this.zf) {
            this.zf = false;
            this.ze.b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, null);
        }
        if (hp()) {
            fArr = s(fArr);
        }
        m mVar = new m();
        mVar.r("ability_vo");
        mVar.setMatrix(fArr);
        this.zd.a(mVar);
    }

    @Override // com.baidu.ar.vo.c.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.zc = null;
            this.zh = null;
            this.zd = null;
            this.ze = null;
        }
    }

    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
        }
    }
}
