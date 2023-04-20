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
import com.baidu.tieba.k91;
import com.baidu.tieba.o91;
import com.baidu.tieba.ol0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.v51;
import com.baidu.tieba.y51;
/* loaded from: classes2.dex */
public abstract class AbsContainer implements ComponentCallbacks, KeyEvent.Callback, ActivityCompat.OnRequestPermissionsResultCallback, y51 {
    public k91 a;
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
    public class a extends sl0<v51> {
        public a(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sl0
        public void onEvent(@NonNull v51 v51Var) {
            if (TextUtils.isEmpty(v51Var.a)) {
                return;
            }
            AbsContainer.this.l(v51Var.a);
        }
    }

    public AbsContainer(@NonNull k91 k91Var) {
        this.a = k91Var;
    }

    public void w(View view2) {
        k91 k91Var = this.a;
        if (k91Var == null || !k91Var.f()) {
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
        return o91.b();
    }

    @NonNull
    public final Intent f() {
        return this.a.getIntent();
    }

    @Override // com.baidu.tieba.y51
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

    @Override // com.baidu.tieba.y51
    public void k() {
        c();
    }

    public void o() {
        v();
    }

    public void p() {
        ol0.a().unregister(this.c);
    }

    public final void v() {
        ol0.a().c(this.c, 1, new a(v51.class));
    }
}
