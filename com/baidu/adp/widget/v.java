package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v {
    float FZ;
    float Ga;
    float Gb;
    float Gc;
    long Gd;
    long Ge;
    boolean Gf;
    final /* synthetic */ VerticalTranslateLayout JO;

    private void mj() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FZ = ((((float) (uptimeMillis - this.Gd)) / 1000.0f) * this.Ga) + this.FZ;
        this.Gd = uptimeMillis;
        this.Ge += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nF() {
        u uVar;
        y yVar;
        mj();
        if (this.FZ <= this.Gb) {
            yVar = this.JO.JL;
            if (yVar != null) {
                yVar.nK();
            }
            this.Gf = false;
            this.JO.FJ = 10000;
            this.JO.mi();
            return;
        }
        this.JO.JA = (int) (a.a(this.Gb, this.FZ, false) + this.Gc);
        this.JO.invalidate();
        uVar = this.JO.JI;
        uVar.sendEmptyMessageAtTime(-100, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nG() {
        u uVar;
        w wVar;
        mj();
        if (this.FZ >= this.Gb) {
            wVar = this.JO.JM;
            if (wVar != null) {
                wVar.nJ();
            }
            this.Gf = false;
            this.JO.FJ = 10001;
            this.JO.mi();
            return;
        }
        this.JO.JA = (int) (a.a(this.Gb, this.FZ, false) + this.Gc);
        this.JO.invalidate();
        uVar = this.JO.JI;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nH() {
        u uVar;
        List<x> list;
        mj();
        if (this.FZ >= this.Gb) {
            list = this.JO.FW;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.mr();
                }
            }
            this.Gf = false;
            this.JO.FJ = 10004;
            this.JO.mi();
            return;
        }
        this.JO.JA = (int) (a.a(this.Gb, this.FZ, false) + this.Gc);
        this.JO.invalidate();
        uVar = this.JO.JI;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nI() {
        u uVar;
        List<x> list;
        mj();
        if (this.FZ <= this.Gb) {
            list = this.JO.FW;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.mr();
                }
            }
            this.Gf = false;
            this.JO.FJ = 10004;
            this.JO.mi();
            return;
        }
        this.JO.JA = (int) (a.a(this.Gb, this.FZ, false) + this.Gc);
        this.JO.invalidate();
        uVar = this.JO.JI;
        uVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<x> list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.JO.FW;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.mq();
            }
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        i = this.JO.JA;
        this.Gb = 0 - i;
        i2 = this.JO.JA;
        this.Gc = i2;
        uVar = this.JO.JI;
        uVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.Gb);
        Log.d("Animator", "@animateTopOpen " + f);
        uVar2 = this.JO.JI;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        List<x> list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.JO.FW;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.mq();
            }
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        i = this.JO.JA;
        this.Gb = 0 - i;
        i2 = this.JO.JA;
        this.Gc = i2;
        Log.d("Animator", "@animateBottomOpen " + this.Gb);
        Log.d("Animator", "@animateBottomOpen " + f);
        uVar = this.JO.JI;
        uVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        uVar2 = this.JO.JI;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Ge);
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
        yVar = this.JO.JL;
        if (yVar != null) {
            yVar.mo();
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        i = this.JO.FA;
        f2 = this.JO.Jw;
        float f3 = (-i) + f2;
        i2 = this.JO.JA;
        this.Gb = f3 - i2;
        i3 = this.JO.JA;
        this.Gc = i3;
        Log.d("Animator", "@animateTop " + this.Gb);
        Log.d("Animator", "@animateTop " + f);
        uVar = this.JO.JI;
        uVar.removeMessages(-100);
        uVar2 = this.JO.JI;
        uVar2.sendEmptyMessageAtTime(-100, this.Ge);
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
        wVar = this.JO.JM;
        if (wVar != null) {
            wVar.ms();
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        i = this.JO.FA;
        f2 = this.JO.Jy;
        float f3 = i - f2;
        i2 = this.JO.JA;
        this.Gb = f3 - i2;
        i3 = this.JO.JA;
        this.Gc = i3;
        Log.d("Animator", "@animateBottom " + this.Gb);
        Log.d("Animator", "@animateBottom " + f);
        uVar = this.JO.JI;
        uVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        uVar2 = this.JO.JI;
        uVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Ge);
    }
}
