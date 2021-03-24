package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6337a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6338b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6339c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6340d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Hashtable f6341e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6342f;

    public j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f6342f = lBSAuthManager;
        this.f6337a = i;
        this.f6338b = z;
        this.f6339c = str;
        this.f6340d = str2;
        this.f6341e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean b2;
        m mVar;
        m mVar2;
        boolean b3;
        if (a.f6321a) {
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(this.f6337a);
            sb.append("; forced = ");
            sb.append(this.f6338b);
            sb.append("checkAK = ");
            b3 = this.f6342f.b(this.f6339c);
            sb.append(b3);
            a.a(sb.toString());
        }
        int i = this.f6337a;
        if (i != 601 && !this.f6338b && i != -1) {
            b2 = this.f6342f.b(this.f6339c);
            if (!b2) {
                if (602 == this.f6337a) {
                    if (a.f6321a) {
                        a.a("authenticate wait  ");
                    }
                    mVar = LBSAuthManager.f6314d;
                    if (mVar != null) {
                        mVar2 = LBSAuthManager.f6314d;
                        mVar2.b();
                    }
                } else if (a.f6321a) {
                    a.a("authenticate else  ");
                }
                this.f6342f.a((String) null, this.f6339c);
                return;
            }
        }
        if (a.f6321a) {
            a.a("authenticate sendAuthRequest");
        }
        context = LBSAuthManager.f6313a;
        String[] b4 = b.b(context);
        if (a.f6321a) {
            a.a("authStrings.length:" + b4.length);
        }
        if (b4 == null || b4.length <= 1) {
            this.f6342f.a(this.f6338b, this.f6340d, this.f6341e, this.f6339c);
            return;
        }
        if (a.f6321a) {
            a.a("more sha1 auth");
        }
        this.f6342f.a(this.f6338b, this.f6340d, this.f6341e, b4, this.f6339c);
    }
}
