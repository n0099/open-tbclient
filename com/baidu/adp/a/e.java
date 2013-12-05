package com.baidu.adp.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private InputMethodManager f400a = null;
    protected Context b;

    public e(Context context) {
        this.b = null;
        this.b = context;
    }

    public Context b() {
        return this.b;
    }

    public void c() {
    }

    public void a(InputMethodManager inputMethodManager) {
        this.f400a = inputMethodManager;
    }

    public InputMethodManager g_() {
        if (this.f400a == null) {
            this.f400a = (InputMethodManager) this.b.getSystemService("input_method");
        }
        return this.f400a;
    }

    public void a(View view) {
        try {
            if (this.f400a != null && view != null) {
                this.f400a.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void b(View view) {
        try {
            g_().showSoftInput(view, 0);
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "ShowSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void a(View view, int i) {
        new Handler().postDelayed(new f(this, view), i);
    }
}
