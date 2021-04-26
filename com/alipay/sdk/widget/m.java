package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;
/* loaded from: classes.dex */
public class m extends j.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2027a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2028b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f2029c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, WebViewWindow webViewWindow, String str) {
        super(jVar, null);
        this.f2029c = jVar;
        this.f2027a = webViewWindow;
        this.f2028b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        WebViewWindow webViewWindow;
        this.f2029c.removeView(this.f2027a);
        webViewWindow = this.f2029c.x;
        webViewWindow.a(this.f2028b);
        this.f2029c.v = false;
    }
}
