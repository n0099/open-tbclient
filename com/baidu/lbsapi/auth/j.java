package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1841a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.f1841a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        StringBuilder append = new StringBuilder().append("status = ").append(this.f1841a).append("; forced = ").append(this.b).append("checkAK = ");
        b = this.f.b(this.c);
        a.a(append.append(b).toString());
        if (this.f1841a != 601 && !this.b && this.f1841a != -1) {
            b2 = this.f.b(this.c);
            if (!b2) {
                if (602 != this.f1841a) {
                    a.a("authenticate else");
                    this.f.a((String) null, this.c);
                    return;
                }
                a.a("authenticate wait ");
                mVar = LBSAuthManager.d;
                if (mVar != null) {
                    mVar2 = LBSAuthManager.d;
                    mVar2.b();
                }
                this.f.a((String) null, this.c);
                return;
            }
        }
        a.a("authenticate sendAuthRequest");
        context = LBSAuthManager.f1832a;
        String[] b3 = b.b(context);
        if (b3 == null || b3.length <= 1) {
            this.f.a(this.b, this.d, this.e, this.c);
            return;
        }
        a.a("authStrings.length:" + b3.length);
        a.a("more sha1 auth");
        this.f.a(this.b, this.d, this.e, b3, this.c);
    }
}
