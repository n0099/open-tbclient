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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IPCServiceManager {
    private static volatile IPCServiceManagerAidl aVG;
    private static final a aVH = new a();
    private static IPCServiceManagerAidlImpl aVI;
    static ContentProviderClient aVJ;

    public static IBinder o(final String str, boolean z) {
        if (z) {
            return new f() { // from class: com.baidu.pyramid.runtime.multiprocess.IPCServiceManager.1
                @Override // com.baidu.pyramid.runtime.multiprocess.f
                protected IBinder EY() throws RemoteException {
                    return IPCServiceManager.EV().getService(str);
                }
            };
        }
        try {
            return EV().getService(str);
        } catch (RemoteException e) {
            d("MultiProcess", e);
            g.h(e);
            return null;
        }
    }

    public static void addService(String str, IBinder iBinder, boolean z) {
        try {
            EV().addService(str, iBinder, z);
        } catch (RemoteException e) {
            d("MultiProcess", e);
            g.h(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IPCServiceManagerAidl EV() {
        IPCServiceManagerAidl iPCServiceManagerAidl = aVG;
        if (iPCServiceManagerAidl == null) {
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(aVH);
            aVG = asInterface;
            return asInterface;
        }
        return iPCServiceManagerAidl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle EU() {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("service", EW());
        }
        return bundle;
    }

    private static IPCServiceManagerAidlImpl EW() {
        if (aVI == null) {
            aVI = new IPCServiceManagerAidlImpl();
        }
        return aVI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends f {
        private static final Uri aVK = Uri.parse("content://" + ServerProvider.Fh() + "/ipc_manager/method/get_service_handler");

        private a() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.f
        protected IBinder EY() {
            ContentResolver contentResolver = e.getAppContext().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle a = a(contentResolver, jSONObject);
            if (a == null) {
                a = b(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                g.eU(jSONObject.toString());
            }
            if (a != null && Build.VERSION.SDK_INT >= 18) {
                return a.getBinder("service");
            }
            return null;
        }

        private Bundle a(ContentResolver contentResolver, JSONObject jSONObject) {
            Bundle bundle = null;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                ContentProviderClient acquireContentProviderClient = contentResolver.acquireContentProviderClient(ServerProvider.Fh());
                if (acquireContentProviderClient != null && (bundle = a(acquireContentProviderClient, jSONObject)) == null) {
                    bundle = b(acquireContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.aVJ = acquireContentProviderClient;
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
                bundle = a(contentResolver, aVK, jSONObject);
                if (bundle == null) {
                    bundle = b(contentResolver, aVK, jSONObject);
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
                if (Build.VERSION.SDK_INT >= 17) {
                    return contentProviderClient.call("_get_service_handler", null, null);
                }
                return null;
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientCall", g.i(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.d("getServicerBinder", e);
                return null;
            }
        }

        private Bundle b(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.query(aVK, null, null, null, null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientQuery", g.i(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.d("getServicerBinder", e);
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
                IPCServiceManager.d("getServicerBinder", e);
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
                IPCServiceManager.d("getServicerBinder", e);
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
    public static void d(String str, Exception exc) {
    }
}
