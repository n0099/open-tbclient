package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService;
import com.baidu.searchbox.live.interfaces.service.ILivePlayEtnService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.codec.net.RFC1522Codec;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010 JC\u0010(\u001a\u0004\u0018\u00010\u00172\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.R%\u00105\u001a\n 0*\u0004\u0018\u00010/0/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R%\u0010:\u001a\n 0*\u0004\u0018\u000106068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePlayUrlServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "", "url", "", "compareEtnHost", "(Ljava/lang/String;)Z", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "urlType", "Lorg/json/JSONObject;", "schemeParams", "fillLiveParams", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;Lorg/json/JSONObject;)Ljava/lang/String;", "paramKey", "paramValue", "fillParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "defaultUrl", "schemeMultiRate", "fromScheme", "getMultiRateUrlByType", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;Ljava/lang/Boolean;)Ljava/lang/String;", "params", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "getPlayUrlBySchemeParams", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "roomMultiRate", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper$MultiRateData;", "getRoomInfoMultiData", "(Lorg/json/JSONObject;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;)Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper$MultiRateData;", "getSchemeMultiData", "isSupportAvc", "()Z", "isSupportHevc", "isSupportRtc", "playUrl", "avcUrl", "hevcUrl", "rtcUrl", "rtcHevcUrl", "selectUrlByDevice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "transEtnUrl", "(Ljava/lang/String;)Ljava/lang/String;", "", "userSelectedRank", "()I", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayEtnService;", "kotlin.jvm.PlatformType", "etnService$delegate", "Lkotlin/Lazy;", "getEtnService", "()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayEtnService;", "etnService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService$delegate", "getPluginManagerService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LivePlayUrlServiceImpl implements LivePlayUrlService {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePlayUrlServiceImpl.class), "pluginManagerService", "getPluginManagerService()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePlayUrlServiceImpl.class), "etnService", "getEtnService()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayEtnService;"))};
    public final Lazy pluginManagerService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<PluginInvokeService>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePlayUrlServiceImpl$pluginManagerService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PluginInvokeService invoke() {
            return (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        }
    });
    public final Lazy etnService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ILivePlayEtnService>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePlayUrlServiceImpl$etnService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILivePlayEtnService invoke() {
            return (ILivePlayEtnService) ServiceManager.getService(ILivePlayEtnService.Companion.getSERVICE_REFERENCE());
        }
    });

    private final ILivePlayEtnService getEtnService() {
        Lazy lazy = this.etnService$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ILivePlayEtnService) lazy.getValue();
    }

    private final PluginInvokeService getPluginManagerService() {
        Lazy lazy = this.pluginManagerService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PluginInvokeService) lazy.getValue();
    }

    private final boolean isSupportAvc() {
        Map<String, Object> mediaLivePlayConfig;
        PluginInvokeService pluginManagerService = getPluginManagerService();
        Object obj = null;
        if (pluginManagerService != null && (mediaLivePlayConfig = pluginManagerService.getMediaLivePlayConfig("is_support_avc", null)) != null) {
            obj = mediaLivePlayConfig.get("is_support_avc");
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    private final boolean isSupportHevc() {
        Map<String, Object> mediaLivePlayConfig;
        PluginInvokeService pluginManagerService = getPluginManagerService();
        Object obj = null;
        if (pluginManagerService != null && (mediaLivePlayConfig = pluginManagerService.getMediaLivePlayConfig("is_support_hevc", null)) != null) {
            obj = mediaLivePlayConfig.get("is_support_hevc");
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    private final boolean isSupportRtc() {
        Map<String, Object> mediaLivePlayConfig;
        PluginInvokeService pluginManagerService = getPluginManagerService();
        Object obj = null;
        if (pluginManagerService != null && (mediaLivePlayConfig = pluginManagerService.getMediaLivePlayConfig("is_support_rtc", null)) != null) {
            obj = mediaLivePlayConfig.get("is_support_rtc");
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    private final int userSelectedRank() {
        Object obj;
        Map<String, Object> mediaLivePlayConfig;
        PluginInvokeService pluginManagerService = getPluginManagerService();
        Integer num = null;
        if (pluginManagerService != null && (mediaLivePlayConfig = pluginManagerService.getMediaLivePlayConfig("user_selected_play_rank", null)) != null) {
            obj = mediaLivePlayConfig.get("user_selected_play_rank");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = obj;
        }
        Integer num2 = num;
        if (num2 != null) {
            return num2.intValue();
        }
        return -1;
    }

    private final boolean compareEtnHost(String str) {
        Object obj;
        Map<String, Object> mediaLivePlayConfig;
        PluginInvokeService pluginManagerService = getPluginManagerService();
        Boolean bool = null;
        if (pluginManagerService != null && (mediaLivePlayConfig = pluginManagerService.getMediaLivePlayConfig("compare_etn_host", MapsKt__MapsJVMKt.mapOf(new Pair("compare_etn_host", str)))) != null) {
            obj = mediaLivePlayConfig.get("compare_etn_host");
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = obj;
        }
        Boolean bool2 = bool;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService
    public String transEtnUrl(String str) {
        ILivePlayEtnService etnService;
        if (!compareEtnHost(str) || (etnService = getEtnService()) == null) {
            return null;
        }
        return etnService.transEtnUrl(str);
    }

    private final String fillParam(String str, String str2, String str3) {
        if (!StringsKt__StringsJVMKt.isBlank(str2) && !StringsKt__StringsJVMKt.isBlank(str3) && !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
                return str + '&' + str2 + '=' + str3;
            }
            return str + RFC1522Codec.SEP + str2 + '=' + str3;
        }
        return str;
    }

    private final MultiRatePlayUrlHelper.MultiRateData getRoomInfoMultiData(JSONObject jSONObject, LivePlayUrlService.UrlType urlType) {
        int userSelectedRank = userSelectedRank();
        if (userSelectedRank == -1) {
            MultiRatePlayUrlHelper multiRatePlayUrlHelper = MultiRatePlayUrlHelper.INSTANCE;
            multiRatePlayUrlHelper.log("getRoomInfoMultiData 用户记录档位为空，返回选中类型 type: " + urlType);
            return null;
        }
        return MultiRatePlayUrlHelper.INSTANCE.getMultiRateDataByRoomInfo(jSONObject, userSelectedRank, urlType);
    }

    private final MultiRatePlayUrlHelper.MultiRateData getSchemeMultiData(JSONObject jSONObject, LivePlayUrlService.UrlType urlType) {
        int userSelectedRank = userSelectedRank();
        if (userSelectedRank == -1) {
            MultiRatePlayUrlHelper multiRatePlayUrlHelper = MultiRatePlayUrlHelper.INSTANCE;
            multiRatePlayUrlHelper.log("getSchemeMultiData 用户记录档位为空，返回选中类型 type: " + urlType);
            return null;
        }
        return MultiRatePlayUrlHelper.INSTANCE.getMultiDataByScheme(jSONObject, userSelectedRank, urlType);
    }

    private final LivePlayUrlService.PlayUrlData selectUrlByDevice(String str, String str2, String str3, String str4, String str5) {
        LivePlayUrlService.UrlType urlType;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice paramsString: 无起播地址，返回 ");
            return null;
        }
        MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice : 开始处理起播地址，流地址： playUrl " + str + ", avcUrl " + str2 + ", hevcUrl " + str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "rtcUrl " + str4 + ", rtcHevcUrl " + str5);
        if (!TextUtils.isEmpty(str5) && isSupportRtc() && isSupportHevc()) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice preStartPlayer 使用 rtcHevc");
            urlType = LivePlayUrlService.UrlType.RTC_HEVC;
            str = str5;
        } else if (!TextUtils.isEmpty(str4) && isSupportRtc()) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice preStartPlayer 使用 rtc");
            urlType = LivePlayUrlService.UrlType.RTC_AVC;
            str = str4;
        } else if (!TextUtils.isEmpty(str3) && isSupportHevc()) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice preStartPlayer 使用 hevc");
            urlType = LivePlayUrlService.UrlType.HEVC;
            str = str3;
        } else if (!TextUtils.isEmpty(str2) && isSupportAvc()) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice preStartPlayer 使用 avc");
            urlType = LivePlayUrlService.UrlType.AVC;
            str = str2;
        } else {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice preStartPlayer 使用默认流地址");
            urlType = null;
        }
        if (TextUtils.isEmpty(str)) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice defaultUrl 无效，返回空，无起播地址");
            return null;
        } else if (urlType == null) {
            MultiRatePlayUrlHelper.INSTANCE.log("selectUrlByDevice urlType 无效，返回默认流地址: " + str);
            return new LivePlayUrlService.PlayUrlData(str, null);
        } else {
            return new LivePlayUrlService.PlayUrlData(str, urlType);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService
    public String fillLiveParams(String str, LivePlayUrlService.UrlType urlType, JSONObject jSONObject) {
        String str2;
        String str3;
        Object obj;
        Object obj2;
        String str4 = null;
        if (jSONObject != null) {
            str2 = jSONObject.optString("status");
        } else {
            str2 = null;
        }
        boolean areEqual = Intrinsics.areEqual("3", str2);
        if (jSONObject != null) {
            str3 = jSONObject.optString("kabr_spts");
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str)) {
            MultiRatePlayUrlHelper.INSTANCE.log("fillLiveParams 拼接前地址为空");
            return str;
        }
        MultiRatePlayUrlHelper.INSTANCE.log("fillLiveParams 拼接前流地址 " + str + ", type: " + urlType);
        Map<String, Object> mediaLivePlayConfig = getPluginManagerService().getMediaLivePlayConfig("live_play_rate", MapsKt__MapsJVMKt.mapOf(new Pair("kabr_spts", str3)));
        if (mediaLivePlayConfig != null) {
            obj = mediaLivePlayConfig.get("live_play_rate");
        } else {
            obj = null;
        }
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str5 = (String) obj;
        if (!areEqual && str3 != null && (!StringsKt__StringsJVMKt.isBlank(str3)) && str5 != null && (!StringsKt__StringsJVMKt.isBlank(str5)) && str != null && (!StringsKt__StringsJVMKt.isBlank(str)) && urlType != LivePlayUrlService.UrlType.RTC_AVC && urlType != LivePlayUrlService.UrlType.RTC_HEVC) {
            str = fillParam(str, "kabr_spts", str3);
        }
        MultiRatePlayUrlHelper.INSTANCE.log("fillLiveParams kabr_spts 拼接后地址： " + str + ", type: " + urlType);
        if (str != null && (!StringsKt__StringsJVMKt.isBlank(str)) && urlType != LivePlayUrlService.UrlType.RTC_AVC && urlType != LivePlayUrlService.UrlType.RTC_HEVC) {
            Map<String, Object> mediaLivePlayConfig2 = getPluginManagerService().getMediaLivePlayConfig("live_add_cdn_trace_id", MapsKt__MapsJVMKt.mapOf(new Pair("url", str)));
            if (mediaLivePlayConfig2 != null) {
                obj2 = mediaLivePlayConfig2.get("live_add_cdn_trace_id");
            } else {
                obj2 = null;
            }
            if (obj2 instanceof String) {
                str4 = obj2;
            }
            String str6 = str4;
            if (str6 != null) {
                str = str6;
            }
        }
        MultiRatePlayUrlHelper.INSTANCE.log("fillLiveParams 拼接后流地址 " + str + ", type: " + urlType);
        return str;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService
    public String getMultiRateUrlByType(String str, JSONObject jSONObject, LivePlayUrlService.UrlType urlType, Boolean bool) {
        MultiRatePlayUrlHelper.MultiRateData roomInfoMultiData;
        String str2;
        MultiRatePlayUrlHelper.INSTANCE.log("getMultiRateUrlByType 获取多码率起播地址：" + bool + StringUtil.ARRAY_ELEMENT_SEPARATOR + urlType);
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            roomInfoMultiData = getSchemeMultiData(jSONObject, urlType);
        } else {
            roomInfoMultiData = getRoomInfoMultiData(jSONObject, urlType);
        }
        if (roomInfoMultiData != null) {
            str2 = roomInfoMultiData.getUrl();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (roomInfoMultiData == null) {
                return null;
            }
            return roomInfoMultiData.getUrl();
        }
        return str;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService
    public LivePlayUrlService.PlayUrlData getPlayUrlBySchemeParams(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            MultiRatePlayUrlHelper.INSTANCE.log("getPlayUrlBySchemeParams params: 参数为空，返回");
            return null;
        }
        try {
            if (str == null) {
                Intrinsics.throwNpe();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("multirate");
            String optString2 = jSONObject2.optString("playUrl");
            if (TextUtils.isEmpty(optString)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(optString);
            }
            LivePlayUrlService.PlayUrlData selectUrlByDevice = selectUrlByDevice(optString2, getMultiRateUrlByType(jSONObject2.optString("avcUrl"), jSONObject, LivePlayUrlService.UrlType.AVC, Boolean.TRUE), getMultiRateUrlByType(jSONObject2.optString("hevcUrl"), jSONObject, LivePlayUrlService.UrlType.HEVC, Boolean.TRUE), getMultiRateUrlByType(jSONObject2.optString("rtcUrl"), jSONObject, LivePlayUrlService.UrlType.RTC_AVC, Boolean.TRUE), getMultiRateUrlByType(jSONObject2.optString("rtcHevcUrl"), jSONObject, LivePlayUrlService.UrlType.RTC_HEVC, Boolean.TRUE));
            if (selectUrlByDevice != null && !TextUtils.isEmpty(selectUrlByDevice.getUrl())) {
                String fillLiveParams = fillLiveParams(selectUrlByDevice.getUrl(), selectUrlByDevice.getUrlType(), jSONObject2);
                if (!TextUtils.isEmpty(fillLiveParams)) {
                    MultiRatePlayUrlHelper.INSTANCE.log("getPlayUrlBySchemeParams 返回最终地址：" + selectUrlByDevice.getUrlType() + StringUtil.ARRAY_ELEMENT_SEPARATOR + fillLiveParams);
                    return new LivePlayUrlService.PlayUrlData(fillLiveParams, selectUrlByDevice.getUrlType());
                }
                MultiRatePlayUrlHelper.INSTANCE.log("getPlayUrlBySchemeParams 默认起播地址获取失败");
                return null;
            }
            MultiRatePlayUrlHelper.INSTANCE.log("getPlayUrlBySchemeParams 多个类型流选择后为空，返回");
            return null;
        } catch (Exception e) {
            MultiRatePlayUrlHelper.INSTANCE.log("getPlayUrlBySchemeParams 获取地址异常，" + e.getMessage());
            return null;
        }
    }
}
