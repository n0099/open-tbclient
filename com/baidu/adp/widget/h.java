package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    final /* synthetic */ HorizontalTranslateLayout FY;
    float FZ;
    float Ga;
    float Gb;
    float Gc;
    long Gd;
    long Ge;
    boolean Gf;

    private void mj() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FZ = ((((float) (uptimeMillis - this.Gd)) / 1000.0f) * this.Ga) + this.FZ;
        this.Gd = uptimeMillis;
        this.Ge += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mk() {
        g gVar;
        j jVar;
        mj();
        if (this.FZ <= this.Gb) {
            jVar = this.FY.FU;
            if (jVar != null) {
                jVar.mp();
            }
            this.Gf = false;
            this.FY.FJ = 10000;
            this.FY.mi();
            return;
        }
        this.FY.FE = (int) (ab.a(this.Gb, this.FZ, false) + this.Gc);
        this.FY.invalidate();
        gVar = this.FY.FR;
        gVar.sendEmptyMessageAtTime(-100, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ml() {
        g gVar;
        l lVar;
        mj();
        if (this.FZ >= this.Gb) {
            lVar = this.FY.FV;
            if (lVar != null) {
                lVar.mt();
            }
            this.Gf = false;
            this.FY.FJ = 10001;
            this.FY.mi();
            return;
        }
        this.FY.FE = (int) (ab.a(this.Gb, this.FZ, false) + this.Gc);
        this.FY.invalidate();
        gVar = this.FY.FR;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mm() {
        g gVar;
        List<k> list;
        mj();
        if (this.FZ >= this.Gb) {
            list = this.FY.FW;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.mr();
                }
            }
            this.Gf = false;
            this.FY.FJ = 10004;
            this.FY.mi();
            return;
        }
        this.FY.FE = (int) (ab.a(this.Gb, this.FZ, false) + this.Gc);
        this.FY.invalidate();
        gVar = this.FY.FR;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mn() {
        g gVar;
        List<k> list;
        mj();
        if (this.FZ <= this.Gb) {
            list = this.FY.FW;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.mr();
                }
            }
            this.Gf = false;
            this.FY.FJ = 10004;
            this.FY.mi();
            return;
        }
        this.FY.FE = (int) (ab.a(this.Gb, this.FZ, false) + this.Gc);
        this.FY.invalidate();
        gVar = this.FY.FR;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.FY.FW;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.mq();
            }
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        i = this.FY.FE;
        this.Gb = 0 - i;
        i2 = this.FY.FE;
        this.Gc = i2;
        gVar = this.FY.FR;
        gVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.Gb);
        Log.d("Animator", "@animateTopOpen " + f);
        gVar2 = this.FY.FR;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.FY.FW;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.mq();
            }
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        i = this.FY.FE;
        this.Gb = 0 - i;
        i2 = this.FY.FE;
        this.Gc = i2;
        Log.d("Animator", "@animateBottomOpen " + this.Gb);
        Log.d("Animator", "@animateBottomOpen " + f);
        gVar = this.FY.FR;
        gVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        gVar2 = this.FY.FR;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        j jVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        jVar = this.FY.FU;
        if (jVar != null) {
            jVar.mo();
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        f2 = this.FY.FC;
        float f3 = (-this.FY.getMeasuredWidth()) + f2;
        i = this.FY.FE;
        this.Gb = f3 - i;
        i2 = this.FY.FE;
        this.Gc = i2;
        Log.d("Animator", "@animateTop " + this.Gb);
        Log.d("Animator", "@animateTop " + f);
        gVar = this.FY.FR;
        gVar.removeMessages(-100);
        gVar2 = this.FY.FR;
        gVar2.sendEmptyMessageAtTime(-100, this.Ge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        l lVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        lVar = this.FY.FV;
        if (lVar != null) {
            lVar.ms();
        }
        this.Gf = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gd = uptimeMillis;
        this.Ge = uptimeMillis + 16;
        this.Ga = f;
        this.FZ = 0.0f;
        f2 = this.FY.FD;
        float measuredWidth = this.FY.getMeasuredWidth() - f2;
        i = this.FY.FE;
        this.Gb = measuredWidth - i;
        i2 = this.FY.FE;
        this.Gc = i2;
        Log.d("Animator", "@animateBottom " + this.Gb);
        Log.d("Animator", "@animateBottom " + f);
        gVar = this.FY.FR;
        gVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        gVar2 = this.FY.FR;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Ge);
    }
}
