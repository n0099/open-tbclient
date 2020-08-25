package com.baidu.ar.vo.c;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.k;
import com.baidu.ar.arrender.l;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class g implements d {
    private int mPreviewHeight;
    private int mPreviewWidth;
    private com.baidu.ar.vo.a.b ym;
    private com.baidu.ar.vo.b.a yn;
    private k yo;
    private com.baidu.ar.vo.a yp;
    private boolean yq = true;
    private int yr = 0;
    private volatile Runnable ys;

    public g(k kVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.a aVar2) {
        this.yo = kVar;
        this.ym = bVar;
        this.yn = aVar;
        this.yp = aVar2;
    }

    private boolean hp() {
        if (this.yr == 0) {
            this.yr = this.yo.isDriverdByARPVersion() ? 1 : -1;
        }
        return this.yr == 1;
    }

    private void j(int i, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 4101);
        hashMap.put("guideDirection", Integer.valueOf(i2));
        hashMap.put("switchGuide", Integer.valueOf(i));
        this.yp.d(hashMap);
    }

    private float[] t(float[] fArr) {
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
        if (bVar.yl) {
            int[] b = b(bVar.x, bVar.y);
            f = b[1];
            f2 = b[0];
        } else {
            float f3 = bVar.x;
            f = bVar.y;
            f2 = f3;
        }
        String a = a(this.ym);
        if (bVar.type == 3) {
            this.yn.hi();
            a(a, (int) f2, (int) f, null, (int) bVar.yk);
            this.ys = new Runnable() { // from class: com.baidu.ar.vo.c.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.yo != null) {
                        g.this.yo.sceneRotateToCamera();
                    }
                }
            };
        } else if (bVar.type == 2) {
            this.yn.hi();
            a(a, (int) f2, (int) f, null, (int) bVar.yk);
            this.ys = new Runnable() { // from class: com.baidu.ar.vo.c.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.yo != null) {
                        g.this.yo.sceneWorldPositionToOrigin();
                    }
                }
            };
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(String str, int i, int i2, float[] fArr, float f) {
        if (this.yn != null) {
            this.yn.insertModel(str, i, i2, fArr, f);
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
    public void hl() {
        j(1, 0);
    }

    @Override // com.baidu.ar.vo.c.d
    public void hm() {
        j(1, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void hn() {
        j(0, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void ho() {
        this.yo.i(true);
    }

    @Override // com.baidu.ar.vo.c.d
    public void release() {
        this.yn = null;
        this.ys = null;
        this.yo = null;
        this.yp = null;
    }

    @Override // com.baidu.ar.vo.c.d
    public void s(float[] fArr) {
        if (this.yo == null || fArr == null || fArr.length != 16) {
            return;
        }
        if (this.ys != null) {
            this.ys.run();
            this.ys = null;
        }
        this.yo.b(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, fArr);
        if (this.yq) {
            this.yq = false;
            this.yp.b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, null);
        }
        if (hp()) {
            fArr = t(fArr);
        }
        l lVar = new l();
        lVar.p("ability_vo");
        lVar.setMatrix(fArr);
        this.yo.a(lVar);
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }
}
