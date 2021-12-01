package c.a.q.f.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q.f.a;
import c.a.q.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.channels.upc.d;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends c.a.q.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f11364f;

    /* renamed from: g  reason: collision with root package name */
    public k f11365g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0742a f11366h;

    /* renamed from: i  reason: collision with root package name */
    public j f11367i;

    /* renamed from: c.a.q.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0735a extends b<C0735a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f11368f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401830733, "Lc/a/q/f/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-401830733, "Lc/a/q/f/f/a$a;");
                    return;
                }
            }
            f11368f = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
            b.b(4);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0735a(int i2) {
            super(i2, 4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static C0735a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? new C0735a(i2) : (C0735a) invokeI.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f11368f[a()] : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b<T extends b> implements Comparable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f11369e;

        public b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int b2 = b(i3);
            if (i2 >= 0 && i2 <= b2) {
                this.f11369e = i2;
                return;
            }
            throw new IllegalArgumentException("invalid index " + i2);
        }

        public static int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (1 << i2) - 1 : invokeI.intValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11369e : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: c */
        public int compareTo(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? this.f11369e - t.a() : invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.f11369e == ((b) obj).f11369e;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11369e : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c<T extends b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C0737c<T>> a;

        /* renamed from: c.a.q.f.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0736a implements Comparator<C0737c<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0736a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
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
            public int compare(C0737c<T> c0737c, C0737c<T> c0737c2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c0737c, c0737c2)) == null) ? c0737c.a - c0737c2.a : invokeLL.intValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Comparator<C0737c<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
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
            public int compare(C0737c<T> c0737c, C0737c<T> c0737c2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c0737c, c0737c2)) == null) ? c0737c2.a - c0737c.a : invokeLL.intValue;
            }
        }

        /* renamed from: c.a.q.f.f.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0737c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public T f11370b;

            public C0737c(T t) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11370b = t;
            }

            public T a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11370b : (T) invokeV.objValue;
            }

            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a++;
                }
            }
        }

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
            this.a = new ArrayList();
        }

        public C0737c a(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
                C0737c<T> c0737c = new C0737c<>(t);
                this.a.add(c0737c);
                return c0737c;
            }
            return (C0737c) invokeL.objValue;
        }

        public List<C0737c<T>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new C0736a(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public List<C0737c<T>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new b(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends b<d> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final int f11371f;

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f11372g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401830640, "Lc/a/q/f/f/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-401830640, "Lc/a/q/f/f/a$d;");
                    return;
                }
            }
            int b2 = b.b(6);
            f11371f = b2;
            f11372g = new String[b2 + 1];
            String[] strArr = {"read", "access", "sync", "open", "refresh", BundleOpProvider.METHOD_BUNDLE_CHECK, IntentConfig.CLOSE, "release"};
            for (int i2 = 0; i2 <= f11371f; i2++) {
                String str = strArr[i2 / 8];
                String valueOf = String.valueOf(i2 % 8);
                String[] strArr2 = f11372g;
                strArr2[i2] = str + valueOf;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2) {
            super(i2, 6);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static d d(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? f(b2 & 255) : (d) invokeB.objValue;
        }

        public static d e(g gVar, C0735a c0735a) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gVar, c0735a)) == null) ? f((gVar.a() << 4) | c0735a.a()) : (d) invokeLL.objValue;
        }

        public static d f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? new d(i2) : (d) invokeI.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f11372g[a()] : (String) invokeV.objValue;
        }

        public C0735a h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? C0735a.d(a() & 15) : (C0735a) invokeV.objValue;
        }

        public byte i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (byte) a() : invokeV.byteValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f11373b;

        public e() {
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
            this.a = new d[27];
        }

        public static e b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                e eVar = new e();
                for (byte b2 : c.a.q.f.f.b.d(bArr)) {
                    eVar.d(d.d(b2));
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11373b : invokeV.intValue;
        }

        public final void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d[] dVarArr = this.a;
                if (i2 - dVarArr.length > 0) {
                    int length = dVarArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.a = (d[]) Arrays.copyOf(this.a, i2);
                }
            }
        }

        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                c(this.f11373b + 1);
                d[] dVarArr = this.a;
                int i2 = this.f11373b;
                this.f11373b = i2 + 1;
                dVarArr[i2] = dVar;
            }
        }

        public d e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (i2 < this.f11373b) {
                    return this.a[i2];
                }
                throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f11373b);
            }
            return (d) invokeI.objValue;
        }

        public byte[] f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i2 = 0; i2 < this.f11373b; i2++) {
                    byteArrayOutputStream.write(this.a[i2].i());
                }
                return c.a.q.f.f.b.b(byteArrayOutputStream.toByteArray());
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f<T extends b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Map<T, Integer> f11374b;

        /* renamed from: c.a.q.f.f.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0738a implements Comparator<Map.Entry<T, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0738a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
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
            public int compare(Map.Entry<T, Integer> entry, Map.Entry<T, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
                }
                return invokeLL.intValue;
            }
        }

        public f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11374b = new HashMap();
            this.a = i2;
        }

        public List<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f11374b.entrySet());
                Collections.sort(arrayList, new C0738a(this));
                ArrayList arrayList2 = new ArrayList(this.a);
                int min = Math.min(this.a, arrayList.size());
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

        public void b(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                Integer num = this.f11374b.get(t);
                this.f11374b.put(t, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends b<g> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final int f11375f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401830547, "Lc/a/q/f/f/a$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-401830547, "Lc/a/q/f/f/a$g;");
                    return;
                }
            }
            f11375f = b.b(2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2) {
            super(i2, 2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static g d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? new g(i2) : (g) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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
    }

    /* loaded from: classes5.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f11376b;

        public i() {
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

    /* loaded from: classes5.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f11377b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.q.h.c.a.e f11378c;

        /* renamed from: d  reason: collision with root package name */
        public long f11379d;

        /* renamed from: e  reason: collision with root package name */
        public String f11380e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11381f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f11382g;

        public j(a aVar) {
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
            this.f11382g = aVar;
            this.f11378c = new c.a.q.h.c.a.e();
            this.f11381f = true;
        }

        public long a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f11378c.a(j2) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11380e : (String) invokeV.objValue;
        }

        public boolean c(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                if (this.f11378c.c(j2, j3)) {
                    this.f11381f = true;
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                String str2 = this.f11380e;
                if (str2 == str) {
                    return false;
                }
                if (str == null || !str.equals(str2)) {
                    this.f11381f = true;
                    this.f11380e = str;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void e(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f11377b == j2) {
                return;
            }
            this.f11377b = j2;
            this.f11381f = true;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11379d : invokeV.longValue;
        }

        public boolean g(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (this.f11379d != j2) {
                    this.f11379d = j2;
                    this.f11381f = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f11381f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.a);
                        jSONObject.put("pub_lst_ts", this.f11377b);
                        jSONObject.put("pkg_lst_up_ts", this.f11379d);
                        jSONObject.put("flags", this.f11378c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.f11380e);
                        this.f11382g.f11366h.i("pub.dat", jSONObject.toString(), true);
                        this.f11381f = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                String g2 = this.f11382g.f11366h.g("pub.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.a = jSONObject.getInt("pub_ver");
                    this.f11377b = jSONObject.getLong("pub_lst_ts");
                    this.f11379d = jSONObject.getLong("pkg_lst_up_ts");
                    this.f11378c.b(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.f11380e = jSONObject.optString("aid");
                    this.f11381f = false;
                } catch (Exception unused) {
                    this.f11381f = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;

        /* renamed from: b  reason: collision with root package name */
        public Method f11383b;

        /* renamed from: c  reason: collision with root package name */
        public Method f11384c;

        /* renamed from: d  reason: collision with root package name */
        public Method f11385d;

        /* renamed from: e  reason: collision with root package name */
        public Method f11386e;

        public k() {
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

        public int a(Context context, Uri uri, int i2, int i3, int i4) throws d.a {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                try {
                    return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
                } catch (Exception e2) {
                    throw new d.a(e2);
                }
            }
            return invokeCommon.intValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = com.baidu.helios.channels.upc.d.b(Context.class, com.baidu.helios.channels.upc.d.a(c.a.q.f.f.c.a()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.f11383b = com.baidu.helios.channels.upc.d.b(Context.class, com.baidu.helios.channels.upc.d.a(c.a.q.f.f.c.b()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.f11384c = com.baidu.helios.channels.upc.d.b(ContentResolver.class, com.baidu.helios.channels.upc.d.a(c.a.q.f.f.c.e()), new Class[]{Uri.class, Integer.TYPE});
                    this.f11385d = com.baidu.helios.channels.upc.d.b(Context.class, com.baidu.helios.channels.upc.d.a(c.a.q.f.f.c.d()), new Class[]{Uri.class, Integer.TYPE});
                    this.f11386e = com.baidu.helios.channels.upc.d.b(ContentResolver.class, com.baidu.helios.channels.upc.d.a(c.a.q.f.f.c.c()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i2) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, i2) == null) {
                try {
                    this.f11386e.invoke(contentResolver, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new d.a(e2);
                }
            }
        }

        public void d(Context context, Uri uri, int i2) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, context, uri, i2) == null) {
                try {
                    this.f11385d.invoke(context, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new d.a(e2);
                }
            }
        }

        public void e(Context context, String str, Uri uri, int i2) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, context, str, uri, i2) == null) {
                try {
                    this.f11383b.invoke(context, str, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new d.a(e2);
                }
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i2) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, contentResolver, uri, i2) == null) {
                try {
                    this.f11384c.invoke(contentResolver, uri, Integer.valueOf(i2));
                } catch (Exception e2) {
                    throw new d.a(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f11387d;

        /* renamed from: e  reason: collision with root package name */
        public long f11388e;

        /* renamed from: f  reason: collision with root package name */
        public String f11389f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(a aVar, String str) {
            super(aVar.f11366h, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
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
                this.f11387d = jSONObject.getString("pkg");
                this.f11388e = jSONObject.getLong("last_fe_ts");
                this.f11389f = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.q.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f11387d);
                jSONObject.put("last_fe_ts", this.f11388e);
                jSONObject.put("id", this.f11389f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11389f : (String) invokeV.objValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.f11388e == j2) {
                return;
            }
            this.f11388e = j2;
            a(true);
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str.equals(this.f11389f)) {
                return;
            }
            this.f11389f = str;
            a(true);
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11387d : (String) invokeV.objValue;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str.equals(this.f11387d)) {
                return;
            }
            this.f11387d = str;
            a(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("upc", 8500000L);
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
        this.f11365g = new k();
        this.f11367i = new j(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // c.a.q.f.a
    public a.g b(String str, a.f fVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return a.g.a();
            }
            h hVar = new h();
            l lVar = null;
            try {
                packageInfo = this.f11364f.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.g.a();
            }
            if (fVar.a) {
                lVar = new l(this, str);
                lVar.d();
                if (str.equals(lVar.i())) {
                    String f2 = lVar.f();
                    if (!TextUtils.isEmpty(f2)) {
                        return a.g.f(f2);
                    }
                }
                lVar.j(str);
            }
            l lVar2 = lVar;
            int i2 = packageInfo.applicationInfo.uid;
            i iVar = new i();
            c cVar = new c();
            c cVar2 = new c();
            for (int i3 = 0; i3 < 16; i3++) {
                try {
                    C0735a d2 = C0735a.d(i3);
                    if (u(str, d2, i2)) {
                        cVar.a(d2);
                    } else {
                        cVar2.a(d2);
                    }
                } finally {
                    if (fVar.a && lVar2 != null) {
                        lVar2.b();
                    }
                }
            }
            e eVar = new e();
            int a = c.a.q.f.f.b.a(20);
            c cVar3 = new c();
            for (int i4 = 0; i4 <= g.f11375f; i4++) {
                cVar3.a(g.d(i4));
            }
            int i5 = 0;
            while (i5 < a) {
                int i6 = i5;
                c cVar4 = cVar3;
                int i7 = a;
                e eVar2 = eVar;
                d j2 = j(str, i5, cVar.b(), cVar3.c(), i2, iVar);
                if (j2 == null) {
                    j2 = j(str, i6, cVar2.b(), cVar4.c(), i2, iVar);
                }
                if (j2 == null) {
                    return a.g.a();
                }
                eVar2.d(j2);
                i5 = i6 + 1;
                eVar = eVar2;
                cVar3 = cVar4;
                a = i7;
            }
            String i8 = c.a.q.j.c.a.i(eVar.f());
            if (fVar.a && lVar2 != null) {
                lVar2.h(i8);
                lVar2.g(System.currentTimeMillis());
            }
            a.g f3 = a.g.f(i8);
            if (fVar.f11329b) {
                f3.f11331c = hVar;
            }
            if (fVar.a && lVar2 != null) {
                lVar2.b();
            }
            return f3;
        }
        return (a.g) invokeLL.objValue;
    }

    @Override // c.a.q.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f11364f = this.a.a;
            this.f11366h = this.f11322b.f("upc");
            this.f11365g.b();
        }
    }

    @Override // c.a.q.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            this.f11367i.i();
            try {
                return h(dVar);
            } finally {
                this.f11367i.h();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final a.e h(a.d dVar) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return a.e.a();
            }
            Context context = this.a.a;
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                boolean z = packageInfo.lastUpdateTime != this.f11367i.f();
                this.f11367i.g(packageInfo.lastUpdateTime);
                if (z || this.f11367i.a(6L) != 4) {
                    c.a.q.j.a a = this.a.f11326c.a("aid");
                    e b3 = e.b(a.d());
                    if (b3 == null) {
                        return a.e.a();
                    }
                    if (this.f11367i.a(1L) == 1 && (b2 = this.f11367i.b()) != null && b2.equals(a.c())) {
                        return a.e.d();
                    }
                    this.f11367i.d(a.c());
                    ProviderInfo providerInfo = null;
                    try {
                        providerInfo = packageManager.resolveContentProvider(k(packageName), 0);
                    } catch (Exception unused) {
                    }
                    if (providerInfo == null) {
                        this.f11367i.c(4L, 6L);
                    } else {
                        this.f11367i.c(2L, 6L);
                    }
                    return i(b3);
                }
                return a.e.a();
            } catch (PackageManager.NameNotFoundException unused2) {
                return a.e.a();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final a.e i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            f fVar = new f(6);
            for (int i2 = 0; i2 < eVar.a(); i2++) {
                fVar.b(eVar.e(i2).h());
            }
            List<C0735a> a = fVar.a();
            if (s(eVar, a)) {
                for (int a2 = eVar.a() - 1; a2 >= 0; a2--) {
                    o(a2, eVar.e(a2));
                }
                for (C0735a c0735a : a) {
                    r(c0735a);
                }
                this.f11367i.e(System.currentTimeMillis());
            }
            this.f11367i.c(1L, 1L);
            return a.e.d();
        }
        return (a.e) invokeL.objValue;
    }

    public final d j(String str, int i2, List<c.C0737c<C0735a>> list, List<c.C0737c<g>> list2, int i3, i iVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), list, list2, Integer.valueOf(i3), iVar})) == null) {
            for (c.C0737c<C0735a> c0737c : list) {
                for (c.C0737c<g> c0737c2 : list2) {
                    d e2 = d.e(c0737c2.a(), c0737c.a());
                    if (t(str, i2, e2, i3, iVar)) {
                        c0737c.c();
                        c0737c2.c();
                        return e2;
                    }
                }
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return str + ".helios.quark";
        }
        return (String) invokeL.objValue;
    }

    public final String l(String str, int i2, d dVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, str, i2, dVar)) == null) ? String.format("content://%s/dat/v1/i%d/%s", k(str), Integer.valueOf(i2), dVar.g()) : (String) invokeLIL.objValue;
    }

    public final String m(String str, C0735a c0735a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, c0735a)) == null) ? String.format("content://%s/dic/v1/%s", k(str), c0735a.e()) : (String) invokeLL.objValue;
    }

    public final void n(UriMatcher uriMatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uriMatcher) == null) {
            uriMatcher.addURI(k(this.f11364f.getPackageName()), "dat/v1/*/*", 1);
            uriMatcher.addURI(k(this.f11364f.getPackageName()), "dic/v1/*", 2);
        }
    }

    public final boolean o(int i2, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return p(Uri.parse(l(this.f11364f.getPackageName(), i2, dVar)));
        }
        return invokeIL.booleanValue;
    }

    public final boolean p(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, uri)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f11364f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.f11365g.e(context, context.getPackageName(), uri, 65);
                this.f11365g.f(contentResolver, uri, 1);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean q(Uri uri, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, uri, i2)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f11364f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.f11365g.d(context, uri, i2);
                this.f11365g.c(contentResolver, uri, i2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public final boolean r(C0735a c0735a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, c0735a)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return p(Uri.parse(m(this.f11364f.getPackageName(), c0735a)));
        }
        return invokeL.booleanValue;
    }

    public final boolean s(e eVar, List<C0735a> list) {
        InterceptResult invokeLL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, eVar, list)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            ContentResolver contentResolver = this.f11364f.getContentResolver();
            UriMatcher uriMatcher = new UriMatcher(-1);
            n(uriMatcher);
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
                if ((match == 1 || match == 2) && uriPermission.isWritePermission()) {
                    q(uri, uriPermission.isReadPermission() ? 3 : 2);
                } else if (match == 1) {
                    try {
                        i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception unused) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < eVar.a()) {
                        if (!eVar.e(i2).g().equals(pathSegments.get(3))) {
                        }
                    }
                    q(uri, 1);
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<C0735a> it = list.iterator();
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
                        q(uri, 1);
                    }
                }
            }
            int a = eVar.a();
            for (int i3 = 0; i3 < a; i3++) {
                if (!t(this.f11364f.getPackageName(), i3, eVar.e(i3), Process.myUid(), null)) {
                    return true;
                }
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!u(this.f11364f.getPackageName(), list.get(i4), Process.myUid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean t(String str, int i2, d dVar, int i3, i iVar) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{str, Integer.valueOf(i2), dVar, Integer.valueOf(i3), iVar})) == null) {
            Uri parse = Uri.parse(l(str, i2, dVar));
            int i5 = 0;
            while (true) {
                if (i5 >= 2) {
                    i4 = -1;
                    break;
                }
                if (iVar != null) {
                    try {
                        if (iVar.a > 0 && iVar.a % 100 == 0) {
                            try {
                                Thread.sleep(10L);
                            } catch (Exception unused) {
                            }
                        }
                        iVar.a++;
                    } catch (Throwable unused2) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused3) {
                        }
                        i5++;
                    }
                }
                i4 = this.f11365g.a(this.f11364f, parse, 0, i3, 1);
                break;
            }
            if (i4 == 0) {
                return true;
            }
            if (iVar != null) {
                iVar.f11376b++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean u(String str, C0735a c0735a, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, str, c0735a, i2)) == null) {
            Uri parse = Uri.parse(m(str, c0735a));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.f11365g.a(this.f11364f, parse, 0, i2, 1);
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
}
