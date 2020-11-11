package com.baidu.ar.imu;

import com.baidu.ar.ARType;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class ImuAR extends com.baidu.ar.c implements g {
    private static final String TAG = ImuAR.class.getSimpleName();
    private com.baidu.ar.lua.c rw;

    /* renamed from: rx  reason: collision with root package name */
    private i f1193rx;
    private Matrixf4x4 ry = new Matrixf4x4();
    private Matrixf4x4 rz = new Matrixf4x4();
    private Matrixf4x4 rA = new Matrixf4x4();
    private Matrixf4x4 rB = new Matrixf4x4();
    private boolean rC = true;
    private float[] rD = new float[16];
    private boolean rE = false;
    private int rF = 0;
    private boolean rG = false;
    private boolean rH = false;
    private boolean rI = false;
    private boolean rJ = false;

    private Matrixf4x4 a(Matrixf4x4 matrixf4x4, Matrixf4x4 matrixf4x42, Vector3f vector3f) {
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        if (this.rF != 1) {
            Matrixf4x4 matrixf4x44 = new Matrixf4x4();
            matrixf4x44.setW0(vector3f.x());
            matrixf4x44.setW1(vector3f.y());
            matrixf4x44.setW2(vector3f.z());
            float[] fArr = new float[16];
            Matrix.multiplyMM(fArr, matrixf4x44.getMatrix(), matrixf4x4.getMatrix());
            float[] fArr2 = new float[16];
            Matrix.invertM(fArr2, 0, fArr, 0);
            matrixf4x43.setMatrixValues(fArr2);
        } else if (this.rC) {
            this.rC = false;
            this.rz.setMatrixValues(matrixf4x4.getMatrix());
            this.rA.loadIndentity();
            Matrix.translateM(this.rA.getMatrix(), 0, vector3f.getX(), vector3f.getY(), vector3f.getZ());
            float[] fArr3 = new float[16];
            Matrix.multiplyMM(fArr3, matrixf4x4.getMatrix(), this.rA.getMatrix());
            float[] fArr4 = new float[16];
            Matrix.invertM(fArr4, 0, fArr3, 0);
            this.rA.setMatrixValues(fArr4);
            matrixf4x43.setMatrixValues(matrixf4x42.getMatrix());
        } else {
            Matrixf4x4 matrixf4x45 = new Matrixf4x4();
            float[] fArr5 = new float[16];
            Matrix.transposeM(fArr5, 0, this.rz.getMatrix(), 0);
            float[] fArr6 = new float[16];
            Matrix.multiplyMM(fArr6, fArr5, matrixf4x4.getMatrix());
            matrixf4x45.setMatrixValues(fArr6);
            Matrix.transposeM(fArr6, 0, matrixf4x45.getMatrix(), 0);
            float[] fArr7 = new float[16];
            Matrix.multiplyMM(fArr7, fArr6, this.rA.getMatrix());
            matrixf4x43.setMatrixValues(fArr7);
        }
        return matrixf4x43;
    }

    private Vector3f a(Matrixf4x4 matrixf4x4) {
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

    private void a(Matrixf4x4 matrixf4x4, Vector3f vector3f) {
        this.rI = false;
        if (this.rF != 1) {
            float[] fArr = new float[16];
            Matrix.transposeM(fArr, 0, matrixf4x4.getMatrix(), 0);
            this.rB.setMatrixValues(fArr);
            return;
        }
        this.rz.setMatrixValues(matrixf4x4.getMatrix());
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        matrixf4x42.setW0(vector3f.x());
        matrixf4x42.setW1(vector3f.y());
        matrixf4x42.setW2(vector3f.z());
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, matrixf4x4.getMatrix(), matrixf4x42.getMatrix());
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        this.rA.setMatrixValues(fArr3);
    }

    private void a(float[] fArr, int i) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        System.arraycopy(fArr, 0, this.rD, 0, 16);
        this.ry.setMatrixValues(this.rD);
        this.rE = true;
        this.rF = i;
        System.arraycopy(fArr, 0, this.rD, 0, 16);
        this.ry.setMatrixValues(this.rD);
        com.baidu.ar.arrender.k r = r();
        if (r != null) {
            r.b(ARPScriptEnvironment.KEY_DATA_PIP_IMU, this.ry);
        }
        this.rE = true;
        this.rF = i;
        eU();
    }

    private void b(Matrixf4x4 matrixf4x4) {
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

    private Matrixf4x4 c(Matrixf4x4 matrixf4x4) {
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

    private Matrixf4x4 c(Vector3f vector3f) {
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(this.ry.getMatrix());
        matrixf4x4.transpose();
        if (this.rI) {
            a(matrixf4x4, vector3f);
        }
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, this.rB.getMatrix(), matrixf4x4.getMatrix());
        matrixf4x4.setMatrixValues(fArr);
        return matrixf4x4;
    }

    private void eT() {
        if (this.rw == null) {
            this.rw = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.imu.ImuAR.1
                @Override // com.baidu.ar.lua.c
                public void a(int i, int i2, HashMap<String, Object> hashMap) {
                    boolean z = false;
                    switch (i) {
                        case 305:
                            if (hashMap != null && hashMap.containsKey("with_interaction") && ((Integer) hashMap.get("with_interaction")).intValue() != 0) {
                                z = true;
                            }
                            ImuAR.this.rI = true;
                            if (z || ImuAR.this.r() == null) {
                                return;
                            }
                            ImuAR.this.r().bB();
                            return;
                        case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                            if (hashMap.get("is_mirrored") instanceof Integer) {
                                ImuAR.this.rJ = ((Integer) hashMap.get("is_mirrored")).intValue() == 1;
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }

                @Override // com.baidu.ar.lua.c
                public List<Integer> n() {
                    return Arrays.asList(Integer.valueOf((int) ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA), 305);
                }
            };
        }
        a(this.rw);
    }

    private void eU() {
        com.baidu.ar.arrender.k r = r();
        if (this.rE && !this.rG) {
            this.rG = true;
            b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, (HashMap<String, Object>) null);
            if (r != null) {
                this.rH = r.isDriverdByARPVersion();
            }
        }
        if (r != null) {
            Matrixf4x4 aT = r.aT();
            Vector3f a2 = a(aT);
            Matrixf4x4 a3 = a(c(a2), aT, a2);
            if (this.rJ) {
                b(a3);
            }
            if (this.f1193rx != null && this.f1193rx.eX() == b.WORLD && this.rH) {
                a3 = c(a3);
            }
            l lVar = new l();
            lVar.p("ability_imu");
            lVar.setMatrix(a3.getMatrix());
            r.i(true);
            r.a(lVar);
        }
    }

    @Override // com.baidu.ar.imu.g
    public void onImuUpdate(f fVar) {
        if (fVar != null) {
            a(fVar.getMatrix(), fVar.eV());
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        com.baidu.ar.g.b.c(TAG, "release()");
        a((g) this);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("succeeded", 1);
        b(304, hashMap);
        b(this.rw);
        this.f1193rx = null;
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        int i = 0;
        super.setup(hashMap);
        if (hashMap != null && hashMap.containsKey("type")) {
            com.baidu.ar.g.b.c(TAG, "setup() luaParams = " + hashMap.toString());
            Object obj = hashMap.get("type");
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof Float ? (int) ((Float) obj).floatValue() : 0;
            if (hashMap.containsKey("init_pos")) {
                Object obj2 = hashMap.get("init_pos");
                if (obj2 instanceof Integer) {
                    i = ((Integer) obj2).intValue();
                } else if (obj2 instanceof Float) {
                    i = (int) ((Float) obj2).floatValue();
                }
            }
            this.f1193rx = new i();
            this.f1193rx.b(b.J(intValue));
            this.f1193rx.L(i);
            a(this.f1193rx, this);
            eT();
            com.baidu.ar.arrender.k r = r();
            if (r != null) {
                r.bz();
                if (this.f1193rx.eX() == b.RELATIVE) {
                    r.aI();
                }
                r.a(this.f1193rx.eX());
            }
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("succeeded", 1);
            b(302, hashMap2);
        }
        if (ARConfig.getARType() == ARType.IMU.getTypeValue()) {
            StatisticApi.onEvent(StatisticConstants.IMU_SET_SUCCESS);
        }
    }
}
