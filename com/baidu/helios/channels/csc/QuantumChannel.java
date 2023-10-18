package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.channels.csc.d;
import com.baidu.tieba.b00;
import com.baidu.tieba.e00;
import com.baidu.tieba.g00;
import com.baidu.tieba.jz;
import com.baidu.tieba.ux;
import com.baidu.tieba.wx;
import com.baidu.tieba.xx;
import com.baidu.tieba.yz;
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
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QuantumChannel extends ux {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;
    public b00.a f;
    public d g;
    public f h;
    public c i;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
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
        public b(String str, Throwable th) {
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
        public b(Throwable th) {
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

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public c() {
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
            jz jzVar = new jz();
            try {
                this.a = new String(jzVar.a(xx.e()), "UTF-8");
                this.b = new String(jzVar.a(xx.f()), "UTF-8");
                this.c = new String(jzVar.a(xx.g()), "UTF-8");
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public yz c;
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
            this.c = new yz();
            this.f = true;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == i) {
                return;
            }
            this.a = i;
            this.f = true;
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.b == j) {
                return;
            }
            this.b = j;
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

        public long f(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.c.a(j) : invokeJ.longValue;
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

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wx.a a;
        public byte[] b;

        /* loaded from: classes3.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public byte[] b;
            public int c;

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
                this.a = 160;
                this.b = new byte[160];
            }

            public a a(byte b) {
                InterceptResult invokeB;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b)) == null) {
                    c(this.c + 1);
                    byte[] bArr = this.b;
                    int i = this.c;
                    this.c = i + 1;
                    bArr[i] = b;
                    return this;
                }
                return (a) invokeB.objValue;
            }

            public e b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(Arrays.copyOf(this.b, this.c)) : (e) invokeV.objValue;
            }

            public final void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    byte[] bArr = this.b;
                    if (i - bArr.length > 0) {
                        int length = bArr.length;
                        int i2 = length + (length >> 1);
                        if (i2 - i >= 0) {
                            i = i2;
                        }
                        this.b = Arrays.copyOf(this.b, i);
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
            this.a = wx.b(bArr);
        }

        public static int b(byte b) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(65537, null, b)) == null) {
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

        public static e d(byte[] bArr, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) ? new e(wx.c(bArr, i)) : (e) invokeLI.objValue;
        }

        public static byte e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            return (byte) 2;
                        }
                        throw new g("unexpected value " + i);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.length : invokeV.intValue;
        }

        public int c(int i) {
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

        public byte[] f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.a() : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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

        public int a(Object obj, Object obj2) {
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

        public Object b(Context context) {
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

        public void c(Object obj, Object obj2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, obj, obj2, i) == null) {
                try {
                    this.a.invoke(obj, obj2, Integer.valueOf(i), 1);
                } catch (Exception unused) {
                    throw new d.a("");
                }
            }
        }

        public final void d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                Method d = com.baidu.helios.channels.csc.d.d(Context.class, com.baidu.helios.channels.csc.d.c(xx.c()), null);
                this.c = d;
                Object invoke = d.invoke(context, new Object[0]);
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), "");
                this.d = com.baidu.helios.channels.csc.d.d(intent.getClass(), com.baidu.helios.channels.csc.d.c(xx.d()), null).invoke(intent, new Object[0]).getClass();
                String c = com.baidu.helios.channels.csc.d.c(xx.a());
                Class<?> cls = invoke.getClass();
                Class cls2 = Integer.TYPE;
                this.a = com.baidu.helios.channels.csc.d.d(cls, c, new Class[]{this.d, cls2, cls2});
                this.b = com.baidu.helios.channels.csc.d.d(invoke.getClass(), com.baidu.helios.channels.csc.d.c(xx.b()), new Class[]{this.d});
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public g(String str, Throwable th) {
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

    /* loaded from: classes3.dex */
    public class h extends ux.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;
        public int e;
        public long f;
        public String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(QuantumChannel quantumChannel, String str) {
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
                    super((b00.a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ux.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.d = jSONObject.getString("pkg");
                this.e = jSONObject.getInt("aid_ver");
                this.f = jSONObject.getLong("last_fe_ts");
                this.g = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // com.baidu.tieba.ux.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.d);
                jSONObject.put("aid_ver", this.e);
                jSONObject.put("last_fe_ts", this.f);
                jSONObject.put("id", this.g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (String) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str.equals(this.d)) {
                return;
            }
            this.d = str;
            a(true);
        }

        public int j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : invokeV.intValue;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str.equals(this.g)) {
                return;
            }
            this.g = str;
            a(true);
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (String) invokeV.objValue;
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
        j = wx.a(160);
        k = wx.a(8);
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
    @Override // com.baidu.tieba.ux
    public ux.h b(String str, ux.g gVar) {
        InterceptResult invokeLL;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            try {
                Object b2 = this.h.b(this.a.a);
                if (b2 == null) {
                    return ux.h.c(-101, null);
                }
                if (gVar.a) {
                    hVar = new h(this, str);
                    hVar.d();
                    if (str.equals(hVar.f())) {
                        try {
                            if (hVar.j() == i(b2, str)) {
                                String l = hVar.l();
                                if (!TextUtils.isEmpty(l)) {
                                    return ux.h.f(l);
                                }
                            }
                        } catch (b e2) {
                            return ux.h.d(e2);
                        } catch (g unused) {
                            return ux.h.b(-102);
                        } catch (d.a unused2) {
                            return ux.h.c(-101, null);
                        }
                    }
                } else {
                    hVar = null;
                }
                try {
                    try {
                        if (!p(b2, str)) {
                            ux.h c2 = ux.h.c(-2, null);
                            if (gVar.a && hVar != null) {
                                hVar.b();
                            }
                            return c2;
                        }
                        String i = g00.i(o(b2, str));
                        int i2 = i(b2, str);
                        if (gVar.a && hVar != null) {
                            hVar.k(i);
                            hVar.i(str);
                            hVar.h(System.currentTimeMillis());
                            hVar.g(i2);
                        }
                        ux.h f2 = ux.h.f(i);
                        if (gVar.a && hVar != null) {
                            hVar.b();
                        }
                        return f2;
                    } catch (b e3) {
                        ux.h d2 = ux.h.d(e3);
                        if (gVar.a && hVar != null) {
                            hVar.b();
                        }
                        return d2;
                    } catch (g unused3) {
                        ux.h b3 = ux.h.b(-102);
                        if (gVar.a && hVar != null) {
                            hVar.b();
                        }
                        return b3;
                    } catch (d.a unused4) {
                        ux.h c3 = ux.h.c(-2, null);
                        if (gVar.a && hVar != null) {
                            hVar.b();
                        }
                        return c3;
                    }
                } catch (Throwable th) {
                    if (gVar.a && hVar != null) {
                        hVar.b();
                    }
                    throw th;
                }
            } catch (d.a unused5) {
                return ux.h.c(-101, null);
            }
        }
        return (ux.h) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ux
    public void e(ux.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f = this.b.f("csc");
            this.h = new f(this.a.a);
            this.i = new c(null);
        }
    }

    @Override // com.baidu.tieba.ux
    public ux.f f(ux.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.g.j();
            try {
                return j(eVar);
            } finally {
                this.g.k();
            }
        }
        return (ux.f) invokeL.objValue;
    }

    public final int h(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            try {
                return this.h.a(obj, obj2);
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
            for (int i = 0; i < k; i++) {
                aVar.a(e.e(h(obj, n(str, i))));
            }
            byte[] f2 = aVar.b().f();
            int i2 = 0;
            for (int i3 = 0; i3 < f2.length; i3++) {
                i2 |= (f2[i3] & 255) << (i3 * 8);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public final ux.f j(ux.e eVar) {
        InterceptResult invokeL;
        Object obj;
        long j2;
        int i;
        String i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, eVar)) != null) {
            return (ux.f) invokeL.objValue;
        }
        Context context = this.a.a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.g.g();
            this.g.h(packageInfo.lastUpdateTime);
            if (!z && this.g.f(6L) == 4) {
                return ux.f.b(-101);
            }
            e00 a2 = this.a.c.a("aid");
            try {
                Object b2 = this.h.b(context);
                if (b2 == null) {
                    return ux.f.b(-102);
                }
                try {
                    try {
                        if (this.g.f(1L) == 1 && (i2 = this.g.i()) != null && i2.equals(a2.c()) && p(b2, packageName)) {
                            if (this.g.a() == i(b2, packageName)) {
                                return ux.f.d();
                            }
                        }
                        byte[] d2 = a2.d();
                        this.g.e(a2.c());
                        e d3 = e.d(d2, d2.length * 8);
                        try {
                            try {
                                int a3 = d3.a();
                                for (int i3 = 0; i3 < a3; i3++) {
                                    try {
                                        m(b2, l(packageName, i3), d3.c(i3));
                                    } catch (b unused) {
                                        i = -101;
                                        j2 = 4;
                                        this.g.d(j2, 6L);
                                        return ux.f.b(i);
                                    }
                                }
                                int nextInt = new Random().nextInt(255);
                                this.g.b(nextInt);
                                byte[] bArr = new byte[1];
                                for (int i4 = 0; i4 < 1; i4++) {
                                    bArr[i4] = (byte) ((nextInt >> (i4 * 8)) & 255);
                                }
                                e d4 = e.d(bArr, 8);
                                try {
                                    int a4 = d4.a();
                                    for (int i5 = 0; i5 < a4; i5++) {
                                        m(b2, n(packageName, i5), d4.c(i5));
                                    }
                                    try {
                                        if (i(b2, packageName) != nextInt) {
                                            return ux.f.b(-103);
                                        }
                                        try {
                                            m(b2, k(packageName), 1);
                                            this.g.c(System.currentTimeMillis());
                                            this.g.d(1L, 1L);
                                            return ux.f.d();
                                        } catch (b unused2) {
                                            this.g.d(4L, 6L);
                                            return ux.f.b(-101);
                                        } catch (d.a unused3) {
                                            return ux.f.b(-102);
                                        }
                                    } catch (b unused4) {
                                        this.g.d(4L, 6L);
                                        return ux.f.b(-101);
                                    } catch (g unused5) {
                                        return ux.f.b(-103);
                                    } catch (d.a unused6) {
                                        return ux.f.b(-102);
                                    }
                                } catch (b unused7) {
                                    this.g.d(4L, 6L);
                                    return ux.f.b(-101);
                                } catch (d.a unused8) {
                                    return ux.f.b(-102);
                                }
                            } catch (d.a unused9) {
                                return ux.f.b(-102);
                            }
                        } catch (b unused10) {
                            j2 = 4;
                            i = -101;
                        }
                    } catch (Exception unused11) {
                        return ux.f.b(-103);
                    }
                } catch (b unused12) {
                    this.g.d(4L, 6L);
                    return ux.f.b(-101);
                } catch (g unused13) {
                    m(obj, k(packageName), 0);
                    return ux.f.b(-103);
                } catch (d.a unused14) {
                    return ux.f.b(-102);
                }
            } catch (d.a unused15) {
                return ux.f.b(-102);
            }
        } catch (PackageManager.NameNotFoundException unused16) {
            return ux.f.b(-100);
        }
    }

    public final Object k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return com.baidu.helios.channels.csc.d.b(this.h.d, new Object[]{str, this.i.b});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new b("");
            }
        }
        return invokeL.objValue;
    }

    public final Object l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i)) == null) {
            try {
                Class<?> cls = this.h.d;
                return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.i.a + i});
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new b("");
            }
        }
        return invokeLI.objValue;
    }

    public final void m(Object obj, Object obj2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, obj2, i) == null) {
            try {
                this.h.c(obj, obj2, i);
            } catch (d.a e2) {
                throw e2;
            } catch (Throwable th) {
                throw new b(th);
            }
        }
    }

    public final Object n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            try {
                Class<?> cls = this.h.d;
                return com.baidu.helios.channels.csc.d.b(cls, new Object[]{str, this.i.c + i});
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
            for (int i = 0; i < j; i++) {
                aVar.a(e.e(h(obj, l(str, i))));
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
