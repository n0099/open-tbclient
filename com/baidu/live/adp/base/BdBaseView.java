package com.baidu.live.adp.base;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class BdBaseView<T> {
    protected BdPageContext<T> mContext;
    private InputMethodManager mInputManager = null;

    public BdBaseView(BdPageContext<T> bdPageContext) {
        this.mContext = null;
        this.mContext = bdPageContext;
    }

    public BdPageContext<T> getPageContext() {
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
        new Handler().postDelayed(new DelayRunnable(view), i);
    }

    /* loaded from: classes4.dex */
    class DelayRunnable implements Runnable {
        private View mView;

        public DelayRunnable(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BdBaseView.this.mContext != null && BdBaseView.this.mContext.getPageActivity() != null && !BdBaseView.this.mContext.getPageActivity().isFinishing()) {
                BdBaseView.this.ShowSoftKeyPad(this.mView);
            }
        }
    }
}
