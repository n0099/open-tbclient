package c.b.c.a.a.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC1446a f31365a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31366b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.b.c.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1446a {
        boolean a();

        boolean b();

        boolean c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2083778507, "Lc/b/c/a/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2083778507, "Lc/b/c/a/a/a/a;");
        }
    }

    public static Uri a(String str, String str2, int i2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, str5})) == null) {
            StringBuilder sb = new StringBuilder();
            if (str2 != null) {
                if (str != null) {
                    sb.append(str);
                    sb.append("://");
                }
                sb.append(str2);
                if (i2 > 0) {
                    sb.append(':');
                    sb.append(i2);
                }
            }
            if (str3 == null || !str3.startsWith("/")) {
                sb.append('/');
            }
            if (str3 != null) {
                sb.append(str3);
            }
            if (str4 != null) {
                sb.append('?');
                sb.append(str4);
            }
            if (str5 != null) {
                sb.append('#');
                sb.append(str5);
            }
            return Uri.parse(sb.toString());
        }
        return (Uri) invokeCommon.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str2 == null) {
                str2 = "ISO-8859-1";
            }
            try {
                return URLEncoder.encode(str, str2);
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (TextUtils.isEmpty(str) || f31365a == null || f31366b) {
                return str;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Uri parse = Uri.parse(str);
                e(parse, linkedHashMap);
                LinkedList linkedList = new LinkedList();
                f(linkedHashMap, linkedList, "device_id");
                f(linkedHashMap, linkedList, HttpConstants.DEVICE_TYPE);
                f(linkedHashMap, linkedList, "device_brand");
                f(linkedHashMap, linkedList, "uuid");
                f(linkedHashMap, linkedList, "openudid");
                String d2 = d(linkedList, false, "UTF-8");
                if (TextUtils.isEmpty(d2)) {
                    return str;
                }
                byte[] bytes = d2.getBytes();
                byte[] a2 = TTEncryptUtils.a(bytes, bytes.length);
                if (a2 == null) {
                    return str;
                }
                String encodeToString = Base64.encodeToString(a2, 2);
                LinkedList linkedList2 = new LinkedList();
                if (f31365a.a()) {
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(encodeToString);
                    linkedList2.add(new Pair("ss_queries", linkedList3));
                }
                if (f31365a.b() && list != null) {
                    list.add(new Pair<>("X-SS-QUERIES", b(encodeToString, "UTF-8")));
                }
                if (!linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        if (entry != null) {
                            linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                        }
                    }
                }
                return a(parse.getScheme(), parse.getHost(), parse.getPort(), parse.getPath(), d(linkedList2, true, "UTF-8"), parse.getFragment()).toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String d(List<Pair<String, List<String>>> list, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{list, Boolean.valueOf(z), str})) == null) {
            StringBuilder sb = new StringBuilder();
            for (Pair<String, List<String>> pair : list) {
                Object obj = pair.first;
                String str2 = (String) obj;
                if (z) {
                    str2 = b((String) obj, str);
                }
                List<String> list2 = (List) pair.second;
                if (list2 != null && list2.size() > 0) {
                    for (String str3 : list2) {
                        if (z) {
                            str3 = str3 != null ? b(str3, str) : "";
                        }
                        if (sb.length() > 0) {
                            sb.append("&");
                        }
                        sb.append(str2);
                        sb.append("=");
                        sb.append(str3);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void e(Uri uri, Map<String, List<String>> map) throws IOException {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, uri, map) == null) {
            if (uri == null) {
                throw new IOException("parseUrl url is null !!!");
            }
            if (map != null) {
                try {
                    String query = uri.getQuery();
                    if (query != null) {
                        for (String str : query.split("&")) {
                            int indexOf = str.indexOf("=");
                            if (indexOf >= 0) {
                                String decode = URLDecoder.decode(str.substring(0, indexOf), "UTF-8");
                                List<String> list = map.get(decode);
                                if (list == null) {
                                    list = new LinkedList<>();
                                }
                                list.add(URLDecoder.decode(str.substring(indexOf + 1), "UTF-8"));
                                map.put(decode, list);
                            } else {
                                String decode2 = URLDecoder.decode(str, "UTF-8");
                                List<String> list2 = map.get(decode2);
                                if (list2 == null) {
                                    list2 = new LinkedList<>();
                                }
                                list2.add("");
                                map.put(decode2, list2);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    throw new IOException("parseUrl url is null !!!");
                }
            }
        }
    }

    public static boolean f(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, map, list, str)) == null) {
            if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
                return false;
            }
            list.add(new Pair<>(str, map.get(str)));
            if (f31365a.c()) {
                return true;
            }
            map.remove(str);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
