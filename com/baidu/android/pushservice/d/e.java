package com.baidu.android.pushservice.d;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f36079e;

    /* renamed from: f  reason: collision with root package name */
    public int f36080f;

    /* renamed from: g  reason: collision with root package name */
    public String f36081g;

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
        this.f36079e = 0;
        this.f36079e = i2;
        this.f36080f = i3;
        if (i2 == 0) {
            ((d) this).f36078d = true;
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
        this.f36079e = 0;
        this.f36079e = i2;
        this.f36080f = i3;
        this.f36081g = str;
        if (i2 == 0) {
            ((d) this).f36078d = true;
        }
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            intent.putExtra("bind_status", this.f36079e);
        }
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.a(hashMap);
            String d2 = com.baidu.android.pushservice.c.c.d(((a) this).f36073a, "bduss");
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            hashMap.put("cookie", d2);
        }
    }

    @Override // com.baidu.android.pushservice.d.d, com.baidu.android.pushservice.d.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String b2 = super.b(str);
            if (!TextUtils.isEmpty(((a) this).f36074b.f36092d)) {
                com.baidu.android.pushservice.a.b.a(((a) this).f36073a).e(((a) this).f36074b.f36092d);
                if (!TextUtils.isEmpty(((a) this).f36074b.f36095g)) {
                    com.baidu.android.pushservice.a.b.a(((a) this).f36073a).a(((a) this).f36074b.f36092d, new f(((a) this).f36074b.f36095g, b2));
                }
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "bind");
            hashMap.put("bind_name", Build.MODEL);
            hashMap.put("bind_status", this.f36079e + "");
            hashMap.put("push_sdk_version", this.f36080f + "");
            if (com.baidu.android.pushservice.b.d.b(((a) this).f36073a)) {
                String cuid = DeviceId.getCUID(((a) this).f36073a);
                if (!TextUtils.isEmpty(cuid)) {
                    hashMap.put("cuid", cuid);
                    String d2 = com.baidu.android.pushservice.c.c.d(((a) this).f36073a, PushConstants.EXTRA_PUSH_FREQ);
                    if (!TextUtils.isEmpty(d2)) {
                        hashMap.put(PushConstants.EXTRA_PUSH_FREQ, d2);
                    }
                }
                hashMap.put("new_channel_id", com.baidu.android.pushservice.k.a(((a) this).f36073a).c());
            }
            String d3 = com.baidu.android.pushservice.c.c.d(((a) this).f36073a, PushConstants.EXTRA_APP_NOTIFY_STATUS);
            if (!TextUtils.isEmpty(d3)) {
                hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, d3);
            }
            String m = com.baidu.android.pushservice.j.m.m(((a) this).f36073a);
            if (!TextUtils.isEmpty(m)) {
                hashMap.put("app_version", m);
            }
            String d4 = com.baidu.android.pushservice.c.c.d(((a) this).f36073a, "do_not_disturb");
            if (!TextUtils.isEmpty(d4)) {
                hashMap.put("do_not_disturb", d4);
            }
            String a2 = com.baidu.android.pushservice.j.i.a(((a) this).f36073a, PushConstants.EXTRA_BDUSS_ACTION);
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(com.baidu.android.pushservice.c.c.d(((a) this).f36073a, "bduss"))) {
                hashMap.put("bd_action", a2);
            }
            if (!TextUtils.isEmpty(this.f36081g)) {
                hashMap.put("bind_notify_status", this.f36081g);
            }
            if (!TextUtils.isEmpty(((a) this).f36074b.f36097i) && com.baidu.android.pushservice.b.d.q(((a) this).f36073a)) {
                hashMap.put("push_proxy", ((a) this).f36074b.f36097i);
            }
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (com.baidu.android.pushservice.j.m.n()) {
                hashMap.put("rom", com.baidu.android.pushservice.j.m.l(((a) this).f36073a));
            }
            if (com.baidu.android.pushservice.j.m.o(((a) this).f36073a)) {
                hashMap.put("connect_version", "3");
            } else {
                hashMap.put("connect_version", "2");
            }
            hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
            String str = ((a) this).f36074b.f36092d;
            if (!TextUtils.isEmpty(str) && str.length() <= 128) {
                hashMap.put("package_name", str);
            }
            String deviceID = DeviceId.getDeviceID(((a) this).f36073a);
            if (com.baidu.android.pushservice.h.f()) {
                try {
                    hashMap.put("rsa_device_id", Base64.encodeToString(com.baidu.android.pushservice.j.k.a(deviceID.getBytes(), BaiduAppSSOJni.getPublicKey(1)), 2));
                } catch (Exception unused) {
                }
            } else {
                hashMap.put("device_id", deviceID);
            }
            hashMap.put("device_type", "3");
            hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(((a) this).f36073a) ? 1 : 0) + "");
            hashMap.put("dual_channel", (com.baidu.android.pushservice.b.d.c(((a) this).f36073a) ? 1 : 0) + "");
            hashMap.put("ignore_token", (((a) this).f36074b.k ? 1 : 0) + "");
            if (PushSettings.e(((a) this).f36073a)) {
                return;
            }
            hashMap.put("check_sdk", com.baidu.android.pushservice.j.i.a(((a) this).f36073a, "com.baidu.android.pushservice.CHECK_SDK"));
        }
    }
}
