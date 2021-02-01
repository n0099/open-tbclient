package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.f;
/* loaded from: classes4.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3024a = e.class.getSimpleName();

    public void a(Context context) {
        String currentNetMode = NetworkUtil.getCurrentNetMode(context);
        String e = f.e();
        if (e == null || e.equals(currentNetMode)) {
            return;
        }
        f.a(currentNetMode);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context);
        NetworkUtil.updateNetworkProxy(context);
    }
}
