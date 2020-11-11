package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes12.dex */
public class a {
    private BroadcastReceiver eou;
    private int eov;
    private InterfaceC0567a eow;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0567a {
        void aH(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.eov = getNetworkState();
        this.eou = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.eov) {
                    if (a.this.eow != null) {
                        a.this.eow.aH(a.this.eov, networkState);
                    }
                    a.this.eov = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.eou, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.eou);
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

    public void a(InterfaceC0567a interfaceC0567a) {
        this.eow = interfaceC0567a;
    }
}
