package com.baidu.clientupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.util.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClientUpdater f1322a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClientUpdater clientUpdater) {
        this.f1322a = clientUpdater;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogUtil.logE("ClientUpdater", "receive:android.net.conn.CONNECTIVITY_CHANGE");
        this.f1322a.a();
    }
}
