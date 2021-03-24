package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;
/* loaded from: classes.dex */
public class l extends j.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2040a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f2041b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, WebViewWindow webViewWindow) {
        super(jVar, null);
        this.f2041b = jVar;
        this.f2040a = webViewWindow;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f2040a.a();
        this.f2041b.v = false;
    }
}
