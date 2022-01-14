package c.a.m.i;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.g;
import c.a.m.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cesium.i.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends c.a.m.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f4301f;

    /* renamed from: g  reason: collision with root package name */
    public g f4302g;

    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f4303f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f4304e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1911546008, "Lc/a/m/i/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1911546008, "Lc/a/m/i/d$a;");
                    return;
                }
            }
            f4303f = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        }

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f4304e = i2;
        }

        public static a c(byte b2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Boolean.valueOf(z)})) == null) {
                int i2 = b2 & 255;
                return d(z ? i2 >> 4 : i2 & 15);
            }
            return (a) invokeCommon.objValue;
        }

        public static a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 < 0 || i2 >= 16) {
                    throw new IllegalArgumentException("invalid idx " + i2);
                }
                return new a(i2);
            }
            return (a) invokeI.objValue;
        }

        public byte a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (byte) this.f4304e : invokeV.byteValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: b */
        public int compareTo(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f4304e - aVar.f4304e : invokeL.intValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f4303f[this.f4304e] : (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && a.class == obj.getClass() && this.f4304e == ((a) obj).f4304e;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4304e : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<a, Integer> a;

        /* loaded from: classes.dex */
        public class a implements Comparator<Map.Entry<a, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<a, Integer> entry, Map.Entry<a, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
                }
                return invokeLL.intValue;
            }
        }

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
            this.a = new HashMap();
        }

        public List<a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a.entrySet());
                Collections.sort(arrayList, new a(this));
                ArrayList arrayList2 = new ArrayList(6);
                int min = Math.min(6, arrayList.size());
                for (int i2 = 0; i2 < min; i2++) {
                    Map.Entry entry = (Map.Entry) arrayList.get(i2);
                    if (((Integer) entry.getValue()).intValue() > 1) {
                        arrayList2.add(entry.getKey());
                    }
                }
                return arrayList2;
            }
            return (List) invokeV.objValue;
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                Integer num = this.a.get(aVar);
                this.a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f4305b;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new a[33];
        }

        public c(d dVar, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = new a[33];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i4 = 0; i4 < bArr.length; i4++) {
                a c2 = a.c(bArr[i4], false);
                a c3 = a.c(bArr[i4], true);
                c(c2);
                c(c3);
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4305b : invokeV.intValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a[] aVarArr = this.a;
                if (i2 - aVarArr.length > 0) {
                    int length = aVarArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.a = (a[]) Arrays.copyOf(this.a, i2);
                }
            }
        }

        public void c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                b(this.f4305b + 1);
                a[] aVarArr = this.a;
                int i2 = this.f4305b;
                this.f4305b = i2 + 1;
                aVarArr[i2] = aVar;
            }
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (i2 < this.f4305b) {
                    return this.a[i2];
                }
                throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f4305b);
            }
            return (a) invokeI.objValue;
        }

        public byte[] e() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i3 = 0;
                while (true) {
                    i2 = this.f4305b;
                    if (i3 >= i2 / 2) {
                        break;
                    }
                    int i4 = i3 * 2;
                    byteArrayOutputStream.write((byte) (((d(i4 + 1).a() & 255) << 4) | (d(i4).a() & 255)));
                    i3++;
                }
                if (i2 % 2 != 0) {
                    byteArrayOutputStream.write((byte) (d(i2 - 1).a() & 255));
                }
                return byteArrayOutputStream.toByteArray();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* renamed from: c.a.m.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0198d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<b> a;

        /* renamed from: c.a.m.i.d$d$a */
        /* loaded from: classes.dex */
        public class a implements Comparator<b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C0198d c0198d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0198d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) ? bVar.a - bVar2.a : invokeLL.intValue;
            }
        }

        /* renamed from: c.a.m.i.d$d$b */
        /* loaded from: classes.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public a f4306b;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4306b = aVar;
            }

            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a++;
                }
            }
        }

        public C0198d() {
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
            this.a = new ArrayList();
        }

        public List<b> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new a(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.add(new b(aVar));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public byte f4307b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f4308c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4309d;

        /* renamed from: e  reason: collision with root package name */
        public String f4310e;

        public e(byte[] bArr, byte b2, byte[] bArr2, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Byte.valueOf(b2), bArr2, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4310e = "";
            this.a = bArr;
            this.f4307b = b2;
            this.f4308c = bArr2;
            this.f4309d = z;
            this.f4310e = str;
        }

        public static e b(g.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                try {
                    byte[] y = d.y(aVar.n());
                    if (y.length > 16) {
                        return null;
                    }
                    return new e(y, aVar.v().getBytes("UTF-8")[0], aVar.p() != null ? aVar.p().getBytes("UTF-8") : null, aVar.m(), aVar.u());
                } catch (Exception unused) {
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public g.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return c.a.m.g.c(c.a.m.k.b.a(this.a, "", true), new String(new byte[]{this.f4307b}, "UTF-8"), this.f4308c != null ? new String(this.f4308c, "UTF-8") : null, this.f4309d, this.f4310e);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (g.a) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f4311b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;

        /* renamed from: b  reason: collision with root package name */
        public Method f4312b;

        /* renamed from: c  reason: collision with root package name */
        public Method f4313c;

        /* renamed from: d  reason: collision with root package name */
        public Method f4314d;

        /* renamed from: e  reason: collision with root package name */
        public Method f4315e;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a(Context context, Uri uri, int i2, int i3, int i4) throws i.a {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                try {
                    return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
            return invokeCommon.intValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = i.b(Context.class, i.a(c.a.m.h.c.a()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.f4312b = i.b(Context.class, i.a(c.a.m.h.c.d()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.f4313c = i.b(ContentResolver.class, i.a(c.a.m.h.c.g()), new Class[]{Uri.class, Integer.TYPE});
                    this.f4314d = i.b(Context.class, i.a(c.a.m.h.c.f()), new Class[]{Uri.class, Integer.TYPE});
                    this.f4315e = i.b(ContentResolver.class, i.a(c.a.m.h.c.e()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i2) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, i2) == null) {
                try {
                    this.f4315e.invoke(contentResolver, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }

        public void d(Context context, Uri uri, int i2) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, context, uri, i2) == null) {
                try {
                    this.f4314d.invoke(context, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }

        public void e(Context context, String str, Uri uri, int i2) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, context, str, uri, i2) == null) {
                try {
                    this.f4312b.invoke(context, str, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i2) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, contentResolver, uri, i2) == null) {
                try {
                    this.f4313c.invoke(contentResolver, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
        super("upc", 9000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g gVar = new g();
        this.f4302g = gVar;
        gVar.b();
    }

    public static byte[] y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    int digit = Character.digit(str.charAt(i3), 16);
                    int digit2 = Character.digit(str.charAt(i3 + 1), 16);
                    if (digit == -1 || digit2 == -1) {
                        throw new IllegalArgumentException("input is not hexadecimal");
                    }
                    bArr[i2] = (byte) ((digit * 16) + digit2);
                }
                return bArr;
            }
            throw new IllegalArgumentException("Expected a string of even length");
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // c.a.m.i.a
    public a.f a(a.e eVar, g.a aVar) {
        InterceptResult invokeLL;
        e b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && (b2 = e.b(aVar)) != null) {
                c cVar = new c(this, b2.a);
                cVar.c(a.c(b2.f4307b, false));
                cVar.c(a.c(b2.f4307b, true));
                byte[] bArr = b2.f4308c;
                if (bArr != null) {
                    for (byte b3 : bArr) {
                        cVar.c(a.c(b3, false));
                        cVar.c(a.c(b3, true));
                    }
                }
                b bVar = new b();
                for (int i2 = 0; i2 < cVar.a(); i2++) {
                    bVar.b(cVar.d(i2));
                }
                List<a> a2 = bVar.a();
                if (p(cVar, a2)) {
                    for (int a3 = cVar.a() - 1; a3 >= 0; a3--) {
                        l(a3, cVar.d(a3));
                    }
                    for (a aVar2 : a2) {
                        o(aVar2);
                    }
                    x(c.a.m.g.n());
                    return a.f.c();
                }
                return a.f.c();
            }
            return a.f.a();
        }
        return (a.f) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c2  */
    @Override // c.a.m.i.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        int i2;
        Byte b2;
        Byte b3;
        boolean z;
        byte[] bArr;
        String str2;
        boolean z2;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return a.h.a();
            }
            try {
                i2 = this.f4301f.getPackageManager().getPackageUid(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                i2 = -1;
            }
            if (i2 < 0) {
                return a.h.a();
            }
            f fVar = new f();
            c cVar2 = new c(this);
            C0198d c0198d = new C0198d();
            C0198d c0198d2 = new C0198d();
            for (int i3 = 0; i3 < 16; i3++) {
                a d2 = a.d(i3);
                if (s(str, d2, i2)) {
                    c0198d.b(d2);
                } else {
                    c0198d2.b(d2);
                }
            }
            for (int i4 = 0; i4 < 32; i4++) {
                a g2 = g(str, i4, c0198d.a(), i2, fVar);
                if (g2 == null) {
                    g2 = g(str, i4, c0198d2.a(), i2, fVar);
                }
                if (g2 == null) {
                    return a.h.a();
                }
                cVar2.c(g2);
            }
            byte[] e2 = cVar2.e();
            int i5 = 3;
            byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    b2 = null;
                    break;
                }
                byte b4 = bArr2[i6];
                a c2 = a.c(b4, false);
                int i7 = i6;
                byte[] bArr3 = bArr2;
                if (r(str, 32, c2, i2, fVar)) {
                    a c3 = a.c(b4, true);
                    if (r(str, 33, c3, i2, fVar)) {
                        c cVar3 = new c(this);
                        cVar3.c(c2);
                        cVar3.c(c3);
                        b2 = Byte.valueOf(cVar3.e()[0]);
                        break;
                    }
                }
                i6 = i7 + 1;
                bArr2 = bArr3;
                i5 = 3;
            }
            if (b2 == null) {
                c cVar4 = new c(this);
                int i8 = 32;
                for (int i9 = 34; i8 < i9; i9 = 34) {
                    int i10 = i8;
                    c cVar5 = cVar4;
                    a g3 = g(str, i8, c0198d.a(), i2, fVar);
                    if (g3 == null) {
                        g3 = g(str, i10, c0198d2.a(), i2, fVar);
                    }
                    if (g3 == null) {
                        return a.h.a();
                    }
                    cVar5.c(g3);
                    i8 = i10 + 1;
                    cVar4 = cVar5;
                }
                b3 = Byte.valueOf(cVar4.e()[0]);
                z = true;
            } else {
                b3 = b2;
                z = false;
            }
            if (z) {
                c cVar6 = new c(this);
                int i11 = 34;
                while (true) {
                    if (i11 >= 94) {
                        cVar = cVar6;
                        break;
                    }
                    int i12 = i11;
                    cVar = cVar6;
                    a g4 = g(str, i11, c0198d.a(), i2, fVar);
                    if (g4 == null) {
                        g4 = g(str, i12, c0198d2.a(), i2, fVar);
                    }
                    if (g4 == null) {
                        break;
                    }
                    cVar.c(g4);
                    i11 = i12 + 1;
                    cVar6 = cVar;
                }
                if (cVar.a() > 0) {
                    bArr = cVar.e();
                    if (q(str, i2)) {
                        str2 = "";
                        z2 = false;
                    } else {
                        str2 = t(str, c.a.m.g.n(), i2) ? c.a.m.g.n() : "";
                        z2 = true;
                    }
                    return a.h.c(new e(e2, b3.byteValue(), bArr, z2, str2).a());
                }
            }
            bArr = null;
            if (q(str, i2)) {
            }
            return a.h.c(new e(e2, b3.byteValue(), bArr, z2, str2).a());
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.m.i.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f4301f = this.a.a;
        }
    }

    public final a g(String str, int i2, List<C0198d.b> list, int i3, f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), list, Integer.valueOf(i3), fVar})) == null) {
            for (C0198d.b bVar : list) {
                if (r(str, i2, bVar.f4306b, i3, fVar)) {
                    bVar.c();
                    return bVar.f4306b;
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public final String h(String str, int i2, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, str, i2, aVar)) == null) ? String.format("content://%s/dat/v1/i%d/%s", v(str), Integer.valueOf(i2), aVar.e()) : (String) invokeLIL.objValue;
    }

    public final String i(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, aVar)) == null) ? String.format("content://%s/dic/v1/%s", v(str), aVar.e()) : (String) invokeLL.objValue;
    }

    public final String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? String.format("content://%s/clo/v1/%s", v(str), str2) : (String) invokeLL.objValue;
    }

    public final void k(UriMatcher uriMatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uriMatcher) == null) {
            uriMatcher.addURI(v(this.f4301f.getPackageName()), "dat/v1/*/*", 1);
            uriMatcher.addURI(v(this.f4301f.getPackageName()), "dic/v1/*", 2);
            uriMatcher.addURI(v(this.f4301f.getPackageName()), "clo/v1/*", 3);
        }
    }

    public final boolean l(int i2, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return m(Uri.parse(h(this.f4301f.getPackageName(), i2, aVar)));
        }
        return invokeIL.booleanValue;
    }

    public final boolean m(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, uri)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f4301f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.f4302g.e(context, context.getPackageName(), uri, 65);
                this.f4302g.f(contentResolver, uri, 1);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean n(Uri uri, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, uri, i2)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f4301f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.f4302g.d(context, uri, i2);
                this.f4302g.c(contentResolver, uri, i2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public final boolean o(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return m(Uri.parse(i(this.f4301f.getPackageName(), aVar)));
        }
        return invokeL.booleanValue;
    }

    public final boolean p(c cVar, List<a> list) {
        InterceptResult invokeLL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, cVar, list)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            ContentResolver contentResolver = this.f4301f.getContentResolver();
            UriMatcher uriMatcher = new UriMatcher(-1);
            k(uriMatcher);
            List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
            if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
                persistedUriPermissions = contentResolver.getOutgoingPersistedUriPermissions();
            }
            if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
                return true;
            }
            for (UriPermission uriPermission : persistedUriPermissions) {
                Uri uri = uriPermission.getUri();
                int match = uriMatcher.match(uri);
                List<String> pathSegments = uri.getPathSegments();
                if ((match == 1 || match == 2 || match == 3) && uriPermission.isWritePermission()) {
                    n(uri, uriPermission.isReadPermission() ? 3 : 2);
                } else if (match == 1) {
                    try {
                        i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception unused) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < cVar.a()) {
                        if (!cVar.d(i2).e().equals(pathSegments.get(3))) {
                        }
                    }
                    n(uri, 1);
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().e().equals(str)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        n(uri, 1);
                    }
                } else if (match == 3) {
                    String str2 = pathSegments.get(2);
                    if (!TextUtils.equals(str2, c.a.m.g.n()) && !TextUtils.equals(str2, "yes")) {
                        n(uri, 1);
                    }
                }
            }
            int a2 = cVar.a();
            for (int i3 = 0; i3 < a2; i3++) {
                if (!r(this.f4301f.getPackageName(), i3, cVar.d(i3), Process.myUid(), null)) {
                    return true;
                }
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!s(this.f4301f.getPackageName(), list.get(i4), Process.myUid())) {
                    return true;
                }
            }
            if (q(this.f4301f.getPackageName(), Process.myUid())) {
                String n = c.a.m.g.n();
                return (TextUtils.isEmpty(n) || t(this.f4301f.getPackageName(), n, Process.myUid())) ? false : true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean q(String str, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            Uri parse = Uri.parse(w(str));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.f4302g.a(this.f4301f, parse, 0, i2, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            return i3 == 0;
        }
        return invokeLI.booleanValue;
    }

    public final boolean r(String str, int i2, a aVar, int i3, f fVar) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i2), aVar, Integer.valueOf(i3), fVar})) == null) {
            Uri parse = Uri.parse(h(str, i2, aVar));
            int i5 = 0;
            while (true) {
                if (i5 >= 2) {
                    i4 = -1;
                    break;
                }
                if (fVar != null) {
                    try {
                        fVar.a++;
                    } catch (Throwable unused) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused2) {
                        }
                        i5++;
                    }
                }
                i4 = this.f4302g.a(this.f4301f, parse, 0, i3, 1);
                break;
            }
            if (i4 == 0) {
                return true;
            }
            if (fVar != null) {
                fVar.f4311b++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean s(String str, a aVar, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048591, this, str, aVar, i2)) == null) {
            Uri parse = Uri.parse(i(str, aVar));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.f4302g.a(this.f4301f, parse, 0, i2, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            return i3 == 0;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean t(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, str, str2, i2)) == null) {
            Uri parse = Uri.parse(j(str, str2));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.f4302g.a(this.f4301f, parse, 0, i2, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            return i3 == 0;
        }
        return invokeLLI.booleanValue;
    }

    public final String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            return str + ".cesium";
        }
        return (String) invokeL.objValue;
    }

    public final String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? String.format("content://%s/clo/v1/%s", v(str), "yes") : (String) invokeL.objValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 26) {
                return m(Uri.parse(w(this.f4301f.getPackageName()))) && m(Uri.parse(j(this.f4301f.getPackageName(), str)));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
