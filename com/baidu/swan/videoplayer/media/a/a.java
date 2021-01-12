package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes14.dex */
public class a {
    private BroadcastReceiver eyH;
    private int eyI;
    private InterfaceC0551a eyJ;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0551a {
        void aG(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.eyI = getNetworkState();
        this.eyH = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.eyI) {
                    if (a.this.eyJ != null) {
                        a.this.eyJ.aG(a.this.eyI, networkState);
                    }
                    a.this.eyI = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.eyH, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.eyH);
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

    public void a(InterfaceC0551a interfaceC0551a) {
        this.eyJ = interfaceC0551a;
    }
}
