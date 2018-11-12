package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.e;
/* loaded from: classes4.dex */
public class d extends BroadcastReceiver {
    public static final String a = d.class.getSimpleName();

    public void a(Context context) {
        String currentNetMode = NetworkUtil.getCurrentNetMode(context);
        String e = e.e();
        if (e == null || e.equals(currentNetMode)) {
            return;
        }
        e.a(currentNetMode);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context);
        NetworkUtil.updateNetworkProxy(context);
    }
}
