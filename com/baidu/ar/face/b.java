package com.baidu.ar.face;

import android.support.v4.media.session.MediaSessionCompat;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.face.a.a;
/* loaded from: classes.dex */
public class b {
    public static final String TAG = "b";
    public boolean needHeadPose = false;
    public boolean needSkeleton = false;
    public boolean needTriggers = false;
    public boolean needExpression = false;
    public boolean nE = false;
    public boolean nF = true;
    public boolean nG = true;
    public int nH = 180;
    public int nI = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
    public boolean nJ = true;
    public boolean nK = false;
    public int nL = 4;
    public int nM = 4;

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
        this.nF = (this.nF || i != 0) ? true : true;
        this.nG = true;
    }

    public a.C0060a a(a.b bVar) {
        a.C0060a c0060a;
        int i = bVar.qg;
        if (i == 0) {
            this.nL = 1;
            c0060a = bVar.qd;
        } else if (i == 1) {
            this.nL = 1;
            c0060a = bVar.qe;
        } else if (i != 2) {
            com.baidu.ar.h.b.b(TAG, "createFaceParams() device not support!!!");
            c0060a = null;
        } else {
            this.nL = 4;
            c0060a = bVar.qf;
        }
        this.nM = this.nL;
        return c0060a;
    }

    public void b(String str, int i) {
        this.needHeadPose = c.b(str, false);
        this.needSkeleton = c.c(str, false);
        this.needTriggers = c.d(str, false);
        this.needExpression = c.e(str, false);
        this.nE = c.f(str, false);
        this.nF = c.g(str, i != 0);
        int c = c.c(str, 1);
        this.nM = c;
        if (c <= 1 || ARAuth.checkFeatureAuth(FeatureCodes.FACE_MULTI)) {
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
        this.nI = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
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
