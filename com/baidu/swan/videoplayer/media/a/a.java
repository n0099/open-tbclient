package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class a {
    private BroadcastReceiver dCL;
    private int dCM;
    private InterfaceC0483a dCN;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0483a {
        void aA(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.dCM = getNetworkState();
        this.dCL = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.dCM) {
                    if (a.this.dCN != null) {
                        a.this.dCN.aA(a.this.dCM, networkState);
                    }
                    a.this.dCM = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.dCL, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.dCL);
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

    public void a(InterfaceC0483a interfaceC0483a) {
        this.dCN = interfaceC0483a;
    }
}
