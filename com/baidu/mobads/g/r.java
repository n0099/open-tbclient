package com.baidu.mobads.g;

import android.text.TextUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class r extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f8310a;

    public r(q qVar) {
        this.f8310a = qVar;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        String a2;
        String a3;
        String a4;
        try {
            a2 = this.f8310a.a("key_crash_trace");
            a3 = this.f8310a.a("key_crash_ad");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            com.baidu.mobads.b.a a5 = com.baidu.mobads.b.a.a();
            a4 = this.f8310a.a("key_crash_source");
            a5.a(a4, a2, a3);
            this.f8310a.e();
            return null;
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            return null;
        }
    }
}
