package com.baidu.ar.vo.c;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.m;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g implements d {
    public int mPreviewHeight;
    public int mPreviewWidth;
    public com.baidu.ar.vo.a.b zb;
    public com.baidu.ar.vo.b.a zc;
    public l zd;
    public com.baidu.ar.vo.a ze;
    public boolean zf = true;
    public int zg = 0;
    public volatile Runnable zh;

    public g(l lVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.a aVar2) {
        this.zd = lVar;
        this.zb = bVar;
        this.zc = aVar;
        this.ze = aVar2;
    }

    private boolean hp() {
        if (this.zg == 0) {
            this.zg = this.zd.isDriverdByARPVersion() ? 1 : -1;
        }
        return this.zg == 1;
    }

    private void k(int i, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 4101);
        hashMap.put("guideDirection", Integer.valueOf(i2));
        hashMap.put("switchGuide", Integer.valueOf(i));
        this.ze.d(hashMap);
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
        Runnable runnable;
        if (bVar == null) {
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
            runnable = new Runnable() { // from class: com.baidu.ar.vo.c.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.zd != null) {
                        g.this.zd.sceneRotateToCamera();
                    }
                }
            };
        } else if (i != 2) {
            return;
        } else {
            this.zc.hi();
            a(a, (int) f, (int) f2, null, (int) bVar.yZ);
            runnable = new Runnable() { // from class: com.baidu.ar.vo.c.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.zd != null) {
                        g.this.zd.sceneWorldPositionToOrigin();
                    }
                }
            };
        }
        this.zh = runnable;
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(String str, int i, int i2, float[] fArr, float f) {
        com.baidu.ar.vo.b.a aVar = this.zc;
        if (aVar != null) {
            aVar.insertModel(str, i, i2, fArr, f);
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public int[] b(float f, float f2) {
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

    @Override // com.baidu.ar.vo.c.d
    public void hl() {
        k(1, 0);
    }

    @Override // com.baidu.ar.vo.c.d
    public void hm() {
        k(1, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void hn() {
        k(0, 1);
    }

    @Override // com.baidu.ar.vo.c.d
    public void ho() {
        this.zd.setOffScreenGuideWork(true);
    }

    @Override // com.baidu.ar.vo.c.d
    public void r(float[] fArr) {
        if (this.zd == null || fArr == null || fArr.length != 16) {
            return;
        }
        if (this.zh != null) {
            this.zh.run();
            this.zh = null;
        }
        this.zd.a(ARPScriptEnvironment.KEY_DATA_PIP_SLAM, fArr);
        if (this.zf) {
            this.zf = false;
            this.ze.b(7001, null);
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
        this.zc = null;
        this.zh = null;
        this.zd = null;
        this.ze = null;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }
}
