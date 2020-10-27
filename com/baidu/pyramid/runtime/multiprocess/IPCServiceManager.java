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
/* loaded from: classes16.dex */
public class IPCServiceManager {
    private static volatile IPCServiceManagerAidl cdU;
    private static final a cdV = new a();
    private static IPCServiceManagerAidlImpl cdW;
    static ContentProviderClient cdX;

    public static IBinder J(final String str, boolean z) {
        if (z) {
            return new f() { // from class: com.baidu.pyramid.runtime.multiprocess.IPCServiceManager.1
                @Override // com.baidu.pyramid.runtime.multiprocess.f
                protected IBinder aaP() throws RemoteException {
                    return IPCServiceManager.aaM().getService(str);
                }
            };
        }
        try {
            return aaM().getService(str);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            g.k(e);
            return null;
        }
    }

    public static void addService(String str, IBinder iBinder, boolean z) {
        try {
            aaM().addService(str, iBinder, z);
        } catch (RemoteException e) {
            c("MultiProcess", e);
            g.k(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IPCServiceManagerAidl aaM() {
        IPCServiceManagerAidl iPCServiceManagerAidl = cdU;
        if (iPCServiceManagerAidl == null) {
            IPCServiceManagerAidl asInterface = IPCServiceManagerAidl.Stub.asInterface(cdV);
            cdU = asInterface;
            return asInterface;
        }
        return iPCServiceManagerAidl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle aaL() {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder("service", aaN());
        } else {
            bundle.putParcelable("service", new BindlerHolder(aaN()));
        }
        return bundle;
    }

    private static IPCServiceManagerAidlImpl aaN() {
        if (cdW == null) {
            cdW = new IPCServiceManagerAidlImpl();
        }
        return cdW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a extends f {
        private static final Uri cdY = Uri.parse("content://" + ServerProvider.aaY() + "/ipc_manager/method/get_service_handler");

        private a() {
        }

        @Override // com.baidu.pyramid.runtime.multiprocess.f
        protected IBinder aaP() {
            ContentResolver contentResolver = e.getAppContext().getContentResolver();
            JSONObject jSONObject = new JSONObject();
            Bundle a2 = a(contentResolver, jSONObject);
            if (a2 == null) {
                a2 = b(contentResolver, jSONObject);
            }
            if (jSONObject.length() != 0) {
                g.jF(jSONObject.toString());
            }
            if (a2 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return a2.getBinder("service");
            }
            a2.setClassLoader(BindlerHolder.class.getClassLoader());
            BindlerHolder bindlerHolder = (BindlerHolder) a2.getParcelable("service");
            if (bindlerHolder != null) {
                return bindlerHolder.aaK();
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
                ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(ServerProvider.aaY());
                if (acquireUnstableContentProviderClient != null && (bundle = a(acquireUnstableContentProviderClient, jSONObject)) == null) {
                    bundle = b(acquireUnstableContentProviderClient, jSONObject);
                }
                if (bundle != null) {
                    IPCServiceManager.cdX = acquireUnstableContentProviderClient;
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
                bundle = a(contentResolver, cdY, jSONObject);
                if (bundle == null) {
                    bundle = b(contentResolver, cdY, jSONObject);
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
                return contentProviderClient.query(cdY, null, null, null, null).getExtras();
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
    /* loaded from: classes16.dex */
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
