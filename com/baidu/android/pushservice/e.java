package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
import java.util.HashSet;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static int f310a = -1;
    private static Boolean e = false;
    private static volatile e m;
    com.baidu.android.pushservice.message.a c;
    private i h;
    private h i;
    private Context l;
    private boolean d = false;
    private boolean f = false;
    private LinkedList g = new LinkedList();
    private boolean j = false;
    private int k = 0;
    Handler b = new Handler();
    private HashSet n = new HashSet();
    private Runnable o = new g(this);

    private e(Context context) {
        this.l = context;
    }

    public static e a(Context context) {
        if (m == null) {
            m = new e(context);
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.d || e.booleanValue()) {
            if (b.a()) {
                Log.i("PushConnection", "Connect return. mConnected:" + this.d + " mConnectting:" + e);
            }
        } else if (y.a().d()) {
            e = true;
            f310a = -1;
            Thread thread = new Thread(new f(this));
            thread.setName("PushService-PushService-connect");
            thread.start();
        } else {
            if (b.a()) {
                Log.d("PushConnection", "re-token");
            }
            PushSDK.getInstantce(this.l).sendRequestTokenIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (b.a()) {
            Log.i("PushConnection", "disconnectedByPeer, mStoped == " + this.j);
        }
        if (this.j) {
            return;
        }
        f();
        this.k++;
        if (this.k < 3) {
            int i = (this.k - 1) * 30 * 1000;
            if (this.k == 1) {
                i = 0;
            }
            this.b.postDelayed(this.o, i);
            if (b.a()) {
                Log.i("PushConnection", "Schedule retry-- retry times: " + this.k + " time delay: " + i);
            }
        }
    }

    private void f() {
        this.f = true;
        this.d = false;
        a(false);
        synchronized (this.g) {
            this.g.notifyAll();
        }
        PushSocket.closeSocket(f310a);
        if (this.c != null) {
            this.c.a();
        }
    }

    public void a(com.baidu.android.pushservice.message.b bVar) {
        synchronized (this.g) {
            this.g.add(bVar);
            this.g.notify();
        }
    }

    public void a(boolean z) {
        if (this.l == null) {
            Log.e("PushConnection", "setConnectState, mContext == null");
        } else {
            Settings.System.putInt(this.l.getContentResolver(), "com.baidu.pushservice.PushSettings.connect_state", z ? 1 : 0);
        }
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(String str) {
        boolean z = false;
        if (this.n.contains(str)) {
            this.n.remove(str);
            z = true;
        }
        if (this.n.size() >= 100) {
            this.n.clear();
        }
        this.n.add(str);
        return z;
    }

    public void b() {
        this.k = 0;
        this.j = false;
        d();
    }

    public void c() {
        if (b.a()) {
            Log.i("PushConnection", "---stop---");
        }
        this.f = true;
        this.j = true;
        this.b.removeCallbacks(this.o);
        f();
    }
}
