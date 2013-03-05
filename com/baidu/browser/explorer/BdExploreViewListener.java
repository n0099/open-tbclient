package com.baidu.browser.explorer;

import android.view.MotionEvent;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public interface BdExploreViewListener {
    void onHideTabWindow();

    void onLongPress(BdWebView.BdHitTestResult bdHitTestResult);

    void onSelectionSearch(String str);

    void onShowTabWindow();

    void onWebViewTouch(MotionEvent motionEvent);
}
