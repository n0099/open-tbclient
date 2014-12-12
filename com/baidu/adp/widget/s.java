package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    float uX;
    float uY;
    float uZ;
    float va;
    long vb;
    long vc;
    boolean vd;
    final /* synthetic */ VerticalTranslateLayout yX;

    private void iS() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.uX = ((((float) (uptimeMillis - this.vb)) / 1000.0f) * this.uY) + this.uX;
        this.vb = uptimeMillis;
        this.vc += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kp() {
        r rVar;
        v vVar;
        iS();
        if (this.uX <= this.uZ) {
            vVar = this.yX.yU;
            if (vVar != null) {
                vVar.ku();
            }
            this.vd = false;
            this.yX.uH = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.yX.iR();
            return;
        }
        this.yX.yJ = (int) (a.a(this.uZ, this.uX, false) + this.va);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(-100, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kq() {
        r rVar;
        t tVar;
        iS();
        if (this.uX >= this.uZ) {
            tVar = this.yX.yV;
            if (tVar != null) {
                tVar.kt();
            }
            this.vd = false;
            this.yX.uH = 10001;
            this.yX.iR();
            return;
        }
        this.yX.yJ = (int) (a.a(this.uZ, this.uX, false) + this.va);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(-101, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kr() {
        r rVar;
        List<u> list;
        iS();
        if (this.uX >= this.uZ) {
            list = this.yX.uU;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.ja();
                }
            }
            this.vd = false;
            this.yX.uH = 10004;
            this.yX.iR();
            return;
        }
        this.yX.yJ = (int) (a.a(this.uZ, this.uX, false) + this.va);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ks() {
        r rVar;
        List<u> list;
        iS();
        if (this.uX <= this.uZ) {
            list = this.yX.uU;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.ja();
                }
            }
            this.vd = false;
            this.yX.uH = 10004;
            this.yX.iR();
            return;
        }
        this.yX.yJ = (int) (a.a(this.uZ, this.uX, false) + this.va);
        this.yX.invalidate();
        rVar = this.yX.yR;
        rVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.yX.uU;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.iZ();
            }
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        i = this.yX.yJ;
        this.uZ = 0 - i;
        i2 = this.yX.yJ;
        this.va = i2;
        rVar = this.yX.yR;
        rVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.uZ);
        Log.d("Animator", "@animateTopOpen " + f);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.vc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f) {
        List<u> list;
        int i;
        int i2;
        r rVar;
        r rVar2;
        list = this.yX.uU;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.iZ();
            }
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        i = this.yX.yJ;
        this.uZ = 0 - i;
        i2 = this.yX.yJ;
        this.va = i2;
        Log.d("Animator", "@animateBottomOpen " + this.uZ);
        Log.d("Animator", "@animateBottomOpen " + f);
        rVar = this.yX.yR;
        rVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.vc);
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
            vVar.iX();
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        i = this.yX.uy;
        f2 = this.yX.yF;
        float f3 = (-i) + f2;
        i2 = this.yX.yJ;
        this.uZ = f3 - i2;
        i3 = this.yX.yJ;
        this.va = i3;
        Log.d("Animator", "@animateTop " + this.uZ);
        Log.d("Animator", "@animateTop " + f);
        rVar = this.yX.yR;
        rVar.removeMessages(-100);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(-100, this.vc);
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
            tVar.jb();
        }
        this.vd = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vb = uptimeMillis;
        this.vc = uptimeMillis + 16;
        this.uY = f;
        this.uX = 0.0f;
        i = this.yX.uy;
        f2 = this.yX.yH;
        float f3 = i - f2;
        i2 = this.yX.yJ;
        this.uZ = f3 - i2;
        i3 = this.yX.yJ;
        this.va = i3;
        Log.d("Animator", "@animateBottom " + this.uZ);
        Log.d("Animator", "@animateBottom " + f);
        rVar = this.yX.yR;
        rVar.removeMessages(-101);
        rVar2 = this.yX.yR;
        rVar2.sendEmptyMessageAtTime(-101, this.vc);
    }
}
