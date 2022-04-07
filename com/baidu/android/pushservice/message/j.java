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
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context.getApplicationContext();
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            int i = 0;
            while (true) {
                if (i >= bArr.length) {
                    i = 0;
                    break;
                } else if (bArr[i] == 0) {
                    break;
                } else {
                    i++;
                }
            }
            return new String(bArr, 0, i);
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, com.baidu.android.pushservice.message.a.k kVar, String str, int i) {
        b.a c;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, context, kVar, str, i) == null) {
            if (kVar == com.baidu.android.pushservice.message.a.k.b || kVar == com.baidu.android.pushservice.message.a.k.c || kVar == com.baidu.android.pushservice.message.a.k.g) {
                b.a a = new b.a(context).a("0").b(str).a(System.currentTimeMillis());
                c = a.c(i + "");
                j = 601002;
            } else {
                b.a a2 = new b.a(context).a("0").b(str).a(System.currentTimeMillis());
                c = a2.c(i + "");
                j = 601001;
            }
            c.b(j).a();
        }
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        InterceptResult invokeL;
        g gVar;
        k kVar;
        int c;
        g gVar2;
        g gVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            eVar.d = true;
            g gVar4 = new g();
            gVar4.a(-1);
            byte[] bArr = eVar.b;
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
                c = dVar.c();
                byte[] bArr3 = new byte[64];
                dVar.a(bArr3);
                kVar.a(bArr3);
            } catch (IOException e) {
                e = e;
                gVar = gVar4;
            }
            try {
                if (c > 0) {
                    byte[] bArr4 = new byte[c];
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
                        int i = !jSONObject.isNull("notify_id") ? jSONObject.getInt("notify_id") : kVar.i() != com.baidu.android.pushservice.message.a.k.h.b() ? m.i(this.b, kVar.h()) : 0;
                        if (!jSONObject.isNull(WebvttCueParser.ENTITY_LESS_THAN)) {
                            com.baidu.android.pushservice.i.i.b(this.b, "last_time", jSONObject.optLong(WebvttCueParser.ENTITY_LESS_THAN));
                        }
                        if (!jSONObject.isNull("wbn")) {
                            int optInt = jSONObject.optInt("wbn");
                            int optInt2 = jSONObject.optInt("wbt");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("widget_badge_type", optInt2);
                            jSONObject2.put("widget_badge_num", optInt);
                            kVar.a(jSONObject2.toString());
                        }
                        kVar.a(i);
                        kVar.a(false);
                    } catch (JSONException e2) {
                        new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                    }
                } else {
                    gVar2 = gVar4;
                    kVar.a(false);
                }
                byteArrayInputStream.close();
                dVar.a();
                eVar.a(kVar);
                if (c <= 0) {
                    c = 0;
                }
                int i2 = c + 204;
                int length = bArr.length - i2;
                if (length <= 0) {
                    length = 0;
                }
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr, i2, bArr5, 0, length);
                com.baidu.android.pushservice.message.a.k a = com.baidu.android.pushservice.message.a.k.a(kVar.i());
                if (a != com.baidu.android.pushservice.message.a.k.i && com.baidu.android.pushservice.c.c.c(this.a, kVar.g())) {
                    com.baidu.android.pushservice.f.a.a("PushMessageHandler", "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.b);
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
                if (a == com.baidu.android.pushservice.message.a.k.b || a == com.baidu.android.pushservice.message.a.k.c || a == com.baidu.android.pushservice.message.a.k.g) {
                    com.baidu.android.pushservice.c.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), bArr5, kVar.j(), kVar.d(), gVar3.a(), kVar.b());
                } else if (a != com.baidu.android.pushservice.message.a.k.i) {
                    com.baidu.android.pushservice.c.c.a(this.a, kVar.e(), kVar.i(), kVar.g(), null, null, 0L, gVar3.a(), kVar.b());
                }
                m.o(this.a);
                a(this.a, a, kVar.h(), gVar3.a());
                return gVar3;
            } catch (IOException e3) {
                e = e3;
                gVar = gVar2;
                new b.c(this.a).a(Log.getStackTraceString(e)).a();
                return gVar;
            }
        }
        return (g) invokeL.objValue;
    }
}
