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
/* loaded from: classes7.dex */
public class IPCServiceManager {
    private static volatile IPCServiceManagerAidl bMI;
    private static final a bMJ = new a();
    private static IPCServiceManagerAidlImpl bMK;
    static ContentProviderClient bML;

    public static IBinder E(final String str, boolean z) {
        if (z) {
            return new f() { // from class: com.baidu.pyramid.runtime.multiprocess.IPCServiceManager.1
                @Override // com.baidu.pyramid.runtime.multiprocess.f
                protected IBinder Wq() throws RemoteException {
                    return IPCServiceManager.Wn().getService(str);
                }
            };
        }
        try {
            return Wn().getService(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            g.k(e);
            return null;
        }
    }

    public static void addService(String str, IBinder iBinder, boolean z) {
        try {
            Wn().addService(str, iBinder, z);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            g.k(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IPCServiceManagerAidl Wn() {
        IPCServiceManagerAidl iPCServiceManagerAidl = bMI;
        if (iPCServiceManagerAidl == null) {
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(bMJ);
            bMI = asInterface;
            return asInterface;
        }
        return iPCServiceManagerAidl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle Wm() {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("service", Wo());
        } else {
            bundle.putParcelable("service", new BindlerHolder(Wo()));
        }
        return bundle;
    }

    private static IPCServiceManagerAidlImpl Wo() {
        if (bMK == null) {
            bMK = new IPCServiceManagerAidlImpl();
        }
        return bMK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends f {
        private static final Uri bMM = Uri.parse("content://" + ServerProvider.Wz() + "/ipc_manager/method/get_service_handler");

        private a() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.f
        protected IBinder Wq() {
            ContentResolver contentResolver = e.getAppContext().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle a = a(contentResolver, jSONObject);
            if (a == null) {
                a = b(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                g.iq(jSONObject.toString());
            }
            if (a == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return a.getBinder("service");
            }
            a.setClassLoader(BindlerHolder.class.getClassLoader());
            BindlerHolder bindlerHolder = (BindlerHolder) a.getParcelable("service");
            if (bindlerHolder != null) {
                return bindlerHolder.Wl();
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
                ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(ServerProvider.Wz());
                if (acquireUnstableContentProviderClient != null && (bundle = a(acquireUnstableContentProviderClient, jSONObject)) == null) {
                    bundle = b(acquireUnstableContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.bML = acquireUnstableContentProviderClient;
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
                bundle = a(contentResolver, bMM, jSONObject);
                if (bundle == null) {
                    bundle = b(contentResolver, bMM, jSONObject);
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
                    jSONObject.put("useProviderClientCall", g.l(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.c("getServicerBinder", e);
                return null;
            }
        }

        private Bundle b(ContentProviderClient contentProviderClient, JSONObject jSONObject) {
            try {
                return contentProviderClient.query(bMM, null, null, null, null).getExtras();
            } catch (Exception e) {
                try {
                    jSONObject.put("useProviderClientQuery", g.l(e));
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
                    jSONObject.put("useContentResolverCall", g.l(e));
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
                    jSONObject.put("useContentResolverQuery", g.l(e));
                } catch (JSONException e2) {
                }
                IPCServiceManager.c("getServicerBinder", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
