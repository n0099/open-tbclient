package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v {
    float FO;
    float FP;
    float FQ;
    float FR;
    long FS;
    long FT;
    boolean FU;
    final /* synthetic */ VerticalTranslateLayout JF;

    private void mC() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FO = ((((float) (uptimeMillis - this.FS)) / 1000.0f) * this.FP) + this.FO;
        this.FS = uptimeMillis;
        this.FT += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nW() {
        u uVar;
        y yVar;
        mC();
        if (this.FO <= this.FQ) {
            yVar = this.JF.JC;
            if (yVar != null) {
                yVar.ob();
            }
            this.FU = false;
            this.JF.Fy = 10000;
            this.JF.mB();
            return;
        }
        this.JF.Jr = (int) (a.a(this.FQ, this.FO, false) + this.FR);
        this.JF.invalidate();
        uVar = this.JF.Jz;
        uVar.sendEmptyMessageAtTime(-100, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nX() {
        u uVar;
        w wVar;
        mC();
        if (this.FO >= this.FQ) {
            wVar = this.JF.JD;
            if (wVar != null) {
                wVar.oa();
            }
            this.FU = false;
            this.JF.Fy = 10001;
            this.JF.mB();
            return;
        }
        this.JF.Jr = (int) (a.a(this.FQ, this.FO, false) + this.FR);
        this.JF.invalidate();
        uVar = this.JF.Jz;
        uVar.sendEmptyMessageAtTime(-101, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nY() {
        u uVar;
        List<x> list;
        mC();
        if (this.FO >= this.FQ) {
            list = this.JF.FL;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.mK();
                }
            }
            this.FU = false;
            this.JF.Fy = 10004;
            this.JF.mB();
            return;
        }
        this.JF.Jr = (int) (a.a(this.FQ, this.FO, false) + this.FR);
        this.JF.invalidate();
        uVar = this.JF.Jz;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nZ() {
        u uVar;
        List<x> list;
        mC();
        if (this.FO <= this.FQ) {
            list = this.JF.FL;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.mK();
                }
            }
            this.FU = false;
            this.JF.Fy = 10004;
            this.JF.mB();
            return;
        }
        this.JF.Jr = (int) (a.a(this.FQ, this.FO, false) + this.FR);
        this.JF.invalidate();
        uVar = this.JF.Jz;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<x> list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.JF.FL;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.mJ();
            }
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        i = this.JF.Jr;
        this.FQ = 0 - i;
        i2 = this.JF.Jr;
        this.FR = i2;
        uVar = this.JF.Jz;
        uVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.FQ);
        Log.d("Animator", "@animateTopOpen " + f);
        uVar2 = this.JF.Jz;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        List<x> list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.JF.FL;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.mJ();
            }
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        i = this.JF.Jr;
        this.FQ = 0 - i;
        i2 = this.JF.Jr;
        this.FR = i2;
        Log.d("Animator", "@animateBottomOpen " + this.FQ);
        Log.d("Animator", "@animateBottomOpen " + f);
        uVar = this.JF.Jz;
        uVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        uVar2 = this.JF.Jz;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f) {
        y yVar;
        int i;
        float f2;
        int i2;
        int i3;
        u uVar;
        u uVar2;
        yVar = this.JF.JC;
        if (yVar != null) {
            yVar.mH();
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        i = this.JF.Fp;
        f2 = this.JF.Jn;
        float f3 = (-i) + f2;
        i2 = this.JF.Jr;
        this.FQ = f3 - i2;
        i3 = this.JF.Jr;
        this.FR = i3;
        Log.d("Animator", "@animateTop " + this.FQ);
        Log.d("Animator", "@animateTop " + f);
        uVar = this.JF.Jz;
        uVar.removeMessages(-100);
        uVar2 = this.JF.Jz;
        uVar2.sendEmptyMessageAtTime(-100, this.FT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f) {
        w wVar;
        int i;
        float f2;
        int i2;
        int i3;
        u uVar;
        u uVar2;
        wVar = this.JF.JD;
        if (wVar != null) {
            wVar.mL();
        }
        this.FU = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FS = uptimeMillis;
        this.FT = uptimeMillis + 16;
        this.FP = f;
        this.FO = 0.0f;
        i = this.JF.Fp;
        f2 = this.JF.Jp;
        float f3 = i - f2;
        i2 = this.JF.Jr;
        this.FQ = f3 - i2;
        i3 = this.JF.Jr;
        this.FR = i3;
        Log.d("Animator", "@animateBottom " + this.FQ);
        Log.d("Animator", "@animateBottom " + f);
        uVar = this.JF.Jz;
        uVar.removeMessages(-101);
        uVar2 = this.JF.Jz;
        uVar2.sendEmptyMessageAtTime(-101, this.FT);
    }
}
