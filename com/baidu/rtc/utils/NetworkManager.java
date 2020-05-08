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
    private static NetworkManager bwT;
    private Application mApp;
    private NetworkType bwU = null;
    private boolean isNetAvailable = true;
    private final LinkedList<a> bwV = new LinkedList<>();
    private NetworkConnectChangedReceiver bwW = new NetworkConnectChangedReceiver();
    private Object bwX = new Object();

    /* loaded from: classes6.dex */
    public interface a {
        void onNetworkChanged(NetworkType networkType, NetworkType networkType2);
    }

    private NetworkManager() {
    }

    public static NetworkManager NK() {
        if (bwT == null) {
            synchronized (NetworkManager.class) {
                if (bwT == null) {
                    bwT = new NetworkManager();
                }
            }
        }
        return bwT;
    }

    public void init(Application application) {
        this.mApp = application;
        this.bwU = aG(this.mApp);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mApp.registerReceiver(this.bwW, intentFilter);
    }

    public boolean NL() {
        return this.mApp != null;
    }

    private NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkType aG(Context context) {
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

    public NetworkType NM() {
        return this.bwU == null ? NetworkType.NETWORK_UNKNOWN : this.bwU;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.bwX) {
                if (!this.bwV.contains(aVar)) {
                    this.bwV.add(aVar);
                }
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bwX) {
                if (this.bwV.contains(aVar)) {
                    this.bwV.remove(aVar);
                }
            }
        }
    }

    public int NN() {
        if (this.bwU == null) {
            return -1;
        }
        switch (this.bwU) {
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
            NetworkType aG;
            if (intent.getAction() == "android.net.conn.CONNECTIVITY_CHANGE" && (aG = NetworkManager.this.aG(NetworkManager.this.mApp)) != NetworkManager.this.bwU) {
                NetworkType networkType = NetworkManager.this.bwU;
                NetworkManager.this.bwU = aG;
                if (!NetworkManager.this.bwV.isEmpty()) {
                    synchronized (NetworkManager.this.bwX) {
                        Iterator it = NetworkManager.this.bwV.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar != null) {
                                aVar.onNetworkChanged(NetworkManager.this.bwU, networkType);
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
