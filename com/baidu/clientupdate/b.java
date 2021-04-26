package com.baidu.clientupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.util.LogUtil;
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientUpdater f4720a;

    public b(ClientUpdater clientUpdater) {
        this.f4720a = clientUpdater;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogUtil.logE("ClientUpdater", "receive:android.net.conn.CONNECTIVITY_CHANGE");
        this.f4720a.a();
    }
}
