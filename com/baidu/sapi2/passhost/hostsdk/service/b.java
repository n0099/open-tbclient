package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.sapi2.passhost.hostsdk.service.ConnectReceiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class b implements ConnectReceiver.a {
    private static final String a = "NetworkEngineService";
    private Context b;
    private ExecutorService c;
    private ConnectReceiver d;

    /* loaded from: classes.dex */
    private static class a {
        public static b a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }

    private b() {
        this.c = Executors.newSingleThreadExecutor();
    }

    public void a(Context context) {
        this.b = context;
        this.d = new ConnectReceiver(this);
    }

    public void b() {
        Log.d(a, "start()");
        this.b.registerReceiver(this.d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void c() {
        Log.d(a, "stop()");
        this.b.unregisterReceiver(this.d);
    }

    public void a(Apn.IOnChange iOnChange) {
        Apn.setIOnChange(iOnChange);
    }

    @Override // com.baidu.sapi2.passhost.hostsdk.service.ConnectReceiver.a
    public void a(Runnable runnable) {
        this.c.submit(runnable);
    }
}
