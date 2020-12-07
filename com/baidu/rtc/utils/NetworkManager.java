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
/* loaded from: classes11.dex */
public class NetworkManager {
    private static NetworkManager cxf;
    private Application mApp;
    private NetworkType cxg = null;
    private boolean isNetAvailable = true;
    private final LinkedList<a> cxh = new LinkedList<>();
    private NetworkConnectChangedReceiver cxi = new NetworkConnectChangedReceiver();
    private Object cxj = new Object();

    /* loaded from: classes11.dex */
    public interface a {
        void onNetworkChanged(NetworkType networkType, NetworkType networkType2);
    }

    private NetworkManager() {
    }

    public static NetworkManager ahC() {
        if (cxf == null) {
            synchronized (NetworkManager.class) {
                if (cxf == null) {
                    cxf = new NetworkManager();
                }
            }
        }
        return cxf;
    }

    public void d(Application application) {
        this.mApp = application;
        this.cxg = bI(this.mApp);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mApp.registerReceiver(this.cxi, intentFilter);
    }

    public boolean ahD() {
        return this.mApp != null;
    }

    private NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkType bI(Context context) {
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

    public NetworkType ahE() {
        return this.cxg == null ? NetworkType.NETWORK_UNKNOWN : this.cxg;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.cxj) {
                if (!this.cxh.contains(aVar)) {
                    this.cxh.add(aVar);
                }
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.cxj) {
                if (this.cxh.contains(aVar)) {
                    this.cxh.remove(aVar);
                }
            }
        }
    }

    public int ahF() {
        if (this.cxg == null) {
            return -1;
        }
        switch (this.cxg) {
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

    /* loaded from: classes11.dex */
    public class NetworkConnectChangedReceiver extends BroadcastReceiver {
        public NetworkConnectChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkType bI;
            if (intent.getAction() == "android.net.conn.CONNECTIVITY_CHANGE" && (bI = NetworkManager.this.bI(NetworkManager.this.mApp)) != NetworkManager.this.cxg) {
                NetworkType networkType = NetworkManager.this.cxg;
                NetworkManager.this.cxg = bI;
                if (!NetworkManager.this.cxh.isEmpty()) {
                    synchronized (NetworkManager.this.cxj) {
                        Iterator it = NetworkManager.this.cxh.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar != null) {
                                aVar.onNetworkChanged(NetworkManager.this.cxg, networkType);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
