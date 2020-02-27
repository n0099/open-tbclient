package com.baidu.searchbox.picture.contract;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
/* loaded from: classes13.dex */
public interface IViewer {
    Activity getHostContext();

    ViewGroup getRootView();

    ViewPager getViewPager();
}
