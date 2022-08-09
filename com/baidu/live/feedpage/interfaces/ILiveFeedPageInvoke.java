package com.baidu.live.feedpage.interfaces;

import android.content.Context;
/* loaded from: classes2.dex */
public interface ILiveFeedPageInvoke {
    String getCuid();

    String getIID();

    String getUIMode();

    String getUK();

    void invokeScheme(Context context, String str);

    void showToast(Context context, String str);
}
