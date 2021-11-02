package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
/* loaded from: classes7.dex */
public interface IComboPraiseContext {
    void doLogin(Context context, ILoginStatusListener iLoginStatusListener);

    boolean getPraiseSwitchState();

    boolean isLogin();

    boolean isPraiseLoginSupported();

    boolean isPraiseOptimized();

    void notifyPraiseAnimationEvent(Context context, String str, String str2);
}
