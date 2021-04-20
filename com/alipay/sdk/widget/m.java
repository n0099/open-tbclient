package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;
/* loaded from: classes.dex */
public class m extends j.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2067a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2068b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f2069c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, WebViewWindow webViewWindow, String str) {
        super(jVar, null);
        this.f2069c = jVar;
        this.f2067a = webViewWindow;
        this.f2068b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        WebViewWindow webViewWindow;
        this.f2069c.removeView(this.f2067a);
        webViewWindow = this.f2069c.x;
        webViewWindow.a(this.f2068b);
        this.f2069c.v = false;
    }
}
