package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r.f.a;
import b.a.r.f.c.a;
import b.a.r.h.d.a;
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
/* loaded from: classes7.dex */
public class QuantumChannel extends b.a.r.f.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0774a f39296f;

    /* renamed from: g  reason: collision with root package name */
    public d f39297g;

    /* renamed from: h  reason: collision with root package name */
    public f f39298h;

    /* renamed from: i  reason: collision with root package name */
    public b f39299i;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f39300a;

        /* renamed from: b  reason: collision with root package name */
        public String f39301b;

        /* renamed from: c  reason: collision with root package name */
        public String f39302c;

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
            b.a.r.h.b.b bVar = new b.a.r.h.b.b();
            try {
                this.f39300a = new String(bVar.a(b.a.r.f.c.b.a()), "UTF-8");
                this.f39301b = new String(bVar.a(b.a.r.f.c.b.b()), "UTF-8");
                this.f39302c = new String(bVar.a(b.a.r.f.c.b.c()), "UTF-8");
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f39303a;

        /* renamed from: b  reason: collision with root package name */
        public long f39304b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.r.h.c.a.e f39305c;

        /* renamed from: d  reason: collision with root package name */
        public long f39306d;

        /* renamed from: e  reason: collision with root package name */
        public String f39307e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f39308f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ QuantumChannel f39309g;

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
            this.f39309g = quantumChannel;
            this.f39305c = new b.a.r.h.c.a.e();
            this.f39308f = true;
        }

        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.f39305c.a(j) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39307e : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f39303a == i2) {
                return;
            }
            this.f39303a = i2;
            this.f39308f = true;
        }

        public boolean d(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                if (this.f39305c.c(j, j2)) {
                    this.f39308f = true;
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
                String str2 = this.f39307e;
                if (str2 == str) {
                    return false;
                }
                if (str == null || !str.equals(str2)) {
                    this.f39308f = true;
                    this.f39307e = str;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f39304b == j) {
                return;
            }
            this.f39304b = j;
            this.f39308f = true;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39306d : invokeV.longValue;
        }

        public boolean h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                if (this.f39306d != j) {
                    this.f39306d = j;
                    this.f39308f = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39303a : invokeV.intValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.f39308f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.f39303a);
                        jSONObject.put("pub_lst_ts", this.f39304b);
                        jSONObject.put("pkg_lst_up_ts", this.f39306d);
                        jSONObject.put("flags", this.f39305c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.f39307e);
                        this.f39309g.f39296f.i("pub.dat", jSONObject.toString(), true);
                        this.f39308f = false;
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
                String g2 = this.f39309g.f39296f.g("pub.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f39303a = jSONObject.getInt("pub_ver");
                    this.f39304b = jSONObject.getLong("pub_lst_ts");
                    this.f39306d = jSONObject.getLong("pkg_lst_up_ts");
                    this.f39305c.b(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.f39307e = jSONObject.optString("aid");
                    this.f39308f = false;
                } catch (Exception unused) {
                    this.f39308f = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C0763a f39310a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f39311b;

        /* loaded from: classes7.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public byte[] f39312a;

            /* renamed from: b  reason: collision with root package name */
            public int f39313b;

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
                this.f39312a = new byte[160];
            }

            public a a(byte b2) {
                InterceptResult invokeB;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b2)) == null) {
                    c(this.f39313b + 1);
                    byte[] bArr = this.f39312a;
                    int i2 = this.f39313b;
                    this.f39313b = i2 + 1;
                    bArr[i2] = b2;
                    return this;
                }
                return (a) invokeB.objValue;
            }

            public e b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(Arrays.copyOf(this.f39312a, this.f39313b)) : (e) invokeV.objValue;
            }

            public final void c(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    byte[] bArr = this.f39312a;
                    if (i2 - bArr.length > 0) {
                        int length = bArr.length;
                        int i3 = length + (length >> 1);
                        if (i3 - i2 >= 0) {
                            i2 = i3;
                        }
                        this.f39312a = Arrays.copyOf(this.f39312a, i2);
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
            this.f39311b = bArr;
            this.f39310a = b.a.r.f.c.a.b(bArr);
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
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) ? new e(b.a.r.f.c.a.c(bArr, i2)) : (e) invokeLI.objValue;
        }

        public byte[] d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39310a.a() : (byte[]) invokeV.objValue;
        }

        public int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 >= 0) {
                    byte[] bArr = this.f39311b;
                    if (i2 < bArr.length) {
                        return b(bArr[i2]);
                    }
                }
                throw new IllegalArgumentException("illegal index " + i2 + " with current length is " + this.f39311b.length);
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39311b.length : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Method f39314a;

        /* renamed from: b  reason: collision with root package name */
        public Method f39315b;

        /* renamed from: c  reason: collision with root package name */
        public Method f39316c;

        /* renamed from: d  reason: collision with root package name */
        public Class<?> f39317d;

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
                    return ((Integer) this.f39315b.invoke(obj, obj2)).intValue();
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
                    return this.f39316c.invoke(context, new Object[0]);
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
                    this.f39314a.invoke(obj, obj2, Integer.valueOf(i2), 1);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
        }

        public final void d(Context context) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                Method d2 = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(b.a.r.f.c.b.f()), null);
                this.f39316c = d2;
                Object invoke = d2.invoke(context, new Object[0]);
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), "");
                this.f39317d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(b.a.r.f.c.b.e()), null).invoke(intent, new Object[0]).getClass();
                String c2 = com.baidu.helios.channels.csc.d.c(b.a.r.f.c.b.g());
                Class<?> cls = invoke.getClass();
                Class cls2 = Integer.TYPE;
                this.f39314a = com.baidu.helios.channels.csc.d.d(cls, c2, new Class[]{this.f39317d, cls2, cls2});
                this.f39315b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(b.a.r.f.c.b.d()), new Class[]{this.f39317d});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f39318d;

        /* renamed from: e  reason: collision with root package name */
        public int f39319e;

        /* renamed from: f  reason: collision with root package name */
        public long f39320f;

        /* renamed from: g  reason: collision with root package name */
        public String f39321g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f39296f, str);
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
                    super((a.C0774a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.a.r.f.a.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f39318d = jSONObject.getString("pkg");
                this.f39319e = jSONObject.getInt("aid_ver");
                this.f39320f = jSONObject.getLong("last_fe_ts");
                this.f39321g = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // b.a.r.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f39318d);
                jSONObject.put("aid_ver", this.f39319e);
                jSONObject.put("last_fe_ts", this.f39320f);
                jSONObject.put("id", this.f39321g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39319e : invokeV.intValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f39319e == i2) {
                return;
            }
            this.f39319e = i2;
            a(true);
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f39320f == j) {
                return;
            }
            this.f39320f = j;
            a(true);
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.f39321g)) {
                return;
            }
            this.f39321g = str;
            a(true);
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39321g : (String) invokeV.objValue;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str.equals(this.f39318d)) {
                return;
            }
            this.f39318d = str;
            a(true);
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39318d : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
        j = b.a.r.f.c.a.a(160);
        k = b.a.r.f.c.a.a(8);
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
        this.f39297g = new d(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // b.a.r.f.a
    public a.g b(String str, a.f fVar) {
        InterceptResult invokeLL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            try {
                Object b2 = this.f39298h.b(this.f15168a.f15172a);
                if (b2 == null) {
                    return a.g.c(-101, null);
                }
                if (fVar.f15178a) {
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
                            if (fVar.f15178a && gVar != null) {
                                gVar.b();
                            }
                            return c2;
                        }
                        String i2 = b.a.r.j.c.a.i(o(b2, str));
                        int p = p(b2, str);
                        if (fVar.f15178a && gVar != null) {
                            gVar.i(i2);
                            gVar.k(str);
                            gVar.h(System.currentTimeMillis());
                            gVar.g(p);
                        }
                        a.g f2 = a.g.f(i2);
                        if (fVar.f15178a && gVar != null) {
                            gVar.b();
                        }
                        return f2;
                    } catch (c e3) {
                        a.g d2 = a.g.d(e3);
                        if (fVar.f15178a && gVar != null) {
                            gVar.b();
                        }
                        return d2;
                    } catch (h unused3) {
                        a.g b3 = a.g.b(-102);
                        if (fVar.f15178a && gVar != null) {
                            gVar.b();
                        }
                        return b3;
                    } catch (d.a unused4) {
                        a.g c3 = a.g.c(-2, null);
                        if (fVar.f15178a && gVar != null) {
                            gVar.b();
                        }
                        return c3;
                    }
                } catch (Throwable th) {
                    if (fVar.f15178a && gVar != null) {
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

    @Override // b.a.r.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f39296f = this.f15169b.f("csc");
            this.f39298h = new f(this.f15168a.f15172a);
            this.f39299i = new b(null);
        }
    }

    @Override // b.a.r.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            this.f39297g.k();
            try {
                return i(dVar);
            } finally {
                this.f39297g.j();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final int h(Object obj, Object obj2) throws c, d.a {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            try {
                return this.f39298h.a(obj, obj2);
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
        Context context = this.f15168a.f15172a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f39297g.g();
            this.f39297g.h(packageInfo.lastUpdateTime);
            if (!z && this.f39297g.a(6L) == 4) {
                return a.e.b(-101);
            }
            b.a.r.j.a a2 = this.f15168a.f15174c.a("aid");
            try {
                Object b3 = this.f39298h.b(context);
                if (b3 == null) {
                    return a.e.b(-102);
                }
                try {
                    try {
                        if (this.f39297g.a(1L) == 1 && (b2 = this.f39297g.b()) != null && b2.equals(a2.c()) && m(b3, packageName)) {
                            if (this.f39297g.i() == p(b3, packageName)) {
                                return a.e.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.f39297g.e(a2.c());
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
                                        this.f39297g.d(j2, 6L);
                                        return a.e.b(i2);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.f39297g.c(nextInt);
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
                                            this.f39297g.f(System.currentTimeMillis());
                                            this.f39297g.d(1L, 1L);
                                            return a.e.d();
                                        } catch (c unused2) {
                                            this.f39297g.d(4L, 6L);
                                            return a.e.b(-101);
                                        } catch (d.a unused3) {
                                            return a.e.b(-102);
                                        }
                                    } catch (c unused4) {
                                        this.f39297g.d(4L, 6L);
                                        return a.e.b(-101);
                                    } catch (h unused5) {
                                        return a.e.b(-103);
                                    } catch (d.a unused6) {
                                        return a.e.b(-102);
                                    }
                                } catch (c unused7) {
                                    this.f39297g.d(4L, 6L);
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
                    this.f39297g.d(4L, 6L);
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
                return com.baidu.helios.channels.csc.d.e(this.f39298h.f39317d, new Object[]{str, this.f39299i.f39301b});
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
                Class<?> cls = this.f39298h.f39317d;
                return com.baidu.helios.channels.csc.d.e(cls, new Object[]{str, this.f39299i.f39300a + i2});
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
                this.f39298h.c(obj, obj2, i2);
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
                Class<?> cls = this.f39298h.f39317d;
                return com.baidu.helios.channels.csc.d.e(cls, new Object[]{str, this.f39299i.f39302c + i2});
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
            for (int i2 = 0; i2 < j; i2++) {
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
            for (int i2 = 0; i2 < k; i2++) {
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
