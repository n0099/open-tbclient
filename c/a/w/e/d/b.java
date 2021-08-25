package c.a.w.e.d;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.w.e.g.e;
import c.a.w.e.g.k;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.live.framework.net.LiveNetwork;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final a f30436e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(914016687, "Lc/a/w/e/d/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(914016687, "Lc/a/w/e/d/b$a;");
                    return;
                }
            }
            f30436e = new a();
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

    public static final Map<String, String> a(Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, map, map2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            hashMap.put("livefeed_sdk_version", "1.0.0");
            hashMap.put("npslist", h());
            hashMap.put("sign", e(map, hashMap, map2));
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final String b(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
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

    public static final StringBuffer c(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, stringBuffer, arrayList)) == null) {
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

    public static final <T> void d(String url, Map<String, String> post, c.a.w.e.d.a<T> callback, int i2, int i3, Map<String, String> map, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{url, post, callback, Integer.valueOf(i2), Integer.valueOf(i3), map, list}) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(post, "post");
            Intrinsics.checkNotNullParameter(callback, "callback");
            LiveNetwork liveNetwork = new LiveNetwork();
            String b2 = b(url, map);
            Map<String, String> a2 = a(post, i(b2));
            liveNetwork.e(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i2)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i3))));
            liveNetwork.f(b2);
            liveNetwork.d(l(MapsKt__MapsKt.plus(new HashMap(a2), post)), callback, list);
        }
    }

    public static final String e(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, map2, map3)) == null) {
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
            Collections.sort(arrayList, a.f30436e);
            StringBuffer stringBuffer = new StringBuffer(1024);
            c(stringBuffer, arrayList);
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

    public static final int f(String pkg) {
        InterceptResult invokeL;
        c.a.w.e.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, pkg)) == null) {
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            SparseArray<c.a.w.e.e.a> g2 = g(pkg);
            if (g2 == null || (aVar = g2.get(3)) == null) {
                return 0;
            }
            return aVar.a();
        }
        return invokeL.intValue;
    }

    public static final SparseArray<c.a.w.e.e.a> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null) {
                return j(bundleGroup);
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, String.valueOf(f(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME)));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static final Map<String, String> i(String fullUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fullUrl)) == null) {
            Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
            return k.d(k.b(fullUrl));
        }
        return (Map) invokeL.objValue;
    }

    public static final SparseArray<c.a.w.e.e.a> j(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bundleInfoGroup)) == null) {
            SparseArray<c.a.w.e.e.a> sparseArray = new SparseArray<>();
            try {
                sparseArray.append(1, k(bundleInfoGroup.getBundleByType(1)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                sparseArray.append(2, k(bundleInfoGroup.getBundleByType(2)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                sparseArray.append(3, k(bundleInfoGroup.getBundleByType(3)));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final c.a.w.e.e.a k(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bundleInfo)) == null) {
            if (bundleInfo == null) {
                return null;
            }
            String packageName = bundleInfo.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "bundle.packageName");
            return new c.a.w.e.e.a(packageName, bundleInfo.getVersionCode(), bundleInfo.needForceUpdate(), bundleInfo.getExt());
        }
        return (c.a.w.e.e.a) invokeL.objValue;
    }

    public static final Map<String, String> l(Map<String, String> map) {
        InterceptResult invokeL;
        String key;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
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
