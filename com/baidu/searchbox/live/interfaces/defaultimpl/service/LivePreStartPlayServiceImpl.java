package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import com.baidu.tbadk.TbConfig;
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
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b9\u0010\u001cJ#\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001cR\u001e\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R%\u0010'\u001a\n \u001f*\u0004\u0018\u00010\"0\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R%\u00101\u001a\n \u001f*\u0004\u0018\u00010-0-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R%\u00106\u001a\n \u001f*\u0004\u0018\u000102028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u0010\u001a\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00108¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "buildExtLog", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "params", "", "createAndStartPlayer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "url", "paramKey", "paramValue", "fillParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "cacheKey", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "getPreStartPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "isLiveNpsSupportPreStart", "()Z", "msg", "", TbConfig.TMP_LOG_DIR_NAME, "(Ljava/lang/String;)V", "preStartPlayer", "releasePreStartPlayer", "()V", "resetTimeoutWork", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService$delegate", "Lkotlin/Lazy;", "getAppService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService", "Landroid/os/Handler;", "mainHandler$delegate", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService$delegate", "getPlayerService", "()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService$delegate", "getPluginManagerService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "<init>", "Companion", "PreStartPlayer", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LivePreStartPlayServiceImpl implements LivePreStartPlayerService {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AB_PRE_START_PLAYER_SWITCH = "android_live_media_pre_start_player_switch";
    public static final Companion Companion;
    public static final int ENABLE_ERROR_NO_CONVERT = 2013;
    public static final String KEY_PLAY_CONFIG_PLAY_RATE = "live_play_rate";
    public static final int K_LIVE_PLAY_RATE_SETTING = 2014;
    public static final int K_RTC_MEDIA_SERVER_IP = 2010;
    public static final String LIVE_NPS = "com.baidu.searchbox.livenps";
    public static final int LIVE_PLUGIN_SUPPORT_PRE_START_PLAYER_MIM_VERSION = 601500000;
    public static final String LIVE_STATE_BACK = "3";
    public static final String LIVE_TEMPLATE_AUDIO = "5";
    public static final String LIVE_TEMPLATE_DATE = "7";
    public static final String PARAM_KABR_SPTS = "kabr_spts";
    public static final long PLAYER_TIME_OUT_DURATION = 6000;
    public static final int V_MEDIA_SOURCE_TYPE_DEF = 0;
    public static final int V_MEDIA_SOURCE_TYPE_DURTC = 2;
    public static final int V_MEDIA_SOURCE_TYPE_PLAYBACK = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbConfigService abService;
    public final Lazy appService$delegate;
    public final Lazy mainHandler$delegate;
    public final Lazy playerService$delegate;
    public final Lazy pluginManagerService$delegate;
    public PreStartPlayer preStartPlayer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$Companion;", "", "AB_PRE_START_PLAYER_SWITCH", "Ljava/lang/String;", "", "ENABLE_ERROR_NO_CONVERT", "I", "KEY_PLAY_CONFIG_PLAY_RATE", "K_LIVE_PLAY_RATE_SETTING", "K_RTC_MEDIA_SERVER_IP", "LIVE_NPS", "LIVE_PLUGIN_SUPPORT_PRE_START_PLAYER_MIM_VERSION", "LIVE_STATE_BACK", "LIVE_TEMPLATE_AUDIO", "LIVE_TEMPLATE_DATE", "PARAM_KABR_SPTS", "", "PLAYER_TIME_OUT_DURATION", "J", "V_MEDIA_SOURCE_TYPE_DEF", "V_MEDIA_SOURCE_TYPE_DURTC", "V_MEDIA_SOURCE_TYPE_PLAYBACK", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

        public final String getCacheKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cacheKey : (String) invokeV.objValue;
        }

        public final LivePlayer getPlayer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.player : (LivePlayer) invokeV.objValue;
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
        this.mainHandler$delegate = LazyKt__LazyJVMKt.lazy(LivePreStartPlayServiceImpl$mainHandler$2.INSTANCE);
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
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str);
                jSONObject.put("pageType", "zhongtai");
            } catch (JSONException e) {
                log("buildExtLog Exception " + e.getMessage());
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01eb A[Catch: Exception -> 0x0351, TryCatch #0 {Exception -> 0x0351, blocks: (B:5:0x0012, B:10:0x0025, B:14:0x003b, B:18:0x0045, B:22:0x004f, B:24:0x0067, B:26:0x0082, B:28:0x008a, B:31:0x0094, B:36:0x009f, B:41:0x00aa, B:46:0x00b5, B:51:0x00c0, B:53:0x00c7, B:55:0x0105, B:57:0x010d, B:60:0x0112, B:63:0x0118, B:66:0x0122, B:68:0x0129, B:70:0x0130, B:71:0x0134, B:73:0x013c, B:74:0x0140, B:76:0x0148, B:77:0x014c, B:83:0x0158, B:85:0x015e, B:87:0x0165, B:89:0x016b, B:91:0x0173, B:122:0x01e0, B:127:0x01eb, B:129:0x01f2, B:132:0x01fb, B:135:0x0205, B:137:0x020c, B:138:0x0215, B:142:0x0242, B:147:0x0253, B:149:0x0266, B:153:0x0270, B:175:0x02c0, B:177:0x02fb, B:156:0x0276, B:158:0x027c, B:160:0x0283, B:162:0x0289, B:164:0x028f, B:168:0x0296, B:170:0x02b2, B:174:0x02bd, B:92:0x017f, B:97:0x018a, B:99:0x0190, B:101:0x0197, B:103:0x019d, B:105:0x01a5, B:106:0x01ac, B:111:0x01b7, B:113:0x01bd, B:115:0x01c4, B:117:0x01ca, B:119:0x01d2, B:120:0x01d9, B:179:0x0336), top: B:190:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f2 A[Catch: Exception -> 0x0351, TryCatch #0 {Exception -> 0x0351, blocks: (B:5:0x0012, B:10:0x0025, B:14:0x003b, B:18:0x0045, B:22:0x004f, B:24:0x0067, B:26:0x0082, B:28:0x008a, B:31:0x0094, B:36:0x009f, B:41:0x00aa, B:46:0x00b5, B:51:0x00c0, B:53:0x00c7, B:55:0x0105, B:57:0x010d, B:60:0x0112, B:63:0x0118, B:66:0x0122, B:68:0x0129, B:70:0x0130, B:71:0x0134, B:73:0x013c, B:74:0x0140, B:76:0x0148, B:77:0x014c, B:83:0x0158, B:85:0x015e, B:87:0x0165, B:89:0x016b, B:91:0x0173, B:122:0x01e0, B:127:0x01eb, B:129:0x01f2, B:132:0x01fb, B:135:0x0205, B:137:0x020c, B:138:0x0215, B:142:0x0242, B:147:0x0253, B:149:0x0266, B:153:0x0270, B:175:0x02c0, B:177:0x02fb, B:156:0x0276, B:158:0x027c, B:160:0x0283, B:162:0x0289, B:164:0x028f, B:168:0x0296, B:170:0x02b2, B:174:0x02bd, B:92:0x017f, B:97:0x018a, B:99:0x0190, B:101:0x0197, B:103:0x019d, B:105:0x01a5, B:106:0x01ac, B:111:0x01b7, B:113:0x01bd, B:115:0x01c4, B:117:0x01ca, B:119:0x01d2, B:120:0x01d9, B:179:0x0336), top: B:190:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean createAndStartPlayer(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Map<String, Object> mediaLivePlayConfig;
        Integer num;
        Map<String, Object> mediaLivePlayConfig2;
        int i;
        Map<String, Object> mediaLivePlayConfig3;
        Map<String, Object> mediaLivePlayConfig4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, str, str2, str3)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("playUrl");
                if (optString == null) {
                    optString = "";
                }
                boolean areEqual = Intrinsics.areEqual("3", jSONObject.optString("status"));
                String optString2 = jSONObject.optString("avcUrl");
                if (optString2 == null) {
                    optString2 = "";
                }
                String optString3 = jSONObject.optString("hevcUrl");
                if (optString3 == null) {
                    optString3 = "";
                }
                String optString4 = jSONObject.optString("rtcUrl");
                if (optString4 == null) {
                    optString4 = "";
                }
                String optString5 = jSONObject.optString("templateId");
                String optString6 = jSONObject.optString(PARAM_KABR_SPTS);
                String optString7 = jSONObject.optString("playerIdentifier");
                if (!TextUtils.isEmpty(optString7)) {
                    log("preStartPlayer paramsString: playerCacheKey " + optString7 + ",内核复用场景，直播间外已经起播，无需预播放");
                    return false;
                }
                if (!Intrinsics.areEqual(optString5, "5") && !Intrinsics.areEqual(optString5, "7")) {
                    if (optString.length() == 0) {
                        if (optString2.length() == 0) {
                            if (optString3.length() == 0) {
                                if (optString4.length() == 0) {
                                    log("preStartPlayer paramsString: 无起播地址，返回 ");
                                    return false;
                                }
                            }
                        }
                    }
                    log("preStartPlayer paramsString: 开始构建起播参数， 流地址： playUrl " + optString + ", avcUrl " + optString2 + ", hevcUrl " + optString3);
                    Map<String, Object> mediaLivePlayConfig5 = getPluginManagerService().getMediaLivePlayConfig(KEY_PLAY_CONFIG_PLAY_RATE, MapsKt__MapsJVMKt.mapOf(new Pair(PARAM_KABR_SPTS, optString6)));
                    Object obj = mediaLivePlayConfig5 != null ? mediaLivePlayConfig5.get("KEY_PLAY_CONFIG_PLAY_RATE") : null;
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    String str4 = (String) obj;
                    if (!areEqual && optString6 != null && (!StringsKt__StringsJVMKt.isBlank(optString6)) && str4 != null && (!StringsKt__StringsJVMKt.isBlank(str4))) {
                        if (!StringsKt__StringsJVMKt.isBlank(optString)) {
                            optString = fillParam(optString, PARAM_KABR_SPTS, optString6);
                        }
                        if (!StringsKt__StringsJVMKt.isBlank(optString2)) {
                            optString2 = fillParam(optString2, PARAM_KABR_SPTS, optString6);
                        }
                        if (!StringsKt__StringsJVMKt.isBlank(optString3)) {
                            optString3 = fillParam(optString3, PARAM_KABR_SPTS, optString6);
                        }
                    }
                    if (optString4.length() > 0) {
                        PluginInvokeService pluginManagerService = getPluginManagerService();
                        if (Intrinsics.areEqual((pluginManagerService == null || (mediaLivePlayConfig4 = pluginManagerService.getMediaLivePlayConfig("is_support_rtc", null)) == null) ? null : mediaLivePlayConfig4.get("is_support_rtc"), Boolean.TRUE)) {
                            log("preStartPlayer 使用 rtc");
                            num = 2;
                            if (!(optString4.length() != 0)) {
                                log("preStartPlayer 无有效流地址");
                                return false;
                            }
                            HashMap<Integer, String> hashMap = new HashMap<>();
                            if (!areEqual && optString6 != null && (!StringsKt__StringsJVMKt.isBlank(optString6)) && str4 != null && (!StringsKt__StringsJVMKt.isBlank(str4))) {
                                hashMap.put(2014, str4);
                            }
                            hashMap.put(0, optString4);
                            hashMap.put(301, "live");
                            hashMap.put(124, "live_landing");
                            String buildExtLog = buildExtLog(str, str2);
                            if (buildExtLog == null) {
                                buildExtLog = "";
                            }
                            hashMap.put(111, buildExtLog);
                            hashMap.put(2000, areEqual ? "0" : "1");
                            hashMap.put(2013, "1");
                            BuildParams buildParams = new BuildParams(str);
                            if (num != null) {
                                i = num.intValue();
                            } else {
                                i = areEqual ? 1 : 0;
                            }
                            buildParams.setPlayerType(i);
                            if (num != null && num.intValue() == 2) {
                                PluginInvokeService pluginManagerService2 = getPluginManagerService();
                                Object obj2 = (pluginManagerService2 == null || (mediaLivePlayConfig3 = pluginManagerService2.getMediaLivePlayConfig("get_preset_ip", null)) == null) ? null : mediaLivePlayConfig3.get("get_preset_ip");
                                String str5 = (String) (!(obj2 instanceof String) ? null : obj2);
                                log("preStartPlayer rtc preset_ip " + str5);
                                if (!TextUtils.isEmpty(str5)) {
                                    if (str5 == null) {
                                        str5 = "";
                                    }
                                    hashMap.put(2010, str5);
                                }
                            }
                            log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                            LivePlayer createPlayer = getPlayerService().createPlayer(buildParams);
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
                    }
                    if (optString3.length() > 0) {
                        PluginInvokeService pluginManagerService3 = getPluginManagerService();
                        if (Intrinsics.areEqual((pluginManagerService3 == null || (mediaLivePlayConfig2 = pluginManagerService3.getMediaLivePlayConfig("is_support_hevc", null)) == null) ? null : mediaLivePlayConfig2.get("is_support_hevc"), Boolean.TRUE)) {
                            log("preStartPlayer 使用 hevc");
                            optString4 = optString3;
                            num = null;
                            if (!(optString4.length() != 0)) {
                            }
                        }
                    }
                    if (optString3.length() > 0) {
                        PluginInvokeService pluginManagerService4 = getPluginManagerService();
                        if (Intrinsics.areEqual((pluginManagerService4 == null || (mediaLivePlayConfig = pluginManagerService4.getMediaLivePlayConfig("is_support_avc", null)) == null) ? null : mediaLivePlayConfig.get("is_support_avc"), Boolean.TRUE)) {
                            log("preStartPlayer 使用 avc");
                            optString4 = optString2;
                            num = null;
                            if (!(optString4.length() != 0)) {
                            }
                        }
                    }
                    log("preStartPlayer 使用默认流地址");
                    optString4 = optString;
                    num = null;
                    if (!(optString4.length() != 0)) {
                    }
                }
                log("preStartPlayer paramsString: templateId " + optString5 + " ,非可起播模版，返回 ");
                return false;
            } catch (Exception e) {
                log("preStartPlayer Exception " + e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private final String fillParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, str, str2, str3)) == null) {
            if (StringsKt__StringsJVMKt.isBlank(str2) || StringsKt__StringsJVMKt.isBlank(str3)) {
                return str;
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
                return str + '&' + str2 + '=' + str3;
            }
            return str + '?' + str2 + '=' + str3;
        }
        return (String) invokeLLL.objValue;
    }

    private final AppInfoService getAppService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Lazy lazy = this.mainHandler$delegate;
            KProperty kProperty = $$delegatedProperties[3];
            return (Handler) lazy.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    private final ILivePlayerService getPlayerService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            Lazy lazy = this.pluginManagerService$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (PluginInvokeService) lazy.getValue();
        }
        return (PluginInvokeService) invokeV.objValue;
    }

    private final boolean isLiveNpsSupportPreStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            PluginInvokeService pluginManagerService = getPluginManagerService();
            return (pluginManagerService != null ? pluginManagerService.getLiveNpsPluginWillLoadVersion() : 0) >= 601500000;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        AppInfoService appService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, str) == null) || (appService = getAppService()) == null || !appService.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("LivePreStartPlayService", String.valueOf(str));
    }

    private final void resetTimeoutWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
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
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$0.this$0.log("resetTimeoutWork: 播放器超时检查第二级，再次延时等待结束，直接检查回收");
                                        this.this$0.this$0.releasePreStartPlayer();
                                    }
                                }
                            }, 12000L);
                            return;
                        }
                        this.this$0.log("resetTimeoutWork: 播放器超时检查第一次，插件已加载： 6000");
                        this.this$0.releasePreStartPlayer();
                    }
                }
            }, PLAYER_TIME_OUT_DURATION);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    public LivePlayer getPreStartPlayer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            getMainHandler().removeCallbacksAndMessages(null);
            PreStartPlayer preStartPlayer = this.preStartPlayer;
            if (!TextUtils.isEmpty(preStartPlayer != null ? preStartPlayer.getCacheKey() : null)) {
                PreStartPlayer preStartPlayer2 = this.preStartPlayer;
                if (Intrinsics.areEqual(str, preStartPlayer2 != null ? preStartPlayer2.getCacheKey() : null)) {
                    log("getCachePlayer player: 存在提前创建当前直播间播放器");
                    PreStartPlayer preStartPlayer3 = this.preStartPlayer;
                    LivePlayer player = preStartPlayer3 != null ? preStartPlayer3.getPlayer() : null;
                    log("getCachePlayer 返回已起播播放器：player: " + player);
                    this.preStartPlayer = null;
                    return player;
                }
            }
            releasePreStartPlayer();
            return null;
        }
        return (LivePlayer) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean preStartPlayer(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            AbConfigService abConfigService = this.abService;
            boolean z = abConfigService != null && abConfigService.getSwitch(AB_PRE_START_PLAYER_SWITCH, false);
            log("preStartPlayer preStartSupportSwitch: " + z + "， isLiveNpsSupportPreStart: " + isLiveNpsSupportPreStart() + ",roomId: " + str + ", source: " + str2 + ", params " + str3 + "，Thread: " + Thread.currentThread());
            if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && z && isLiveNpsSupportPreStart()) {
                PreStartPlayer preStartPlayer = this.preStartPlayer;
                if (!TextUtils.isEmpty(preStartPlayer != null ? preStartPlayer.getCacheKey() : null)) {
                    PreStartPlayer preStartPlayer2 = this.preStartPlayer;
                    if (!Intrinsics.areEqual(preStartPlayer2 != null ? preStartPlayer2.getCacheKey() : null, str)) {
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
                if (Intrinsics.areEqual(preStartPlayer3 != null ? preStartPlayer3.getCacheKey() : null, str)) {
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

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    public void releasePreStartPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("releasePreStartPlayer: 播放器超时回收，cacheKey: ");
            PreStartPlayer preStartPlayer = this.preStartPlayer;
            sb.append(preStartPlayer != null ? preStartPlayer.getCacheKey() : null);
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
}
