package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.location.LocationClientOption;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Properties;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static int f580a = -1;
    private static Boolean e = false;
    private static volatile e p;
    com.baidu.android.pushservice.message.a c;
    private Socket g;
    private InputStream h;
    private OutputStream i;
    private j k;
    private i l;
    private Context o;
    private boolean r;
    private boolean d = false;
    private boolean f = false;
    private LinkedList j = new LinkedList();
    private boolean m = false;
    private int n = 0;
    Handler b = new Handler();
    private HashSet q = new HashSet();
    private Runnable s = new g(this);
    private Runnable t = new h(this);
    private long u = 0;
    private int[] v = {300, 450, 600};
    private int[] w = {0, 0, 0};
    private final int x = 2;
    private int y = 2;
    private int z = 0;
    private final int A = 7200;

    private e(Context context) {
        this.o = context;
        h();
    }

    public static e a(Context context) {
        if (p == null) {
            p = new e(context);
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i = this.y;
        if (z) {
            this.z++;
            this.w[this.y] = 0;
            if (this.v[this.y] * this.z >= 7200) {
                this.z = 0;
                if (this.y < this.v.length - 1 && this.w[this.y + 1] < 2) {
                    this.y++;
                    PushSDK.getInstantce(this.o).setAlarmTimeout(this.v[this.y]);
                }
            }
        } else {
            this.z = 0;
            int[] iArr = this.w;
            int i2 = this.y;
            iArr[i2] = iArr[i2] + 1;
            if (this.y > 0) {
                this.y--;
                PushSDK.getInstantce(this.o).setAlarmTimeout(this.v[this.y]);
            }
        }
        if (PushSettings.c()) {
            Log.d("PushConnection", "RTC stat update from " + this.v[i] + " to " + this.v[this.y]);
            com.baidu.android.pushservice.util.n.a("RTC stat update from " + this.v[i] + " to " + this.v[this.y]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        if (this.d || e.booleanValue()) {
            if (b.a()) {
                Log.i("PushConnection", "Connect return. mConnected:" + this.d + " mConnectting:" + e);
            }
        } else if (y.a().e()) {
            e = true;
            f580a = -1;
            Thread thread = new Thread(new f(this));
            thread.setName("PushService-PushService-connect");
            thread.start();
        } else {
            if (b.a()) {
                Log.d("PushConnection", "re-token");
            }
            PushSDK.getInstantce(this.o).sendRequestTokenIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (b.a()) {
            Log.i("PushConnection", "disconnectedByPeer, mStoped == " + this.m);
            com.baidu.android.pushservice.util.n.a("disconnectedByPeer, mStoped == " + this.m);
        }
        if (this.m) {
            return;
        }
        g();
        this.n++;
        if (this.n < 3) {
            int i = (this.n - 1) * 30 * LocationClientOption.MIN_SCAN_SPAN;
            if (this.n == 1) {
                i = 0;
            }
            this.b.postDelayed(this.s, i);
            if (b.a()) {
                Log.i("PushConnection", "Schedule retry-- retry times: " + this.n + " time delay: " + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (b.a()) {
            Log.i("PushConnection", "disconnected");
        }
        this.b.removeCallbacks(this.t);
        this.f = true;
        this.d = false;
        a(false);
        synchronized (this.j) {
            this.j.notifyAll();
        }
        try {
            if (this.g != null) {
                this.g.close();
                this.g = null;
            }
            if (this.h != null) {
                this.h.close();
                this.h = null;
            }
            if (this.i != null) {
                this.i.close();
                this.i = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (PushSocket.f586a) {
            PushSocket.closeSocket(f580a);
        }
        if (this.c != null) {
            this.c.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        FileInputStream fileInputStream;
        int i = 0;
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed1");
                    Log.e("PushConnection", property);
                    int parseInt = (property == null || property.length() <= 0) ? 0 : Integer.parseInt(property);
                    String property2 = properties.getProperty("rtcseed2");
                    Log.e("PushConnection", property2);
                    int parseInt2 = (property2 == null || property2.length() <= 0) ? 0 : Integer.parseInt(property2);
                    String property3 = properties.getProperty("rtcseed3");
                    Log.e("PushConnection", property3);
                    if (property3 != null && property3.length() > 0) {
                        i = Integer.parseInt(property3);
                    }
                    if (parseInt > 0 && parseInt2 > 0 && i > 0) {
                        this.v[0] = parseInt;
                        this.v[1] = parseInt2;
                        this.v[2] = i;
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (b.a()) {
                        System.out.println(e.getMessage());
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public void a(com.baidu.android.pushservice.message.b bVar) {
        synchronized (this.j) {
            this.j.add(bVar);
            this.j.notify();
        }
    }

    public void a(boolean z) {
        if (this.o == null) {
            Log.e("PushConnection", "setConnectState, mContext == null");
        } else {
            Settings.System.putInt(this.o.getContentResolver(), "com.baidu.pushservice.PushSettings.connect_state", z ? 1 : 0);
        }
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(String str) {
        boolean z = false;
        if (this.q.contains(str)) {
            this.q.remove(str);
            z = true;
        }
        if (this.q.size() >= 100) {
            this.q.clear();
        }
        this.q.add(str);
        return z;
    }

    public void b() {
        this.n = 0;
        this.m = false;
        e();
    }

    public void c() {
        if (b.a()) {
            Log.i("PushConnection", "---stop---");
        }
        this.f = true;
        this.m = true;
        this.b.removeCallbacks(this.s);
        g();
    }

    public void d() {
        if (this.c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.u <= 180000) {
                if (b.a()) {
                    Log.i("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.");
                    return;
                }
                return;
            }
            this.c.d();
            this.u = currentTimeMillis;
            if (b.a()) {
                Log.i("PushConnection", "sendHeartbeatMessage");
            }
        }
    }
}
