package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes11.dex */
public class a {
    private BroadcastReceiver dsi;
    private int dsj;
    private InterfaceC0465a dsk;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0465a {
        void ay(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.dsj = getNetworkState();
        this.dsi = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.dsj) {
                    if (a.this.dsk != null) {
                        a.this.dsk.ay(a.this.dsj, networkState);
                    }
                    a.this.dsj = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.dsi, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.dsi);
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

    public void a(InterfaceC0465a interfaceC0465a) {
        this.dsk = interfaceC0465a;
    }
}
