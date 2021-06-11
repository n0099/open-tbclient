package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6352a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6354c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6355d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6356e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6357f;

    public j(LBSAuthManager lBSAuthManager, int i2, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6357f = lBSAuthManager;
        this.f6352a = i2;
        this.f6353b = z;
        this.f6354c = str;
        this.f6355d = str2;
        this.f6356e = hashtable;
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
        sb.append(this.f6352a);
        sb.append("; forced = ");
        sb.append(this.f6353b);
        sb.append("checkAK = ");
        b2 = this.f6357f.b(this.f6354c);
        sb.append(b2);
        a.a(sb.toString());
        int i2 = this.f6352a;
        if (i2 != 601 && !this.f6353b && i2 != -1) {
            b3 = this.f6357f.b(this.f6354c);
            if (!b3) {
                if (602 == this.f6352a) {
                    a.a("authenticate wait ");
                    mVar = LBSAuthManager.f6328d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6328d;
                        mVar2.b();
                    }
                } else {
                    a.a("authenticate else");
                }
                this.f6357f.a((String) null, this.f6354c);
                return;
            }
        }
        a.a("authenticate sendAuthRequest");
        context = LBSAuthManager.f6327a;
        String[] b4 = b.b(context);
        a.a("authStrings.length:" + b4.length);
        if (b4 == null || b4.length <= 1) {
            this.f6357f.a(this.f6353b, this.f6355d, this.f6356e, this.f6354c);
            return;
        }
        a.a("more sha1 auth");
        this.f6357f.a(this.f6353b, this.f6355d, this.f6356e, b4, this.f6354c);
    }
}
