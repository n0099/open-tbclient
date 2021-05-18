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
import com.baidu.mapsdkplatform.comapi.util.i;
/* loaded from: classes2.dex */
public class a implements PermissionCheck.c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7557a = "a";

    /* renamed from: g  reason: collision with root package name */
    public static a f7558g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f7559h = -100;

    /* renamed from: b  reason: collision with root package name */
    public Context f7560b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f7561c;

    /* renamed from: d  reason: collision with root package name */
    public e f7562d;

    /* renamed from: e  reason: collision with root package name */
    public String f7563e;

    /* renamed from: f  reason: collision with root package name */
    public int f7564f;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    public static a a() {
        if (f7558g == null) {
            f7558g = new a();
        }
        return f7558g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        if (message.what != 2012) {
            if (message.arg2 == 3) {
                this.f7560b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
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
        this.f7560b.sendBroadcast(intent);
    }

    private void f() {
        e eVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
        Context context = this.f7560b;
        if (context == null || (eVar = this.f7562d) == null) {
            return;
        }
        context.registerReceiver(eVar, intentFilter);
    }

    private void g() {
        Context context;
        e eVar = this.f7562d;
        if (eVar == null || (context = this.f7560b) == null) {
            return;
        }
        context.unregisterReceiver(eVar);
    }

    public void a(Context context) {
        this.f7560b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i2;
        if (bVar == null) {
            return;
        }
        if (bVar.f7989a == 0) {
            i.f8022d = bVar.f7993e;
            i.a(bVar.f7990b, bVar.f7991c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        int i3 = bVar.f7989a;
        if (i3 != PermissionCheck.f7981b && i3 != PermissionCheck.f7980a && i3 != PermissionCheck.f7982c) {
            com.baidu.mapsdkplatform.comapi.util.d.a().a(bVar.f7994f);
        }
        Handler handler = this.f7561c;
        if (handler == null || (i2 = bVar.f7989a) == f7559h) {
            return;
        }
        f7559h = i2;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = IMConstants.IM_MSG_TYPE_SHIELD_ME;
        obtainMessage.arg1 = bVar.f7989a;
        obtainMessage.obj = bVar.f7992d;
        this.f7561c.sendMessage(obtainMessage);
    }

    public void a(String str) {
        this.f7563e = str;
    }

    public void b() {
        if (this.f7564f == 0) {
            if (this.f7560b == null) {
                throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.f7562d = new e();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f7560b);
        }
        this.f7564f++;
    }

    public boolean c() {
        if (this.f7560b != null) {
            this.f7561c = new b(this);
            i.b(this.f7560b);
            com.baidu.mapsdkplatform.comapi.util.d.a().a(this.f7560b);
            i.f();
            PermissionCheck.init(this.f7560b);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            return true;
        }
        throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    public void d() {
        int i2 = this.f7564f - 1;
        this.f7564f = i2;
        if (i2 == 0) {
            g();
            i.a();
        }
    }

    public Context e() {
        Context context = this.f7560b;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }
}
