package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import com.baidu.browser.BrowserType;
/* loaded from: classes2.dex */
public interface IAiAppsSocialShareIoc {

    /* loaded from: classes2.dex */
    public interface OnShareResultListener {
        void notify(String str, String str2);

        void onSharePanelCancel();
    }

    void share(Context context, String str, BrowserType browserType, String str2, String str3, boolean z, boolean z2, String str4, OnShareResultListener onShareResultListener);
}
