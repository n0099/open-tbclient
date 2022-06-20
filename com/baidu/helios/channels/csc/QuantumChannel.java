package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.channels.csc.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b40;
import com.repackage.e40;
import com.repackage.g40;
import com.repackage.j30;
import com.repackage.v10;
import com.repackage.x10;
import com.repackage.y10;
import com.repackage.y30;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QuantumChannel extends v10 {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;
    public b40.a f;
    public d g;
    public f h;
    public b i;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            j30 j30Var = new j30();
            try {
                this.a = new String(j30Var.a(y10.a()), "UTF-8");
                this.b = new String(j30Var.a(y10.b()), "UTF-8");
                this.c = new String(j30Var.a(y10.c()), "UTF-8");
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public y30 c;
        public long d;
        public String e;
        public boolean f;
        public final /* synthetic */ QuantumChannel g;

        public d(QuantumChannel quantumChannel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quantumChannel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = quantumChannel;
            this.c = new y30();
            this.f = true;
        }

        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.c.a(j) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == i) {
                return;
            }
            this.a = i;
            this.f = true;
        }

        public boolean d(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                if (this.c.c(j, j2)) {
                    this.f = true;
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
                String str2 = this.e;
                if (str2 == str) {
                    return false;
                }
                if (str == null || !str.equals(str2)) {
                    this.f = true;
                    this.e = str;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.b == j) {
                return;
            }
            this.b = j;
            this.f = true;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : invokeV.longValue;
        }

        public boolean h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                if (this.d != j) {
                    this.d = j;
                    this.f = true;
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
                if (this.f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.a);
                        jSONObject.put("pub_lst_ts", this.b);
                        jSONObject.put("pkg_lst_up_ts", this.d);
                        jSONObject.put("flags", this.c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.e);
                        this.g.f.i("pub.dat", jSONObject.toString(), true);
                        this.f = false;
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
                String g = this.g.f.g("pub.dat", true);
                if (TextUtils.isEmpty(g)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g);
                    this.a = jSONObject.getInt("pub_ver");
                    this.b = jSONObject.getLong("pub_lst_ts");
                    this.d = jSONObject.getLong("pkg_lst_up_ts");
                    this.c.b(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.e = jSONObject.optString("aid");
                    this.f = false;
                } catch (Exception unused) {
                    this.f = true;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public x10.a a;
        public byte[] b;

        /* loaded from: classes2.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public byte[] a;
            public int b;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = new byte[160];
            }

            public a a(byte b) {
                InterceptResult invokeB;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b)) == null) {
                    c(this.b + 1);
                    byte[] bArr = this.a;
                    int i = this.b;
                    this.b = i + 1;
                    bArr[i] = b;
                    return this;
                }
                return (a) invokeB.objValue;
            }

            public e b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(Arrays.copyOf(this.a, this.b)) : (e) invokeV.objValue;
            }

            public final void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    byte[] bArr = this.a;
                    if (i - bArr.length > 0) {
                        int length = bArr.length;
                        int i2 = length + (length >> 1);
                        if (i2 - i >= 0) {
                            i = i2;
                        }
                        this.a = Arrays.copyOf(this.a, i);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bArr;
            this.a = x10.b(bArr);
        }

        public static byte a(int i) throws h {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            return (byte) 2;
                        }
                        throw new h("unexpected value " + i);
                    }
                    return (byte) 1;
                }
                return (byte) 0;
            }
            return invokeI.byteValue;
        }

        public static int b(byte b) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b)) == null) {
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
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

        public static e c(byte[] bArr, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) ? new e(x10.c(bArr, i)) : (e) invokeLI.objValue;
        }

        public byte[] d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a() : (byte[]) invokeV.objValue;
        }

        public int e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i >= 0) {
                    byte[] bArr = this.b;
                    if (i < bArr.length) {
                        return b(bArr[i]);
                    }
                }
                throw new IllegalArgumentException("illegal index " + i + " with current length is " + this.b.length);
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.length : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;
        public Method b;
        public Method c;
        public Class<?> d;

        public f(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                d(context);
            } catch (Exception e) {
                throw new IllegalStateException("charset = " + Charset.defaultCharset(), e);
            }
        }

        public int a(Object obj, Object obj2) throws d.a {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                try {
                    return ((Integer) this.b.invoke(obj, obj2)).intValue();
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
                    return this.c.invoke(context, new Object[0]);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
            return invokeL.objValue;
        }

        public void c(Object obj, Object obj2, int i) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, obj, obj2, i) == null) {
                try {
                    this.a.invoke(obj, obj2, Integer.valueOf(i), 1);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
        }

        public final void d(Context context) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                Method d = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(y10.f()), null);
                this.c = d;
                Object invoke = d.invoke(context, new Object[0]);
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), "");
                this.d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(y10.e()), null).invoke(intent, new Object[0]).getClass();
                String c = com.baidu.helios.channels.csc.d.c(y10.g());
                Class<?> cls = invoke.getClass();
                Class cls2 = Integer.TYPE;
                this.a = com.baidu.helios.channels.csc.d.d(cls, c, new Class[]{this.d, cls2, cls2});
                this.b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(y10.d()), new Class[]{this.d});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends v10.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;
        public int e;
        public long f;
        public String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quantumChannel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((b40.a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.v10.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.d = jSONObject.getString("pkg");
                this.e = jSONObject.getInt("aid_ver");
                this.f = jSONObject.getLong("last_fe_ts");
                this.g = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // com.repackage.v10.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.d);
                jSONObject.put("aid_ver", this.e);
                jSONObject.put("last_fe_ts", this.f);
                jSONObject.put("id", this.g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.intValue;
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.e == i) {
                return;
            }
            this.e = i;
            a(true);
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f == j) {
                return;
            }
            this.f = j;
            a(true);
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.g)) {
                return;
            }
            this.g = str;
            a(true);
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : (String) invokeV.objValue;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str.equals(this.d)) {
                return;
            }
            this.d = str;
            a(true);
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        j = x10.a(160);
        k = x10.a(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuantumChannel() {
        super("csc", 9000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new d(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // com.repackage.v10
    public v10.g b(String str, v10.f fVar) {
        InterceptResult invokeLL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            try {
                Object b2 = this.h.b(this.a.a);
                if (b2 == null) {
                    return v10.g.c(-101, null);
                }
                if (fVar.a) {
                    gVar = new g(this, str);
                    gVar.d();
                    if (str.equals(gVar.l())) {
                        try {
                            if (gVar.f() == p(b2, str)) {
                                String j2 = gVar.j();
                                if (!TextUtils.isEmpty(j2)) {
                                    return v10.g.f(j2);
                                }
                            }
                        } catch (c e2) {
                            return v10.g.d(e2);
                        } catch (h unused) {
                            return v10.g.b(-102);
                        } catch (d.a unused2) {
                            return v10.g.c(-101, null);
                        }
                    }
                } else {
                    gVar = null;
                }
                try {
                    try {
                        if (!m(b2, str)) {
                            v10.g c2 = v10.g.c(-2, null);
                            if (fVar.a && gVar != null) {
                                gVar.b();
                            }
                            return c2;
                        }
                        String i = g40.i(o(b2, str));
                        int p = p(b2, str);
                        if (fVar.a && gVar != null) {
                            gVar.i(i);
                            gVar.k(str);
                            gVar.h(System.currentTimeMillis());
                            gVar.g(p);
                        }
                        v10.g f2 = v10.g.f(i);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return f2;
                    } catch (c e3) {
                        v10.g d2 = v10.g.d(e3);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return d2;
                    } catch (h unused3) {
                        v10.g b3 = v10.g.b(-102);
                        if (fVar.a && gVar != null) {
                            gVar.b();
                        }
                        return b3;
                    } catch (d.a unused4) {
                        v10.g c3 = v10.g.c(-2, null);
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
                return v10.g.c(-101, null);
            }
        }
        return (v10.g) invokeLL.objValue;
    }

    @Override // com.repackage.v10
    public void e(v10.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f = this.b.f("csc");
            this.h = new f(this.a.a);
            this.i = new b(null);
        }
    }

    @Override // com.repackage.v10
    public v10.e f(v10.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            this.g.k();
            try {
                return i(dVar);
            } finally {
                this.g.j();
            }
        }
        return (v10.e) invokeL.objValue;
    }

    public final int h(Object obj, Object obj2) throws c, d.a {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            try {
                return this.h.a(obj, obj2);
            } catch (d.a e2) {
                throw e2;
            } catch (Throwable th) {
                throw new c(th);
            }
        }
        return invokeLL.intValue;
    }

    public final v10.e i(v10.d dVar) {
        InterceptResult invokeL;
        Object obj;
        long j2;
        int i;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, dVar)) != null) {
            return (v10.e) invokeL.objValue;
        }
        Context context = this.a.a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.g.g();
            this.g.h(packageInfo.lastUpdateTime);
            if (!z && this.g.a(6L) == 4) {
                return v10.e.b(-101);
            }
            e40 a2 = this.a.c.a("aid");
            try {
                Object b3 = this.h.b(context);
                if (b3 == null) {
                    return v10.e.b(-102);
                }
                try {
                    try {
                        if (this.g.a(1L) == 1 && (b2 = this.g.b()) != null && b2.equals(a2.c()) && m(b3, packageName)) {
                            if (this.g.i() == p(b3, packageName)) {
                                return v10.e.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.g.e(a2.c());
                        e c2 = e.c(d2, d2.length * 8);
                        try {
                            try {
                                int f2 = c2.f();
                                for (int i2 = 0; i2 < f2; i2++) {
                                    try {
                                        l(b3, k(packageName, i2), c2.e(i2));
                                    } catch (c unused) {
                                        i = -101;
                                        j2 = 4;
                                        this.g.d(j2, 6L);
                                        return v10.e.b(i);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.g.c(nextInt);
                                byte[] bArr = new byte[1];
                                for (int i3 = 0; i3 < 1; i3++) {
                                    bArr[i3] = (byte) ((nextInt >> (i3 * 8)) & 255);
                                }
                                e c3 = e.c(bArr, 8);
                                try {
                                    int f3 = c3.f();
                                    for (int i4 = 0; i4 < f3; i4++) {
                                        l(b3, n(packageName, i4), c3.e(i4));
                                    }
                                    try {
                                        if (p(b3, packageName) != nextInt) {
                                            return v10.e.b(-103);
                                        }
                                        try {
                                            l(b3, j(packageName), 1);
                                            this.g.f(System.currentTimeMillis());
                                            this.g.d(1L, 1L);
                                            return v10.e.d();
                                        } catch (c unused2) {
                                            this.g.d(4L, 6L);
                                            return v10.e.b(-101);
                                        } catch (d.a unused3) {
                                            return v10.e.b(-102);
                                        }
                                    } catch (c unused4) {
                                        this.g.d(4L, 6L);
                                        return v10.e.b(-101);
                                    } catch (h unused5) {
                                        return v10.e.b(-103);
                                    } catch (d.a unused6) {
                                        return v10.e.b(-102);
                                    }
                                } catch (c unused7) {
                                    this.g.d(4L, 6L);
                                    return v10.e.b(-101);
                                } catch (d.a unused8) {
                                    return v10.e.b(-102);
                                }
                            } catch (d.a unused9) {
                                return v10.e.b(-102);
                            }
                        } catch (c unused10) {
                            j2 = 4;
                            i = -101;
                        }
                    } catch (Exception unused11) {
                        return v10.e.b(-103);
                    }
                } catch (c unused12) {
                    this.g.d(4L, 6L);
                    return v10.e.b(-101);
                } catch (h unused13) {
                    l(obj, j(packageName), 0);
                    return v10.e.b(-103);
                } catch (d.a unused14) {
                    return v10.e.b(-102);
                }
            } catch (d.a unused15) {
                return v10.e.b(-102);
            }
        } catch (PackageManager.NameNotFoundException unused16) {
            return v10.e.b(-100);
        }
    }

    public final Object j(String str) throws c {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return com.baidu.helios.channels.csc.d.e(this.h.d, new Object[]{str, this.i.b});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new c("");
            }
        }
        return invokeL.objValue;
    }

    public final Object k(String str, int i) throws c {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            try {
                Class<?> cls = this.h.d;
                return com.baidu.helios.channels.csc.d.e(cls, new Object[]{str, this.i.a + i});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new c("");
            }
        }
        return invokeLI.objValue;
    }

    public final void l(Object obj, Object obj2, int i) throws c, d.a {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, obj, obj2, i) == null) {
            try {
                this.h.c(obj, obj2, i);
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

    public final Object n(String str, int i) throws c {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            try {
                Class<?> cls = this.h.d;
                return com.baidu.helios.channels.csc.d.e(cls, new Object[]{str, this.i.c + i});
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
            for (int i = 0; i < j; i++) {
                aVar.a(e.a(h(obj, k(str, i))));
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
            for (int i = 0; i < k; i++) {
                aVar.a(e.a(h(obj, n(str, i))));
            }
            byte[] d2 = aVar.b().d();
            int i2 = 0;
            for (int i3 = 0; i3 < d2.length; i3++) {
                i2 |= (d2[i3] & 255) << (i3 * 8);
            }
            return i2;
        }
        return invokeLL.intValue;
    }
}
