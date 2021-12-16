package com.baidu.android.pushservice.message;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
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
    }

    private byte[] a(long j2, g gVar) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, this, j2, gVar)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.baidu.android.pushservice.j.e eVar = new com.baidu.android.pushservice.j.e(byteArrayOutputStream);
            try {
                try {
                    eVar.a(j2);
                    eVar.b(gVar.a());
                    eVar.b(0);
                    if (gVar.b() != null) {
                        eVar.a(gVar.b());
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                    }
                    try {
                        eVar.a();
                    } catch (IOException e3) {
                        new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                    }
                    return byteArray;
                } catch (Exception e4) {
                    new b.c(this.a).a(Log.getStackTraceString(e4)).a();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        new b.c(this.a).a(Log.getStackTraceString(e5)).a();
                    }
                    try {
                        eVar.a();
                        return null;
                    } catch (IOException e6) {
                        new b.c(this.a).a(Log.getStackTraceString(e6)).a();
                        return null;
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e7) {
                    new b.c(this.a).a(Log.getStackTraceString(e7)).a();
                }
                try {
                    eVar.a();
                } catch (IOException e8) {
                    new b.c(this.a).a(Log.getStackTraceString(e8)).a();
                }
                throw th;
            }
        }
        return (byte[]) invokeJL.objValue;
    }

    private byte[] a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i2)) == null) {
            byte[] bArr = new byte[i2];
            if (str != null) {
                byte[] bytes = str.getBytes();
                System.arraycopy(bytes, 0, bArr, 0, Math.min(i2, bytes.length));
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
            com.baidu.android.pushservice.j.e eVar = new com.baidu.android.pushservice.j.e(byteArrayOutputStream);
            int length = bArr != null ? bArr.length : 0;
            try {
                try {
                    eVar.a((int) s);
                    if (s != h.f33212f.b() && s != h.f33213g.b()) {
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
                    com.baidu.android.pushservice.e.c.a(this.a, byteArrayOutputStream);
                    try {
                        eVar.a();
                    } catch (Exception e2) {
                        new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                    }
                    return byteArray;
                } catch (Throwable th) {
                    com.baidu.android.pushservice.e.c.a(this.a, byteArrayOutputStream);
                    try {
                        eVar.a();
                    } catch (Exception e3) {
                        new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                new b.c(this.a).a(Log.getStackTraceString(e4)).a();
                com.baidu.android.pushservice.e.c.a(this.a, byteArrayOutputStream);
                try {
                    eVar.a();
                    return null;
                } catch (Exception e5) {
                    new b.c(this.a).a(Log.getStackTraceString(e5)).a();
                    return null;
                }
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    @Override // com.baidu.android.pushservice.message.d
    public e a(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            com.baidu.android.pushservice.j.d dVar = new com.baidu.android.pushservice.j.d(byteArrayInputStream);
            short c2 = dVar.c();
            e eVar = new e(c2);
            if (c2 != h.f33213g.b() && c2 != h.f33212f.b()) {
                dVar.c();
                dVar.b();
                dVar.a(new byte[16]);
                dVar.b();
                dVar.b();
                int b2 = dVar.b();
                byte[] bArr2 = null;
                if (b2 > 0) {
                    if (b2 > 20480) {
                        b2 = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;
                    }
                    bArr2 = new byte[b2];
                    dVar.a(bArr2);
                }
                eVar.f33202b = bArr2;
            }
            byteArrayInputStream.close();
            dVar.a();
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.message.d
    public void a(int i2, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, bArr) == null) {
            g gVar = new g();
            gVar.a(i2);
            if (bArr != null) {
                gVar.a(bArr);
            }
            e eVar = new e(h.f33211e.b());
            try {
                eVar.f33202b = a(h.f33211e.b(), a(Long.parseLong(str), gVar));
                a(eVar);
            } catch (NumberFormatException e2) {
                new b.c(this.a).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0168 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    @Override // com.baidu.android.pushservice.message.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        b.c cVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel_token", com.baidu.android.pushservice.k.a(this.a).b());
                jSONObject.put("channel_id", com.baidu.android.pushservice.k.a(this.a).a());
                if (com.baidu.android.pushservice.b.d.b(this.a)) {
                    jSONObject.put("new_channel_token", com.baidu.android.pushservice.k.a(this.a).d());
                    jSONObject.put("new_channel_id", com.baidu.android.pushservice.k.a(this.a).c());
                }
                jSONObject.put("sa_mode", com.baidu.android.pushservice.b.d.a(this.a).b());
                jSONObject.put("highest_version", com.baidu.android.pushservice.b.d.a(this.a).c());
                jSONObject.put("period", 1800);
                jSONObject.put("channel_type", 3);
                jSONObject.put("tinyheart", 1);
                if (m.o(this.a)) {
                    jSONObject.put("connect_version", 3);
                    String str2 = Build.MANUFACTURER;
                    if (!TextUtils.isEmpty(str2) && str2.length() <= 128) {
                        jSONObject.put("manufacture", str2);
                    }
                } else {
                    jSONObject.put("connect_version", 2);
                }
                jSONObject.put("app_alone_conn", com.baidu.android.pushservice.b.d.e(this.a) ? 1 : 0);
                jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, this.a.getPackageName());
                jSONObject.put("proxy_conn", com.baidu.android.pushservice.b.d.c(this.a) ? 1 : 0);
                jSONObject.put("noti_enable", com.baidu.android.pushservice.j.h.b(this.a));
                if (this.a.getPackageName().equals("com.baidu.searchbox")) {
                    jSONObject.put("pkg_version", m.a(this.a));
                }
                jSONObject.put("tiny_msghead", 1);
                jSONObject.put("alarm_function", 1);
                JSONObject jSONObject2 = new JSONObject();
                String str3 = Build.MODEL;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("model", str3);
                }
                String cuid = DeviceId.getCUID(this.a);
                if (!TextUtils.isEmpty(cuid)) {
                    jSONObject2.put("cuid", cuid);
                }
                int length = jSONObject2.toString().length();
                jSONObject.put("devinfo", Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), 2));
                jSONObject.put("devinfolength", length);
                str = jSONObject.toString();
            } catch (Exception e2) {
                e = e2;
                cVar = new b.c(this.a);
                cVar.a(Log.getStackTraceString(e)).a();
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
            } catch (UnsatisfiedLinkError e3) {
                e = e3;
                cVar = new b.c(this.a);
                cVar.a(Log.getStackTraceString(e)).a();
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte[] a = a(h.f33208b.b(), str.getBytes());
            e eVar = new e(h.f33208b.b());
            eVar.f33202b = a;
            eVar.f33203c = true;
            eVar.a(false);
            a(eVar);
        }
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
        if (a3 == null || (a = a3.a(eVar)) == null || !eVar.f33204d) {
            return;
        }
        e eVar2 = new e(eVar.a);
        if (a2 == h.f33211e) {
            eVar2.f33202b = a(h.f33211e.b(), a(eVar.e().e(), a));
        } else if (a2 == h.f33213g || a2 == h.f33209c) {
            eVar2.f33202b = a(eVar.a, (byte[]) null);
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
            byte[] a = a(h.f33212f.b(), (byte[]) null);
            e eVar = new e(h.f33212f.b());
            eVar.f33202b = a;
            eVar.f33203c = true;
            eVar.a(true);
            a(eVar);
        }
    }
}
