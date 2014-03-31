package com.baidu.adp.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public class f {
    private InputMethodManager a = null;
    protected Context b;

    public f(Context context) {
        this.b = null;
        this.b = context;
    }

    public final Context b() {
        return this.b;
    }

    public void c() {
    }

    public final void a(InputMethodManager inputMethodManager) {
        this.a = inputMethodManager;
    }

    public final void a(View view) {
        try {
            if (this.a != null && view != null) {
                this.a.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public final void b(View view) {
        try {
            if (this.a == null) {
                this.a = (InputMethodManager) this.b.getSystemService("input_method");
            }
            this.a.showSoftInput(view, 0);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "ShowSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public final void a(View view, int i) {
        new Handler().postDelayed(new g(this, view), 100L);
    }
}
