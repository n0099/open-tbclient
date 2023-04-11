package com.baidu.searchbox.live.mix.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.interfaces.context.PluginContextUtil;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.interfaces.yy.YYStaticConfig;
import com.baidu.searchbox.live.list.MixLiveActivity;
import com.baidu.searchbox.live.list.MixLiveTranslucentActivity;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.searchbox.live.ubc.LiveComponentLoadLogger;
import com.baidu.searchbox.live.ubc.MediaLiveEnterRoomRate;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.LiveActivityUtil;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\bX\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014JQ\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010&\u001a\u00020\u0001H\u0002¢\u0006\u0004\b&\u0010\u0003J#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040(2\u0006\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b+\u0010\u0003J\u001f\u0010.\u001a\u00020\u00012\u0006\u0010-\u001a\u00020,2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010/Ja\u00101\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b1\u00102J]\u00103\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b3\u00104J\u001d\u00105\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u00108R\u001e\u0010>\u001a\n =*\u0004\u0018\u00010<0<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010BR\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010DR\u0016\u0010E\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010DR6\u0010I\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0018\u00010Fj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0018\u0001`H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00108R\u0018\u0010L\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010BR\u001e\u0010N\u001a\n =*\u0004\u0018\u00010M0M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001e\u0010V\u001a\n =*\u0004\u0018\u00010U0U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006Y"}, d2 = {"Lcom/baidu/searchbox/live/mix/proxy/LiveMixShellManager;", "", "enterFlowEnd", "()V", "", "slot", "enterFlowEndSlot", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "jsonObject", "enterFlowStartSlot", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Landroid/content/Context;", "context", "roomId", "source", "params", "Landroid/net/Uri;", "uri", "enterLiveRoom", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "", "isYYMixLive", "preStartPlayer", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZZ)V", "entranceSupportPlayerReuse", "()Z", "getCurrentLoadRoomId", "()Ljava/lang/String;", "jumpToOuterWebView", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "stat", FlowInfoHelper.KEY_IS_COLDLAUNCH, "logPluginFlowEnd", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;Z)V", "message", "logShell", "npsLoadChainYYMixLive", "url", "", "parseYYLiveParamMap", "(Ljava/lang/String;)Ljava/util/Map;", "preloadMediaPlugin", "Landroid/content/Intent;", "intent", "releaseAndStartLiveActivity", "(Landroid/content/Intent;Landroid/content/Context;)V", "businessPluginStatus", "startLiveActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Boolean;ZLjava/lang/String;)V", "startMixLiveActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZZLjava/lang/String;)V", LiveYYPluginManager.USE_FROM_START_YY_LIVE_PAGE, "(Landroid/content/Context;Ljava/lang/String;)V", "KEY_ID_AUDIO_ENTER_AUDIO_ROOM_PERF_FLOW", "Ljava/lang/String;", "KEY_ID_AUDIO_RTC_JOIN", "UBC_ID_PLUGIN_PAGE_FLOW", "USE_FROM_START_LIVE_PAGE", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "Lcom/baidu/ubc/Flow;", "audioFlow", "Lcom/baidu/ubc/Flow;", "audioRtcFlow", "Z", "isDebug", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mLaunchInfo", "Ljava/util/HashMap;", "mRoomId", "pageFlow", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "preStartService", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "getStat", "()Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "setStat", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "Lcom/baidu/ubc/UBCManager;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveMixShellManager {
    public static final String KEY_ID_AUDIO_ENTER_AUDIO_ROOM_PERF_FLOW = "2408";
    public static final String KEY_ID_AUDIO_RTC_JOIN = "2415";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3180";
    public static final String USE_FROM_START_LIVE_PAGE = "startLiveActivity";
    public static Flow audioFlow;
    public static Flow audioRtcFlow;
    public static boolean isColdLaunch;
    public static final boolean isDebug;
    public static HashMap<String, Object> mLaunchInfo;
    public static String mRoomId;
    public static Flow pageFlow;
    public static final LivePreStartPlayerService preStartService;
    public static YYStatInfo stat;
    public static final LiveMixShellManager INSTANCE = new LiveMixShellManager();
    public static final UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public static final AbConfigService abService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());

    static {
        boolean z;
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            z = appInfoService.isDebug();
        } else {
            z = false;
        }
        isDebug = z;
        preStartService = (LivePreStartPlayerService) ServiceManager.getService(LivePreStartPlayerService.Companion.getSERVICE_REFERENCE());
        mRoomId = "";
        isColdLaunch = true;
    }

    public final String getCurrentLoadRoomId() {
        return mRoomId;
    }

    public final YYStatInfo getStat() {
        return stat;
    }

    private final void logShell(String str) {
        if (isDebug) {
            Log.d("LIVE_ARCH", str);
        }
    }

    public final void enterFlowEndSlot(String str) {
        logShell(" end slot : " + str);
        if (ubcManager != null && pageFlow != null && !TextUtils.isEmpty(str)) {
            ubcManager.flowEndSlot(pageFlow, str);
        }
    }

    public final void setStat(YYStatInfo yYStatInfo) {
        stat = yYStatInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseAndStartLiveActivity(Intent intent, Context context) {
        Boolean bool;
        IVideoInsertLiveService iVideoInsertLiveService = (IVideoInsertLiveService) ServiceManager.getService(IVideoInsertLiveService.Companion.getSERVICE_REFERENCE());
        if (iVideoInsertLiveService != null) {
            bool = Boolean.valueOf(iVideoInsertLiveService.releaseLive());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            intent.putExtra("finish_dispatch_lifecycle", true);
        }
        LiveActivityUtil.startActivitySafely(context, intent);
    }

    public final void enterFlowStartSlot(String str, JSONObject jSONObject) {
        logShell(" start slot : " + str);
        if (ubcManager != null && pageFlow != null && !TextUtils.isEmpty(str)) {
            ubcManager.flowStartSlot(pageFlow, str, jSONObject);
        }
    }

    public static /* synthetic */ void enterFlowStartSlot$default(LiveMixShellManager liveMixShellManager, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        liveMixShellManager.enterFlowStartSlot(str, jSONObject);
    }

    public final void enterLiveRoom(Context context, String str, String str2, String str3, Uri uri) {
        boolean z;
        boolean z2 = false;
        if (TextUtils.isEmpty(jumpToOuterWebView(str3))) {
            LivePreStartPlayerService livePreStartPlayerService = preStartService;
            if (livePreStartPlayerService != null) {
                z2 = livePreStartPlayerService.preStartPlayer(str, str2, str3);
            }
            z = z2;
        } else {
            z = false;
        }
        enterLiveRoom(context, str, str2, str3, uri, false, z);
    }

    private final void enterLiveRoom(final Context context, final String str, final String str2, final String str3, final Uri uri, final boolean z, final boolean z2) {
        String str4;
        String str5;
        String str6;
        boolean z3;
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("LiveMixShellManager enterLiveRoom roomId: ");
        sb.append(str);
        sb.append(" source: ");
        sb.append(str2);
        sb.append(" params: ");
        sb.append(str3);
        sb.append(" uri: ");
        if (uri == null || (str4 = uri.toString()) == null) {
            str4 = "  isYYMixLive: " + z;
        }
        sb.append((Object) str4);
        npsLoadChainLog.dLog(sb.toString());
        UBCManager uBCManager = ubcManager;
        if (uBCManager != null) {
            pageFlow = uBCManager.beginFlow(UBC_ID_PLUGIN_PAGE_FLOW);
            audioFlow = ubcManager.beginFlow(KEY_ID_AUDIO_ENTER_AUDIO_ROOM_PERF_FLOW);
            audioRtcFlow = ubcManager.beginFlow(KEY_ID_AUDIO_RTC_JOIN);
        }
        boolean z4 = false;
        if (mLaunchInfo == null) {
            mLaunchInfo = FlowInfoHelper.startNewFlow(str, false);
        }
        if (z2) {
            FlowInfoHelper.startSigleLineSlot(mLaunchInfo, "pre_start_play", true);
        }
        if (TextUtils.isEmpty(jumpToOuterWebView(str3))) {
            MediaLiveEnterRoomRate.INSTANCE.doEnterFirstSegmentInit(str, "", "", str2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "0";
        if (str == null) {
            str5 = "";
        } else {
            str5 = str;
        }
        mRoomId = str5;
        PluginInvokeService pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
        if (pluginInvokeService != null && pluginInvokeService.isPluginLoaded("com.baidu.searchbox.livenps")) {
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager enterLiveRoom 媒体一级插件已加载");
            if (!isColdLaunch) {
                str6 = "0";
            } else {
                PluginInvokeService pluginInvokeService2 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                if (pluginInvokeService2 != null) {
                    z3 = pluginInvokeService2.isPluginLoaded("com.baidu.live.media.business");
                } else {
                    z3 = false;
                }
                if (z3) {
                    objectRef.element = "1";
                }
                str6 = "1";
            }
            try {
                if (pageFlow != null) {
                    YYStatInfo yYStatInfo = new YYStatInfo();
                    stat = yYStatInfo;
                    if (yYStatInfo != null) {
                        yYStatInfo.isColdLaunch = isColdLaunch;
                        isColdLaunch = false;
                        yYStatInfo.loadType = "launch";
                        yYStatInfo.roomId = str;
                        if (!z) {
                            yYStatInfo.flowObj = pageFlow;
                            if (audioRtcFlow != null) {
                                yYStatInfo.flowAudioRtcObj = audioRtcFlow;
                            }
                            if (audioFlow != null) {
                                yYStatInfo.flowAudioObj = audioFlow;
                            }
                        } else {
                            INSTANCE.enterFlowEnd();
                        }
                    }
                    YYStatInfo yYStatInfo2 = stat;
                    YYStatInfo yYStatInfo3 = stat;
                    if (yYStatInfo3 != null) {
                        z4 = yYStatInfo3.isColdLaunch;
                    }
                    logPluginFlowEnd(yYStatInfo2, z4);
                    PluginInvokeService pluginInvokeService3 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                    if (pluginInvokeService3 != null) {
                        pluginInvokeService3.updateStatInfo(stat);
                    }
                    mRoomId = "";
                    pageFlow = null;
                    audioRtcFlow = null;
                    audioFlow = null;
                }
            } catch (Throwable th) {
                NpsLoadChainLog.getInstance().dLog("LiveMixShellManager enterLiveRoom exception: " + th.getMessage());
            }
            if (!TextUtils.isEmpty(jumpToOuterWebView(str3))) {
                PluginInvokeService pluginInvokeService4 = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
                if (pluginInvokeService4 != null) {
                    pluginInvokeService4.jumpToOuterWebView(context, str3);
                    return;
                }
                return;
            }
            MediaLiveEnterRoomRate.INSTANCE.doEnterUbcByRequestEnter(str, "enter_room_plugin1_loaded", "", "", str2, str6, (String) objectRef.element);
            startMixLiveActivity(context, str, str2, str3, uri, z, z2, (String) objectRef.element);
            return;
        }
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager enterLiveRoom 启动媒体一级插件未加载");
        PluginInvokeService pluginInvokeService5 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
        if (pluginInvokeService5 != null) {
            PluginInvokeService.DefaultImpls.loadPlugin$default(pluginInvokeService5, "com.baidu.searchbox.livenps", "startLiveActivity", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.mix.proxy.LiveMixShellManager$enterLiveRoom$3
                @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                public void onResult(boolean z5, int i, String str7) {
                    LivePreStartPlayerService livePreStartPlayerService;
                    boolean z6;
                    String str8;
                    Flow flow;
                    Flow flow2;
                    Flow flow3;
                    YYStatInfo stat2;
                    Flow flow4;
                    YYStatInfo stat3;
                    Flow flow5;
                    Flow flow6;
                    String str9;
                    String str10 = str7;
                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                    npsLoadChainLog2.dLog("LiveMixShellManager onResult 启动媒体一级插件加载结果：isSucc: " + z5 + "  retCode " + i + "  retMsg " + str10);
                    if (z5) {
                        LiveMixShellManager liveMixShellManager = LiveMixShellManager.INSTANCE;
                        z6 = LiveMixShellManager.isColdLaunch;
                        if (z6) {
                            str8 = "1";
                        } else {
                            str8 = "0";
                        }
                        String str11 = str8;
                        try {
                            LiveMixShellManager liveMixShellManager2 = LiveMixShellManager.INSTANCE;
                            flow = LiveMixShellManager.pageFlow;
                            if (flow != null) {
                                LiveMixShellManager.INSTANCE.setStat(new YYStatInfo());
                                YYStatInfo stat4 = LiveMixShellManager.INSTANCE.getStat();
                                boolean z7 = true;
                                if (stat4 != null) {
                                    stat4.isColdLaunch = true;
                                }
                                LiveMixShellManager liveMixShellManager3 = LiveMixShellManager.INSTANCE;
                                LiveMixShellManager.isColdLaunch = false;
                                YYStatInfo stat5 = LiveMixShellManager.INSTANCE.getStat();
                                if (stat5 != null) {
                                    stat5.loadType = "load";
                                }
                                YYStatInfo stat6 = LiveMixShellManager.INSTANCE.getStat();
                                if (stat6 != null) {
                                    LiveMixShellManager liveMixShellManager4 = LiveMixShellManager.INSTANCE;
                                    str9 = LiveMixShellManager.mRoomId;
                                    stat6.roomId = str9;
                                }
                                if (!z) {
                                    YYStatInfo stat7 = LiveMixShellManager.INSTANCE.getStat();
                                    if (stat7 != null) {
                                        LiveMixShellManager liveMixShellManager5 = LiveMixShellManager.INSTANCE;
                                        flow6 = LiveMixShellManager.pageFlow;
                                        stat7.flowObj = flow6;
                                    }
                                    LiveMixShellManager liveMixShellManager6 = LiveMixShellManager.INSTANCE;
                                    flow2 = LiveMixShellManager.audioRtcFlow;
                                    if (flow2 != null && (stat3 = LiveMixShellManager.INSTANCE.getStat()) != null) {
                                        LiveMixShellManager liveMixShellManager7 = LiveMixShellManager.INSTANCE;
                                        flow5 = LiveMixShellManager.audioRtcFlow;
                                        stat3.flowAudioRtcObj = flow5;
                                    }
                                    LiveMixShellManager liveMixShellManager8 = LiveMixShellManager.INSTANCE;
                                    flow3 = LiveMixShellManager.audioFlow;
                                    if (flow3 != null && (stat2 = LiveMixShellManager.INSTANCE.getStat()) != null) {
                                        LiveMixShellManager liveMixShellManager9 = LiveMixShellManager.INSTANCE;
                                        flow4 = LiveMixShellManager.audioFlow;
                                        stat2.flowAudioObj = flow4;
                                    }
                                } else {
                                    LiveMixShellManager.INSTANCE.enterFlowEnd();
                                }
                                LiveMixShellManager liveMixShellManager10 = LiveMixShellManager.INSTANCE;
                                YYStatInfo stat8 = LiveMixShellManager.INSTANCE.getStat();
                                YYStatInfo stat9 = LiveMixShellManager.INSTANCE.getStat();
                                if (stat9 != null) {
                                    z7 = stat9.isColdLaunch;
                                }
                                liveMixShellManager10.logPluginFlowEnd(stat8, z7);
                                PluginInvokeService pluginInvokeService6 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                                if (pluginInvokeService6 != null) {
                                    pluginInvokeService6.updateStatInfo(LiveMixShellManager.INSTANCE.getStat());
                                }
                                LiveMixShellManager liveMixShellManager11 = LiveMixShellManager.INSTANCE;
                                LiveMixShellManager.mRoomId = "";
                                LiveMixShellManager liveMixShellManager12 = LiveMixShellManager.INSTANCE;
                                LiveMixShellManager.pageFlow = null;
                                LiveMixShellManager liveMixShellManager13 = LiveMixShellManager.INSTANCE;
                                LiveMixShellManager.audioRtcFlow = null;
                                LiveMixShellManager liveMixShellManager14 = LiveMixShellManager.INSTANCE;
                                LiveMixShellManager.audioFlow = null;
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(LiveMixShellManager.INSTANCE.jumpToOuterWebView(str3))) {
                            PluginInvokeService pluginInvokeService7 = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
                            if (pluginInvokeService7 != null) {
                                pluginInvokeService7.jumpToOuterWebView(context, str3);
                                return;
                            }
                            return;
                        }
                        MediaLiveEnterRoomRate.INSTANCE.doEnterUbcByRequestEnter(str, "enter_room_plugin1_reloaded", "", "", str2, str11, (String) objectRef.element);
                        LiveMixShellManager.INSTANCE.startMixLiveActivity(context, str, str2, str3, uri, z, z2, (String) objectRef.element);
                        return;
                    }
                    LiveMixShellManager.INSTANCE.enterFlowEnd();
                    MediaLiveEnterRoomRate mediaLiveEnterRoomRate = MediaLiveEnterRoomRate.INSTANCE;
                    String str12 = str;
                    String valueOf = String.valueOf(i);
                    if (str10 == null) {
                        str10 = "";
                    }
                    mediaLiveEnterRoomRate.doEnterFirstSegmentPluginLoadError(str12, valueOf, str10, str2);
                    ToastService toastService = MiniPluginManager.INSTANCE.getToastService();
                    if (toastService != null) {
                        ToastService.DefaultImpls.showNormal$default(toastService, context, "加载失败，请稍后重试", 0, 4, null);
                    }
                    LiveMixShellManager liveMixShellManager15 = LiveMixShellManager.INSTANCE;
                    livePreStartPlayerService = LiveMixShellManager.preStartService;
                    if (livePreStartPlayerService != null) {
                        livePreStartPlayerService.releasePreStartPlayer();
                    }
                }
            }, false, 8, null);
        }
    }

    public static /* synthetic */ void enterLiveRoom$default(LiveMixShellManager liveMixShellManager, Context context, String str, String str2, String str3, Uri uri, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        if ((i & 64) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        liveMixShellManager.enterLiveRoom(context, str, str2, str3, uri, z, z3);
    }

    private final boolean entranceSupportPlayerReuse() {
        int i;
        boolean z;
        boolean z2;
        AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
        PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService != null) {
            i = pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps");
        } else {
            i = 0;
        }
        if (i > 601500000) {
            z = true;
        } else {
            z = false;
        }
        if (abConfigService != null) {
            z2 = abConfigService.getSwitch(MiniPluginManager.YY_AB_TEST_VIDEO_REUSE_SWITCH, false);
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    private final void npsLoadChainYYMixLive() {
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(npsLoadChainLog, "NpsLoadChainLog.getInstance()");
        npsLoadChainLog.setEntry("YYMixLive");
        NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(npsLoadChainLog2, "NpsLoadChainLog.getInstance()");
        PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
        npsLoadChainLog2.setPluginVersion((pluginMgrService == null || (r1 = String.valueOf(pluginMgrService.getPluginVersionCode("com.baidu.searchbox.yylive.entrance"))) == null) ? "" : "");
    }

    public final void enterFlowEnd() {
        Flow flow;
        Flow flow2;
        Flow flow3;
        UBCManager uBCManager = ubcManager;
        if (uBCManager != null && (flow3 = pageFlow) != null) {
            uBCManager.flowEnd(flow3);
            pageFlow = null;
        }
        UBCManager uBCManager2 = ubcManager;
        if (uBCManager2 != null && (flow2 = audioFlow) != null) {
            uBCManager2.flowEnd(flow2);
            audioFlow = null;
        }
        UBCManager uBCManager3 = ubcManager;
        if (uBCManager3 != null && (flow = audioRtcFlow) != null) {
            uBCManager3.flowEnd(flow);
            audioRtcFlow = null;
        }
        FlowInfoHelper.popFlow(mRoomId);
        mLaunchInfo = null;
        mRoomId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logPluginFlowEnd(YYStatInfo yYStatInfo, boolean z) {
        String str;
        HashMap<String, Object> hashMap = mLaunchInfo;
        if (hashMap != null && yYStatInfo != null) {
            FlowInfoHelper.put(hashMap, FlowInfoHelper.KEY_IS_COLDLAUNCH, Integer.valueOf(z ? 1 : 0));
            FlowInfoHelper.put(mLaunchInfo, FlowInfoHelper.KEY_ROOM_ID, mRoomId);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pkg", "com.baidu.searchbox.livenps");
                PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
                if (pluginMgrService == null || (str = String.valueOf(pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps"))) == null) {
                    str = "";
                }
                jSONObject.put("ver", str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FlowInfoHelper.put(mLaunchInfo, FlowInfoHelper.KEY_PLUGIN_INFO, jSONObject);
            yYStatInfo.statInfo = FlowInfoHelper.popFlow(mRoomId);
            mLaunchInfo = null;
        }
    }

    private final Map<String, String> parseYYLiveParamMap(String str) {
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        Map<String, String> stringToMap = MixUriUtilKt.stringToMap(MixUriUtilKt.getParamsStr(str));
        if (stringToMap.containsKey("params")) {
            try {
                String str2 = stringToMap.get("params");
                if (str2 != null) {
                    jSONObject = new JSONObject(str2);
                } else {
                    jSONObject = null;
                }
                stringToMap = MixUriUtilKt.paramsJsonToMap(jSONObject);
            } catch (Exception unused) {
                stringToMap = null;
            }
        }
        if (stringToMap != null) {
            String str3 = stringToMap.get("sid");
            String str4 = stringToMap.get(YyLiveRoomConfig.KEY_SSID);
            String str5 = stringToMap.get("anchorUid");
            String str6 = stringToMap.get("templateId");
            String str7 = stringToMap.get(YyLiveRoomConfig.KEY_STREAMINFO);
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "isMix=1", false, 2, (Object) null)) {
                hashMap.put("PreJoinChannelType", "mix");
            } else {
                hashMap.put("PreJoinChannelType", "startYYLive");
            }
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("PreJoinChannelSid", str3);
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("PreJoinChannelSsid", str4);
            if (str6 == null) {
                str6 = "";
            }
            hashMap.put("PreJoinChannelTemplateId", str6);
            if (str5 == null) {
                str5 = "";
            }
            hashMap.put("PreJoinChannelAnchorId", str5);
            if (str7 == null) {
                str7 = "";
            }
            hashMap.put("PreJoinChannelStreamInfo", str7);
        }
        return hashMap;
    }

    private final void preloadMediaPlugin() {
        Boolean bool;
        PluginInvokeService pluginInvokeService;
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager preloadMediaPlugin");
        AbConfigService abConfigService = abService;
        int i = 0;
        if (abConfigService != null) {
            bool = Boolean.valueOf(abConfigService.getSwitch(MiniPluginManager.PROHIBIT_PRE_LOAD_MEDIA_SWITCH, false));
        } else {
            bool = null;
        }
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.dLog("LiveMixShellManager 禁止预加载二级实验：" + bool);
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) && (pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService()) != null && !pluginInvokeService.isPluginLoaded("com.baidu.live.media.business")) {
            PluginInvokeService pluginInvokeService2 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
            if (pluginInvokeService2 != null) {
                i = pluginInvokeService2.getPluginVersionCode("com.baidu.searchbox.livenps");
            }
            if (i >= 600500000) {
                MiniPluginManager.INSTANCE.loadMediaPlugin(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.mix.proxy.LiveMixShellManager$preloadMediaPlugin$1
                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z, int i2, String str) {
                        NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                        npsLoadChainLog2.dLog("LiveMixShellManager preloadMediaPlugin result " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void startLiveActivity(final Context context, String str, String str2, String str3, Uri uri, Boolean bool, boolean z, String str4) {
        boolean z2;
        int i;
        boolean z3;
        Boolean bool2;
        int i2;
        boolean z4;
        Integer num;
        String str5;
        boolean z5;
        String optString;
        YYStatInfo yYStatInfo;
        Boolean bool3;
        boolean z6;
        final Intent intent;
        Class cls;
        IVideoInsertLiveService iVideoInsertLiveService;
        Uri uri2;
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager startLiveActivity，isYYMixLive " + bool);
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            preloadMediaPlugin();
        }
        AbConfigService abConfigService = abService;
        boolean z7 = false;
        if (abConfigService != null) {
            z2 = abConfigService.getSwitch(MiniPluginManager.LIVE_LEFT_SLIDE_CLOSE_ROOM_SWITCH, false);
        } else {
            z2 = false;
        }
        PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService != null) {
            i = pluginMgrService.getPluginVersionCode("com.baidu.live.media.business");
        } else {
            i = 0;
        }
        if (z2 && i >= 604000000) {
            z3 = true;
        } else {
            z3 = false;
        }
        AbConfigService abConfigService2 = abService;
        if (abConfigService2 != null) {
            bool2 = Boolean.valueOf(abConfigService2.getSwitch(MiniPluginManager.LIVE_MEDIA_KERNAL_REUSE_SWITCH, false));
        } else {
            bool2 = null;
        }
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager startLiveActivity 泛知识内核复用开关：" + bool2);
        PluginInvokeService pluginMgrService2 = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService2 != null) {
            i2 = pluginMgrService2.getPluginVersionCode("com.baidu.searchbox.livenps");
        } else {
            i2 = 0;
        }
        if (i2 >= 601500000 && Intrinsics.areEqual(bool2, Boolean.TRUE)) {
            z4 = true;
        } else {
            z4 = false;
        }
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("LiveMixShellManager npsVersion：");
        PluginInvokeService pluginMgrService3 = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService3 != null) {
            num = Integer.valueOf(pluginMgrService3.getPluginVersionCode("com.baidu.searchbox.livenps"));
        } else {
            num = null;
        }
        sb.append(num);
        npsLoadChainLog.dLog(sb.toString());
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            boolean entranceSupportPlayerReuse = entranceSupportPlayerReuse();
            if (z4 && entranceSupportPlayerReuse) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager isPluginSupportKernalReuse：" + z4);
        String str6 = "";
        if (str3 == null) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if (!StringsKt__StringsKt.contains$default((CharSequence) str5, (CharSequence) "playUrl", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) str5, (CharSequence) "play_url", false, 2, (Object) null)) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!TextUtils.isEmpty(str5)) {
            try {
                optString = new JSONObject(str5).optString("playerIdentifier");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            yYStatInfo = stat;
            if (yYStatInfo == null) {
                bool3 = Boolean.valueOf(yYStatInfo.isColdLaunch);
            } else {
                bool3 = null;
            }
            booleanRef.element = Intrinsics.areEqual(bool3, Boolean.TRUE);
            MediaLivePluginLogger companion = MediaLivePluginLogger.Companion.getInstance();
            if (str != null) {
                str6 = str;
            }
            companion.updateStartPageInfo(str6, str2, z5, booleanRef.element, str4);
            MediaLivePluginLogger.Companion.getInstance().logLiveRoomStartPage();
            MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartPage();
            LiveComponentLoadLogger.Companion.getInstance().externalLiveLaunchMediaCompLoadFlow(stat);
            if (!z4 && !TextUtils.isEmpty(optString)) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6 && !z3) {
                cls = MixLiveActivity.class;
            } else {
                cls = MixLiveTranslucentActivity.class;
            }
            intent = new Intent(context, cls);
            intent.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            intent.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (PluginContextUtil.INSTANCE.getActivity(context) instanceof Activity) {
                intent.addFlags(134217728);
            }
            intent.putExtra("roomId", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("source", str2);
            }
            if (!TextUtils.isEmpty(str5)) {
                intent.putExtra("params", str5);
            }
            if (uri != null) {
                if (z6) {
                    Uri.Builder path = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath());
                    Set<String> queryParameterNames = uri.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String str7 : queryParameterNames) {
                            path.appendQueryParameter(str7, uri.getQueryParameter(str7));
                        }
                    }
                    uri2 = path.appendQueryParameter(MiniPluginManager.PLAY_AB_SWITCH, "true").build();
                    Intrinsics.checkExpressionValueIsNotNull(uri2, "builder.appendQueryParam…B_SWITCH, \"true\").build()");
                } else {
                    uri2 = uri;
                }
                intent.putExtra("scheme", uri2.toString());
            }
            intent.putExtra("translucent", z6);
            if (z3 && !z6) {
                z7 = true;
            }
            intent.putExtra("enterWithAnimation", z7);
            intent.putExtra("preStartPlayer", z);
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager translucent " + z6);
            stat = null;
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager 启动混排 Activity");
            if (!(!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) && (iVideoInsertLiveService = (IVideoInsertLiveService) ServiceManager.getService(IVideoInsertLiveService.Companion.getSERVICE_REFERENCE())) != null && iVideoInsertLiveService.needReleaseLive()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.live.mix.proxy.LiveMixShellManager$startLiveActivity$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMixShellManager.INSTANCE.releaseAndStartLiveActivity(intent, context);
                    }
                });
                return;
            }
            releaseAndStartLiveActivity(intent, context);
        }
        optString = null;
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        yYStatInfo = stat;
        if (yYStatInfo == null) {
        }
        booleanRef2.element = Intrinsics.areEqual(bool3, Boolean.TRUE);
        MediaLivePluginLogger companion2 = MediaLivePluginLogger.Companion.getInstance();
        if (str != null) {
        }
        companion2.updateStartPageInfo(str6, str2, z5, booleanRef2.element, str4);
        MediaLivePluginLogger.Companion.getInstance().logLiveRoomStartPage();
        MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartPage();
        LiveComponentLoadLogger.Companion.getInstance().externalLiveLaunchMediaCompLoadFlow(stat);
        if (!z4) {
        }
        z6 = false;
        if (z6) {
        }
        cls = MixLiveTranslucentActivity.class;
        intent = new Intent(context, cls);
        intent.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        intent.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
        if (PluginContextUtil.INSTANCE.getActivity(context) instanceof Activity) {
        }
        intent.putExtra("roomId", str);
        if (!TextUtils.isEmpty(str2)) {
        }
        if (!TextUtils.isEmpty(str5)) {
        }
        if (uri != null) {
        }
        intent.putExtra("translucent", z6);
        if (z3) {
            z7 = true;
        }
        intent.putExtra("enterWithAnimation", z7);
        intent.putExtra("preStartPlayer", z);
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager translucent " + z6);
        stat = null;
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager 启动混排 Activity");
        if (!(!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))) {
        }
        releaseAndStartLiveActivity(intent, context);
    }

    public static /* synthetic */ void startLiveActivity$default(LiveMixShellManager liveMixShellManager, Context context, String str, String str2, String str3, Uri uri, Boolean bool, boolean z, String str4, int i, Object obj) {
        Boolean bool2;
        boolean z2;
        String str5;
        if ((i & 32) != 0) {
            bool2 = Boolean.FALSE;
        } else {
            bool2 = bool;
        }
        if ((i & 64) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i & 128) != 0) {
            str5 = null;
        } else {
            str5 = str4;
        }
        liveMixShellManager.startLiveActivity(context, str, str2, str3, uri, bool2, z2, str5);
    }

    public static /* synthetic */ void startMixLiveActivity$default(LiveMixShellManager liveMixShellManager, Context context, String str, String str2, String str3, Uri uri, boolean z, boolean z2, String str4, int i, Object obj) {
        boolean z3;
        String str5;
        if ((i & 64) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        if ((i & 128) != 0) {
            str5 = null;
        } else {
            str5 = str4;
        }
        liveMixShellManager.startMixLiveActivity(context, str, str2, str3, uri, z, z3, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startMixLiveActivity(final Context context, final String str, final String str2, final String str3, final Uri uri, final boolean z, boolean z2, final String str4) {
        PluginInvokeService pluginInvokeService;
        String it;
        PluginInvokeService pluginInvokeService2 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
        if (pluginInvokeService2 != null) {
            pluginInvokeService2.checkPreLoadLiveNpsUpdate();
        }
        if (z) {
            npsLoadChainYYMixLive();
            if (uri != null && (it = uri.toString()) != null) {
                LiveMixShellManager liveMixShellManager = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                YYStaticConfig.conf.putAll(liveMixShellManager.parseYYLiveParamMap(it));
            }
        }
        if (z && (pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService()) != null && !pluginInvokeService.isPluginLoaded("com.baidu.searchbox.yylive.entrance")) {
            HashMap hashMap = new HashMap();
            if (uri != null) {
                String str5 = (String) hashMap.put("uri", uri.toString());
            }
            PluginInvokeService pluginInvokeService3 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
            if (pluginInvokeService3 != null) {
                pluginInvokeService3.loadPlugin(null, "com.baidu.searchbox.yylive.entrance", "startLiveActivity", true, true, hashMap, new PluginLoadCallback() { // from class: com.baidu.searchbox.live.mix.proxy.LiveMixShellManager$startMixLiveActivity$3
                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z3, int i, String str6) {
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                        npsLoadChainLog.dLog("LiveMixShellManager onResult 启动媒体一级插件加载结果：isSucc: " + z3 + "  retCode " + i + "  retMsg " + str6);
                        if (z3) {
                            if (i == -100100) {
                                return;
                            }
                            LiveMixShellManager.INSTANCE.startLiveActivity(context, str, str2, str3, uri, Boolean.valueOf(z), false, str4);
                            return;
                        }
                        MediaLiveEnterRoomRate.INSTANCE.doEnterFirstSegmentPluginYYLoadError(str, String.valueOf(i), str6, str2);
                        ToastService toastService = MiniPluginManager.INSTANCE.getToastService();
                        if (toastService != null) {
                            ToastService.DefaultImpls.showNormal$default(toastService, context, "加载失败，请稍后重试", 0, 4, null);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (z) {
            if (YYStaticConfig.conf == null) {
                YYStaticConfig.conf = new HashMap<>();
            }
            HashMap<String, Object> hashMap2 = YYStaticConfig.conf;
            Intrinsics.checkExpressionValueIsNotNull(hashMap2, "YYStaticConfig.conf");
            hashMap2.put("hostJoinLivePluginFromStatus", "direct");
        }
        startLiveActivity(context, str, str2, str3, uri, Boolean.valueOf(z), z2, str4);
    }

    public final String jumpToOuterWebView(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Log.d("enter_outlive_weburl", "LiveMediaEntryProxy: params: " + str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                String optString = jSONObject.optString("params");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (TextUtils.equals("1", jSONObject2.optString("enter_outlive_commonwebview", ""))) {
                        String jSONObject3 = jSONObject2.toString();
                        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "tieBaParamsJSONObject.toString()");
                        return jSONObject3;
                    }
                }
            } else if (!TextUtils.equals("1", jSONObject.optString("enter_outlive_commonwebview", "")) || str == null) {
                return "";
            } else {
                return str;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public final void startYYLiveActivity(Context context, String str) {
        Map<String, String> map;
        int i;
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.dLog("LiveMixShellManager startYYLiveActivity " + str);
        Map<String, String> stringToMap = MixUriUtilKt.stringToMap(MixUriUtilKt.getParamsStr(str));
        String str2 = stringToMap.get("params");
        if (str2 != null) {
            try {
                map = MixUriUtilKt.paramsJsonToMap(new JSONObject(str2));
            } catch (Exception unused) {
                map = stringToMap;
            }
            if (map != null) {
                stringToMap = map;
            }
        }
        PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
        boolean z = false;
        if (pluginMgrService != null) {
            i = pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps");
        } else {
            i = 0;
        }
        z = (i == 0 || i >= 500500000) ? true : true;
        if (stringToMap.containsKey("isMix") && z) {
            if (Intrinsics.areEqual("1", stringToMap.get("isMix"))) {
                String str3 = stringToMap.get("roomId");
                String str4 = stringToMap.get("source");
                if (!stringToMap.containsKey("roomType")) {
                    stringToMap.put("roomType", "3");
                }
                String bundleToJsonStr = MiniJsonUtils.INSTANCE.bundleToJsonStr(stringToMap);
                NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                npsLoadChainLog2.dLog("LiveMixShellManager startYYLiveActivity  enterLiveRoom roomId " + str3 + " source " + str4 + " params " + bundleToJsonStr);
                if (YYStaticConfig.conf == null) {
                    YYStaticConfig.conf = new HashMap<>();
                }
                HashMap<String, Object> hashMap = YYStaticConfig.conf;
                Intrinsics.checkExpressionValueIsNotNull(hashMap, "YYStaticConfig.conf");
                hashMap.put("hostJoinLiveBegin", Long.valueOf(System.currentTimeMillis()));
                enterLiveRoom$default(this, context, str3, str4, bundleToJsonStr, Uri.parse(str), true, false, 64, null);
                return;
            }
            PluginInvokeService pluginMgrService2 = MiniPluginManager.INSTANCE.getPluginMgrService();
            if (pluginMgrService2 != null) {
                pluginMgrService2.realJumpYY(context, str);
            }
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager startYYLiveActivity isMix = false");
            return;
        }
        PluginInvokeService pluginMgrService3 = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService3 != null) {
            pluginMgrService3.realJumpYY(context, str);
        }
        NpsLoadChainLog.getInstance().dLog("LiveMixShellManager startYYLiveActivity");
    }
}
