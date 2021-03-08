package com.baidu.mobads.g;

import android.text.TextUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class r extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f2400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f2400a = qVar;
    }

    @Override // com.baidu.mobads.f.a
    protected Object a() {
        String a2;
        String a3;
        String a4;
        try {
            a2 = this.f2400a.a("key_crash_trace");
            a3 = this.f2400a.a("key_crash_ad");
            if (!TextUtils.isEmpty(a2)) {
                com.baidu.mobads.b.a a5 = com.baidu.mobads.b.a.a();
                a4 = this.f2400a.a("key_crash_source");
                a5.a(a4, a2, a3);
                this.f2400a.e();
                return null;
            }
            return null;
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            return null;
        }
    }
}
