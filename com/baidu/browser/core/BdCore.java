package com.baidu.browser.core;

import android.app.Activity;
import android.content.Context;
import com.baidu.browser.core.net.BdNetManager;
/* loaded from: classes.dex */
public final class BdCore implements IElement {
    private static BdCore sInstance;

    private BdCore() {
    }

    public static BdCore getInstance() {
        if (sInstance == null) {
            sInstance = new BdCore();
        }
        return sInstance;
    }

    private static void destroy() {
        sInstance = null;
    }

    public void onInit(Activity activity) {
        BdNetManager.getInstance().onInit(activity);
    }

    @Override // com.baidu.browser.core.IElement
    public void onInit(Context context) {
    }

    @Override // com.baidu.browser.core.IElement
    public void onSave(Context context) {
    }

    @Override // com.baidu.browser.core.IElement
    public void onLoad(Context context) {
    }

    @Override // com.baidu.browser.core.IElement
    public void onDestroy() {
        BdNetManager.getInstance().onDestroy();
        destroy();
    }

    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
