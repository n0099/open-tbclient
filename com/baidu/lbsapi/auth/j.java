package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6309a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6311c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6312d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6313e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6314f;

    public j(LBSAuthManager lBSAuthManager, int i2, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6314f = lBSAuthManager;
        this.f6309a = i2;
        this.f6310b = z;
        this.f6311c = str;
        this.f6312d = str2;
        this.f6313e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        Context context;
        boolean b3;
        m mVar;
        m mVar2;
        StringBuilder sb = new StringBuilder();
        sb.append("status = ");
        sb.append(this.f6309a);
        sb.append("; forced = ");
        sb.append(this.f6310b);
        sb.append("checkAK = ");
        b2 = this.f6314f.b(this.f6311c);
        sb.append(b2);
        a.a(sb.toString());
        int i2 = this.f6309a;
        if (i2 != 601 && !this.f6310b && i2 != -1) {
            b3 = this.f6314f.b(this.f6311c);
            if (!b3) {
                if (602 == this.f6309a) {
                    a.a("authenticate wait ");
                    mVar = LBSAuthManager.f6285d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6285d;
                        mVar2.b();
                    }
                } else {
                    a.a("authenticate else");
                }
                this.f6314f.a((String) null, this.f6311c);
                return;
            }
        }
        a.a("authenticate sendAuthRequest");
        context = LBSAuthManager.f6284a;
        String[] b4 = b.b(context);
        a.a("authStrings.length:" + b4.length);
        if (b4 == null || b4.length <= 1) {
            this.f6314f.a(this.f6310b, this.f6312d, this.f6313e, this.f6311c);
            return;
        }
        a.a("more sha1 auth");
        this.f6314f.a(this.f6310b, this.f6312d, this.f6313e, b4, this.f6311c);
    }
}
