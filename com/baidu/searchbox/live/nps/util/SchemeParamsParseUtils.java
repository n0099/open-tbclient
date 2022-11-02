package com.baidu.searchbox.live.nps.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SchemeParamsParseUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SchemeParamsParseUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getParamsStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf <= 0) {
                return null;
            }
            return str.substring(indexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> paramsJsonToMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof String) {
                    hashMap.put(next, (String) opt);
                } else if (opt != null) {
                    hashMap.put(next, opt.toString());
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static HashMap<String, String> stringToMap(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                try {
                    String decode = URLDecoder.decode(split[0], "UTF-8");
                    if (split.length > 1) {
                        str2 = URLDecoder.decode(split[1], "UTF-8");
                    } else {
                        str2 = "";
                    }
                    hashMap.put(decode, str2);
                } catch (UnsupportedEncodingException unused) {
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r1v10. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, String> parseYYLiveParamMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            HashMap hashMap = new HashMap();
            HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
            Map map = stringToMap;
            if (stringToMap != null) {
                boolean containsKey = stringToMap.containsKey("params");
                map = stringToMap;
                if (containsKey) {
                    try {
                        String str2 = stringToMap.get("params");
                        if (str2 != null) {
                            map = paramsJsonToMap(new JSONObject(str2));
                        }
                    } catch (Exception unused) {
                    }
                    map = null;
                }
            }
            if (map != null) {
                String str3 = map.get("sid");
                String str4 = map.get(YyLiveRoomConfig.KEY_SSID);
                String str5 = map.get("anchorUid");
                String str6 = map.get("templateId");
                String str7 = map.get(YyLiveRoomConfig.KEY_STREAMINFO);
                if (str.contains("isMix=1")) {
                    hashMap.put("PreJoinChannelType", "mix");
                } else {
                    hashMap.put("PreJoinChannelType", "startYYLive");
                }
                hashMap.put("PreJoinChannelSid", str3);
                hashMap.put("PreJoinChannelSsid", str4);
                hashMap.put("PreJoinChannelTemplateId", str6);
                hashMap.put("PreJoinChannelAnchorId", str5);
                hashMap.put("PreJoinChannelStreamInfo", str7);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Uri setUriParam(Uri uri, List<Pair<String, String>> list, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, list, z)) == null) {
            if (uri != null && list != null && list.size() != 0) {
                HashSet<String> hashSet = new HashSet(uri.getQueryParameterNames());
                Uri.Builder clearQuery = uri.buildUpon().clearQuery();
                for (Pair<String, String> pair : list) {
                    if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                        boolean remove = hashSet.remove(pair.first);
                        if (remove && !z) {
                            try {
                                clearQuery.appendQueryParameter((String) pair.first, uri.getQueryParameter((String) pair.first));
                            } catch (Exception unused) {
                            }
                        } else if (!TextUtils.isEmpty((CharSequence) pair.second) || remove) {
                            if (!TextUtils.isEmpty((CharSequence) pair.second)) {
                                clearQuery.appendQueryParameter((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                }
                for (String str : hashSet) {
                    try {
                        clearQuery.appendQueryParameter(str, uri.getQueryParameter(str));
                    } catch (Exception unused2) {
                    }
                }
                return clearQuery.build();
            }
            return uri;
        }
        return (Uri) invokeLLZ.objValue;
    }
}
