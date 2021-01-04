package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2544a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f2545b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.f2544a = i;
        this.f2545b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        Context context;
        boolean b3;
        m mVar;
        m mVar2;
        StringBuilder append = new StringBuilder().append("status = ").append(this.f2544a).append("; forced = ").append(this.f2545b).append("checkAK = ");
        b2 = this.f.b(this.c);
        a.a(append.append(b2).toString());
        if (this.f2544a != 601 && !this.f2545b && this.f2544a != -1) {
            b3 = this.f.b(this.c);
            if (!b3) {
                if (602 != this.f2544a) {
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
        context = LBSAuthManager.f2530a;
        String[] b4 = b.b(context);
        if (b4 == null || b4.length <= 1) {
            this.f.a(this.f2545b, this.d, this.e, this.c);
            return;
        }
        a.a("authStrings.length:" + b4.length);
        a.a("more sha1 auth");
        this.f.a(this.f2545b, this.d, this.e, b4, this.c);
    }
}
