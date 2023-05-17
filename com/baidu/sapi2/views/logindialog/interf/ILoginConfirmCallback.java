package com.baidu.sapi2.views.logindialog.interf;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
/* loaded from: classes3.dex */
public interface ILoginConfirmCallback extends NoProguard {
    void onFailure(QuickLoginResult quickLoginResult);

    boolean onPreStart(boolean z);

    void onSuccess(QuickLoginResult quickLoginResult);
}
