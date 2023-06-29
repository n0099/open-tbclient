package com.baidu.nadcore.webviewx.container.base;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.baidu.tieba.a81;
import com.baidu.tieba.d81;
import com.baidu.tieba.pb1;
import com.baidu.tieba.tb1;
import com.baidu.tieba.tn0;
import com.baidu.tieba.xn0;
/* loaded from: classes3.dex */
public abstract class AbsContainer implements ComponentCallbacks, KeyEvent.Callback, ActivityCompat.OnRequestPermissionsResultCallback, d81 {
    public pb1 a;
    public boolean b = true;
    public final Object c = new Object();

    public abstract boolean a(MotionEvent motionEvent);

    public abstract boolean b();

    public abstract View e();

    public abstract int h();

    public abstract boolean j();

    public abstract void l(String str);

    public void m(int i, int i2, Intent intent) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void q() {
    }

    public void r(Bundle bundle) {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public abstract void x(String str);

    public abstract void z();

    /* loaded from: classes3.dex */
    public class a extends xn0<a81> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xn0
        public void onEvent(@NonNull a81 a81Var) {
            if (TextUtils.isEmpty(a81Var.a)) {
                return;
            }
            AbsContainer.this.l(a81Var.a);
        }
    }

    public AbsContainer(@NonNull pb1 pb1Var) {
        this.a = pb1Var;
    }

    public void w(View view2) {
        pb1 pb1Var = this.a;
        if (pb1Var == null || !pb1Var.f()) {
            getActivity().setContentView(view2);
        }
    }

    public void y(boolean z) {
        this.b = z;
    }

    public void c() {
        this.a.d();
    }

    @NonNull
    public final Context d() {
        return tb1.b();
    }

    @NonNull
    public final Intent f() {
        return this.a.getIntent();
    }

    @Override // com.baidu.tieba.d81
    public void g() {
        z();
    }

    @NonNull
    public final Activity getActivity() {
        return this.a.getActivity();
    }

    @NonNull
    public final Resources getResources() {
        return getActivity().getResources();
    }

    @NonNull
    public final Window i() {
        return getActivity().getWindow();
    }

    @Override // com.baidu.tieba.d81
    public void k() {
        c();
    }

    public void o() {
        v();
    }

    public void p() {
        tn0.a().unregister(this.c);
    }

    public final void v() {
        tn0.a().c(this.c, 1, new a(a81.class));
    }
}
