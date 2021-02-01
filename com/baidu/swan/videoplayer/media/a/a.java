package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes15.dex */
public class a {
    private BroadcastReceiver eAO;
    private int eAP;
    private InterfaceC0548a eAQ;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0548a {
        void aD(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.eAP = getNetworkState();
        this.eAO = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.eAP) {
                    if (a.this.eAQ != null) {
                        a.this.eAQ.aD(a.this.eAP, networkState);
                    }
                    a.this.eAP = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.eAO, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.eAO);
        }
    }

    public int getNetworkState() {
        if (SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) {
            return 1;
        }
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            return 2;
        }
        return 0;
    }

    public void a(InterfaceC0548a interfaceC0548a) {
        this.eAQ = interfaceC0548a;
    }
}
