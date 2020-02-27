package com.baidu.rtc.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class NetworkManager {
    private static NetworkManager aXZ;
    private Application mApp;
    private NetworkType aYa = null;
    private boolean isNetAvailable = true;
    private final LinkedList<a> aYb = new LinkedList<>();
    private NetworkConnectChangedReceiver aYc = new NetworkConnectChangedReceiver();
    private Object aYd = new Object();

    /* loaded from: classes6.dex */
    public interface a {
        void onNetworkChanged(NetworkType networkType, NetworkType networkType2);
    }

    private NetworkManager() {
    }

    public static NetworkManager FR() {
        if (aXZ == null) {
            synchronized (NetworkManager.class) {
                if (aXZ == null) {
                    aXZ = new NetworkManager();
                }
            }
        }
        return aXZ;
    }

    public void init(Application application) {
        this.mApp = application;
        this.aYa = bb(this.mApp);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mApp.registerReceiver(this.aYc, intentFilter);
    }

    public boolean FS() {
        return this.mApp != null;
    }

    private NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkType bb(Context context) {
        NetworkType networkType = NetworkType.NETWORK_NO;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            this.isNetAvailable = true;
            if (activeNetworkInfo.getType() == 1) {
                return NetworkType.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return NetworkType.NETWORK_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return NetworkType.NETWORK_3G;
                    case 13:
                    case 18:
                        return NetworkType.NETWORK_4G;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return NetworkType.NETWORK_3G;
                        }
                        return NetworkType.NETWORK_UNKNOWN;
                }
            }
            return NetworkType.NETWORK_UNKNOWN;
        }
        NetworkType networkType2 = NetworkType.NETWORK_NO;
        this.isNetAvailable = false;
        return networkType2;
    }

    public NetworkType FT() {
        return this.aYa == null ? NetworkType.NETWORK_UNKNOWN : this.aYa;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.aYd) {
                if (!this.aYb.contains(aVar)) {
                    this.aYb.add(aVar);
                }
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.aYd) {
                if (this.aYb.contains(aVar)) {
                    this.aYb.remove(aVar);
                }
            }
        }
    }

    public int FU() {
        if (this.aYa == null) {
            return -1;
        }
        switch (this.aYa) {
            case NETWORK_WIFI:
                return 1;
            case NETWORK_2G:
                return 2;
            case NETWORK_3G:
                return 3;
            case NETWORK_4G:
                return 4;
            case NETWORK_NO:
                return 0;
            default:
                return -1;
        }
    }

    /* loaded from: classes6.dex */
    public class NetworkConnectChangedReceiver extends BroadcastReceiver {
        public NetworkConnectChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkType bb;
            if (intent.getAction() == "android.net.conn.CONNECTIVITY_CHANGE" && (bb = NetworkManager.this.bb(NetworkManager.this.mApp)) != NetworkManager.this.aYa) {
                NetworkType networkType = NetworkManager.this.aYa;
                NetworkManager.this.aYa = bb;
                if (!NetworkManager.this.aYb.isEmpty()) {
                    synchronized (NetworkManager.this.aYd) {
                        Iterator it = NetworkManager.this.aYb.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar != null) {
                                aVar.onNetworkChanged(NetworkManager.this.aYa, networkType);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum NetworkType {
        NETWORK_WIFI("WiFi"),
        NETWORK_4G("4G"),
        NETWORK_2G("2G"),
        NETWORK_3G("3G"),
        NETWORK_UNKNOWN("Unknown"),
        NETWORK_NO("No network");
        
        private String desc;

        NetworkType(String str) {
            this.desc = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.desc;
        }
    }
}
