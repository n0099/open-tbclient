package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public abstract class g extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Activity f2011a;

    public g(Activity activity) {
        super(activity);
        this.f2011a = activity;
    }

    public abstract void a();

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f2011a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean b();
}
