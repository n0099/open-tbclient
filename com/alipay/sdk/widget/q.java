package com.alipay.sdk.widget;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.alipay.sdk.widget.WebViewWindow;
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2047a;

    public q(WebViewWindow webViewWindow) {
        this.f2047a = webViewWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebViewWindow.c cVar;
        Handler handler;
        ImageView imageView;
        ImageView imageView2;
        cVar = this.f2047a.f2009i;
        if (cVar != null) {
            view.setEnabled(false);
            handler = WebViewWindow.f2001f;
            handler.postDelayed(new r(this, view), 256L);
            imageView = this.f2047a.f2002a;
            if (view != imageView) {
                imageView2 = this.f2047a.f2004c;
                if (view == imageView2) {
                    cVar.b(this.f2047a);
                    return;
                }
                return;
            }
            cVar.a(this.f2047a);
        }
    }
}
