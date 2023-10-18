package com.baidu.android.pushservice.p;

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
import com.baidu.android.pushservice.util.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.mobads.sdk.internal.bj;
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
    public int g;
    public int h;
    public String i;

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
        this.g = 0;
        this.g = i;
        this.h = i2;
        if (i == 0) {
            this.f = true;
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
        this.g = 0;
        this.g = i;
        this.h = i2;
        this.i = str;
        if (i == 0) {
            this.f = true;
        }
    }

    @Override // com.baidu.android.pushservice.p.a
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            intent.putExtra("bind_status", this.g);
        }
    }

    @Override // com.baidu.android.pushservice.p.a
    public void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            super.a(hashMap);
            String a = com.baidu.android.pushservice.m.d.a(this.c, "bduss");
            if (TextUtils.isEmpty(a)) {
                return;
            }
            hashMap.put("cookie", a);
        }
    }

    @Override // com.baidu.android.pushservice.p.d, com.baidu.android.pushservice.p.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String b = super.b(str);
            if (!TextUtils.isEmpty(this.d.c)) {
                com.baidu.android.pushservice.k.b.a(this.c).d(this.d.c);
                if (!TextUtils.isEmpty(this.d.f)) {
                    com.baidu.android.pushservice.k.b.a(this.c).a(this.d.c, new f(this.d.f, b));
                }
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.p.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", UbcRemoteStat.BIND_SERVICE);
            hashMap.put("bind_status", this.g + "");
            hashMap.put("push_sdk_version", this.h + "");
            if (com.baidu.android.pushservice.l.d.o(this.c)) {
                String cuid = DeviceId.getCUID(this.c);
                if (!TextUtils.isEmpty(cuid)) {
                    hashMap.put("cuid", cuid);
                    String a = com.baidu.android.pushservice.m.d.a(this.c, PushConstants.EXTRA_PUSH_FREQ);
                    if (!TextUtils.isEmpty(a)) {
                        hashMap.put(PushConstants.EXTRA_PUSH_FREQ, a);
                    }
                }
                hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(this.c).c());
            }
            String a2 = com.baidu.android.pushservice.m.d.a(this.c, "teenager");
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("teenager", a2);
            }
            String a3 = com.baidu.android.pushservice.m.d.a(this.c, "privacy");
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put("privacy", a3);
            }
            String a4 = com.baidu.android.pushservice.m.d.a(this.c, PushConstants.EXTRA_APP_NOTIFY_STATUS);
            if (!TextUtils.isEmpty(a4)) {
                hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, a4);
            }
            String r = Utility.r(this.c);
            if (!TextUtils.isEmpty(r)) {
                hashMap.put("app_version", r);
            }
            String a5 = com.baidu.android.pushservice.m.d.a(this.c, "do_not_disturb");
            if (!TextUtils.isEmpty(a5)) {
                hashMap.put("do_not_disturb", a5);
            }
            String c = com.baidu.android.pushservice.a0.i.c(this.c, PushConstants.EXTRA_BDUSS_ACTION);
            if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(com.baidu.android.pushservice.m.d.a(this.c, "bduss"))) {
                hashMap.put("bd_action", c);
            }
            if (!TextUtils.isEmpty(this.i)) {
                hashMap.put("bind_notify_status", this.i);
            }
            if (!TextUtils.isEmpty(this.d.h) && com.baidu.android.pushservice.l.d.r(this.c)) {
                hashMap.put("push_proxy", this.d.h);
            }
            hashMap.put("manufacture", Utility.a(this.c, false));
            if (Utility.O(this.c)) {
                hashMap.put(Config.ROM, Utility.y(this.c));
            }
            if (Utility.D(this.c)) {
                hashMap.put("connect_version", "3");
            } else {
                hashMap.put("connect_version", "2");
            }
            hashMap.put(bj.f, Build.VERSION.SDK_INT + "");
            String str = this.d.c;
            if (!TextUtils.isEmpty(str) && str.length() <= 128) {
                hashMap.put("package_name", str);
            }
            String deviceID = DeviceId.getDeviceID(this.c);
            if (com.baidu.android.pushservice.g.f()) {
                try {
                    hashMap.put("rsa_device_id", Base64.encodeToString(com.baidu.android.pushservice.a0.l.a(deviceID.getBytes(), BaiduAppSSOJni.getPublicKey(1)), 2));
                } catch (Exception unused) {
                }
            } else {
                hashMap.put("device_id", deviceID);
            }
            hashMap.put(HttpConstants.DEVICE_TYPE, "3");
            hashMap.put("app_alone_conn", (com.baidu.android.pushservice.l.d.s(this.c) ? 1 : 0) + "");
            hashMap.put("dual_channel", (com.baidu.android.pushservice.l.d.q(this.c) ? 1 : 0) + "");
            hashMap.put("ignore_token", (this.d.j ? 1 : 0) + "");
            hashMap.put("auto_start", String.valueOf(com.baidu.android.pushservice.v.c.a().b(this.c)));
            hashMap.put("power_allowed", String.valueOf(com.baidu.android.pushservice.v.c.a().a(this.c)));
            if (PushSettings.f(this.c)) {
                return;
            }
            hashMap.put("check_sdk", com.baidu.android.pushservice.a0.i.c(this.c, "com.baidu.android.pushservice.CHECK_SDK"));
        }
    }
}
