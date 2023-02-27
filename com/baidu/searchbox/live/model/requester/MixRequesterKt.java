package com.baidu.searchbox.live.model.requester;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.live.arch.utils.MiniCommonUrlParamUtils;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.bd.BaiduIdentityService;
import com.baidu.searchbox.live.model.net.MixNetCallback;
import com.baidu.searchbox.live.model.net.MixNetwork;
import com.baidu.searchbox.live.service.MixRequestCommonParamsService;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.webkit.sdk.WebChromeClient;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\u001a5\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001aK\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\r\u001aO\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e26\u0010\u0005\u001a2\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011\u0018\u00010\u0010j\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0011\u0018\u0001`\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a-\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\r\u001a}\u0010 \u001a\u00020\u001f\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b \u0010!\u001a;\u0010#\u001a\u00020\u00002\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$\u001a3\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"0\u0011\u0018\u00010\u0010H\u0002¢\u0006\u0004\b%\u0010\u0014\u001aU\u0010'\u001a\u00020\u00002\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00042\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010(\u001a#\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00042\u0006\u0010)\u001a\u00020\u0000¢\u0006\u0004\b*\u0010+\u001a\u000f\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010-\u001a1\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\"0\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004H\u0002¢\u0006\u0004\b.\u0010/\"\u0016\u00100\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101\"\u0016\u00102\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00101¨\u00063"}, d2 = {"", "url", "", "isComponent", "", "params", "addCommonParameters", "(Ljava/lang/String;ZLjava/util/Map;)Ljava/lang/String;", "postParams", "urlParams", "addLiveCommonParameters", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "addLiveCommonToUrl", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "Ljava/lang/StringBuffer;", "md5Source", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addParamsToStringBuffer", "(Ljava/lang/StringBuffer;Ljava/util/ArrayList;)Ljava/lang/StringBuffer;", "addQueryParamsToUrl", ExifInterface.GPS_DIRECTION_TRUE, "post", "Lcom/baidu/searchbox/live/model/net/MixNetCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "from", "subFrom", "get", "postImmediate", "", "fetchData", "(Ljava/lang/String;Ljava/util/Map;Lcom/baidu/searchbox/live/model/net/MixNetCallback;IIZLjava/util/Map;Z)V", "", "genParamSign", "(Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;", "genParamsStringBuffer", "commonParams", "genSignParamsStr", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;", "fullUrl", "getUrlParamsFromUrl", "(Ljava/lang/String;)Ljava/util/Map;", "isParamSwitchOn", "()Z", "transformMap", "(Ljava/util/Map;)Ljava/util/Map;", "SIGN_SUFFIX", "Ljava/lang/String;", "SIGN_SUFFIX2", "lib-live-mini-shell_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixRequesterKt {
    public static final String SIGN_SUFFIX = "tiebaclient!!!";
    public static final String SIGN_SUFFIX2 = "CtmXzYPtdE58nCCcvqM0ectyqW3N5rfY";

    public static final String addCommonParameters(String str, boolean z, Map<String, String> map) {
        String fullUrl;
        if (z) {
            fullUrl = MiniCommonUrlParamUtils.appendParam(str);
        } else {
            BaiduIdentityService baiduIdentityService = (BaiduIdentityService) ServiceManager.getService(BaiduIdentityService.Companion.getSERVICE_REFERENCE());
            if (baiduIdentityService == null || (fullUrl = baiduIdentityService.processUrl(str)) == null) {
                fullUrl = str;
            }
        }
        if (map != null) {
            return MixUriUtilKt.addParam(str, map);
        }
        Intrinsics.checkExpressionValueIsNotNull(fullUrl, "fullUrl");
        return fullUrl;
    }

    public static final Map<String, String> addLiveCommonParameters(Map<String, String> map, Map<String, String> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.put("sdk_version", MiniPluginInfoHelper.INSTANCE.getSdkName());
        String version = BIMManager.getVersion();
        Intrinsics.checkExpressionValueIsNotNull(version, "BIMManager.getVersion()");
        hashMap.put("im_sdk_version", version);
        hashMap.put("nps_version_code", String.valueOf(MiniPluginInfoHelper.INSTANCE.getVersionCode("com.baidu.searchbox.livenps")));
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            hashMap.put(Constants.EXTRA_KEY_APP_VERSION_CODE, appInfoService.getVersionCode());
        }
        hashMap.put("sign", genSignParamsStr(map, hashMap, map2));
        return hashMap;
    }

    public static final String genParamSign(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            arrayList.addAll(map.entrySet());
        }
        if (map2 != null) {
            arrayList.addAll(map2.entrySet());
        }
        Collections.sort(arrayList, new Comparator<Map.Entry<? extends String, ? extends Object>>() { // from class: com.baidu.searchbox.live.model.requester.MixRequesterKt$genParamSign$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Map.Entry<? extends String, ? extends Object> entry, Map.Entry<? extends String, ? extends Object> entry2) {
                return compare2((Map.Entry<String, ? extends Object>) entry, (Map.Entry<String, ? extends Object>) entry2);
            }

            /* renamed from: compare  reason: avoid collision after fix types in other method */
            public final int compare2(Map.Entry<String, ? extends Object> entry, Map.Entry<String, ? extends Object> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        StringBuffer stringBuffer = new StringBuffer(1024);
        genParamsStringBuffer(stringBuffer, arrayList);
        stringBuffer.append("tiebaclient!!!");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "md5Source.toString()");
        Charset charset = Charsets.UTF_8;
        if (stringBuffer2 != null) {
            byte[] bytes = stringBuffer2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String md5 = MixMd5Utils.toMd5(bytes, true);
            Intrinsics.checkExpressionValueIsNotNull(md5, "MixMd5Utils.toMd5(md5Sou…ng().toByteArray(), true)");
            return md5;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String addLiveCommonToUrl(String str, Map<String, String> map) {
        String fullUrl = MiniCommonUrlParamUtils.appendParam(str);
        if (map != null) {
            Intrinsics.checkExpressionValueIsNotNull(fullUrl, "fullUrl");
            return MixUriUtilKt.addParam(fullUrl, map);
        }
        Intrinsics.checkExpressionValueIsNotNull(fullUrl, "fullUrl");
        return fullUrl;
    }

    public static final String addQueryParamsToUrl(String str, Map<String, String> map) {
        if (map != null) {
            return MixUriUtilKt.addParam(str, map);
        }
        return str;
    }

    public static final StringBuffer addParamsToStringBuffer(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = arrayList.iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (value == null) {
                    value = "";
                }
                if (!Intrinsics.areEqual("sign", key)) {
                    stringBuffer.append(key);
                    stringBuffer.append("=");
                    stringBuffer.append(value);
                }
            }
        }
        return stringBuffer;
    }

    public static final StringBuffer genParamsStringBuffer(StringBuffer stringBuffer, ArrayList<Map.Entry<String, Object>> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Map.Entry<String, Object>> it = arrayList.iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                Object value = next.getValue();
                if (!Intrinsics.areEqual("sign", key)) {
                    stringBuffer.append(key);
                    stringBuffer.append("=");
                    stringBuffer.append(value);
                }
            }
        }
        return stringBuffer;
    }

    public static final <T> void fetchData(String str, Map<String, String> map, MixNetCallback<T> mixNetCallback, int i, int i2, boolean z, Map<String, String> map2, boolean z2) {
        if (isParamSwitchOn()) {
            Map<String, Object> map3 = null;
            if (z) {
                MixNetwork mixNetwork = new MixNetwork();
                mixNetwork.setUrl(addQueryParamsToUrl(str, map2));
                mixNetwork.setExtra(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
                Map<String, String> urlParamsFromUrl = getUrlParamsFromUrl(addLiveCommonToUrl(str, null));
                MixRequestCommonParamsService mixRequestCommonParamsService = (MixRequestCommonParamsService) MixRequestServiceLocator.Companion.getGlobalService(MixRequestCommonParamsService.class);
                if (mixRequestCommonParamsService != null) {
                    map3 = mixRequestCommonParamsService.getCommonParams();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (urlParamsFromUrl != null) {
                    for (Map.Entry<String, String> entry : urlParamsFromUrl.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        linkedHashMap.put(key, value);
                    }
                }
                if (map3 != null) {
                    for (Map.Entry<String, Object> entry2 : map3.entrySet()) {
                        linkedHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
                for (Map.Entry<String, Object> entry3 : transformMap(map).entrySet()) {
                    linkedHashMap.put(entry3.getKey(), entry3.getValue());
                }
                linkedHashMap.put("sign", genParamSign(map2, linkedHashMap));
                mixNetwork.post(linkedHashMap, mixNetCallback, z2);
                return;
            }
            MixNetwork mixNetwork2 = new MixNetwork();
            mixNetwork2.setUrl(addQueryParamsToUrl(str, map2));
            mixNetwork2.setExtra(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
            Map<String, String> urlParamsFromUrl2 = getUrlParamsFromUrl(addCommonParameters(str, z, null));
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (urlParamsFromUrl2 != null) {
                for (Map.Entry<String, String> entry4 : urlParamsFromUrl2.entrySet()) {
                    String key2 = entry4.getKey();
                    String value2 = entry4.getValue();
                    if (value2 == null) {
                        value2 = "";
                    }
                    linkedHashMap2.put(key2, value2);
                }
            }
            for (Map.Entry<String, Object> entry5 : transformMap(map).entrySet()) {
                linkedHashMap2.put(entry5.getKey(), entry5.getValue());
            }
            mixNetwork2.post(linkedHashMap2, mixNetCallback, z2);
        } else if (z) {
            MixNetwork mixNetwork3 = new MixNetwork();
            String addLiveCommonToUrl = addLiveCommonToUrl(str, map2);
            Map<String, String> addLiveCommonParameters = addLiveCommonParameters(map, getUrlParamsFromUrl(addLiveCommonToUrl));
            mixNetwork3.setExtra(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
            mixNetwork3.setUrl(addLiveCommonToUrl);
            mixNetwork3.post(transformMap(MapsKt__MapsKt.plus(new HashMap(addLiveCommonParameters), map)), mixNetCallback, z2);
        } else {
            String addCommonParameters = addCommonParameters(str, z, map2);
            MixNetwork mixNetwork4 = new MixNetwork();
            mixNetwork4.setExtra(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
            mixNetwork4.setUrl(addCommonParameters);
            mixNetwork4.post(transformMap(map), mixNetCallback, z2);
        }
    }

    public static /* synthetic */ void fetchData$default(String str, Map map, MixNetCallback mixNetCallback, int i, int i2, boolean z, Map map2, boolean z2, int i3, Object obj) {
        int i4;
        int i5;
        boolean z3;
        Map map3;
        boolean z4;
        if ((i3 & 8) != 0) {
            i4 = 0;
        } else {
            i4 = i;
        }
        if ((i3 & 16) != 0) {
            i5 = 0;
        } else {
            i5 = i2;
        }
        if ((i3 & 32) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i3 & 64) != 0) {
            map3 = null;
        } else {
            map3 = map2;
        }
        if ((i3 & 128) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        fetchData(str, map, mixNetCallback, i4, i5, z3, map3, z4);
    }

    public static final String genSignParamsStr(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
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
        Collections.sort(arrayList, new Comparator<Map.Entry<? extends String, ? extends String>>() { // from class: com.baidu.searchbox.live.model.requester.MixRequesterKt$genSignParamsStr$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Map.Entry<? extends String, ? extends String> entry, Map.Entry<? extends String, ? extends String> entry2) {
                return compare2((Map.Entry<String, String>) entry, (Map.Entry<String, String>) entry2);
            }

            /* renamed from: compare  reason: avoid collision after fix types in other method */
            public final int compare2(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        StringBuffer stringBuffer = new StringBuffer(1024);
        addParamsToStringBuffer(stringBuffer, arrayList);
        stringBuffer.append("tiebaclient!!!");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "md5Source.toString()");
        Charset charset = Charsets.UTF_8;
        if (stringBuffer2 != null) {
            byte[] bytes = stringBuffer2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String md5 = MixMd5Utils.toMd5(bytes, true);
            Intrinsics.checkExpressionValueIsNotNull(md5, "MixMd5Utils.toMd5(md5Sou…ng().toByteArray(), true)");
            return md5;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final Map<String, String> getUrlParamsFromUrl(String str) {
        String params = MixUriUtilKt.getParams(str);
        if (params == null) {
            params = "";
        }
        return MixUriUtilKt.stringToMap(params);
    }

    public static final Map<String, Object> transformMap(Map<String, String> map) {
        String key;
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

    public static final boolean isParamSwitchOn() {
        AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
        if (abConfigService == null) {
            return false;
        }
        return abConfigService.getSwitch("live_request_param_android", false);
    }
}
