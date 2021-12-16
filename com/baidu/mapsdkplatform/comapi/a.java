package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a implements PermissionCheck.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";

    /* renamed from: g  reason: collision with root package name */
    public static a f36796g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f36797h = -100;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f36798b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f36799c;

    /* renamed from: d  reason: collision with root package name */
    public e f36800d;

    /* renamed from: e  reason: collision with root package name */
    public String f36801e;

    /* renamed from: f  reason: collision with root package name */
    public int f36802f;

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
            if (f36796g == null) {
                f36796g = new a();
            }
            return f36796g;
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
                    this.f36798b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
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
            this.f36798b.sendBroadcast(intent);
        }
    }

    private void f() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
            Context context = this.f36798b;
            if (context == null || (eVar = this.f36800d) == null) {
                return;
            }
            context.registerReceiver(eVar, intentFilter);
        }
    }

    private void g() {
        e eVar;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (eVar = this.f36800d) == null || (context = this.f36798b) == null) {
            return;
        }
        context.unregisterReceiver(eVar);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f36798b = context;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.a == 0) {
            i.f37174d = bVar.f37154e;
            i.a(bVar.f37151b, bVar.f37152c);
        } else {
            String str = "Authentication Error\n" + bVar.toString();
        }
        int i3 = bVar.a;
        if (i3 != PermissionCheck.f37141b && i3 != PermissionCheck.a && i3 != PermissionCheck.f37142c) {
            com.baidu.mapsdkplatform.comapi.util.d.a().a(bVar.f37155f);
        }
        Handler handler = this.f36799c;
        if (handler == null || (i2 = bVar.a) == f36797h) {
            return;
        }
        f36797h = i2;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 2012;
        obtainMessage.arg1 = bVar.a;
        obtainMessage.obj = bVar.f37153d;
        this.f36799c.sendMessage(obtainMessage);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f36801e = str;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f36802f == 0) {
                if (this.f36798b == null) {
                    throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                }
                this.f36800d = new e();
                f();
                SysUpdateObservable.getInstance().updateNetworkInfo(this.f36798b);
            }
            this.f36802f++;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f36798b != null) {
                this.f36799c = new b(this);
                i.b(this.f36798b);
                com.baidu.mapsdkplatform.comapi.util.d.a().a(this.f36798b);
                i.f();
                PermissionCheck.init(this.f36798b);
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
            int i2 = this.f36802f - 1;
            this.f36802f = i2;
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
            Context context = this.f36798b;
            if (context != null) {
                return context;
            }
            throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        return (Context) invokeV.objValue;
    }
}
