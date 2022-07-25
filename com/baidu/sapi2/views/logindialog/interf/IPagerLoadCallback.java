package com.baidu.sapi2.views.logindialog.interf;

import com.baidu.sapi2.NoProguard;
/* loaded from: classes2.dex */
public interface IPagerLoadCallback extends NoProguard {
    void onChange2LoginPage();

    void onChange2SmsPage(String str, int i);

    void onPageLoading();

    void onPageShow(int i);
}
