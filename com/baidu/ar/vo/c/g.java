package com.baidu.ar.vo.c;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.m;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g implements d {
    private int mPreviewHeight;
    private int mPreviewWidth;
    private com.baidu.ar.vo.a.b zb;
    private com.baidu.ar.vo.b.a zc;
    private l zd;
    private com.baidu.ar.vo.a ze;
    private boolean zf = true;
    private int zg = 0;
    private volatile Runnable zh;

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
        if (bVar == null) {
            return;
        }
        if (bVar.za) {
            int[] b2 = b(bVar.x, bVar.y);
            f = b2[1];
            f2 = b2[0];
        } else {
            float f3 = bVar.x;
            f = bVar.y;
            f2 = f3;
        }
        String a2 = a(this.zb);
        if (bVar.type == 3) {
            this.zc.hi();
            a(a2, (int) f2, (int) f, null, (int) bVar.yZ);
            this.zh = new Runnable() { // from class: com.baidu.ar.vo.c.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.zd != null) {
                        g.this.zd.sceneRotateToCamera();
                    }
                }
            };
        } else if (bVar.type == 2) {
            this.zc.hi();
            a(a2, (int) f2, (int) f, null, (int) bVar.yZ);
            this.zh = new Runnable() { // from class: com.baidu.ar.vo.c.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.zd != null) {
                        g.this.zd.sceneWorldPositionToOrigin();
                    }
                }
            };
        }
    }

    @Override // com.baidu.ar.vo.c.d
    public void a(String str, int i, int i2, float[] fArr, float f) {
        if (this.zc != null) {
            this.zc.insertModel(str, i, i2, fArr, f);
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
