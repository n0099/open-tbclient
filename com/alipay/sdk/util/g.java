package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class g implements AlipayResultActivity.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f1978a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f1979b;

    public g(e eVar, CountDownLatch countDownLatch) {
        this.f1979b = eVar;
        this.f1978a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i, String str, String str2) {
        this.f1979b.i = com.alipay.sdk.app.j.a(i, str, str2);
        this.f1978a.countDown();
    }
}
