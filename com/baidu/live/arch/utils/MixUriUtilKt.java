package com.baidu.live.arch.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a%\u0010\r\u001a\u00020\u00002\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a?\u0010\u001a\u001a\u0004\u0018\u00010\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u001c\u0010\u0017\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0016\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b\u001a?\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001c2\u001c\u0010\u0017\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0016\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00112\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"", "url", "", "params", "addParam", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "buildScheme", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getParams", "(Ljava/lang/String;)Ljava/lang/String;", "getParamsStr", "mapToString", "(Ljava/util/Map;)Ljava/lang/String;", "Lorg/json/JSONObject;", "input", "", "paramsJsonToMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "uri", "", "Lkotlin/Pair;", "kv", "", "isOver", "setSchemeParam", "(Ljava/lang/String;Ljava/util/List;Z)Ljava/lang/String;", "Landroid/net/Uri;", "setUriParam", "(Landroid/net/Uri;Ljava/util/List;Z)Landroid/net/Uri;", "stringToMap", "(Ljava/lang/String;)Ljava/util/Map;", "lib-live-mini-arch_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixUriUtilKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String addParam(String str, Map map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String mapToString = mapToString(map);
                if (!TextUtils.isEmpty(mapToString)) {
                    if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
                        return str + '&' + mapToString;
                    }
                    return str + '?' + mapToString;
                }
                return str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static final String buildScheme(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format = String.format("{\"roomId\":\"%s\", \"source\":\"%s\"}", Arrays.copyOf(new Object[]{str, str2}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                String format2 = String.format("baiduboxapp://v14/live/enterRoom?upgrade=0&params=%s", Arrays.copyOf(new Object[]{URLEncoder.encode(format, "UTF-8")}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                return format2;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static final String getParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "?", 0, false, 6, (Object) null);
                if (indexOf$default <= 0) {
                    return null;
                }
                String substring = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String getParamsStr(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "?", 0, false, 6, (Object) null);
                if (indexOf$default > 0) {
                    str2 = str.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).substring(startIndex)");
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    return "";
                }
                return str2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final String mapToString(Map map) {
        InterceptResult invokeL;
        boolean z;
        String encode;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (sb.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    sb.append("&");
                }
                String str3 = (String) map.get(str2);
                if (str2 == null) {
                    encode = "";
                } else {
                    try {
                        encode = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                sb.append(encode);
                sb.append("=");
                if (str3 == null) {
                    str = "";
                } else {
                    str = URLEncoder.encode(str3, "UTF-8");
                }
                sb.append(str);
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "stringBuilder.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public static final Map stringToMap(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str)) {
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    for (String str3 : (String[]) array) {
                        Object[] array2 = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr = (String[]) array2;
                            try {
                                String decode = URLDecoder.decode(strArr[0], "UTF-8");
                                Intrinsics.checkExpressionValueIsNotNull(decode, "URLDecoder.decode(nameValue[0], \"UTF-8\")");
                                if (strArr.length > 1) {
                                    str2 = URLDecoder.decode(strArr[1], "UTF-8");
                                } else {
                                    str2 = "";
                                }
                                linkedHashMap.put(decode, str2);
                            } catch (UnsupportedEncodingException unused) {
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static final Map paramsJsonToMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object opt = jSONObject.opt(key);
                if (opt instanceof String) {
                    Intrinsics.checkExpressionValueIsNotNull(key, "key");
                    linkedHashMap.put(key, opt);
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(key, "key");
                    if (opt != null) {
                        str = opt.toString();
                    } else {
                        str = null;
                    }
                    linkedHashMap.put(key, str);
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:
        if (r5.length() == 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String setSchemeParam(String str, List list, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        boolean z3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, str, list, z)) == null) {
            boolean z4 = false;
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                if (list != null && !list.isEmpty()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!z3) {
                    try {
                        Uri uriParam = setUriParam(Uri.parse(str), list, z);
                        if (uriParam != null) {
                            str2 = uriParam.toString();
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                        }
                        z4 = true;
                        if (!z4) {
                            return str2;
                        }
                        return str;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return str;
                    }
                }
                return str;
            }
            return str;
        }
        return (String) invokeLLZ.objValue;
    }

    public static final Uri setUriParam(Uri uri, List list, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, uri, list, z)) == null) {
            if (uri != null) {
                if (list != null && !list.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    Set<String> srcPrama = uri.getQueryParameterNames();
                    Intrinsics.checkExpressionValueIsNotNull(srcPrama, "srcPrama");
                    Set<String> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(srcPrama);
                    Uri.Builder clearQuery = uri.buildUpon().clearQuery();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        if (((CharSequence) pair.getFirst()).length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            boolean remove = mutableSet.remove(pair.getFirst());
                            if (remove && !z) {
                                try {
                                    clearQuery.appendQueryParameter((String) pair.getFirst(), uri.getQueryParameter((String) pair.getFirst()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                CharSequence charSequence = (CharSequence) pair.getSecond();
                                if (charSequence != null && charSequence.length() != 0) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (!z4 || remove) {
                                    CharSequence charSequence2 = (CharSequence) pair.getSecond();
                                    if (charSequence2 != null && charSequence2.length() != 0) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    if (!z5) {
                                        try {
                                            clearQuery.appendQueryParameter((String) pair.getFirst(), (String) pair.getSecond());
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (String str : mutableSet) {
                        try {
                            clearQuery.appendQueryParameter(str, uri.getQueryParameter(str));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return clearQuery.build();
                }
                return uri;
            }
            return uri;
        }
        return (Uri) invokeLLZ.objValue;
    }
}
