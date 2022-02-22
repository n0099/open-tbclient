package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f32550b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32550b = context.getApplicationContext();
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            int i2 = 0;
            while (true) {
                if (i2 >= bArr.length) {
                    i2 = 0;
                    break;
                } else if (bArr[i2] == 0) {
                    break;
                } else {
                    i2++;
                }
            }
            return new String(bArr, 0, i2);
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, com.baidu.android.pushservice.message.a.k kVar, String str, int i2) {
        b.a c2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, context, kVar, str, i2) == null) {
            if (kVar == com.baidu.android.pushservice.message.a.k.f32517b || kVar == com.baidu.android.pushservice.message.a.k.f32518c || kVar == com.baidu.android.pushservice.message.a.k.f32522g) {
                b.a a = new b.a(context).a("0").b(str).a(System.currentTimeMillis());
                c2 = a.c(i2 + "");
                j2 = 601002;
            } else {
                b.a a2 = new b.a(context).a("0").b(str).a(System.currentTimeMillis());
                c2 = a2.c(i2 + "");
                j2 = 601001;
            }
            c2.b(j2).a();
        }
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        InterceptResult invokeL;
        g gVar;
        k kVar;
        int c2;
        g gVar2;
        g gVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            eVar.f32529d = true;
            g gVar4 = new g();
            gVar4.a(-1);
            byte[] bArr = eVar.f32527b;
            if (bArr == null) {
                return gVar4;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            com.baidu.android.pushservice.i.d dVar = new com.baidu.android.pushservice.i.d(byteArrayInputStream);
            try {
                kVar = new k();
                byte[] bArr2 = new byte[128];
                dVar.a(bArr2);
                kVar.b(a(bArr2));
                kVar.b(dVar.d());
                kVar.c(dVar.c());
                c2 = dVar.c();
                byte[] bArr3 = new byte[64];
                dVar.a(bArr3);
                kVar.a(bArr3);
            } catch (IOException e2) {
                e = e2;
                gVar = gVar4;
            }
            try {
                if (c2 > 0) {
                    byte[] bArr4 = new byte[c2];
                    dVar.a(bArr4);
                    gVar2 = gVar4;
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr4));
                        if (!jSONObject.isNull("sign_info")) {
                            String string = jSONObject.getString("sign_info");
                            if (!TextUtils.isEmpty(string)) {
                                kVar.b(string.getBytes());
                            }
                        }
                        if (!jSONObject.isNull("package_name")) {
                            String string2 = jSONObject.getString("package_name");
                            if (!TextUtils.isEmpty(string2)) {
                                kVar.c(string2);
                            }
                        }
                        if (!jSONObject.isNull("expiretime")) {
                            kVar.a(jSONObject.getLong("expiretime"));
                        }
                        if (!jSONObject.isNull("foreground_show")) {
                            kVar.b(jSONObject.getInt("foreground_show"));
                        }
                        int i2 = !jSONObject.isNull("notify_id") ? jSONObject.getInt("notify_id") : kVar.i() != com.baidu.android.pushservice.message.a.k.f32523h.b() ? m.i(this.f32550b, kVar.h()) : 0;
                        if (!jSONObject.isNull("lt")) {
                            com.baidu.android.pushservice.i.i.b(this.f32550b, "last_time", jSONObject.optLong("lt"));
                        }
                        if (!jSONObject.isNull("wbn")) {
                            int optInt = jSONObject.optInt("wbn");
                            int optInt2 = jSONObject.optInt("wbt");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("widget_badge_type", optInt2);
                            jSONObject2.put("widget_badge_num", optInt);
                            kVar.a(jSONObject2.toString());
                        }
                        kVar.a(i2);
                        kVar.a(false);
                    } catch (JSONException e3) {
                        new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                    }
                } else {
                    gVar2 = gVar4;
                    kVar.a(false);
                }
                byteArrayInputStream.close();
                dVar.a();
                eVar.a(kVar);
                if (c2 <= 0) {
                    c2 = 0;
                }
                int i3 = c2 + 204;
                int length = bArr.length - i3;
                if (length <= 0) {
                    length = 0;
                }
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr, i3, bArr5, 0, length);
                com.baidu.android.pushservice.message.a.k a = com.baidu.android.pushservice.message.a.k.a(kVar.i());
                if (a != com.baidu.android.pushservice.message.a.k.f32524i && com.baidu.android.pushservice.c.c.c(this.a, kVar.g())) {
                    com.baidu.android.pushservice.f.a.a("PushMessageHandler", "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.f32550b);
                    a(this.a, a, kVar.h(), 4);
                    g gVar5 = gVar2;
                    gVar5.a(4);
                    return gVar5;
                }
                g gVar6 = gVar2;
                com.baidu.android.pushservice.message.a.c a2 = new com.baidu.android.pushservice.message.a.j(this.a).a(a);
                if (a2 != null) {
                    gVar3 = a2.a(kVar, bArr5);
                } else {
                    gVar6.a(2);
                    gVar3 = gVar6;
                }
                if (gVar3 == null) {
                    return null;
                }
                if (a == com.baidu.android.pushservice.message.a.k.f32517b || a == com.baidu.android.pushservice.message.a.k.f32518c || a == com.baidu.android.pushservice.message.a.k.f32522g) {
                    com.baidu.android.pushservice.c.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), bArr5, kVar.j(), kVar.d(), gVar3.a(), kVar.b());
                } else if (a != com.baidu.android.pushservice.message.a.k.f32524i) {
                    com.baidu.android.pushservice.c.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), null, null, 0L, gVar3.a(), kVar.b());
                }
                m.o(this.a);
                a(this.a, a, kVar.h(), gVar3.a());
                return gVar3;
            } catch (IOException e4) {
                e = e4;
                gVar = gVar2;
                new b.c(this.a).a(Log.getStackTraceString(e)).a();
                return gVar;
            }
        }
        return (g) invokeL.objValue;
    }
}
