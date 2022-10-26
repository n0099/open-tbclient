package com.baidu.android.pushservice.httpapi;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public int f;
    public String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i iVar, Context context, int i, int i2) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.e = i;
        this.f = i2;
        if (i == 0) {
            ((d) this).d = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i iVar, Context context, int i, int i2, String str) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context, Integer.valueOf(i), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.e = i;
        this.f = i2;
        this.g = str;
        if (i == 0) {
            ((d) this).d = true;
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            intent.putExtra("bind_status", this.e);
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void a(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.a(hashMap);
            String d = com.baidu.android.pushservice.c.c.d(((a) this).a, "bduss");
            if (TextUtils.isEmpty(d)) {
                return;
            }
            hashMap.put("cookie", d);
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.d, com.baidu.android.pushservice.httpapi.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String b = super.b(str);
            if (!TextUtils.isEmpty(((a) this).b.d)) {
                com.baidu.android.pushservice.a.b.a(((a) this).a).e(((a) this).b.d);
                if (!TextUtils.isEmpty(((a) this).b.g)) {
                    com.baidu.android.pushservice.a.b.a(((a) this).a).a(((a) this).b.d, new f(((a) this).b.g, b));
                }
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void b(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "bind");
            hashMap.put("bind_status", this.e + "");
            hashMap.put("push_sdk_version", this.f + "");
            if (com.baidu.android.pushservice.b.d.b(((a) this).a)) {
                String cuid = DeviceId.getCUID(((a) this).a);
                if (!TextUtils.isEmpty(cuid)) {
                    hashMap.put("cuid", cuid);
                    String d = com.baidu.android.pushservice.c.c.d(((a) this).a, PushConstants.EXTRA_PUSH_FREQ);
                    if (!TextUtils.isEmpty(d)) {
                        hashMap.put(PushConstants.EXTRA_PUSH_FREQ, d);
                    }
                }
                hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(((a) this).a).c());
            }
            String d2 = com.baidu.android.pushservice.c.c.d(((a) this).a, "teenager");
            if (!TextUtils.isEmpty(d2)) {
                hashMap.put("teenager", d2);
            }
            String d3 = com.baidu.android.pushservice.c.c.d(((a) this).a, "privacy");
            if (!TextUtils.isEmpty(d3)) {
                hashMap.put("privacy", d3);
            }
            String d4 = com.baidu.android.pushservice.c.c.d(((a) this).a, PushConstants.EXTRA_APP_NOTIFY_STATUS);
            if (!TextUtils.isEmpty(d4)) {
                hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, d4);
            }
            String y = com.baidu.android.pushservice.i.m.y(((a) this).a);
            if (!TextUtils.isEmpty(y)) {
                hashMap.put("app_version", y);
            }
            String d5 = com.baidu.android.pushservice.c.c.d(((a) this).a, "do_not_disturb");
            if (!TextUtils.isEmpty(d5)) {
                hashMap.put("do_not_disturb", d5);
            }
            String a = com.baidu.android.pushservice.i.i.a(((a) this).a, PushConstants.EXTRA_BDUSS_ACTION);
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(com.baidu.android.pushservice.c.c.d(((a) this).a, "bduss"))) {
                hashMap.put("bd_action", a);
            }
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put("bind_notify_status", this.g);
            }
            if (!TextUtils.isEmpty(((a) this).b.i) && com.baidu.android.pushservice.b.d.r(((a) this).a)) {
                hashMap.put("push_proxy", ((a) this).b.i);
            }
            hashMap.put("manufacture", com.baidu.android.pushservice.i.m.c(((a) this).a, false));
            if (com.baidu.android.pushservice.i.m.x(((a) this).a)) {
                hashMap.put(Config.ROM, com.baidu.android.pushservice.i.m.l(((a) this).a));
            }
            if (com.baidu.android.pushservice.i.m.A(((a) this).a)) {
                hashMap.put("connect_version", "3");
            } else {
                hashMap.put("connect_version", "2");
            }
            hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
            String str = ((a) this).b.d;
            if (!TextUtils.isEmpty(str) && str.length() <= 128) {
                hashMap.put("package_name", str);
            }
            String deviceID = DeviceId.getDeviceID(((a) this).a);
            if (com.baidu.android.pushservice.g.f()) {
                try {
                    hashMap.put("rsa_device_id", Base64.encodeToString(com.baidu.android.pushservice.i.k.a(deviceID.getBytes(), BaiduAppSSOJni.getPublicKey(1)), 2));
                } catch (Exception unused) {
                }
            } else {
                hashMap.put("device_id", deviceID);
            }
            hashMap.put(HttpConstants.DEVICE_TYPE, "3");
            hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.f(((a) this).a) ? 1 : 0) + "");
            hashMap.put("dual_channel", (com.baidu.android.pushservice.b.d.c(((a) this).a) ? 1 : 0) + "");
            hashMap.put("ignore_token", (((a) this).b.k ? 1 : 0) + "");
            if (PushSettings.e(((a) this).a)) {
                return;
            }
            hashMap.put("check_sdk", com.baidu.android.pushservice.i.i.a(((a) this).a, "com.baidu.android.pushservice.CHECK_SDK"));
        }
    }
}
