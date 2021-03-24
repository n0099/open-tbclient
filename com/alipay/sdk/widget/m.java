package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;
/* loaded from: classes.dex */
public class m extends j.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2042a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f2044c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, WebViewWindow webViewWindow, String str) {
        super(jVar, null);
        this.f2044c = jVar;
        this.f2042a = webViewWindow;
        this.f2043b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        WebViewWindow webViewWindow;
        this.f2044c.removeView(this.f2042a);
        webViewWindow = this.f2044c.x;
        webViewWindow.a(this.f2043b);
        this.f2044c.v = false;
    }
}
