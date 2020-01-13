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
/* loaded from: classes5.dex */
public class NetworkManager {
    private static NetworkManager aTA;
    private Application mApp;
    private NetworkType aTB = null;
    private boolean isNetAvailable = true;
    private final LinkedList<a> aTC = new LinkedList<>();
    private NetworkConnectChangedReceiver aTD = new NetworkConnectChangedReceiver();
    private Object aTE = new Object();

    /* loaded from: classes5.dex */
    public interface a {
        void onNetworkChanged(NetworkType networkType, NetworkType networkType2);
    }

    private NetworkManager() {
    }

    public static NetworkManager Dv() {
        if (aTA == null) {
            synchronized (NetworkManager.class) {
                if (aTA == null) {
                    aTA = new NetworkManager();
                }
            }
        }
        return aTA;
    }

    public void init(Application application) {
        this.mApp = application;
        this.aTB = aX(this.mApp);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mApp.registerReceiver(this.aTD, intentFilter);
    }

    public boolean Dw() {
        return this.mApp != null;
    }

    private NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkType aX(Context context) {
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

    public NetworkType Dx() {
        return this.aTB == null ? NetworkType.NETWORK_UNKNOWN : this.aTB;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.aTE) {
                if (!this.aTC.contains(aVar)) {
                    this.aTC.add(aVar);
                }
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.aTE) {
                if (this.aTC.contains(aVar)) {
                    this.aTC.remove(aVar);
                }
            }
        }
    }

    public int Dy() {
        if (this.aTB == null) {
            return -1;
        }
        switch (this.aTB) {
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

    /* loaded from: classes5.dex */
    public class NetworkConnectChangedReceiver extends BroadcastReceiver {
        public NetworkConnectChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkType aX;
            if (intent.getAction() == "android.net.conn.CONNECTIVITY_CHANGE" && (aX = NetworkManager.this.aX(NetworkManager.this.mApp)) != NetworkManager.this.aTB) {
                NetworkType networkType = NetworkManager.this.aTB;
                NetworkManager.this.aTB = aX;
                if (!NetworkManager.this.aTC.isEmpty()) {
                    synchronized (NetworkManager.this.aTE) {
                        Iterator it = NetworkManager.this.aTC.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar != null) {
                                aVar.onNetworkChanged(NetworkManager.this.aTB, networkType);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
