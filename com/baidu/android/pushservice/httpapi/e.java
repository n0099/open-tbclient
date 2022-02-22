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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f32445e;

    /* renamed from: f  reason: collision with root package name */
    public int f32446f;

    /* renamed from: g  reason: collision with root package name */
    public String f32447g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i iVar, Context context, int i2, int i3) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32445e = 0;
        this.f32445e = i2;
        this.f32446f = i3;
        if (i2 == 0) {
            ((d) this).f32444d = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i iVar, Context context, int i2, int i3, String str) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context, Integer.valueOf(i2), Integer.valueOf(i3), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32445e = 0;
        this.f32445e = i2;
        this.f32446f = i3;
        this.f32447g = str;
        if (i2 == 0) {
            ((d) this).f32444d = true;
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            intent.putExtra("bind_status", this.f32445e);
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.a(hashMap);
            String d2 = com.baidu.android.pushservice.c.c.d(((a) this).a, "bduss");
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            hashMap.put("cookie", d2);
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.d, com.baidu.android.pushservice.httpapi.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String b2 = super.b(str);
            if (!TextUtils.isEmpty(((a) this).f32441b.f32455d)) {
                com.baidu.android.pushservice.a.b.a(((a) this).a).e(((a) this).f32441b.f32455d);
                if (!TextUtils.isEmpty(((a) this).f32441b.f32458g)) {
                    com.baidu.android.pushservice.a.b.a(((a) this).a).a(((a) this).f32441b.f32455d, new f(((a) this).f32441b.f32458g, b2));
                }
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "bind");
            hashMap.put("bind_name", Build.MODEL);
            hashMap.put("bind_status", this.f32445e + "");
            hashMap.put("push_sdk_version", this.f32446f + "");
            if (com.baidu.android.pushservice.b.d.b(((a) this).a)) {
                String cuid = DeviceId.getCUID(((a) this).a);
                if (!TextUtils.isEmpty(cuid)) {
                    hashMap.put("cuid", cuid);
                    String d2 = com.baidu.android.pushservice.c.c.d(((a) this).a, PushConstants.EXTRA_PUSH_FREQ);
                    if (!TextUtils.isEmpty(d2)) {
                        hashMap.put(PushConstants.EXTRA_PUSH_FREQ, d2);
                    }
                }
                hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(((a) this).a).c());
            }
            String d3 = com.baidu.android.pushservice.c.c.d(((a) this).a, "teenager");
            if (!TextUtils.isEmpty(d3)) {
                hashMap.put("teenager", d3);
            }
            String d4 = com.baidu.android.pushservice.c.c.d(((a) this).a, "privacy");
            if (!TextUtils.isEmpty(d4)) {
                hashMap.put("privacy", d4);
            }
            String d5 = com.baidu.android.pushservice.c.c.d(((a) this).a, PushConstants.EXTRA_APP_NOTIFY_STATUS);
            if (!TextUtils.isEmpty(d5)) {
                hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, d5);
            }
            String m = com.baidu.android.pushservice.i.m.m(((a) this).a);
            if (!TextUtils.isEmpty(m)) {
                hashMap.put("app_version", m);
            }
            String d6 = com.baidu.android.pushservice.c.c.d(((a) this).a, "do_not_disturb");
            if (!TextUtils.isEmpty(d6)) {
                hashMap.put("do_not_disturb", d6);
            }
            String a = com.baidu.android.pushservice.i.i.a(((a) this).a, PushConstants.EXTRA_BDUSS_ACTION);
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(com.baidu.android.pushservice.c.c.d(((a) this).a, "bduss"))) {
                hashMap.put("bd_action", a);
            }
            if (!TextUtils.isEmpty(this.f32447g)) {
                hashMap.put("bind_notify_status", this.f32447g);
            }
            if (!TextUtils.isEmpty(((a) this).f32441b.f32460i) && com.baidu.android.pushservice.b.d.q(((a) this).a)) {
                hashMap.put("push_proxy", ((a) this).f32441b.f32460i);
            }
            hashMap.put("manufacture", com.baidu.android.pushservice.i.m.a(false));
            if (com.baidu.android.pushservice.i.m.n()) {
                hashMap.put("rom", com.baidu.android.pushservice.i.m.l(((a) this).a));
            }
            if (com.baidu.android.pushservice.i.m.o(((a) this).a)) {
                hashMap.put("connect_version", "3");
            } else {
                hashMap.put("connect_version", "2");
            }
            hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
            String str = ((a) this).f32441b.f32455d;
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
            hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(((a) this).a) ? 1 : 0) + "");
            hashMap.put("dual_channel", (com.baidu.android.pushservice.b.d.c(((a) this).a) ? 1 : 0) + "");
            hashMap.put("ignore_token", (((a) this).f32441b.k ? 1 : 0) + "");
            if (PushSettings.e(((a) this).a)) {
                return;
            }
            hashMap.put("check_sdk", com.baidu.android.pushservice.i.i.a(((a) this).a, "com.baidu.android.pushservice.CHECK_SDK"));
        }
    }
}
