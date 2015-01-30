package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    final /* synthetic */ HorizontalTranslateLayout vc;
    float vd;
    float ve;
    float vf;
    float vg;
    long vh;
    long vi;
    boolean vj;

    private void iT() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vd = ((((float) (uptimeMillis - this.vh)) / 1000.0f) * this.ve) + this.vd;
        this.vh = uptimeMillis;
        this.vi += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iU() {
        f fVar;
        i iVar;
        iT();
        if (this.vd <= this.vf) {
            iVar = this.vc.uY;
            if (iVar != null) {
                iVar.iZ();
            }
            this.vj = false;
            this.vc.uN = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.vc.iS();
            return;
        }
        this.vc.uI = (int) (y.a(this.vf, this.vd, false) + this.vg);
        this.vc.invalidate();
        fVar = this.vc.uV;
        fVar.sendEmptyMessageAtTime(-100, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iV() {
        f fVar;
        k kVar;
        iT();
        if (this.vd >= this.vf) {
            kVar = this.vc.uZ;
            if (kVar != null) {
                kVar.jd();
            }
            this.vj = false;
            this.vc.uN = 10001;
            this.vc.iS();
            return;
        }
        this.vc.uI = (int) (y.a(this.vf, this.vd, false) + this.vg);
        this.vc.invalidate();
        fVar = this.vc.uV;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iW() {
        f fVar;
        List<j> list;
        iT();
        if (this.vd >= this.vf) {
            list = this.vc.va;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.jb();
                }
            }
            this.vj = false;
            this.vc.uN = 10004;
            this.vc.iS();
            return;
        }
        this.vc.uI = (int) (y.a(this.vf, this.vd, false) + this.vg);
        this.vc.invalidate();
        fVar = this.vc.uV;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iX() {
        f fVar;
        List<j> list;
        iT();
        if (this.vd <= this.vf) {
            list = this.vc.va;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.jb();
                }
            }
            this.vj = false;
            this.vc.uN = 10004;
            this.vc.iS();
            return;
        }
        this.vc.uI = (int) (y.a(this.vf, this.vd, false) + this.vg);
        this.vc.invalidate();
        fVar = this.vc.uV;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.vc.va;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.ja();
            }
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        i = this.vc.uI;
        this.vf = 0 - i;
        i2 = this.vc.uI;
        this.vg = i2;
        fVar = this.vc.uV;
        fVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.vf);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.vc.uV;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.vc.va;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.ja();
            }
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        i = this.vc.uI;
        this.vf = 0 - i;
        i2 = this.vc.uI;
        this.vg = i2;
        Log.d("Animator", "@animateBottomOpen " + this.vf);
        Log.d("Animator", "@animateBottomOpen " + f);
        fVar = this.vc.uV;
        fVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        fVar2 = this.vc.uV;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        i iVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        iVar = this.vc.uY;
        if (iVar != null) {
            iVar.iY();
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        f2 = this.vc.uG;
        float f3 = (-this.vc.getMeasuredWidth()) + f2;
        i = this.vc.uI;
        this.vf = f3 - i;
        i2 = this.vc.uI;
        this.vg = i2;
        Log.d("Animator", "@animateTop " + this.vf);
        Log.d("Animator", "@animateTop " + f);
        fVar = this.vc.uV;
        fVar.removeMessages(-100);
        fVar2 = this.vc.uV;
        fVar2.sendEmptyMessageAtTime(-100, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        k kVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        kVar = this.vc.uZ;
        if (kVar != null) {
            kVar.jc();
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        f2 = this.vc.uH;
        float measuredWidth = this.vc.getMeasuredWidth() - f2;
        i = this.vc.uI;
        this.vf = measuredWidth - i;
        i2 = this.vc.uI;
        this.vg = i2;
        Log.d("Animator", "@animateBottom " + this.vf);
        Log.d("Animator", "@animateBottom " + f);
        fVar = this.vc.uV;
        fVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        fVar2 = this.vc.uV;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vi);
    }
}
