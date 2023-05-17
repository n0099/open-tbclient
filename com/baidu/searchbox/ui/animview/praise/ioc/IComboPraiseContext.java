package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
/* loaded from: classes4.dex */
public interface IComboPraiseContext {
    void doLogin(Context context, ILoginStatusListener iLoginStatusListener);

    boolean getPraiseSwitchState();

    boolean isLogin();

    boolean isPraiseLoginSupported();

    boolean isPraiseOptimized();

    boolean isPraiseResourceLoadSwitch();

    void notifyPraiseAnimationEvent(Context context, String str, String str2);
}
