package com.baidu.mobads.g;

import android.text.TextUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class r implements Runnable {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a;
        String a2;
        String a3;
        try {
            a = this.a.a("key_crash_trace");
            a2 = this.a.a("key_crash_ad");
            if (!TextUtils.isEmpty(a)) {
                com.baidu.mobads.c.a a4 = com.baidu.mobads.c.a.a();
                a3 = this.a.a("key_crash_source");
                a4.a(a3, a, a2);
                this.a.e();
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }
}
