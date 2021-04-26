package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.helios.bridge.multiprocess.f;
import d.a.q.d.a;
import d.a.q.g.c.a.c;
/* loaded from: classes2.dex */
public class g extends a implements IBinder.DeathRecipient {

    /* renamed from: g  reason: collision with root package name */
    public ContentProviderClient f6423g;

    /* renamed from: h  reason: collision with root package name */
    public e f6424h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q.d.d.b f6425i;
    public String j;

    public g(d.a.q.d.d.b bVar, String str) {
        this.f6425i = bVar;
        this.j = str;
    }

    public static Bundle j(a.d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("errcode", dVar.f63538b);
        bundle.putString("id", dVar.f63537a);
        return bundle;
    }

    public static a.d k(Bundle bundle) {
        return new a.d(bundle.getInt("errcode"), bundle.getString("id"), null);
    }

    public static void m(Bundle bundle, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("bridge_binder", iBinder);
        } else {
            bundle.putParcelable("bridge_binder", new b(iBinder));
        }
    }

    public static IBinder o(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder("bridge_binder");
        }
        try {
            bundle.setClassLoader(b.class.getClassLoader());
            return ((b) bundle.getParcelable("bridge_binder")).a();
        } catch (Exception e2) {
            Log.e("Helios-mul", "parcel", e2);
            return null;
        }
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        try {
            this.f6424h.a(str, bundle, new f.a() { // from class: com.baidu.helios.bridge.multiprocess.g.1
                @Override // com.baidu.helios.bridge.multiprocess.f
                public void a(int i2, Bundle bundle2) {
                    cVar.b(i2, null, bundle2);
                }

                @Override // com.baidu.helios.bridge.multiprocess.f
                public void a(String str2, Bundle bundle2) {
                    cVar.a(str2, bundle2);
                }
            });
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.f6425i.j();
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        try {
            return this.f6424h.a(str);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        this.f6424h = p(this.f63530e.f63534c);
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        try {
            Bundle a2 = this.f6424h.a(str, bundle);
            if (a2 != null) {
                return k(a2);
            }
        } catch (RemoteException unused) {
        }
        return a.d.a(-1, null);
    }

    public final Bundle g(ContentProviderClient contentProviderClient, Uri uri) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = contentProviderClient.query(Uri.withAppendedPath(uri, BaseIPCProvider.f6404a), null, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Bundle extras = cursor.getExtras();
            c.a(cursor);
            return extras;
        } catch (Exception unused2) {
            c.a(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            c.a(cursor2);
            throw th;
        }
    }

    public final Bundle h(ContentProviderClient contentProviderClient, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return contentProviderClient.call(str, null, null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final Bundle i(Context context, boolean z, Uri uri, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        Bundle bundle = null;
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            ContentProviderClient acquireContentProviderClient = z ? contentResolver.acquireContentProviderClient(uri) : contentResolver.acquireUnstableContentProviderClient(uri);
            if (acquireContentProviderClient != null && (bundle = h(acquireContentProviderClient, str)) == null) {
                bundle = g(acquireContentProviderClient, uri);
            }
            if (bundle != null) {
                this.f6423g = acquireContentProviderClient;
                break;
            }
            try {
                Thread.sleep(20L);
            } catch (InterruptedException unused) {
            }
            i2++;
        }
        return bundle;
    }

    public final String l(Context context) {
        return context.getPackageName() + this.j;
    }

    public boolean n() {
        return this.f6424h != null;
    }

    public final e p(Context context) {
        IBinder o;
        Bundle i2 = i(context, false, Uri.parse("content://" + l(context)), BaseIPCProvider.f6405b);
        StringBuilder sb = new StringBuilder();
        sb.append("remote bridge bundle result is ");
        sb.append(i2);
        Log.i("Helios-mul", sb.toString() == null ? StringUtil.NULL_STRING : "non-null");
        if (i2 == null || (o = o(i2)) == null) {
            return null;
        }
        return e.a.a(o);
    }
}
