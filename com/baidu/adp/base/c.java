package com.baidu.adp.base;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c<T> {
    protected e<T> mContext;
    private InputMethodManager mInputManager = null;

    public c(e<T> eVar) {
        this.mContext = null;
        this.mContext = eVar;
    }

    public e<T> getPageContext() {
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

    public void HidenSoftKeyPad(View view2) {
        try {
            if (this.mInputManager == null) {
                getInputMethodManager();
            }
            if (this.mInputManager != null && view2 != null) {
                this.mInputManager.hideSoftInputFromWindow(view2.getWindowToken(), 2);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ShowSoftKeyPad(View view2) {
        try {
            getInputMethodManager().showSoftInput(view2, 0);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ShowSoftKeyPadDelay(View view2, int i) {
        new Handler().postDelayed(new a(view2), i);
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private View mView;

        public a(View view2) {
            this.mView = null;
            this.mView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mContext != null && c.this.mContext.getPageActivity() != null && !c.this.mContext.getPageActivity().isFinishing()) {
                c.this.ShowSoftKeyPad(this.mView);
            }
        }
    }
}
