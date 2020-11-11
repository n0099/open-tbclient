package com.baidu.mobads.g;

import android.text.TextUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f2347a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f2347a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a2;
        String a3;
        String a4;
        try {
            a2 = this.f2347a.a("key_crash_trace");
            a3 = this.f2347a.a("key_crash_ad");
            if (!TextUtils.isEmpty(a2)) {
                com.baidu.mobads.c.a a5 = com.baidu.mobads.c.a.a();
                a4 = this.f2347a.a("key_crash_source");
                a5.a(a4, a2, a3);
                this.f2347a.e();
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }
}
