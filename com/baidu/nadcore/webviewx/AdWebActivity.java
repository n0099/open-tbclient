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
import com.baidu.tieba.ca1;
import com.baidu.tieba.da1;
import com.baidu.tieba.ga1;
import com.baidu.tieba.ha1;
import com.baidu.tieba.vm0;
import com.baidu.tieba.x91;
/* loaded from: classes3.dex */
public class AdWebActivity extends BaseActivity implements SlideInterceptor, ca1, da1 {
    public final AbsContainer u = x91.a.b(this, this, vm0.b().a().a("key_webview_core_type", 0));

    @Override // com.baidu.tieba.ca1
    public boolean f() {
        return false;
    }

    @Override // com.baidu.tieba.da1
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tieba.ca1
    @NonNull
    public Activity getActivity() {
        return this;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E1() {
        super.E1();
        this.u.p();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void H1() {
        super.H1();
        this.u.q();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void K1() {
        super.K1();
        this.u.s();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void L1() {
        super.L1();
        this.u.t();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void M1() {
        super.M1();
        this.u.u();
    }

    @Override // com.baidu.tieba.ca1
    public void d() {
        finish();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1(Bundle bundle) {
        super.D1(bundle);
        if (!this.u.b()) {
            if (!isFinishing()) {
                finish();
                return;
            }
            return;
        }
        this.u.x("1");
        this.u.o();
        ga1.f().a(getActivity());
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1(@Nullable Bundle bundle) {
        super.I1(bundle);
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
    public boolean N1(Bundle bundle) {
        if (!super.N1(bundle)) {
            return false;
        }
        requestWindowFeature(1);
        if (ha1.b.a().a(getIntent())) {
            T1(0, 0, 0, 0);
            forceActivityTransparent(true);
        } else {
            T1(R.anim.nad_slide_in_from_right, R.anim.nad_slide_out_to_left, R.anim.nad_slide_in_from_left, R.anim.nad_slide_out_to_right);
        }
        if (Build.VERSION.SDK_INT == 26) {
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
        } else {
            Q1(true, this);
            W1(true);
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
