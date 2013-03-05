package com.baidu.browser.webkit;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class BdWebErrorEngine {
    public static final int HAS_SHOWN = 2;
    public static final int NOT_SHOW = 0;
    public static final int PROGRESS_MAX = 100;
    public static final int PROGRESS_MIN = 10;
    public static final int START_SHOW = 1;
    public static final int STATE_PAGE_FINISHED = 4;
    public static final int STATE_PAGE_RECEIVED = 8;
    public static final int STATE_PAGE_STARTED = 1;
    public static final int STATE_PROGRESS_CHANGED = 2;
    public static final int STATE_RECEIVE_ERROR = 32;
    public static final int STATE_START_SHOW = 16;
    private BdWebErrorListener mListener;
    private int mShowState;

    /* loaded from: classes.dex */
    public interface BdWebErrorListener {
        void onHideErrorPage();

        void onShowErrorPage(int i);
    }

    public void setEventLisener(BdWebErrorListener bdWebErrorListener) {
        this.mListener = bdWebErrorListener;
    }

    public void onPageStarted(BdWebView bdWebView, String str, Bitmap bitmap) {
        this.mShowState = 0;
        onStateChanged(bdWebView, changeStateMaskByErrorCode(bdWebView, 1), null);
    }

    public void onPageFinished(BdWebView bdWebView, String str) {
        int i = 4;
        if (this.mShowState == 0) {
            i = 20;
        }
        this.mShowState = 2;
        onStateChanged(bdWebView, changeStateMaskByErrorCode(bdWebView, i), null);
        bdWebView.setErrorCode(0);
    }

    public void onReceivedError(BdWebView bdWebView, int i, String str, String str2) {
        bdWebView.setErrorCode(i);
    }

    public void onReceivedSslError(BdWebView bdWebView, BdSslErrorHandler bdSslErrorHandler, BdSslError bdSslError) {
        if (this.mListener != null) {
            this.mListener.onHideErrorPage();
        }
    }

    public void doUpdateVisitedHistory(BdWebView bdWebView, String str, boolean z) {
        if (str != null) {
            this.mShowState = 1;
        }
    }

    public void onProgressChanged(BdWebView bdWebView, int i) {
        int i2;
        if (this.mShowState == 1) {
            i2 = 18;
            this.mShowState = 2;
            hideErrorPage();
        } else {
            i2 = 2;
        }
        if (i <= 10) {
            bdWebView.setErrorListCode(0);
        }
        onStateChanged(bdWebView, i2, Integer.valueOf(i));
    }

    public void onReceivedTitle(BdWebView bdWebView, String str) {
        onStateChanged(bdWebView, changeStateMaskByErrorCode(bdWebView, 8), null);
    }

    private void onStateChanged(BdWebView bdWebView, int i, Object obj) {
        if ((i & 16) != 0) {
            if (this.mShowState > 0) {
                hideErrorPage();
            }
            if ((i & 32) != 0) {
                bdWebView.setErrorListCode(bdWebView.getErrorCode());
                showErrorPage(bdWebView);
            } else if (bdWebView.getErrorListCode() != 0) {
                showErrorPage(bdWebView);
            } else {
                hideErrorPage();
            }
        }
    }

    private int changeStateMaskByErrorCode(BdWebView bdWebView, int i) {
        if (bdWebView.getErrorCode() != 0) {
            return i | 32;
        }
        return i;
    }

    private void showErrorPage(BdWebView bdWebView) {
        int errorListCode = bdWebView.getErrorListCode();
        if (errorListCode == 0) {
            hideErrorPage();
        } else if (this.mListener != null) {
            this.mListener.onShowErrorPage(errorListCode);
        }
    }

    public void hideErrorPage() {
        if (this.mListener != null) {
            this.mListener.onHideErrorPage();
        }
    }
}
