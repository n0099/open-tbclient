package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements PermissionCheck.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public static a f = null;
    public static int g = -100;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public Handler c;
    public f d;
    public int e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-52719328, "Lcom/baidu/mapsdkplatform/comapi/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-52719328, "Lcom/baidu/mapsdkplatform/comapi/a;");
                return;
            }
        }
        NativeLoader.getInstance().loadLibrary("gnustl_shared");
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.e == 0) {
                if (this.b == null) {
                    Context cachedContext = JNIInitializer.getCachedContext();
                    this.b = cachedContext;
                    if (cachedContext == null) {
                        Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                        return;
                    }
                }
                this.d = new f();
                f();
                SysUpdateObservable.getInstance().updateNetworkInfo(this.b);
            }
            this.e++;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                f = new a();
            }
            return f;
        }
        return (a) invokeV.objValue;
    }

    private void f() {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
            Context context = this.b;
            if (context != null && (fVar = this.d) != null) {
                context.registerReceiver(fVar, intentFilter);
            }
        }
    }

    private void g() {
        f fVar;
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && (fVar = this.d) != null && (context = this.b) != null) {
            context.unregisterReceiver(fVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = this.e - 1;
            this.e = i;
            if (i == 0) {
                g();
                h.b();
            }
        }
    }

    public Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b == null) {
                this.b = JNIInitializer.getCachedContext();
            }
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, message) == null) {
            if (this.b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                this.b = cachedContext;
                if (cachedContext == null) {
                    return;
                }
            }
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
            int i = message.arg2;
            if (i == 2 || i == 404 || i == 5 || i == 8) {
                this.b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.b = context;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) != null) || bVar == null) {
            return;
        }
        if (bVar.a == 0) {
            h.c = bVar.e;
            h.a(bVar.b, bVar.c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        int i2 = bVar.a;
        if (i2 != PermissionCheck.b && i2 != PermissionCheck.a && i2 != PermissionCheck.c) {
            com.baidu.mapsdkplatform.comapi.util.c.a().a(bVar.f);
        }
        Handler handler = this.c;
        if (handler != null && (i = bVar.a) != g) {
            g = i;
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 2012;
            obtainMessage.arg1 = bVar.a;
            obtainMessage.obj = bVar.d;
            this.c.sendMessage(obtainMessage);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                this.b = cachedContext;
                if (cachedContext == null) {
                    Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return false;
                }
            }
            h.b(this.b);
            if (!c.b()) {
                PermissionCheck.setPrivacyMode(false);
            } else {
                PermissionCheck.setPrivacyMode(true);
            }
            this.c = new b(this);
            h.c(this.b);
            com.baidu.mapsdkplatform.comapi.util.c.a().a(this.b);
            h.h();
            PermissionCheck.init(this.b);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            if (c.b()) {
                return true;
            }
            throw new BaiduMapSDKException("not agree privacyMode, please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
        }
        return invokeV.booleanValue;
    }
}
