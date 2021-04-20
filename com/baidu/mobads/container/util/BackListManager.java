package com.baidu.mobads.container.util;

import android.text.TextUtils;
import android.webkit.WebView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BackListManager {
    public static final String TAG = "BackListManager";
    public ArrayList<BackRecord> mBackList = new ArrayList<>();
    public int mCurrentIndex = -1;
    public WebView mView;

    /* loaded from: classes2.dex */
    public class BackRecord {
        public String mExtra;
        public int mStep = -1;
        public String mURL;

        public BackRecord(String str, String str2) {
            this.mURL = str;
            this.mExtra = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isSameExtra(String str) {
            String str2 = this.mExtra;
            if (str2 != null) {
                return str2.equals(str);
            }
            return str == null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateStep(String str) {
            this.mStep--;
            this.mURL = str;
        }
    }

    private boolean isNewRecord(String str) {
        if (this.mBackList.isEmpty()) {
            return true;
        }
        try {
            return !this.mBackList.get(this.mCurrentIndex).isSameExtra(str);
        } catch (Exception unused) {
            return true;
        }
    }

    public void addBackList(String str, boolean z) {
        WebView.HitTestResult hitTestResult;
        if (this.mView == null || z || TextUtils.isEmpty(str)) {
            return;
        }
        int i = this.mCurrentIndex;
        if ((i <= -1 || !str.equals(this.mBackList.get(i).mURL)) && (hitTestResult = this.mView.getHitTestResult()) != null) {
            String extra = hitTestResult.getExtra();
            synchronized (this) {
                if (!isNewRecord(extra)) {
                    this.mBackList.get(this.mCurrentIndex).updateStep(str);
                } else {
                    this.mBackList.add(new BackRecord(str, extra));
                    this.mCurrentIndex++;
                }
            }
        }
    }

    public boolean canGoBack() {
        int i;
        return !this.mBackList.isEmpty() && (i = this.mBackList.get(this.mCurrentIndex).mStep) < 0 && this.mView.canGoBackOrForward(i);
    }

    public void goBack() {
        if (this.mView == null) {
            RemoteXAdLogger.getInstance().i(TAG, "go back with a null mView.");
            return;
        }
        synchronized (this) {
            this.mView.goBackOrForward(this.mBackList.isEmpty() ? 0 : this.mBackList.get(this.mCurrentIndex).mStep);
            this.mBackList.remove(this.mCurrentIndex);
            this.mCurrentIndex--;
        }
    }

    public void resetManager() {
        synchronized (this) {
            this.mView = null;
            this.mCurrentIndex = -1;
            this.mBackList.clear();
        }
    }

    public void setWebView(WebView webView) {
        this.mView = webView;
    }
}
