package com.baidu.searchbox.live.ubc;

import android.text.TextUtils;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MixNetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILivePageInfoInterface;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.live.ubc.LiveComponentStatusHelper;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b9\u0010\u001fJ)\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001a\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u000bR%\u0010(\u001a\n #*\u0004\u0018\u00010\"0\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;", "com/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish", "", "roomId", "source", "templateId", "", "bindRoomIdToExternalEnterFlow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "key", "cancelCurrentComponentFlow", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "ext", "contentItem", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "endCurrentComponentFlow", "", "statInfo", "externalLiveLaunchMediaCompLoadFlow", "(Ljava/lang/Object;)V", "Lcom/baidu/ubc/Flow;", "getCurrentFlowRoomId", "(Ljava/lang/String;)Lcom/baidu/ubc/Flow;", "", "isFromUser", "launchMediaCompLoadFlow", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "msg", "logDebug", "onCoreFinished", "()V", "componentName", "onFinished", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService$delegate", "Lkotlin/Lazy;", "getAbService", "()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "abService", "externalSource", "Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "externalYYStatInfo", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "", "flowExtContent", "Ljava/util/Map;", "flowMaps", "mCurrentRoomId", "", "mStartTime", "J", "Lcom/baidu/ubc/UBCManager;", "ubc", "Lcom/baidu/ubc/UBCManager;", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LiveComponentLoadLogger implements LiveComponentStatusHelper.ILiveComponentLoadFinish {
    public static final String MEDIA_COMMPONENT_TAG = "LIVE_ARCH";
    public static final String UBC_ID_ROOM_COMPONENT_LOAD_FINISH_FLOW = "4770";
    public static final String UBC_LIVE_EVENT_COMP_LOADED = "live_load_event_loaded";
    public static final String UBC_LIVE_EVENT_ENTER = "live_load_event_enter";
    public final Lazy abService$delegate;
    public String externalSource;
    public YYStatInfo externalYYStatInfo;
    public Map<String, JSONObject> flowExtContent;
    public Map<String, Flow> flowMaps;
    public String mCurrentRoomId;
    public long mStartTime;
    public final UBCManager ubc;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveComponentLoadLogger.class), "abService", "getAbService()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;"))};
    public static final Companion Companion = new Companion(null);
    public static final Lazy instance$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LiveComponentLoadLogger>() { // from class: com.baidu.searchbox.live.ubc.LiveComponentLoadLogger$Companion$instance$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LiveComponentLoadLogger invoke() {
            LiveComponentLoadLogger liveComponentLoadLogger = new LiveComponentLoadLogger(null);
            LiveComponentStatusHelper.Companion.getInstance().addComponentFinishCallback(liveComponentLoadLogger);
            return liveComponentLoadLogger;
        }
    });

    private final AbConfigService getAbService() {
        Lazy lazy = this.abService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AbConfigService) lazy.getValue();
    }

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onFinished(String str) {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u001d\u0010\f\u001a\u00020\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger$Companion;", "", "MEDIA_COMMPONENT_TAG", "Ljava/lang/String;", "UBC_ID_ROOM_COMPONENT_LOAD_FINISH_FLOW", "UBC_LIVE_EVENT_COMP_LOADED", "UBC_LIVE_EVENT_ENTER", "Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;", Transition.MATCH_INSTANCE_STR, "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;"))};

        public final LiveComponentLoadLogger getInstance() {
            Lazy lazy = LiveComponentLoadLogger.instance$delegate;
            Companion companion = LiveComponentLoadLogger.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (LiveComponentLoadLogger) lazy.getValue();
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveComponentLoadLogger() {
        Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.getServic…anager.SERVICE_REFERENCE)");
        this.ubc = (UBCManager) service;
        this.abService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AbConfigService>() { // from class: com.baidu.searchbox.live.ubc.LiveComponentLoadLogger$abService$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AbConfigService invoke() {
                return (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
            }
        });
        this.flowMaps = new LinkedHashMap();
        this.flowExtContent = new LinkedHashMap();
    }

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onCoreFinished() {
        Flow currentFlowRoomId;
        String str = this.mCurrentRoomId;
        if (str != null && (currentFlowRoomId = getCurrentFlowRoomId(str)) != null) {
            logDebug("addComponentLoadedEvent all finish" + (System.currentTimeMillis() - this.mStartTime));
            this.ubc.flowAddEvent(currentFlowRoomId, UBC_LIVE_EVENT_COMP_LOADED);
        }
    }

    public /* synthetic */ LiveComponentLoadLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final Flow getCurrentFlowRoomId(String str) {
        return this.flowMaps.get(str);
    }

    public final void cancelCurrentComponentFlow(String str) {
        Flow currentFlowRoomId = getCurrentFlowRoomId(str);
        if (currentFlowRoomId != null) {
            logDebug("cancelCurrentComponentFlow" + str);
            this.ubc.flowCancel(currentFlowRoomId);
            this.flowMaps.remove(str);
            this.flowExtContent.remove(str);
        }
    }

    public final void logDebug(String str) {
        if (MiniShellRuntime.INSTANCE.isDebug()) {
            Log.d("LIVE_ARCH", str);
        }
    }

    private final JSONObject contentItem(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("source", this.externalSource);
            jSONObject2.putOpt("type", "component_load");
            jSONObject2.putOpt("from", "liveshow");
            jSONObject2.putOpt("value", "component_load_finish");
            jSONObject2.putOpt("page", "live");
            jSONObject2.putOpt("network", MixNetWorkUtils.getNetworkClass());
            jSONObject2.putOpt("ext", jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public static /* synthetic */ void launchMediaCompLoadFlow$default(LiveComponentLoadLogger liveComponentLoadLogger, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = MediaLivePluginLogger.PAGE_SELECT_SOURCE;
        }
        liveComponentLoadLogger.launchMediaCompLoadFlow(str, str2, z, str3);
    }

    public final void bindRoomIdToExternalEnterFlow(String str, String str2, String str3) {
        String str4;
        int i;
        String str5;
        IntentData schemeIntentData;
        IntentData.SchemeModel model;
        IntentData schemeIntentData2;
        Object obj;
        logDebug("bindRoomIdToExternalEnterFlow  :" + str);
        if (str != null) {
            this.mCurrentRoomId = str;
            Boolean bool = null;
            try {
                str4 = new JSONObject(str2).optString("livesource");
            } catch (Exception unused) {
                str4 = null;
            }
            if (!TextUtils.isEmpty(str4)) {
                str2 = str4;
            }
            this.externalSource = str2;
            Map<String, Flow> map = this.flowMaps;
            if (map != null) {
                bool = Boolean.valueOf(map.containsKey(str));
            }
            if (bool.booleanValue()) {
                return;
            }
            YYStatInfo yYStatInfo = this.externalYYStatInfo;
            if (yYStatInfo != null && (obj = yYStatInfo.flowObj) != null) {
                Map<String, Flow> map2 = this.flowMaps;
                if (obj != null) {
                    map2.put(str, (Flow) obj);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.ubc.Flow");
                }
            }
            YYStatInfo yYStatInfo2 = this.externalYYStatInfo;
            if (yYStatInfo2 != null && this.flowExtContent.get(str) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MixYYFakeShell.ROOM_ID_YY, str);
                jSONObject.put("setup_type", yYStatInfo2.loadType);
                jSONObject.put("jump_source", str2);
                ILivePageInfoInterface iLivePageInfoInterface = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
                String str6 = (iLivePageInfoInterface == null || (schemeIntentData2 = iLivePageInfoInterface.getSchemeIntentData()) == null || (str6 = schemeIntentData2.getId()) == null) ? "" : "";
                ILivePageInfoInterface iLivePageInfoInterface2 = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
                boolean z = false;
                if (iLivePageInfoInterface2 != null && (schemeIntentData = iLivePageInfoInterface2.getSchemeIntentData()) != null && (model = schemeIntentData.getModel()) != null) {
                    i = model.getInterventions();
                } else {
                    i = 0;
                }
                if (Intrinsics.areEqual(str6, str)) {
                    jSONObject.put("ganyu_scene_qufen", i);
                }
                jSONObject.put("livesdk", MiniPluginInfoHelper.INSTANCE.getVersionName("com.baidu.searchbox.livenps"));
                jSONObject.put("templateId", str3);
                jSONObject.put("prohibit_preload_media_business", "1");
                AbConfigService abService = getAbService();
                if (abService != null && abService.getSwitch(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, false)) {
                    z = true;
                }
                if (z) {
                    str5 = "1";
                } else {
                    str5 = "0";
                }
                jSONObject.put(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, str5);
                jSONObject.put(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, "1");
                logDebug("禁止预加载二级实验 true， 延时加载二级实验： " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + "前请求 enter 接口实验 true");
                this.flowExtContent.put(str, jSONObject);
            }
        }
    }

    public final void endCurrentComponentFlow(String str) {
        String str2;
        Flow currentFlowRoomId = getCurrentFlowRoomId(str);
        if (currentFlowRoomId != null) {
            JSONObject jSONObject = this.flowExtContent.get(str);
            if (jSONObject != null) {
                PluginInvokeService pluginInvokeService = MiniPluginInfoHelper.INSTANCE.getPluginInvokeService();
                if (pluginInvokeService != null && pluginInvokeService.isPluginLoaded("com.baidu.live.media.business")) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                jSONObject.put("media_business_plugin_loaded", str2);
            }
            logDebug("endCurrentComponentFlow" + str + contentItem(this.flowExtContent.get(str)).toString());
            this.ubc.flowSetValueWithDuration(currentFlowRoomId, contentItem(this.flowExtContent.get(str)).toString());
            this.ubc.flowEnd(currentFlowRoomId);
            this.flowMaps.remove(str);
            this.flowExtContent.remove(str);
        }
    }

    public final void externalLiveLaunchMediaCompLoadFlow(Object obj) {
        Object obj2;
        Object obj3;
        long j;
        Object obj4;
        String str;
        logDebug("externalLiveLaunchMediaCompLoadFlow ");
        LiveComponentStatusHelper.Companion.getInstance().clean();
        boolean z = obj instanceof YYStatInfo;
        String str2 = null;
        if (!z) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        YYStatInfo yYStatInfo = (YYStatInfo) obj2;
        if (yYStatInfo != null) {
            obj3 = yYStatInfo.flowObj;
        } else {
            obj3 = null;
        }
        if (!(obj3 instanceof Flow)) {
            obj3 = null;
        }
        Flow flow = (Flow) obj3;
        if (flow != null) {
            j = flow.getStartTime();
        } else {
            j = 0;
        }
        this.mStartTime = j;
        YYStatInfo yYStatInfo2 = new YYStatInfo();
        this.externalYYStatInfo = yYStatInfo2;
        if (yYStatInfo2 != null) {
            if (!z) {
                obj4 = null;
            } else {
                obj4 = obj;
            }
            YYStatInfo yYStatInfo3 = (YYStatInfo) obj4;
            if (yYStatInfo3 != null) {
                str = yYStatInfo3.roomId;
            } else {
                str = null;
            }
            yYStatInfo2.roomId = str;
        }
        YYStatInfo yYStatInfo4 = this.externalYYStatInfo;
        if (yYStatInfo4 != null) {
            if (!z) {
                obj = null;
            }
            YYStatInfo yYStatInfo5 = (YYStatInfo) obj;
            if (yYStatInfo5 != null) {
                str2 = yYStatInfo5.loadType;
            }
            yYStatInfo4.loadType = str2;
        }
        Flow beginFlow = this.ubc.beginFlow(UBC_ID_ROOM_COMPONENT_LOAD_FINISH_FLOW);
        this.ubc.flowAddEventWithDate(beginFlow, UBC_LIVE_EVENT_ENTER, "", this.mStartTime);
        YYStatInfo yYStatInfo6 = this.externalYYStatInfo;
        if (yYStatInfo6 != null) {
            yYStatInfo6.flowObj = beginFlow;
        }
        logDebug("externalLiveLaunchMediaCompLoadFlow startTime flow" + this.mStartTime);
    }

    public final void launchMediaCompLoadFlow(String str, String str2, boolean z, String str3) {
        int i;
        String str4;
        IntentData schemeIntentData;
        IntentData.SchemeModel model;
        IntentData schemeIntentData2;
        if (z && str != null) {
            LiveComponentStatusHelper.Companion.getInstance().clean();
            this.mCurrentRoomId = str;
            if (this.flowMaps.get(str) == null) {
                Flow flow = this.ubc.beginFlow(UBC_ID_ROOM_COMPONENT_LOAD_FINISH_FLOW);
                this.ubc.flowAddEvent(flow, UBC_LIVE_EVENT_ENTER);
                Map<String, Flow> map = this.flowMaps;
                Intrinsics.checkExpressionValueIsNotNull(flow, "flow");
                map.put(str, flow);
                if (this.flowExtContent.get(str) == null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MixYYFakeShell.ROOM_ID_YY, str);
                    jSONObject.put("setup_type", "launch");
                    jSONObject.put("jump_source", str3);
                    ILivePageInfoInterface iLivePageInfoInterface = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
                    String str5 = (iLivePageInfoInterface == null || (schemeIntentData2 = iLivePageInfoInterface.getSchemeIntentData()) == null || (str5 = schemeIntentData2.getId()) == null) ? "" : "";
                    ILivePageInfoInterface iLivePageInfoInterface2 = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
                    boolean z2 = false;
                    if (iLivePageInfoInterface2 != null && (schemeIntentData = iLivePageInfoInterface2.getSchemeIntentData()) != null && (model = schemeIntentData.getModel()) != null) {
                        i = model.getInterventions();
                    } else {
                        i = 0;
                    }
                    if (Intrinsics.areEqual(str5, str)) {
                        jSONObject.put("ganyu_scene_qufen", i);
                    }
                    jSONObject.put("livesdk", MiniPluginInfoHelper.INSTANCE.getVersionName("com.baidu.searchbox.livenps"));
                    jSONObject.put("templateId", str2);
                    jSONObject.put("prohibit_preload_media_business", "1");
                    AbConfigService abService = getAbService();
                    if (abService != null && abService.getSwitch(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, false)) {
                        z2 = true;
                    }
                    if (z2) {
                        str4 = "1";
                    } else {
                        str4 = "0";
                    }
                    jSONObject.put(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, str4);
                    jSONObject.put(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, "1");
                    logDebug("禁止预加载二级实验 true， 延时加载二级实验： " + z2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "前请求 enter 接口实验 true");
                    this.flowExtContent.put(str, jSONObject);
                }
                this.mStartTime = System.currentTimeMillis();
                logDebug("launchMediaCompLoadFlow  second jump create flow " + str);
            }
        }
    }
}
