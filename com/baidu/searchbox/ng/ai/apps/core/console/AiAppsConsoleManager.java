package com.baidu.searchbox.ng.ai.apps.core.console;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppKeyboardUtils;
/* loaded from: classes2.dex */
public class AiAppsConsoleManager extends AiAppsWebViewManager {
    private static final String CONSOLE_ID = "console";
    private static final String CONSOLE_WEB_URL = "file:///android_asset/aiapps/sConsole.html";
    private Context mContext;

    public AiAppsConsoleManager(Context context) {
        super(context);
        this.mContext = context;
        getWebView().setVisibility(8);
        getWebView().setBackgroundColor(0);
        loadUrl(CONSOLE_WEB_URL);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected BrowserType getBrowserType() {
        return null;
    }

    public void addToParent(ViewGroup viewGroup) {
        if (viewGroup != null) {
            addView(viewGroup, getWebView());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConsoleVisible(boolean z) {
        getWebView().setVisibility(z ? 0 : 8);
    }

    public void toggleConsoleVisibility() {
        setConsoleVisible(getWebView().getVisibility() != 0);
    }

    private void addView(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !hasChildView(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void removeView(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && hasChildView(viewGroup, view)) {
            viewGroup.removeView(view);
        }
    }

    private boolean hasChildView(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public String getWebViewId() {
        return CONSOLE_ID;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void destroy() {
        checkInputMethod();
        super.destroy();
    }

    private void checkInputMethod() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            AiAppKeyboardUtils.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
