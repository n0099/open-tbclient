package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r.e.a;
import c.a.r.e.c.a;
import c.a.r.g.d.a;
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
import java.util.Arrays;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class QuantumChannel extends c.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int f40283j;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C1372a f40284f;

    /* renamed from: g  reason: collision with root package name */
    public d f40285g;

    /* renamed from: h  reason: collision with root package name */
    public f f40286h;

    /* renamed from: i  reason: collision with root package name */
    public c f40287i;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
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
        public b(String str, Throwable th) {
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
        public b(Throwable th) {
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

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f40288a;

        /* renamed from: b  reason: collision with root package name */
        public String f40289b;

        /* renamed from: c  reason: collision with root package name */
        public String f40290c;

        public c() {
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
            c.a.r.g.b.b bVar = new c.a.r.g.b.b();
            try {
                this.f40288a = new String(bVar.a(c.a.r.e.c.b.e()));
                this.f40289b = new String(bVar.a(c.a.r.e.c.b.f()));
                this.f40290c = new String(bVar.a(c.a.r.e.c.b.g()));
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40291a;

        /* renamed from: b  reason: collision with root package name */
        public long f40292b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f40293c;

        /* renamed from: d  reason: collision with root package name */
        public long f40294d;

        /* renamed from: e  reason: collision with root package name */
        public String f40295e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40296f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ QuantumChannel f40297g;

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
            this.f40297g = quantumChannel;
            this.f40293c = new c.a.r.g.c.a.e();
            this.f40296f = true;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40291a : invokeV.intValue;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f40291a == i2) {
                return;
            }
            this.f40291a = i2;
            this.f40296f = true;
        }

        public void c(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || this.f40292b == j2) {
                return;
            }
            this.f40292b = j2;
            this.f40296f = true;
        }

        public boolean d(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                if (this.f40293c.c(j2, j3)) {
                    this.f40296f = true;
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
                String str2 = this.f40295e;
                if (str2 == str) {
                    return false;
                }
                if (str == null || !str.equals(str2)) {
                    this.f40296f = true;
                    this.f40295e = str;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public long f(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.f40293c.a(j2) : invokeJ.longValue;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40294d : invokeV.longValue;
        }

        public boolean h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.f40294d != j2) {
                    this.f40294d = j2;
                    this.f40296f = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40295e : (String) invokeV.objValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                String g2 = this.f40297g.f40284f.g("pub.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f40291a = jSONObject.getInt("pub_ver");
                    this.f40292b = jSONObject.getLong("pub_lst_ts");
                    this.f40294d = jSONObject.getLong("pkg_lst_up_ts");
                    this.f40293c.b(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.f40295e = jSONObject.optString("aid");
                    this.f40296f = false;
                } catch (Exception unused) {
                    this.f40296f = true;
                }
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.f40296f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.f40291a);
                        jSONObject.put("pub_lst_ts", this.f40292b);
                        jSONObject.put("pkg_lst_up_ts", this.f40294d);
                        jSONObject.put("flags", this.f40293c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.f40295e);
                        this.f40297g.f40284f.i("pub.dat", jSONObject.toString(), true);
                        this.f40296f = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C1366a f40298a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f40299b;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f40300a;

            /* renamed from: b  reason: collision with root package name */
            public byte[] f40301b;

            /* renamed from: c  reason: collision with root package name */
            public int f40302c;

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
                this.f40300a = 160;
                this.f40301b = new byte[160];
            }

            public a a(byte b2) {
                InterceptResult invokeB;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b2)) == null) {
                    c(this.f40302c + 1);
                    byte[] bArr = this.f40301b;
                    int i2 = this.f40302c;
                    this.f40302c = i2 + 1;
                    bArr[i2] = b2;
                    return this;
                }
                return (a) invokeB.objValue;
            }

            public e b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(Arrays.copyOf(this.f40301b, this.f40302c)) : (e) invokeV.objValue;
            }

            public final void c(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    byte[] bArr = this.f40301b;
                    if (i2 - bArr.length > 0) {
                        int length = bArr.length;
                        int i3 = length + (length >> 1);
                        if (i3 - i2 >= 0) {
                            i2 = i3;
                        }
                        this.f40301b = Arrays.copyOf(this.f40301b, i2);
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
            this.f40299b = bArr;
            this.f40298a = c.a.r.e.c.a.b(bArr);
        }

        public static int b(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(65537, null, b2)) == null) {
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

        public static e d(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) ? new e(c.a.r.e.c.a.c(bArr, i2)) : (e) invokeLI.objValue;
        }

        public static byte e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            return (byte) 2;
                        }
                        throw new g("unexpected value " + i2);
                    }
                    return (byte) 1;
                }
                return (byte) 0;
            }
            return invokeI.byteValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40299b.length : invokeV.intValue;
        }

        public int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 >= 0) {
                    byte[] bArr = this.f40299b;
                    if (i2 < bArr.length) {
                        return b(bArr[i2]);
                    }
                }
                throw new IllegalArgumentException("illegal index " + i2 + " with current length is " + this.f40299b.length);
            }
            return invokeI.intValue;
        }

        public byte[] f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40298a.a() : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Method f40303a;

        /* renamed from: b  reason: collision with root package name */
        public Method f40304b;

        /* renamed from: c  reason: collision with root package name */
        public Method f40305c;

        /* renamed from: d  reason: collision with root package name */
        public Class<?> f40306d;

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
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public int a(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                try {
                    return ((Integer) this.f40304b.invoke(obj, obj2)).intValue();
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
            return invokeLL.intValue;
        }

        public Object b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                try {
                    return this.f40305c.invoke(context, new Object[0]);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
            return invokeL.objValue;
        }

        public void c(Object obj, Object obj2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, obj, obj2, i2) == null) {
                try {
                    this.f40303a.invoke(obj, obj2, Integer.valueOf(i2), 1);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
        }

        public final void d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                Method d2 = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(c.a.r.e.c.b.c()), null);
                this.f40305c = d2;
                Object invoke = d2.invoke(context, new Object[0]);
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), "");
                this.f40306d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(c.a.r.e.c.b.d()), null).invoke(intent, new Object[0]).getClass();
                String c2 = com.baidu.helios.channels.csc.d.c(c.a.r.e.c.b.a());
                Class<?> cls = invoke.getClass();
                Class cls2 = Integer.TYPE;
                this.f40303a = com.baidu.helios.channels.csc.d.d(cls, c2, new Class[]{this.f40306d, cls2, cls2});
                this.f40304b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(c.a.r.e.c.b.b()), new Class[]{this.f40306d});
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
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
        public g(String str, Throwable th) {
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

    /* loaded from: classes5.dex */
    public class h extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f40307d;

        /* renamed from: e  reason: collision with root package name */
        public int f40308e;

        /* renamed from: f  reason: collision with root package name */
        public long f40309f;

        /* renamed from: g  reason: collision with root package name */
        public String f40310g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f40284f, str);
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
                    super((a.C1372a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.r.e.a.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f40307d = jSONObject.getString("pkg");
                this.f40308e = jSONObject.getInt("aid_ver");
                this.f40309f = jSONObject.getLong("last_fe_ts");
                this.f40310g = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.r.e.a.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f40307d);
                jSONObject.put("aid_ver", this.f40308e);
                jSONObject.put("last_fe_ts", this.f40309f);
                jSONObject.put("id", this.f40310g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40307d : (String) invokeV.objValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f40308e == i2) {
                return;
            }
            this.f40308e = i2;
            a(true);
        }

        public void h(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f40309f == j2) {
                return;
            }
            this.f40309f = j2;
            a(true);
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.f40307d)) {
                return;
            }
            this.f40307d = str;
            a(true);
        }

        public int j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40308e : invokeV.intValue;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str.equals(this.f40310g)) {
                return;
            }
            this.f40310g = str;
            a(true);
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40310g : (String) invokeV.objValue;
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
        f40283j = c.a.r.e.c.a.a(160);
        k = c.a.r.e.c.a.a(8);
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
        this.f40285g = new d(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // c.a.r.e.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            try {
                Object b2 = this.f40286h.b(this.f29174a.f29178a);
                if (b2 == null) {
                    return a.h.b(-101, null);
                }
                if (gVar.f29184a) {
                    hVar = new h(this, str);
                    hVar.d();
                    if (str.equals(hVar.f())) {
                        try {
                            if (hVar.j() == i(b2, str)) {
                                String l = hVar.l();
                                if (!TextUtils.isEmpty(l)) {
                                    return a.h.e(l);
                                }
                            }
                        } catch (b e2) {
                            return a.h.c(e2);
                        } catch (g unused) {
                            return a.h.a(-102);
                        } catch (d.a unused2) {
                            return a.h.b(-101, null);
                        }
                    }
                } else {
                    hVar = null;
                }
                try {
                    try {
                        if (!p(b2, str)) {
                            a.h b3 = a.h.b(-2, null);
                            if (gVar.f29184a && hVar != null) {
                                hVar.b();
                            }
                            return b3;
                        }
                        String i2 = c.a.r.h.c.a.i(o(b2, str));
                        int i3 = i(b2, str);
                        if (gVar.f29184a && hVar != null) {
                            hVar.k(i2);
                            hVar.i(str);
                            hVar.h(System.currentTimeMillis());
                            hVar.g(i3);
                        }
                        a.h e3 = a.h.e(i2);
                        if (gVar.f29184a && hVar != null) {
                            hVar.b();
                        }
                        return e3;
                    } catch (b e4) {
                        a.h c2 = a.h.c(e4);
                        if (gVar.f29184a && hVar != null) {
                            hVar.b();
                        }
                        return c2;
                    } catch (g unused3) {
                        a.h a2 = a.h.a(-102);
                        if (gVar.f29184a && hVar != null) {
                            hVar.b();
                        }
                        return a2;
                    } catch (d.a unused4) {
                        a.h b4 = a.h.b(-2, null);
                        if (gVar.f29184a && hVar != null) {
                            hVar.b();
                        }
                        return b4;
                    }
                } catch (Throwable th) {
                    if (gVar.f29184a && hVar != null) {
                        hVar.b();
                    }
                    throw th;
                }
            } catch (d.a unused5) {
                return a.h.b(-101, null);
            }
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.r.e.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f40284f = this.f29175b.f("csc");
            this.f40286h = new f(this.f29174a.f29178a);
            this.f40287i = new c(null);
        }
    }

    @Override // c.a.r.e.a
    public a.f f(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.f40285g.j();
            try {
                return j(eVar);
            } finally {
                this.f40285g.k();
            }
        }
        return (a.f) invokeL.objValue;
    }

    public final int h(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            try {
                return this.f40286h.a(obj, obj2);
            } catch (d.a e2) {
                throw e2;
            } catch (Throwable th) {
                throw new b(th);
            }
        }
        return invokeLL.intValue;
    }

    public final int i(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, obj, str)) == null) {
            e.a aVar = new e.a();
            for (int i2 = 0; i2 < k; i2++) {
                aVar.a(e.e(h(obj, n(str, i2))));
            }
            byte[] f2 = aVar.b().f();
            int i3 = 0;
            for (int i4 = 0; i4 < f2.length; i4++) {
                i3 |= (f2[i4] & 255) << (i4 * 8);
            }
            return i3;
        }
        return invokeLL.intValue;
    }

    public final a.f j(a.e eVar) {
        InterceptResult invokeL;
        Object obj;
        long j2;
        int i2;
        String i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, eVar)) != null) {
            return (a.f) invokeL.objValue;
        }
        Context context = this.f29174a.f29178a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f40285g.g();
            this.f40285g.h(packageInfo.lastUpdateTime);
            if (!z && this.f40285g.f(6L) == 4) {
                return a.f.b(-101);
            }
            c.a.r.h.a a2 = this.f29174a.f29180c.a("aid");
            try {
                Object b2 = this.f40286h.b(context);
                if (b2 == null) {
                    return a.f.b(-102);
                }
                try {
                    try {
                        if (this.f40285g.f(1L) == 1 && (i3 = this.f40285g.i()) != null && i3.equals(a2.c()) && p(b2, packageName)) {
                            if (this.f40285g.a() == i(b2, packageName)) {
                                return a.f.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.f40285g.e(a2.c());
                        e d3 = e.d(d2, d2.length * 8);
                        try {
                            try {
                                int a3 = d3.a();
                                for (int i4 = 0; i4 < a3; i4++) {
                                    try {
                                        m(b2, l(packageName, i4), d3.c(i4));
                                    } catch (b unused) {
                                        i2 = -101;
                                        j2 = 4;
                                        this.f40285g.d(j2, 6L);
                                        return a.f.b(i2);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.f40285g.b(nextInt);
                                byte[] bArr = new byte[1];
                                for (int i5 = 0; i5 < 1; i5++) {
                                    bArr[i5] = (byte) ((nextInt >> (i5 * 8)) & 255);
                                }
                                e d4 = e.d(bArr, 8);
                                try {
                                    int a4 = d4.a();
                                    for (int i6 = 0; i6 < a4; i6++) {
                                        m(b2, n(packageName, i6), d4.c(i6));
                                    }
                                    try {
                                        if (i(b2, packageName) != nextInt) {
                                            return a.f.b(-103);
                                        }
                                        try {
                                            m(b2, k(packageName), 1);
                                            this.f40285g.c(System.currentTimeMillis());
                                            this.f40285g.d(1L, 1L);
                                            return a.f.d();
                                        } catch (b unused2) {
                                            this.f40285g.d(4L, 6L);
                                            return a.f.b(-101);
                                        } catch (d.a unused3) {
                                            return a.f.b(-102);
                                        }
                                    } catch (b unused4) {
                                        this.f40285g.d(4L, 6L);
                                        return a.f.b(-101);
                                    } catch (g unused5) {
                                        return a.f.b(-103);
                                    } catch (d.a unused6) {
                                        return a.f.b(-102);
                                    }
                                } catch (b unused7) {
                                    this.f40285g.d(4L, 6L);
                                    return a.f.b(-101);
                                } catch (d.a unused8) {
                                    return a.f.b(-102);
                                }
                            } catch (d.a unused9) {
                                return a.f.b(-102);
                            }
                        } catch (b unused10) {
                            j2 = 4;
                            i2 = -101;
                        }
                    } catch (Exception unused11) {
                        return a.f.b(-103);
                    }
                } catch (b unused12) {
                    this.f40285g.d(4L, 6L);
                    return a.f.b(-101);
                } catch (g unused13) {
                    m(obj, k(packageName), 0);
                    return a.f.b(-103);
                } catch (d.a unused14) {
                    return a.f.b(-102);
                }
            } catch (d.a unused15) {
                return a.f.b(-102);
            }
        } catch (PackageManager.NameNotFoundException unused16) {
            return a.f.b(-100);
        }
    }

    public final Object k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return com.baidu.helios.channels.csc.d.b(this.f40286h.f40306d, new Object[]{str, this.f40287i.f40289b});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new b("");
            }
        }
        return invokeL.objValue;
    }

    public final Object l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            try {
                Class<?> cls = this.f40286h.f40306d;
                return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.f40287i.f40288a + i2});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new b("");
            }
        }
        return invokeLI.objValue;
    }

    public final void m(Object obj, Object obj2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, obj2, i2) == null) {
            try {
                this.f40286h.c(obj, obj2, i2);
            } catch (d.a e2) {
                throw e2;
            } catch (Throwable th) {
                throw new b(th);
            }
        }
    }

    public final Object n(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) {
            try {
                Class<?> cls = this.f40286h.f40306d;
                return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.f40287i.f40290c + i2});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new b("");
            }
        }
        return invokeLI.objValue;
    }

    public final byte[] o(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, obj, str)) == null) {
            e.a aVar = new e.a();
            for (int i2 = 0; i2 < f40283j; i2++) {
                aVar.a(e.e(h(obj, l(str, i2))));
            }
            return aVar.b().f();
        }
        return (byte[]) invokeLL.objValue;
    }

    public final boolean p(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, str)) == null) ? h(obj, k(str)) == 1 : invokeLL.booleanValue;
    }
}
