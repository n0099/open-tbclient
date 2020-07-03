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
import com.baidu.helios.bridge.a;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.helios.bridge.multiprocess.f;
/* loaded from: classes6.dex */
public class h extends com.baidu.helios.bridge.a implements IBinder.DeathRecipient {
    private ContentProviderClient aqQ;
    private e aqR;
    private c aqS;
    private String i;

    public h(c cVar, String str) {
        this.aqS = cVar;
        this.i = str;
    }

    private Bundle a(ContentProviderClient contentProviderClient, Uri uri) {
        Cursor cursor;
        Cursor query;
        Cursor cursor2 = null;
        try {
            query = contentProviderClient.query(Uri.withAppendedPath(uri, "ipc/method/get_bridge"), null, null, null, null);
        } catch (Exception e) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Bundle extras = query.getExtras();
            com.baidu.helios.common.b.a.c.b(query);
            return extras;
        } catch (Exception e2) {
            cursor = query;
            com.baidu.helios.common.b.a.c.b(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = query;
            com.baidu.helios.common.b.a.c.b(cursor2);
            throw th;
        }
    }

    private Bundle a(ContentProviderClient contentProviderClient, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return contentProviderClient.call(str, null, null);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Bundle a(Context context, boolean z, Uri uri, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        int i = 0;
        Bundle bundle = null;
        while (true) {
            if (i >= 2) {
                break;
            }
            ContentProviderClient acquireContentProviderClient = z ? contentResolver.acquireContentProviderClient(uri) : contentResolver.acquireUnstableContentProviderClient(uri);
            if (acquireContentProviderClient != null && (bundle = a(acquireContentProviderClient, str)) == null) {
                bundle = a(acquireContentProviderClient, uri);
            }
            if (bundle != null) {
                this.aqQ = acquireContentProviderClient;
                break;
            }
            try {
                Thread.sleep(20L);
            } catch (InterruptedException e) {
            }
            i++;
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(a.d dVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("errcode", dVar.errCode);
        bundle.putString("id", dVar.id);
        return bundle;
    }

    private String a(Context context) {
        return context.getPackageName() + this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Bundle bundle, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("bridge_binder", iBinder);
        } else {
            bundle.putParcelable("bridge_binder", new b(iBinder));
        }
    }

    private e ag(Context context) {
        IBinder j;
        Bundle a = a(context, false, Uri.parse("content://" + a(context)), "_method_get_bridge");
        Log.i("Helios-mul", new StringBuilder().append("remote bridge bundle result is ").append(a).toString() == null ? "null" : "non-null");
        if (a != null && (j = j(a)) != null) {
            return e.a.a(j);
        }
        return null;
    }

    static a.d i(Bundle bundle) {
        return new a.d(bundle.getInt("errcode"), bundle.getString("id"), null);
    }

    static IBinder j(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder("bridge_binder");
        }
        try {
            bundle.setClassLoader(b.class.getClassLoader());
            return ((b) bundle.getParcelable("bridge_binder")).a();
        } catch (Exception e) {
            Log.e("Helios-mul", "parcel", e);
            return null;
        }
    }

    @Override // com.baidu.helios.bridge.a
    public void a(String str, Bundle bundle, final a.c<String> cVar) {
        try {
            this.aqR.a(str, bundle, new f.a() { // from class: com.baidu.helios.bridge.multiprocess.g.1
                @Override // com.baidu.helios.bridge.multiprocess.f
                public void a(int i, Bundle bundle2) {
                    cVar.a(i, null, bundle2);
                }

                @Override // com.baidu.helios.bridge.multiprocess.f
                public void a(String str2, Bundle bundle2) {
                    cVar.a(str2, bundle2);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean a() {
        return this.aqR != null;
    }

    @Override // com.baidu.helios.bridge.a
    public void b(a.b bVar) {
        this.aqR = ag(this.aql.applicationContext);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.aqS.a();
    }

    @Override // com.baidu.helios.bridge.a
    public a.d d(String str, Bundle bundle) {
        try {
            Bundle a = this.aqR.a(str, bundle);
            if (a != null) {
                return i(a);
            }
        } catch (RemoteException e) {
        }
        return a.d.d(-1, null);
    }

    @Override // com.baidu.helios.bridge.a
    public boolean dX(String str) {
        try {
            return this.aqR.a(str);
        } catch (RemoteException e) {
            return false;
        }
    }
}
