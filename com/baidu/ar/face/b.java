package com.baidu.ar.face;

import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.face.a.a;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private boolean needHeadPose = false;
    private boolean needSkeleton = false;
    private boolean needTriggers = false;
    private boolean needExpression = false;
    private boolean no = false;
    private boolean np = true;
    private boolean nq = true;
    private int nr = 180;
    private int ns = 320;
    private boolean nt = true;
    private boolean nu = false;
    private int nv = 4;
    private int nw = this.nv;

    public void A(boolean z) {
        this.nu = z;
    }

    public a.C0082a a(a.b bVar) {
        a.C0082a c0082a = null;
        switch (bVar.pQ) {
            case 0:
                this.nv = 1;
                c0082a = bVar.pN;
                break;
            case 1:
                this.nv = 1;
                c0082a = bVar.pO;
                break;
            case 2:
                this.nv = 4;
                c0082a = bVar.pP;
                break;
            default:
                com.baidu.ar.g.b.b(TAG, "createFaceParams() device not support!!!");
                break;
        }
        this.nw = this.nv;
        return c0082a;
    }

    public void b(String str, int i) {
        this.needHeadPose = c.b(str, false);
        this.needSkeleton = c.c(str, false);
        this.needTriggers = c.d(str, false);
        this.needExpression = c.e(str, false);
        this.no = c.f(str, false);
        this.np = c.g(str, i != 0);
        this.nw = c.c(str, 1);
        if (this.nw <= 1 || com.baidu.ar.auth.a.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
            return;
        }
        this.nw = 1;
    }

    public boolean dA() {
        return this.nq;
    }

    public boolean dB() {
        return this.nt;
    }

    public boolean dC() {
        return this.nu;
    }

    public int dD() {
        return this.nv;
    }

    public int dE() {
        return this.nw;
    }

    public void ds() {
        this.nr = 180;
        this.ns = 320;
    }

    public void dt() {
        this.nw = 1;
    }

    public boolean du() {
        return this.needHeadPose;
    }

    public boolean dv() {
        return this.needSkeleton;
    }

    public boolean dw() {
        return this.needTriggers;
    }

    public boolean dx() {
        return this.needExpression;
    }

    public boolean dy() {
        return this.no;
    }

    public boolean dz() {
        return this.np;
    }

    public int getAlgoImageHeight() {
        return this.ns;
    }

    public int getAlgoImageWidth() {
        return this.nr;
    }

    public void setAlgoImageHeight(int i) {
        this.ns = i;
    }

    public void setAlgoImageWidth(int i) {
        this.nr = i;
    }

    public void x(int i) {
        this.np = i != 0;
    }

    public void y(int i) {
        this.needHeadPose = false;
        this.needSkeleton = false;
        this.needTriggers = false;
        this.needExpression = false;
        this.no = false;
        this.nw = this.nv;
        this.np = i != 0;
        this.nq = true;
    }

    public void z(int i) {
        boolean z = false;
        this.needHeadPose = this.needHeadPose;
        this.needSkeleton = this.needSkeleton;
        this.needTriggers = this.needTriggers;
        this.needExpression = this.needExpression;
        this.no = this.no;
        if (this.np || i != 0) {
            z = true;
        }
        this.np = z;
        if (!this.nq) {
        }
        this.nq = true;
    }

    public void z(boolean z) {
        this.nt = z;
    }
}
