package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class g implements AlipayResultActivity.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f1973a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f1974b;

    public g(e eVar, CountDownLatch countDownLatch) {
        this.f1974b = eVar;
        this.f1973a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i2, String str, String str2) {
        this.f1974b.f1971i = com.alipay.sdk.app.j.a(i2, str, str2);
        this.f1973a.countDown();
    }
}
