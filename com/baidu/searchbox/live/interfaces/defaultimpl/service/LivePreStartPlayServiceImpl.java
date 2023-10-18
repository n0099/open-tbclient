package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService;
import com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 82\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b7\u0010\u0017J#\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0017R\u001e\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR%\u0010\"\u001a\n \u001a*\u0004\u0018\u00010\u001d0\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u001e\u0010)\u001a\n \u001a*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R%\u0010/\u001a\n \u001a*\u0004\u0018\u00010+0+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010.R%\u00104\u001a\n \u001a*\u0004\u0018\u000100008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103R\u0018\u0010\u0015\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00106¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "", "roomId", "source", "buildExtLog", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "params", "", "createAndStartPlayer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "cacheKey", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "getPreStartPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "isLiveNpsSupportPreStart", "()Z", "msg", "", LocalFilesFilterKt.FILTER_NAME_LOG, "(Ljava/lang/String;)V", "preStartPlayer", "releasePreStartPlayer", "()V", "resetTimeoutWork", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService$delegate", "Lkotlin/Lazy;", "getAppService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService", "Landroid/os/Handler;", "mainHandler$delegate", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "playUrlService", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService$delegate", "getPlayerService", "()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService$delegate", "getPluginManagerService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginManagerService", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "<init>", "Companion", "PreStartPlayer", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LivePreStartPlayServiceImpl implements LivePreStartPlayerService {
    public static final String AB_PRE_START_PLAYER_SWITCH = "android_live_media_pre_start_player_switch";
    public static final int ENABLE_ERROR_NO_CONVERT = 2013;
    public static final int FORMAT_KEY = 114;
    public static final int K_LIVE_PLAY_RATE_SETTING = 2014;
    public static final String K_LIVE_PLAY_RATE_SETTING_OPTION = "playerSetting";
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
    public PreStartPlayer preStartPlayer;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "playerService", "getPlayerService()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "pluginManagerService", "getPluginManagerService()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "appService", "getAppService()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePreStartPlayServiceImpl.class), "mainHandler", "getMainHandler()Landroid/os/Handler;"))};
    public static final Companion Companion = new Companion(null);
    public final Lazy playerService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ILivePlayerService>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$playerService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILivePlayerService invoke() {
            return (ILivePlayerService) ServiceManager.getService(ILivePlayerService.Companion.getSERVICE_REFERENCE());
        }
    });
    public final Lazy pluginManagerService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<PluginInvokeService>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$pluginManagerService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PluginInvokeService invoke() {
            return (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        }
    });
    public final Lazy appService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AppInfoService>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$appService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AppInfoService invoke() {
            return (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        }
    });
    public final AbConfigService abService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
    public final LivePlayUrlService playUrlService = (LivePlayUrlService) ServiceManager.getService(LivePlayUrlService.Companion.getSERVICE_REFERENCE());
    public final Lazy mainHandler$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$mainHandler$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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

    private final AppInfoService getAppService() {
        Lazy lazy = this.appService$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (AppInfoService) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMainHandler() {
        Lazy lazy = this.mainHandler$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (Handler) lazy.getValue();
    }

    private final ILivePlayerService getPlayerService() {
        Lazy lazy = this.playerService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ILivePlayerService) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PluginInvokeService getPluginManagerService() {
        Lazy lazy = this.pluginManagerService$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (PluginInvokeService) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$Companion;", "", "AB_PRE_START_PLAYER_SWITCH", "Ljava/lang/String;", "", "ENABLE_ERROR_NO_CONVERT", "I", "FORMAT_KEY", "K_LIVE_PLAY_RATE_SETTING", "K_LIVE_PLAY_RATE_SETTING_OPTION", "K_RTC_MEDIA_HEVC_TYPE", "K_RTC_MEDIA_SERVER_IP", "LIVE_NPS", "LIVE_PLUGIN_SUPPORT_PRE_START_PLAYER_MIM_VERSION", "LIVE_STATE_BACK", "LIVE_TEMPLATE_AUDIO", "LIVE_TEMPLATE_DATE", "", "PLAYER_TIME_OUT_DURATION", "J", "V_MEDIA_SOURCE_TYPE_DEF", "V_MEDIA_SOURCE_TYPE_DURTC", "V_MEDIA_SOURCE_TYPE_PLAYBACK", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0003R\u0019\u0010\u0007\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0003R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "", "component1", "()Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "component2", "()Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "cacheKey", DI.LIVE_PLAYER, CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;)Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePreStartPlayServiceImpl$PreStartPlayer;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCacheKey", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "getPlayer", "<init>", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class PreStartPlayer {
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
            return this.cacheKey;
        }

        public final LivePlayer component2() {
            return this.player;
        }

        public final PreStartPlayer copy(String str, LivePlayer livePlayer) {
            return new PreStartPlayer(str, livePlayer);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof PreStartPlayer) {
                    PreStartPlayer preStartPlayer = (PreStartPlayer) obj;
                    return Intrinsics.areEqual(this.cacheKey, preStartPlayer.cacheKey) && Intrinsics.areEqual(this.player, preStartPlayer.player);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.cacheKey;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            LivePlayer livePlayer = this.player;
            return hashCode + (livePlayer != null ? livePlayer.hashCode() : 0);
        }

        public String toString() {
            return "PreStartPlayer(cacheKey=" + this.cacheKey + ", player=" + this.player + SmallTailInfo.EMOTION_SUFFIX;
        }

        public PreStartPlayer(String str, LivePlayer livePlayer) {
            this.cacheKey = str;
            this.player = livePlayer;
        }

        public final String getCacheKey() {
            return this.cacheKey;
        }

        public final LivePlayer getPlayer() {
            return this.player;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    public void releasePreStartPlayer() {
        String str;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        AppInfoService appService = getAppService();
        if (appService != null && appService.isDebug() && !TextUtils.isEmpty(str)) {
            Log.i("LivePreStartPlayService", String.valueOf(str));
        }
    }

    private final String buildExtLog(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BasicVideoParserKt.PD_REC, str2);
            jSONObject.put("firstJump", "1");
            jSONObject.put("roomId", str);
            jSONObject.put("pageType", "zhongtai");
        } catch (JSONException e) {
            log("buildExtLog Exception " + e.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x02b4, code lost:
        r3 = r3.toString();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "it.toString()");
        r11.put(2017, r3);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ea, code lost:
        if (r6 != 2) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0263 A[Catch: Exception -> 0x0366, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0270 A[Catch: Exception -> 0x0366, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a4 A[Catch: Exception -> 0x0366, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0305 A[Catch: Exception -> 0x0366, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c A[Catch: Exception -> 0x0366, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01de A[Catch: Exception -> 0x0366, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f5 A[Catch: Exception -> 0x0366, TRY_LEAVE, TryCatch #4 {Exception -> 0x0366, blocks: (B:3:0x0013, B:5:0x0047, B:7:0x0062, B:9:0x006a, B:12:0x0074, B:14:0x007d, B:17:0x0085, B:20:0x0091, B:23:0x00c8, B:29:0x00f6, B:33:0x0103, B:35:0x0127, B:39:0x0132, B:40:0x0135, B:50:0x0150, B:51:0x0157, B:53:0x017c, B:55:0x0182, B:58:0x0187, B:61:0x018d, B:64:0x0197, B:66:0x019e, B:67:0x01a7, B:71:0x01b6, B:75:0x01c5, B:86:0x01f5, B:109:0x022e, B:111:0x0234, B:113:0x0243, B:117:0x024d, B:147:0x02b4, B:148:0x02c8, B:150:0x0305, B:126:0x0263, B:128:0x026a, B:130:0x0270, B:132:0x0279, B:135:0x0280, B:139:0x0287, B:141:0x02a4, B:145:0x02af, B:119:0x0253, B:123:0x025d, B:78:0x01de, B:84:0x01ef, B:43:0x013d, B:24:0x00d1, B:28:0x00f3, B:152:0x0342, B:154:0x034a, B:88:0x01fb, B:95:0x020f, B:97:0x0214, B:102:0x0223, B:98:0x0218), top: B:165:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean createAndStartPlayer(String str, String str2, String str3) {
        LivePlayUrlService.PlayUrlData playUrlData;
        String str4;
        boolean z;
        Map<String, Object> mediaLivePlayConfig;
        Object obj;
        String str5;
        String buildExtLog;
        String str6;
        LivePlayUrlService.UrlType urlType;
        int i;
        Integer valueOf;
        int i2;
        PluginInvokeService pluginManagerService;
        Object obj2;
        Object obj3;
        Object obj4;
        String str7;
        LivePlayer createPlayer;
        int i3;
        String it;
        String url;
        String queryParameter;
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str3);
            boolean areEqual = Intrinsics.areEqual("3", jSONObject2.optString("status"));
            String optString = jSONObject2.optString("templateId");
            String optString2 = jSONObject2.optString("format");
            String optString3 = jSONObject2.optString("kabr_spts");
            int optInt = jSONObject2.optInt(K_LIVE_PLAY_RATE_SETTING_OPTION);
            String optString4 = jSONObject2.optString("playerIdentifier");
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
                        str4 = "get_preset_ip";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        str4 = "get_preset_ip";
                        sb.append("preStartPlayer ETN 转换地址非控，使用 ETN: ");
                        sb.append(transEtnUrl);
                        log(sb.toString());
                        if (transEtnUrl == null) {
                            transEtnUrl = "";
                        }
                        hashMap.put(2018, transEtnUrl);
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("vr");
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
                        mediaLivePlayConfig = getPluginManagerService().getMediaLivePlayConfig("live_play_rate", MapsKt__MapsKt.mapOf(new Pair("kabr_spts", optString3), new Pair(K_LIVE_PLAY_RATE_SETTING_OPTION, Integer.valueOf(optInt))));
                        if (mediaLivePlayConfig == null) {
                            obj = mediaLivePlayConfig.get("live_play_rate");
                        } else {
                            obj = null;
                        }
                        if (!(obj instanceof String)) {
                            obj = null;
                        }
                        str5 = (String) obj;
                        if (!areEqual && optString3 != null && (!StringsKt__StringsJVMKt.isBlank(optString3)) && str5 != null && (!StringsKt__StringsJVMKt.isBlank(str5))) {
                            hashMap.put(2014, str5);
                        }
                        buildExtLog = buildExtLog(str, str2);
                        if (buildExtLog != null) {
                            buildExtLog = "";
                        }
                        hashMap.put(111, buildExtLog);
                        if (areEqual) {
                            str6 = "1";
                        } else {
                            str6 = "0";
                        }
                        hashMap.put(2000, str6);
                        hashMap.put(2013, "1");
                        BuildParams buildParams = new BuildParams(str);
                        urlType = playUrlData.getUrlType();
                        if (urlType != null) {
                            int i4 = WhenMappings.$EnumSwitchMapping$1[urlType.ordinal()];
                            if (i4 != 1) {
                                i = 2;
                            } else {
                                i = 2;
                            }
                            valueOf = Integer.valueOf(i);
                            if (optJSONObject == null && (url = playUrlData.getUrl()) != null) {
                                queryParameter = Uri.parse(url).getQueryParameter("vr");
                                try {
                                    jSONObject = new JSONObject(queryParameter);
                                    try {
                                        Unit unit = Unit.INSTANCE;
                                    } catch (Throwable th) {
                                        th = th;
                                        optJSONObject = jSONObject;
                                        th.printStackTrace();
                                        if (queryParameter != null) {
                                            optJSONObject = new JSONObject(URLDecoder.decode(queryParameter));
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                        jSONObject = optJSONObject;
                                        optJSONObject = jSONObject;
                                        if (optJSONObject == null) {
                                        }
                                        if (valueOf != null) {
                                        }
                                        log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                                        createPlayer = getPlayerService().createPlayer(buildParams);
                                        log("preStartPlayer: 播放器创建结束： " + createPlayer);
                                        if (createPlayer == null) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                optJSONObject = jSONObject;
                            }
                            if (optJSONObject == null) {
                                if (optJSONObject != null && (it = optJSONObject.toString()) != null) {
                                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                                    buildParams.setOption(BuildParams.K_VR, it);
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                if (valueOf != null) {
                                    i3 = valueOf.intValue();
                                } else if (areEqual) {
                                    i3 = 4;
                                } else {
                                    i3 = 3;
                                }
                                buildParams.setPlayerType(i3);
                            } else {
                                if (valueOf != null) {
                                    i2 = valueOf.intValue();
                                } else if (areEqual) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                buildParams.setPlayerType(i2);
                            }
                            if (valueOf != null && valueOf.intValue() == 2) {
                                pluginManagerService = getPluginManagerService();
                                if (pluginManagerService == null) {
                                    String str8 = str4;
                                    obj2 = null;
                                    Map<String, Object> mediaLivePlayConfig2 = pluginManagerService.getMediaLivePlayConfig(str8, null);
                                    if (mediaLivePlayConfig2 != null) {
                                        obj3 = mediaLivePlayConfig2.get(str8);
                                        if (!(obj3 instanceof String)) {
                                            obj4 = obj2;
                                        } else {
                                            obj4 = obj3;
                                        }
                                        str7 = (String) obj4;
                                        log("preStartPlayer rtc preset_ip " + str7);
                                        if (!TextUtils.isEmpty(str7)) {
                                            if (str7 == null) {
                                                str7 = "";
                                            }
                                            hashMap.put(2010, str7);
                                        }
                                    }
                                } else {
                                    obj2 = null;
                                }
                                obj3 = obj2;
                                if (!(obj3 instanceof String)) {
                                }
                                str7 = (String) obj4;
                                log("preStartPlayer rtc preset_ip " + str7);
                                if (!TextUtils.isEmpty(str7)) {
                                }
                            }
                            log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                            createPlayer = getPlayerService().createPlayer(buildParams);
                            log("preStartPlayer: 播放器创建结束： " + createPlayer);
                            if (createPlayer == null) {
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
                        valueOf = null;
                        if (optJSONObject == null) {
                            queryParameter = Uri.parse(url).getQueryParameter("vr");
                            jSONObject = new JSONObject(queryParameter);
                            Unit unit4 = Unit.INSTANCE;
                            optJSONObject = jSONObject;
                        }
                        if (optJSONObject == null) {
                        }
                        if (valueOf != null) {
                            pluginManagerService = getPluginManagerService();
                            if (pluginManagerService == null) {
                            }
                            obj3 = obj2;
                            if (!(obj3 instanceof String)) {
                            }
                            str7 = (String) obj4;
                            log("preStartPlayer rtc preset_ip " + str7);
                            if (!TextUtils.isEmpty(str7)) {
                            }
                        }
                        log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                        createPlayer = getPlayerService().createPlayer(buildParams);
                        log("preStartPlayer: 播放器创建结束： " + createPlayer);
                        if (createPlayer == null) {
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    mediaLivePlayConfig = getPluginManagerService().getMediaLivePlayConfig("live_play_rate", MapsKt__MapsKt.mapOf(new Pair("kabr_spts", optString3), new Pair(K_LIVE_PLAY_RATE_SETTING_OPTION, Integer.valueOf(optInt))));
                    if (mediaLivePlayConfig == null) {
                    }
                    if (!(obj instanceof String)) {
                    }
                    str5 = (String) obj;
                    if (!areEqual) {
                        hashMap.put(2014, str5);
                    }
                    buildExtLog = buildExtLog(str, str2);
                    if (buildExtLog != null) {
                    }
                    hashMap.put(111, buildExtLog);
                    if (areEqual) {
                    }
                    hashMap.put(2000, str6);
                    hashMap.put(2013, "1");
                    BuildParams buildParams2 = new BuildParams(str);
                    urlType = playUrlData.getUrlType();
                    if (urlType != null) {
                    }
                    valueOf = null;
                    if (optJSONObject == null) {
                    }
                    if (optJSONObject == null) {
                    }
                    if (valueOf != null) {
                    }
                    log("preStartPlayer paramsString: 开始构建起播参数， 流类型：" + buildParams2.getPlayerType() + WebvttCueParser.CHAR_SPACE);
                    createPlayer = getPlayerService().createPlayer(buildParams2);
                    log("preStartPlayer: 播放器创建结束： " + createPlayer);
                    if (createPlayer == null) {
                    }
                }
                log("preStartPlayer paramsString: 解析 scheme 后未找到可用流地址，返回");
                return false;
            }
            log("preStartPlayer paramsString: templateId " + optString + " ,非可起播模版，返回 ");
            return false;
        } catch (Exception e) {
            log("preStartPlayer Exception " + e.getMessage());
            return false;
        }
    }

    private final boolean isLiveNpsSupportPreStart() {
        int i;
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

    private final void resetTimeoutWork() {
        getMainHandler().removeCallbacksAndMessages(null);
        getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$resetTimeoutWork$1
            @Override // java.lang.Runnable
            public final void run() {
                PluginInvokeService pluginManagerService;
                Handler mainHandler;
                LivePreStartPlayServiceImpl.this.log("resetTimeoutWork: 播放器超时检查第一次： 6000");
                pluginManagerService = LivePreStartPlayServiceImpl.this.getPluginManagerService();
                if (pluginManagerService == null || !pluginManagerService.isPluginLoaded("com.baidu.searchbox.livenps")) {
                    LivePreStartPlayServiceImpl.this.log("resetTimeoutWork: 播放器超时检查第一次，插件未加载，再次延时等待");
                    mainHandler = LivePreStartPlayServiceImpl.this.getMainHandler();
                    mainHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl$resetTimeoutWork$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            LivePreStartPlayServiceImpl.this.log("resetTimeoutWork: 播放器超时检查第二级，再次延时等待结束，直接检查回收");
                            LivePreStartPlayServiceImpl.this.releasePreStartPlayer();
                        }
                    }, 12000L);
                    return;
                }
                LivePreStartPlayServiceImpl.this.log("resetTimeoutWork: 播放器超时检查第一次，插件已加载： 6000");
                LivePreStartPlayServiceImpl.this.releasePreStartPlayer();
            }
        }, PLAYER_TIME_OUT_DURATION);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    public LivePlayer getPreStartPlayer(String str) {
        String str2;
        String str3;
        LivePlayer livePlayer;
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da  */
    @Override // com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean preStartPlayer(String str, String str2, String str3) {
        boolean z;
        String str4;
        String str5;
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
}
