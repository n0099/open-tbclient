package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    final /* synthetic */ HorizontalTranslateLayout FN;
    float FO;
    float FP;
    float FQ;
    float FR;
    long FS;
    long FT;
    boolean FU;

    private void mC() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FO = ((((float) (uptimeMillis - this.FS)) / 1000.0f) * this.FP) + this.FO;
        this.FS = uptimeMillis;
        this.FT += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mD() {
        g gVar;
        j jVar;
        mC();
        if (this.FO <= this.FQ) {
            jVar = this.FN.FJ;
            if (jVar != null) {
                jVar.mI();
            }
            this.FU = false;
            this.FN.Fy = 10000;
            this.FN.mB();
            return;
        }
        this.FN.Ft = (int) (ab.a(this.FQ, this.FO, false) + this.FR);
        this.FN.invalidate();
        gVar = this.FN.FG;
        gVar.sendEmptyMessageAtTime(-100, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mE() {
        g gVar;
        l lVar;
        mC();
        if (this.FO >= this.FQ) {
            lVar = this.FN.FK;
            if (lVar != null) {
                lVar.mM();
            }
            this.FU = false;
            this.FN.Fy = 10001;
            this.FN.mB();
            return;
        }
        this.FN.Ft = (int) (ab.a(this.FQ, this.FO, false) + this.FR);
        this.FN.invalidate();
        gVar = this.FN.FG;
        gVar.sendEmptyMessageAtTime(-101, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mF() {
        g gVar;
        List<k> list;
        mC();
        if (this.FO >= this.FQ) {
            list = this.FN.FL;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.mK();
                }
            }
            this.FU = false;
            this.FN.Fy = 10004;
            this.FN.mB();
            return;
        }
        this.FN.Ft = (int) (ab.a(this.FQ, this.FO, false) + this.FR);
        this.FN.invalidate();
        gVar = this.FN.FG;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mG() {
        g gVar;
        List<k> list;
        mC();
        if (this.FO <= this.FQ) {
            list = this.FN.FL;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.mK();
                }
            }
            this.FU = false;
            this.FN.Fy = 10004;
            this.FN.mB();
            return;
        }
        this.FN.Ft = (int) (ab.a(this.FQ, this.FO, false) + this.FR);
        this.FN.invalidate();
        gVar = this.FN.FG;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.FN.FL;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.mJ();
            }
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        i = this.FN.Ft;
        this.FQ = 0 - i;
        i2 = this.FN.Ft;
        this.FR = i2;
        gVar = this.FN.FG;
        gVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.FQ);
        Log.d("Animator", "@animateTopOpen " + f);
        gVar2 = this.FN.FG;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.FN.FL;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.mJ();
            }
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        i = this.FN.Ft;
        this.FQ = 0 - i;
        i2 = this.FN.Ft;
        this.FR = i2;
        Log.d("Animator", "@animateBottomOpen " + this.FQ);
        Log.d("Animator", "@animateBottomOpen " + f);
        gVar = this.FN.FG;
        gVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        gVar2 = this.FN.FG;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        j jVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        jVar = this.FN.FJ;
        if (jVar != null) {
            jVar.mH();
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        f2 = this.FN.Fr;
        float f3 = (-this.FN.getMeasuredWidth()) + f2;
        i = this.FN.Ft;
        this.FQ = f3 - i;
        i2 = this.FN.Ft;
        this.FR = i2;
        Log.d("Animator", "@animateTop " + this.FQ);
        Log.d("Animator", "@animateTop " + f);
        gVar = this.FN.FG;
        gVar.removeMessages(-100);
        gVar2 = this.FN.FG;
        gVar2.sendEmptyMessageAtTime(-100, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        l lVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        lVar = this.FN.FK;
        if (lVar != null) {
            lVar.mL();
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        f2 = this.FN.Fs;
        float measuredWidth = this.FN.getMeasuredWidth() - f2;
        i = this.FN.Ft;
        this.FQ = measuredWidth - i;
        i2 = this.FN.Ft;
        this.FR = i2;
        Log.d("Animator", "@animateBottom " + this.FQ);
        Log.d("Animator", "@animateBottom " + f);
        gVar = this.FN.FG;
        gVar.removeMessages(-101);
        gVar2 = this.FN.FG;
        gVar2.sendEmptyMessageAtTime(-101, this.FT);
    }
}
