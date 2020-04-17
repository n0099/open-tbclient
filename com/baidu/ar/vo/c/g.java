package com.baidu.ar.vo.c;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.j;
import com.baidu.ar.arrender.k;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g implements d {
    private int mPreviewHeight;
    private int mPreviewWidth;
    private com.baidu.ar.vo.a.b xn;
    private com.baidu.ar.vo.b.a xo;
    private j xp;
    private com.baidu.ar.vo.a xq;
    private boolean xr = true;
    private int xs = 0;
    private volatile Runnable xt;

    public g(j jVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.a aVar2) {
        this.xp = jVar;
        this.xn = bVar;
        this.xo = aVar;
        this.xq = aVar2;
    }

    private boolean fK() {
        if (this.xs == 0) {
            this.xs = this.xp.isDriverdByARPVersion() ? 1 : -1;
        }
        return this.xs == 1;
    }

    private void g(int i, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 4101);
        hashMap.put("guideDirection", Integer.valueOf(i2));
        hashMap.put("switchGuide", Integer.valueOf(i));
        this.xq.d(hashMap);
    }

    private float[] r(float[] fArr) {
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

    @Override // com.baidu.ar.vo.c.d
    public String a(com.baidu.ar.vo.a.b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.getId())) ? "slam_model_1" : bVar.getId();
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(b bVar) {
        float f;
        float f2;
        if (bVar == null) {
            return;
        }
        if (bVar.xm) {
            int[] b = b(bVar.x, bVar.y);
            f = b[1];
            f2 = b[0];
        } else {
            float f3 = bVar.x;
            f = bVar.y;
            f2 = f3;
        }
        String a = a(this.xn);
        if (bVar.type == 3) {
            this.xo.fD();
            a(a, (int) f2, (int) f, null, (int) bVar.xl);
            this.xt = new Runnable() { // from class: com.baidu.ar.vo.c.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.xp != null) {
                        g.this.xp.sceneRotateToCamera();
                    }
                }
            };
        } else if (bVar.type == 2) {
            this.xo.fD();
            a(a, (int) f2, (int) f, null, (int) bVar.xl);
            this.xt = new Runnable() { // from class: com.baidu.ar.vo.c.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.xp != null) {
                        g.this.xp.sceneWorldPositionToOrigin();
                    }
                }
            };
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(String str, int i, int i2, float[] fArr, float f) {
        if (this.xo != null) {
            this.xo.insertModel(str, i, i2, fArr, f);
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public int[] b(float f, float f2) {
        int[] iArr = new int[2];
        if (this.mPreviewWidth != 0) {
            iArr[1] = this.mPreviewHeight - ((int) (720.0f * f));
            iArr[0] = (int) (1280.0f * f2);
        } else {
            iArr[1] = 640;
            iArr[0] = 360;
        }
        return iArr;
    }

    @Override // com.baidu.ar.vo.c.d
    public void fG() {
        g(1, 0);
    }

    @Override // com.baidu.ar.vo.c.d
    public void fH() {
        g(1, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void fI() {
        g(0, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void fJ() {
        this.xp.i(true);
    }

    @Override // com.baidu.ar.vo.c.d
    public void q(float[] fArr) {
        if (this.xp == null || fArr == null || fArr.length != 16) {
            return;
        }
        if (this.xt != null) {
            this.xt.run();
            this.xt = null;
        }
        this.xp.b(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, fArr);
        if (this.xr) {
            this.xr = false;
            this.xq.b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, null);
        }
        if (fK()) {
            fArr = r(fArr);
        }
        k kVar = new k();
        kVar.o("ability_vo");
        kVar.setMatrix(fArr);
        this.xp.a(kVar);
    }

    @Override // com.baidu.ar.vo.c.d
    public void release() {
        this.xo = null;
        this.xt = null;
        this.xp = null;
        this.xq = null;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }
}
