package com.alipay.sdk.widget;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.alipay.sdk.widget.WebViewWindow;
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2049a;

    public q(WebViewWindow webViewWindow) {
        this.f2049a = webViewWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebViewWindow.c cVar;
        Handler handler;
        ImageView imageView;
        ImageView imageView2;
        cVar = this.f2049a.i;
        if (cVar != null) {
            view.setEnabled(false);
            handler = WebViewWindow.f2006f;
            handler.postDelayed(new r(this, view), 256L);
            imageView = this.f2049a.f2007a;
            if (view != imageView) {
                imageView2 = this.f2049a.f2009c;
                if (view == imageView2) {
                    cVar.b(this.f2049a);
                    return;
                }
                return;
            }
            cVar.a(this.f2049a);
        }
    }
}
