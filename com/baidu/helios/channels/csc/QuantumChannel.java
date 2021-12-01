package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q.f.a;
import c.a.q.f.c.a;
import c.a.q.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.channels.csc.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class QuantumChannel extends c.a.q.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int f35053j;

    /* renamed from: k  reason: collision with root package name */
    public static final int f35054k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0742a f35055f;

    /* renamed from: g  reason: collision with root package name */
    public d f35056g;

    /* renamed from: h  reason: collision with root package name */
    public f f35057h;

    /* renamed from: i  reason: collision with root package name */
    public b f35058i;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f35059b;

        /* renamed from: c  reason: collision with root package name */
        public String f35060c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.a.q.h.b.b bVar = new c.a.q.h.b.b();
            try {
                this.a = new String(bVar.a(c.a.q.f.c.b.a()), "UTF-8");
                this.f35059b = new String(bVar.a(c.a.q.f.c.b.b()), "UTF-8");
                this.f35060c = new String(bVar.a(c.a.q.f.c.b.c()), "UTF-8");
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f35061b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.q.h.c.a.e f35062c;

        /* renamed from: d  reason: collision with root package name */
        public long f35063d;

        /* renamed from: e  reason: collision with root package name */
        public String f35064e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35065f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ QuantumChannel f35066g;

        public d(QuantumChannel quantumChannel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quantumChannel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35066g = quantumChannel;
            this.f35062c = new c.a.q.h.c.a.e();
            this.f35065f = true;
        }

        public long a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f35062c.a(j2) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35064e : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.a == i2) {
                return;
            }
            this.a = i2;
            this.f35065f = true;
        }

        public boolean d(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                if (this.f35062c.c(j2, j3)) {
                    this.f35065f = true;
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                String str2 = this.f35064e;
                if (str2 == str) {
                    return false;
                }
                if (str == null || !str.equals(str2)) {
                    this.f35065f = true;
                    this.f35064e = str;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f35061b == j2) {
                return;
            }
            this.f35061b = j2;
            this.f35065f = true;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35063d : invokeV.longValue;
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.f35063d != j2) {
                    this.f35063d = j2;
                    this.f35065f = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.f35065f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.a);
                        jSONObject.put("pub_lst_ts", this.f35061b);
                        jSONObject.put("pkg_lst_up_ts", this.f35063d);
                        jSONObject.put("flags", this.f35062c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.f35064e);
                        this.f35066g.f35055f.i("pub.dat", jSONObject.toString(), true);
                        this.f35065f = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                String g2 = this.f35066g.f35055f.g("pub.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.a = jSONObject.getInt("pub_ver");
                    this.f35061b = jSONObject.getLong("pub_lst_ts");
                    this.f35063d = jSONObject.getLong("pkg_lst_up_ts");
                    this.f35062c.b(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.f35064e = jSONObject.optString("aid");
                    this.f35065f = false;
                } catch (Exception unused) {
                    this.f35065f = true;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a.C0731a a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f35067b;

        /* loaded from: classes8.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public byte[] a;

            /* renamed from: b  reason: collision with root package name */
            public int f35068b;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = new byte[160];
            }

            public a a(byte b2) {
                InterceptResult invokeB;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b2)) == null) {
                    c(this.f35068b + 1);
                    byte[] bArr = this.a;
                    int i2 = this.f35068b;
                    this.f35068b = i2 + 1;
                    bArr[i2] = b2;
                    return this;
                }
                return (a) invokeB.objValue;
            }

            public e b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(Arrays.copyOf(this.a, this.f35068b)) : (e) invokeV.objValue;
            }

            public final void c(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    byte[] bArr = this.a;
                    if (i2 - bArr.length > 0) {
                        int length = bArr.length;
                        int i3 = length + (length >> 1);
                        if (i3 - i2 >= 0) {
                            i2 = i3;
                        }
                        this.a = Arrays.copyOf(this.a, i2);
                    }
                }
            }
        }

        public e(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35067b = bArr;
            this.a = c.a.q.f.c.a.b(bArr);
        }

        public static byte a(int i2) throws h {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            return (byte) 2;
                        }
                        throw new h("unexpected value " + i2);
                    }
                    return (byte) 1;
                }
                return (byte) 0;
            }
            return invokeI.byteValue;
        }

        public static int b(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) {
                if (b2 != 0) {
                    if (b2 != 1) {
                        if (b2 == 2) {
                            return 2;
                        }
                        throw new IllegalStateException();
                    }
                    return 1;
                }
                return 0;
            }
            return invokeB.intValue;
        }

        public static e c(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) ? new e(c.a.q.f.c.a.c(bArr, i2)) : (e) invokeLI.objValue;
        }

        public byte[] d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a() : (byte[]) invokeV.objValue;
        }

        public int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 >= 0) {
                    byte[] bArr = this.f35067b;
                    if (i2 < bArr.length) {
                        return b(bArr[i2]);
                    }
                }
                throw new IllegalArgumentException("illegal index " + i2 + " with current length is " + this.f35067b.length);
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35067b.length : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;

        /* renamed from: b  reason: collision with root package name */
        public Method f35069b;

        /* renamed from: c  reason: collision with root package name */
        public Method f35070c;

        /* renamed from: d  reason: collision with root package name */
        public Class<?> f35071d;

        public f(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                d(context);
            } catch (Exception e2) {
                throw new IllegalStateException("charset = " + Charset.defaultCharset(), e2);
            }
        }

        public int a(Object obj, Object obj2) throws d.a {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                try {
                    return ((Integer) this.f35069b.invoke(obj, obj2)).intValue();
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
            return invokeLL.intValue;
        }

        public Object b(Context context) throws d.a {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                try {
                    return this.f35070c.invoke(context, new Object[0]);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
            return invokeL.objValue;
        }

        public void c(Object obj, Object obj2, int i2) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, obj, obj2, i2) == null) {
                try {
                    this.a.invoke(obj, obj2, Integer.valueOf(i2), 1);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
        }

        public final void d(Context context) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                Method d2 = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(c.a.q.f.c.b.f()), null);
                this.f35070c = d2;
                Object invoke = d2.invoke(context, new Object[0]);
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), "");
                this.f35071d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(c.a.q.f.c.b.e()), null).invoke(intent, new Object[0]).getClass();
                String c2 = com.baidu.helios.channels.csc.d.c(c.a.q.f.c.b.g());
                Class<?> cls = invoke.getClass();
                Class cls2 = Integer.TYPE;
                this.a = com.baidu.helios.channels.csc.d.d(cls, c2, new Class[]{this.f35071d, cls2, cls2});
                this.f35069b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(c.a.q.f.c.b.d()), new Class[]{this.f35071d});
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f35072d;

        /* renamed from: e  reason: collision with root package name */
        public int f35073e;

        /* renamed from: f  reason: collision with root package name */
        public long f35074f;

        /* renamed from: g  reason: collision with root package name */
        public String f35075g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f35055f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quantumChannel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C0742a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.q.f.a.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f35072d = jSONObject.getString("pkg");
                this.f35073e = jSONObject.getInt("aid_ver");
                this.f35074f = jSONObject.getLong("last_fe_ts");
                this.f35075g = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.q.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f35072d);
                jSONObject.put("aid_ver", this.f35073e);
                jSONObject.put("last_fe_ts", this.f35074f);
                jSONObject.put("id", this.f35075g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35073e : invokeV.intValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f35073e == i2) {
                return;
            }
            this.f35073e = i2;
            a(true);
        }

        public void h(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f35074f == j2) {
                return;
            }
            this.f35074f = j2;
            a(true);
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.f35075g)) {
                return;
            }
            this.f35075g = str;
            a(true);
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35075g : (String) invokeV.objValue;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str.equals(this.f35072d)) {
                return;
            }
            this.f35072d = str;
            a(true);
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35072d : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1912859941, "Lcom/baidu/helios/channels/csc/QuantumChannel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1912859941, "Lcom/baidu/helios/channels/csc/QuantumChannel;");
                return;
            }
        }
        f35053j = c.a.q.f.c.a.a(160);
        f35054k = c.a.q.f.c.a.a(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuantumChannel() {
        super("csc", 9000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35056g = new d(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // c.a.q.f.a
    public a.g b(String str, a.f fVar) {
        InterceptResult invokeLL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            try {
                Object b2 = this.f35057h.b(this.a.a);
                if (b2 == null) {
                    return a.g.c(-101, null);
                }
                if (fVar.a) {
                    gVar = new g(this, str);
                    gVar.d();
                    if (str.equals(gVar.l())) {
                        try {
                            if (gVar.f() == p(b2, str)) {
                                String j2 = gVar.j();
                                if (!TextUtils.isEmpty(j2)) {
                                    return a.g.f(j2);
                                }
                            }
                        } catch (c e2) {
                            return a.g.d(e2);
                        } catch (h unused) {
                            return a.g.b(-102);
                        } catch (d.a unused2) {
                            return a.g.c(-101, null);
                        }
                    }
                } else {
                    gVar = null;
                }
                try {
                    try {
                        if (!m(b2, str)) {
                            a.g c2 = a.g.c(-2, null);
                            if (fVar.a && gVar != null) {
                                gVar.b();
                            }
                            return c2;
                        }
                        String i2 = c.a.q.j.c.a.i(o(b2, str));
                        int p = p(b2, str);
                        if (fVar.a && gVar != null) {
                            gVar.i(i2);
                            gVar.k(str);
                            gVar.h(System.currentTimeMillis());
                            gVar.g(p);
                        }
                        a.g f2 = a.g.f(i2);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return f2;
                    } catch (c e3) {
                        a.g d2 = a.g.d(e3);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return d2;
                    } catch (h unused3) {
                        a.g b3 = a.g.b(-102);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return b3;
                    } catch (d.a unused4) {
                        a.g c3 = a.g.c(-2, null);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return c3;
                    }
                } catch (Throwable th) {
                    if (fVar.a && gVar != null) {
                        gVar.b();
                    }
                    throw th;
                }
            } catch (d.a unused5) {
                return a.g.c(-101, null);
            }
        }
        return (a.g) invokeLL.objValue;
    }

    @Override // c.a.q.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f35055f = this.f11322b.f("csc");
            this.f35057h = new f(this.a.a);
            this.f35058i = new b(null);
        }
    }

    @Override // c.a.q.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            this.f35056g.k();
            try {
                return i(dVar);
            } finally {
                this.f35056g.j();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final int h(Object obj, Object obj2) throws c, d.a {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            try {
                return this.f35057h.a(obj, obj2);
            } catch (d.a e2) {
                throw e2;
            } catch (Throwable th) {
                throw new c(th);
            }
        }
        return invokeLL.intValue;
    }

    public final a.e i(a.d dVar) {
        InterceptResult invokeL;
        Object obj;
        long j2;
        int i2;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, dVar)) != null) {
            return (a.e) invokeL.objValue;
        }
        Context context = this.a.a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f35056g.g();
            this.f35056g.h(packageInfo.lastUpdateTime);
            if (!z && this.f35056g.a(6L) == 4) {
                return a.e.b(-101);
            }
            c.a.q.j.a a2 = this.a.f11326c.a("aid");
            try {
                Object b3 = this.f35057h.b(context);
                if (b3 == null) {
                    return a.e.b(-102);
                }
                try {
                    try {
                        if (this.f35056g.a(1L) == 1 && (b2 = this.f35056g.b()) != null && b2.equals(a2.c()) && m(b3, packageName)) {
                            if (this.f35056g.i() == p(b3, packageName)) {
                                return a.e.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.f35056g.e(a2.c());
                        e c2 = e.c(d2, d2.length * 8);
                        try {
                            try {
                                int f2 = c2.f();
                                for (int i3 = 0; i3 < f2; i3++) {
                                    try {
                                        l(b3, k(packageName, i3), c2.e(i3));
                                    } catch (c unused) {
                                        i2 = -101;
                                        j2 = 4;
                                        this.f35056g.d(j2, 6L);
                                        return a.e.b(i2);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.f35056g.c(nextInt);
                                byte[] bArr = new byte[1];
                                for (int i4 = 0; i4 < 1; i4++) {
                                    bArr[i4] = (byte) ((nextInt >> (i4 * 8)) & 255);
                                }
                                e c3 = e.c(bArr, 8);
                                try {
                                    int f3 = c3.f();
                                    for (int i5 = 0; i5 < f3; i5++) {
                                        l(b3, n(packageName, i5), c3.e(i5));
                                    }
                                    try {
                                        if (p(b3, packageName) != nextInt) {
                                            return a.e.b(-103);
                                        }
                                        try {
                                            l(b3, j(packageName), 1);
                                            this.f35056g.f(System.currentTimeMillis());
                                            this.f35056g.d(1L, 1L);
                                            return a.e.d();
                                        } catch (c unused2) {
                                            this.f35056g.d(4L, 6L);
                                            return a.e.b(-101);
                                        } catch (d.a unused3) {
                                            return a.e.b(-102);
                                        }
                                    } catch (c unused4) {
                                        this.f35056g.d(4L, 6L);
                                        return a.e.b(-101);
                                    } catch (h unused5) {
                                        return a.e.b(-103);
                                    } catch (d.a unused6) {
                                        return a.e.b(-102);
                                    }
                                } catch (c unused7) {
                                    this.f35056g.d(4L, 6L);
                                    return a.e.b(-101);
                                } catch (d.a unused8) {
                                    return a.e.b(-102);
                                }
                            } catch (d.a unused9) {
                                return a.e.b(-102);
                            }
                        } catch (c unused10) {
                            j2 = 4;
                            i2 = -101;
                        }
                    } catch (Exception unused11) {
                        return a.e.b(-103);
                    }
                } catch (c unused12) {
                    this.f35056g.d(4L, 6L);
                    return a.e.b(-101);
                } catch (h unused13) {
                    l(obj, j(packageName), 0);
                    return a.e.b(-103);
                } catch (d.a unused14) {
                    return a.e.b(-102);
                }
            } catch (d.a unused15) {
                return a.e.b(-102);
            }
        } catch (PackageManager.NameNotFoundException unused16) {
            return a.e.b(-100);
        }
    }

    public final Object j(String str) throws c {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return com.baidu.helios.channels.csc.d.e(this.f35057h.f35071d, new Object[]{str, this.f35058i.f35059b});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new c("");
            }
        }
        return invokeL.objValue;
    }

    public final Object k(String str, int i2) throws c {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            try {
                Class<?> cls = this.f35057h.f35071d;
                return com.baidu.helios.channels.csc.d.e(cls, new Object[]{str, this.f35058i.a + i2});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new c("");
            }
        }
        return invokeLI.objValue;
    }

    public final void l(Object obj, Object obj2, int i2) throws c, d.a {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, obj, obj2, i2) == null) {
            try {
                this.f35057h.c(obj, obj2, i2);
            } catch (d.a e2) {
                throw e2;
            } catch (Throwable th) {
                throw new c(th);
            }
        }
    }

    public final boolean m(Object obj, String str) throws c, d.a {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, str)) == null) ? h(obj, j(str)) == 1 : invokeLL.booleanValue;
    }

    public final Object n(String str, int i2) throws c {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) {
            try {
                Class<?> cls = this.f35057h.f35071d;
                return com.baidu.helios.channels.csc.d.e(cls, new Object[]{str, this.f35058i.f35060c + i2});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new c("");
            }
        }
        return invokeLI.objValue;
    }

    public final byte[] o(Object obj, String str) throws c, d.a, h {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, obj, str)) == null) {
            e.a aVar = new e.a();
            for (int i2 = 0; i2 < f35053j; i2++) {
                aVar.a(e.a(h(obj, k(str, i2))));
            }
            return aVar.b().d();
        }
        return (byte[]) invokeLL.objValue;
    }

    public final int p(Object obj, String str) throws c, d.a, h {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, str)) == null) {
            e.a aVar = new e.a();
            for (int i2 = 0; i2 < f35054k; i2++) {
                aVar.a(e.a(h(obj, n(str, i2))));
            }
            byte[] d2 = aVar.b().d();
            int i3 = 0;
            for (int i4 = 0; i4 < d2.length; i4++) {
                i3 |= (d2[i4] & 255) << (i4 * 8);
            }
            return i3;
        }
        return invokeLL.intValue;
    }
}
