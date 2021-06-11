package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.helios.bridge.multiprocess.e;
import d.a.q.d.a;
import d.a.q.d.d.c;
import d.a.q.d.d.d;
/* loaded from: classes2.dex */
public abstract class BaseIPCProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6201a = "ipc/method/get_bridge";

    /* renamed from: b  reason: collision with root package name */
    public static final String f6202b = "_method_get_bridge";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6203c = "Helios";

    /* renamed from: f  reason: collision with root package name */
    public static final int f6204f = 0;

    /* renamed from: d  reason: collision with root package name */
    public e f6205d;

    /* renamed from: e  reason: collision with root package name */
    public UriMatcher f6206e = new UriMatcher(-1);

    private String a(String str) {
        return str + getAuthoritySuffix();
    }

    private synchronized void a() {
        if (this.f6205d == null) {
            this.f6205d = new e.a() { // from class: com.baidu.helios.bridge.multiprocess.BaseIPCProvider.1

                /* renamed from: e  reason: collision with root package name */
                public d f6208e;

                /* renamed from: com.baidu.helios.bridge.multiprocess.BaseIPCProvider$1$a */
                /* loaded from: classes2.dex */
                public class a implements a.c<String> {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f6209a;

                    public a(AnonymousClass1 anonymousClass1, f fVar) {
                        this.f6209a = fVar;
                    }

                    @Override // d.a.q.d.a.c
                    public void b(int i2, Exception exc, Bundle bundle) {
                        try {
                            this.f6209a.a(i2, bundle);
                        } catch (RemoteException unused) {
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // d.a.q.d.a.c
                    /* renamed from: c */
                    public void a(String str, Bundle bundle) {
                        try {
                            this.f6209a.a(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                {
                    this.f6208e = new d(BaseIPCProvider.this.getContext().getApplicationContext());
                }

                @Override // com.baidu.helios.bridge.multiprocess.e
                public Bundle a(String str, Bundle bundle) {
                    a.d f2 = this.f6208e.a().f(str, bundle);
                    if (f2 == null) {
                        return null;
                    }
                    return g.j(f2);
                }

                @Override // com.baidu.helios.bridge.multiprocess.e
                public void a(String str, Bundle bundle, f fVar) {
                    this.f6208e.a().a(str, bundle, new a(this, fVar));
                }

                @Override // com.baidu.helios.bridge.multiprocess.e
                public boolean a(String str) {
                    return this.f6208e.a().d(str);
                }
            };
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Log.i(f6203c, "provider call");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        char c2 = 65535;
        if (str.hashCode() == -1722610639 && str.equals(f6202b)) {
            c2 = 0;
        }
        if (c2 != 0) {
            return null;
        }
        a();
        g.m(bundle2, this.f6205d.asBinder());
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public abstract String getAuthoritySuffix();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f6206e.addURI(a(getContext().getPackageName()), f6201a, 0);
        Log.i(f6203c, "provider onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.f6206e.match(uri);
        Log.i(f6203c, "provider query, code = " + match);
        if (match != 0) {
            return null;
        }
        a();
        Bundle bundle = new Bundle();
        g.m(bundle, this.f6205d.asBinder());
        return new c(bundle);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
