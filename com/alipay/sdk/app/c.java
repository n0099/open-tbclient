package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1776a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f1777b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f1778c;

    public c(b bVar, Activity activity, SslErrorHandler sslErrorHandler) {
        this.f1778c = bVar;
        this.f1776a = activity;
        this.f1777b = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.e.a(this.f1776a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new d(this), "退出", new e(this));
    }
}
