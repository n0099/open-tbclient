package com.baidu.searchbox.live.interfaces.player.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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

    String fillLiveParams(String str, UrlType urlType, JSONObject jSONObject);

    String getMultiRateUrlByType(String str, JSONObject jSONObject, UrlType urlType, Boolean bool);

    PlayUrlData getPlayUrlBySchemeParams(String str);

    String transEtnUrl(String str);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$Companion;", "", "KEY_PLAY_CDN_TRACE_ID", "Ljava/lang/String;", "KEY_PLAY_CONFIG_PLAY_RATE", "PARAM_KABR_SPTS", "PARAM_URL", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_PLAY_CDN_TRACE_ID = "live_add_cdn_trace_id";
        public static final String KEY_PLAY_CONFIG_PLAY_RATE = "live_play_rate";
        public static final String PARAM_KABR_SPTS = "kabr_spts";
        public static final String PARAM_URL = "url";
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1992643741, "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1992643741, "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_PLAY_URL);
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return SERVICE_REFERENCE;
            }
            return (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public final UrlType component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.urlType : (UrlType) invokeV.objValue;
        }

        public final PlayUrlData copy(String str, UrlType urlType) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, urlType)) == null) ? new PlayUrlData(str, urlType) : (PlayUrlData) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof PlayUrlData) {
                        PlayUrlData playUrlData = (PlayUrlData) obj;
                        return Intrinsics.areEqual(this.url, playUrlData.url) && Intrinsics.areEqual(this.urlType, playUrlData.urlType);
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String str = this.url;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                UrlType urlType = this.urlType;
                return hashCode + (urlType != null ? urlType.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "PlayUrlData(url=" + this.url + ", urlType=" + this.urlType + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public PlayUrlData(String str, UrlType urlType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, urlType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
            this.urlType = urlType;
        }

        public /* synthetic */ PlayUrlData(String str, UrlType urlType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, urlType);
        }

        public final String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public final UrlType getUrlType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.urlType;
            }
            return (UrlType) invokeV.objValue;
        }

        public final void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.url = str;
            }
        }

        public final void setUrlType(UrlType urlType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, urlType) == null) {
                this.urlType = urlType;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "AVC", "HEVC", "RTC_AVC", "RTC_HEVC", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class UrlType {
        public static final /* synthetic */ UrlType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UrlType AVC;
        public static final UrlType HEVC;
        public static final UrlType RTC_AVC;
        public static final UrlType RTC_HEVC;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-740349568, "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-740349568, "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;");
                    return;
                }
            }
            UrlType urlType = new UrlType("AVC", 0);
            AVC = urlType;
            UrlType urlType2 = new UrlType("HEVC", 1);
            HEVC = urlType2;
            UrlType urlType3 = new UrlType("RTC_AVC", 2);
            RTC_AVC = urlType3;
            UrlType urlType4 = new UrlType("RTC_HEVC", 3);
            RTC_HEVC = urlType4;
            $VALUES = new UrlType[]{urlType, urlType2, urlType3, urlType4};
        }

        public static UrlType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UrlType) Enum.valueOf(UrlType.class, str) : (UrlType) invokeL.objValue;
        }

        public static UrlType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UrlType[]) $VALUES.clone() : (UrlType[]) invokeV.objValue;
        }

        public UrlType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }
}
