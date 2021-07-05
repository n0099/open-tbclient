package com.baidu.ar.imu;

import android.hardware.SensorManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class h implements Observer {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public static final float[] sf;
    public static final float[] sg;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] hp;
    public i rO;
    public float sd;
    public j sh;
    public g si;
    public float[] sj;
    public float sk;
    public float sl;
    public boolean sm;
    public boolean sn;
    public float[] so;
    public float[] sp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-531415007, "Lcom/baidu/ar/imu/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-531415007, "Lcom/baidu/ar/imu/h;");
                return;
            }
        }
        TAG = h.class.getSimpleName();
        sf = new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        sg = new float[]{0.0f, 0.0f, -1.0f, 0.0f};
    }

    public h() {
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
        this.sj = new float[16];
        this.sk = -1.0f;
        this.sl = 10000.0f;
        float[] fArr = new float[16];
        this.hp = fArr;
        this.sm = true;
        this.sn = false;
        this.so = new float[4];
        this.sp = new float[16];
        Matrix.setIdentityM(fArr, 0);
    }

    private j a(b bVar, SensorManager sensorManager) {
        InterceptResult invokeLL;
        j kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, bVar, sensorManager)) == null) {
            if (bVar != b.rE) {
                kVar = this.rO.fb() ? new k(sensorManager) : new d(sensorManager);
            } else if (this.rO.eY()) {
                kVar = new e(sensorManager);
                if (!this.sm) {
                    kVar.sD = true;
                    kVar.sE.matrix = this.hp;
                }
                this.sm = false;
            } else {
                kVar = new a(sensorManager);
            }
            kVar.addObserver(this);
            return kVar;
        }
        return (j) invokeLL.objValue;
    }

    private void eV() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (jVar = this.sh) == null) {
            return;
        }
        jVar.release();
        this.sh = null;
    }

    private void h(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, fArr) == null) {
            Matrix.invertM(this.sj, 0, fArr, 0);
            Matrix.multiplyMM(this.sp, 0, sf, 0, this.sj, 0);
            float j = j(this.sp);
            this.sk = j;
            if (j > 0.0f) {
                float pow = (float) (Math.pow(1.13d, j) + 600.0d);
                this.sl = pow;
                if (pow > 15000.0f) {
                    this.sl = 15000.0f;
                }
            }
            Matrix.multiplyMV(this.so, 0, this.sp, 0, new float[]{0.0f, 0.0f, -this.sl, 1.0f}, 0);
            float[] fArr2 = this.sp;
            float[] fArr3 = this.so;
            fArr2[12] = -fArr3[0];
            fArr2[13] = -fArr3[1];
            fArr2[14] = -fArr3[2];
            Matrix.invertM(this.sj, 0, fArr2, 0);
            float i2 = i(this.so);
            this.sd = i2;
            Matrix.rotateM(this.sj, 0, i2, 0.0f, 0.0f, 1.0f);
        }
    }

    private float i(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, fArr)) == null) {
            float f2 = -fArr[0];
            float f3 = -fArr[1];
            int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            if (i2 != 0 || f2 >= 0.0f) {
                if (i2 != 0 || f2 <= 0.0f) {
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0 || f3 >= 0.0f) {
                        if (i3 != 0 || i2 <= 0) {
                            float atan = (float) ((Math.atan(Math.abs(f3) / Math.abs(f2)) / 3.141592653589793d) * 180.0d);
                            if (i3 > 0 && f3 < 0.0f) {
                                atan = 180.0f - atan;
                            }
                            if (i3 > 0 && i2 > 0) {
                                atan += 180.0f;
                            }
                            return (f2 >= 0.0f || i2 <= 0) ? atan : 360.0f - atan;
                        }
                        return 270.0f;
                    }
                    return 90.0f;
                }
                return 180.0f;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    private float j(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, fArr)) == null) {
            Matrix.multiplyMV(this.so, 0, fArr, 0, sg, 0);
            float[] fArr2 = this.so;
            if (fArr2[2] > 0.0f) {
                return -1.0f;
            }
            return 90.0f - ((float) ((Math.atan(Math.abs(this.so[2]) / ((float) Math.sqrt((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1])))) / 3.141592653589793d) * 180.0d));
        }
        return invokeL.floatValue;
    }

    public boolean a(SensorManager sensorManager, i iVar, g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, sensorManager, iVar, gVar)) == null) {
            if (iVar == null) {
                return false;
            }
            this.rO = iVar;
            this.si = gVar;
            if (iVar.eW() == b.rE && !this.rO.eY()) {
                this.sm = true;
            }
            try {
                if (this.sh == null) {
                    this.sh = a(this.rO.eW(), sensorManager);
                }
                if (this.sh.fc()) {
                    this.sh.start();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                String str = TAG;
                com.baidu.ar.h.b.b(str, "IMUController start: " + th.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public void stop() {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.sh != null && (iVar = this.rO) != null && iVar.eW() == b.rE && !this.sn && this.rO.eY()) {
                this.hp = this.sh.sE.matrix;
                this.sn = true;
            }
            try {
                eV();
                this.si = null;
                this.rO = null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, observable, obj) == null) {
            try {
                if (this.rO != null && this.si != null) {
                    float[] fArr = this.sh.fd().matrix;
                    if (this.rO.fa() || this.rO.eZ()) {
                        h(fArr);
                    }
                    float[] fe = this.sh.fe();
                    f fVar = new f();
                    if (this.rO.eZ()) {
                        fVar.setMatrix(this.sj);
                    } else {
                        fVar.setMatrix(fArr);
                    }
                    fVar.e(this.sd);
                    fVar.M(this.rO.eX());
                    fVar.g(fe);
                    this.si.onImuUpdate(fVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
