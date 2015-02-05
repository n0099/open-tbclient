package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    float va;
    float vb;
    float vc;
    float vd;
    long ve;
    long vf;
    boolean vg;
    final /* synthetic */ VerticalTranslateLayout yU;

    private void iM() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.va = ((((float) (uptimeMillis - this.ve)) / 1000.0f) * this.vb) + this.va;
        this.ve = uptimeMillis;
        this.vf += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ki() {
        r rVar;
        v vVar;
        iM();
        if (this.va <= this.vc) {
            vVar = this.yU.yR;
            if (vVar != null) {
                vVar.kn();
            }
            this.vg = false;
            this.yU.uK = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.yU.iL();
            return;
        }
        this.yU.yG = (int) (a.a(this.vc, this.va, false) + this.vd);
        this.yU.invalidate();
        rVar = this.yU.yO;
        rVar.sendEmptyMessageAtTime(-100, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kj() {
        r rVar;
        t tVar;
        iM();
        if (this.va >= this.vc) {
            tVar = this.yU.yS;
            if (tVar != null) {
                tVar.km();
            }
            this.vg = false;
            this.yU.uK = 10001;
            this.yU.iL();
            return;
        }
        this.yU.yG = (int) (a.a(this.vc, this.va, false) + this.vd);
        this.yU.invalidate();
        rVar = this.yU.yO;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kk() {
        r rVar;
        List<u> list;
        iM();
        if (this.va >= this.vc) {
            list = this.yU.uX;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.iU();
                }
            }
            this.vg = false;
            this.yU.uK = 10004;
            this.yU.iL();
            return;
        }
        this.yU.yG = (int) (a.a(this.vc, this.va, false) + this.vd);
        this.yU.invalidate();
        rVar = this.yU.yO;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kl() {
        r rVar;
        List<u> list;
        iM();
        if (this.va <= this.vc) {
            list = this.yU.uX;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.iU();
                }
            }
            this.vg = false;
            this.yU.uK = 10004;
            this.yU.iL();
            return;
        }
        this.yU.yG = (int) (a.a(this.vc, this.va, false) + this.vd);
        this.yU.invalidate();
        rVar = this.yU.yO;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.yU.uX;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.iT();
            }
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        i = this.yU.yG;
        this.vc = 0 - i;
        i2 = this.yU.yG;
        this.vd = i2;
        rVar = this.yU.yO;
        rVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.vc);
        Log.d("Animator", "@animateTopOpen " + f);
        rVar2 = this.yU.yO;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.yU.uX;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.iT();
            }
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        i = this.yU.yG;
        this.vc = 0 - i;
        i2 = this.yU.yG;
        this.vd = i2;
        Log.d("Animator", "@animateBottomOpen " + this.vc);
        Log.d("Animator", "@animateBottomOpen " + f);
        rVar = this.yU.yO;
        rVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        rVar2 = this.yU.yO;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vf);
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
        vVar = this.yU.yR;
        if (vVar != null) {
            vVar.iR();
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        i = this.yU.uB;
        f2 = this.yU.yC;
        float f3 = (-i) + f2;
        i2 = this.yU.yG;
        this.vc = f3 - i2;
        i3 = this.yU.yG;
        this.vd = i3;
        Log.d("Animator", "@animateTop " + this.vc);
        Log.d("Animator", "@animateTop " + f);
        rVar = this.yU.yO;
        rVar.removeMessages(-100);
        rVar2 = this.yU.yO;
        rVar2.sendEmptyMessageAtTime(-100, this.vf);
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
        tVar = this.yU.yS;
        if (tVar != null) {
            tVar.iV();
        }
        this.vg = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.ve = uptimeMillis;
        this.vf = uptimeMillis + 16;
        this.vb = f;
        this.va = 0.0f;
        i = this.yU.uB;
        f2 = this.yU.yE;
        float f3 = i - f2;
        i2 = this.yU.yG;
        this.vc = f3 - i2;
        i3 = this.yU.yG;
        this.vd = i3;
        Log.d("Animator", "@animateBottom " + this.vc);
        Log.d("Animator", "@animateBottom " + f);
        rVar = this.yU.yO;
        rVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        rVar2 = this.yU.yO;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.vf);
    }
}
