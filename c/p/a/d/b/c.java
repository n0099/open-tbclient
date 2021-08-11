package c.p.a.d.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.d.e;
import c.p.a.d.f;
import c.p.a.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f34373b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34374a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34375e;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34375e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.p().a(3, l.a(), null, "下载失败，请重试！", null, 0);
                c.p.a.d.b.g a2 = c.p.a.d.g.b().a(this.f34375e);
                if (a2 != null) {
                    a2.H();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f34376a;

        /* renamed from: b  reason: collision with root package name */
        public long f34377b;

        /* renamed from: c  reason: collision with root package name */
        public long f34378c;

        /* renamed from: d  reason: collision with root package name */
        public String f34379d;

        /* renamed from: e  reason: collision with root package name */
        public String f34380e;

        /* renamed from: f  reason: collision with root package name */
        public String f34381f;

        /* renamed from: g  reason: collision with root package name */
        public String f34382g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f34383h;

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
                }
            }
        }

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                try {
                    bVar.f34376a = h.r.g(jSONObject, "mDownloadId");
                    bVar.f34377b = h.r.g(jSONObject, "mAdId");
                    bVar.f34378c = h.r.g(jSONObject, "mExtValue");
                    bVar.f34379d = jSONObject.optString("mPackageName");
                    bVar.f34380e = jSONObject.optString("mAppName");
                    bVar.f34381f = jSONObject.optString("mLogExtra");
                    bVar.f34382g = jSONObject.optString("mFileName");
                    bVar.f34383h = h.r.g(jSONObject, "mTimeStamp");
                    return bVar;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }

        public JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mDownloadId", this.f34376a);
                    jSONObject.put("mAdId", this.f34377b);
                    jSONObject.put("mExtValue", this.f34378c);
                    jSONObject.put("mPackageName", this.f34379d);
                    jSONObject.put("mAppName", this.f34380e);
                    jSONObject.put("mLogExtra", this.f34381f);
                    jSONObject.put("mFileName", this.f34382g);
                    jSONObject.put("mTimeStamp", this.f34383h);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public b(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, str2, str3, str4};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34376a = j2;
            this.f34377b = j3;
            this.f34378c = j4;
            this.f34379d = str;
            this.f34380e = str2;
            this.f34381f = str3;
            this.f34382g = str4;
        }
    }

    /* renamed from: c.p.a.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1520c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f34384a;

        /* renamed from: b  reason: collision with root package name */
        public long f34385b;

        /* renamed from: c  reason: collision with root package name */
        public String f34386c;

        /* renamed from: d  reason: collision with root package name */
        public String f34387d;

        /* renamed from: e  reason: collision with root package name */
        public String f34388e;

        /* renamed from: f  reason: collision with root package name */
        public String f34389f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f34390g;

        /* renamed from: h  reason: collision with root package name */
        public String f34391h;

        public C1520c() {
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
            this.f34390g = new ArrayList();
        }

        public static long b(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 > 0 ? j2 : j3 : invokeCommon.longValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b(this.f34384a, this.f34385b) : invokeV.longValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: c  reason: collision with root package name */
        public static int f34392c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f34393d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f34394e = 2;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34395a;

        /* renamed from: b  reason: collision with root package name */
        public int f34396b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1078548533, "Lc/p/a/d/b/c$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1078548533, "Lc/p/a/d/b/c$d;");
            }
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34395a = f34392c;
            this.f34396b = 0;
        }

        public d a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34395a = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34395a == f34393d : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34396b : invokeV.intValue;
        }

        public d d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f34396b = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f34397b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f34398c;

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f34399d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f34400a;

        /* loaded from: classes4.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final String f34401a;

            /* renamed from: b  reason: collision with root package name */
            public final int f34402b;

            /* renamed from: c  reason: collision with root package name */
            public final String f34403c;

            /* renamed from: d  reason: collision with root package name */
            public final String f34404d;

            /* renamed from: e  reason: collision with root package name */
            public final long f34405e;

            public /* synthetic */ b(String str, int i2, String str2, String str3, long j2, a aVar) {
                this(str, i2, str2, str3, j2);
            }

            public b(String str, int i2, String str2, String str3, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34401a = str;
                this.f34402b = i2;
                this.f34403c = str2 != null ? str2.toLowerCase() : null;
                this.f34404d = str3 != null ? str3.toLowerCase() : null;
                this.f34405e = j2;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1078548564, "Lc/p/a/d/b/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1078548564, "Lc/p/a/d/b/c$e;");
                    return;
                }
            }
            f34398c = new String[]{"com", "android", "ss"};
            f34399d = new int[]{3101, 3102, 3103, 3201, 3202, 3203};
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34400a = new LinkedList<>();
        }

        public static e b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f34397b == null) {
                    synchronized (e.class) {
                        if (f34397b == null) {
                            f34397b = new e();
                        }
                    }
                }
                return f34397b;
            }
            return (e) invokeV.objValue;
        }

        public static boolean d(String str, String str2) {
            InterceptResult invokeLL;
            String[] split;
            String[] split2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
                try {
                    split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (split.length != 0 && split2.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (String str3 : split) {
                        String[] strArr = f34398c;
                        int length = strArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                z = false;
                                break;
                            }
                            String str4 = strArr[i4];
                            if (str4.equals(str3)) {
                                if (i2 < split2.length && str4.equals(split2[i2])) {
                                    i2++;
                                }
                                z = true;
                            } else {
                                i4++;
                            }
                        }
                        if (!z) {
                            int i5 = i3;
                            int i6 = i2;
                            while (i2 < split2.length) {
                                if (str3.equals(split2[i2])) {
                                    if (i2 == i6) {
                                        i6++;
                                    }
                                    i5++;
                                    if (i5 >= 2) {
                                        return true;
                                    }
                                }
                                i2++;
                            }
                            i2 = i6;
                            i3 = i5;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public b a(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (bVar == null) {
                    return null;
                }
                f();
                synchronized (this.f34400a) {
                    Iterator<b> it = this.f34400a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.f34405e > bVar.z()) {
                            return next;
                        }
                    }
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }

        public void c(String str) {
            b h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                f();
                if (TextUtils.isEmpty(str) || (h2 = h(str)) == null) {
                    return;
                }
                synchronized (this.f34400a) {
                    this.f34400a.add(h2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
            r7[1] = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pair<b, Integer> e(c.p.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            int i2;
            b next;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                if (bVar == null) {
                    return null;
                }
                try {
                    f();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.f34400a.isEmpty()) {
                    return null;
                }
                String K = bVar.K();
                String e2 = bVar.e();
                String G = bVar.G();
                int F = bVar.F();
                int length = f34399d.length;
                b[] bVarArr = new b[length];
                synchronized (this.f34400a) {
                    Iterator<b> it = this.f34400a.iterator();
                    PackageInfo packageInfo = null;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        next = it.next();
                        if (next.f34405e >= bVar.z()) {
                            if (TextUtils.isEmpty(K)) {
                                if (packageInfo == null) {
                                    packageInfo = h.r.h(bVar);
                                }
                                if (packageInfo != null) {
                                    try {
                                        K = (String) l.a().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(K) && !TextUtils.isEmpty(next.f34404d)) {
                                K = K.toLowerCase();
                                if (K.equals(next.f34404d)) {
                                    bVarArr[0] = next;
                                    break;
                                } else if (K.contains(next.f34404d) || next.f34404d.contains(K)) {
                                    break;
                                }
                            }
                            if (TextUtils.isEmpty(e2)) {
                                if (packageInfo == null) {
                                    packageInfo = h.r.h(bVar);
                                }
                                if (packageInfo != null) {
                                    e2 = packageInfo.packageName;
                                }
                            }
                            if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f34401a)) {
                                e2 = e2.toLowerCase();
                                if (e2.contains(next.f34401a) || next.f34401a.contains(e2)) {
                                    break;
                                } else if (bVarArr[3] == null) {
                                    if (d(e2, next.f34401a)) {
                                        bVarArr[3] = next;
                                    }
                                }
                            }
                            if (bVarArr[4] == null) {
                                if (TextUtils.isEmpty(G)) {
                                    if (packageInfo == null) {
                                        packageInfo = h.r.h(bVar);
                                    }
                                    if (packageInfo != null) {
                                        G = packageInfo.versionName;
                                    }
                                }
                                if (!TextUtils.isEmpty(G) && !TextUtils.isEmpty(next.f34403c)) {
                                    G = G.toLowerCase();
                                    if (G.equals(next.f34403c)) {
                                        bVarArr[4] = next;
                                    }
                                }
                                if (bVarArr[5] == null) {
                                    if (F <= 0) {
                                        if (packageInfo == null) {
                                            packageInfo = h.r.h(bVar);
                                        }
                                        if (packageInfo != null) {
                                            F = packageInfo.versionCode;
                                        }
                                    }
                                    if (F == next.f34402b) {
                                        bVarArr[5] = next;
                                    }
                                }
                            }
                        }
                    }
                    bVarArr[2] = next;
                }
                for (i2 = 0; i2 < length; i2++) {
                    if (bVarArr[i2] != null) {
                        return new Pair<>(bVarArr[i2], Integer.valueOf(f34399d[i2]));
                    }
                }
                return null;
            }
            return (Pair) invokeL.objValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.f34400a) {
                    Iterator<b> it = this.f34400a.iterator();
                    while (it.hasNext() && currentTimeMillis - it.next().f34405e > 1800000) {
                        it.remove();
                    }
                }
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                f();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                synchronized (this.f34400a) {
                    Iterator<b> it = this.f34400a.iterator();
                    while (it.hasNext()) {
                        if (str.equals(it.next().f34401a)) {
                            it.remove();
                            return;
                        }
                    }
                }
            }
        }

        public final b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                try {
                    PackageManager packageManager = l.a().getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        return new b(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis(), null);
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements c.p.a.b.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f34406a;

        /* renamed from: b  reason: collision with root package name */
        public c.p.a.a.a.d.d f34407b;

        /* renamed from: c  reason: collision with root package name */
        public c.p.a.a.a.d.c f34408c;

        /* renamed from: d  reason: collision with root package name */
        public c.p.a.a.a.d.b f34409d;

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

        @Override // c.p.a.b.a.c.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34407b.a() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34407b.d() : invokeV.longValue;
        }

        @Override // c.p.a.b.a.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34407b.t() : invokeV.booleanValue;
        }

        @Override // c.p.a.b.a.c.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34407b.u() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34407b.v() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f34407b.x() != null) {
                    return this.f34407b.x().d();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34407b.z() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f34409d.b() == 2) {
                    return 2;
                }
                return this.f34407b.G();
            }
            return invokeV.intValue;
        }

        @Override // c.p.a.b.a.c.a
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34408c.a() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34408c.b() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34408c.o() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34407b.g() : invokeV.longValue;
        }

        @Override // c.p.a.b.a.c.a
        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f34408c.m() : invokeV.booleanValue;
        }

        @Override // c.p.a.b.a.c.a
        public List<String> n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34407b.y() : (List) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public Object o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f34408c.j() : invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f34408c.n() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f34409d.g() : invokeV.booleanValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f34407b.p() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public int s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.p.a.b.a.c.a
        public int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f34408c.k() : invokeV.intValue;
        }

        @Override // c.p.a.b.a.c.a
        public c.p.a.a.a.d.d u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f34407b : (c.p.a.a.a.d.d) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public c.p.a.a.a.d.c v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f34408c : (c.p.a.a.a.d.c) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public c.p.a.a.a.d.b w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f34409d : (c.p.a.a.a.d.b) invokeV.objValue;
        }

        public boolean x() {
            InterceptResult invokeV;
            c.p.a.a.a.d.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (this.f34406a == 0 || (dVar = this.f34407b) == null || this.f34408c == null || this.f34409d == null) {
                    return true;
                }
                return dVar.t() && this.f34406a <= 0;
            }
            return invokeV.booleanValue;
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                if (x()) {
                    return false;
                }
                if (this.f34407b.t()) {
                    c.p.a.a.a.d.d dVar = this.f34407b;
                    return (dVar instanceof c.p.a.b.a.a.c) && !TextUtils.isEmpty(dVar.u()) && (this.f34408c instanceof c.p.a.b.a.a.b) && (this.f34409d instanceof c.p.a.b.a.a.a);
                }
                return this.f34407b instanceof c.p.a.b.a.a.c;
            }
            return invokeV.booleanValue;
        }

        public f(long j2, @NonNull c.p.a.a.a.d.d dVar, @NonNull c.p.a.a.a.d.c cVar, @NonNull c.p.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), dVar, cVar, bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34406a = j2;
            this.f34407b = dVar;
            this.f34408c = cVar;
            this.f34409d = bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f34410a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.a.a.d.d> f34411b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.a.a.d.c> f34412c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.a.a.d.b> f34413d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.b.a.c.b> f34414e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f34415e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34415e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34415e.f34410a) {
                    return;
                }
                synchronized (g.class) {
                    if (!this.f34415e.f34410a) {
                        this.f34415e.f34414e.putAll(j.b().f());
                        this.f34415e.f34410a = true;
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static g f34416a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1398092244, "Lc/p/a/d/b/c$g$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1398092244, "Lc/p/a/d/b/c$g$b;");
                        return;
                    }
                }
                f34416a = new g(null);
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f34416a : (g) invokeV.objValue;
        }

        public c.p.a.a.a.d.d a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f34411b.get(Long.valueOf(j2)) : (c.p.a.a.a.d.d) invokeJ.objValue;
        }

        public c.p.a.b.a.c.b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                for (c.p.a.b.a.c.b bVar : this.f34414e.values()) {
                    if (bVar != null && bVar.s() == i2) {
                        return bVar;
                    }
                }
                return null;
            }
            return (c.p.a.b.a.c.b) invokeI.objValue;
        }

        public c.p.a.b.a.c.b c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo == null) {
                    return null;
                }
                for (c.p.a.b.a.c.b bVar : this.f34414e.values()) {
                    if (bVar != null && bVar.s() == downloadInfo.getId()) {
                        return bVar;
                    }
                }
                if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
                    try {
                        long g2 = h.r.g(new JSONObject(downloadInfo.getExtra()), "extra");
                        if (g2 != 0) {
                            for (c.p.a.b.a.c.b bVar2 : this.f34414e.values()) {
                                if (bVar2 != null && bVar2.b() == g2) {
                                    return bVar2;
                                }
                            }
                            f.e.b().d("getNativeModelByInfo");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                for (c.p.a.b.a.c.b bVar3 : this.f34414e.values()) {
                    if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                        return bVar3;
                    }
                }
                return null;
            }
            return (c.p.a.b.a.c.b) invokeL.objValue;
        }

        public c.p.a.b.a.c.b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                for (c.p.a.b.a.c.b bVar : this.f34414e.values()) {
                    if (bVar != null && str.equals(bVar.e())) {
                        return bVar;
                    }
                }
                return null;
            }
            return (c.p.a.b.a.c.b) invokeL.objValue;
        }

        @NonNull
        public Map<Long, c.p.a.b.a.c.b> f(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    for (c.p.a.b.a.c.b bVar : this.f34414e.values()) {
                        if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                            bVar.n0(str2);
                            hashMap.put(Long.valueOf(bVar.b()), bVar);
                        }
                    }
                }
                return hashMap;
            }
            return (Map) invokeLL.objValue;
        }

        public void g(long j2, c.p.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048581, this, j2, bVar) == null) || bVar == null) {
                return;
            }
            this.f34413d.put(Long.valueOf(j2), bVar);
        }

        public void h(long j2, c.p.a.a.a.d.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048582, this, j2, cVar) == null) || cVar == null) {
                return;
            }
            this.f34412c.put(Long.valueOf(j2), cVar);
        }

        public void i(c.p.a.a.a.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) || dVar == null) {
                return;
            }
            this.f34411b.put(Long.valueOf(dVar.d()), dVar);
            if (dVar.x() != null) {
                dVar.x().b(dVar.d());
                dVar.x().g(dVar.v());
            }
        }

        public synchronized void j(c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                synchronized (this) {
                    if (bVar == null) {
                        return;
                    }
                    this.f34414e.put(Long.valueOf(bVar.b()), bVar);
                    j.b().c(bVar);
                }
            }
        }

        public synchronized void k(List<Long> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
                synchronized (this) {
                    ArrayList arrayList = new ArrayList();
                    for (Long l : list) {
                        long longValue = l.longValue();
                        arrayList.add(String.valueOf(longValue));
                        this.f34414e.remove(Long.valueOf(longValue));
                    }
                    j.b().e(arrayList);
                }
            }
        }

        public c.p.a.a.a.d.c n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) ? this.f34412c.get(Long.valueOf(j2)) : (c.p.a.a.a.d.c) invokeJ.objValue;
        }

        public c.p.a.b.a.c.b o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                for (c.p.a.b.a.c.b bVar : this.f34414e.values()) {
                    if (bVar != null && str.equals(bVar.a())) {
                        return bVar;
                    }
                }
                return null;
            }
            return (c.p.a.b.a.c.b) invokeL.objValue;
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                c.p.a.d.e.a().d(new a(this), true);
            }
        }

        public void r(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            for (c.p.a.a.a.d.d dVar : this.f34411b.values()) {
                if ((dVar instanceof c.p.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((c.p.a.b.a.a.c) dVar).e(str2);
                }
            }
        }

        public c.p.a.a.a.d.b s(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) ? this.f34413d.get(Long.valueOf(j2)) : (c.p.a.a.a.d.b) invokeJ.objValue;
        }

        public ConcurrentHashMap<Long, c.p.a.b.a.c.b> t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f34414e : (ConcurrentHashMap) invokeV.objValue;
        }

        public c.p.a.b.a.c.b u(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) ? this.f34414e.get(Long.valueOf(j2)) : (c.p.a.b.a.c.b) invokeJ.objValue;
        }

        @NonNull
        public f v(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
                f fVar = new f();
                fVar.f34406a = j2;
                fVar.f34407b = a(j2);
                c.p.a.a.a.d.c n = n(j2);
                fVar.f34408c = n;
                if (n == null) {
                    fVar.f34408c = new c.p.a.a.a.d.h();
                }
                c.p.a.a.a.d.b s = s(j2);
                fVar.f34409d = s;
                if (s == null) {
                    fVar.f34409d = new c.p.a.a.a.d.g();
                }
                return fVar;
            }
            return (f) invokeJ.objValue;
        }

        public void w(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
                this.f34411b.remove(Long.valueOf(j2));
                this.f34412c.remove(Long.valueOf(j2));
                this.f34413d.remove(Long.valueOf(j2));
            }
        }

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
                    return;
                }
            }
            this.f34410a = false;
            this.f34411b = new ConcurrentHashMap<>();
            this.f34412c = new ConcurrentHashMap<>();
            this.f34413d = new ConcurrentHashMap<>();
            this.f34414e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34417a;

        /* renamed from: b  reason: collision with root package name */
        public int f34418b;

        /* renamed from: c  reason: collision with root package name */
        public String f34419c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public h(int i2) {
            this(i2, 0, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34417a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34418b : invokeV.intValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34419c : (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public h(int i2, int i3) {
            this(i2, i3, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public h(int i2, String str) {
            this(i2, 0, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public h(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f34417a = i2;
            this.f34418b = i3;
            this.f34419c = str;
        }
    }

    /* loaded from: classes4.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f34420a;
        public transient /* synthetic */ FieldHolder $fh;

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

        public static i a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f34420a == null) {
                    synchronized (e.class) {
                        if (f34420a == null) {
                            f34420a = new i();
                        }
                    }
                }
                return f34420a;
            }
            return (i) invokeV.objValue;
        }

        public void b(int i2, int i3, c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, bVar) == null) || bVar == null) {
                return;
            }
            c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(bVar.s());
            if (d2.b("report_api_hijack", 0) == 0) {
                return;
            }
            int i4 = i3 - i2;
            if (i2 <= 0 || i4 <= d2.b("check_api_hijack_version_code_diff", 500)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version_code_diff", i4);
                jSONObject.put("installed_version_code", i3);
                jSONObject.put("hijack_type", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().w("api_hijack", jSONObject, bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Collection f34421e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f34422f;

            public a(j jVar, Collection collection) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, collection};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34422f = jVar;
                this.f34421e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f34422f.g().edit();
                    for (c.p.a.b.a.c.b bVar : this.f34421e) {
                        if (bVar != null && bVar.b() != 0) {
                            edit.putString(String.valueOf(bVar.b()), bVar.g0().toString());
                        }
                    }
                    edit.apply();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f34423e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f34424f;

            public b(j jVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34424f = jVar;
                this.f34423e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f34424f.g().edit();
                    for (String str : this.f34423e) {
                        edit.remove(str);
                    }
                    edit.apply();
                }
            }
        }

        /* renamed from: c.p.a.d.b.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1521c {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static j f34425a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1398181648, "Lc/p/a/d/b/c$j$c;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1398181648, "Lc/p/a/d/b/c$j$c;");
                        return;
                    }
                }
                f34425a = new j(null);
            }
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1521c.f34425a : (j) invokeV.objValue;
        }

        public void c(c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar);
                d(arrayList);
            }
        }

        public synchronized void d(Collection<c.p.a.b.a.c.b> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
                synchronized (this) {
                    if (collection != null) {
                        if (!collection.isEmpty()) {
                            c.p.a.d.e.a().d(new a(this, collection), true);
                        }
                    }
                }
            }
        }

        public void e(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
                return;
            }
            c.p.a.d.e.a().d(new b(this, list), true);
        }

        @NonNull
        public ConcurrentHashMap<Long, c.p.a.b.a.c.b> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ConcurrentHashMap<Long, c.p.a.b.a.c.b> concurrentHashMap = new ConcurrentHashMap<>();
                Map<String, ?> all = g().getAll();
                if (all == null) {
                    return concurrentHashMap;
                }
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            long longValue = Long.valueOf(entry.getKey()).longValue();
                            c.p.a.b.a.c.b k0 = c.p.a.b.a.c.b.k0(new JSONObject(String.valueOf(entry.getValue())));
                            if (longValue > 0 && k0 != null) {
                                concurrentHashMap.put(Long.valueOf(longValue), k0);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return concurrentHashMap;
            }
            return (ConcurrentHashMap) invokeV.objValue;
        }

        public final SharedPreferences g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? l.a().getSharedPreferences("sp_ad_download_event", 0) : (SharedPreferences) invokeV.objValue;
        }

        public j() {
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
        this.f34374a = null;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34373b == null) {
                synchronized (c.class) {
                    if (f34373b == null) {
                        f34373b = new c();
                    }
                }
            }
            return f34373b;
        }
        return (c) invokeV.objValue;
    }

    public void b(Context context, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, downloadInfo) == null) && c() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f34374a == null) {
                this.f34374a = new Handler(Looper.getMainLooper());
            }
            String url = downloadInfo.getUrl();
            c.p.a.e.b.g.a.H(context).d(downloadInfo.getId());
            this.f34374a.post(new a(this, url));
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l.v().optInt("forbid_invalidte_download_file_install", 0) == 1 : invokeV.booleanValue;
    }
}
