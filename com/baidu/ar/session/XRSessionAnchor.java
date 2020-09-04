package com.baidu.ar.session;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.baidu.ar.plugin.PluginManager;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.smallgame.sdk.a;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.google.ar.core.ArCoreApk;
import java.io.File;
@NotProguard
/* loaded from: classes20.dex */
public class XRSessionAnchor {
    private static final String TAG = "XRSessionAnchor";
    private static final String apkinfo = "com.google.ar.core";
    private boolean mAppAuthorized;
    private Context mContext = V8Engine.getAppContext();
    private long mNativeSessionHandle;
    OrientationEventListener mOrientationEventListener;
    private int mRotation;
    private WindowManager mWM;

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionCreateFail(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionCreateSuccess(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionOrientationChange(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionPermissionChange(long j, int i);

    public XRSessionAnchor() {
        Context context = this.mContext;
        Context context2 = this.mContext;
        this.mWM = (WindowManager) context.getSystemService("window");
        this.mAppAuthorized = true;
        this.mRotation = 0;
        this.mOrientationEventListener = new OrientationEventListener(V8Engine.getAppContext()) { // from class: com.baidu.ar.session.XRSessionAnchor.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                if (XRSessionAnchor.this.mWM.getDefaultDisplay().getRotation() != XRSessionAnchor.this.mRotation) {
                    XRSessionAnchor.this.mRotation = XRSessionAnchor.this.mWM.getDefaultDisplay().getRotation();
                    XRSessionAnchor.this.xRSessionOrientationChange(XRSessionAnchor.this.mNativeSessionHandle, XRSessionAnchor.this.mRotation);
                }
            }
        };
    }

    public static boolean supportArCore(Context context) {
        try {
            ArCoreApk.Availability gw = ArCoreApk.dWU().gw(context);
            return gw != null && (gw.isSupported() || gw.isTransient());
        } catch (Exception e) {
            return true;
        }
    }

    public void requestCameraPermission() {
        if (a.bPs != null) {
            a.bPs.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener() { // from class: com.baidu.ar.session.XRSessionAnchor.2
                @Override // com.baidu.smallgame.sdk.permission.PermissionListener
                public void onPermissionResult(String str, int i) {
                    if (i == 0) {
                        Log.i(XRSessionAnchor.TAG, "requestCameraPermission@ permissionState:" + i);
                        if (!XRSessionAnchor.this.mAppAuthorized) {
                            XRSessionAnchor.this.mAppAuthorized = true;
                            XRSessionAnchor.this.xRSessionPermissionChange(XRSessionAnchor.this.mNativeSessionHandle, 0);
                            return;
                        }
                        return;
                    }
                    int i2 = i + 1000;
                    if (XRSessionAnchor.this.mAppAuthorized && i2 == 1002) {
                        XRSessionAnchor.this.mAppAuthorized = false;
                        XRSessionAnchor.this.xRSessionPermissionChange(XRSessionAnchor.this.mNativeSessionHandle, i2);
                    }
                    Log.i(XRSessionAnchor.TAG, "Permission fail:" + i2);
                }
            });
        }
    }

    public void requestInstallArcore() {
        PackageInfo packageInfo;
        this.mContext = V8Engine.getAppContext();
        this.mRotation = a.bPt;
        final String str = "";
        if (this.mContext != null) {
            str = this.mContext.getFilesDir() + "/aigames_folder/game_ar_resource/arcore";
            Log.i(TAG, "apk path is:" + str);
        }
        try {
            if (this.mContext != null && (packageInfo = this.mContext.getPackageManager().getPackageInfo(apkinfo, 0)) != null) {
                Log.i(TAG, "installed package name is:" + packageInfo.packageName);
            }
        } catch (PackageManager.NameNotFoundException e) {
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
                    } else if (a.bPs == null) {
                        XRSessionAnchor.this.xRSessionCreateSuccess(XRSessionAnchor.this.mNativeSessionHandle, a.bPt);
                    } else {
                        a.bPs.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener() { // from class: com.baidu.ar.session.XRSessionAnchor.3.1
                            @Override // com.baidu.smallgame.sdk.permission.PermissionListener
                            public void onPermissionResult(String str2, int i) {
                                if (i == 0) {
                                    Log.i(XRSessionAnchor.TAG, "Permission ok!@ permissionState:" + i);
                                    XRSessionAnchor.this.xRSessionCreateSuccess(XRSessionAnchor.this.mNativeSessionHandle, a.bPt);
                                    XRSessionAnchor.this.mOrientationEventListener.enable();
                                    return;
                                }
                                int i2 = i + 1000;
                                XRSessionAnchor.this.xRSessionCreateFail(XRSessionAnchor.this.mNativeSessionHandle, i2);
                                Log.i(XRSessionAnchor.TAG, "Permission fail:" + i2);
                            }
                        });
                    }
                } catch (Throwable th) {
                    XRSessionAnchor.this.xRSessionCreateFail(XRSessionAnchor.this.mNativeSessionHandle, 1003);
                }
            }
        }).start();
    }
}
