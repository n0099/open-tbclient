package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v {
    float FX;
    float FY;
    float FZ;
    float Ga;
    long Gb;
    long Gc;
    boolean Gd;
    final /* synthetic */ VerticalTranslateLayout JM;

    private void mj() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FX = ((((float) (uptimeMillis - this.Gb)) / 1000.0f) * this.FY) + this.FX;
        this.Gb = uptimeMillis;
        this.Gc += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nF() {
        u uVar;
        y yVar;
        mj();
        if (this.FX <= this.FZ) {
            yVar = this.JM.JJ;
            if (yVar != null) {
                yVar.nK();
            }
            this.Gd = false;
            this.JM.FH = 10000;
            this.JM.mi();
            return;
        }
        this.JM.Jy = (int) (a.a(this.FZ, this.FX, false) + this.Ga);
        this.JM.invalidate();
        uVar = this.JM.JG;
        uVar.sendEmptyMessageAtTime(-100, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nG() {
        u uVar;
        w wVar;
        mj();
        if (this.FX >= this.FZ) {
            wVar = this.JM.JK;
            if (wVar != null) {
                wVar.nJ();
            }
            this.Gd = false;
            this.JM.FH = 10001;
            this.JM.mi();
            return;
        }
        this.JM.Jy = (int) (a.a(this.FZ, this.FX, false) + this.Ga);
        this.JM.invalidate();
        uVar = this.JM.JG;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nH() {
        u uVar;
        List<x> list;
        mj();
        if (this.FX >= this.FZ) {
            list = this.JM.FU;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.mr();
                }
            }
            this.Gd = false;
            this.JM.FH = 10004;
            this.JM.mi();
            return;
        }
        this.JM.Jy = (int) (a.a(this.FZ, this.FX, false) + this.Ga);
        this.JM.invalidate();
        uVar = this.JM.JG;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nI() {
        u uVar;
        List<x> list;
        mj();
        if (this.FX <= this.FZ) {
            list = this.JM.FU;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.mr();
                }
            }
            this.Gd = false;
            this.JM.FH = 10004;
            this.JM.mi();
            return;
        }
        this.JM.Jy = (int) (a.a(this.FZ, this.FX, false) + this.Ga);
        this.JM.invalidate();
        uVar = this.JM.JG;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<x> list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.JM.FU;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.mq();
            }
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        i = this.JM.Jy;
        this.FZ = 0 - i;
        i2 = this.JM.Jy;
        this.Ga = i2;
        uVar = this.JM.JG;
        uVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.FZ);
        Log.d("Animator", "@animateTopOpen " + f);
        uVar2 = this.JM.JG;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        List<x> list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.JM.FU;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.mq();
            }
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        i = this.JM.Jy;
        this.FZ = 0 - i;
        i2 = this.JM.Jy;
        this.Ga = i2;
        Log.d("Animator", "@animateBottomOpen " + this.FZ);
        Log.d("Animator", "@animateBottomOpen " + f);
        uVar = this.JM.JG;
        uVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        uVar2 = this.JM.JG;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Gc);
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
        yVar = this.JM.JJ;
        if (yVar != null) {
            yVar.mo();
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        i = this.JM.Fy;
        f2 = this.JM.Ju;
        float f3 = (-i) + f2;
        i2 = this.JM.Jy;
        this.FZ = f3 - i2;
        i3 = this.JM.Jy;
        this.Ga = i3;
        Log.d("Animator", "@animateTop " + this.FZ);
        Log.d("Animator", "@animateTop " + f);
        uVar = this.JM.JG;
        uVar.removeMessages(-100);
        uVar2 = this.JM.JG;
        uVar2.sendEmptyMessageAtTime(-100, this.Gc);
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
        wVar = this.JM.JK;
        if (wVar != null) {
            wVar.ms();
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        i = this.JM.Fy;
        f2 = this.JM.Jw;
        float f3 = i - f2;
        i2 = this.JM.Jy;
        this.FZ = f3 - i2;
        i3 = this.JM.Jy;
        this.Ga = i3;
        Log.d("Animator", "@animateBottom " + this.FZ);
        Log.d("Animator", "@animateBottom " + f);
        uVar = this.JM.JG;
        uVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        uVar2 = this.JM.JG;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Gc);
    }
}
