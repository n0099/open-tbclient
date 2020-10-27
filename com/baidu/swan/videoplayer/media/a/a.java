package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes12.dex */
public class a {
    private BroadcastReceiver eiA;
    private int eiB;
    private InterfaceC0555a eiC;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0555a {
        void aH(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.eiB = getNetworkState();
        this.eiA = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.eiB) {
                    if (a.this.eiC != null) {
                        a.this.eiC.aH(a.this.eiB, networkState);
                    }
                    a.this.eiB = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.eiA, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.eiA);
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

    public void a(InterfaceC0555a interfaceC0555a) {
        this.eiC = interfaceC0555a;
    }
}
