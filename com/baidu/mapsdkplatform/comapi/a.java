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
    public static final String f7500a = "a";

    /* renamed from: g  reason: collision with root package name */
    public static a f7501g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f7502h = -100;

    /* renamed from: b  reason: collision with root package name */
    public Context f7503b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f7504c;

    /* renamed from: d  reason: collision with root package name */
    public e f7505d;

    /* renamed from: e  reason: collision with root package name */
    public String f7506e;

    /* renamed from: f  reason: collision with root package name */
    public int f7507f;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    public static a a() {
        if (f7501g == null) {
            f7501g = new a();
        }
        return f7501g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        if (message.what != 2012) {
            if (message.arg2 == 3) {
                this.f7503b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
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
        this.f7503b.sendBroadcast(intent);
    }

    private void f() {
        e eVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
        Context context = this.f7503b;
        if (context == null || (eVar = this.f7505d) == null) {
            return;
        }
        context.registerReceiver(eVar, intentFilter);
    }

    private void g() {
        Context context;
        e eVar = this.f7505d;
        if (eVar == null || (context = this.f7503b) == null) {
            return;
        }
        context.unregisterReceiver(eVar);
    }

    public void a(Context context) {
        this.f7503b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i2;
        if (bVar == null) {
            return;
        }
        if (bVar.f7932a == 0) {
            i.f7965d = bVar.f7936e;
            i.a(bVar.f7933b, bVar.f7934c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        int i3 = bVar.f7932a;
        if (i3 != PermissionCheck.f7924b && i3 != PermissionCheck.f7923a && i3 != PermissionCheck.f7925c) {
            com.baidu.mapsdkplatform.comapi.util.d.a().a(bVar.f7937f);
        }
        Handler handler = this.f7504c;
        if (handler == null || (i2 = bVar.f7932a) == f7502h) {
            return;
        }
        f7502h = i2;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = IMConstants.IM_MSG_TYPE_SHIELD_ME;
        obtainMessage.arg1 = bVar.f7932a;
        obtainMessage.obj = bVar.f7935d;
        this.f7504c.sendMessage(obtainMessage);
    }

    public void a(String str) {
        this.f7506e = str;
    }

    public void b() {
        if (this.f7507f == 0) {
            if (this.f7503b == null) {
                throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.f7505d = new e();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f7503b);
        }
        this.f7507f++;
    }

    public boolean c() {
        if (this.f7503b != null) {
            this.f7504c = new b(this);
            i.b(this.f7503b);
            com.baidu.mapsdkplatform.comapi.util.d.a().a(this.f7503b);
            i.f();
            PermissionCheck.init(this.f7503b);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            return true;
        }
        throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    public void d() {
        int i2 = this.f7507f - 1;
        this.f7507f = i2;
        if (i2 == 0) {
            g();
            i.a();
        }
    }

    public Context e() {
        Context context = this.f7503b;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }
}
