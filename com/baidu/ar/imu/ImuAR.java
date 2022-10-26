package com.baidu.ar.imu;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ARType;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.m;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ImuAR extends com.baidu.ar.c implements g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ImuAR";
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.lua.c rN;
    public i rO;
    public Matrixf4x4 rP;
    public Matrixf4x4 rQ;
    public Matrixf4x4 rR;
    public Matrixf4x4 rS;
    public boolean rT;
    public float[] rU;
    public boolean rV;
    public int rW;
    public boolean rX;
    public boolean rY;
    public boolean rZ;
    public boolean sa;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-728444633, "Lcom/baidu/ar/imu/ImuAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-728444633, "Lcom/baidu/ar/imu/ImuAR;");
        }
    }

    public ImuAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rP = new Matrixf4x4();
        this.rQ = new Matrixf4x4();
        this.rR = new Matrixf4x4();
        this.rS = new Matrixf4x4();
        this.rT = true;
        this.rU = new float[16];
        this.rV = false;
        this.rW = 0;
        this.rX = false;
        this.rY = false;
        this.rZ = false;
        this.sa = false;
    }

    private Matrixf4x4 a(Matrixf4x4 matrixf4x4, Matrixf4x4 matrixf4x42, Vector3f vector3f) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, matrixf4x4, matrixf4x42, vector3f)) == null) {
            Matrixf4x4 matrixf4x43 = new Matrixf4x4();
            if (this.rW != 1) {
                Matrixf4x4 matrixf4x44 = new Matrixf4x4();
                matrixf4x44.setW0(vector3f.x());
                matrixf4x44.setW1(vector3f.y());
                matrixf4x44.setW2(vector3f.z());
                float[] fArr = new float[16];
                Matrix.multiplyMM(fArr, matrixf4x44.getMatrix(), matrixf4x4.getMatrix());
                float[] fArr2 = new float[16];
                Matrix.invertM(fArr2, 0, fArr, 0);
                matrixf4x43.setMatrixValues(fArr2);
            } else if (this.rT) {
                this.rT = false;
                this.rQ.setMatrixValues(matrixf4x4.getMatrix());
                this.rR.loadIndentity();
                Matrix.translateM(this.rR.getMatrix(), 0, vector3f.getX(), vector3f.getY(), vector3f.getZ());
                float[] fArr3 = new float[16];
                Matrix.multiplyMM(fArr3, matrixf4x4.getMatrix(), this.rR.getMatrix());
                float[] fArr4 = new float[16];
                Matrix.invertM(fArr4, 0, fArr3, 0);
                this.rR.setMatrixValues(fArr4);
                matrixf4x43.setMatrixValues(matrixf4x42.getMatrix());
            } else {
                Matrixf4x4 matrixf4x45 = new Matrixf4x4();
                float[] fArr5 = new float[16];
                Matrix.transposeM(fArr5, 0, this.rQ.getMatrix(), 0);
                float[] fArr6 = new float[16];
                Matrix.multiplyMM(fArr6, fArr5, matrixf4x4.getMatrix());
                matrixf4x45.setMatrixValues(fArr6);
                Matrix.transposeM(fArr6, 0, matrixf4x45.getMatrix(), 0);
                float[] fArr7 = new float[16];
                Matrix.multiplyMM(fArr7, fArr6, this.rR.getMatrix());
                matrixf4x43.setMatrixValues(fArr7);
            }
            return matrixf4x43;
        }
        return (Matrixf4x4) invokeLLL.objValue;
    }

    private Matrixf4x4 a(Vector3f vector3f) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, vector3f)) == null) {
            Matrixf4x4 matrixf4x4 = new Matrixf4x4();
            matrixf4x4.setMatrixValues(this.rP.getMatrix());
            matrixf4x4.transpose();
            if (this.rZ) {
                a(matrixf4x4, vector3f);
            }
            float[] fArr = new float[16];
            Matrix.multiplyMM(fArr, this.rS.getMatrix(), matrixf4x4.getMatrix());
            matrixf4x4.setMatrixValues(fArr);
            return matrixf4x4;
        }
        return (Matrixf4x4) invokeL.objValue;
    }

    private Vector3f a(Matrixf4x4 matrixf4x4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, matrixf4x4)) == null) {
            float[] matrix = matrixf4x4.getMatrix();
            Vector3f vector3f = new Vector3f(matrix[12], matrix[13], matrix[14]);
            Matrixf4x4 matrixf4x42 = new Matrixf4x4();
            matrix[14] = 0.0f;
            matrix[13] = 0.0f;
            matrix[12] = 0.0f;
            matrixf4x42.setMatrixValues(matrix);
            Matrixf4x4 matrixf4x43 = new Matrixf4x4();
            Matrix.invertM(matrixf4x43.getMatrix(), 0, matrixf4x42.getMatrix(), 0);
            Vector4f vector4f = new Vector4f();
            Matrix.multiplyMV3(vector4f.toArray(), matrixf4x43.getMatrix(), vector3f.toArray(), 1.0f);
            vector3f.setXYZ(vector4f.x(), vector4f.y(), vector4f.z());
            return vector3f;
        }
        return (Vector3f) invokeL.objValue;
    }

    private void a(Matrixf4x4 matrixf4x4, Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, matrixf4x4, vector3f) == null) {
            this.rZ = false;
            if (this.rW != 1) {
                float[] fArr = new float[16];
                Matrix.transposeM(fArr, 0, matrixf4x4.getMatrix(), 0);
                this.rS.setMatrixValues(fArr);
                return;
            }
            this.rQ.setMatrixValues(matrixf4x4.getMatrix());
            Matrixf4x4 matrixf4x42 = new Matrixf4x4();
            matrixf4x42.setW0(vector3f.x());
            matrixf4x42.setW1(vector3f.y());
            matrixf4x42.setW2(vector3f.z());
            float[] fArr2 = new float[16];
            Matrix.multiplyMM(fArr2, matrixf4x4.getMatrix(), matrixf4x42.getMatrix());
            float[] fArr3 = new float[16];
            Matrix.invertM(fArr3, 0, fArr2, 0);
            this.rR.setMatrixValues(fArr3);
        }
    }

    private void a(float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65543, this, fArr, i) == null) && fArr != null && fArr.length == 16) {
            System.arraycopy(fArr, 0, this.rU, 0, 16);
            this.rP.setMatrixValues(this.rU);
            this.rV = true;
            this.rW = i;
            System.arraycopy(fArr, 0, this.rU, 0, 16);
            this.rP.setMatrixValues(this.rU);
            l r = r();
            if (r != null) {
                r.a(ARPScriptEnvironment.KEY_DATA_PIP_IMU, this.rP);
            }
            this.rV = true;
            this.rW = i;
            eT();
        }
    }

    private void b(Matrixf4x4 matrixf4x4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, matrixf4x4) == null) {
            float[] fArr = new float[16];
            Matrix.invertM(fArr, 0, matrixf4x4.getMatrix(), 0);
            Matrixf4x4 matrixf4x42 = new Matrixf4x4();
            matrixf4x42.setMatrix(fArr);
            matrixf4x42.setW0(0.0f);
            matrixf4x42.setW1(0.0f);
            matrixf4x42.setW2(0.0f);
            matrixf4x42.setW3(1.0f);
            Vector3f vector3f = new Vector3f(-fArr[12], -fArr[13], -fArr[14]);
            Vector4f vector4f = new Vector4f(0.0f, 0.0f, 1.0f, 1.0f);
            matrixf4x42.multiplyVector4fByMatrix(vector4f);
            Vector3f vector3f2 = new Vector3f(vector4f.x(), vector4f.y(), vector4f.z());
            vector3f2.add(vector3f);
            Vector4f vector4f2 = new Vector4f(0.0f, -1.0f, 0.0f, 1.0f);
            matrixf4x42.multiplyVector4fByMatrix(vector4f2);
            Matrixf4x4 lookAtLH = Matrixf4x4.lookAtLH(vector3f, vector3f2, new Vector3f(vector4f2.x(), vector4f2.y(), vector4f2.z()));
            Matrixf4x4 matrixf4x43 = new Matrixf4x4();
            matrixf4x43.setX0(-1.0f);
            Matrix.multiplyMM(matrixf4x4.getMatrix(), matrixf4x43.getMatrix(), lookAtLH.getMatrix());
        }
    }

    private Matrixf4x4 c(Matrixf4x4 matrixf4x4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, matrixf4x4)) == null) {
            if (matrixf4x4 == null) {
                return null;
            }
            Matrixf4x4 matrixf4x42 = new Matrixf4x4();
            Matrixf4x4 matrixf4x43 = new Matrixf4x4();
            Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
            matrixf4x43.setMatrixValues(matrixf4x42.getMatrix());
            Quaternion quaternion = new Quaternion();
            quaternion.setAxisAngle(new Vector3f(1.0f, 0.0f, 0.0f), -90.0f);
            Matrix.multiplyMM(matrixf4x42.getMatrix(), quaternion.getMatrix4x4().getMatrix(), matrixf4x43.getMatrix());
            Matrixf4x4 matrixf4x44 = new Matrixf4x4();
            Matrix.invertM(matrixf4x44.getMatrix(), 0, matrixf4x42.getMatrix(), 0);
            return matrixf4x44;
        }
        return (Matrixf4x4) invokeL.objValue;
    }

    private void eS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.rN == null) {
                this.rN = new com.baidu.ar.lua.c(this) { // from class: com.baidu.ar.imu.ImuAR.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImuAR sb;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.sb = this;
                    }

                    @Override // com.baidu.ar.lua.c
                    public void a(int i, int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i, i2, hashMap) == null) {
                            if (i != 305) {
                                if (i == 306 && (hashMap.get("is_mirrored") instanceof Integer)) {
                                    int intValue = ((Integer) hashMap.get("is_mirrored")).intValue();
                                    this.sb.sa = intValue == 1;
                                    return;
                                }
                                return;
                            }
                            if (hashMap != null && hashMap.containsKey("with_interaction") && ((Integer) hashMap.get("with_interaction")).intValue() != 0) {
                                r0 = true;
                            }
                            this.sb.rZ = true;
                            if (r0 || this.sb.r() == null) {
                                return;
                            }
                            this.sb.r().by();
                        }
                    }

                    @Override // com.baidu.ar.lua.c
                    public List n() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Arrays.asList(306, 305) : (List) invokeV.objValue;
                    }
                };
            }
            a(this.rN);
        }
    }

    private void eT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            l r = r();
            if (this.rV && !this.rX) {
                this.rX = true;
                b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, (HashMap) null);
                if (r != null) {
                    this.rY = r.isDriverdByARPVersion();
                }
            }
            if (r != null) {
                Matrixf4x4 initialTransform = r.getInitialTransform();
                Vector3f a = a(initialTransform);
                Matrixf4x4 a2 = a(a(a), initialTransform, a);
                if (this.sa) {
                    b(a2);
                }
                i iVar = this.rO;
                if (iVar != null && iVar.eW() == b.rD && this.rY) {
                    a2 = c(a2);
                }
                m mVar = new m();
                mVar.r("ability_imu");
                mVar.setMatrix(a2.getMatrix());
                r.setOffScreenGuideWork(true);
                r.a(mVar);
            }
        }
    }

    @Override // com.baidu.ar.imu.g
    public void onImuUpdate(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        a(fVar.getMatrix(), fVar.eU());
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.baidu.ar.h.b.c(TAG, "release()");
            a((g) this);
            HashMap hashMap = new HashMap();
            hashMap.put("succeeded", 1);
            b(304, hashMap);
            b(this.rN);
            this.rO = null;
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            super.setup(hashMap);
            if (hashMap != null && hashMap.containsKey("type")) {
                String str = TAG;
                com.baidu.ar.h.b.c(str, "setup() luaParams = " + hashMap.toString());
                Object obj = hashMap.get("type");
                int i = 0;
                int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof Float ? (int) ((Float) obj).floatValue() : 0;
                if (hashMap.containsKey("init_pos")) {
                    Object obj2 = hashMap.get("init_pos");
                    if (obj2 instanceof Integer) {
                        i = ((Integer) obj2).intValue();
                    } else if (obj2 instanceof Float) {
                        i = (int) ((Float) obj2).floatValue();
                    }
                }
                i iVar = new i();
                this.rO = iVar;
                iVar.b(b.L(intValue));
                this.rO.N(i);
                a(this.rO, this);
                eS();
                l r = r();
                if (r != null) {
                    r.bw();
                    if (this.rO.eW() == b.rE) {
                        r.aJ();
                    }
                    r.a(this.rO.eW());
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("succeeded", 1);
                b(302, hashMap2);
            }
            if (ARConfig.getARType() == ARType.IMU.getTypeValue()) {
                StatisticApi.onEvent(StatisticConstants.IMU_SET_SUCCESS);
            }
        }
    }
}
