package com.baidu.pyramid.runtime.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.components.ServerProvider;
import com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IPCServiceManager {
    private static volatile IPCServiceManagerAidl agE;
    private static IPCServiceManagerAidlImpl agG;
    static ContentProviderClient agH;
    private static final boolean DEBUG = i.DEBUG;
    private static final a agF = new a();

    public static IBinder m(final String str, boolean z) {
        if (z) {
            return new h() { // from class: com.baidu.pyramid.runtime.multiprocess.IPCServiceManager.1
                @Override // com.baidu.pyramid.runtime.multiprocess.h
                protected IBinder uo() throws RemoteException {
                    return IPCServiceManager.ul().getService(str);
                }
            };
        }
        try {
            return ul().getService(str);
        } catch (RemoteException e) {
            g("MultiProcess", e);
            j.i(e);
            return null;
        }
    }

    public static void addService(String str, IBinder iBinder, boolean z) {
        try {
            ul().addService(str, iBinder, z);
        } catch (RemoteException e) {
            g("MultiProcess", e);
            j.i(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IPCServiceManagerAidl ul() {
        IPCServiceManagerAidl iPCServiceManagerAidl = agE;
        if (iPCServiceManagerAidl == null) {
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(agF);
            agE = asInterface;
            return asInterface;
        }
        return iPCServiceManagerAidl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle uk() {
        Bundle bundle = new Bundle();
        c.a(bundle, NotificationCompat.CATEGORY_SERVICE, um());
        return bundle;
    }

    private static IPCServiceManagerAidlImpl um() {
        if (agG == null) {
            agG = new IPCServiceManagerAidlImpl();
        }
        return agG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends h {
        private static final Uri agI = Uri.parse("content://" + ServerProvider.uv() + "/ipc_manager/method/get_service_handler");

        private a() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.h
        protected IBinder uo() {
            ContentResolver contentResolver = g.getAppContext().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle a = a(contentResolver, jSONObject);
            if (a == null) {
                a = b(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                j.dj(jSONObject.toString());
            }
            if (a == null) {
                return null;
            }
            return c.getBinder(a, NotificationCompat.CATEGORY_SERVICE);
        }

        private Bundle a(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                ContentProviderClient acquireContentProviderClient = contentResolver.acquireContentProviderClient(ServerProvider.uv());
                if (acquireContentProviderClient != null && (bundle = a(acquireContentProviderClient, jSONObject)) == null) {
                    bundle = b(acquireContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.agH = acquireContentProviderClient;
                    break;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                }
                i++;
            }
            return bundle;
        }

        private Bundle b(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            for (int i = 0; i < 2; i++) {
                bundle = a(contentResolver, agI, jSONObject);
                if (bundle == null) {
                    bundle = b(contentResolver, agI, jSONObject);
                }
                if (bundle != null) {
                    break;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                }
            }
            return bundle;
        }

        private Bundle a(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.call("_get_service_handler", null, null);
            } catch (Throwable th) {
                try {
                    jSONObject.put("useProviderClientCall", j.l(th));
                } catch (JSONException e) {
                }
                IPCServiceManager.g("getServicerBinder", th);
                return null;
            }
        }

        private Bundle b(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.query(agI, null, null, null, null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientQuery", j.l(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.g("getServicerBinder", e);
                return null;
            }
        }

        private Bundle a(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.call(uri, "_get_service_handler", (String) null, (Bundle) null);
            } catch (Exception e) {
                try {
                    jSONObject.put("useContentResolverCall", j.l(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.g("getServicerBinder", e);
                return null;
            }
        }

        private Bundle b(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.query(uri, null, null, null, null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useContentResolverQuery", j.l(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.g("getServicerBinder", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class IPCServiceManagerAidlImpl extends IPCServiceManagerAidl.Stub {
        private IPCServiceManagerAidlImpl() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public IBinder getService(String str) throws RemoteException {
            return k.getService(str);
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public boolean removeService(String str) throws RemoteException {
            return k.removeService(str);
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            k.addService(str, iBinder, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str, Throwable th) {
        if (DEBUG) {
            Log.e(str, "", th);
        }
    }
}
