package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    final /* synthetic */ HorizontalTranslateLayout uW;
    float uX;
    float uY;
    float uZ;
    float va;
    long vb;
    long vc;
    boolean vd;

    private void iS() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.uX = ((((float) (uptimeMillis - this.vb)) / 1000.0f) * this.uY) + this.uX;
        this.vb = uptimeMillis;
        this.vc += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iT() {
        f fVar;
        i iVar;
        iS();
        if (this.uX <= this.uZ) {
            iVar = this.uW.uS;
            if (iVar != null) {
                iVar.iY();
            }
            this.vd = false;
            this.uW.uH = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.uW.iR();
            return;
        }
        this.uW.uC = (int) (y.a(this.uZ, this.uX, false) + this.va);
        this.uW.invalidate();
        fVar = this.uW.uP;
        fVar.sendEmptyMessageAtTime(-100, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iU() {
        f fVar;
        k kVar;
        iS();
        if (this.uX >= this.uZ) {
            kVar = this.uW.uT;
            if (kVar != null) {
                kVar.jc();
            }
            this.vd = false;
            this.uW.uH = 10001;
            this.uW.iR();
            return;
        }
        this.uW.uC = (int) (y.a(this.uZ, this.uX, false) + this.va);
        this.uW.invalidate();
        fVar = this.uW.uP;
        fVar.sendEmptyMessageAtTime(-101, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iV() {
        f fVar;
        List<j> list;
        iS();
        if (this.uX >= this.uZ) {
            list = this.uW.uU;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.ja();
                }
            }
            this.vd = false;
            this.uW.uH = 10004;
            this.uW.iR();
            return;
        }
        this.uW.uC = (int) (y.a(this.uZ, this.uX, false) + this.va);
        this.uW.invalidate();
        fVar = this.uW.uP;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iW() {
        f fVar;
        List<j> list;
        iS();
        if (this.uX <= this.uZ) {
            list = this.uW.uU;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.ja();
                }
            }
            this.vd = false;
            this.uW.uH = 10004;
            this.uW.iR();
            return;
        }
        this.uW.uC = (int) (y.a(this.uZ, this.uX, false) + this.va);
        this.uW.invalidate();
        fVar = this.uW.uP;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.uW.uU;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.iZ();
            }
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        i = this.uW.uC;
        this.uZ = 0 - i;
        i2 = this.uW.uC;
        this.va = i2;
        fVar = this.uW.uP;
        fVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.uZ);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.uW.uP;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.uW.uU;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.iZ();
            }
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        i = this.uW.uC;
        this.uZ = 0 - i;
        i2 = this.uW.uC;
        this.va = i2;
        Log.d("Animator", "@animateBottomOpen " + this.uZ);
        Log.d("Animator", "@animateBottomOpen " + f);
        fVar = this.uW.uP;
        fVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        fVar2 = this.uW.uP;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        i iVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        iVar = this.uW.uS;
        if (iVar != null) {
            iVar.iX();
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        f2 = this.uW.uA;
        float f3 = (-this.uW.getMeasuredWidth()) + f2;
        i = this.uW.uC;
        this.uZ = f3 - i;
        i2 = this.uW.uC;
        this.va = i2;
        Log.d("Animator", "@animateTop " + this.uZ);
        Log.d("Animator", "@animateTop " + f);
        fVar = this.uW.uP;
        fVar.removeMessages(-100);
        fVar2 = this.uW.uP;
        fVar2.sendEmptyMessageAtTime(-100, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        k kVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        kVar = this.uW.uT;
        if (kVar != null) {
            kVar.jb();
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        f2 = this.uW.uB;
        float measuredWidth = this.uW.getMeasuredWidth() - f2;
        i = this.uW.uC;
        this.uZ = measuredWidth - i;
        i2 = this.uW.uC;
        this.va = i2;
        Log.d("Animator", "@animateBottom " + this.uZ);
        Log.d("Animator", "@animateBottom " + f);
        fVar = this.uW.uP;
        fVar.removeMessages(-101);
        fVar2 = this.uW.uP;
        fVar2.sendEmptyMessageAtTime(-101, this.vc);
    }
}
