package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.f;
/* loaded from: classes5.dex */
public class a implements PermissionCheck.c {
    private static a f;
    private Context b;
    private Handler c;
    private e d;
    private int e;
    private static final String a = a.class.getSimpleName();
    private static int g = -100;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    private a() {
    }

    public static a a() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        if (message.what == 2012) {
            if (message.arg1 == 0) {
                intent = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
            } else {
                Intent intent2 = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
                intent2.putExtra("error_code", message.arg1);
                intent2.putExtra("error_message", (String) message.obj);
                intent = intent2;
            }
            this.b.sendBroadcast(intent);
            return;
        }
        if (message.arg2 == 3) {
            this.b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
        }
        if (message.arg2 == 2 || message.arg2 == 404 || message.arg2 == 5 || message.arg2 == 8) {
            this.b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
        }
    }

    private void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        if (this.b == null || this.d == null) {
            return;
        }
        this.b.registerReceiver(this.d, intentFilter);
    }

    private void g() {
        if (this.d == null || this.b == null) {
            return;
        }
        this.b.unregisterReceiver(this.d);
    }

    public void a(Context context) {
        this.b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.a == 0) {
            f.z = bVar.e;
            f.a(bVar.b, bVar.c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        if (this.c == null || bVar.a == g) {
            return;
        }
        g = bVar.a;
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 2012;
        obtainMessage.arg1 = bVar.a;
        obtainMessage.obj = bVar.d;
        this.c.sendMessage(obtainMessage);
    }

    public void b() {
        if (this.e == 0) {
            if (this.b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.d = new e();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.b);
        }
        this.e++;
    }

    public boolean c() {
        if (this.b == null) {
            throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        this.c = new b(this);
        f.b(this.b);
        f.f();
        PermissionCheck.init(this.b);
        PermissionCheck.setPermissionCheckResultListener(this);
        PermissionCheck.permissionCheck();
        return true;
    }

    public void d() {
        this.e--;
        if (this.e == 0) {
            g();
            f.a();
        }
    }

    public Context e() {
        if (this.b == null) {
            throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        return this.b;
    }
}
