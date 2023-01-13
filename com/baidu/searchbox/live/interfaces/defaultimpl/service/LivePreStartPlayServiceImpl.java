package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService;
import com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
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
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 82\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b7\u0010\u0017J#\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0017R\u001e\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR%\u0010\"\u001a\n \u001a*\u0004\u0018\u00010\u001d0\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u001e\u0010)\u001a\n \u001a*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R%\u0010/\u001a\n \u001a*\u0004\u0018\u00010+0+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010.R%\u00104\u001a\n \u001a*\u0004\u0018\u000100008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103R\u0018\u0010\u0015\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00106¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "", "roomId", "source", "buildExtLog", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "params", "", "createAndStartPlayer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "cacheKey", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "getPreStartPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "isLiveNpsSupportPreStart", "()Z", "msg", "", "log", "(Ljava/lang/String;)V", "preStartPlayer", "releasePreStartPlayer", "()V", "resetTimeoutWork", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService$delegate", "Lkotlin/Lazy;", "getAppService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService", "Landroid/os/Handler;", "mainHandler$delegate", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "playUrlService", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService$delegate", "getPlayerService", "()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService$delegate", "getPluginManagerService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "<init>", "Companion", "PreStartPlayer", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LivePreStartPlayServiceImpl implements LivePreStartPlayerService {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AB_PRE_START_PLAYER_SWITCH = "android_live_media_pre_start_player_switch";
    public static final Companion Companion;
    public static final int ENABLE_ERROR_NO_CONVERT = 2013;
    public static final int FORMAT_KEY = 114;
    public static final int K_LIVE_PLAY_RATE_SETTING = 2014;
    public static final int K_RTC_MEDIA_HEVC_TYPE = 2015;
    public static final int K_RTC_MEDIA_SERVER_IP = 2010;
    public static final String LIVE_NPS = "com.baidu.searchbox.livenps";
    public static final int LIVE_PLUGIN_SUPPORT_PRE_START_PLAYER_MIM_VERSION = 601500000;
    public static final String LIVE_STATE_BACK = "3";
    public static final String LIVE_TEMPLATE_AUDIO = "5";
    public static final String LIVE_TEMPLATE_DATE = "7";
    public static final long PLAYER_TIME_OUT_DURATION = 6000;
    public static final int V_MEDIA_SOURCE_TYPE_DEF = 0;
    public static final int V_MEDIA_SOURCE_TYPE_DURTC = 2;
    public static final int V_MEDIA_SOURCE_TYPE_PLAYBACK = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbConfigService abService;
    public final Lazy appService$delegate;
    public final Lazy mainHandler$delegate;
    public final LivePlayUrlService playUrlService;
    public final Lazy playerService$delegate;
    public final Lazy pluginManagerService$delegate;
    public PreStartPlayer preStartPlayer;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            int[] iArr = new int[LivePlayUrlService.UrlType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LivePlayUrlService.UrlType.RTC_HEVC.ordinal()] = 1;
            int[] iArr2 = new int[LivePlayUrlService.UrlType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LivePlayUrlService.UrlType.RTC_HEVC.ordinal()] = 1;
            $EnumSwitchMapping$1[LivePlayUrlService.UrlType.RTC_AVC.ordinal()] = 2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(443206265, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(443206265, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "playerService", "getPlayerService()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "pluginManagerService", "getPluginManagerService()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "appService", "getAppService()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "mainHandler", "getMainHandler()Landroid/os/Handler;"))};
        Companion = new Companion(null);
    }

    private final AppInfoService getAppService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Lazy lazy = this.appService$delegate;
            KProperty kProperty = $$delegatedProperties[2];
            return (AppInfoService) lazy.getValue();
        }
        return (AppInfoService) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Lazy lazy = this.mainHandler$delegate;
            KProperty kProperty = $$delegatedProperties[3];
            return (Handler) lazy.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    private final ILivePlayerService getPlayerService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Lazy lazy = this.playerService$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (ILivePlayerService) lazy.getValue();
        }
        return (ILivePlayerService) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PluginInvokeService getPluginManagerService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Lazy lazy = this.pluginManagerService$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (PluginInvokeService) lazy.getValue();
        }
        return (PluginInvokeService) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$Companion;", "", "AB_PRE_START_PLAYER_SWITCH", "Ljava/lang/String;", "", "ENABLE_ERROR_NO_CONVERT", "I", "FORMAT_KEY", "K_LIVE_PLAY_RATE_SETTING", "K_RTC_MEDIA_HEVC_TYPE", "K_RTC_MEDIA_SERVER_IP", "LIVE_NPS", "LIVE_PLUGIN_SUPPORT_PRE_START_PLAYER_MIM_VERSION", "LIVE_STATE_BACK", "LIVE_TEMPLATE_AUDIO", "LIVE_TEMPLATE_DATE", "", "PLAYER_TIME_OUT_DURATION", "J", "V_MEDIA_SOURCE_TYPE_DEF", "V_MEDIA_SOURCE_TYPE_DURTC", "V_MEDIA_SOURCE_TYPE_PLAYBACK", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0003R\u0019\u0010\u0007\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0003R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "", "component1", "()Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "component2", "()Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "cacheKey", DI.LIVE_PLAYER, "copy", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;)Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getCacheKey", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "getPlayer", "<init>", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class PreStartPlayer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String cacheKey;
        public final LivePlayer player;

        public static /* synthetic */ PreStartPlayer copy$default(PreStartPlayer preStartPlayer, String str, LivePlayer livePlayer, int i, Object obj) {
            if ((i & 1) != 0) {
                str = preStartPlayer.cacheKey;
            }
            if ((i & 2) != 0) {
                livePlayer = preStartPlayer.player;
            }
            return preStartPlayer.copy(str, livePlayer);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cacheKey : (String) invokeV.objValue;
        }

        public final LivePlayer component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.player : (LivePlayer) invokeV.objValue;
        }

        public final PreStartPlayer copy(String str, LivePlayer livePlayer) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, livePlayer)) == null) ? new PreStartPlayer(str, livePlayer) : (PreStartPlayer) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof PreStartPlayer) {
                        PreStartPlayer preStartPlayer = (PreStartPlayer) obj;
                        return Intrinsics.areEqual(this.cacheKey, preStartPlayer.cacheKey) && Intrinsics.areEqual(this.player, preStartPlayer.player);
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
                String str = this.cacheKey;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                LivePlayer livePlayer = this.player;
                return hashCode + (livePlayer != null ? livePlayer.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "PreStartPlayer(cacheKey=" + this.cacheKey + ", player=" + this.player + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public PreStartPlayer(String str, LivePlayer livePlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, livePlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cacheKey = str;
            this.player = livePlayer;
        }

        public final String getCacheKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.cacheKey;
            }
            return (String) invokeV.objValue;
        }

        public final LivePlayer getPlayer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.player;
            }
            return (LivePlayer) invokeV.objValue;
        }
    }

    public LivePreStartPlayServiceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.playerService$delegate = LazyKt__LazyJVMKt.lazy(LivePreStartPlayServiceImpl$playerService$2.INSTANCE);
        this.pluginManagerService$delegate = LazyKt__LazyJVMKt.lazy(LivePreStartPlayServiceImpl$pluginManagerService$2.INSTANCE);
        this.appService$delegate = LazyKt__LazyJVMKt.lazy(LivePreStartPlayServiceImpl$appService$2.INSTANCE);
        this.abService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
        this.playUrlService = (LivePlayUrlService) ServiceManager.getService(LivePlayUrlService.Companion.getSERVICE_REFERENCE());
        this.mainHandler$delegate = LazyKt__LazyJVMKt.lazy(LivePreStartPlayServiceImpl$mainHandler$2.INSTANCE);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    public void releasePreStartPlayer() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("releasePreStartPlayer: 播放器超时回收，cacheKey: ");
            PreStartPlayer preStartPlayer = this.preStartPlayer;
            if (preStartPlayer != null) {
                str = preStartPlayer.getCacheKey();
            } else {
                str = null;
            }
            sb.append(str);
            log(sb.toString());
            getMainHandler().removeCallbacksAndMessages(null);
            PreStartPlayer preStartPlayer2 = this.preStartPlayer;
            this.preStartPlayer = null;
            if (preStartPlayer2 != null) {
                preStartPlayer2.getPlayer().goBackOrForeground(false);
                preStartPlayer2.getPlayer().release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        AppInfoService appService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, str) == null) && (appService = getAppService()) != null && appService.isDebug() && !TextUtils.isEmpty(str)) {
            Log.i("LivePreStartPlayService", String.valueOf(str));
        }
    }

    private final String buildExtLog(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pdRec", str2);
                jSONObject.put("firstJump", "1");
                jSONObject.put("roomId", str);
                jSONObject.put("pageType", "zhongtai");
            } catch (JSONException e) {
                log("buildExtLog Exception " + e.getMessage());
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x028a, code lost:
        r3 = r8.toString();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "it.toString()");
        r10.put(2017, r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023e A[Catch: Exception -> 0x0330, TryCatch #5 {Exception -> 0x0330, blocks: (B:5:0x0014, B:7:0x0043, B:9:0x005d, B:11:0x0065, B:14:0x006f, B:16:0x0078, B:19:0x0080, B:22:0x008c, B:25:0x00c2, B:31:0x00ea, B:35:0x00f7, B:37:0x011a, B:41:0x0125, B:42:0x0128, B:52:0x0143, B:53:0x014a, B:55:0x015d, B:57:0x0163, B:60:0x0168, B:63:0x016e, B:66:0x0177, B:68:0x017e, B:69:0x0187, B:73:0x0196, B:77:0x01a5, B:86:0x01d2, B:108:0x020b, B:110:0x0211, B:112:0x021e, B:116:0x0228, B:145:0x028a, B:146:0x029c, B:148:0x02d7, B:125:0x023e, B:127:0x0244, B:129:0x024b, B:131:0x0251, B:133:0x0257, B:137:0x025e, B:139:0x027a, B:143:0x0285, B:118:0x022e, B:122:0x0238, B:80:0x01be, B:84:0x01cc, B:45:0x0130, B:26:0x00c8, B:30:0x00e7, B:150:0x0310, B:152:0x0316, B:88:0x01d8, B:95:0x01ec, B:97:0x01f1, B:102:0x0200, B:101:0x01fd), top: B:167:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x027a A[Catch: Exception -> 0x0330, TryCatch #5 {Exception -> 0x0330, blocks: (B:5:0x0014, B:7:0x0043, B:9:0x005d, B:11:0x0065, B:14:0x006f, B:16:0x0078, B:19:0x0080, B:22:0x008c, B:25:0x00c2, B:31:0x00ea, B:35:0x00f7, B:37:0x011a, B:41:0x0125, B:42:0x0128, B:52:0x0143, B:53:0x014a, B:55:0x015d, B:57:0x0163, B:60:0x0168, B:63:0x016e, B:66:0x0177, B:68:0x017e, B:69:0x0187, B:73:0x0196, B:77:0x01a5, B:86:0x01d2, B:108:0x020b, B:110:0x0211, B:112:0x021e, B:116:0x0228, B:145:0x028a, B:146:0x029c, B:148:0x02d7, B:125:0x023e, B:127:0x0244, B:129:0x024b, B:131:0x0251, B:133:0x0257, B:137:0x025e, B:139:0x027a, B:143:0x0285, B:118:0x022e, B:122:0x0238, B:80:0x01be, B:84:0x01cc, B:45:0x0130, B:26:0x00c8, B:30:0x00e7, B:150:0x0310, B:152:0x0316, B:88:0x01d8, B:95:0x01ec, B:97:0x01f1, B:102:0x0200, B:101:0x01fd), top: B:167:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02d7 A[Catch: Exception -> 0x0330, TryCatch #5 {Exception -> 0x0330, blocks: (B:5:0x0014, B:7:0x0043, B:9:0x005d, B:11:0x0065, B:14:0x006f, B:16:0x0078, B:19:0x0080, B:22:0x008c, B:25:0x00c2, B:31:0x00ea, B:35:0x00f7, B:37:0x011a, B:41:0x0125, B:42:0x0128, B:52:0x0143, B:53:0x014a, B:55:0x015d, B:57:0x0163, B:60:0x0168, B:63:0x016e, B:66:0x0177, B:68:0x017e, B:69:0x0187, B:73:0x0196, B:77:0x01a5, B:86:0x01d2, B:108:0x020b, B:110:0x0211, B:112:0x021e, B:116:0x0228, B:145:0x028a, B:146:0x029c, B:148:0x02d7, B:125:0x023e, B:127:0x0244, B:129:0x024b, B:131:0x0251, B:133:0x0257, B:137:0x025e, B:139:0x027a, B:143:0x0285, B:118:0x022e, B:122:0x0238, B:80:0x01be, B:84:0x01cc, B:45:0x0130, B:26:0x00c8, B:30:0x00e7, B:150:0x0310, B:152:0x0316, B:88:0x01d8, B:95:0x01ec, B:97:0x01f1, B:102:0x0200, B:101:0x01fd), top: B:167:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015d A[Catch: Exception -> 0x0330, TryCatch #5 {Exception -> 0x0330, blocks: (B:5:0x0014, B:7:0x0043, B:9:0x005d, B:11:0x0065, B:14:0x006f, B:16:0x0078, B:19:0x0080, B:22:0x008c, B:25:0x00c2, B:31:0x00ea, B:35:0x00f7, B:37:0x011a, B:41:0x0125, B:42:0x0128, B:52:0x0143, B:53:0x014a, B:55:0x015d, B:57:0x0163, B:60:0x0168, B:63:0x016e, B:66:0x0177, B:68:0x017e, B:69:0x0187, B:73:0x0196, B:77:0x01a5, B:86:0x01d2, B:108:0x020b, B:110:0x0211, B:112:0x021e, B:116:0x0228, B:145:0x028a, B:146:0x029c, B:148:0x02d7, B:125:0x023e, B:127:0x0244, B:129:0x024b, B:131:0x0251, B:133:0x0257, B:137:0x025e, B:139:0x027a, B:143:0x0285, B:118:0x022e, B:122:0x0238, B:80:0x01be, B:84:0x01cc, B:45:0x0130, B:26:0x00c8, B:30:0x00e7, B:150:0x0310, B:152:0x0316, B:88:0x01d8, B:95:0x01ec, B:97:0x01f1, B:102:0x0200, B:101:0x01fd), top: B:167:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d2 A[Catch: Exception -> 0x0330, TRY_LEAVE, TryCatch #5 {Exception -> 0x0330, blocks: (B:5:0x0014, B:7:0x0043, B:9:0x005d, B:11:0x0065, B:14:0x006f, B:16:0x0078, B:19:0x0080, B:22:0x008c, B:25:0x00c2, B:31:0x00ea, B:35:0x00f7, B:37:0x011a, B:41:0x0125, B:42:0x0128, B:52:0x0143, B:53:0x014a, B:55:0x015d, B:57:0x0163, B:60:0x0168, B:63:0x016e, B:66:0x0177, B:68:0x017e, B:69:0x0187, B:73:0x0196, B:77:0x01a5, B:86:0x01d2, B:108:0x020b, B:110:0x0211, B:112:0x021e, B:116:0x0228, B:145:0x028a, B:146:0x029c, B:148:0x02d7, B:125:0x023e, B:127:0x0244, B:129:0x024b, B:131:0x0251, B:133:0x0257, B:137:0x025e, B:139:0x027a, B:143:0x0285, B:118:0x022e, B:122:0x0238, B:80:0x01be, B:84:0x01cc, B:45:0x0130, B:26:0x00c8, B:30:0x00e7, B:150:0x0310, B:152:0x0316, B:88:0x01d8, B:95:0x01ec, B:97:0x01f1, B:102:0x0200, B:101:0x01fd), top: B:167:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean createAndStartPlayer(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        JSONObject jSONObject;
        boolean areEqual;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        LivePlayUrlService.PlayUrlData playUrlData;
        boolean z;
        Map<String, Object> mediaLivePlayConfig;
        Object obj;
        String str4;
        String buildExtLog;
        String str5;
        LivePlayUrlService.UrlType urlType;
        int i;
        Integer num;
        int i2;
        PluginInvokeService pluginManagerService;
        Object obj2;
        Object obj3;
        String str6;
        Map<String, Object> mediaLivePlayConfig2;
        LivePlayer createPlayer;
        int i3;
        String it;
        String url;
        String queryParameter;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, str, str2, str3)) == null) {
            try {
                jSONObject = new JSONObject(str3);
                areEqual = Intrinsics.areEqual("3", jSONObject.optString("status"));
                optString = jSONObject.optString("templateId");
                optString2 = jSONObject.optString("format");
                optString3 = jSONObject.optString("kabr_spts");
                optString4 = jSONObject.optString("playerIdentifier");
            } catch (Exception e) {
                log("preStartPlayer Exception " + e.getMessage());
            }
            if (!TextUtils.isEmpty(optString4)) {
                log("preStartPlayer paramsString: playerCacheKey " + optString4 + ",内核复用场景，直播间外已经起播，无需预播放");
                return false;
            }
            if (!Intrinsics.areEqual(optString, "5") && !Intrinsics.areEqual(optString, "7")) {
                HashMap<Integer, String> hashMap = new HashMap<>();
                LivePlayUrlService livePlayUrlService = this.playUrlService;
                if (livePlayUrlService != null) {
                    playUrlData = livePlayUrlService.getPlayUrlBySchemeParams(str3);
                } else {
                    playUrlData = null;
                }
                if (playUrlData != null && !TextUtils.isEmpty(playUrlData.getUrl())) {
                    log("preStartPlayer 获取到流地址 " + playUrlData.getUrl() + ", type: " + playUrlData.getUrlType());
                    String transEtnUrl = this.playUrlService.transEtnUrl(playUrlData.getUrl());
                    if (TextUtils.isEmpty(transEtnUrl)) {
                        log("preStartPlayer ETN 转换地址为空，不使用 ETN");
                    } else {
                        log("preStartPlayer ETN 转换地址非控，使用 ETN: " + transEtnUrl);
                        if (transEtnUrl == null) {
                            transEtnUrl = "";
                        }
                        hashMap.put(2018, transEtnUrl);
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("vr");
                    String url2 = playUrlData.getUrl();
                    if (url2 == null) {
                        url2 = "";
                    }
                    hashMap.put(0, url2);
                    hashMap.put(301, "live");
                    hashMap.put(124, "live_landing");
                    if (!TextUtils.isEmpty(optString2)) {
                        if (optString2 == null) {
                            optString2 = "";
                        }
                        hashMap.put(114, optString2);
                    }
                    LivePlayUrlService.UrlType urlType2 = playUrlData.getUrlType();
                    if (urlType2 != null && WhenMappings.$EnumSwitchMapping$0[urlType2.ordinal()] == 1) {
                        z = true;
                        if (z) {
                            hashMap.put(2015, "1");
                        }
                        mediaLivePlayConfig = getPluginManagerService().getMediaLivePlayConfig("live_play_rate", MapsKt__MapsJVMKt.mapOf(new Pair("kabr_spts", optString3)));
                        if (mediaLivePlayConfig == null) {
                            obj = mediaLivePlayConfig.get("live_play_rate");
                        } else {
                            obj = null;
                        }
                        if (!(obj instanceof String)) {
                            obj = null;
                        }
                        str4 = (String) obj;
                        if (!areEqual && optString3 != null && (!StringsKt__StringsJVMKt.isBlank(optString3)) && str4 != null && (!StringsKt__StringsJVMKt.isBlank(str4))) {
                            hashMap.put(2014, str4);
                        }
                        buildExtLog = buildExtLog(str, str2);
                        if (buildExtLog != null) {
                            buildExtLog = "";
                        }
                        hashMap.put(111, buildExtLog);
                        if (areEqual) {
                            str5 = "1";
                        } else {
                            str5 = "0";
                        }
                        hashMap.put(2000, str5);
                        hashMap.put(2013, "1");
                        BuildParams buildParams = new BuildParams(str);
                        urlType = playUrlData.getUrlType();
                        if (urlType != null && ((i = WhenMappings.$EnumSwitchMapping$1[urlType.ordinal()]) == 1 || i == 2)) {
                            num = 2;
                            if (optJSONObject == null && (url = playUrlData.getUrl()) != null) {
                                queryParameter = Uri.parse(url).getQueryParameter("vr");
                                try {
                                    jSONObject2 = new JSONObject(queryParameter);
                                    try {
                                        Unit unit = Unit.INSTANCE;
                                    } catch (Throwable th) {
                                        th = th;
                                        optJSONObject = jSONObject2;
                                        th.printStackTrace();
                                        if (queryParameter != null) {
                                            try {
                                                optJSONObject = new JSONObject(URLDecoder.decode(queryParameter));
                                            } catch (Throwable th2) {
                                                th2.printStackTrace();
                                            }
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                        jSONObject2 = optJSONObject;
                                        optJSONObject = jSONObject2;
                                        if (optJSONObject != null) {
                                        }
                                        if (num == null) {
                                        }
                                        log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                                        createPlayer = getPlayerService().createPlayer(buildParams);
                                        log("preStartPlayer: 播放器创建结束： " + createPlayer);
                                        if (createPlayer != null) {
                                        }
                                        return false;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                optJSONObject = jSONObject2;
                            }
                            if (optJSONObject != null) {
                                if (optJSONObject != null && (it = optJSONObject.toString()) != null) {
                                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                                    buildParams.setOption(BuildParams.K_VR, it);
                                }
                                if (num != null) {
                                    i3 = num.intValue();
                                } else if (areEqual) {
                                    i3 = 4;
                                } else {
                                    i3 = 3;
                                }
                                buildParams.setPlayerType(i3);
                            } else {
                                if (num != null) {
                                    i2 = num.intValue();
                                } else if (areEqual) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                buildParams.setPlayerType(i2);
                            }
                            if (num == null && num.intValue() == 2) {
                                pluginManagerService = getPluginManagerService();
                                if (pluginManagerService == null && (mediaLivePlayConfig2 = pluginManagerService.getMediaLivePlayConfig("get_preset_ip", null)) != null) {
                                    obj2 = mediaLivePlayConfig2.get("get_preset_ip");
                                } else {
                                    obj2 = null;
                                }
                                if (obj2 instanceof String) {
                                    obj3 = null;
                                } else {
                                    obj3 = obj2;
                                }
                                str6 = (String) obj3;
                                log("preStartPlayer rtc preset_ip " + str6);
                                if (!TextUtils.isEmpty(str6)) {
                                    if (str6 == null) {
                                        str6 = "";
                                    }
                                    hashMap.put(2010, str6);
                                }
                            }
                            log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                            createPlayer = getPlayerService().createPlayer(buildParams);
                            log("preStartPlayer: 播放器创建结束： " + createPlayer);
                            if (createPlayer != null) {
                                log("preStartPlayer: 播放器开始起播");
                                long currentTimeMillis = System.currentTimeMillis();
                                createPlayer.setUseLivePreStartPlayerState(true);
                                createPlayer.setVideoInfo(hashMap);
                                createPlayer.mute(true);
                                createPlayer.start();
                                log("preStartPlayer: 播放器起播动作耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                                this.preStartPlayer = new PreStartPlayer(str, createPlayer);
                                resetTimeoutWork();
                                return true;
                            }
                            return false;
                        }
                        num = null;
                        if (optJSONObject == null) {
                            queryParameter = Uri.parse(url).getQueryParameter("vr");
                            jSONObject2 = new JSONObject(queryParameter);
                            Unit unit3 = Unit.INSTANCE;
                            optJSONObject = jSONObject2;
                        }
                        if (optJSONObject != null) {
                        }
                        if (num == null) {
                            pluginManagerService = getPluginManagerService();
                            if (pluginManagerService == null) {
                            }
                            obj2 = null;
                            if (obj2 instanceof String) {
                            }
                            str6 = (String) obj3;
                            log("preStartPlayer rtc preset_ip " + str6);
                            if (!TextUtils.isEmpty(str6)) {
                            }
                        }
                        log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                        createPlayer = getPlayerService().createPlayer(buildParams);
                        log("preStartPlayer: 播放器创建结束： " + createPlayer);
                        if (createPlayer != null) {
                        }
                        return false;
                    }
                    z = false;
                    if (z) {
                    }
                    mediaLivePlayConfig = getPluginManagerService().getMediaLivePlayConfig("live_play_rate", MapsKt__MapsJVMKt.mapOf(new Pair("kabr_spts", optString3)));
                    if (mediaLivePlayConfig == null) {
                    }
                    if (!(obj instanceof String)) {
                    }
                    str4 = (String) obj;
                    if (!areEqual) {
                        hashMap.put(2014, str4);
                    }
                    buildExtLog = buildExtLog(str, str2);
                    if (buildExtLog != null) {
                    }
                    hashMap.put(111, buildExtLog);
                    if (areEqual) {
                    }
                    hashMap.put(2000, str5);
                    hashMap.put(2013, "1");
                    BuildParams buildParams2 = new BuildParams(str);
                    urlType = playUrlData.getUrlType();
                    if (urlType != null) {
                        num = 2;
                        if (optJSONObject == null) {
                        }
                        if (optJSONObject != null) {
                        }
                        if (num == null) {
                        }
                        log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams2.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                        createPlayer = getPlayerService().createPlayer(buildParams2);
                        log("preStartPlayer: 播放器创建结束： " + createPlayer);
                        if (createPlayer != null) {
                        }
                        return false;
                    }
                    num = null;
                    if (optJSONObject == null) {
                    }
                    if (optJSONObject != null) {
                    }
                    if (num == null) {
                    }
                    log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams2.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                    createPlayer = getPlayerService().createPlayer(buildParams2);
                    log("preStartPlayer: 播放器创建结束： " + createPlayer);
                    if (createPlayer != null) {
                    }
                    return false;
                }
                log("preStartPlayer paramsString: 解析 scheme 后未找到可用流地址，返回");
                return false;
            }
            log("preStartPlayer paramsString: templateId " + optString + " ,非可起播模版，返回 ");
            return false;
        }
        return invokeLLL.booleanValue;
    }

    private final boolean isLiveNpsSupportPreStart() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            PluginInvokeService pluginManagerService = getPluginManagerService();
            if (pluginManagerService != null) {
                i = pluginManagerService.getLiveNpsPluginWillLoadVersion();
            } else {
                i = 0;
            }
            if (i < 601500000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private final void resetTimeoutWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            getMainHandler().removeCallbacksAndMessages(null);
            getMainHandler().postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$resetTimeoutWork$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LivePreStartPlayServiceImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    PluginInvokeService pluginManagerService;
                    Handler mainHandler;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.log("resetTimeoutWork: 播放器超时检查第一次： 6000");
                    pluginManagerService = this.this$0.getPluginManagerService();
                    if (pluginManagerService == null || !pluginManagerService.isPluginLoaded("com.baidu.searchbox.livenps")) {
                        this.this$0.log("resetTimeoutWork: 播放器超时检查第一次，插件未加载，再次延时等待");
                        mainHandler = this.this$0.getMainHandler();
                        mainHandler.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$resetTimeoutWork$1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LivePreStartPlayServiceImpl$resetTimeoutWork$1 this$0;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null && interceptable3.invokeV(1048576, this) != null) {
                                    return;
                                }
                                this.this$0.this$0.log("resetTimeoutWork: 播放器超时检查第二级，再次延时等待结束，直接检查回收");
                                this.this$0.this$0.releasePreStartPlayer();
                            }
                        }, 12000L);
                        return;
                    }
                    this.this$0.log("resetTimeoutWork: 播放器超时检查第一次，插件已加载： 6000");
                    this.this$0.releasePreStartPlayer();
                }
            }, PLAYER_TIME_OUT_DURATION);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    public LivePlayer getPreStartPlayer(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            getMainHandler().removeCallbacksAndMessages(null);
            PreStartPlayer preStartPlayer = this.preStartPlayer;
            if (preStartPlayer != null) {
                str2 = preStartPlayer.getCacheKey();
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                PreStartPlayer preStartPlayer2 = this.preStartPlayer;
                if (preStartPlayer2 != null) {
                    str3 = preStartPlayer2.getCacheKey();
                } else {
                    str3 = null;
                }
                if (Intrinsics.areEqual(str, str3)) {
                    log("getCachePlayer player: 存在提前创建当前直播间播放器");
                    PreStartPlayer preStartPlayer3 = this.preStartPlayer;
                    if (preStartPlayer3 != null) {
                        livePlayer = preStartPlayer3.getPlayer();
                    } else {
                        livePlayer = null;
                    }
                    log("getCachePlayer 返回已起播播放器：player: " + livePlayer);
                    this.preStartPlayer = null;
                    return livePlayer;
                }
            }
            releasePreStartPlayer();
            return null;
        }
        return (LivePlayer) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean preStartPlayer(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        boolean z;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            AbConfigService abConfigService = this.abService;
            if (abConfigService != null && abConfigService.getSwitch(AB_PRE_START_PLAYER_SWITCH, false)) {
                z = true;
            } else {
                z = false;
            }
            log("preStartPlayer preStartSupportSwitch: " + z + "， isLiveNpsSupportPreStart: " + isLiveNpsSupportPreStart() + ",roomId: " + str + ", source: " + str2 + ", params " + str3 + "，Thread: " + Thread.currentThread());
            if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && z && isLiveNpsSupportPreStart()) {
                PreStartPlayer preStartPlayer = this.preStartPlayer;
                String str6 = null;
                if (preStartPlayer != null) {
                    str4 = preStartPlayer.getCacheKey();
                } else {
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4)) {
                    PreStartPlayer preStartPlayer2 = this.preStartPlayer;
                    if (preStartPlayer2 != null) {
                        str5 = preStartPlayer2.getCacheKey();
                    } else {
                        str5 = null;
                    }
                    if (!Intrinsics.areEqual(str5, str)) {
                        log("preStartPlayer paramsString: 存在已起播非当前直播间播放器, 直接销毁后再次创建");
                        releasePreStartPlayer();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (str == null) {
                            str = "";
                        }
                        if (str3 == null) {
                            str3 = "";
                        }
                        boolean createAndStartPlayer = createAndStartPlayer(str, str2, str3);
                        log("preStartPlayer 结果：" + createAndStartPlayer + ", 预起播任务耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                        return createAndStartPlayer;
                    }
                }
                PreStartPlayer preStartPlayer3 = this.preStartPlayer;
                if (preStartPlayer3 != null) {
                    str6 = preStartPlayer3.getCacheKey();
                }
                if (Intrinsics.areEqual(str6, str)) {
                    log("preStartPlayer paramsString: 存在当前直播间已起播播放器，无需继续创建，重置超时时间，返回");
                    resetTimeoutWork();
                    return true;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str == null) {
                }
                if (str3 == null) {
                }
                boolean createAndStartPlayer2 = createAndStartPlayer(str, str2, str3);
                log("preStartPlayer 结果：" + createAndStartPlayer2 + ", 预起播任务耗时：" + (System.currentTimeMillis() - currentTimeMillis2));
                return createAndStartPlayer2;
            }
            releasePreStartPlayer();
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
