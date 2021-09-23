package c.a.m.b;

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
import c.a.m.b.a;
import c.a.m.f;
import c.a.m.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cesium.a.i;
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
public class d extends c.a.m.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f3944f;

    /* renamed from: g  reason: collision with root package name */
    public g f3945g;

    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f3946f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f3947e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111950065, "Lc/a/m/b/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2111950065, "Lc/a/m/b/d$a;");
                    return;
                }
            }
            f3946f = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
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
            this.f3947e = i2;
        }

        public static a b(byte b2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Boolean.valueOf(z)})) == null) {
                int i2 = b2 & 255;
                return c(z ? i2 >> 4 : i2 & 15);
            }
            return (a) invokeCommon.objValue;
        }

        public static a c(int i2) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.f3947e - aVar.f3947e : invokeL.intValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f3946f[this.f3947e] : (String) invokeV.objValue;
        }

        public byte e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (byte) this.f3947e : invokeV.byteValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && a.class == obj.getClass() && this.f3947e == ((a) obj).f3947e;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3947e : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<a, Integer> f3948a;

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
            this.f3948a = new HashMap();
        }

        public List<a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f3948a.entrySet());
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
                Integer num = this.f3948a.get(aVar);
                this.f3948a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f3949a;

        /* renamed from: b  reason: collision with root package name */
        public a[] f3950b;

        /* renamed from: c  reason: collision with root package name */
        public int f3951c;

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
            this.f3949a = 33;
            this.f3950b = new a[33];
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
            this.f3949a = 33;
            this.f3950b = new a[33];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i4 = 0; i4 < bArr.length; i4++) {
                a b2 = a.b(bArr[i4], false);
                a b3 = a.b(bArr[i4], true);
                c(b2);
                c(b3);
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3951c : invokeV.intValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < this.f3951c) {
                    return this.f3950b[i2];
                }
                throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f3951c);
            }
            return (a) invokeI.objValue;
        }

        public void c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                d(this.f3951c + 1);
                a[] aVarArr = this.f3950b;
                int i2 = this.f3951c;
                this.f3951c = i2 + 1;
                aVarArr[i2] = aVar;
            }
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                a[] aVarArr = this.f3950b;
                if (i2 - aVarArr.length > 0) {
                    int length = aVarArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.f3950b = (a[]) Arrays.copyOf(this.f3950b, i2);
                }
            }
        }

        public byte[] e() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i3 = 0;
                while (true) {
                    i2 = this.f3951c;
                    if (i3 >= i2 / 2) {
                        break;
                    }
                    int i4 = i3 * 2;
                    byteArrayOutputStream.write((byte) (((b(i4 + 1).e() & 255) << 4) | (b(i4).e() & 255)));
                    i3++;
                }
                if (i2 % 2 != 0) {
                    byteArrayOutputStream.write((byte) (b(i2 - 1).e() & 255));
                }
                return byteArrayOutputStream.toByteArray();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* renamed from: c.a.m.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0099d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<b> f3952a;

        /* renamed from: c.a.m.b.d$d$a */
        /* loaded from: classes.dex */
        public class a implements Comparator<b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C0099d c0099d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0099d};
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
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) ? bVar.f3953a - bVar2.f3953a : invokeLL.intValue;
            }
        }

        /* renamed from: c.a.m.b.d$d$b */
        /* loaded from: classes.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f3953a;

            /* renamed from: b  reason: collision with root package name */
            public a f3954b;

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
                this.f3954b = aVar;
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3953a++;
                }
            }
        }

        public C0099d() {
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
            this.f3952a = new ArrayList();
        }

        public List<b> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f3952a);
                Collections.sort(arrayList, new a(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f3952a.add(new b(aVar));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f3955a;

        /* renamed from: b  reason: collision with root package name */
        public byte f3956b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f3957c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3958d;

        /* renamed from: e  reason: collision with root package name */
        public String f3959e;

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
            this.f3959e = "";
            this.f3955a = bArr;
            this.f3956b = b2;
            this.f3957c = bArr2;
            this.f3958d = z;
            this.f3959e = str;
        }

        public static e a(l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                try {
                    byte[] v = d.v(aVar.h());
                    if (v.length > 16) {
                        return null;
                    }
                    return new e(v, aVar.n().getBytes("UTF-8")[0], aVar.l() != null ? aVar.l().getBytes("UTF-8") : null, aVar.q(), aVar.r());
                } catch (Exception unused) {
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public l.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return l.e(f.c.a(this.f3955a, "", true), new String(new byte[]{this.f3956b}, "UTF-8"), this.f3957c != null ? new String(this.f3957c, "UTF-8") : null, this.f3958d, this.f3959e);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (l.a) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f3960a;

        /* renamed from: b  reason: collision with root package name */
        public int f3961b;

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

        /* renamed from: a  reason: collision with root package name */
        public Method f3962a;

        /* renamed from: b  reason: collision with root package name */
        public Method f3963b;

        /* renamed from: c  reason: collision with root package name */
        public Method f3964c;

        /* renamed from: d  reason: collision with root package name */
        public Method f3965d;

        /* renamed from: e  reason: collision with root package name */
        public Method f3966e;

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

        public int a(Context context, Uri uri, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                try {
                    return ((Integer) this.f3962a.invoke(context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
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
                    this.f3962a = i.b(Context.class, i.a(c.a.m.a.c.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.f3963b = i.b(Context.class, i.a(c.a.m.a.c.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.f3964c = i.b(ContentResolver.class, i.a(c.a.m.a.c.f()), new Class[]{Uri.class, Integer.TYPE});
                    this.f3965d = i.b(Context.class, i.a(c.a.m.a.c.g()), new Class[]{Uri.class, Integer.TYPE});
                    this.f3966e = i.b(ContentResolver.class, i.a(c.a.m.a.c.h()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, i2) == null) {
                try {
                    this.f3964c.invoke(contentResolver, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }

        public void d(Context context, Uri uri, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, context, uri, i2) == null) {
                try {
                    this.f3965d.invoke(context, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }

        public void e(Context context, String str, Uri uri, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, context, str, uri, i2) == null) {
                try {
                    this.f3963b.invoke(context, str, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new i.a(e2);
                }
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, contentResolver, uri, i2) == null) {
                try {
                    this.f3966e.invoke(contentResolver, uri, Integer.valueOf(i2));
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
        this.f3945g = gVar;
        gVar.b();
    }

    public static byte[] v(String str) {
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

    @Override // c.a.m.b.a
    public a.f a(a.e eVar, l.a aVar) {
        InterceptResult invokeLL;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && (a2 = e.a(aVar)) != null) {
                c cVar = new c(this, a2.f3955a);
                cVar.c(a.b(a2.f3956b, false));
                cVar.c(a.b(a2.f3956b, true));
                byte[] bArr = a2.f3957c;
                if (bArr != null) {
                    for (byte b2 : bArr) {
                        cVar.c(a.b(b2, false));
                        cVar.c(a.b(b2, true));
                    }
                }
                b bVar = new b();
                for (int i2 = 0; i2 < cVar.a(); i2++) {
                    bVar.b(cVar.b(i2));
                }
                List<a> a3 = bVar.a();
                if (p(cVar, a3)) {
                    for (int a4 = cVar.a() - 1; a4 >= 0; a4--) {
                        l(a4, cVar.b(a4));
                    }
                    for (a aVar2 : a3) {
                        o(aVar2);
                    }
                    y(l.l());
                    return a.f.b();
                }
                return a.f.b();
            }
            return a.f.c();
        }
        return (a.f) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c2  */
    @Override // c.a.m.b.a
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
                return a.h.d();
            }
            try {
                i2 = this.f3944f.getPackageManager().getPackageUid(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                i2 = -1;
            }
            if (i2 < 0) {
                return a.h.d();
            }
            f fVar = new f();
            c cVar2 = new c(this);
            C0099d c0099d = new C0099d();
            C0099d c0099d2 = new C0099d();
            for (int i3 = 0; i3 < 16; i3++) {
                a c2 = a.c(i3);
                if (s(str, c2, i2)) {
                    c0099d.b(c2);
                } else {
                    c0099d2.b(c2);
                }
            }
            for (int i4 = 0; i4 < 32; i4++) {
                a g2 = g(str, i4, c0099d.a(), i2, fVar);
                if (g2 == null) {
                    g2 = g(str, i4, c0099d2.a(), i2, fVar);
                }
                if (g2 == null) {
                    return a.h.d();
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
                a b5 = a.b(b4, false);
                int i7 = i6;
                byte[] bArr3 = bArr2;
                if (r(str, 32, b5, i2, fVar)) {
                    a b6 = a.b(b4, true);
                    if (r(str, 33, b6, i2, fVar)) {
                        c cVar3 = new c(this);
                        cVar3.c(b5);
                        cVar3.c(b6);
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
                    a g3 = g(str, i8, c0099d.a(), i2, fVar);
                    if (g3 == null) {
                        g3 = g(str, i10, c0099d2.a(), i2, fVar);
                    }
                    if (g3 == null) {
                        return a.h.d();
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
                    a g4 = g(str, i11, c0099d.a(), i2, fVar);
                    if (g4 == null) {
                        g4 = g(str, i12, c0099d2.a(), i2, fVar);
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
                        str2 = t(str, l.l(), i2) ? l.l() : "";
                        z2 = true;
                    }
                    return a.h.b(new e(e2, b3.byteValue(), bArr, z2, str2).b());
                }
            }
            bArr = null;
            if (q(str, i2)) {
            }
            return a.h.b(new e(e2, b3.byteValue(), bArr, z2, str2).b());
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // c.a.m.b.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f3944f = this.f3918a.f3922a;
        }
    }

    public final a g(String str, int i2, List<C0099d.b> list, int i3, f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), list, Integer.valueOf(i3), fVar})) == null) {
            for (C0099d.b bVar : list) {
                if (r(str, i2, bVar.f3954b, i3, fVar)) {
                    bVar.b();
                    return bVar.f3954b;
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public final String h(String str, int i2, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, str, i2, aVar)) == null) ? String.format("content://%s/dat/v1/i%d/%s", w(str), Integer.valueOf(i2), aVar.d()) : (String) invokeLIL.objValue;
    }

    public final String i(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, aVar)) == null) ? String.format("content://%s/dic/v1/%s", w(str), aVar.d()) : (String) invokeLL.objValue;
    }

    public final String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? String.format("content://%s/clo/v1/%s", w(str), str2) : (String) invokeLL.objValue;
    }

    public final void k(UriMatcher uriMatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uriMatcher) == null) {
            uriMatcher.addURI(w(this.f3944f.getPackageName()), "dat/v1/*/*", 1);
            uriMatcher.addURI(w(this.f3944f.getPackageName()), "dic/v1/*", 2);
            uriMatcher.addURI(w(this.f3944f.getPackageName()), "clo/v1/*", 3);
        }
    }

    public final boolean l(int i2, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return m(Uri.parse(h(this.f3944f.getPackageName(), i2, aVar)));
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
            Context context = this.f3944f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.f3945g.e(context, context.getPackageName(), uri, 65);
                this.f3945g.c(contentResolver, uri, 1);
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
            Context context = this.f3944f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.f3945g.d(context, uri, i2);
                this.f3945g.f(contentResolver, uri, i2);
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
            return m(Uri.parse(i(this.f3944f.getPackageName(), aVar)));
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
            ContentResolver contentResolver = this.f3944f.getContentResolver();
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
                        if (!cVar.b(i2).d().equals(pathSegments.get(3))) {
                        }
                    }
                    n(uri, 1);
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().d().equals(str)) {
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
                    if (!TextUtils.equals(str2, l.l()) && !TextUtils.equals(str2, "yes")) {
                        n(uri, 1);
                    }
                }
            }
            int a2 = cVar.a();
            for (int i3 = 0; i3 < a2; i3++) {
                if (!r(this.f3944f.getPackageName(), i3, cVar.b(i3), Process.myUid(), null)) {
                    return true;
                }
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!s(this.f3944f.getPackageName(), list.get(i4), Process.myUid())) {
                    return true;
                }
            }
            if (q(this.f3944f.getPackageName(), Process.myUid())) {
                String l = l.l();
                return (TextUtils.isEmpty(l) || t(this.f3944f.getPackageName(), l, Process.myUid())) ? false : true;
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
            Uri parse = Uri.parse(x(str));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.f3945g.a(this.f3944f, parse, 0, i2, 1);
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
                        fVar.f3960a++;
                    } catch (Throwable unused) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused2) {
                        }
                        i5++;
                    }
                }
                i4 = this.f3945g.a(this.f3944f, parse, 0, i3, 1);
                break;
            }
            if (i4 == 0) {
                return true;
            }
            if (fVar != null) {
                fVar.f3961b++;
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
                    i3 = this.f3945g.a(this.f3944f, parse, 0, i2, 1);
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
                    i3 = this.f3945g.a(this.f3944f, parse, 0, i2, 1);
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

    public final String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            return str + ".cesium";
        }
        return (String) invokeL.objValue;
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? String.format("content://%s/clo/v1/%s", w(str), "yes") : (String) invokeL.objValue;
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 26) {
                return m(Uri.parse(x(this.f3944f.getPackageName()))) && m(Uri.parse(j(this.f3944f.getPackageName(), str)));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
