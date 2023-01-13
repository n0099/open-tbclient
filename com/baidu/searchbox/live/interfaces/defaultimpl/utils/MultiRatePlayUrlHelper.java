package com.baidu.searchbox.live.interfaces.defaultimpl.utils;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
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
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u0000:\u00014B\t\b\u0002¢\u0006\u0004\b2\u00103J+\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0012R\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0012R\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0012R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0012R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0012R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0012R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0012R%\u00101\u001a\n ,*\u0004\u0018\u00010+0+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper;", "Lorg/json/JSONObject;", "schemeMulti", "", "targetRank", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;", "targetType", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper$MultiRateData;", "getMultiDataByScheme", "(Lorg/json/JSONObject;ILcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService$UrlType;)Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper$MultiRateData;", "roomMultiRate", "getMultiRateDataByRoomInfo", "", "msg", "", "log", "(Ljava/lang/String;)V", "ABBR_BPS", "Ljava/lang/String;", "ABBR_FLV", "ABBR_FLV_AVC_LIST", "ABBR_FLV_HEVC_LIST", "ABBR_FLV_PREFIX", "ABBR_HEIGHT", "ABBR_NAME", "ABBR_PREFIX_DISABLE", "ABBR_RANK", "ABBR_RATE_NAME", "ABBR_RTC_AVC_LIST", "ABBR_RTC_HEVC_LIST", "ABBR_RTC_PREFIX", "ABBR_WIDTH", "BPS", "FLV", "FLV_AVC_LIST", "FLV_HEVC_LIST", "HEIGHT", "NAME", "RANK", "RATE_NAME", "RTC_AVC_LIST", "RTC_HEVC_LIST", "WIDTH", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "kotlin.jvm.PlatformType", "appService$delegate", "Lkotlin/Lazy;", "getAppService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService", "<init>", "()V", "MultiRateData", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MultiRatePlayUrlHelper {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ABBR_BPS = "b";
    public static final String ABBR_FLV = "f";
    public static final String ABBR_FLV_AVC_LIST = "la";
    public static final String ABBR_FLV_HEVC_LIST = "lh";
    public static final String ABBR_FLV_PREFIX = "p";
    public static final String ABBR_HEIGHT = "h";
    public static final String ABBR_NAME = "n";
    public static final String ABBR_PREFIX_DISABLE = "pd";
    public static final String ABBR_RANK = "r";
    public static final String ABBR_RATE_NAME = "ra";
    public static final String ABBR_RTC_AVC_LIST = "lr";
    public static final String ABBR_RTC_HEVC_LIST = "lrh";
    public static final String ABBR_RTC_PREFIX = "pr";
    public static final String ABBR_WIDTH = "w";
    public static final String BPS = "bps";
    public static final String FLV = "flv";
    public static final String FLV_AVC_LIST = "list_avc";
    public static final String FLV_HEVC_LIST = "list_hevc";
    public static final String HEIGHT = "height";
    public static final MultiRatePlayUrlHelper INSTANCE;
    public static final String NAME = "name";
    public static final String RANK = "rank";
    public static final String RATE_NAME = "rate_name";
    public static final String RTC_AVC_LIST = "list_rtc";
    public static final String RTC_HEVC_LIST = "list_rtc_hevc";
    public static final String WIDTH = "width";
    public static final Lazy appService$delegate;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            int[] iArr = new int[LivePlayUrlService.UrlType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LivePlayUrlService.UrlType.AVC.ordinal()] = 1;
            $EnumSwitchMapping$0[LivePlayUrlService.UrlType.HEVC.ordinal()] = 2;
            $EnumSwitchMapping$0[LivePlayUrlService.UrlType.RTC_AVC.ordinal()] = 3;
            $EnumSwitchMapping$0[LivePlayUrlService.UrlType.RTC_HEVC.ordinal()] = 4;
            int[] iArr2 = new int[LivePlayUrlService.UrlType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LivePlayUrlService.UrlType.AVC.ordinal()] = 1;
            $EnumSwitchMapping$1[LivePlayUrlService.UrlType.HEVC.ordinal()] = 2;
            $EnumSwitchMapping$1[LivePlayUrlService.UrlType.RTC_AVC.ordinal()] = 3;
            $EnumSwitchMapping$1[LivePlayUrlService.UrlType.RTC_HEVC.ordinal()] = 4;
            int[] iArr3 = new int[LivePlayUrlService.UrlType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[LivePlayUrlService.UrlType.AVC.ordinal()] = 1;
            $EnumSwitchMapping$2[LivePlayUrlService.UrlType.HEVC.ordinal()] = 2;
            $EnumSwitchMapping$2[LivePlayUrlService.UrlType.RTC_AVC.ordinal()] = 3;
            $EnumSwitchMapping$2[LivePlayUrlService.UrlType.RTC_HEVC.ordinal()] = 4;
        }
    }

    private final AppInfoService getAppService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Lazy lazy = appService$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (AppInfoService) lazy.getValue();
        }
        return (AppInfoService) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000BM\u0012\b\b\u0002\u0010\f\u001a\u00020\u0001\u0012\b\b\u0002\u0010\r\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJV\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\tR\"\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0003\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\u0003\"\u0004\b!\u0010\u001fR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010%R\"\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b&\u0010\u0003\"\u0004\b'\u0010\u001fR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010%R\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\"\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010%R\"\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b,\u0010\u0003\"\u0004\b-\u0010\u001f¨\u00060"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper$MultiRateData;", "", "component1", "()I", "component2", "component3", "component4", "", "component5", "()Ljava/lang/String;", "component6", "component7", MultiRatePlayUrlHelper.RANK, "width", "height", MultiRatePlayUrlHelper.BPS, "url", "name", "rateName", "copy", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper$MultiRateData;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "I", "getBps", "setBps", "(I)V", "getHeight", "setHeight", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getRank", "setRank", "getRateName", "setRateName", "getUrl", "setUrl", "getWidth", "setWidth", "<init>", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class MultiRateData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bps;
        public int height;
        public String name;
        public int rank;
        public String rateName;
        public String url;
        public int width;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MultiRateData() {
            this(0, 0, 0, 0, null, null, null, 127, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), (String) objArr[4], (String) objArr[5], (String) objArr[6], ((Integer) objArr[7]).intValue(), (DefaultConstructorMarker) objArr[8]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static /* synthetic */ MultiRateData copy$default(MultiRateData multiRateData, int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = multiRateData.rank;
            }
            if ((i5 & 2) != 0) {
                i2 = multiRateData.width;
            }
            int i6 = i2;
            if ((i5 & 4) != 0) {
                i3 = multiRateData.height;
            }
            int i7 = i3;
            if ((i5 & 8) != 0) {
                i4 = multiRateData.bps;
            }
            int i8 = i4;
            if ((i5 & 16) != 0) {
                str = multiRateData.url;
            }
            String str4 = str;
            if ((i5 & 32) != 0) {
                str2 = multiRateData.name;
            }
            String str5 = str2;
            if ((i5 & 64) != 0) {
                str3 = multiRateData.rateName;
            }
            return multiRateData.copy(i, i6, i7, i8, str4, str5, str3);
        }

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.rank : invokeV.intValue;
        }

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.width : invokeV.intValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.height : invokeV.intValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bps : invokeV.intValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.rateName : (String) invokeV.objValue;
        }

        public final MultiRateData copy(int i, int i2, int i3, int i4, String str, String str2, String str3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3})) == null) ? new MultiRateData(i, i2, i3, i4, str, str2, str3) : (MultiRateData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof MultiRateData) {
                        MultiRateData multiRateData = (MultiRateData) obj;
                        return this.rank == multiRateData.rank && this.width == multiRateData.width && this.height == multiRateData.height && this.bps == multiRateData.bps && Intrinsics.areEqual(this.url, multiRateData.url) && Intrinsics.areEqual(this.name, multiRateData.name) && Intrinsics.areEqual(this.rateName, multiRateData.rateName);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                int i = ((((((this.rank * 31) + this.width) * 31) + this.height) * 31) + this.bps) * 31;
                String str = this.url;
                int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.name;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.rateName;
                return hashCode2 + (str3 != null ? str3.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return "MultiRateData(rank=" + this.rank + ", width=" + this.width + ", height=" + this.height + ", bps=" + this.bps + ", url=" + this.url + ", name=" + this.name + ", rateName=" + this.rateName + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public MultiRateData(int i, int i2, int i3, int i4, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.rank = i;
            this.width = i2;
            this.height = i3;
            this.bps = i4;
            this.url = str;
            this.name = str2;
            this.rateName = str3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ MultiRateData(int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(r14, r1, r2, r0, r3, r4, r13);
            int i6;
            int i7;
            int i8;
            String str4;
            String str5;
            String str6;
            if ((i5 & 1) != 0) {
                i6 = 0;
            } else {
                i6 = i;
            }
            if ((i5 & 2) != 0) {
                i7 = 0;
            } else {
                i7 = i2;
            }
            if ((i5 & 4) != 0) {
                i8 = 0;
            } else {
                i8 = i3;
            }
            int i9 = (i5 & 8) == 0 ? i4 : 0;
            if ((i5 & 16) != 0) {
                str4 = "";
            } else {
                str4 = str;
            }
            if ((i5 & 32) != 0) {
                str5 = "";
            } else {
                str5 = str2;
            }
            if ((i5 & 64) != 0) {
                str6 = "";
            } else {
                str6 = str3;
            }
        }

        public final int getBps() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.bps;
            }
            return invokeV.intValue;
        }

        public final int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.height;
            }
            return invokeV.intValue;
        }

        public final String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public final int getRank() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.rank;
            }
            return invokeV.intValue;
        }

        public final String getRateName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.rateName;
            }
            return (String) invokeV.objValue;
        }

        public final String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public final int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.width;
            }
            return invokeV.intValue;
        }

        public final void setBps(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
                this.bps = i;
            }
        }

        public final void setHeight(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
                this.height = i;
            }
        }

        public final void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.name = str;
            }
        }

        public final void setRank(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
                this.rank = i;
            }
        }

        public final void setRateName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
                this.rateName = str;
            }
        }

        public final void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
                this.url = str;
            }
        }

        public final void setWidth(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
                this.width = i;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-121419981, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-121419981, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/utils/MultiRatePlayUrlHelper;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MultiRatePlayUrlHelper.class), "appService", "getAppService()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;"))};
        INSTANCE = new MultiRatePlayUrlHelper();
        appService$delegate = LazyKt__LazyJVMKt.lazy(MultiRatePlayUrlHelper$appService$2.INSTANCE);
    }

    public MultiRatePlayUrlHelper() {
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

    public final MultiRateData getMultiDataByScheme(JSONObject jSONObject, int i, LivePlayUrlService.UrlType urlType) {
        InterceptResult invokeLIL;
        String str;
        String str2;
        MultiRateData multiRateData;
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, jSONObject, i, urlType)) == null) {
            log("getMultiDataByScheme 开始：rank: " + i + ",type: " + urlType + ", schemeMulti: " + jSONObject);
            if (jSONObject == null) {
                log("getMultiDataByScheme 多码率参数为空，直接退出");
                return null;
            } else if (i < 0) {
                log("getMultiDataByScheme 档位数据异常，直接退出 " + i);
                return null;
            } else if (urlType == null) {
                log("getMultiDataByScheme 目标类型异常，直接退出 " + urlType);
                return null;
            } else {
                try {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[urlType.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    str = ABBR_RTC_HEVC_LIST;
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                str = ABBR_RTC_AVC_LIST;
                            }
                        } else {
                            str = ABBR_FLV_HEVC_LIST;
                        }
                    } else {
                        str = ABBR_FLV_AVC_LIST;
                    }
                    int i3 = WhenMappings.$EnumSwitchMapping$1[urlType.ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3 && i3 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str2 = "pr";
                    } else {
                        str2 = "p";
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(str);
                    String optString = jSONObject.optString(str2);
                    INSTANCE.log("getMultiDataByScheme 目标地址列表：" + optJSONArray);
                    INSTANCE.log("getMultiDataByScheme 目标地址前缀：" + optString);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            Object obj = optJSONArray.get(i4);
                            if (!(obj instanceof JSONObject)) {
                                obj = null;
                            }
                            JSONObject jSONObject2 = (JSONObject) obj;
                            if (jSONObject2 != null && jSONObject2.optInt("r") == i) {
                                multiRateData = new MultiRateData(0, 0, 0, 0, null, null, null, 127, null);
                                multiRateData.setRank(jSONObject2.optInt("r"));
                                multiRateData.setWidth(jSONObject2.optInt("w"));
                                multiRateData.setHeight(jSONObject2.optInt("h"));
                                multiRateData.setBps(jSONObject2.optInt("b"));
                                String optString2 = jSONObject2.optString("n");
                                Intrinsics.checkExpressionValueIsNotNull(optString2, "it.optString(ABBR_NAME)");
                                multiRateData.setName(optString2);
                                String optString3 = jSONObject2.optString(ABBR_RATE_NAME);
                                Intrinsics.checkExpressionValueIsNotNull(optString3, "it.optString(ABBR_RATE_NAME)");
                                multiRateData.setRateName(optString3);
                                if (jSONObject2.optInt("pd") == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                INSTANCE.log("getMultiDataByScheme 找到对应档位是否禁用前缀配置：" + z);
                                if (z) {
                                    str3 = jSONObject2.optString("f");
                                    Intrinsics.checkExpressionValueIsNotNull(str3, "it.optString(ABBR_FLV)");
                                } else {
                                    str3 = optString + jSONObject2.optString("f");
                                }
                                multiRateData.setUrl(str3);
                                INSTANCE.log("getMultiDataByScheme 拼接后地址：" + multiRateData.getUrl());
                            } else {
                                multiRateData = null;
                            }
                            if (multiRateData != null) {
                                INSTANCE.log("getMultiDataByScheme 对应档位起播数据解析成功，返回");
                                return multiRateData;
                            }
                        }
                        return null;
                    }
                    INSTANCE.log("getMultiDataByScheme 多码率参数中未找到 " + str + " 对应的多码率列表");
                    return null;
                } catch (Exception e) {
                    log("getMultiDataByScheme 解析多码率数据异常：" + e.getMessage());
                    return null;
                }
            }
        }
        return (MultiRateData) invokeLIL.objValue;
    }

    public final MultiRateData getMultiRateDataByRoomInfo(JSONObject jSONObject, int i, LivePlayUrlService.UrlType urlType) {
        InterceptResult invokeLIL;
        String str;
        MultiRateData multiRateData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i, urlType)) == null) {
            log("getMultiRateDataByRoomInfo 开始：rank: " + i + ",type: " + urlType + ", multiRate: " + jSONObject);
            if (jSONObject == null) {
                log("getMultiRateDataByRoomInfo 多码率参数为空，直接退出");
                return null;
            } else if (i < 0) {
                log("getMultiRateDataByRoomInfo 档位数据异常，直接退出 " + i);
                return null;
            } else if (urlType == null) {
                log("getMultiRateDataByRoomInfo 目标类型异常，直接退出 " + urlType);
                return null;
            } else {
                try {
                    int i2 = WhenMappings.$EnumSwitchMapping$2[urlType.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    str = RTC_HEVC_LIST;
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                str = RTC_AVC_LIST;
                            }
                        } else {
                            str = FLV_HEVC_LIST;
                        }
                    } else {
                        str = FLV_AVC_LIST;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(str);
                    INSTANCE.log("getMultiRateDataByRoomInfo 目标地址列表：" + optJSONArray);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            Object obj = optJSONArray.get(i3);
                            if (!(obj instanceof JSONObject)) {
                                obj = null;
                            }
                            JSONObject jSONObject2 = (JSONObject) obj;
                            if (jSONObject2 != null && jSONObject2.optInt(RANK) == i) {
                                multiRateData = new MultiRateData(0, 0, 0, 0, null, null, null, 127, null);
                                multiRateData.setRank(jSONObject2.optInt(RANK));
                                multiRateData.setWidth(jSONObject2.optInt("width"));
                                multiRateData.setHeight(jSONObject2.optInt("height"));
                                multiRateData.setBps(jSONObject2.optInt(BPS));
                                String optString = jSONObject2.optString("name");
                                Intrinsics.checkExpressionValueIsNotNull(optString, "it.optString(NAME)");
                                multiRateData.setName(optString);
                                String optString2 = jSONObject2.optString(RATE_NAME);
                                Intrinsics.checkExpressionValueIsNotNull(optString2, "it.optString(RATE_NAME)");
                                multiRateData.setRateName(optString2);
                                String optString3 = jSONObject2.optString("flv");
                                Intrinsics.checkExpressionValueIsNotNull(optString3, "it.optString(FLV)");
                                multiRateData.setUrl(optString3);
                                INSTANCE.log("getMultiRateDataByRoomInfo 目标档位地址：" + multiRateData.getUrl());
                            } else {
                                multiRateData = null;
                            }
                            if (multiRateData != null) {
                                INSTANCE.log("getMultiRateDataByRoomInfo 对应档位起播数据解析成功，返回");
                                return multiRateData;
                            }
                        }
                        return null;
                    }
                    INSTANCE.log("getMultiRateDataByRoomInfo 多码率参数中未找到 " + str + " 对应的多码率列表");
                    return null;
                } catch (Exception e) {
                    log("getMultiRateDataByRoomInfo 解析多码率数据异常：" + e.getMessage());
                    return null;
                }
            }
        }
        return (MultiRateData) invokeLIL.objValue;
    }

    public final void log(String str) {
        AppInfoService appService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (appService = getAppService()) != null && appService.isDebug() && !TextUtils.isEmpty(str)) {
            Log.i("LivePlayUrlService", String.valueOf(str));
        }
    }
}
