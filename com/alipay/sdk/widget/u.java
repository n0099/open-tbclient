package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public Stack<WebViewWindow> f2052a = new Stack<>();

    public WebViewWindow a() {
        return this.f2052a.pop();
    }

    public boolean b() {
        return this.f2052a.isEmpty();
    }

    public void c() {
        if (b()) {
            return;
        }
        Iterator<WebViewWindow> it = this.f2052a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2052a.clear();
    }

    public void a(WebViewWindow webViewWindow) {
        this.f2052a.push(webViewWindow);
    }
}
