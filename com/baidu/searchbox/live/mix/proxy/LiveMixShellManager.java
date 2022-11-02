package com.baidu.searchbox.live.mix.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.player.internal.LivePreStartPlayerService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.interfaces.yy.YYStaticConfig;
import com.baidu.searchbox.live.list.MixLiveTranslucentActivity;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.searchbox.live.ubc.LiveComponentLoadLogger;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.LiveActivityUtil;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\bO\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014JQ\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0001H\u0002¢\u0006\u0004\b$\u0010\u0003J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0001H\u0002¢\u0006\u0004\b)\u0010\u0003JU\u0010*\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b*\u0010+JQ\u0010,\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b,\u0010\u0018J\u001d\u0010-\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00100R\u001e\u00106\u001a\n 5*\u0004\u0018\u000104048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010:R\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010<R6\u0010@\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>\u0018\u0001`?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00100R\u0018\u0010C\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010:R\u001e\u0010E\u001a\n 5*\u0004\u0018\u00010D0D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010M\u001a\n 5*\u0004\u0018\u00010L0L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/baidu/searchbox/live/mix/proxy/LiveMixShellManager;", "", "enterFlowEnd", "()V", "", "slot", "enterFlowEndSlot", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "jsonObject", "enterFlowStartSlot", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Landroid/content/Context;", "context", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "params", "Landroid/net/Uri;", "uri", "enterLiveRoom", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "", "isYYMixLive", "preStartPlayer", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZZ)V", "entranceSupportPlayerReuse", "()Z", "getCurrentLoadRoomId", "()Ljava/lang/String;", "jumpToOuterWebView", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "stat", FlowInfoHelper.KEY_IS_COLDLAUNCH, "logPluginFlowEnd", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;Z)V", "npsLoadChainYYMixLive", "url", "", "parseYYLiveParamMap", "(Ljava/lang/String;)Ljava/util/Map;", "preloadMediaPlugin", "startLiveActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Boolean;Z)V", "startMixLiveActivity", LiveYYPluginManager.USE_FROM_START_YY_LIVE_PAGE, "(Landroid/content/Context;Ljava/lang/String;)V", "KEY_ID_AUDIO_ENTER_AUDIO_ROOM_PERF_FLOW", "Ljava/lang/String;", "KEY_ID_AUDIO_RTC_JOIN", "UBC_ID_PLUGIN_PAGE_FLOW", "USE_FROM_START_LIVE_PAGE", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "Lcom/baidu/ubc/Flow;", "audioFlow", "Lcom/baidu/ubc/Flow;", "audioRtcFlow", "Z", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mLaunchInfo", "Ljava/util/HashMap;", "mRoomId", "pageFlow", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "preStartService", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePreStartPlayerService;", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "getStat", "()Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "setStat", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "Lcom/baidu/ubc/UBCManager;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveMixShellManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final LiveMixShellManager INSTANCE;
    public static final String KEY_ID_AUDIO_ENTER_AUDIO_ROOM_PERF_FLOW = "2408";
    public static final String KEY_ID_AUDIO_RTC_JOIN = "2415";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3180";
    public static final String USE_FROM_START_LIVE_PAGE = "startLiveActivity";
    public static final AbConfigService abService;
    public static Flow audioFlow;
    public static Flow audioRtcFlow;
    public static boolean isColdLaunch;
    public static HashMap<String, Object> mLaunchInfo;
    public static String mRoomId;
    public static Flow pageFlow;
    public static final LivePreStartPlayerService preStartService;
    public static YYStatInfo stat;
    public static final UBCManager ubcManager;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(131449227, "Lcom/baidu/searchbox/live/mix/proxy/LiveMixShellManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(131449227, "Lcom/baidu/searchbox/live/mix/proxy/LiveMixShellManager;");
                return;
            }
        }
        INSTANCE = new LiveMixShellManager();
        ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        abService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
        preStartService = (LivePreStartPlayerService) ServiceManager.getService(LivePreStartPlayerService.Companion.getSERVICE_REFERENCE());
        mRoomId = "";
        isColdLaunch = true;
    }

    private final boolean entranceSupportPlayerReuse() {
        InterceptResult invokeV;
        int i;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public LiveMixShellManager() {
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

    public final String getCurrentLoadRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return mRoomId;
        }
        return (String) invokeV.objValue;
    }

    public final YYStatInfo getStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return stat;
        }
        return (YYStatInfo) invokeV.objValue;
    }

    public final void enterFlowEndSlot(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && ubcManager != null && pageFlow != null && !TextUtils.isEmpty(str)) {
            ubcManager.flowEndSlot(pageFlow, str);
        }
    }

    public final void setStat(YYStatInfo yYStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yYStatInfo) == null) {
            stat = yYStatInfo;
        }
    }

    public final void enterFlowStartSlot(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) && ubcManager != null && pageFlow != null && !TextUtils.isEmpty(str)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, str, str2, str3, uri) == null) {
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
    }

    private final void enterLiveRoom(final Context context, final String str, final String str2, final String str3, final Uri uri, final boolean z, final boolean z2) {
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{context, str, str2, str3, uri, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
            boolean z3 = false;
            if (mLaunchInfo == null) {
                mLaunchInfo = FlowInfoHelper.startNewFlow(str, false);
            }
            if (z2) {
                FlowInfoHelper.startSigleLineSlot(mLaunchInfo, "pre_start_play", true);
            }
            if (str == null) {
                str5 = "";
            } else {
                str5 = str;
            }
            mRoomId = str5;
            PluginInvokeService pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
            if (pluginInvokeService != null && pluginInvokeService.isPluginLoaded("com.baidu.searchbox.livenps")) {
                NpsLoadChainLog.getInstance().dLog("LiveMixShellManager enterLiveRoom 媒体一级插件已加载");
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
                            z3 = yYStatInfo3.isColdLaunch;
                        }
                        logPluginFlowEnd(yYStatInfo2, z3);
                        PluginInvokeService pluginInvokeService2 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                        if (pluginInvokeService2 != null) {
                            pluginInvokeService2.updateStatInfo(stat);
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
                    PluginInvokeService pluginInvokeService3 = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
                    if (pluginInvokeService3 != null) {
                        pluginInvokeService3.jumpToOuterWebView(context, str3);
                        return;
                    }
                    return;
                }
                startMixLiveActivity(context, str, str2, str3, uri, z, z2);
                return;
            }
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager enterLiveRoom 启动媒体一级插件未加载");
            PluginInvokeService pluginInvokeService4 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
            if (pluginInvokeService4 != null) {
                PluginInvokeService.DefaultImpls.loadPlugin$default(pluginInvokeService4, "com.baidu.searchbox.livenps", "startLiveActivity", new PluginLoadCallback(z, str3, context, str, str2, uri, z2) { // from class: com.baidu.searchbox.live.mix.proxy.LiveMixShellManager$enterLiveRoom$3
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Context $context;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean $isYYMixLive;
                    public final /* synthetic */ String $params;
                    public final /* synthetic */ boolean $preStartPlayer;
                    public final /* synthetic */ String $roomId;
                    public final /* synthetic */ String $source;
                    public final /* synthetic */ Uri $uri;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z), str3, context, str, str2, uri, Boolean.valueOf(z2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$isYYMixLive = z;
                        this.$params = str3;
                        this.$context = context;
                        this.$roomId = str;
                        this.$source = str2;
                        this.$uri = uri;
                        this.$preStartPlayer = z2;
                    }

                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z4, int i, String str6) {
                        Flow flow;
                        Flow flow2;
                        Flow flow3;
                        YYStatInfo stat2;
                        Flow flow4;
                        YYStatInfo stat3;
                        Flow flow5;
                        Flow flow6;
                        String str7;
                        LivePreStartPlayerService livePreStartPlayerService;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z4), Integer.valueOf(i), str6}) == null) {
                            NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                            npsLoadChainLog2.dLog("LiveMixShellManager onResult 启动媒体一级插件加载结果：isSucc: " + z4 + "  retCode " + i + "  retMsg " + str6);
                            if (z4) {
                                try {
                                    LiveMixShellManager liveMixShellManager = LiveMixShellManager.INSTANCE;
                                    flow = LiveMixShellManager.pageFlow;
                                    if (flow != null) {
                                        LiveMixShellManager.INSTANCE.setStat(new YYStatInfo());
                                        YYStatInfo stat4 = LiveMixShellManager.INSTANCE.getStat();
                                        boolean z5 = true;
                                        if (stat4 != null) {
                                            stat4.isColdLaunch = true;
                                        }
                                        LiveMixShellManager liveMixShellManager2 = LiveMixShellManager.INSTANCE;
                                        LiveMixShellManager.isColdLaunch = false;
                                        YYStatInfo stat5 = LiveMixShellManager.INSTANCE.getStat();
                                        if (stat5 != null) {
                                            stat5.loadType = "load";
                                        }
                                        YYStatInfo stat6 = LiveMixShellManager.INSTANCE.getStat();
                                        if (stat6 != null) {
                                            LiveMixShellManager liveMixShellManager3 = LiveMixShellManager.INSTANCE;
                                            str7 = LiveMixShellManager.mRoomId;
                                            stat6.roomId = str7;
                                        }
                                        if (!this.$isYYMixLive) {
                                            YYStatInfo stat7 = LiveMixShellManager.INSTANCE.getStat();
                                            if (stat7 != null) {
                                                LiveMixShellManager liveMixShellManager4 = LiveMixShellManager.INSTANCE;
                                                flow6 = LiveMixShellManager.pageFlow;
                                                stat7.flowObj = flow6;
                                            }
                                            LiveMixShellManager liveMixShellManager5 = LiveMixShellManager.INSTANCE;
                                            flow2 = LiveMixShellManager.audioRtcFlow;
                                            if (flow2 != null && (stat3 = LiveMixShellManager.INSTANCE.getStat()) != null) {
                                                LiveMixShellManager liveMixShellManager6 = LiveMixShellManager.INSTANCE;
                                                flow5 = LiveMixShellManager.audioRtcFlow;
                                                stat3.flowAudioRtcObj = flow5;
                                            }
                                            LiveMixShellManager liveMixShellManager7 = LiveMixShellManager.INSTANCE;
                                            flow3 = LiveMixShellManager.audioFlow;
                                            if (flow3 != null && (stat2 = LiveMixShellManager.INSTANCE.getStat()) != null) {
                                                LiveMixShellManager liveMixShellManager8 = LiveMixShellManager.INSTANCE;
                                                flow4 = LiveMixShellManager.audioFlow;
                                                stat2.flowAudioObj = flow4;
                                            }
                                        } else {
                                            LiveMixShellManager.INSTANCE.enterFlowEnd();
                                        }
                                        LiveMixShellManager liveMixShellManager9 = LiveMixShellManager.INSTANCE;
                                        YYStatInfo stat8 = LiveMixShellManager.INSTANCE.getStat();
                                        YYStatInfo stat9 = LiveMixShellManager.INSTANCE.getStat();
                                        if (stat9 != null) {
                                            z5 = stat9.isColdLaunch;
                                        }
                                        liveMixShellManager9.logPluginFlowEnd(stat8, z5);
                                        PluginInvokeService pluginInvokeService5 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                                        if (pluginInvokeService5 != null) {
                                            pluginInvokeService5.updateStatInfo(LiveMixShellManager.INSTANCE.getStat());
                                        }
                                        LiveMixShellManager liveMixShellManager10 = LiveMixShellManager.INSTANCE;
                                        LiveMixShellManager.mRoomId = "";
                                        LiveMixShellManager liveMixShellManager11 = LiveMixShellManager.INSTANCE;
                                        LiveMixShellManager.pageFlow = null;
                                        LiveMixShellManager liveMixShellManager12 = LiveMixShellManager.INSTANCE;
                                        LiveMixShellManager.audioRtcFlow = null;
                                        LiveMixShellManager liveMixShellManager13 = LiveMixShellManager.INSTANCE;
                                        LiveMixShellManager.audioFlow = null;
                                    }
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                                if (!TextUtils.isEmpty(LiveMixShellManager.INSTANCE.jumpToOuterWebView(this.$params))) {
                                    PluginInvokeService pluginInvokeService6 = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
                                    if (pluginInvokeService6 != null) {
                                        pluginInvokeService6.jumpToOuterWebView(this.$context, this.$params);
                                        return;
                                    }
                                    return;
                                }
                                LiveMixShellManager.INSTANCE.startMixLiveActivity(this.$context, this.$roomId, this.$source, this.$params, this.$uri, this.$isYYMixLive, this.$preStartPlayer);
                                return;
                            }
                            LiveMixShellManager.INSTANCE.enterFlowEnd();
                            ToastService toastService = MiniPluginManager.INSTANCE.getToastService();
                            if (toastService != null) {
                                ToastService.DefaultImpls.showNormal$default(toastService, this.$context, "加载失败，请稍后重试", 0, 4, null);
                            }
                            LiveMixShellManager liveMixShellManager14 = LiveMixShellManager.INSTANCE;
                            livePreStartPlayerService = LiveMixShellManager.preStartService;
                            if (livePreStartPlayerService != null) {
                                livePreStartPlayerService.releasePreStartPlayer();
                            }
                        }
                    }
                }, false, 8, null);
            }
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

    public static /* synthetic */ void startLiveActivity$default(LiveMixShellManager liveMixShellManager, Context context, String str, String str2, String str3, Uri uri, Boolean bool, boolean z, int i, Object obj) {
        Boolean bool2;
        boolean z2;
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
        liveMixShellManager.startLiveActivity(context, str, str2, str3, uri, bool2, z2);
    }

    public static /* synthetic */ void startMixLiveActivity$default(LiveMixShellManager liveMixShellManager, Context context, String str, String str2, String str3, Uri uri, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        if ((i & 64) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        liveMixShellManager.startMixLiveActivity(context, str, str2, str3, uri, z, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logPluginFlowEnd(YYStatInfo yYStatInfo, boolean z) {
        HashMap<String, Object> hashMap;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65556, this, yYStatInfo, z) == null) && (hashMap = mLaunchInfo) != null && yYStatInfo != null) {
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

    private final void npsLoadChainYYMixLive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(npsLoadChainLog, "NpsLoadChainLog.getInstance()");
            npsLoadChainLog.setEntry("YYMixLive");
            NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(npsLoadChainLog2, "NpsLoadChainLog.getInstance()");
            PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
            npsLoadChainLog2.setPluginVersion((pluginMgrService == null || (r1 = String.valueOf(pluginMgrService.getPluginVersionCode("com.baidu.searchbox.yylive.entrance"))) == null) ? "" : "");
        }
    }

    public final void enterFlowEnd() {
        Flow flow;
        Flow flow2;
        Flow flow3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    private final Map<String, String> parseYYLiveParamMap(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, str)) == null) {
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
        return (Map) invokeL.objValue;
    }

    private final void preloadMediaPlugin() {
        Boolean bool;
        PluginInvokeService pluginInvokeService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
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
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                        public void onResult(boolean z, int i2, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) {
                                NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                                npsLoadChainLog2.dLog("LiveMixShellManager preloadMediaPlugin result " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void startLiveActivity(Context context, String str, String str2, String str3, Uri uri, Boolean bool, boolean z) {
        boolean z2;
        int i;
        boolean z3;
        Boolean bool2;
        int i2;
        boolean z4;
        Integer num;
        String str4;
        boolean z5;
        String optString;
        YYStatInfo yYStatInfo;
        Boolean bool3;
        boolean z6;
        Class<MixLiveTranslucentActivity> cls;
        Uri uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{context, str, str2, str3, uri, bool, Boolean.valueOf(z)}) == null) {
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager startLiveActivity，isYYMixLive " + bool);
            boolean z7 = true;
            if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                preloadMediaPlugin();
            }
            AbConfigService abConfigService = abService;
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
            String str5 = "";
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            if (!StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) "playUrl", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) "play_url", false, 2, (Object) null)) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (!TextUtils.isEmpty(str4)) {
                try {
                    optString = new JSONObject(str4).optString("playerIdentifier");
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
                    str5 = str;
                }
                companion.updateStartPageInfo(str5, str2, z5, booleanRef.element);
                MediaLivePluginLogger.Companion.getInstance().logLiveRoomStartPage();
                MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartPage();
                LiveComponentLoadLogger.Companion.getInstance().externalLiveLaunchMediaCompLoadFlow(stat);
                if (!z4 && !TextUtils.isEmpty(optString)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6 && !z3) {
                    cls = MixLiveTranslucentActivity.class;
                } else {
                    cls = MixLiveTranslucentActivity.class;
                }
                Intent intent = new Intent(context, cls);
                intent.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                intent.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                if (context instanceof Activity) {
                    intent.addFlags(134217728);
                }
                intent.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str);
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra("source", str2);
                }
                if (!TextUtils.isEmpty(str4)) {
                    intent.putExtra("params", str4);
                }
                if (uri != null) {
                    if (z6) {
                        Uri.Builder path = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath());
                        Set<String> queryParameterNames = uri.getQueryParameterNames();
                        if (queryParameterNames != null) {
                            for (String str6 : queryParameterNames) {
                                path.appendQueryParameter(str6, uri.getQueryParameter(str6));
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
                intent.putExtra("enterWithAnimation", (z3 || z6) ? false : false);
                intent.putExtra("preStartPlayer", z);
                NpsLoadChainLog.getInstance().dLog("LiveMixShellManager translucent " + z6);
                stat = null;
                NpsLoadChainLog.getInstance().dLog("LiveMixShellManager 启动混排 Activity");
                LiveActivityUtil.startActivitySafely(context, intent);
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
            companion2.updateStartPageInfo(str5, str2, z5, booleanRef2.element);
            MediaLivePluginLogger.Companion.getInstance().logLiveRoomStartPage();
            MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartPage();
            LiveComponentLoadLogger.Companion.getInstance().externalLiveLaunchMediaCompLoadFlow(stat);
            if (!z4) {
            }
            z6 = false;
            if (z6) {
            }
            cls = MixLiveTranslucentActivity.class;
            Intent intent2 = new Intent(context, cls);
            intent2.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            intent2.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (context instanceof Activity) {
            }
            intent2.putExtra(ILiveNPSPlugin.PARAMS_ROOM_ID, str);
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            if (uri != null) {
            }
            intent2.putExtra("translucent", z6);
            intent2.putExtra("enterWithAnimation", (z3 || z6) ? false : false);
            intent2.putExtra("preStartPlayer", z);
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager translucent " + z6);
            stat = null;
            NpsLoadChainLog.getInstance().dLog("LiveMixShellManager 启动混排 Activity");
            LiveActivityUtil.startActivitySafely(context, intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startMixLiveActivity(final Context context, final String str, final String str2, final String str3, final Uri uri, final boolean z, boolean z2) {
        PluginInvokeService pluginInvokeService;
        String it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{context, str, str2, str3, uri, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
                    String str4 = (String) hashMap.put("uri", uri.toString());
                }
                PluginInvokeService pluginInvokeService2 = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                if (pluginInvokeService2 != null) {
                    pluginInvokeService2.loadPlugin(null, "com.baidu.searchbox.yylive.entrance", "startLiveActivity", true, true, hashMap, new PluginLoadCallback(context, str, str2, str3, uri, z) { // from class: com.baidu.searchbox.live.mix.proxy.LiveMixShellManager$startMixLiveActivity$3
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ Context $context;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ boolean $isYYMixLive;
                        public final /* synthetic */ String $params;
                        public final /* synthetic */ String $roomId;
                        public final /* synthetic */ String $source;
                        public final /* synthetic */ Uri $uri;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, str, str2, str3, uri, Boolean.valueOf(z)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.$context = context;
                            this.$roomId = str;
                            this.$source = str2;
                            this.$params = str3;
                            this.$uri = uri;
                            this.$isYYMixLive = z;
                        }

                        @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                        public void onResult(boolean z3, int i, String str5) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z3), Integer.valueOf(i), str5}) == null) {
                                NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                                npsLoadChainLog.dLog("LiveMixShellManager onResult 启动媒体一级插件加载结果：isSucc: " + z3 + "  retCode " + i + "  retMsg " + str5);
                                if (z3) {
                                    if (i == -100100) {
                                        return;
                                    }
                                    LiveMixShellManager.INSTANCE.startLiveActivity(this.$context, this.$roomId, this.$source, this.$params, this.$uri, Boolean.valueOf(this.$isYYMixLive), false);
                                    return;
                                }
                                ToastService toastService = MiniPluginManager.INSTANCE.getToastService();
                                if (toastService != null) {
                                    ToastService.DefaultImpls.showNormal$default(toastService, this.$context, "加载失败，请稍后重试", 0, 4, null);
                                }
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
            startLiveActivity(context, str, str2, str3, uri, Boolean.valueOf(z), z2);
        }
    }

    public final String jumpToOuterWebView(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public final void startYYLiveActivity(Context context, String str) {
        Map<String, String> map;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
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
                    String str3 = stringToMap.get(ILiveNPSPlugin.PARAMS_ROOM_ID);
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
}
