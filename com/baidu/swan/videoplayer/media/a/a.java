package com.baidu.swan.videoplayer.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes14.dex */
public class a {
    private BroadcastReceiver eCp;
    private int eCq;
    private InterfaceC0554a eCr;
    private Context mContext;

    /* renamed from: com.baidu.swan.videoplayer.media.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0554a {
        void aD(int i, int i2);
    }

    public void register(Context context) {
        this.mContext = context;
        this.eCq = getNetworkState();
        this.eCp = new BroadcastReceiver() { // from class: com.baidu.swan.videoplayer.media.a.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int networkState;
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (networkState = a.this.getNetworkState()) != a.this.eCq) {
                    if (a.this.eCr != null) {
                        a.this.eCr.aD(a.this.eCq, networkState);
                    }
                    a.this.eCq = networkState;
                }
            }
        };
        this.mContext.registerReceiver(this.eCp, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this.eCp);
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

    public void a(InterfaceC0554a interfaceC0554a) {
        this.eCr = interfaceC0554a;
    }
}
