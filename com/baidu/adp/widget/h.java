package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    final /* synthetic */ HorizontalTranslateLayout FW;
    float FX;
    float FY;
    float FZ;
    float Ga;
    long Gb;
    long Gc;
    boolean Gd;

    private void mj() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.FX = ((((float) (uptimeMillis - this.Gb)) / 1000.0f) * this.FY) + this.FX;
        this.Gb = uptimeMillis;
        this.Gc += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mk() {
        g gVar;
        j jVar;
        mj();
        if (this.FX <= this.FZ) {
            jVar = this.FW.FS;
            if (jVar != null) {
                jVar.mp();
            }
            this.Gd = false;
            this.FW.FH = 10000;
            this.FW.mi();
            return;
        }
        this.FW.FC = (int) (ab.a(this.FZ, this.FX, false) + this.Ga);
        this.FW.invalidate();
        gVar = this.FW.FP;
        gVar.sendEmptyMessageAtTime(-100, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ml() {
        g gVar;
        l lVar;
        mj();
        if (this.FX >= this.FZ) {
            lVar = this.FW.FT;
            if (lVar != null) {
                lVar.mt();
            }
            this.Gd = false;
            this.FW.FH = 10001;
            this.FW.mi();
            return;
        }
        this.FW.FC = (int) (ab.a(this.FZ, this.FX, false) + this.Ga);
        this.FW.invalidate();
        gVar = this.FW.FP;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mm() {
        g gVar;
        List<k> list;
        mj();
        if (this.FX >= this.FZ) {
            list = this.FW.FU;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.mr();
                }
            }
            this.Gd = false;
            this.FW.FH = 10004;
            this.FW.mi();
            return;
        }
        this.FW.FC = (int) (ab.a(this.FZ, this.FX, false) + this.Ga);
        this.FW.invalidate();
        gVar = this.FW.FP;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mn() {
        g gVar;
        List<k> list;
        mj();
        if (this.FX <= this.FZ) {
            list = this.FW.FU;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.mr();
                }
            }
            this.Gd = false;
            this.FW.FH = 10004;
            this.FW.mi();
            return;
        }
        this.FW.FC = (int) (ab.a(this.FZ, this.FX, false) + this.Ga);
        this.FW.invalidate();
        gVar = this.FW.FP;
        gVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.FW.FU;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.mq();
            }
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        i = this.FW.FC;
        this.FZ = 0 - i;
        i2 = this.FW.FC;
        this.Ga = i2;
        gVar = this.FW.FP;
        gVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.FZ);
        Log.d("Animator", "@animateTopOpen " + f);
        gVar2 = this.FW.FP;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.FW.FU;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.mq();
            }
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        i = this.FW.FC;
        this.FZ = 0 - i;
        i2 = this.FW.FC;
        this.Ga = i2;
        Log.d("Animator", "@animateBottomOpen " + this.FZ);
        Log.d("Animator", "@animateBottomOpen " + f);
        gVar = this.FW.FP;
        gVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        gVar2 = this.FW.FP;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        j jVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        jVar = this.FW.FS;
        if (jVar != null) {
            jVar.mo();
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        f2 = this.FW.FA;
        float f3 = (-this.FW.getMeasuredWidth()) + f2;
        i = this.FW.FC;
        this.FZ = f3 - i;
        i2 = this.FW.FC;
        this.Ga = i2;
        Log.d("Animator", "@animateTop " + this.FZ);
        Log.d("Animator", "@animateTop " + f);
        gVar = this.FW.FP;
        gVar.removeMessages(-100);
        gVar2 = this.FW.FP;
        gVar2.sendEmptyMessageAtTime(-100, this.Gc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        l lVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        lVar = this.FW.FT;
        if (lVar != null) {
            lVar.ms();
        }
        this.Gd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.Gb = uptimeMillis;
        this.Gc = uptimeMillis + 16;
        this.FY = f;
        this.FX = 0.0f;
        f2 = this.FW.FB;
        float measuredWidth = this.FW.getMeasuredWidth() - f2;
        i = this.FW.FC;
        this.FZ = measuredWidth - i;
        i2 = this.FW.FC;
        this.Ga = i2;
        Log.d("Animator", "@animateBottom " + this.FZ);
        Log.d("Animator", "@animateBottom " + f);
        gVar = this.FW.FP;
        gVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        gVar2 = this.FW.FP;
        gVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.Gc);
    }
}
