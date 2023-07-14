package com.baidu.ar.session;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.baidu.ar.plugin.PluginManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.ap1;
import com.google.ar.core.ArCoreApk;
import java.io.File;
@NotProguard
/* loaded from: classes.dex */
public class XRSessionAnchor {
    public static final String TAG = "XRSessionAnchor";
    public static final String apkinfo = "com.google.ar.core";
    public boolean mAppAuthorized;
    public Context mContext;
    public long mNativeSessionHandle;
    public OrientationEventListener mOrientationEventListener;
    public int mRotation;
    public WindowManager mWM;

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionCreateFail(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionCreateSuccess(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionOrientationChange(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionPermissionChange(long j, int i);

    public XRSessionAnchor() {
        Context appContext = V8Engine.getAppContext();
        this.mContext = appContext;
        this.mWM = (WindowManager) appContext.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        this.mAppAuthorized = true;
        this.mRotation = 0;
        this.mOrientationEventListener = new OrientationEventListener(V8Engine.getAppContext()) { // from class: com.baidu.ar.session.XRSessionAnchor.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                if (XRSessionAnchor.this.mWM.getDefaultDisplay().getRotation() != XRSessionAnchor.this.mRotation) {
                    XRSessionAnchor xRSessionAnchor = XRSessionAnchor.this;
                    xRSessionAnchor.mRotation = xRSessionAnchor.mWM.getDefaultDisplay().getRotation();
                    XRSessionAnchor xRSessionAnchor2 = XRSessionAnchor.this;
                    xRSessionAnchor2.xRSessionOrientationChange(xRSessionAnchor2.mNativeSessionHandle, XRSessionAnchor.this.mRotation);
                }
            }
        };
    }

    public void requestCameraPermission() {
        PermissionProxy permissionProxy = ap1.o;
        if (permissionProxy != null) {
            permissionProxy.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener() { // from class: com.baidu.ar.session.XRSessionAnchor.2
                @Override // com.baidu.smallgame.sdk.permission.PermissionListener
                public void onPermissionResult(String str, int i) {
                    if (i == 0) {
                        Log.i(XRSessionAnchor.TAG, "requestCameraPermission@ permissionState:" + i);
                        if (XRSessionAnchor.this.mAppAuthorized) {
                            return;
                        }
                        XRSessionAnchor.this.mAppAuthorized = true;
                        XRSessionAnchor xRSessionAnchor = XRSessionAnchor.this;
                        xRSessionAnchor.xRSessionPermissionChange(xRSessionAnchor.mNativeSessionHandle, 0);
                        return;
                    }
                    int i2 = i + 1000;
                    if (XRSessionAnchor.this.mAppAuthorized && i2 == 1002) {
                        XRSessionAnchor.this.mAppAuthorized = false;
                        XRSessionAnchor xRSessionAnchor2 = XRSessionAnchor.this;
                        xRSessionAnchor2.xRSessionPermissionChange(xRSessionAnchor2.mNativeSessionHandle, i2);
                    }
                    Log.i(XRSessionAnchor.TAG, "Permission fail:" + i2);
                }
            });
        }
    }

    public static boolean supportArCore(Context context) {
        try {
            ArCoreApk.Availability a = ArCoreApk.b().a(context);
            if (a != null) {
                if (a.isSupported() || a.isTransient()) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public void requestInstallArcore() {
        final String str;
        PackageInfo packageInfo;
        Context appContext = V8Engine.getAppContext();
        this.mContext = appContext;
        this.mRotation = ap1.p;
        if (appContext != null) {
            str = this.mContext.getFilesDir() + "/aigames_folder/game_ar_resource/arcore";
            Log.i(TAG, "apk path is:" + str);
        } else {
            str = "";
        }
        try {
            if (this.mContext != null && (packageInfo = this.mContext.getPackageManager().getPackageInfo(apkinfo, 0)) != null) {
                Log.i(TAG, "installed package name is:" + packageInfo.packageName);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "google arcore apk is not installed!");
        }
        if (!new File(str).exists()) {
            xRSessionCreateFail(this.mNativeSessionHandle, 1003);
            Log.e(TAG, "google arcore apk is not exist!");
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.ar.session.XRSessionAnchor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int installPackage = PluginManager.getPluginManagerInstance(XRSessionAnchor.this.mContext).installPackage(str, false);
                    Log.i(XRSessionAnchor.TAG, "plugin manager install err code:" + installPackage);
                    if (installPackage != 1 && installPackage != -1) {
                        XRSessionAnchor.this.xRSessionCreateFail(XRSessionAnchor.this.mNativeSessionHandle, 1003);
                    }
                    if (ap1.o != null) {
                        ap1.o.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener() { // from class: com.baidu.ar.session.XRSessionAnchor.3.1
                            @Override // com.baidu.smallgame.sdk.permission.PermissionListener
                            public void onPermissionResult(String str2, int i) {
                                if (i == 0) {
                                    Log.i(XRSessionAnchor.TAG, "Permission ok!@ permissionState:" + i);
                                    XRSessionAnchor xRSessionAnchor = XRSessionAnchor.this;
                                    xRSessionAnchor.xRSessionCreateSuccess(xRSessionAnchor.mNativeSessionHandle, ap1.p);
                                    XRSessionAnchor.this.mOrientationEventListener.enable();
                                    return;
                                }
                                int i2 = i + 1000;
                                XRSessionAnchor xRSessionAnchor2 = XRSessionAnchor.this;
                                xRSessionAnchor2.xRSessionCreateFail(xRSessionAnchor2.mNativeSessionHandle, i2);
                                Log.i(XRSessionAnchor.TAG, "Permission fail:" + i2);
                            }
                        });
                    } else {
                        XRSessionAnchor.this.xRSessionCreateSuccess(XRSessionAnchor.this.mNativeSessionHandle, ap1.p);
                    }
                } catch (Throwable unused2) {
                    XRSessionAnchor xRSessionAnchor = XRSessionAnchor.this;
                    xRSessionAnchor.xRSessionCreateFail(xRSessionAnchor.mNativeSessionHandle, 1003);
                }
            }
        }).start();
    }
}
