package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    float sK;
    float sL;
    float sM;
    float sN;
    long sO;
    long sP;
    boolean sQ;
    final /* synthetic */ VerticalTranslateLayout wV;

    private void gV() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sK = ((((float) (uptimeMillis - this.sO)) / 1000.0f) * this.sL) + this.sK;
        this.sO = uptimeMillis;
        this.sP += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iA() {
        r rVar;
        v vVar;
        gV();
        if (this.sK <= this.sM) {
            vVar = this.wV.wS;
            if (vVar != null) {
                vVar.iF();
            }
            this.sQ = false;
            this.wV.su = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.wV.gU();
            return;
        }
        this.wV.wH = (int) (a.a(this.sM, this.sK, false) + this.sN);
        this.wV.invalidate();
        rVar = this.wV.wP;
        rVar.sendEmptyMessageAtTime(-100, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iB() {
        r rVar;
        t tVar;
        gV();
        if (this.sK >= this.sM) {
            tVar = this.wV.wT;
            if (tVar != null) {
                tVar.iE();
            }
            this.sQ = false;
            this.wV.su = 10001;
            this.wV.gU();
            return;
        }
        this.wV.wH = (int) (a.a(this.sM, this.sK, false) + this.sN);
        this.wV.invalidate();
        rVar = this.wV.wP;
        rVar.sendEmptyMessageAtTime(-101, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iC() {
        r rVar;
        List<u> list;
        gV();
        if (this.sK >= this.sM) {
            list = this.wV.sH;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.hd();
                }
            }
            this.sQ = false;
            this.wV.su = 10004;
            this.wV.gU();
            return;
        }
        this.wV.wH = (int) (a.a(this.sM, this.sK, false) + this.sN);
        this.wV.invalidate();
        rVar = this.wV.wP;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iD() {
        r rVar;
        List<u> list;
        gV();
        if (this.sK <= this.sM) {
            list = this.wV.sH;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.hd();
                }
            }
            this.sQ = false;
            this.wV.su = 10004;
            this.wV.gU();
            return;
        }
        this.wV.wH = (int) (a.a(this.sM, this.sK, false) + this.sN);
        this.wV.invalidate();
        rVar = this.wV.wP;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.wV.sH;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.hc();
            }
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        i = this.wV.wH;
        this.sM = 0 - i;
        i2 = this.wV.wH;
        this.sN = i2;
        rVar = this.wV.wP;
        rVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.sM);
        Log.d("Animator", "@animateTopOpen " + f);
        rVar2 = this.wV.wP;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.wV.sH;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.hc();
            }
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        i = this.wV.wH;
        this.sM = 0 - i;
        i2 = this.wV.wH;
        this.sN = i2;
        Log.d("Animator", "@animateBottomOpen " + this.sM);
        Log.d("Animator", "@animateBottomOpen " + f);
        rVar = this.wV.wP;
        rVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        rVar2 = this.wV.wP;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        v vVar;
        int i;
        float f2;
        int i2;
        int i3;
        r rVar;
        r rVar2;
        vVar = this.wV.wS;
        if (vVar != null) {
            vVar.ha();
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        i = this.wV.sk;
        f2 = this.wV.wD;
        float f3 = (-i) + f2;
        i2 = this.wV.wH;
        this.sM = f3 - i2;
        i3 = this.wV.wH;
        this.sN = i3;
        Log.d("Animator", "@animateTop " + this.sM);
        Log.d("Animator", "@animateTop " + f);
        rVar = this.wV.wP;
        rVar.removeMessages(-100);
        rVar2 = this.wV.wP;
        rVar2.sendEmptyMessageAtTime(-100, this.sP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f) {
        t tVar;
        int i;
        float f2;
        int i2;
        int i3;
        r rVar;
        r rVar2;
        tVar = this.wV.wT;
        if (tVar != null) {
            tVar.he();
        }
        this.sQ = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.sO = uptimeMillis;
        this.sP = uptimeMillis + 16;
        this.sL = f;
        this.sK = 0.0f;
        i = this.wV.sk;
        f2 = this.wV.wF;
        float f3 = i - f2;
        i2 = this.wV.wH;
        this.sM = f3 - i2;
        i3 = this.wV.wH;
        this.sN = i3;
        Log.d("Animator", "@animateBottom " + this.sM);
        Log.d("Animator", "@animateBottom " + f);
        rVar = this.wV.wP;
        rVar.removeMessages(-101);
        rVar2 = this.wV.wP;
        rVar2.sendEmptyMessageAtTime(-101, this.sP);
    }
}
