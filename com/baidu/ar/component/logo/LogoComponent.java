package com.baidu.ar.component.logo;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.baidu.ar.ARController;
import com.baidu.ar.b;
import com.baidu.ar.logo.CameraPreViewCallback;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.ar.ui.b.a;
import com.baidu.ar.util.UiThreadUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LogoComponent implements CameraPreViewCallback {
    private static LogoComponent a = null;
    private ARController b;
    private a c;

    private LogoComponent(final Context context, ARController aRController, final ViewGroup viewGroup, final b bVar) {
        this.b = aRController;
        this.b.setCameraPreViewCallback(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.logo.LogoComponent.1
            @Override // java.lang.Runnable
            public void run() {
                if (LogoComponent.this.c == null) {
                    LogoComponent.this.c = new a(context, viewGroup, bVar);
                }
            }
        });
    }

    public static LogoComponent getInstance(Context context, ARController aRController, ViewGroup viewGroup, b bVar) {
        if (a == null) {
            a = new LogoComponent(context, aRController, viewGroup, bVar);
        }
        return a;
    }

    public static void releaseLogo() {
        a = null;
    }

    public void onLuaMessage(final HashMap hashMap) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.logo.LogoComponent.2
            @Override // java.lang.Runnable
            public void run() {
                if (hashMap != null) {
                    int intValue = ((Integer) hashMap.get("id")).intValue();
                    Log.e("lua  ", " ArBridge.LuaSdkBridgeMessageType = " + intValue);
                    switch (intValue) {
                        case ComponentMessageType.MSG_TYPE_LOGO_START /* 3005 */:
                            LogoComponent.this.c.a();
                            return;
                        case ComponentMessageType.MSG_TYPE_LOGO_STOP /* 3006 */:
                            LogoComponent.this.c.b();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    public void onPause() {
        if (this.c != null) {
            this.c.e();
        }
    }

    @Override // com.baidu.ar.logo.CameraPreViewCallback
    public void onPreviewCallback(final byte[] bArr, final int i, final int i2) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.logo.LogoComponent.3
            @Override // java.lang.Runnable
            public void run() {
                if (LogoComponent.this.c != null) {
                    LogoComponent.this.c.a(bArr, i, i2);
                }
            }
        });
    }

    public void onResume() {
        this.c.c();
    }

    public void releaseRecg() {
        if (this.c != null) {
            this.c.f();
        }
        releaseLogo();
    }
}
