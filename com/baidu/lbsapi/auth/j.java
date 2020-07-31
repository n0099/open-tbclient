package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class j implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean b;
        m mVar;
        m mVar2;
        boolean b2;
        if (a.a) {
            StringBuilder append = new StringBuilder().append("status = ").append(this.a).append("; forced = ").append(this.b).append("checkAK = ");
            b2 = this.f.b(this.c);
            a.a(append.append(b2).toString());
        }
        if (this.a != 601 && !this.b && this.a != -1) {
            b = this.f.b(this.c);
            if (!b) {
                if (602 != this.a) {
                    if (a.a) {
                        a.a("authenticate else  ");
                    }
                    this.f.a((String) null, this.c);
                    return;
                }
                if (a.a) {
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
        if (a.a) {
            a.a("authenticate sendAuthRequest");
        }
        context = LBSAuthManager.a;
        String[] b3 = b.b(context);
        if (a.a) {
            a.a("authStrings.length:" + b3.length);
        }
        if (b3 == null || b3.length <= 1) {
            this.f.a(this.b, this.d, this.e, this.c);
            return;
        }
        if (a.a) {
            a.a("more sha1 auth");
        }
        this.f.a(this.b, this.d, this.e, b3, this.c);
    }
}
