package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.f;
/* loaded from: classes2.dex */
public class a implements PermissionCheck.c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7469a = "a";

    /* renamed from: f  reason: collision with root package name */
    public static a f7470f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f7471g = -100;

    /* renamed from: b  reason: collision with root package name */
    public Context f7472b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f7473c;

    /* renamed from: d  reason: collision with root package name */
    public e f7474d;

    /* renamed from: e  reason: collision with root package name */
    public int f7475e;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    public static a a() {
        if (f7470f == null) {
            f7470f = new a();
        }
        return f7470f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        if (message.what != 2012) {
            if (message.arg2 == 3) {
                this.f7472b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
            }
            int i = message.arg2;
            if (i != 2 && i != 404 && i != 5 && i != 8) {
                return;
            }
            intent = new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        } else if (message.arg1 == 0) {
            intent = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
        } else {
            Intent intent2 = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
            intent2.putExtra("error_code", message.arg1);
            intent2.putExtra("error_message", (String) message.obj);
            intent = intent2;
        }
        this.f7472b.sendBroadcast(intent);
    }

    private void f() {
        e eVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
        Context context = this.f7472b;
        if (context == null || (eVar = this.f7474d) == null) {
            return;
        }
        context.registerReceiver(eVar, intentFilter);
    }

    private void g() {
        Context context;
        e eVar = this.f7474d;
        if (eVar == null || (context = this.f7472b) == null) {
            return;
        }
        context.unregisterReceiver(eVar);
    }

    public void a(Context context) {
        this.f7472b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i;
        if (bVar == null) {
            return;
        }
        if (bVar.f7861a == 0) {
            f.z = bVar.f7865e;
            f.a(bVar.f7862b, bVar.f7863c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        Handler handler = this.f7473c;
        if (handler == null || (i = bVar.f7861a) == f7471g) {
            return;
        }
        f7471g = i;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = IMConstants.IM_MSG_TYPE_SHIELD_ME;
        obtainMessage.arg1 = bVar.f7861a;
        obtainMessage.obj = bVar.f7864d;
        this.f7473c.sendMessage(obtainMessage);
    }

    public void b() {
        if (this.f7475e == 0) {
            if (this.f7472b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.f7474d = new e();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f7472b);
        }
        this.f7475e++;
    }

    public boolean c() {
        if (this.f7472b != null) {
            this.f7473c = new b(this);
            f.b(this.f7472b);
            f.f();
            PermissionCheck.init(this.f7472b);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            return true;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    public void d() {
        int i = this.f7475e - 1;
        this.f7475e = i;
        if (i == 0) {
            g();
            f.a();
        }
    }

    public Context e() {
        Context context = this.f7472b;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }
}
