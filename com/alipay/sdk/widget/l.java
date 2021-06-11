package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;
/* loaded from: classes.dex */
public class l extends j.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2038a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f2039b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, WebViewWindow webViewWindow) {
        super(jVar, null);
        this.f2039b = jVar;
        this.f2038a = webViewWindow;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f2038a.a();
        this.f2039b.v = false;
    }
}
