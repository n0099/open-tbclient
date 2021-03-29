package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6339b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6340c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6341d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6342e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6343f;

    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6343f = lBSAuthManager;
        this.f6338a = i;
        this.f6339b = z;
        this.f6340c = str;
        this.f6341d = str2;
        this.f6342e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        boolean b3;
        if (a.f6322a) {
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.f6338a);
            sb.append("; forced = ");
            sb.append(this.f6339b);
            sb.append("checkAK = ");
            b3 = this.f6343f.b(this.f6340c);
            sb.append(b3);
            a.a(sb.toString());
        }
        int i = this.f6338a;
        if (i != 601 && !this.f6339b && i != -1) {
            b2 = this.f6343f.b(this.f6340c);
            if (!b2) {
                if (602 == this.f6338a) {
                    if (a.f6322a) {
                        a.a("authenticate wait  ");
                    }
                    mVar = LBSAuthManager.f6315d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6315d;
                        mVar2.b();
                    }
                } else if (a.f6322a) {
                    a.a("authenticate else  ");
                }
                this.f6343f.a((String) null, this.f6340c);
                return;
            }
        }
        if (a.f6322a) {
            a.a("authenticate sendAuthRequest");
        }
        context = LBSAuthManager.f6314a;
        String[] b4 = b.b(context);
        if (a.f6322a) {
            a.a("authStrings.length:" + b4.length);
        }
        if (b4 == null || b4.length <= 1) {
            this.f6343f.a(this.f6339b, this.f6341d, this.f6342e, this.f6340c);
            return;
        }
        if (a.f6322a) {
            a.a("more sha1 auth");
        }
        this.f6343f.a(this.f6339b, this.f6341d, this.f6342e, b4, this.f6340c);
    }
}
