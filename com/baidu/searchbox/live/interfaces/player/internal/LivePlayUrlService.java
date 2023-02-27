package com.baidu.searchbox.live.interfaces.player.internal;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018J/\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tJ;\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "Lkotlin/Any;", "", "url", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "urlType", "Lorg/json/JSONObject;", "schemeParams", "fillLiveParams", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;Lorg/json/JSONObject;)Ljava/lang/String;", "defaultUrl", "schemeMultiRate", "", "fromScheme", "getMultiRateUrlByType", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;Ljava/lang/Boolean;)Ljava/lang/String;", "params", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "getPlayUrlBySchemeParams", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "transEtnUrl", "(Ljava/lang/String;)Ljava/lang/String;", "Companion", "PlayUrlData", "UrlType", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LivePlayUrlService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String KEY_PLAY_CDN_TRACE_ID = "live_add_cdn_trace_id";
    public static final String KEY_PLAY_CONFIG_PLAY_RATE = "live_play_rate";
    public static final String PARAM_KABR_SPTS = "kabr_spts";
    public static final String PARAM_URL = "url";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "AVC", "HEVC", "RTC_AVC", "RTC_HEVC", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public enum UrlType {
        AVC,
        HEVC,
        RTC_AVC,
        RTC_HEVC
    }

    String fillLiveParams(String str, UrlType urlType, JSONObject jSONObject);

    String getMultiRateUrlByType(String str, JSONObject jSONObject, UrlType urlType, Boolean bool);

    PlayUrlData getPlayUrlBySchemeParams(String str);

    String transEtnUrl(String str);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$Companion;", "", "KEY_PLAY_CDN_TRACE_ID", "Ljava/lang/String;", "KEY_PLAY_CONFIG_PLAY_RATE", "PARAM_KABR_SPTS", "PARAM_URL", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final String KEY_PLAY_CDN_TRACE_ID = "live_add_cdn_trace_id";
        public static final String KEY_PLAY_CONFIG_PLAY_RATE = "live_play_rate";
        public static final String PARAM_KABR_SPTS = "kabr_spts";
        public static final String PARAM_URL = "url";
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_PLAY_URL);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ String getMultiRateUrlByType$default(LivePlayUrlService livePlayUrlService, String str, JSONObject jSONObject, UrlType urlType, Boolean bool, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    bool = Boolean.FALSE;
                }
                return livePlayUrlService.getMultiRateUrlByType(str, jSONObject, urlType, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMultiRateUrlByType");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000B\u001d\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0003\"\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "", "component1", "()Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "component2", "()Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "url", "urlType", "copy", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;)Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$PlayUrlData;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getUrl", "setUrl", "(Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "getUrlType", "setUrlType", "(Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;)V", "<init>", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class PlayUrlData {
        public String url;
        public UrlType urlType;

        public static /* synthetic */ PlayUrlData copy$default(PlayUrlData playUrlData, String str, UrlType urlType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = playUrlData.url;
            }
            if ((i & 2) != 0) {
                urlType = playUrlData.urlType;
            }
            return playUrlData.copy(str, urlType);
        }

        public final String component1() {
            return this.url;
        }

        public final UrlType component2() {
            return this.urlType;
        }

        public final PlayUrlData copy(String str, UrlType urlType) {
            return new PlayUrlData(str, urlType);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof PlayUrlData) {
                    PlayUrlData playUrlData = (PlayUrlData) obj;
                    return Intrinsics.areEqual(this.url, playUrlData.url) && Intrinsics.areEqual(this.urlType, playUrlData.urlType);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            UrlType urlType = this.urlType;
            return hashCode + (urlType != null ? urlType.hashCode() : 0);
        }

        public String toString() {
            return "PlayUrlData(url=" + this.url + ", urlType=" + this.urlType + SmallTailInfo.EMOTION_SUFFIX;
        }

        public PlayUrlData(String str, UrlType urlType) {
            this.url = str;
            this.urlType = urlType;
        }

        public /* synthetic */ PlayUrlData(String str, UrlType urlType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, urlType);
        }

        public final String getUrl() {
            return this.url;
        }

        public final UrlType getUrlType() {
            return this.urlType;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final void setUrlType(UrlType urlType) {
            this.urlType = urlType;
        }
    }
}
