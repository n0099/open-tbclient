package com.baidu.adp.base;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    protected Context mContext;
    private InputMethodManager mInputManager = null;

    public e(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void destroy() {
    }

    public void setInputMethodManager(InputMethodManager inputMethodManager) {
        this.mInputManager = inputMethodManager;
    }

    public InputMethodManager getInputMethodManager() {
        if (this.mInputManager == null) {
            this.mInputManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        }
        return this.mInputManager;
    }

    public void HidenSoftKeyPad(View view) {
        try {
            if (this.mInputManager == null) {
                getInputMethodManager();
            }
            if (this.mInputManager != null && view != null) {
                this.mInputManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void ShowSoftKeyPad(View view) {
        try {
            getInputMethodManager().showSoftInput(view, 0);
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "ShowSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new f(this, view), i);
    }
}
