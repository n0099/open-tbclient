package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class g implements AlipayResultActivity.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f1960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f1961b;

    public g(e eVar, CountDownLatch countDownLatch) {
        this.f1961b = eVar;
        this.f1960a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i2, String str, String str2) {
        this.f1961b.f1958i = com.alipay.sdk.app.j.a(i2, str, str2);
        this.f1960a.countDown();
    }
}
