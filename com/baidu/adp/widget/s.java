package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    float vd;
    float ve;
    float vf;
    float vg;
    long vh;
    long vi;
    boolean vj;
    final /* synthetic */ VerticalTranslateLayout yX;

    private void iT() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vd = ((((float) (uptimeMillis - this.vh)) / 1000.0f) * this.ve) + this.vd;
        this.vh = uptimeMillis;
        this.vi += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kp() {
        r rVar;
        v vVar;
        iT();
        if (this.vd <= this.vf) {
            vVar = this.yX.yU;
            if (vVar != null) {
                vVar.ku();
            }
            this.vj = false;
            this.yX.uN = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.yX.iS();
            return;
        }
        this.yX.yJ = (int) (a.a(this.vf, this.vd, false) + this.vg);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(-100, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kq() {
        r rVar;
        t tVar;
        iT();
        if (this.vd >= this.vf) {
            tVar = this.yX.yV;
            if (tVar != null) {
                tVar.kt();
            }
            this.vj = false;
            this.yX.uN = 10001;
            this.yX.iS();
            return;
        }
        this.yX.yJ = (int) (a.a(this.vf, this.vd, false) + this.vg);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kr() {
        r rVar;
        List<u> list;
        iT();
        if (this.vd >= this.vf) {
            list = this.yX.va;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.jb();
                }
            }
            this.vj = false;
            this.yX.uN = 10004;
            this.yX.iS();
            return;
        }
        this.yX.yJ = (int) (a.a(this.vf, this.vd, false) + this.vg);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ks() {
        r rVar;
        List<u> list;
        iT();
        if (this.vd <= this.vf) {
            list = this.yX.va;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.jb();
                }
            }
            this.vj = false;
            this.yX.uN = 10004;
            this.yX.iS();
            return;
        }
        this.yX.yJ = (int) (a.a(this.vf, this.vd, false) + this.vg);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.yX.va;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.ja();
            }
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        i = this.yX.yJ;
        this.vf = 0 - i;
        i2 = this.yX.yJ;
        this.vg = i2;
        rVar = this.yX.yR;
        rVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.vf);
        Log.d("Animator", "@animateTopOpen " + f);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.yX.va;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.ja();
            }
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        i = this.yX.yJ;
        this.vf = 0 - i;
        i2 = this.yX.yJ;
        this.vg = i2;
        Log.d("Animator", "@animateBottomOpen " + this.vf);
        Log.d("Animator", "@animateBottomOpen " + f);
        rVar = this.yX.yR;
        rVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f) {
        v vVar;
        int i;
        float f2;
        int i2;
        int i3;
        r rVar;
        r rVar2;
        vVar = this.yX.yU;
        if (vVar != null) {
            vVar.iY();
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        i = this.yX.uE;
        f2 = this.yX.yF;
        float f3 = (-i) + f2;
        i2 = this.yX.yJ;
        this.vf = f3 - i2;
        i3 = this.yX.yJ;
        this.vg = i3;
        Log.d("Animator", "@animateTop " + this.vf);
        Log.d("Animator", "@animateTop " + f);
        rVar = this.yX.yR;
        rVar.removeMessages(-100);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(-100, this.vi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f) {
        t tVar;
        int i;
        float f2;
        int i2;
        int i3;
        r rVar;
        r rVar2;
        tVar = this.yX.yV;
        if (tVar != null) {
            tVar.jc();
        }
        this.vj = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vh = uptimeMillis;
        this.vi = uptimeMillis + 16;
        this.ve = f;
        this.vd = 0.0f;
        i = this.yX.uE;
        f2 = this.yX.yH;
        float f3 = i - f2;
        i2 = this.yX.yJ;
        this.vf = f3 - i2;
        i3 = this.yX.yJ;
        this.vg = i3;
        Log.d("Animator", "@animateBottom " + this.vf);
        Log.d("Animator", "@animateBottom " + f);
        rVar = this.yX.yR;
        rVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vi);
    }
}
