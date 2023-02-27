package com.baidu.android.pushservice.w;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.message.LocalPushMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676482677, "Lcom/baidu/android/pushservice/w/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676482677, "Lcom/baidu/android/pushservice/w/j;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context.getApplicationContext();
    }

    public static k a(Context context, k kVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, kVar, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("sign_info")) {
                    String string = jSONObject.getString("sign_info");
                    if (!TextUtils.isEmpty(string)) {
                        kVar.b(string.getBytes());
                    }
                }
                if (!jSONObject.isNull("package_name")) {
                    String string2 = jSONObject.getString("package_name");
                    if (!TextUtils.isEmpty(string2)) {
                        kVar.d(string2);
                    }
                }
                if (!jSONObject.isNull("expiretime")) {
                    kVar.a(jSONObject.getLong("expiretime"));
                }
                int i = !jSONObject.isNull(Constants.EXTRA_NOTIFY_ID) ? jSONObject.getInt(Constants.EXTRA_NOTIFY_ID) : kVar.q() != com.baidu.android.pushservice.w.m.l.i.a() ? Utility.p(context, kVar.h()) : 0;
                if (!jSONObject.isNull(WebvttCueParser.ENTITY_LESS_THAN)) {
                    com.baidu.android.pushservice.a0.i.b(context, "last_time", jSONObject.optLong(WebvttCueParser.ENTITY_LESS_THAN));
                }
                if (!jSONObject.isNull("wbn")) {
                    int optInt = jSONObject.optInt("wbn");
                    int optInt2 = jSONObject.optInt("wbt");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("widget_badge_type", optInt2);
                    jSONObject2.put("widget_badge_num", optInt);
                    kVar.g(jSONObject2.toString());
                }
                if (!jSONObject.isNull("foreground_show")) {
                    int i2 = jSONObject.getInt("foreground_show");
                    kVar.a(i2 & 3);
                    kVar.c(i2 & 2080374847);
                }
                if (!jSONObject.isNull("pop_duration")) {
                    kVar.f(jSONObject.optInt("pop_duration", 5));
                }
                if (!jSONObject.isNull("show_params")) {
                    kVar.e(jSONObject.optString("show_params"));
                }
                if (!jSONObject.isNull("log_ext")) {
                    kVar.c(jSONObject.optString("log_ext"));
                }
                kVar.b(i);
                kVar.a(false);
            } catch (JSONException unused) {
            }
            return kVar;
        }
        return (k) invokeLLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
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

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            c = i;
        }
    }

    @Override // com.baidu.android.pushservice.w.c
    public g a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            eVar.d = true;
            g gVar = new g();
            gVar.a(-1);
            byte[] bArr = eVar.b;
            if (bArr == null) {
                return gVar;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            com.baidu.android.pushservice.a0.d dVar = new com.baidu.android.pushservice.a0.d(byteArrayInputStream);
            try {
                k kVar = new k();
                byte[] bArr2 = new byte[128];
                dVar.a(bArr2);
                kVar.a(a(bArr2));
                kVar.d(c);
                kVar.c(dVar.c());
                kVar.e(dVar.d());
                int d = dVar.d();
                byte[] bArr3 = new byte[64];
                dVar.a(bArr3);
                kVar.a(bArr3);
                if (d > 0) {
                    byte[] bArr4 = new byte[d];
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
                                kVar.d(string2);
                            }
                        }
                        if (!jSONObject.isNull("expiretime")) {
                            kVar.a(jSONObject.getLong("expiretime"));
                        }
                        if (!jSONObject.isNull("start")) {
                            kVar.f(jSONObject.getString("start"));
                        }
                        if (!jSONObject.isNull("end")) {
                            kVar.b(jSONObject.getString("end"));
                        }
                        if (!jSONObject.isNull("interval")) {
                            kVar.b(jSONObject.getLong("interval"));
                        }
                        int i = !jSONObject.isNull(Constants.EXTRA_NOTIFY_ID) ? jSONObject.getInt(Constants.EXTRA_NOTIFY_ID) : kVar.q() != com.baidu.android.pushservice.w.m.l.i.a() ? Utility.p(this.b, kVar.h()) : 0;
                        if (!jSONObject.isNull(WebvttCueParser.ENTITY_LESS_THAN)) {
                            com.baidu.android.pushservice.a0.i.b(this.b, "last_time", jSONObject.optLong(WebvttCueParser.ENTITY_LESS_THAN));
                        }
                        if (!jSONObject.isNull("wbn")) {
                            int optInt = jSONObject.optInt("wbn");
                            int optInt2 = jSONObject.optInt("wbt");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("widget_badge_type", optInt2);
                            jSONObject2.put("widget_badge_num", optInt);
                            kVar.g(jSONObject2.toString());
                        }
                        if (!jSONObject.isNull("foreground_show")) {
                            int i2 = jSONObject.getInt("foreground_show");
                            kVar.a(i2 & 3);
                            kVar.c(i2 & 2080374847);
                        }
                        if (!jSONObject.isNull("pop_duration")) {
                            kVar.f(jSONObject.optInt("pop_duration", 5));
                        }
                        if (!jSONObject.isNull("show_params")) {
                            kVar.e(jSONObject.optString("show_params"));
                        }
                        if (!jSONObject.isNull("log_ext")) {
                            kVar.c(jSONObject.optString("log_ext"));
                        }
                        kVar.b(i);
                        kVar.a(false);
                    } catch (JSONException unused) {
                    }
                } else {
                    kVar.a(false);
                }
                byteArrayInputStream.close();
                dVar.a();
                eVar.a(kVar);
                if (d <= 0) {
                    d = 0;
                }
                int i3 = d + 204;
                int length = bArr.length - i3;
                if (length <= 0) {
                    length = 0;
                }
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr, i3, bArr5, 0, length);
                com.baidu.android.pushservice.w.m.l a = com.baidu.android.pushservice.w.m.l.a(kVar.q());
                if (a != com.baidu.android.pushservice.w.m.l.j && com.baidu.android.pushservice.m.d.a(this.a, kVar.g())) {
                    com.baidu.android.pushservice.u.a.a("PushMessageHandler", "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.", this.b);
                    gVar.a(4);
                    return gVar;
                }
                g gVar2 = gVar;
                com.baidu.android.pushservice.w.m.c a2 = new com.baidu.android.pushservice.w.m.k(this.a).a(a);
                if (a2 != null) {
                    gVar2 = a2.a(kVar, bArr5);
                } else {
                    gVar2.a(2);
                }
                if (gVar2 == null) {
                    return null;
                }
                if (a == com.baidu.android.pushservice.w.m.l.c || a == com.baidu.android.pushservice.w.m.l.d || a == com.baidu.android.pushservice.w.m.l.h) {
                    com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), bArr5, kVar.k(), kVar.c(), gVar2.a(), kVar.i());
                } else if (a == com.baidu.android.pushservice.w.m.l.k) {
                    com.baidu.android.pushservice.n.c.a().a(this.a, new LocalPushMsg(kVar, new String(bArr5)));
                } else if (a != com.baidu.android.pushservice.w.m.l.j) {
                    com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), null, null, 0L, gVar2.a(), kVar.i());
                }
                Utility.D(this.a);
                return gVar2;
            } catch (IOException unused2) {
                return gVar;
            }
        }
        return (g) invokeL.objValue;
    }
}
