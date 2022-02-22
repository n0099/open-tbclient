package c.a.y.g.d;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.y.g.g.e;
import c.a.y.g.g.k;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.framework.net.LiveNetwork;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final a f26930e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-288356949, "Lc/a/y/g/d/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-288356949, "Lc/a/y/g/d/b$a;");
                    return;
                }
            }
            f26930e = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL.intValue;
        }
    }

    /* renamed from: c.a.y.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1611b<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C1611b f26931e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-288356918, "Lc/a/y/g/d/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-288356918, "Lc/a/y/g/d/b$b;");
                    return;
                }
            }
            f26931e = new C1611b();
        }

        public C1611b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL.intValue;
        }
    }

    public static final Map<String, String> a(Map<String, String> map, Map<String, String> map2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, map, map2, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            hashMap.put("livefeed_sdk_version", "1.0.0");
            hashMap.put("npslist", k());
            if (z) {
                hashMap.put("sign", g(map, hashMap, map2));
            } else {
                hashMap.put("sign", h(map, hashMap, map2));
            }
            return hashMap;
        }
        return (Map) invokeLLZ.objValue;
    }

    public static /* synthetic */ Map b(Map map, Map map2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(map, map2, z);
    }

    public static final String c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
            String fullUrl = CommonUrlParamManager.getInstance().processUrl(str);
            if (map != null) {
                String a2 = k.a(fullUrl, map);
                Intrinsics.checkNotNullExpressionValue(a2, "UrlUtil.addParam(fullUrl, params)");
                return a2;
            }
            Intrinsics.checkNotNullExpressionValue(fullUrl, "fullUrl");
            return fullUrl;
        }
        return (String) invokeLL.objValue;
    }

    public static final StringBuffer d(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, stringBuffer, arrayList)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (!"sign".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append("=");
                        stringBuffer.append(value);
                        stringBuffer.append("&");
                    }
                }
            }
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static final StringBuffer e(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, stringBuffer, arrayList)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (!"sign".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append("=");
                        stringBuffer.append(value);
                    }
                }
            }
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static final <T> void f(String url, Map<String, String> post, c.a.y.g.d.a<T> callback, int i2, int i3, Map<String, String> map, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{url, post, callback, Integer.valueOf(i2), Integer.valueOf(i3), map, list}) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(post, "post");
            Intrinsics.checkNotNullParameter(callback, "callback");
            LiveNetwork liveNetwork = new LiveNetwork();
            String c2 = c(url, map);
            LiveFeedPageSdk f2 = LiveFeedPageSdk.f();
            Intrinsics.checkNotNullExpressionValue(f2, "LiveFeedPageSdk.getInstance()");
            if (f2.g() != null) {
                LiveFeedPageSdk f3 = LiveFeedPageSdk.f();
                Intrinsics.checkNotNullExpressionValue(f3, "LiveFeedPageSdk.getInstance()");
                c.a.y.d.b.c g2 = f3.g();
                Intrinsics.checkNotNullExpressionValue(g2, "LiveFeedPageSdk.getInstance().invoker");
                String iid = g2.getIID();
                if (!TextUtils.isEmpty(iid)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Intrinsics.checkNotNullExpressionValue(iid, "iid");
                    linkedHashMap.put("iid_bak", iid);
                    c2 = k.a(c2, linkedHashMap);
                    Intrinsics.checkNotNullExpressionValue(c2, "UrlUtil.addParam(fullUrl, iidParam)");
                }
            }
            Map b2 = b(post, l(c2), false, 4, null);
            liveNetwork.e(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i2)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i3))));
            liveNetwork.f(c2);
            liveNetwork.d(o(MapsKt__MapsKt.plus(new HashMap(b2), post)), callback, list);
        }
    }

    public static final String g(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, map, map2, map3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                arrayList.addAll(map.entrySet());
            }
            if (map2 != null) {
                arrayList.addAll(map2.entrySet());
            }
            if (map3 != null) {
                arrayList.addAll(map3.entrySet());
            }
            Collections.sort(arrayList, a.f26930e);
            StringBuffer stringBuffer = new StringBuffer(1024);
            e(stringBuffer, arrayList);
            stringBuffer.append("tiebaclient!!!");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "md5Source.toString()");
            Charset charset = Charsets.UTF_8;
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String b2 = e.b(bytes, true);
                Intrinsics.checkNotNullExpressionValue(b2, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLLL.objValue;
    }

    public static final String h(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, map, map2, map3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                arrayList.addAll(map.entrySet());
            }
            if (map2 != null) {
                arrayList.addAll(map2.entrySet());
            }
            if (map3 != null) {
                arrayList.addAll(map3.entrySet());
            }
            Collections.sort(arrayList, C1611b.f26931e);
            StringBuffer stringBuffer = new StringBuffer(1024);
            d(stringBuffer, arrayList);
            stringBuffer.append("CtmXzYPtdE58nCCcvqM0ectyqW3N5rfY");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "md5Source.toString()");
            Charset charset = Charsets.UTF_8;
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String b2 = e.b(bytes, true);
                Intrinsics.checkNotNullExpressionValue(b2, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLLL.objValue;
    }

    public static final int i(String pkg) {
        InterceptResult invokeL;
        c.a.y.g.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pkg)) == null) {
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            SparseArray<c.a.y.g.e.a> j2 = j(pkg);
            if (j2 == null || (aVar = j2.get(3)) == null) {
                return 0;
            }
            return aVar.a();
        }
        return invokeL.intValue;
    }

    public static final SparseArray<c.a.y.g.e.a> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null) {
                return m(bundleGroup);
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, String.valueOf(i(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME)));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static final Map<String, String> l(String fullUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, fullUrl)) == null) {
            Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
            return k.d(k.b(fullUrl));
        }
        return (Map) invokeL.objValue;
    }

    public static final SparseArray<c.a.y.g.e.a> m(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bundleInfoGroup)) == null) {
            SparseArray<c.a.y.g.e.a> sparseArray = new SparseArray<>();
            try {
                sparseArray.append(1, n(bundleInfoGroup.getBundleByType(1)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                sparseArray.append(2, n(bundleInfoGroup.getBundleByType(2)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                sparseArray.append(3, n(bundleInfoGroup.getBundleByType(3)));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final c.a.y.g.e.a n(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bundleInfo)) == null) {
            if (bundleInfo == null) {
                return null;
            }
            String packageName = bundleInfo.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "bundle.packageName");
            return new c.a.y.g.e.a(packageName, bundleInfo.getVersionCode(), bundleInfo.needForceUpdate(), bundleInfo.getExt());
        }
        return (c.a.y.g.e.a) invokeL.objValue;
    }

    public static final Map<String, String> o(Map<String, String> map) {
        InterceptResult invokeL;
        String key;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, map)) == null) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && (key = entry.getKey()) != null) {
                        hashMap.put(key, entry.getValue());
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
