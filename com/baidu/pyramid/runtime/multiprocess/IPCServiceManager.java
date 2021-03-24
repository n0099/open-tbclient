package com.baidu.pyramid.runtime.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.runtime.multiprocess.components.ServerProvider;
import com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl;
import d.b.d0.b.a.e;
import d.b.d0.b.a.f;
import d.b.d0.b.a.g;
import d.b.d0.b.a.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IPCServiceManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile IPCServiceManagerAidl f10501a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f10502b = new b(null);

    /* renamed from: c  reason: collision with root package name */
    public static IPCServiceManagerAidlImpl f10503c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentProviderClient f10504d;

    /* loaded from: classes2.dex */
    public static class IPCServiceManagerAidlImpl extends IPCServiceManagerAidl.Stub {
        public IPCServiceManagerAidlImpl() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            h.a(str, iBinder, z);
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public IBinder getService(String str) throws RemoteException {
            return h.d(str);
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public boolean removeService(String str) throws RemoteException {
            return h.e(str);
        }

        public /* synthetic */ IPCServiceManagerAidlImpl(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends f {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10505h;

        public a(String str) {
            this.f10505h = str;
        }

        @Override // d.b.d0.b.a.f
        public IBinder c() throws RemoteException {
            return IPCServiceManager.g().getService(this.f10505h);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends f {

        /* renamed from: h  reason: collision with root package name */
        public static final Uri f10506h = Uri.parse("content://" + ServerProvider.getCoreProviderAuthority() + "/ipc_manager/method/get_service_handler");

        public b() {
        }

        @Override // d.b.d0.b.a.f
        public IBinder c() {
            ContentResolver contentResolver = e.a().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle f2 = f(contentResolver, jSONObject);
            if (f2 == null) {
                f2 = i(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                g.c(jSONObject.toString());
            }
            if (f2 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return f2.getBinder("service");
            }
            f2.setClassLoader(BindlerHolder.class.getClassLoader());
            BindlerHolder bindlerHolder = (BindlerHolder) f2.getParcelable("service");
            if (bindlerHolder != null) {
                return bindlerHolder.a();
            }
            return null;
        }

        public final Bundle d(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.call(uri, "_get_service_handler", (String) null, (Bundle) null);
            } catch (Exception e2) {
                try {
                    jSONObject.put("useContentResolverCall", g.a(e2));
                } catch (JSONException unused) {
                }
                IPCServiceManager.h("getServicerBinder", e2);
                return null;
            }
        }

        public final Bundle e(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.query(uri, null, null, null, null).getExtras();
            } catch (Exception e2) {
                try {
                    jSONObject.put("useContentResolverQuery", g.a(e2));
                } catch (JSONException unused) {
                }
                IPCServiceManager.h("getServicerBinder", e2);
                return null;
            }
        }

        public final Bundle f(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(ServerProvider.getCoreProviderAuthority());
                if (acquireUnstableContentProviderClient != null && (bundle = g(acquireUnstableContentProviderClient, jSONObject)) == null) {
                    bundle = h(acquireUnstableContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.f10504d = acquireUnstableContentProviderClient;
                    break;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
                i++;
            }
            return bundle;
        }

        public final Bundle g(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    return contentProviderClient.call("_get_service_handler", null, null);
                }
            } catch (Exception e2) {
                try {
                    jSONObject.put("useProviderClientCall", g.a(e2));
                } catch (JSONException unused) {
                }
                IPCServiceManager.h("getServicerBinder", e2);
            }
            return null;
        }

        public final Bundle h(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.query(f10506h, null, null, null, null).getExtras();
            } catch (Exception e2) {
                try {
                    jSONObject.put("useProviderClientQuery", g.a(e2));
                } catch (JSONException unused) {
                }
                IPCServiceManager.h("getServicerBinder", e2);
                return null;
            }
        }

        public final Bundle i(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            for (int i = 0; i < 2; i++) {
                bundle = d(contentResolver, f10506h, jSONObject);
                if (bundle == null) {
                    bundle = e(contentResolver, f10506h, jSONObject);
                }
                if (bundle != null) {
                    break;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
            return bundle;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static void c(String str, IBinder iBinder, boolean z) {
        try {
            g().addService(str, iBinder, z);
        } catch (RemoteException e2) {
            h("MultiProcess", e2);
            g.b(e2);
        }
    }

    public static Bundle d() {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("service", e());
        } else {
            bundle.putParcelable("service", new BindlerHolder(e()));
        }
        return bundle;
    }

    public static IPCServiceManagerAidlImpl e() {
        if (f10503c == null) {
            f10503c = new IPCServiceManagerAidlImpl(null);
        }
        return f10503c;
    }

    public static IBinder f(String str, boolean z) {
        if (z) {
            return new a(str);
        }
        try {
            return g().getService(str);
        } catch (RemoteException e2) {
            h("MultiProcess", e2);
            g.b(e2);
            return null;
        }
    }

    public static IPCServiceManagerAidl g() {
        IPCServiceManagerAidl iPCServiceManagerAidl = f10501a;
        if (iPCServiceManagerAidl != null) {
            return iPCServiceManagerAidl;
        }
        IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(f10502b);
        f10501a = asInterface;
        return asInterface;
    }

    public static void h(String str, Exception exc) {
    }
}
