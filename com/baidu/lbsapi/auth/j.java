package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6409a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6410b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6411c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6412d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6413e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6414f;

    public j(LBSAuthManager lBSAuthManager, int i2, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6414f = lBSAuthManager;
        this.f6409a = i2;
        this.f6410b = z;
        this.f6411c = str;
        this.f6412d = str2;
        this.f6413e = hashtable;
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
        sb.append(this.f6409a);
        sb.append("; forced = ");
        sb.append(this.f6410b);
        sb.append("checkAK = ");
        b2 = this.f6414f.b(this.f6411c);
        sb.append(b2);
        a.a(sb.toString());
        int i2 = this.f6409a;
        if (i2 != 601 && !this.f6410b && i2 != -1) {
            b3 = this.f6414f.b(this.f6411c);
            if (!b3) {
                if (602 == this.f6409a) {
                    a.a("authenticate wait ");
                    mVar = LBSAuthManager.f6385d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6385d;
                        mVar2.b();
                    }
                } else {
                    a.a("authenticate else");
                }
                this.f6414f.a((String) null, this.f6411c);
                return;
            }
        }
        a.a("authenticate sendAuthRequest");
        context = LBSAuthManager.f6384a;
        String[] b4 = b.b(context);
        a.a("authStrings.length:" + b4.length);
        if (b4 == null || b4.length <= 1) {
            this.f6414f.a(this.f6410b, this.f6412d, this.f6413e, this.f6411c);
            return;
        }
        a.a("more sha1 auth");
        this.f6414f.a(this.f6410b, this.f6412d, this.f6413e, b4, this.f6411c);
    }
}
