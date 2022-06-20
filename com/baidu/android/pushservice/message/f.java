package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
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
    public com.baidu.android.pushservice.i.d d;

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
        this.d = new com.baidu.android.pushservice.i.d(inputStream);
    }

    private byte[] a(long j, g gVar) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, this, j, gVar)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.baidu.android.pushservice.i.e eVar = new com.baidu.android.pushservice.i.e(byteArrayOutputStream);
            try {
                try {
                    eVar.a(j);
                    eVar.b(gVar.a());
                    eVar.b(0);
                    if (gVar.b() != null) {
                        eVar.a(gVar.b());
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        new b.c(this.a).a(Log.getStackTraceString(e)).a();
                    }
                    try {
                        eVar.a();
                    } catch (IOException e2) {
                        new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                    }
                    return byteArray;
                } catch (Exception e3) {
                    new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        new b.c(this.a).a(Log.getStackTraceString(e4)).a();
                    }
                    try {
                        eVar.a();
                        return null;
                    } catch (IOException e5) {
                        new b.c(this.a).a(Log.getStackTraceString(e5)).a();
                        return null;
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e6) {
                    new b.c(this.a).a(Log.getStackTraceString(e6)).a();
                }
                try {
                    eVar.a();
                } catch (IOException e7) {
                    new b.c(this.a).a(Log.getStackTraceString(e7)).a();
                }
                throw th;
            }
        }
        return (byte[]) invokeJL.objValue;
    }

    private byte[] a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i)) == null) {
            byte[] bArr = new byte[i];
            if (str != null) {
                byte[] bytes = str.getBytes();
                System.arraycopy(bytes, 0, bArr, 0, Math.min(i, bytes.length));
            }
            return bArr;
        }
        return (byte[]) invokeLI.objValue;
    }

    private byte[] a(short s, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Short.valueOf(s), bArr})) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.baidu.android.pushservice.i.e eVar = new com.baidu.android.pushservice.i.e(byteArrayOutputStream);
            int length = bArr != null ? bArr.length : 0;
            try {
                try {
                    eVar.a((int) s);
                    if (s != h.f.b() && s != h.g.b()) {
                        eVar.a((int) com.baidu.android.pushservice.a.a());
                        eVar.b(0);
                        eVar.a(a(m.d(this.a, this.a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                        eVar.b(-76508268);
                        eVar.b(1);
                        eVar.b(length);
                        if (bArr != null) {
                            eVar.a(bArr);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.baidu.android.pushservice.d.c.a(this.a, byteArrayOutputStream);
                    try {
                        eVar.a();
                    } catch (Exception e) {
                        new b.c(this.a).a(Log.getStackTraceString(e)).a();
                    }
                    return byteArray;
                } catch (Throwable th) {
                    com.baidu.android.pushservice.d.c.a(this.a, byteArrayOutputStream);
                    try {
                        eVar.a();
                    } catch (Exception e2) {
                        new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                com.baidu.android.pushservice.d.c.a(this.a, byteArrayOutputStream);
                try {
                    eVar.a();
                    return null;
                } catch (Exception e4) {
                    new b.c(this.a).a(Log.getStackTraceString(e4)).a();
                    return null;
                }
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x01ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bb  */
    @Override // com.baidu.android.pushservice.message.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i) {
        b.c cVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel_token", com.baidu.android.pushservice.j.a(this.a).b());
                jSONObject.put("channel_id", com.baidu.android.pushservice.j.a(this.a).a());
                if (com.baidu.android.pushservice.b.d.b(this.a)) {
                    jSONObject.put("new_channel_token", com.baidu.android.pushservice.j.a(this.a).d());
                    jSONObject.put("new_channel_id", com.baidu.android.pushservice.j.a(this.a).c());
                }
                jSONObject.put("sa_mode", com.baidu.android.pushservice.b.d.a(this.a).b());
                jSONObject.put("highest_version", com.baidu.android.pushservice.b.d.a(this.a).c());
                jSONObject.put("period", 1800);
                jSONObject.put("channel_type", 3);
                String d = com.baidu.android.pushservice.c.c.d(this.a, "privacy");
                if (!TextUtils.isEmpty(d)) {
                    jSONObject.put("privacy", Integer.parseInt(d));
                }
                jSONObject.put("push_launch_level", com.baidu.android.pushservice.i.i.b(this.a.getApplicationContext(), "key_push_launch_task_level", 0));
                jSONObject.put("tinyheart", 1);
                if (m.A(this.a)) {
                    jSONObject.put("connect_version", 3);
                    String c = m.c(this.a, false);
                    if (!TextUtils.isEmpty(c) && c.length() <= 128) {
                        jSONObject.put("manufacture", c);
                    }
                } else {
                    jSONObject.put("connect_version", 2);
                }
                jSONObject.put("app_alone_conn", com.baidu.android.pushservice.b.d.f(this.a) ? 1 : 0);
                jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, this.a.getPackageName());
                jSONObject.put("source", i);
                long a = com.baidu.android.pushservice.i.i.a(this.a, "last_time", System.currentTimeMillis());
                jSONObject.put("last_time", a + "");
                jSONObject.put("widget_number", com.baidu.android.pushservice.e.i(this.a) ? 1 : 0);
                jSONObject.put("proxy_conn", com.baidu.android.pushservice.b.d.c(this.a) ? 1 : 0);
                jSONObject.put("noti_enable", com.baidu.android.pushservice.i.h.b(this.a));
                if (this.a.getPackageName().equals("com.baidu.searchbox")) {
                    jSONObject.put("pkg_version", m.a(this.a));
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
                str = jSONObject.toString();
            } catch (Exception e) {
                e = e;
                cVar = new b.c(this.a);
                cVar.a(Log.getStackTraceString(e)).a();
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
            } catch (UnsatisfiedLinkError e2) {
                e = e2;
                cVar = new b.c(this.a);
                cVar.a(Log.getStackTraceString(e)).a();
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte[] a2 = a(h.b.b(), str.getBytes());
            e eVar = new e(h.b.b());
            eVar.b = a2;
            eVar.c = true;
            eVar.a(false);
            a(eVar);
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public void a(int i, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, bArr) == null) {
            g gVar = new g();
            gVar.a(i);
            if (bArr != null) {
                gVar.a(bArr);
            }
            e eVar = new e(h.e.b());
            try {
                eVar.b = a(h.e.b(), a(Long.parseLong(str), gVar));
                a(eVar);
            } catch (NumberFormatException e) {
                new b.c(this.a).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public e b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            short c = this.d.c();
            e eVar = new e(c);
            if (c != h.g.b() && c != h.f.b()) {
                this.d.c();
                this.d.b();
                this.d.a(new byte[16]);
                this.d.b();
                this.d.b();
                int b = this.d.b();
                byte[] bArr = null;
                if (b > 0) {
                    if (b > 20480) {
                        b = 20480;
                    }
                    bArr = new byte[b];
                    this.d.a(bArr);
                }
                eVar.b = bArr;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.message.d
    public void b(e eVar) {
        g a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        a aVar = new a(this.a);
        h a2 = h.a(eVar.a);
        c a3 = aVar.a(a2);
        if (a3 == null || (a = a3.a(eVar)) == null || !eVar.d) {
            return;
        }
        e eVar2 = new e(eVar.a);
        if (a2 == h.e) {
            eVar2.b = a(h.e.b(), a(eVar.e().g(), a));
        } else if (a2 == h.g || a2 == h.c) {
            eVar2.b = a(eVar.a, (byte[]) null);
        }
        a(eVar2);
    }

    @Override // com.baidu.android.pushservice.message.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            byte[] a = a(h.f.b(), (byte[]) null);
            e eVar = new e(h.f.b());
            eVar.b = a;
            eVar.c = true;
            eVar.a(true);
            a(eVar);
        }
    }
}
