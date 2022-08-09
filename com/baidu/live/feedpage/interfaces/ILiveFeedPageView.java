package com.baidu.live.feedpage.interfaces;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
/* loaded from: classes2.dex */
public interface ILiveFeedPageView extends ILiveFeedLifecycle, ILiveFeedRefresh, ILiveFeedOther {
    void lazyLoad();

    View onCreateView(FragmentActivity fragmentActivity, Fragment fragment, String str, String str2, String str3, String str4, boolean z);

    void onDarkModeChange(String str);

    void onFontSizeChanged(int i);

    void onTabSelectedEvent(String str, String str2);

    void onUserVisibleHint(boolean z);
}
