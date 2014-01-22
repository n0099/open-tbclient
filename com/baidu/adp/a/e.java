package com.baidu.adp.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public class e {
    private InputMethodManager a = null;
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
        this.a = inputMethodManager;
    }

    public InputMethodManager g_() {
        if (this.a == null) {
            this.a = (InputMethodManager) this.b.getSystemService("input_method");
        }
        return this.a;
    }

    public void a(View view) {
        try {
            if (this.a != null && view != null) {
                this.a.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void b(View view) {
        try {
            g_().showSoftInput(view, 0);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "ShowSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void a(View view, int i) {
        new Handler().postDelayed(new f(this, view), i);
    }
}
