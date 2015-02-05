package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    final /* synthetic */ HorizontalTranslateLayout uZ;
    float va;
    float vb;
    float vc;
    float vd;
    long ve;
    long vf;
    boolean vg;

    private void iM() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.va = ((((float) (uptimeMillis - this.ve)) / 1000.0f) * this.vb) + this.va;
        this.ve = uptimeMillis;
        this.vf += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iN() {
        f fVar;
        i iVar;
        iM();
        if (this.va <= this.vc) {
            iVar = this.uZ.uV;
            if (iVar != null) {
                iVar.iS();
            }
            this.vg = false;
            this.uZ.uK = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.uZ.iL();
            return;
        }
        this.uZ.uF = (int) (y.a(this.vc, this.va, false) + this.vd);
        this.uZ.invalidate();
        fVar = this.uZ.uS;
        fVar.sendEmptyMessageAtTime(-100, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iO() {
        f fVar;
        k kVar;
        iM();
        if (this.va >= this.vc) {
            kVar = this.uZ.uW;
            if (kVar != null) {
                kVar.iW();
            }
            this.vg = false;
            this.uZ.uK = 10001;
            this.uZ.iL();
            return;
        }
        this.uZ.uF = (int) (y.a(this.vc, this.va, false) + this.vd);
        this.uZ.invalidate();
        fVar = this.uZ.uS;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iP() {
        f fVar;
        List<j> list;
        iM();
        if (this.va >= this.vc) {
            list = this.uZ.uX;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.iU();
                }
            }
            this.vg = false;
            this.uZ.uK = 10004;
            this.uZ.iL();
            return;
        }
        this.uZ.uF = (int) (y.a(this.vc, this.va, false) + this.vd);
        this.uZ.invalidate();
        fVar = this.uZ.uS;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iQ() {
        f fVar;
        List<j> list;
        iM();
        if (this.va <= this.vc) {
            list = this.uZ.uX;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.iU();
                }
            }
            this.vg = false;
            this.uZ.uK = 10004;
            this.uZ.iL();
            return;
        }
        this.uZ.uF = (int) (y.a(this.vc, this.va, false) + this.vd);
        this.uZ.invalidate();
        fVar = this.uZ.uS;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.uZ.uX;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.iT();
            }
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        i = this.uZ.uF;
        this.vc = 0 - i;
        i2 = this.uZ.uF;
        this.vd = i2;
        fVar = this.uZ.uS;
        fVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.vc);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.uZ.uS;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.uZ.uX;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.iT();
            }
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        i = this.uZ.uF;
        this.vc = 0 - i;
        i2 = this.uZ.uF;
        this.vd = i2;
        Log.d("Animator", "@animateBottomOpen " + this.vc);
        Log.d("Animator", "@animateBottomOpen " + f);
        fVar = this.uZ.uS;
        fVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        fVar2 = this.uZ.uS;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        i iVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        iVar = this.uZ.uV;
        if (iVar != null) {
            iVar.iR();
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        f2 = this.uZ.uD;
        float f3 = (-this.uZ.getMeasuredWidth()) + f2;
        i = this.uZ.uF;
        this.vc = f3 - i;
        i2 = this.uZ.uF;
        this.vd = i2;
        Log.d("Animator", "@animateTop " + this.vc);
        Log.d("Animator", "@animateTop " + f);
        fVar = this.uZ.uS;
        fVar.removeMessages(-100);
        fVar2 = this.uZ.uS;
        fVar2.sendEmptyMessageAtTime(-100, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        k kVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        kVar = this.uZ.uW;
        if (kVar != null) {
            kVar.iV();
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        f2 = this.uZ.uE;
        float measuredWidth = this.uZ.getMeasuredWidth() - f2;
        i = this.uZ.uF;
        this.vc = measuredWidth - i;
        i2 = this.uZ.uF;
        this.vd = i2;
        Log.d("Animator", "@animateBottom " + this.vc);
        Log.d("Animator", "@animateBottom " + f);
        fVar = this.uZ.uS;
        fVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        fVar2 = this.uZ.uS;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vf);
    }
}
