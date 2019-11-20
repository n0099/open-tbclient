package com.baidu.pyramid.runtime.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.runtime.multiprocess.components.ServerProvider;
import com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IPCServiceManager {
    private static volatile IPCServiceManagerAidl aCl;
    private static final a aCm = new a();
    private static IPCServiceManagerAidlImpl aCn;
    static ContentProviderClient aCo;

    public static IBinder k(final String str, boolean z) {
        if (z) {
            return new f() { // from class: com.baidu.pyramid.runtime.multiprocess.IPCServiceManager.1
                @Override // com.baidu.pyramid.runtime.multiprocess.f
                protected IBinder Ah() throws RemoteException {
                    return IPCServiceManager.Ae().getService(str);
                }
            };
        }
        try {
            return Ae().getService(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            g.h(e);
            return null;
        }
    }

    public static void addService(String str, IBinder iBinder, boolean z) {
        try {
            Ae().addService(str, iBinder, z);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            g.h(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IPCServiceManagerAidl Ae() {
        IPCServiceManagerAidl iPCServiceManagerAidl = aCl;
        if (iPCServiceManagerAidl == null) {
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(aCm);
            aCl = asInterface;
            return asInterface;
        }
        return iPCServiceManagerAidl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle Ad() {
        Bundle bundle = new Bundle();
        bundle.putBinder("service", Af());
        return bundle;
    }

    private static IPCServiceManagerAidlImpl Af() {
        if (aCn == null) {
            aCn = new IPCServiceManagerAidlImpl();
        }
        return aCn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends f {
        private static final Uri aCp = Uri.parse("content://" + ServerProvider.Aq() + "/ipc_manager/method/get_service_handler");

        private a() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.f
        protected IBinder Ah() {
            ContentResolver contentResolver = e.getAppContext().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle a = a(contentResolver, jSONObject);
            if (a == null) {
                a = b(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                g.dK(jSONObject.toString());
            }
            if (a == null) {
                return null;
            }
            return a.getBinder("service");
        }

        private Bundle a(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                ContentProviderClient acquireContentProviderClient = contentResolver.acquireContentProviderClient(ServerProvider.Aq());
                if (acquireContentProviderClient != null && (bundle = a(acquireContentProviderClient, jSONObject)) == null) {
                    bundle = b(acquireContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.aCo = acquireContentProviderClient;
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
                bundle = a(contentResolver, aCp, jSONObject);
                if (bundle == null) {
                    bundle = b(contentResolver, aCp, jSONObject);
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
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientCall", g.i(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.c("getServicerBinder", e);
                return null;
            }
        }

        private Bundle b(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.query(aCp, null, null, null, null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientQuery", g.i(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.c("getServicerBinder", e);
                return null;
            }
        }

        private Bundle a(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.call(uri, "_get_service_handler", (String) null, (Bundle) null);
            } catch (Exception e) {
                try {
                    jSONObject.put("useContentResolverCall", g.i(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.c("getServicerBinder", e);
                return null;
            }
        }

        private Bundle b(ContentResolver contentResolver, Uri uri, JSONObject jSONObject) {
            try {
                return contentResolver.query(uri, null, null, null, null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useContentResolverQuery", g.i(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.c("getServicerBinder", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class IPCServiceManagerAidlImpl extends IPCServiceManagerAidl.Stub {
        private IPCServiceManagerAidlImpl() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public IBinder getService(String str) throws RemoteException {
            return h.getService(str);
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public boolean removeService(String str) throws RemoteException {
            return h.removeService(str);
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.internal.IPCServiceManagerAidl
        public void addService(String str, IBinder iBinder, boolean z) throws RemoteException {
            h.addService(str, iBinder, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, Exception exc) {
    }
}
