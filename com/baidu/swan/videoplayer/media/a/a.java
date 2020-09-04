package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes9.dex */
public class a {
    private BroadcastReceiver dLZ;
    private int dMa;
    private InterfaceC0529a dMb;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0529a {
        void aH(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.dMa = getNetworkState();
        this.dLZ = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.dMa) {
                    if (a.this.dMb != null) {
                        a.this.dMb.aH(a.this.dMa, networkState);
                    }
                    a.this.dMa = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.dLZ, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.dLZ);
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

    public void a(InterfaceC0529a interfaceC0529a) {
        this.dMb = interfaceC0529a;
    }
}
