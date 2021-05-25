package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.i;
/* loaded from: classes2.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7533a = e.class.getSimpleName();

    public void a(Context context) {
        String currentNetMode = NetworkUtil.getCurrentNetMode(context);
        String e2 = i.e();
        if (e2 == null || e2.equals(currentNetMode)) {
            return;
        }
        i.a(currentNetMode);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context);
        NetworkUtil.updateNetworkProxy(context);
    }
}
