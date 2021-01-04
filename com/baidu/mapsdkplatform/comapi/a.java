package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.h;
/* loaded from: classes15.dex */
public class a implements PermissionCheck.c {
    private static a f;

    /* renamed from: b  reason: collision with root package name */
    private Context f3118b;
    private Handler c;
    private f d;
    private int e;

    /* renamed from: a  reason: collision with root package name */
    private static final String f3117a = a.class.getSimpleName();
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
            this.f3118b.sendBroadcast(intent);
            return;
        }
        if (message.arg2 == 3) {
            this.f3118b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
        }
        if (message.arg2 == 2 || message.arg2 == 404 || message.arg2 == 5 || message.arg2 == 8) {
            this.f3118b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
        }
    }

    private void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
        if (this.f3118b == null || this.d == null) {
            return;
        }
        this.f3118b.registerReceiver(this.d, intentFilter);
    }

    private void g() {
        if (this.d == null || this.f3118b == null) {
            return;
        }
        this.f3118b.unregisterReceiver(this.d);
    }

    public void a(Context context) {
        this.f3118b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.f3208a == 0) {
            h.d = bVar.e;
            h.a(bVar.f3209b, bVar.c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        if (bVar.f3208a != PermissionCheck.f3207b && bVar.f3208a != PermissionCheck.f3206a && bVar.f3208a != PermissionCheck.c) {
            com.baidu.mapsdkplatform.comapi.util.c.a().a(bVar.f);
        }
        if (this.c == null || bVar.f3208a == g) {
            return;
        }
        g = bVar.f3208a;
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 2012;
        obtainMessage.arg1 = bVar.f3208a;
        obtainMessage.obj = bVar.d;
        this.c.sendMessage(obtainMessage);
    }

    public void b() {
        if (this.e == 0) {
            if (this.f3118b == null) {
                throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.d = new f();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f3118b);
        }
        this.e++;
    }

    public boolean c() {
        if (this.f3118b == null) {
            throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        this.c = new b(this);
        h.b(this.f3118b);
        com.baidu.mapsdkplatform.comapi.util.c.a().a(this.f3118b);
        h.g();
        PermissionCheck.init(this.f3118b);
        PermissionCheck.setPermissionCheckResultListener(this);
        PermissionCheck.permissionCheck();
        return true;
    }

    public void d() {
        this.e--;
        if (this.e == 0) {
            g();
            h.a();
        }
    }

    public Context e() {
        if (this.f3118b == null) {
            throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        return this.f3118b;
    }
}
