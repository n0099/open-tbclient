package com.baidu.nadcore.webviewx;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.webviewx.container.base.AbsContainer;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.tieba.R;
import com.baidu.tieba.bm0;
import com.baidu.tieba.d91;
import com.baidu.tieba.i91;
import com.baidu.tieba.j91;
import com.baidu.tieba.m91;
import com.baidu.tieba.n91;
/* loaded from: classes2.dex */
public class AdWebActivity extends BaseActivity implements SlideInterceptor, i91, j91 {
    public final AbsContainer u = d91.a.b(this, this, bm0.b().a().a("key_webview_core_type", 0));

    @Override // com.baidu.tieba.i91
    public boolean d() {
        return false;
    }

    @Override // com.baidu.tieba.j91
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tieba.i91
    @NonNull
    public Activity getActivity() {
        return this;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
        this.u.p();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        super.F1();
        this.u.q();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        this.u.s();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void J1() {
        super.J1();
        this.u.t();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void K1() {
        super.K1();
        this.u.u();
    }

    @Override // com.baidu.tieba.i91
    public void c() {
        finish();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1(Bundle bundle) {
        super.B1(bundle);
        if (!this.u.b()) {
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        this.u.x("1");
        this.u.o();
        m91.f().a(getActivity());
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void G1(@Nullable Bundle bundle) {
        super.G1(bundle);
        this.u.r(bundle);
    }

    @Override // com.baidu.nadcore.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.u.j()) {
            return false;
        }
        return this.u.a(motionEvent);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean L1(Bundle bundle) {
        if (!super.L1(bundle)) {
            return false;
        }
        requestWindowFeature(1);
        if (n91.b.a().a(getIntent())) {
            R1(0, 0, 0, 0);
            forceActivityTransparent(true);
        } else {
            R1(R.anim.nad_slide_in_from_right, R.anim.nad_slide_out_to_left, R.anim.nad_slide_in_from_left, R.anim.nad_slide_out_to_right);
        }
        if (Build.VERSION.SDK_INT == 26) {
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
        } else {
            O1(true, this);
            U1(true);
        }
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.u.m(i, i2, intent);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.u.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
