package com.baidu.adp.base;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d<T> {
    protected f<T> mContext;
    private InputMethodManager mInputManager = null;

    public d(f<T> fVar) {
        this.mContext = null;
        this.mContext = fVar;
    }

    public f<T> getPageContext() {
        return this.mContext;
    }

    public void destroy() {
    }

    public void setInputMethodManager(InputMethodManager inputMethodManager) {
        this.mInputManager = inputMethodManager;
    }

    public InputMethodManager getInputMethodManager() {
        if (this.mInputManager == null) {
            this.mInputManager = (InputMethodManager) this.mContext.getContext().getSystemService("input_method");
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
            BdLog.e(e.getMessage());
        }
    }

    public void ShowSoftKeyPad(View view) {
        try {
            getInputMethodManager().showSoftInput(view, 0);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new a(view), i);
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private View mView;

        public a(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mContext != null && d.this.mContext.getPageActivity() != null && !d.this.mContext.getPageActivity().isFinishing()) {
                d.this.ShowSoftKeyPad(this.mView);
            }
        }
    }
}
