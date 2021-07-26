package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.i;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final String f7573a = "a";

    /* renamed from: g  reason: collision with root package name */
    public static a f7574g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f7575h = -100;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f7576b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f7577c;

    /* renamed from: d  reason: collision with root package name */
    public e f7578d;

    /* renamed from: e  reason: collision with root package name */
    public String f7579e;

    /* renamed from: f  reason: collision with root package name */
    public int f7580f;

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
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7574g == null) {
                f7574g = new a();
            }
            return f7574g;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, message) == null) {
            if (message.what != 2012) {
                if (message.arg2 == 3) {
                    this.f7576b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
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
            this.f7576b.sendBroadcast(intent);
        }
    }

    private void f() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
            Context context = this.f7576b;
            if (context == null || (eVar = this.f7578d) == null) {
                return;
            }
            context.registerReceiver(eVar, intentFilter);
        }
    }

    private void g() {
        e eVar;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (eVar = this.f7578d) == null || (context = this.f7576b) == null) {
            return;
        }
        context.unregisterReceiver(eVar);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f7576b = context;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.f8005a == 0) {
            i.f8038d = bVar.f8009e;
            i.a(bVar.f8006b, bVar.f8007c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        int i3 = bVar.f8005a;
        if (i3 != PermissionCheck.f7997b && i3 != PermissionCheck.f7996a && i3 != PermissionCheck.f7998c) {
            com.baidu.mapsdkplatform.comapi.util.d.a().a(bVar.f8010f);
        }
        Handler handler = this.f7577c;
        if (handler == null || (i2 = bVar.f8005a) == f7575h) {
            return;
        }
        f7575h = i2;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = IMConstants.IM_MSG_TYPE_SHIELD_ME;
        obtainMessage.arg1 = bVar.f8005a;
        obtainMessage.obj = bVar.f8008d;
        this.f7577c.sendMessage(obtainMessage);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f7579e = str;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f7580f == 0) {
                if (this.f7576b == null) {
                    throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                }
                this.f7578d = new e();
                f();
                SysUpdateObservable.getInstance().updateNetworkInfo(this.f7576b);
            }
            this.f7580f++;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f7576b != null) {
                this.f7577c = new b(this);
                i.b(this.f7576b);
                com.baidu.mapsdkplatform.comapi.util.d.a().a(this.f7576b);
                i.f();
                PermissionCheck.init(this.f7576b);
                PermissionCheck.setPermissionCheckResultListener(this);
                PermissionCheck.permissionCheck();
                return true;
            }
            throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f7580f - 1;
            this.f7580f = i2;
            if (i2 == 0) {
                g();
                i.a();
            }
        }
    }

    public Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = this.f7576b;
            if (context != null) {
                return context;
            }
            throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        return (Context) invokeV.objValue;
    }
}
