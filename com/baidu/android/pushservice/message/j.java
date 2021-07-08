package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f3577b;

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
        this.f3577b = context.getApplicationContext();
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

    public static void a(Context context, com.baidu.android.pushservice.message.a.l lVar, String str, int i2) {
        b.a c2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, context, lVar, str, i2) == null) {
            if (lVar == com.baidu.android.pushservice.message.a.l.f3540b || lVar == com.baidu.android.pushservice.message.a.l.f3541c || lVar == com.baidu.android.pushservice.message.a.l.f3545g) {
                b.a a2 = new b.a(context).a("0").b(str).a(System.currentTimeMillis());
                c2 = a2.c(i2 + "");
                j = 601002;
            } else {
                b.a a3 = new b.a(context).a("0").b(str).a(System.currentTimeMillis());
                c2 = a3.c(i2 + "");
                j = 601001;
            }
            c2.b(j).a();
        }
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            eVar.f3554d = true;
            g gVar = new g();
            gVar.a(-1);
            byte[] bArr = eVar.f3552b;
            if (bArr == null) {
                return gVar;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            com.baidu.android.pushservice.j.d dVar = new com.baidu.android.pushservice.j.d(byteArrayInputStream);
            try {
                k kVar = new k();
                byte[] bArr2 = new byte[128];
                dVar.a(bArr2);
                kVar.a(a(bArr2));
                kVar.b(dVar.d());
                kVar.b((int) dVar.c());
                int c2 = dVar.c();
                byte[] bArr3 = new byte[64];
                dVar.a(bArr3);
                kVar.a(bArr3);
                if (c2 > 0) {
                    byte[] bArr4 = new byte[c2];
                    dVar.a(bArr4);
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
                                kVar.b(string2);
                            }
                        }
                        if (!jSONObject.isNull("expiretime")) {
                            kVar.a(jSONObject.getLong("expiretime"));
                        }
                        kVar.a(!jSONObject.isNull("notify_id") ? jSONObject.getInt("notify_id") : kVar.g() != com.baidu.android.pushservice.message.a.l.f3546h.b() ? m.i(this.f3577b, kVar.f()) : 0);
                        kVar.a(false);
                    } catch (JSONException e2) {
                        new b.c(this.f3548a).a(Log.getStackTraceString(e2)).a();
                    }
                } else {
                    kVar.a(false);
                }
                byteArrayInputStream.close();
                dVar.a();
                eVar.a(kVar);
                if (c2 <= 0) {
                    c2 = 0;
                }
                int i2 = c2 + 204;
                int length = bArr.length - i2;
                if (length <= 0) {
                    length = 0;
                }
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr, i2, bArr5, 0, length);
                m.a("New MSG: " + kVar.toString(), this.f3548a);
                com.baidu.android.pushservice.message.a.l a2 = com.baidu.android.pushservice.message.a.l.a(kVar.g());
                if (a2 != com.baidu.android.pushservice.message.a.l.j && com.baidu.android.pushservice.c.c.c(this.f3548a, kVar.e())) {
                    String str = "Message ID(" + kVar.f() + ") received duplicated, ack success to server directly.";
                    com.baidu.android.pushservice.g.a.a("PushMessageHandler", str, this.f3577b);
                    m.a(str, this.f3577b);
                    a(this.f3548a, a2, kVar.f(), 4);
                    gVar.a(4);
                    return gVar;
                }
                com.baidu.android.pushservice.message.a.d a3 = new com.baidu.android.pushservice.message.a.k(this.f3548a).a(a2);
                if (a3 != null) {
                    gVar = a3.a(kVar, bArr5);
                } else {
                    gVar.a(2);
                }
                if (gVar == null) {
                    return null;
                }
                if (a2 == com.baidu.android.pushservice.message.a.l.f3540b || a2 == com.baidu.android.pushservice.message.a.l.f3541c || a2 == com.baidu.android.pushservice.message.a.l.f3545g) {
                    com.baidu.android.pushservice.c.c.a(this.f3548a, kVar.c(), kVar.g(), kVar.e(), bArr5, kVar.h(), kVar.b(), gVar.a(), kVar.a());
                } else if (a2 != com.baidu.android.pushservice.message.a.l.j) {
                    com.baidu.android.pushservice.c.c.a(this.f3548a, kVar.c(), kVar.g(), kVar.e(), null, null, 0L, gVar.a(), kVar.a());
                }
                m.o(this.f3548a);
                a(this.f3548a, a2, kVar.f(), gVar.a());
                return gVar;
            } catch (IOException e3) {
                new b.c(this.f3548a).a(Log.getStackTraceString(e3)).a();
                return gVar;
            }
        }
        return (g) invokeL.objValue;
    }
}
