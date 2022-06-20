package com.baidu.ar.session;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.plugin.PluginManager;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.repackage.jd1;
import java.io.File;
@NotProguard
/* loaded from: classes.dex */
public class XRSessionAnchor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XRSessionAnchor";
    public static final String apkinfo = "com.google.ar.core";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAppAuthorized;
    public Context mContext;
    public long mNativeSessionHandle;
    public OrientationEventListener mOrientationEventListener;
    public int mRotation;
    public WindowManager mWM;

    public XRSessionAnchor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context appContext = V8Engine.getAppContext();
        this.mContext = appContext;
        this.mWM = (WindowManager) appContext.getSystemService("window");
        this.mAppAuthorized = true;
        this.mRotation = 0;
        this.mOrientationEventListener = new OrientationEventListener(this, V8Engine.getAppContext()) { // from class: com.baidu.ar.session.XRSessionAnchor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XRSessionAnchor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Context) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) || this.this$0.mWM.getDefaultDisplay().getRotation() == this.this$0.mRotation) {
                    return;
                }
                XRSessionAnchor xRSessionAnchor = this.this$0;
                xRSessionAnchor.mRotation = xRSessionAnchor.mWM.getDefaultDisplay().getRotation();
                XRSessionAnchor xRSessionAnchor2 = this.this$0;
                xRSessionAnchor2.xRSessionOrientationChange(xRSessionAnchor2.mNativeSessionHandle, this.this$0.mRotation);
            }
        };
    }

    public static boolean supportArCore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                ArCoreApk.Availability a = ArCoreApk.b().a(context);
                if (a != null) {
                    return a.isSupported() || a.isTransient();
                }
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionCreateFail(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionCreateSuccess(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionOrientationChange(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void xRSessionPermissionChange(long j, int i);

    public void requestCameraPermission() {
        PermissionProxy permissionProxy;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (permissionProxy = jd1.o) == null) {
            return;
        }
        permissionProxy.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener(this) { // from class: com.baidu.ar.session.XRSessionAnchor.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XRSessionAnchor this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.smallgame.sdk.permission.PermissionListener
            public void onPermissionResult(String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i) == null) {
                    if (i == 0) {
                        Log.i(XRSessionAnchor.TAG, "requestCameraPermission@ permissionState:" + i);
                        if (this.this$0.mAppAuthorized) {
                            return;
                        }
                        this.this$0.mAppAuthorized = true;
                        XRSessionAnchor xRSessionAnchor = this.this$0;
                        xRSessionAnchor.xRSessionPermissionChange(xRSessionAnchor.mNativeSessionHandle, 0);
                        return;
                    }
                    int i2 = i + 1000;
                    if (this.this$0.mAppAuthorized && i2 == 1002) {
                        this.this$0.mAppAuthorized = false;
                        XRSessionAnchor xRSessionAnchor2 = this.this$0;
                        xRSessionAnchor2.xRSessionPermissionChange(xRSessionAnchor2.mNativeSessionHandle, i2);
                    }
                    Log.i(XRSessionAnchor.TAG, "Permission fail:" + i2);
                }
            }
        });
    }

    public void requestInstallArcore() {
        String str;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context appContext = V8Engine.getAppContext();
            this.mContext = appContext;
            this.mRotation = jd1.p;
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
            new Thread(new Runnable(this, str) { // from class: com.baidu.ar.session.XRSessionAnchor.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XRSessionAnchor this$0;
                public final /* synthetic */ String val$apkIntallPath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$apkIntallPath = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            int installPackage = PluginManager.getPluginManagerInstance(this.this$0.mContext).installPackage(this.val$apkIntallPath, false);
                            Log.i(XRSessionAnchor.TAG, "plugin manager install err code:" + installPackage);
                            if (installPackage != 1 && installPackage != -1) {
                                this.this$0.xRSessionCreateFail(this.this$0.mNativeSessionHandle, 1003);
                            }
                            if (jd1.o == null) {
                                this.this$0.xRSessionCreateSuccess(this.this$0.mNativeSessionHandle, jd1.p);
                            } else {
                                jd1.o.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener(this) { // from class: com.baidu.ar.session.XRSessionAnchor.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.smallgame.sdk.permission.PermissionListener
                                    public void onPermissionResult(String str2, int i) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeLI(1048576, this, str2, i) == null) {
                                            if (i == 0) {
                                                Log.i(XRSessionAnchor.TAG, "Permission ok!@ permissionState:" + i);
                                                XRSessionAnchor xRSessionAnchor = this.this$1.this$0;
                                                xRSessionAnchor.xRSessionCreateSuccess(xRSessionAnchor.mNativeSessionHandle, jd1.p);
                                                this.this$1.this$0.mOrientationEventListener.enable();
                                                return;
                                            }
                                            int i2 = i + 1000;
                                            XRSessionAnchor xRSessionAnchor2 = this.this$1.this$0;
                                            xRSessionAnchor2.xRSessionCreateFail(xRSessionAnchor2.mNativeSessionHandle, i2);
                                            Log.i(XRSessionAnchor.TAG, "Permission fail:" + i2);
                                        }
                                    }
                                });
                            }
                        } catch (Throwable unused2) {
                            XRSessionAnchor xRSessionAnchor = this.this$0;
                            xRSessionAnchor.xRSessionCreateFail(xRSessionAnchor.mNativeSessionHandle, 1003);
                        }
                    }
                }
            }).start();
        }
    }
}
