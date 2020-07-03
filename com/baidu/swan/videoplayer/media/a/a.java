package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes11.dex */
public class a {
    private BroadcastReceiver dwT;
    private int dwU;
    private InterfaceC0471a dwV;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0471a {
        void aA(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.dwU = getNetworkState();
        this.dwT = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.dwU) {
                    if (a.this.dwV != null) {
                        a.this.dwV.aA(a.this.dwU, networkState);
                    }
                    a.this.dwU = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.dwT, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.dwT);
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

    public void a(InterfaceC0471a interfaceC0471a) {
        this.dwV = interfaceC0471a;
    }
}
