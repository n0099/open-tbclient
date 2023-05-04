package com.baidu.searchbox.live.impl;

import android.text.TextUtils;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.live.net.LiveNetwork;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tieba.gc0;
import com.baidu.tieba.sb0;
import com.baidu.webkit.sdk.WebChromeClient;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b$\u0010%JG\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJK\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b22\u0010\b\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e\u0018\u00010\rj\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e\u0018\u0001`\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0013\u001a\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u00012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/live/impl/LiveNpsGetSwitchManager;", "", "", "postParams", "urlParams", "addLiveCommonParameters", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "url", "params", "addLiveCommonToUrl", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "Ljava/lang/StringBuffer;", "md5Source", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addParamsToStringBuffer", "(Ljava/lang/StringBuffer;Ljava/util/ArrayList;)Ljava/lang/StringBuffer;", "commonParams", "genSignParamsStr", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;", "bduss", "Lcom/baidu/searchbox/live/impl/IMasterSwitchCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "getMasterSwitch", "(Ljava/lang/String;Lcom/baidu/searchbox/live/impl/IMasterSwitchCallback;)V", "fullUrl", "getUrlParamsFromUrl", "(Ljava/lang/String;)Ljava/util/Map;", "", "transformMap", "(Ljava/util/Map;)Ljava/util/Map;", "HOST_URL", "Ljava/lang/String;", "SIGN_SUFFIX", "<init>", "()V", "lib-live-getswitch-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveNpsGetSwitchManager {
    public static final String HOST_URL = "https://tiebac.baidu.com";
    public static final LiveNpsGetSwitchManager INSTANCE = new LiveNpsGetSwitchManager();
    public static final String SIGN_SUFFIX = "tiebaclient!!!";

    private final Map<String, String> addLiveCommonParameters(Map<String, String> map, Map<String, String> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.put("sdk_version", "4.3.3");
        hashMap.put("im_sdk_version", "1.3.262");
        hashMap.put("sign", genSignParamsStr(map, hashMap, map2));
        return hashMap;
    }

    private final String addLiveCommonToUrl(String str, Map<String, String> map) {
        String fullUrl = CommonUrlParamManager.getInstance().processUrl(str);
        if (map != null) {
            String a = gc0.a(fullUrl, map);
            Intrinsics.checkExpressionValueIsNotNull(a, "UrlUtil.addParam(fullUrl, params)");
            return a;
        }
        Intrinsics.checkExpressionValueIsNotNull(fullUrl, "fullUrl");
        return fullUrl;
    }

    private final StringBuffer addParamsToStringBuffer(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
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

    private final String genSignParamsStr(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>();
        if (map != null) {
            arrayList.addAll(map.entrySet());
        }
        if (map2 != null) {
            arrayList.addAll(map2.entrySet());
        }
        if (map3 != null) {
            arrayList.addAll(map3.entrySet());
        }
        Collections.sort(arrayList, new Comparator<Map.Entry<? extends String, ? extends String>>() { // from class: com.baidu.searchbox.live.impl.LiveNpsGetSwitchManager$genSignParamsStr$1
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
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            String md5 = Md5Utils.toMd5(bytes, true);
            Intrinsics.checkExpressionValueIsNotNull(md5, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
            return md5;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final Map<String, String> getUrlParamsFromUrl(String str) {
        return gc0.d(gc0.b(str));
    }

    private final Map<String, Object> transformMap(Map<String, String> map) {
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

    public final void getMasterSwitch(String str, final IMasterSwitchCallback iMasterSwitchCallback) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!TextUtils.isEmpty(str)) {
            linkedHashMap.put("bduss", str);
        }
        LiveNetwork liveNetwork = new LiveNetwork();
        liveNetwork.d(3);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/yylive/switch?", Arrays.copyOf(new Object[]{HOST_URL}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        String addLiveCommonToUrl = addLiveCommonToUrl(format, null);
        Map<String, String> addLiveCommonParameters = addLiveCommonParameters(linkedHashMap, getUrlParamsFromUrl(addLiveCommonToUrl));
        liveNetwork.c(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, 17), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, 136)));
        liveNetwork.e(addLiveCommonToUrl);
        liveNetwork.b(transformMap(MapsKt__MapsKt.plus(new HashMap(addLiveCommonParameters), linkedHashMap)), new sb0<LiveMasterSwitchBean>() { // from class: com.baidu.searchbox.live.impl.LiveNpsGetSwitchManager$getMasterSwitch$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.sb0
            public void onNetResponse(NetResponse netResponse, LiveMasterSwitchBean liveMasterSwitchBean) {
                String str2;
                if (netResponse != null && !netResponse.isSuccessful()) {
                    IMasterSwitchCallback iMasterSwitchCallback2 = IMasterSwitchCallback.this;
                    if (liveMasterSwitchBean != null) {
                        str2 = liveMasterSwitchBean.getErrmsg();
                    } else {
                        str2 = null;
                    }
                    iMasterSwitchCallback2.switchCallback(str2);
                } else if (liveMasterSwitchBean == null) {
                    IMasterSwitchCallback.this.switchCallback("error");
                } else {
                    IMasterSwitchCallback.this.switchCallback(liveMasterSwitchBean.getData().getShow_switch());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.sb0
            public LiveMasterSwitchBean onParseResponseInBackground(NetResponse netResponse) {
                if (netResponse != null && netResponse.isSuccessful()) {
                    String str2 = netResponse.decodedResponseStr;
                    Intrinsics.checkExpressionValueIsNotNull(str2, "res.decodedResponseStr");
                    if (!StringsKt__StringsJVMKt.isBlank(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(netResponse.decodedResponseStr);
                            int i = jSONObject.getInt("errno");
                            String errmsg = jSONObject.getString("errmsg");
                            String string = jSONObject.getJSONObject("data").getString("show_switch");
                            Intrinsics.checkExpressionValueIsNotNull(string, "dataBean.getString(\"show_switch\")");
                            Data data = new Data(string);
                            Intrinsics.checkExpressionValueIsNotNull(errmsg, "errmsg");
                            return new LiveMasterSwitchBean(data, errmsg, i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }
        });
    }
}
