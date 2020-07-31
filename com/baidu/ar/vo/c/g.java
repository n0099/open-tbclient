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
/* loaded from: classes11.dex */
public class g implements d {
    private int mPreviewHeight;
    private int mPreviewWidth;
    private com.baidu.ar.vo.a.b xN;
    private com.baidu.ar.vo.b.a xO;
    private j xP;
    private com.baidu.ar.vo.a xQ;
    private boolean xR = true;
    private int xS = 0;
    private volatile Runnable xT;

    public g(j jVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.a aVar2) {
        this.xP = jVar;
        this.xN = bVar;
        this.xO = aVar;
        this.xQ = aVar2;
    }

    private boolean ga() {
        if (this.xS == 0) {
            this.xS = this.xP.isDriverdByARPVersion() ? 1 : -1;
        }
        return this.xS == 1;
    }

    private void h(int i, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 4101);
        hashMap.put("guideDirection", Integer.valueOf(i2));
        hashMap.put("switchGuide", Integer.valueOf(i));
        this.xQ.d(hashMap);
    }

    private float[] s(float[] fArr) {
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
        if (bVar.xM) {
            int[] b = b(bVar.x, bVar.y);
            f = b[1];
            f2 = b[0];
        } else {
            float f3 = bVar.x;
            f = bVar.y;
            f2 = f3;
        }
        String a = a(this.xN);
        if (bVar.type == 3) {
            this.xO.fT();
            a(a, (int) f2, (int) f, null, (int) bVar.xL);
            this.xT = new Runnable() { // from class: com.baidu.ar.vo.c.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.xP != null) {
                        g.this.xP.sceneRotateToCamera();
                    }
                }
            };
        } else if (bVar.type == 2) {
            this.xO.fT();
            a(a, (int) f2, (int) f, null, (int) bVar.xL);
            this.xT = new Runnable() { // from class: com.baidu.ar.vo.c.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.xP != null) {
                        g.this.xP.sceneWorldPositionToOrigin();
                    }
                }
            };
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(String str, int i, int i2, float[] fArr, float f) {
        if (this.xO != null) {
            this.xO.insertModel(str, i, i2, fArr, f);
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
    public void fW() {
        h(1, 0);
    }

    @Override // com.baidu.ar.vo.c.d
    public void fX() {
        h(1, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void fY() {
        h(0, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void fZ() {
        this.xP.h(true);
    }

    @Override // com.baidu.ar.vo.c.d
    public void r(float[] fArr) {
        if (this.xP == null || fArr == null || fArr.length != 16) {
            return;
        }
        if (this.xT != null) {
            this.xT.run();
            this.xT = null;
        }
        this.xP.b(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, fArr);
        if (this.xR) {
            this.xR = false;
            this.xQ.b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, null);
        }
        if (ga()) {
            fArr = s(fArr);
        }
        k kVar = new k();
        kVar.o("ability_vo");
        kVar.setMatrix(fArr);
        this.xP.a(kVar);
    }

    @Override // com.baidu.ar.vo.c.d
    public void release() {
        this.xO = null;
        this.xT = null;
        this.xP = null;
        this.xQ = null;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }
}
