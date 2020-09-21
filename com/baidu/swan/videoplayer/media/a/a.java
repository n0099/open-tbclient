package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes25.dex */
public class a {
    private BroadcastReceiver dOc;
    private int dOd;
    private InterfaceC0524a dOe;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0524a {
        void aH(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.dOd = getNetworkState();
        this.dOc = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.dOd) {
                    if (a.this.dOe != null) {
                        a.this.dOe.aH(a.this.dOd, networkState);
                    }
                    a.this.dOd = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.dOc, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.dOc);
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

    public void a(InterfaceC0524a interfaceC0524a) {
        this.dOe = interfaceC0524a;
    }
}
