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
    public static final String f7771a = "a";

    /* renamed from: f  reason: collision with root package name */
    public static a f7772f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f7773g = -100;

    /* renamed from: b  reason: collision with root package name */
    public Context f7774b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f7775c;

    /* renamed from: d  reason: collision with root package name */
    public e f7776d;

    /* renamed from: e  reason: collision with root package name */
    public int f7777e;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    public static a a() {
        if (f7772f == null) {
            f7772f = new a();
        }
        return f7772f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        if (message.what != 2012) {
            if (message.arg2 == 3) {
                this.f7774b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
            }
            int i2 = message.arg2;
            if (i2 != 2 && i2 != 404 && i2 != 5 && i2 != 8) {
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
        this.f7774b.sendBroadcast(intent);
    }

    private void f() {
        e eVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
        Context context = this.f7774b;
        if (context == null || (eVar = this.f7776d) == null) {
            return;
        }
        context.registerReceiver(eVar, intentFilter);
    }

    private void g() {
        Context context;
        e eVar = this.f7776d;
        if (eVar == null || (context = this.f7774b) == null) {
            return;
        }
        context.unregisterReceiver(eVar);
    }

    public void a(Context context) {
        this.f7774b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i2;
        if (bVar == null) {
            return;
        }
        if (bVar.f8182a == 0) {
            f.z = bVar.f8186e;
            f.a(bVar.f8183b, bVar.f8184c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        Handler handler = this.f7775c;
        if (handler == null || (i2 = bVar.f8182a) == f7773g) {
            return;
        }
        f7773g = i2;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = IMConstants.IM_MSG_TYPE_SHIELD_ME;
        obtainMessage.arg1 = bVar.f8182a;
        obtainMessage.obj = bVar.f8185d;
        this.f7775c.sendMessage(obtainMessage);
    }

    public void b() {
        if (this.f7777e == 0) {
            if (this.f7774b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.f7776d = new e();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f7774b);
        }
        this.f7777e++;
    }

    public boolean c() {
        if (this.f7774b != null) {
            this.f7775c = new b(this);
            f.b(this.f7774b);
            f.f();
            PermissionCheck.init(this.f7774b);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            return true;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    public void d() {
        int i2 = this.f7777e - 1;
        this.f7777e = i2;
        if (i2 == 0) {
            g();
            f.a();
        }
    }

    public Context e() {
        Context context = this.f7774b;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }
}
