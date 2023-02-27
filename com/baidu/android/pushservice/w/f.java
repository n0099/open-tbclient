package com.baidu.android.pushservice.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.android.pushservice.a0.d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, InputStream inputStream, OutputStream outputStream) {
        super(context, inputStream, outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, inputStream, outputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (InputStream) objArr2[1], (OutputStream) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new com.baidu.android.pushservice.a0.d(inputStream);
    }

    @Override // com.baidu.android.pushservice.w.d
    public void a(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            j.a(i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel_token", com.baidu.android.pushservice.j.a(this.a).b());
                jSONObject.put("channel_id", com.baidu.android.pushservice.j.a(this.a).a());
                if (com.baidu.android.pushservice.l.d.o(this.a)) {
                    jSONObject.put("new_channel_token", com.baidu.android.pushservice.j.a(this.a).d());
                    jSONObject.put("new_channel_id", com.baidu.android.pushservice.j.a(this.a).c());
                }
                jSONObject.put("sa_mode", com.baidu.android.pushservice.l.d.i(this.a).b());
                jSONObject.put("proxyed", com.baidu.android.pushservice.a0.j.f(this.a) ? 1 : 2);
                jSONObject.put("highest_version", com.baidu.android.pushservice.l.d.i(this.a).c());
                jSONObject.put("period", 1800);
                jSONObject.put("channel_type", 3);
                String a = com.baidu.android.pushservice.m.d.a(this.a, "privacy");
                if (!TextUtils.isEmpty(a)) {
                    jSONObject.put("privacy", Integer.parseInt(a));
                }
                jSONObject.put("push_launch_level", com.baidu.android.pushservice.a0.i.a(this.a.getApplicationContext(), "key_push_launch_task_level", 0));
                jSONObject.put("tinyheart", 1);
                if (Utility.D(this.a)) {
                    jSONObject.put("connect_version", 3);
                    String a2 = Utility.a(this.a, false);
                    if (!TextUtils.isEmpty(a2) && a2.length() <= 128) {
                        jSONObject.put("manufacture", a2);
                    }
                } else {
                    jSONObject.put("connect_version", 2);
                }
                jSONObject.put("app_alone_conn", com.baidu.android.pushservice.l.d.s(this.a) ? 1 : 0);
                jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, this.a.getPackageName());
                jSONObject.put("source", i);
                jSONObject.put("proc_source", com.baidu.android.pushservice.t.a.a(this.a).b());
                long a3 = com.baidu.android.pushservice.a0.i.a(this.a, "last_time", System.currentTimeMillis() / 1000);
                jSONObject.put("last_time", a3 + "");
                jSONObject.put("widget_number", com.baidu.android.pushservice.e.D(this.a) ? 1 : 0);
                jSONObject.put("app_last_update_ts", Utility.u(this.a));
                jSONObject.put("proxy_conn", com.baidu.android.pushservice.l.d.q(this.a) ? 1 : 0);
                jSONObject.put("noti_enable", com.baidu.android.pushservice.a0.h.b(this.a));
                if (this.a.getPackageName().equals("com.baidu.searchbox")) {
                    jSONObject.put("pkg_version", Utility.A(this.a));
                }
                jSONObject.put("tiny_msghead", 1);
                jSONObject.put("alarm_function", 1);
                JSONObject jSONObject2 = new JSONObject();
                String cuid = DeviceId.getCUID(this.a);
                if (!TextUtils.isEmpty(cuid)) {
                    jSONObject2.put("cuid", cuid);
                }
                int length = jSONObject2.toString().length();
                jSONObject.put("devinfo", Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), 2));
                jSONObject.put("devinfolength", length);
                jSONObject.put("scale", this.a.getResources().getDisplayMetrics().density);
                jSONObject.put("last_update_conf_ts", com.baidu.android.pushservice.a0.k.a(this.a, "last_update_config_time", 0L) / 1000);
                str = jSONObject.toString();
            } catch (Exception | UnsatisfiedLinkError unused) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte[] a4 = a(h.c.a(), str.getBytes());
            e eVar = new e(h.c.a());
            eVar.b = a4;
            eVar.c = true;
            eVar.a(false);
            b(eVar);
        }
    }

    @Override // com.baidu.android.pushservice.w.d
    public void a(int i, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, bArr) == null) {
            g gVar = new g();
            gVar.a(i);
            if (bArr != null) {
                gVar.a(bArr);
            }
            e eVar = new e(h.f.a());
            try {
                eVar.b = a(h.f.a(), a(Long.parseLong(str), gVar));
                b(eVar);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // com.baidu.android.pushservice.w.d
    public void a(e eVar) {
        g a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        a aVar = new a(this.a);
        h a2 = h.a(eVar.a);
        c a3 = aVar.a(a2);
        if (a3 == null || (a = a3.a(eVar)) == null || !eVar.d) {
            return;
        }
        e eVar2 = new e(eVar.a);
        if (a2 == h.f) {
            eVar2.b = a(h.f.a(), a(eVar.b().g(), a));
        } else if (a2 == h.h || a2 == h.d) {
            eVar2.b = a(eVar.a, (byte[]) null);
        }
        b(eVar2);
    }

    public final byte[] a(long j, g gVar) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, gVar)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.baidu.android.pushservice.a0.e eVar = new com.baidu.android.pushservice.a0.e(byteArrayOutputStream);
            try {
                try {
                    eVar.a(j);
                    eVar.a(gVar.a());
                    eVar.a(0);
                    if (gVar.b() != null) {
                        eVar.a(gVar.b());
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        eVar.a();
                    } catch (IOException unused2) {
                    }
                    return byteArray;
                } catch (IOException unused3) {
                    try {
                        eVar.a();
                        return null;
                    } catch (IOException unused4) {
                        return null;
                    }
                }
            } catch (Exception unused5) {
                byteArrayOutputStream.close();
                eVar.a();
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused6) {
                }
                try {
                    eVar.a();
                } catch (IOException unused7) {
                }
                throw th;
            }
        }
        return (byte[]) invokeJL.objValue;
    }

    public final byte[] a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            byte[] bArr = new byte[i];
            if (str != null) {
                byte[] bytes = str.getBytes();
                System.arraycopy(bytes, 0, bArr, 0, Math.min(i, bytes.length));
            }
            return bArr;
        }
        return (byte[]) invokeLI.objValue;
    }

    public final byte[] a(short s, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Short.valueOf(s), bArr})) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.baidu.android.pushservice.a0.e eVar = new com.baidu.android.pushservice.a0.e(byteArrayOutputStream);
            int length = bArr != null ? bArr.length : 0;
            try {
                eVar.b(s);
                if (s != h.g.a() && s != h.h.a()) {
                    eVar.b(com.baidu.android.pushservice.a.a());
                    eVar.a(0);
                    eVar.a(a(Utility.n(this.a, this.a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                    eVar.a(-76508268);
                    eVar.a(1);
                    eVar.a(length);
                    if (bArr != null) {
                        eVar.a(bArr);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.baidu.android.pushservice.q.c.a(this.a, byteArrayOutputStream);
                try {
                    eVar.a();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Exception unused2) {
                com.baidu.android.pushservice.q.c.a(this.a, byteArrayOutputStream);
                try {
                    eVar.a();
                    return null;
                } catch (Exception unused3) {
                    return null;
                }
            } catch (Throwable th) {
                com.baidu.android.pushservice.q.c.a(this.a, byteArrayOutputStream);
                try {
                    eVar.a();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    @Override // com.baidu.android.pushservice.w.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.w.d
    public e c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            short d = this.c.d();
            e eVar = new e(d);
            if (d != h.h.a() && d != h.g.a()) {
                this.c.d();
                this.c.b();
                this.c.a(new byte[16]);
                this.c.b();
                this.c.b();
                int b = this.c.b();
                byte[] bArr = null;
                if (b > 0) {
                    if (b > 20480) {
                        b = 20480;
                    }
                    bArr = new byte[b];
                    this.c.a(bArr);
                }
                eVar.b = bArr;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.w.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            byte[] a = a(h.g.a(), (byte[]) null);
            e eVar = new e(h.g.a());
            eVar.b = a;
            eVar.c = true;
            eVar.a(true);
            b(eVar);
        }
    }
}
