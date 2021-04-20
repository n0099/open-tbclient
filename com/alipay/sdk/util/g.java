package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class g implements AlipayResultActivity.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f2003a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f2004b;

    public g(e eVar, CountDownLatch countDownLatch) {
        this.f2004b = eVar;
        this.f2003a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i, String str, String str2) {
        this.f2004b.i = com.alipay.sdk.app.j.a(i, str, str2);
        this.f2003a.countDown();
    }
}
