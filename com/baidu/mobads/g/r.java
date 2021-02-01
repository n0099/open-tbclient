package com.baidu.mobads.g;

import android.text.TextUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class r extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f3359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f3359a = qVar;
    }

    @Override // com.baidu.mobads.f.a
    protected Object a() {
        String a2;
        String a3;
        String a4;
        try {
            a2 = this.f3359a.a("key_crash_trace");
            a3 = this.f3359a.a("key_crash_ad");
            if (!TextUtils.isEmpty(a2)) {
                com.baidu.mobads.b.a a5 = com.baidu.mobads.b.a.a();
                a4 = this.f3359a.a("key_crash_source");
                a5.a(a4, a2, a3);
                this.f3359a.e();
                return null;
            }
            return null;
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }
}
