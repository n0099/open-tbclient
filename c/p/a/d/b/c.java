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
    public static volatile c f34611b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34612a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34613e;

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
            this.f34613e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.p().a(3, l.a(), null, "下载失败，请重试！", null, 0);
                c.p.a.d.b.g a2 = c.p.a.d.g.b().a(this.f34613e);
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
        public long f34614a;

        /* renamed from: b  reason: collision with root package name */
        public long f34615b;

        /* renamed from: c  reason: collision with root package name */
        public long f34616c;

        /* renamed from: d  reason: collision with root package name */
        public String f34617d;

        /* renamed from: e  reason: collision with root package name */
        public String f34618e;

        /* renamed from: f  reason: collision with root package name */
        public String f34619f;

        /* renamed from: g  reason: collision with root package name */
        public String f34620g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f34621h;

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
                    bVar.f34614a = h.r.g(jSONObject, "mDownloadId");
                    bVar.f34615b = h.r.g(jSONObject, "mAdId");
                    bVar.f34616c = h.r.g(jSONObject, "mExtValue");
                    bVar.f34617d = jSONObject.optString("mPackageName");
                    bVar.f34618e = jSONObject.optString("mAppName");
                    bVar.f34619f = jSONObject.optString("mLogExtra");
                    bVar.f34620g = jSONObject.optString("mFileName");
                    bVar.f34621h = h.r.g(jSONObject, "mTimeStamp");
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
                    jSONObject.put("mDownloadId", this.f34614a);
                    jSONObject.put("mAdId", this.f34615b);
                    jSONObject.put("mExtValue", this.f34616c);
                    jSONObject.put("mPackageName", this.f34617d);
                    jSONObject.put("mAppName", this.f34618e);
                    jSONObject.put("mLogExtra", this.f34619f);
                    jSONObject.put("mFileName", this.f34620g);
                    jSONObject.put("mTimeStamp", this.f34621h);
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
            this.f34614a = j2;
            this.f34615b = j3;
            this.f34616c = j4;
            this.f34617d = str;
            this.f34618e = str2;
            this.f34619f = str3;
            this.f34620g = str4;
        }
    }

    /* renamed from: c.p.a.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1523c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f34622a;

        /* renamed from: b  reason: collision with root package name */
        public long f34623b;

        /* renamed from: c  reason: collision with root package name */
        public String f34624c;

        /* renamed from: d  reason: collision with root package name */
        public String f34625d;

        /* renamed from: e  reason: collision with root package name */
        public String f34626e;

        /* renamed from: f  reason: collision with root package name */
        public String f34627f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f34628g;

        /* renamed from: h  reason: collision with root package name */
        public String f34629h;

        public C1523c() {
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
            this.f34628g = new ArrayList();
        }

        public static long b(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 > 0 ? j2 : j3 : invokeCommon.longValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b(this.f34622a, this.f34623b) : invokeV.longValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: c  reason: collision with root package name */
        public static int f34630c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f34631d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f34632e = 2;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34633a;

        /* renamed from: b  reason: collision with root package name */
        public int f34634b;

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
            this.f34633a = f34630c;
            this.f34634b = 0;
        }

        public d a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34633a = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34633a == f34631d : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34634b : invokeV.intValue;
        }

        public d d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f34634b = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f34635b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f34636c;

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f34637d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f34638a;

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
            public final String f34639a;

            /* renamed from: b  reason: collision with root package name */
            public final int f34640b;

            /* renamed from: c  reason: collision with root package name */
            public final String f34641c;

            /* renamed from: d  reason: collision with root package name */
            public final String f34642d;

            /* renamed from: e  reason: collision with root package name */
            public final long f34643e;

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
                this.f34639a = str;
                this.f34640b = i2;
                this.f34641c = str2 != null ? str2.toLowerCase() : null;
                this.f34642d = str3 != null ? str3.toLowerCase() : null;
                this.f34643e = j2;
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
            f34636c = new String[]{"com", "android", "ss"};
            f34637d = new int[]{3101, 3102, 3103, 3201, 3202, 3203};
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
            this.f34638a = new LinkedList<>();
        }

        public static e b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f34635b == null) {
                    synchronized (e.class) {
                        if (f34635b == null) {
                            f34635b = new e();
                        }
                    }
                }
                return f34635b;
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
                        String[] strArr = f34636c;
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
                synchronized (this.f34638a) {
                    Iterator<b> it = this.f34638a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.f34643e > bVar.z()) {
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
                synchronized (this.f34638a) {
                    this.f34638a.add(h2);
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
                if (this.f34638a.isEmpty()) {
                    return null;
                }
                String K = bVar.K();
                String e2 = bVar.e();
                String G = bVar.G();
                int F = bVar.F();
                int length = f34637d.length;
                b[] bVarArr = new b[length];
                synchronized (this.f34638a) {
                    Iterator<b> it = this.f34638a.iterator();
                    PackageInfo packageInfo = null;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        next = it.next();
                        if (next.f34643e >= bVar.z()) {
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
                            if (!TextUtils.isEmpty(K) && !TextUtils.isEmpty(next.f34642d)) {
                                K = K.toLowerCase();
                                if (K.equals(next.f34642d)) {
                                    bVarArr[0] = next;
                                    break;
                                } else if (K.contains(next.f34642d) || next.f34642d.contains(K)) {
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
                            if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f34639a)) {
                                e2 = e2.toLowerCase();
                                if (e2.contains(next.f34639a) || next.f34639a.contains(e2)) {
                                    break;
                                } else if (bVarArr[3] == null) {
                                    if (d(e2, next.f34639a)) {
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
                                if (!TextUtils.isEmpty(G) && !TextUtils.isEmpty(next.f34641c)) {
                                    G = G.toLowerCase();
                                    if (G.equals(next.f34641c)) {
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
                                    if (F == next.f34640b) {
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
                        return new Pair<>(bVarArr[i2], Integer.valueOf(f34637d[i2]));
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
                synchronized (this.f34638a) {
                    Iterator<b> it = this.f34638a.iterator();
                    while (it.hasNext() && currentTimeMillis - it.next().f34643e > 1800000) {
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
                synchronized (this.f34638a) {
                    Iterator<b> it = this.f34638a.iterator();
                    while (it.hasNext()) {
                        if (str.equals(it.next().f34639a)) {
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
        public long f34644a;

        /* renamed from: b  reason: collision with root package name */
        public c.p.a.a.a.d.d f34645b;

        /* renamed from: c  reason: collision with root package name */
        public c.p.a.a.a.d.c f34646c;

        /* renamed from: d  reason: collision with root package name */
        public c.p.a.a.a.d.b f34647d;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34645b.a() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34645b.d() : invokeV.longValue;
        }

        @Override // c.p.a.b.a.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34645b.t() : invokeV.booleanValue;
        }

        @Override // c.p.a.b.a.c.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34645b.u() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34645b.v() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f34645b.x() != null) {
                    return this.f34645b.x().d();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34645b.z() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f34647d.b() == 2) {
                    return 2;
                }
                return this.f34645b.G();
            }
            return invokeV.intValue;
        }

        @Override // c.p.a.b.a.c.a
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34646c.a() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34646c.b() : (String) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34646c.o() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34645b.g() : invokeV.longValue;
        }

        @Override // c.p.a.b.a.c.a
        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f34646c.m() : invokeV.booleanValue;
        }

        @Override // c.p.a.b.a.c.a
        public List<String> n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34645b.y() : (List) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public Object o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f34646c.j() : invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f34646c.n() : (JSONObject) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f34647d.g() : invokeV.booleanValue;
        }

        @Override // c.p.a.b.a.c.a
        public JSONObject r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f34645b.p() : (JSONObject) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f34646c.k() : invokeV.intValue;
        }

        @Override // c.p.a.b.a.c.a
        public c.p.a.a.a.d.d u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f34645b : (c.p.a.a.a.d.d) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public c.p.a.a.a.d.c v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f34646c : (c.p.a.a.a.d.c) invokeV.objValue;
        }

        @Override // c.p.a.b.a.c.a
        public c.p.a.a.a.d.b w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f34647d : (c.p.a.a.a.d.b) invokeV.objValue;
        }

        public boolean x() {
            InterceptResult invokeV;
            c.p.a.a.a.d.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (this.f34644a == 0 || (dVar = this.f34645b) == null || this.f34646c == null || this.f34647d == null) {
                    return true;
                }
                return dVar.t() && this.f34644a <= 0;
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
                if (this.f34645b.t()) {
                    c.p.a.a.a.d.d dVar = this.f34645b;
                    return (dVar instanceof c.p.a.b.a.a.c) && !TextUtils.isEmpty(dVar.u()) && (this.f34646c instanceof c.p.a.b.a.a.b) && (this.f34647d instanceof c.p.a.b.a.a.a);
                }
                return this.f34645b instanceof c.p.a.b.a.a.c;
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
            this.f34644a = j2;
            this.f34645b = dVar;
            this.f34646c = cVar;
            this.f34647d = bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f34648a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.a.a.d.d> f34649b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.a.a.d.c> f34650c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.a.a.d.b> f34651d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, c.p.a.b.a.c.b> f34652e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f34653e;

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
                this.f34653e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34653e.f34648a) {
                    return;
                }
                synchronized (g.class) {
                    if (!this.f34653e.f34648a) {
                        this.f34653e.f34652e.putAll(j.b().f());
                        this.f34653e.f34648a = true;
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static g f34654a;
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
                f34654a = new g(null);
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f34654a : (g) invokeV.objValue;
        }

        public c.p.a.a.a.d.d a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f34649b.get(Long.valueOf(j2)) : (c.p.a.a.a.d.d) invokeJ.objValue;
        }

        public c.p.a.b.a.c.b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                for (c.p.a.b.a.c.b bVar : this.f34652e.values()) {
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
                for (c.p.a.b.a.c.b bVar : this.f34652e.values()) {
                    if (bVar != null && bVar.s() == downloadInfo.getId()) {
                        return bVar;
                    }
                }
                if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
                    try {
                        long g2 = h.r.g(new JSONObject(downloadInfo.getExtra()), "extra");
                        if (g2 != 0) {
                            for (c.p.a.b.a.c.b bVar2 : this.f34652e.values()) {
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
                for (c.p.a.b.a.c.b bVar3 : this.f34652e.values()) {
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
                for (c.p.a.b.a.c.b bVar : this.f34652e.values()) {
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
                    for (c.p.a.b.a.c.b bVar : this.f34652e.values()) {
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
            this.f34651d.put(Long.valueOf(j2), bVar);
        }

        public void h(long j2, c.p.a.a.a.d.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048582, this, j2, cVar) == null) || cVar == null) {
                return;
            }
            this.f34650c.put(Long.valueOf(j2), cVar);
        }

        public void i(c.p.a.a.a.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) || dVar == null) {
                return;
            }
            this.f34649b.put(Long.valueOf(dVar.d()), dVar);
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
                    this.f34652e.put(Long.valueOf(bVar.b()), bVar);
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
                        this.f34652e.remove(Long.valueOf(longValue));
                    }
                    j.b().e(arrayList);
                }
            }
        }

        public c.p.a.a.a.d.c n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) ? this.f34650c.get(Long.valueOf(j2)) : (c.p.a.a.a.d.c) invokeJ.objValue;
        }

        public c.p.a.b.a.c.b o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                for (c.p.a.b.a.c.b bVar : this.f34652e.values()) {
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
            for (c.p.a.a.a.d.d dVar : this.f34649b.values()) {
                if ((dVar instanceof c.p.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((c.p.a.b.a.a.c) dVar).e(str2);
                }
            }
        }

        public c.p.a.a.a.d.b s(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) ? this.f34651d.get(Long.valueOf(j2)) : (c.p.a.a.a.d.b) invokeJ.objValue;
        }

        public ConcurrentHashMap<Long, c.p.a.b.a.c.b> t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f34652e : (ConcurrentHashMap) invokeV.objValue;
        }

        public c.p.a.b.a.c.b u(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) ? this.f34652e.get(Long.valueOf(j2)) : (c.p.a.b.a.c.b) invokeJ.objValue;
        }

        @NonNull
        public f v(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
                f fVar = new f();
                fVar.f34644a = j2;
                fVar.f34645b = a(j2);
                c.p.a.a.a.d.c n = n(j2);
                fVar.f34646c = n;
                if (n == null) {
                    fVar.f34646c = new c.p.a.a.a.d.h();
                }
                c.p.a.a.a.d.b s = s(j2);
                fVar.f34647d = s;
                if (s == null) {
                    fVar.f34647d = new c.p.a.a.a.d.g();
                }
                return fVar;
            }
            return (f) invokeJ.objValue;
        }

        public void w(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
                this.f34649b.remove(Long.valueOf(j2));
                this.f34650c.remove(Long.valueOf(j2));
                this.f34651d.remove(Long.valueOf(j2));
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
            this.f34648a = false;
            this.f34649b = new ConcurrentHashMap<>();
            this.f34650c = new ConcurrentHashMap<>();
            this.f34651d = new ConcurrentHashMap<>();
            this.f34652e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34655a;

        /* renamed from: b  reason: collision with root package name */
        public int f34656b;

        /* renamed from: c  reason: collision with root package name */
        public String f34657c;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34655a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34656b : invokeV.intValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34657c : (String) invokeV.objValue;
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
            this.f34655a = i2;
            this.f34656b = i3;
            this.f34657c = str;
        }
    }

    /* loaded from: classes4.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f34658a;
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
                if (f34658a == null) {
                    synchronized (e.class) {
                        if (f34658a == null) {
                            f34658a = new i();
                        }
                    }
                }
                return f34658a;
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
            public final /* synthetic */ Collection f34659e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f34660f;

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
                this.f34660f = jVar;
                this.f34659e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f34660f.g().edit();
                    for (c.p.a.b.a.c.b bVar : this.f34659e) {
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
            public final /* synthetic */ List f34661e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f34662f;

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
                this.f34662f = jVar;
                this.f34661e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f34662f.g().edit();
                    for (String str : this.f34661e) {
                        edit.remove(str);
                    }
                    edit.apply();
                }
            }
        }

        /* renamed from: c.p.a.d.b.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1524c {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static j f34663a;
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
                f34663a = new j(null);
            }
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1524c.f34663a : (j) invokeV.objValue;
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
        this.f34612a = null;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34611b == null) {
                synchronized (c.class) {
                    if (f34611b == null) {
                        f34611b = new c();
                    }
                }
            }
            return f34611b;
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
            if (this.f34612a == null) {
                this.f34612a = new Handler(Looper.getMainLooper());
            }
            String url = downloadInfo.getUrl();
            c.p.a.e.b.g.a.H(context).d(downloadInfo.getId());
            this.f34612a.post(new a(this, url));
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l.v().optInt("forbid_invalidte_download_file_install", 0) == 1 : invokeV.booleanValue;
    }
}
