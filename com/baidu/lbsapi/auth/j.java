package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6375c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6376d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6377e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6378f;

    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6378f = lBSAuthManager;
        this.f6373a = i;
        this.f6374b = z;
        this.f6375c = str;
        this.f6376d = str2;
        this.f6377e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        boolean b3;
        if (a.f6357a) {
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.f6373a);
            sb.append("; forced = ");
            sb.append(this.f6374b);
            sb.append("checkAK = ");
            b3 = this.f6378f.b(this.f6375c);
            sb.append(b3);
            a.a(sb.toString());
        }
        int i = this.f6373a;
        if (i != 601 && !this.f6374b && i != -1) {
            b2 = this.f6378f.b(this.f6375c);
            if (!b2) {
                if (602 == this.f6373a) {
                    if (a.f6357a) {
                        a.a("authenticate wait  ");
                    }
                    mVar = LBSAuthManager.f6350d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6350d;
                        mVar2.b();
                    }
                } else if (a.f6357a) {
                    a.a("authenticate else  ");
                }
                this.f6378f.a((String) null, this.f6375c);
                return;
            }
        }
        if (a.f6357a) {
            a.a("authenticate sendAuthRequest");
        }
        context = LBSAuthManager.f6349a;
        String[] b4 = b.b(context);
        if (a.f6357a) {
            a.a("authStrings.length:" + b4.length);
        }
        if (b4 == null || b4.length <= 1) {
            this.f6378f.a(this.f6374b, this.f6376d, this.f6377e, this.f6375c);
            return;
        }
        if (a.f6357a) {
            a.a("more sha1 auth");
        }
        this.f6378f.a(this.f6374b, this.f6376d, this.f6377e, b4, this.f6375c);
    }
}
