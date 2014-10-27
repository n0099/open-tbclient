package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    final /* synthetic */ HorizontalTranslateLayout sJ;
    float sK;
    float sL;
    float sM;
    float sN;
    long sO;
    long sP;
    boolean sQ;

    private void gV() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sK = ((((float) (uptimeMillis - this.sO)) / 1000.0f) * this.sL) + this.sK;
        this.sO = uptimeMillis;
        this.sP += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gW() {
        f fVar;
        i iVar;
        gV();
        if (this.sK <= this.sM) {
            iVar = this.sJ.sF;
            if (iVar != null) {
                iVar.hb();
            }
            this.sQ = false;
            this.sJ.su = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.sJ.gU();
            return;
        }
        this.sJ.so = (int) (y.a(this.sM, this.sK, false) + this.sN);
        this.sJ.invalidate();
        fVar = this.sJ.sC;
        fVar.sendEmptyMessageAtTime(-100, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gX() {
        f fVar;
        k kVar;
        gV();
        if (this.sK >= this.sM) {
            kVar = this.sJ.sG;
            if (kVar != null) {
                kVar.hf();
            }
            this.sQ = false;
            this.sJ.su = 10001;
            this.sJ.gU();
            return;
        }
        this.sJ.so = (int) (y.a(this.sM, this.sK, false) + this.sN);
        this.sJ.invalidate();
        fVar = this.sJ.sC;
        fVar.sendEmptyMessageAtTime(-101, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gY() {
        f fVar;
        List<j> list;
        gV();
        if (this.sK >= this.sM) {
            list = this.sJ.sH;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.hd();
                }
            }
            this.sQ = false;
            this.sJ.su = 10004;
            this.sJ.gU();
            return;
        }
        this.sJ.so = (int) (y.a(this.sM, this.sK, false) + this.sN);
        this.sJ.invalidate();
        fVar = this.sJ.sC;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gZ() {
        f fVar;
        List<j> list;
        gV();
        if (this.sK <= this.sM) {
            list = this.sJ.sH;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.hd();
                }
            }
            this.sQ = false;
            this.sJ.su = 10004;
            this.sJ.gU();
            return;
        }
        this.sJ.so = (int) (y.a(this.sM, this.sK, false) + this.sN);
        this.sJ.invalidate();
        fVar = this.sJ.sC;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.sJ.sH;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.hc();
            }
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        i = this.sJ.so;
        this.sM = 0 - i;
        i2 = this.sJ.so;
        this.sN = i2;
        fVar = this.sJ.sC;
        fVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.sM);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.sJ.sC;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.sJ.sH;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.hc();
            }
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        i = this.sJ.so;
        this.sM = 0 - i;
        i2 = this.sJ.so;
        this.sN = i2;
        Log.d("Animator", "@animateBottomOpen " + this.sM);
        Log.d("Animator", "@animateBottomOpen " + f);
        fVar = this.sJ.sC;
        fVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        fVar2 = this.sJ.sC;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        i iVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        iVar = this.sJ.sF;
        if (iVar != null) {
            iVar.ha();
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        f2 = this.sJ.sm;
        float f3 = (-this.sJ.getMeasuredWidth()) + f2;
        i = this.sJ.so;
        this.sM = f3 - i;
        i2 = this.sJ.so;
        this.sN = i2;
        Log.d("Animator", "@animateTop " + this.sM);
        Log.d("Animator", "@animateTop " + f);
        fVar = this.sJ.sC;
        fVar.removeMessages(-100);
        fVar2 = this.sJ.sC;
        fVar2.sendEmptyMessageAtTime(-100, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        k kVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        kVar = this.sJ.sG;
        if (kVar != null) {
            kVar.he();
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        f2 = this.sJ.sn;
        float measuredWidth = this.sJ.getMeasuredWidth() - f2;
        i = this.sJ.so;
        this.sM = measuredWidth - i;
        i2 = this.sJ.so;
        this.sN = i2;
        Log.d("Animator", "@animateBottom " + this.sM);
        Log.d("Animator", "@animateBottom " + f);
        fVar = this.sJ.sC;
        fVar.removeMessages(-101);
        fVar2 = this.sJ.sC;
        fVar2.sendEmptyMessageAtTime(-101, this.sP);
    }
}
