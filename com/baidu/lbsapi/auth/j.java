package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2493a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f2494b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.f2493a = i;
        this.f2494b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        boolean b3;
        if (a.f2481a) {
            StringBuilder append = new StringBuilder().append("status = ").append(this.f2493a).append("; forced = ").append(this.f2494b).append("checkAK = ");
            b3 = this.f.b(this.c);
            a.a(append.append(b3).toString());
        }
        if (this.f2493a != 601 && !this.f2494b && this.f2493a != -1) {
            b2 = this.f.b(this.c);
            if (!b2) {
                if (602 != this.f2493a) {
                    if (a.f2481a) {
                        a.a("authenticate else  ");
                    }
                    this.f.a((String) null, this.c);
                    return;
                }
                if (a.f2481a) {
                    a.a("authenticate wait  ");
                }
                mVar = LBSAuthManager.d;
                if (mVar != null) {
                    mVar2 = LBSAuthManager.d;
                    mVar2.b();
                }
                this.f.a((String) null, this.c);
                return;
            }
        }
        if (a.f2481a) {
            a.a("authenticate sendAuthRequest");
        }
        context = LBSAuthManager.f2479a;
        String[] b4 = b.b(context);
        if (a.f2481a) {
            a.a("authStrings.length:" + b4.length);
        }
        if (b4 == null || b4.length <= 1) {
            this.f.a(this.f2494b, this.d, this.e, this.c);
            return;
        }
        if (a.f2481a) {
            a.a("more sha1 auth");
        }
        this.f.a(this.f2494b, this.d, this.e, b4, this.c);
    }
}
