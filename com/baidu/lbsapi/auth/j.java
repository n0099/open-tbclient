package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6558a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6559b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6560c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6561d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6562e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6563f;

    public j(LBSAuthManager lBSAuthManager, int i2, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6563f = lBSAuthManager;
        this.f6558a = i2;
        this.f6559b = z;
        this.f6560c = str;
        this.f6561d = str2;
        this.f6562e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        boolean b3;
        if (a.f6542a) {
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.f6558a);
            sb.append("; forced = ");
            sb.append(this.f6559b);
            sb.append("checkAK = ");
            b3 = this.f6563f.b(this.f6560c);
            sb.append(b3);
            a.a(sb.toString());
        }
        int i2 = this.f6558a;
        if (i2 != 601 && !this.f6559b && i2 != -1) {
            b2 = this.f6563f.b(this.f6560c);
            if (!b2) {
                if (602 == this.f6558a) {
                    if (a.f6542a) {
                        a.a("authenticate wait  ");
                    }
                    mVar = LBSAuthManager.f6535d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6535d;
                        mVar2.b();
                    }
                } else if (a.f6542a) {
                    a.a("authenticate else  ");
                }
                this.f6563f.a((String) null, this.f6560c);
                return;
            }
        }
        if (a.f6542a) {
            a.a("authenticate sendAuthRequest");
        }
        context = LBSAuthManager.f6534a;
        String[] b4 = b.b(context);
        if (a.f6542a) {
            a.a("authStrings.length:" + b4.length);
        }
        if (b4 == null || b4.length <= 1) {
            this.f6563f.a(this.f6559b, this.f6561d, this.f6562e, this.f6560c);
            return;
        }
        if (a.f6542a) {
            a.a("more sha1 auth");
        }
        this.f6563f.a(this.f6559b, this.f6561d, this.f6562e, b4, this.f6560c);
    }
}
