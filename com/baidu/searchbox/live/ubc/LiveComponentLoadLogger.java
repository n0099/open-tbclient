package com.baidu.searchbox.live.ubc;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MixNetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.live.ubc.LiveComponentStatusHelper;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b9\u0010\u001fJ)\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001a\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u000bR%\u0010(\u001a\n #*\u0004\u0018\u00010\"0\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;", "com/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "templateId", "", "bindRoomIdToExternalEnterFlow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "key", "cancelCurrentComponentFlow", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "ext", "contentItem", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "endCurrentComponentFlow", "", "statInfo", "externalLiveLaunchMediaCompLoadFlow", "(Ljava/lang/Object;)V", "Lcom/baidu/ubc/Flow;", "getCurrentFlowRoomId", "(Ljava/lang/String;)Lcom/baidu/ubc/Flow;", "", "isFromUser", "launchMediaCompLoadFlow", "(Ljava/lang/String;Ljava/lang/String;Z)V", "msg", "logDebug", "onCoreFinished", "()V", "componentName", "onFinished", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService$delegate", "Lkotlin/Lazy;", "getAbService", "()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "abService", "externalSource", "Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "externalYYStatInfo", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "", "flowExtContent", "Ljava/util/Map;", "flowMaps", "mCurrentRoomId", "", "mStartTime", "J", "Lcom/baidu/ubc/UBCManager;", UBCCloudControlProcessor.UBC_KEY, "Lcom/baidu/ubc/UBCManager;", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveComponentLoadLogger implements LiveComponentStatusHelper.ILiveComponentLoadFinish {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String MEDIA_COMMPONENT_TAG = "LIVE_ARCH";
    public static final String UBC_ID_ROOM_COMPONENT_LOAD_FINISH_FLOW = "4770";
    public static final String UBC_LIVE_EVENT_COMP_LOADED = "live_load_event_loaded";
    public static final String UBC_LIVE_EVENT_ENTER = "live_load_event_enter";
    public static final Lazy instance$delegate;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy abService$delegate;
    public String externalSource;
    public YYStatInfo externalYYStatInfo;
    public Map<String, JSONObject> flowExtContent;
    public Map<String, Flow> flowMaps;
    public String mCurrentRoomId;
    public long mStartTime;
    public final UBCManager ubc;

    private final AbConfigService getAbService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Lazy lazy = this.abService$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (AbConfigService) lazy.getValue();
        }
        return (AbConfigService) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onFinished(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u001d\u0010\f\u001a\u00020\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger$Companion;", "", "MEDIA_COMMPONENT_TAG", "Ljava/lang/String;", "UBC_ID_ROOM_COMPONENT_LOAD_FINISH_FLOW", "UBC_LIVE_EVENT_COMP_LOADED", "UBC_LIVE_EVENT_ENTER", "Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;", Transition.MATCH_INSTANCE_STR, "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ KProperty[] $$delegatedProperties;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-123999794, "Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-123999794, "Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger$Companion;");
                    return;
                }
            }
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;"))};
        }

        public final LiveComponentLoadLogger getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Lazy lazy = LiveComponentLoadLogger.instance$delegate;
                Companion companion = LiveComponentLoadLogger.Companion;
                KProperty kProperty = $$delegatedProperties[0];
                return (LiveComponentLoadLogger) lazy.getValue();
            }
            return (LiveComponentLoadLogger) invokeV.objValue;
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(294613462, "Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(294613462, "Lcom/baidu/searchbox/live/ubc/LiveComponentLoadLogger;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveComponentLoadLogger.class), "abService", "getAbService()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;"))};
        Companion = new Companion(null);
        instance$delegate = LazyKt__LazyJVMKt.lazy(LiveComponentLoadLogger$Companion$instance$2.INSTANCE);
    }

    public LiveComponentLoadLogger() {
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
        Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.getServic…anager.SERVICE_REFERENCE)");
        this.ubc = (UBCManager) service;
        this.abService$delegate = LazyKt__LazyJVMKt.lazy(LiveComponentLoadLogger$abService$2.INSTANCE);
        this.flowMaps = new LinkedHashMap();
        this.flowExtContent = new LinkedHashMap();
    }

    public /* synthetic */ LiveComponentLoadLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final Flow getCurrentFlowRoomId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            return this.flowMaps.get(str);
        }
        return (Flow) invokeL.objValue;
    }

    public final void logDebug(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && MiniShellRuntime.INSTANCE.isDebug()) {
            Log.d("LIVE_ARCH", str);
        }
    }

    private final JSONObject contentItem(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
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
        return (JSONObject) invokeL.objValue;
    }

    public final void bindRoomIdToExternalEnterFlow(String str, String str2, String str3) {
        String str4;
        boolean z;
        Object obj;
        boolean z2;
        Object obj2;
        Object obj3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
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
                if (yYStatInfo != null && (obj3 = yYStatInfo.flowObj) != null) {
                    Map<String, Flow> map2 = this.flowMaps;
                    if (obj3 != null) {
                        map2.put(str, (Flow) obj3);
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
                    jSONObject.put("livesdk", MiniPluginInfoHelper.INSTANCE.getVersionName("com.baidu.searchbox.livenps"));
                    jSONObject.put("templateId", str3);
                    AbConfigService abService = getAbService();
                    boolean z3 = true;
                    if (abService != null && abService.getSwitch(MiniPluginManager.PROHIBIT_PRE_LOAD_MEDIA_SWITCH, false)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    String str5 = "1";
                    if (z) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    jSONObject.put("prohibit_preload_media_business", obj);
                    AbConfigService abService2 = getAbService();
                    if (abService2 != null && abService2.getSwitch(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, false)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        obj2 = "1";
                    } else {
                        obj2 = "0";
                    }
                    jSONObject.put(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, obj2);
                    AbConfigService abService3 = getAbService();
                    z3 = (abService3 == null || !abService3.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false)) ? false : false;
                    if (!z3) {
                        str5 = "0";
                    }
                    jSONObject.put(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, str5);
                    logDebug("禁止预加载二级实验 " + z + "， 延时加载二级实验： " + z2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "前请求 enter 接口实验 " + z3);
                    this.flowExtContent.put(str, jSONObject);
                }
            }
        }
    }

    public final void launchMediaCompLoadFlow(String str, String str2, boolean z) {
        boolean z2;
        Object obj;
        boolean z3;
        Object obj2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048580, this, str, str2, z) == null) && z && str != null) {
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
                    jSONObject.put("jump_source", MediaLivePluginLogger.PAGE_SELECT_SOURCE);
                    jSONObject.put("livesdk", MiniPluginInfoHelper.INSTANCE.getVersionName("com.baidu.searchbox.livenps"));
                    jSONObject.put("templateId", str2);
                    AbConfigService abService = getAbService();
                    boolean z4 = true;
                    if (abService != null && abService.getSwitch(MiniPluginManager.PROHIBIT_PRE_LOAD_MEDIA_SWITCH, false)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    String str3 = "1";
                    if (z2) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    jSONObject.put("prohibit_preload_media_business", obj);
                    AbConfigService abService2 = getAbService();
                    if (abService2 != null && abService2.getSwitch(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, false)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        obj2 = "1";
                    } else {
                        obj2 = "0";
                    }
                    jSONObject.put(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, obj2);
                    AbConfigService abService3 = getAbService();
                    z4 = (abService3 == null || !abService3.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false)) ? false : false;
                    if (!z4) {
                        str3 = "0";
                    }
                    jSONObject.put(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, str3);
                    logDebug("禁止预加载二级实验 " + z2 + "， 延时加载二级实验： " + z3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "前请求 enter 接口实验 " + z4);
                    this.flowExtContent.put(str, jSONObject);
                }
                this.mStartTime = System.currentTimeMillis();
                logDebug("launchMediaCompLoadFlow  second jump create flow " + str);
            }
        }
    }

    public final void cancelCurrentComponentFlow(String str) {
        Flow currentFlowRoomId;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (currentFlowRoomId = getCurrentFlowRoomId(str)) != null) {
            logDebug("cancelCurrentComponentFlow" + str);
            this.ubc.flowCancel(currentFlowRoomId);
            this.flowMaps.remove(str);
            this.flowExtContent.remove(str);
        }
    }

    public final void endCurrentComponentFlow(String str) {
        Flow currentFlowRoomId;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (currentFlowRoomId = getCurrentFlowRoomId(str)) != null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
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
    }

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onCoreFinished() {
        String str;
        Flow currentFlowRoomId;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (str = this.mCurrentRoomId) != null && (currentFlowRoomId = getCurrentFlowRoomId(str)) != null) {
            logDebug("addComponentLoadedEvent all finish" + (System.currentTimeMillis() - this.mStartTime));
            this.ubc.flowAddEvent(currentFlowRoomId, UBC_LIVE_EVENT_COMP_LOADED);
        }
    }
}
