package com.baidu.ar.face;

import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.face.a.a;
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private boolean needHeadPose = false;
    private boolean needSkeleton = false;
    private boolean needTriggers = false;
    private boolean needExpression = false;
    private boolean nE = false;
    private boolean nF = true;
    private boolean nG = true;
    private int nH = 180;
    private int nI = 320;
    private boolean nJ = true;
    private boolean nK = false;
    private int nL = 4;
    private int nM = this.nL;

    public void A(int i) {
        this.needHeadPose = false;
        this.needSkeleton = false;
        this.needTriggers = false;
        this.needExpression = false;
        this.nE = false;
        this.nM = this.nL;
        this.nF = i != 0;
        this.nG = true;
    }

    public void B(int i) {
        boolean z = false;
        this.needHeadPose = this.needHeadPose;
        this.needSkeleton = this.needSkeleton;
        this.needTriggers = this.needTriggers;
        this.needExpression = this.needExpression;
        this.nE = this.nE;
        if (this.nF || i != 0) {
            z = true;
        }
        this.nF = z;
        if (!this.nG) {
        }
        this.nG = true;
    }

    public a.C0086a a(a.b bVar) {
        a.C0086a c0086a = null;
        switch (bVar.qg) {
            case 0:
                this.nL = 1;
                c0086a = bVar.qd;
                break;
            case 1:
                this.nL = 1;
                c0086a = bVar.qe;
                break;
            case 2:
                this.nL = 4;
                c0086a = bVar.qf;
                break;
            default:
                com.baidu.ar.h.b.b(TAG, "createFaceParams() device not support!!!");
                break;
        }
        this.nM = this.nL;
        return c0086a;
    }

    public void b(String str, int i) {
        this.needHeadPose = c.b(str, false);
        this.needSkeleton = c.c(str, false);
        this.needTriggers = c.d(str, false);
        this.needExpression = c.e(str, false);
        this.nE = c.f(str, false);
        this.nF = c.g(str, i != 0);
        this.nM = c.c(str, 1);
        if (this.nM <= 1 || ARAuth.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
            return;
        }
        this.nM = 1;
    }

    public boolean dA() {
        return this.nJ;
    }

    public boolean dB() {
        return this.nK;
    }

    public int dC() {
        return this.nL;
    }

    public int dD() {
        return this.nM;
    }

    public void dr() {
        this.nH = 180;
        this.nI = 320;
    }

    public void ds() {
        this.nM = 1;
    }

    public boolean dt() {
        return this.needHeadPose;
    }

    public boolean du() {
        return this.needSkeleton;
    }

    public boolean dv() {
        return this.needTriggers;
    }

    public boolean dw() {
        return this.needExpression;
    }

    public boolean dx() {
        return this.nE;
    }

    public boolean dy() {
        return this.nF;
    }

    public boolean dz() {
        return this.nG;
    }

    public int getAlgoImageHeight() {
        return this.nI;
    }

    public int getAlgoImageWidth() {
        return this.nH;
    }

    public void setAlgoImageHeight(int i) {
        this.nI = i;
    }

    public void setAlgoImageWidth(int i) {
        this.nH = i;
    }

    public void x(boolean z) {
        this.nJ = z;
    }

    public void y(boolean z) {
        this.nK = z;
    }

    public void z(int i) {
        this.nF = i != 0;
    }
}
