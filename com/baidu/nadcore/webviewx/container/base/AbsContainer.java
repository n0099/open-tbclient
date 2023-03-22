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
import com.baidu.tieba.i91;
import com.baidu.tieba.m91;
import com.baidu.tieba.ml0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.t51;
import com.baidu.tieba.w51;
/* loaded from: classes2.dex */
public abstract class AbsContainer implements ComponentCallbacks, KeyEvent.Callback, ActivityCompat.OnRequestPermissionsResultCallback, w51 {
    public i91 a;
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

    /* loaded from: classes2.dex */
    public class a extends ql0<t51> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ql0
        public void onEvent(@NonNull t51 t51Var) {
            if (TextUtils.isEmpty(t51Var.a)) {
                return;
            }
            AbsContainer.this.l(t51Var.a);
        }
    }

    public AbsContainer(@NonNull i91 i91Var) {
        this.a = i91Var;
    }

    public void w(View view2) {
        i91 i91Var = this.a;
        if (i91Var == null || !i91Var.d()) {
            getActivity().setContentView(view2);
        }
    }

    public void y(boolean z) {
        this.b = z;
    }

    public void c() {
        this.a.c();
    }

    @NonNull
    public final Context d() {
        return m91.b();
    }

    @NonNull
    public final Intent f() {
        return this.a.getIntent();
    }

    @Override // com.baidu.tieba.w51
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

    @Override // com.baidu.tieba.w51
    public void k() {
        c();
    }

    public void o() {
        v();
    }

    public void p() {
        ml0.a().unregister(this.c);
    }

    public final void v() {
        ml0.a().c(this.c, 1, new a(t51.class));
    }
}
