package com.baidu.searchbox.live.ubc;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.mix.proxy.LiveMixShellManager;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.ubc.LiveComponentStatusHelper;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001B\n\b\u0002¢\u0006\u0005\b\u0089\u0001\u0010\u0015JM\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u0015J\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u0015J\r\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u0015J\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001fJ\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u0015J\r\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010\u0015J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\u0015J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\u0015J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u0015J\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\u0015J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\u0015J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u0015J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010\u0015J\r\u0010*\u001a\u00020\u000b¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u0015J\r\u0010,\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\u0015J\r\u0010-\u001a\u00020\u000b¢\u0006\u0004\b-\u0010\u0015J\r\u0010.\u001a\u00020\u000b¢\u0006\u0004\b.\u0010\u0015J\r\u0010/\u001a\u00020\u000b¢\u0006\u0004\b/\u0010\u0015J\r\u00100\u001a\u00020\u000b¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u0010\u0015J\r\u00102\u001a\u00020\u000b¢\u0006\u0004\b2\u0010\u0015J\u0015\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u001fJ\r\u00105\u001a\u00020\u000b¢\u0006\u0004\b5\u0010\u0015J\r\u00106\u001a\u00020\u000b¢\u0006\u0004\b6\u0010\u0015J\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u0010\u0015J\r\u00108\u001a\u00020\u000b¢\u0006\u0004\b8\u0010\u0015J\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010\u0015J\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\u0015J\r\u0010<\u001a\u00020\u000b¢\u0006\u0004\b<\u0010\u0015J\r\u0010=\u001a\u00020\u000b¢\u0006\u0004\b=\u0010\u0015J\r\u0010>\u001a\u00020\u000b¢\u0006\u0004\b>\u0010\u0015J\r\u0010?\u001a\u00020\u000b¢\u0006\u0004\b?\u0010\u0015J\r\u0010@\u001a\u00020\u000b¢\u0006\u0004\b@\u0010\u0015J\r\u0010A\u001a\u00020\u000b¢\u0006\u0004\bA\u0010\u0015J\r\u0010B\u001a\u00020\u000b¢\u0006\u0004\bB\u0010\u0015J\r\u0010C\u001a\u00020\u000b¢\u0006\u0004\bC\u0010\u0015J\r\u0010D\u001a\u00020\u000b¢\u0006\u0004\bD\u0010\u0015J\r\u0010E\u001a\u00020\u000b¢\u0006\u0004\bE\u0010\u0015J\r\u0010F\u001a\u00020\u000b¢\u0006\u0004\bF\u0010\u0015J\r\u0010G\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\u0015J\r\u0010H\u001a\u00020\u000b¢\u0006\u0004\bH\u0010\u0015J\r\u0010I\u001a\u00020\u000b¢\u0006\u0004\bI\u0010\u0015J\r\u0010J\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010\u0015J\u000f\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0004\bK\u0010\u0015J\u0017\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u0004H\u0016¢\u0006\u0004\bM\u0010\u001fJ\u000f\u0010N\u001a\u00020\u000bH\u0002¢\u0006\u0004\bN\u0010\u0015J\u0017\u0010P\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010R\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bR\u0010\u0011J\u0015\u0010U\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VJ1\u0010W\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\bW\u0010XJ+\u0010Z\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010Y\u001a\u00020\u0002¢\u0006\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010]R%\u0010d\u001a\n _*\u0004\u0018\u00010^0^8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010iR\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0016\u0010l\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010iR\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0016\u0010n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010iR\u0016\u0010o\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010iR\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010iR\u0016\u0010q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010iR\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010iR\u0016\u0010s\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010iR\u0016\u0010t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010iR\u0016\u0010u\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010iR\u0016\u0010v\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010iR\u0016\u0010w\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010iR\u0018\u0010y\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010|\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u007f\u001a\u00020~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010iR\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\"\u0010\u0088\u0001\u001a\u00030\u0084\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u0010a\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u008b\u0001"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;", "com/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish", "", "isFromUser", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "source", "hasStream", FlowInfoHelper.KEY_IS_COLDLAUNCH, "roomType", "roomTemplate", "", "createSelectLaunchInfo", "(ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "slotName", "depSlot", "endSlot", "(Ljava/lang/String;Ljava/lang/String;)V", "getSwitchPreloadSplite", "()Ljava/lang/Boolean;", "logBindMediaComponentDataEnd", "()V", "logBindMediaComponentDataStart", "logBindMixShellDataEnd", "logBindMixShellDataStart", "logCreateMediaComponentEnd", "logCreateMediaComponentStart", "logCreateMixShellEnd", "logCreateMixShellStart", "msg", "logDebug", "(Ljava/lang/String;)V", "logDebugE", "logFirstJumpPreEnterParseEnd", "logFirstJumpPreEnterReqStart", "logFirstJumpPreEnterStart", "logFirstJumpPreEnterStartParse", "logGetLiveTypeEndAndItem", "logGetLiveTypeNetEndAndStartParse", "logListBeginGetLiveTypeStart", "logListBeginSlideReqStart", "logListGetLiveTypeStartToSendReqNet", "logListLoadRoomAndNextListAddItem", "logListOnCreateEndAndNextToLoadRoom", "logListOnCreateStart", "logListParseEndAndNextToAddItem", "logListSlideEndAndAddItem", "logListSlideReqNetEndAndStartParse", "logListSlideStartToSendReqNet", "logLiveRoomDrawUIFinish", "logLiveRoomFirstFrame", "leaveFrom", "logLiveRoomLeave", "logLiveRoomPageEndAndPageAttachStart", "logLiveRoomPageEndBindStartLayout", "logLiveRoomPageEndLayoutDrawBottomComponent", "logLiveRoomPageEndLayoutDrawComponent", "logLiveRoomPageEndLayoutDrawIMComponent", "logLiveRoomPageEndLayoutDrawTopComponent", "logLiveRoomPageOnSelect", "logLiveRoomPageResume", "logLiveRoomStartPage", "logMixShellOnSelect", "logPageAfterSelectedEndFetchLiveBeanDispatchStart", "logPageAfterSelectedStartFetchLiveBean", "logPageAttachEndNextToPageOnCreate", "logPageEnterLiveParseEnd", "logPageEnterLiveParseStart", "logPageEnterLiveRoomReqNetEnd", "logPageEnterLiveRoomReqNetEndAndParseStart", "logPageEnterLiveRoomReqNetStart", "logPageOnCreateEnd", "logPageOnCreateStart", "logPageSelectedEnterFetchEnd", "logPageSelectedEnterFetchStart", "onCoreFinished", "componentName", "onFinished", "printFlowEachSlotInfo", "preLoadSwitch", "setSwitchPreloadSplite", "(Ljava/lang/Boolean;)V", "startSlot", "", "flowObj", "updateLaunchFlowObj", "(Ljava/lang/Object;)V", "updateStartPageInfo", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "firstJump", "updateStartPageInfoIntentRoomInfo", "(Ljava/lang/String;Ljava/lang/String;Z)V", "UBC_ID_PLUGIN_PAGE_FLOW", "Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService$delegate", "Lkotlin/Lazy;", "getAbService", "()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "abService", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasLogAddItem", "Z", "hasLoggedBeginGetLiveTypeReqStart", "hasLoggedBeginPreEnterReqStart", "hasLoggedBeginSlideReqStart", "hasLoggedBindMediaComponent", "hasLoggedBindMixShell", "hasLoggedCreateMediaComponent", "hasLoggedCreateMixShell", "hasLoggedFirstFrame", "hasLoggedInit", "hasLoggedResume", "hasLoggedSelect", "hasLoggedSelectMixShell", "hasSendEnterRequest", "isDebug", "Lcom/baidu/ubc/Flow;", "launchFlow", "Lcom/baidu/ubc/Flow;", "Lorg/json/JSONObject;", "logStartPageValueJson", "Lorg/json/JSONObject;", "", "pageLoadStartTime", "J", "preEnterSwitch", "switchPreloadSplite", "Ljava/lang/Boolean;", "Lcom/baidu/ubc/UBCManager;", "ubcManager$delegate", "getUbcManager", "()Lcom/baidu/ubc/UBCManager;", "ubcManager", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MediaLivePluginLogger implements LiveComponentStatusHelper.ILiveComponentLoadFinish {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String MEDIA_LIVE_PLUGIN_TAG = "LIVE_ARCH";
    public static final String PAGE_SELECT_SOURCE = "slide";
    public static final String PAGE_SLOT_BIND_MEDIA_COMPONENT = "bind_media_component";
    public static final String PAGE_SLOT_BIND_MIX_SHELL = "bind_mix_shell";
    public static final String PAGE_SLOT_BIND_TO_NOTIFY_SELECT = "bind_to_notify_select";
    public static final String PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL = "bind_to_notify_select_mix_shell";
    public static final String PAGE_SLOT_CREATE_MEDIA_COMPONENT = "create_media_component";
    public static final String PAGE_SLOT_CREATE_MIX_SHELL = "create_mix_shell";
    public static final String PAGE_SLOT_DISPATCH_ENTER_ACTION = "dispatch_enter_action";
    public static final String PAGE_SLOT_GET_LIVE_TYPE_START = "get_live_type_start";
    public static final String PAGE_SLOT_GET_LIVE_TYPE_TIME = "get_live_type_time";
    public static final String PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE = "get_live_type_time_parse";
    public static final String PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME = "get_slide_add_time";
    public static final String PAGE_SLOT_GET_SLIDE_NET_TIME = "get_slide_net_time";
    public static final String PAGE_SLOT_GET_SLIDE_PARSE_TIME = "get_slide_net_time_parse";
    public static final String PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM = "list_create_to_load_room";
    public static final String PAGE_SLOT_LOAD_ROOM = "load_room";
    public static final String PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START = "get_slide_start";
    public static final String PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM = "load_room_to_create_media_component";
    public static final String PAGE_SLOT_PAGE_AFTER_ENTER_LIVE_PAGE_DRAW = "page_after_enter_live_page_draw";
    public static final String PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START = "page_attach_to_create";
    public static final String PAGE_SLOT_PAGE_ATTACH_TIME = "page_attach";
    public static final String PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME = "page_attach_to_first_frame";
    public static final String PAGE_SLOT_PAGE_ATTACH_TO_RESUME = "page_attach_to_resume";
    public static final String PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START = "page_create_to_list_create";
    public static final String PAGE_SLOT_PAGE_CREATE_TIME = "page_on_create_time";
    public static final String PAGE_SLOT_PAGE_ENTER_LIVE_NOTIFY_BIND = "page_enter_live_notify_bind";
    public static final String PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE = "page_enter_live_req_parse";
    public static final String PAGE_SLOT_PAGE_ENTER_LIVE_REQ_TIME = "page_enter_live_req";
    public static final String PAGE_SLOT_PAGE_INIT = "page_init";
    public static final String PAGE_SLOT_PAGE_LAYOUT_MANAGER_BOTTOM = "page_enter_res_to_bottom";
    public static final String PAGE_SLOT_PAGE_LAYOUT_MANAGER_IM = "page_enter_res_to_im";
    public static final String PAGE_SLOT_PAGE_LAYOUT_MANAGER_LAYOUT = "page_enter_res_layout_start";
    public static final String PAGE_SLOT_PAGE_LAYOUT_MANAGER_TOP = "page_enter_res_to_top";
    public static final String PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE = "page_fj_pre_enter_live_req_parse";
    public static final String PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME = "page_fj_pre_enter_live_req";
    public static final String PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START = "page_fj_pre_enter_live_start";
    public static final String PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_NO = "page_selected_enter_fetch_no";
    public static final String PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_PRE = "page_selected_enter_fetch_pre";
    public static final String PAGE_SLOT_PAGE_SELECT_FETCH_START = "page_slot_page_select_fetch_data_start";
    public static final Lazy instance$delegate;
    public static long pageEnterNetDuration;
    public static long pageEnterStartTime;
    public static long pageSelectStartTime;
    public transient /* synthetic */ FieldHolder $fh;
    public final String UBC_ID_PLUGIN_PAGE_FLOW;
    public final Lazy abService$delegate;
    public Handler handler;
    public boolean hasLogAddItem;
    public boolean hasLoggedBeginGetLiveTypeReqStart;
    public boolean hasLoggedBeginPreEnterReqStart;
    public boolean hasLoggedBeginSlideReqStart;
    public boolean hasLoggedBindMediaComponent;
    public boolean hasLoggedBindMixShell;
    public boolean hasLoggedCreateMediaComponent;
    public boolean hasLoggedCreateMixShell;
    public boolean hasLoggedFirstFrame;
    public boolean hasLoggedInit;
    public boolean hasLoggedResume;
    public boolean hasLoggedSelect;
    public boolean hasLoggedSelectMixShell;
    public boolean hasSendEnterRequest;
    public final boolean isDebug;
    public Flow launchFlow;
    public JSONObject logStartPageValueJson;
    public long pageLoadStartTime;
    public final boolean preEnterSwitch;
    public Boolean switchPreloadSplite;
    public final Lazy ubcManager$delegate;

    private final AbConfigService getAbService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Lazy lazy = this.abService$delegate;
            KProperty kProperty = $$delegatedProperties[1];
            return (AbConfigService) lazy.getValue();
        }
        return (AbConfigService) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UBCManager getUbcManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Lazy lazy = this.ubcManager$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (UBCManager) lazy.getValue();
        }
        return (UBCManager) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b6\u00107R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0003R\u0016\u0010\u001b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0003R\u0016\u0010\u001e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0003R\u0016\u0010 \u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0003R\u0016\u0010!\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0003R\u0016\u0010\"\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0003R\u0016\u0010#\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0003R\u0016\u0010$\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0003R\u0016\u0010%\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0003R\u0016\u0010&\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0003R\u0016\u0010'\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0003R\u0016\u0010(\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0003R\u0016\u0010)\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0003R\u0016\u0010*\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0003R\u001d\u00100\u001a\u00020+8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103¨\u00068"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger$Companion;", "", "MEDIA_LIVE_PLUGIN_TAG", "Ljava/lang/String;", "PAGE_SELECT_SOURCE", "PAGE_SLOT_BIND_MEDIA_COMPONENT", "PAGE_SLOT_BIND_MIX_SHELL", "PAGE_SLOT_BIND_TO_NOTIFY_SELECT", "PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL", "PAGE_SLOT_CREATE_MEDIA_COMPONENT", "PAGE_SLOT_CREATE_MIX_SHELL", "PAGE_SLOT_DISPATCH_ENTER_ACTION", "PAGE_SLOT_GET_LIVE_TYPE_START", "PAGE_SLOT_GET_LIVE_TYPE_TIME", "PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE", "PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME", "PAGE_SLOT_GET_SLIDE_NET_TIME", "PAGE_SLOT_GET_SLIDE_PARSE_TIME", "PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM", "PAGE_SLOT_LOAD_ROOM", "PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START", "PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM", "PAGE_SLOT_PAGE_AFTER_ENTER_LIVE_PAGE_DRAW", "PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START", "PAGE_SLOT_PAGE_ATTACH_TIME", "PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME", "PAGE_SLOT_PAGE_ATTACH_TO_RESUME", "PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START", "PAGE_SLOT_PAGE_CREATE_TIME", "PAGE_SLOT_PAGE_ENTER_LIVE_NOTIFY_BIND", "PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE", "PAGE_SLOT_PAGE_ENTER_LIVE_REQ_TIME", "PAGE_SLOT_PAGE_INIT", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_BOTTOM", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_IM", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_LAYOUT", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_TOP", "PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE", "PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME", "PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START", "PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_NO", "PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_PRE", "PAGE_SLOT_PAGE_SELECT_FETCH_START", "Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;", Transition.MATCH_INSTANCE_STR, "", "pageEnterNetDuration", "J", "pageEnterStartTime", "pageSelectStartTime", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class Companion {
        public static final /* synthetic */ KProperty[] $$delegatedProperties;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(854380418, "Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(854380418, "Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger$Companion;");
                    return;
                }
            }
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;"))};
        }

        public final MediaLivePluginLogger getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Lazy lazy = MediaLivePluginLogger.instance$delegate;
                Companion companion = MediaLivePluginLogger.Companion;
                KProperty kProperty = $$delegatedProperties[0];
                return (MediaLivePluginLogger) lazy.getValue();
            }
            return (MediaLivePluginLogger) invokeV.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1786894198, "Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1786894198, "Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MediaLivePluginLogger.class), "ubcManager", "getUbcManager()Lcom/baidu/ubc/UBCManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MediaLivePluginLogger.class), "abService", "getAbService()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;"))};
        Companion = new Companion(null);
        instance$delegate = LazyKt__LazyJVMKt.lazy(MediaLivePluginLogger$Companion$instance$2.INSTANCE);
    }

    private final void logLiveRoomPageEndLayoutDrawBottomComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            logDebug("logLiveRoomPageEndLayoutDrawBottomComponent");
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("底部bar组件渲染完成了：" + (currentTimeMillis - pageSelectStartTime));
            }
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_BOTTOM);
            }
        }
    }

    private final void logLiveRoomPageEndLayoutDrawIMComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            logDebug("logLiveRoomPageEndLayoutDrawIMComponent");
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("IM组件渲染完成了：" + (currentTimeMillis - pageSelectStartTime));
            }
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_IM);
            }
        }
    }

    private final void logLiveRoomPageEndLayoutDrawTopComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            logDebug("logLiveRoomPageEndLayoutDrawTopComponent");
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("顶部bar组件渲染完成了：" + (currentTimeMillis - pageSelectStartTime));
            }
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_TOP);
            }
        }
    }

    public final void logLiveRoomPageOnSelect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            logDebug("logLiveRoomPageOnSelect");
            if (this.isDebug) {
                pageSelectStartTime = System.currentTimeMillis();
            }
            if (!this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_DISPATCH_ENTER_ACTION, null);
                this.hasLoggedSelect = true;
            }
        }
    }

    public final void logPageAfterSelectedEndFetchLiveBeanDispatchStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            logDebug("logPageAfterSelectedEndFetchLiveBeanDispatchStart");
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("选中到获取进场数据之间的耗时：" + (currentTimeMillis - pageSelectStartTime));
            }
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_SELECT_FETCH_START);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_NOTIFY_BIND, null);
            }
        }
    }

    public final void logPageAfterSelectedStartFetchLiveBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            logDebug("logPageAfterSelectedStartFetchLiveBean");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                if (this.isDebug) {
                    long currentTimeMillis = System.currentTimeMillis();
                    logDebug("选中到开始取获取进场数据：" + (currentTimeMillis - pageSelectStartTime));
                }
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_DISPATCH_ENTER_ACTION);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_SELECT_FETCH_START, null);
            }
        }
    }

    public final void logPageAttachEndNextToPageOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            logDebug("logPageAttachEndNextToPageOnCreate");
            if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, "page_attach");
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START, null);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_RESUME, null);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME, null);
            }
        }
    }

    public final void logPageEnterLiveRoomReqNetEndAndParseStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            logDebug("logPageEnterLiveRoomReqNetEndAndParseStart");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null && this.hasSendEnterRequest) {
                if (this.isDebug) {
                    pageEnterNetDuration = System.currentTimeMillis() - pageEnterStartTime;
                }
                this.hasSendEnterRequest = false;
                getUbcManager().flowEndSlot(this.launchFlow, "page_enter_live_req");
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE, null);
            }
        }
    }

    public MediaLivePluginLogger() {
        boolean z;
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
        this.ubcManager$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) MediaLivePluginLogger$ubcManager$2.INSTANCE);
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            z = appInfoService.isDebug();
        } else {
            z = false;
        }
        this.isDebug = z;
        this.abService$delegate = LazyKt__LazyJVMKt.lazy(MediaLivePluginLogger$abService$2.INSTANCE);
        AbConfigService abService = getAbService();
        this.preEnterSwitch = abService != null ? abService.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false) : false;
        this.UBC_ID_PLUGIN_PAGE_FLOW = LiveMixShellManager.UBC_ID_PLUGIN_PAGE_FLOW;
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void printFlowEachSlotInfo() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            try {
                Flow flow = this.launchFlow;
                HashMap hashMap2 = null;
                if (flow != null) {
                    hashMap = flow.getSlotMaps();
                } else {
                    hashMap = null;
                }
                if (hashMap != null) {
                    Flow flow2 = this.launchFlow;
                    if (flow2 != null) {
                        hashMap2 = flow2.getSlotMaps();
                    }
                    if (hashMap2 == null) {
                        Intrinsics.throwNpe();
                    }
                    for (Map.Entry entry : hashMap2.entrySet()) {
                        Slot value = (Slot) entry.getValue();
                        StringBuilder sb = new StringBuilder();
                        sb.append("阶段耗时 ");
                        sb.append((String) entry.getKey());
                        sb.append(" = ");
                        Intrinsics.checkExpressionValueIsNotNull(value, "value");
                        sb.append(value.getJSONObject());
                        logDebugE(sb.toString());
                    }
                }
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
            }
        }
    }

    public final void logLiveRoomPageEndBindStartLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            logDebug("logLiveRoomPageEndBindStartLayout");
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("开始向组件分发进场成功消息：" + (currentTimeMillis - pageSelectStartTime));
            }
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_NOTIFY_BIND);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_LAYOUT, null);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_IM, null);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_TOP, null);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_BOTTOM, null);
            }
        }
    }

    public final void logLiveRoomPageEndLayoutDrawComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            logDebug("logLiveRoomPageEndLayoutDrawComponent");
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("完成向组件分发进场成功消息：" + (currentTimeMillis - pageSelectStartTime));
                logDebug("从选中到完成进场处理，并减去网络的耗时：" + ((currentTimeMillis - pageSelectStartTime) - pageEnterNetDuration));
            }
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_LAYOUT);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_AFTER_ENTER_LIVE_PAGE_DRAW, null);
            }
        }
    }

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onCoreFinished() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.isDebug) {
                long currentTimeMillis = System.currentTimeMillis();
                logDebug("选中到渲染完成耗时：" + (currentTimeMillis - pageSelectStartTime));
                StringBuilder sb = new StringBuilder();
                sb.append("完载startTime：");
                Flow flow = this.launchFlow;
                if (flow != null) {
                    j = flow.getStartTime();
                } else {
                    j = 0;
                }
                sb.append(Long.valueOf(j));
                logDebug(sb.toString());
                logDebug("完载时间耗时：" + (currentTimeMillis - this.pageLoadStartTime));
            }
            logLiveRoomDrawUIFinish();
        }
    }

    public /* synthetic */ MediaLivePluginLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void logDebug(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.isDebug) {
            Log.d("LIVE_ARCH", str);
        }
    }

    public final void logDebugE(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && this.isDebug) {
            Log.e("LIVE_ARCH", str);
        }
    }

    public final void setSwitchPreloadSplite(Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, bool) == null) && bool != null) {
            this.switchPreloadSplite = Boolean.valueOf(bool.booleanValue());
        }
    }

    public final Boolean getSwitchPreloadSplite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.switchPreloadSplite;
        }
        return (Boolean) invokeV.objValue;
    }

    public final void logBindMediaComponentDataStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            logDebug("logBindMediaComponentDataStart");
            if (!this.hasLoggedBindMediaComponent && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, "bind_media_component", null);
                this.hasLoggedBindMediaComponent = true;
            }
        }
    }

    public final void logBindMixShellDataStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            logDebug("logBindMixShellDataStart");
            if (!this.hasLoggedBindMixShell && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_BIND_MIX_SHELL, null);
                this.hasLoggedBindMixShell = true;
            }
        }
    }

    public final void logCreateMediaComponentEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            logDebug("logCreateMediaComponentEnd");
            if (this.hasLoggedCreateMediaComponent && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, "create_media_component");
            }
        }
    }

    public final void logCreateMediaComponentStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            logDebug("logCreateMediaComponentStart");
            if (!this.hasLoggedCreateMediaComponent && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, "create_media_component", null);
                this.hasLoggedCreateMediaComponent = true;
            }
        }
    }

    public final void logCreateMixShellEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            logDebug("logCreateMixShellEnd");
            if (this.hasLoggedCreateMixShell && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_CREATE_MIX_SHELL);
            }
        }
    }

    public final void logFirstJumpPreEnterParseEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.handler.post(new Runnable(this) { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$logFirstJumpPreEnterParseEnd$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLivePluginLogger this$0;

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
                    boolean z;
                    UBCManager ubcManager;
                    Flow flow;
                    UBCManager ubcManager2;
                    Flow flow2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.logDebug("logFirstJumpPreEnterParseEnd");
                        z = this.this$0.hasLoggedBeginPreEnterReqStart;
                        if (!z) {
                            return;
                        }
                        ubcManager = this.this$0.getUbcManager();
                        if (ubcManager == null) {
                            return;
                        }
                        flow = this.this$0.launchFlow;
                        if (flow == null) {
                            return;
                        }
                        ubcManager2 = this.this$0.getUbcManager();
                        flow2 = this.this$0.launchFlow;
                        ubcManager2.flowEndSlot(flow2, MediaLivePluginLogger.PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE);
                    }
                }
            });
        }
    }

    public final void logFirstJumpPreEnterStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            logDebug("logFirstJumpPreEnterStart");
            if (!this.hasLoggedBeginPreEnterReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START, null);
                this.hasLoggedBeginPreEnterReqStart = true;
            }
        }
    }

    public final void logFirstJumpPreEnterStartParse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.handler.post(new Runnable(this) { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$logFirstJumpPreEnterStartParse$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLivePluginLogger this$0;

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
                    boolean z;
                    UBCManager ubcManager;
                    Flow flow;
                    UBCManager ubcManager2;
                    Flow flow2;
                    UBCManager ubcManager3;
                    Flow flow3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.logDebug("logFirstJumpPreEnterStartParse");
                        z = this.this$0.hasLoggedBeginPreEnterReqStart;
                        if (!z) {
                            return;
                        }
                        ubcManager = this.this$0.getUbcManager();
                        if (ubcManager == null) {
                            return;
                        }
                        flow = this.this$0.launchFlow;
                        if (flow == null) {
                            return;
                        }
                        ubcManager2 = this.this$0.getUbcManager();
                        flow2 = this.this$0.launchFlow;
                        ubcManager2.flowEndSlot(flow2, MediaLivePluginLogger.PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME);
                        ubcManager3 = this.this$0.getUbcManager();
                        flow3 = this.this$0.launchFlow;
                        ubcManager3.flowStartSlot(flow3, MediaLivePluginLogger.PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE, null);
                    }
                }
            });
        }
    }

    public final void logGetLiveTypeEndAndItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            logDebug("logLiveRoomEndGetLiveTypeTimeAndEndParse");
            if (this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE);
            }
        }
    }

    public final void logListBeginGetLiveTypeStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            logDebug("logListBeginGetLiveTypeStart");
            if (!this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_START, null);
                this.hasLoggedBeginGetLiveTypeReqStart = true;
            }
        }
    }

    public final void logListBeginSlideReqStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            logDebug("logListBeginSlideReqStart");
            if (!this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START, null);
                this.hasLoggedBeginSlideReqStart = true;
            }
        }
    }

    public final void logListSlideEndAndAddItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            logDebug("logListSlideEndAndAddItem");
            if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME);
            }
        }
    }

    public final void logLiveRoomFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            logDebug("logLiveRoomFirstFrame");
            if (!this.hasLoggedFirstFrame && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME);
                this.hasLoggedFirstFrame = false;
            }
        }
    }

    public final void logLiveRoomPageResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            logDebug("logLiveRoomPageResume");
            if (!this.hasLoggedResume && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_RESUME);
                this.hasLoggedResume = true;
            }
        }
    }

    public final void logLiveRoomStartPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            logDebug("logLiveRoomStartPage");
            if (!this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, "page_init", null);
                this.hasLoggedInit = true;
            }
        }
    }

    public final void logPageEnterLiveParseEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            logDebug("logPageEnterLiveParseEnd");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE);
            }
        }
    }

    public final void logPageEnterLiveParseStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            logDebug("logPageEnterLiveParseStart");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE, null);
            }
        }
    }

    private final void logLiveRoomDrawUIFinish() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            logDebug("logLiveRoomDrawUIFinish");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_AFTER_ENTER_LIVE_PAGE_DRAW);
                if (this.isDebug) {
                    JSONObject jSONObject = new JSONObject();
                    Flow flow = this.launchFlow;
                    if (flow == null) {
                        Intrinsics.throwNpe();
                    }
                    for (Map.Entry entry : new HashMap(flow.getSlotMaps()).entrySet()) {
                        Slot value = (Slot) entry.getValue();
                        JSONObject jSONObject2 = new JSONObject();
                        Intrinsics.checkExpressionValueIsNotNull(value, "value");
                        jSONObject2.put("s", value.getStart());
                        jSONObject2.put("e", value.getEnd());
                        jSONObject.put((String) entry.getKey(), jSONObject2);
                    }
                    Log.d("LIVE_ARCH", jSONObject.toString());
                }
                UBCManager ubcManager = getUbcManager();
                Flow flow2 = this.launchFlow;
                JSONObject jSONObject3 = this.logStartPageValueJson;
                if (jSONObject3 != null) {
                    str = jSONObject3.toString();
                } else {
                    str = null;
                }
                ubcManager.flowSetValueWithDuration(flow2, str);
                getUbcManager().flowEnd(this.launchFlow);
                if (this.isDebug) {
                    printFlowEachSlotInfo();
                }
                this.launchFlow = null;
            }
        }
    }

    public static /* synthetic */ void updateStartPageInfoIntentRoomInfo$default(MediaLivePluginLogger mediaLivePluginLogger, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        mediaLivePluginLogger.updateStartPageInfoIntentRoomInfo(str, str2, z);
    }

    public final void createSelectLaunchInfo(boolean z, String str, String str2, boolean z2, boolean z3, String str3, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3), str3, str4}) != null) || !z) {
            return;
        }
        logLiveRoomLeave("pageChange");
        this.hasLoggedBeginPreEnterReqStart = false;
        this.hasLoggedCreateMixShell = false;
        this.hasLoggedBindMixShell = false;
        this.hasLoggedSelectMixShell = false;
        this.hasLoggedCreateMediaComponent = false;
        this.hasLoggedBindMediaComponent = false;
        this.hasLoggedSelect = false;
        if (getUbcManager() != null && this.launchFlow == null) {
            Flow beginFlow = getUbcManager().beginFlow(this.UBC_ID_PLUGIN_PAGE_FLOW);
            this.launchFlow = beginFlow;
            if (beginFlow != null) {
                j = beginFlow.getStartTime();
            } else {
                j = 0;
            }
            this.pageLoadStartTime = j;
            updateStartPageInfo(str, str2, z2, z3);
            updateStartPageInfoIntentRoomInfo(str3, str4, !z);
        }
    }

    public final void endSlot(final String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                this.handler.post(new Runnable(this, str) { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$endSlot$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $slotName;
                    public final /* synthetic */ MediaLivePluginLogger this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.$slotName = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        UBCManager ubcManager;
                        Flow flow;
                        UBCManager ubcManager2;
                        Flow flow2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        ubcManager = this.this$0.getUbcManager();
                        if (ubcManager == null) {
                            return;
                        }
                        flow = this.this$0.launchFlow;
                        if (flow == null) {
                            return;
                        }
                        ubcManager2 = this.this$0.getUbcManager();
                        flow2 = this.this$0.launchFlow;
                        ubcManager2.flowEndSlot(flow2, this.$slotName);
                    }
                });
            } else if (getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, str);
            }
        }
    }

    public final void startSlot(final String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, str2) == null) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                this.handler.post(new Runnable(this, str) { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$startSlot$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $slotName;
                    public final /* synthetic */ MediaLivePluginLogger this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.$slotName = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        UBCManager ubcManager;
                        Flow flow;
                        UBCManager ubcManager2;
                        Flow flow2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        ubcManager = this.this$0.getUbcManager();
                        if (ubcManager == null) {
                            return;
                        }
                        flow = this.this$0.launchFlow;
                        if (flow == null) {
                            return;
                        }
                        ubcManager2 = this.this$0.getUbcManager();
                        flow2 = this.this$0.launchFlow;
                        ubcManager2.flowStartSlot(flow2, this.$slotName, null);
                    }
                });
            } else if (getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowStartSlot(this.launchFlow, str, null);
            }
        }
    }

    public final void logBindMediaComponentDataEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            logDebug("logBindMediaComponentDataEnd");
            if (this.hasLoggedBindMediaComponent && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, "bind_media_component");
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT, null);
            }
        }
    }

    public final void logBindMixShellDataEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            logDebug("logBindMixShellDataEnd");
            if (this.hasLoggedBindMixShell && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_BIND_MIX_SHELL);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL, null);
            }
        }
    }

    public final void logCreateMixShellStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            logDebug("logCreateMixShellStart");
            if (!this.hasLoggedCreateMixShell && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_CREATE_MIX_SHELL, null);
                this.hasLoggedCreateMixShell = true;
            }
        }
    }

    public final void logFirstJumpPreEnterReqStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            logDebug("logFirstJumpPreEnterReqStart");
            if (this.hasLoggedBeginPreEnterReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME, null);
            }
        }
    }

    public final void logGetLiveTypeNetEndAndStartParse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            logDebug("logLiveRoomEndGetLiveTypeTimeAndStartParse");
            if (this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, "get_live_type_time");
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE, null);
            }
        }
    }

    public final void logListGetLiveTypeStartToSendReqNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            logDebug("logListGetLiveTypeStartToSendReqNet");
            if (this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_START);
                getUbcManager().flowStartSlot(this.launchFlow, "get_live_type_time", null);
            }
        }
    }

    public final void logListLoadRoomAndNextListAddItem() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !this.hasLogAddItem && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logListLoadRoomAndNextListAddItem");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM, null);
            this.hasLogAddItem = true;
        }
    }

    public final void logListOnCreateEndAndNextToLoadRoom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logListOnCreateEndAndNextToLoadRoom");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM, null);
        }
    }

    public final void logListOnCreateStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logListOnCreateStart");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM, null);
        }
    }

    public final void logListParseEndAndNextToAddItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            logDebug("logListParseEndAndNextToAddItem");
            if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_PARSE_TIME);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME, null);
            }
        }
    }

    public final void logListSlideReqNetEndAndStartParse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            logDebug("logListSlideReqNetEndAndStartParse");
            if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_NET_TIME);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_PARSE_TIME, null);
            }
        }
    }

    public final void logListSlideStartToSendReqNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            logDebug("logListSlideStartToSendReqNet");
            if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_NET_TIME, null);
            }
        }
    }

    public final void logLiveRoomPageEndAndPageAttachStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            logDebug("logLiveRoomPageEndAndPageAttachStart");
            if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, "page_init");
                getUbcManager().flowStartSlot(this.launchFlow, "page_attach", null);
            }
        }
    }

    public final void logMixShellOnSelect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            logDebug("logMixShellOnSelect");
            if (this.isDebug) {
                pageSelectStartTime = System.currentTimeMillis();
            }
            if (!this.hasLoggedSelectMixShell && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL);
                this.hasLoggedSelectMixShell = true;
            }
        }
    }

    public final void logPageEnterLiveRoomReqNetEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            logDebug("logPageEnterLiveRoomReqNetEnd");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null && this.hasSendEnterRequest) {
                if (this.isDebug) {
                    pageEnterNetDuration = System.currentTimeMillis() - pageEnterStartTime;
                }
                this.hasSendEnterRequest = false;
                getUbcManager().flowEndSlot(this.launchFlow, "page_enter_live_req");
            }
        }
    }

    public final void logPageEnterLiveRoomReqNetStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            logDebug("logPageEnterLiveRoomReqNetStart");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                if (this.isDebug) {
                    pageEnterStartTime = System.currentTimeMillis();
                }
                this.hasSendEnterRequest = true;
                getUbcManager().flowStartSlot(this.launchFlow, "page_enter_live_req", null);
            }
        }
    }

    public final void logPageOnCreateEnd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logPageOnCreateEnd");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_TIME);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START, null);
        }
    }

    public final void logPageOnCreateStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            logDebug("logPageOnCreateStart");
            if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
                getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START);
                getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_TIME, null);
            }
        }
    }

    public final void logPageSelectedEnterFetchEnd() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            logDebug("logPageSelectedEnterFetchEnd");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                UBCManager ubcManager = getUbcManager();
                Flow flow = this.launchFlow;
                if (this.preEnterSwitch) {
                    str = PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_PRE;
                } else {
                    str = PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_NO;
                }
                ubcManager.flowEndSlot(flow, str);
            }
        }
    }

    public final void logPageSelectedEnterFetchStart() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            logDebug("logPageSelectedEnterFetchStart");
            if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
                UBCManager ubcManager = getUbcManager();
                Flow flow = this.launchFlow;
                if (this.preEnterSwitch) {
                    str = PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_PRE;
                } else {
                    str = PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_NO;
                }
                ubcManager.flowStartSlot(flow, str, null);
            }
        }
    }

    public final void logLiveRoomLeave(String str) {
        JSONObject jSONObject;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            logDebug("logLiveRoomLeave");
            if (getUbcManager() != null && this.launchFlow != null) {
                JSONObject jSONObject2 = this.logStartPageValueJson;
                if (jSONObject2 != null) {
                    jSONObject = jSONObject2.optJSONObject("ext");
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    jSONObject.put("leave_from", str);
                }
                UBCManager ubcManager = getUbcManager();
                Flow flow = this.launchFlow;
                JSONObject jSONObject3 = this.logStartPageValueJson;
                if (jSONObject3 != null) {
                    str2 = jSONObject3.toString();
                } else {
                    str2 = null;
                }
                ubcManager.flowSetValue(flow, str2);
                getUbcManager().flowEnd(this.launchFlow);
                this.launchFlow = null;
            }
        }
    }

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onFinished(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -2138765360) {
                if (hashCode != -1785848897) {
                    if (hashCode == -1205843543 && str.equals(LiveComponentStatusHelper.BOTTOM_LIVE_COMPONENT)) {
                        logLiveRoomPageEndLayoutDrawBottomComponent();
                    }
                } else if (str.equals(LiveComponentStatusHelper.TOPBAR_LIVE_COMPONENT)) {
                    logLiveRoomPageEndLayoutDrawTopComponent();
                }
            } else if (str.equals(LiveComponentStatusHelper.IM_LIVE_COMPONENT)) {
                logLiveRoomPageEndLayoutDrawIMComponent();
            }
        }
    }

    public final void updateLaunchFlowObj(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, obj) == null) {
            if (!(obj instanceof Flow)) {
                obj = null;
            }
            Flow flow = (Flow) obj;
            this.launchFlow = flow;
            if (flow != null) {
                j = flow.getStartTime();
            } else {
                j = 0;
            }
            this.pageLoadStartTime = j;
            this.hasLoggedInit = false;
            this.hasLoggedCreateMixShell = false;
            this.hasLoggedBindMixShell = false;
            this.hasLoggedBeginSlideReqStart = false;
            this.hasLoggedBeginGetLiveTypeReqStart = false;
            this.hasLoggedBeginPreEnterReqStart = false;
            this.hasLogAddItem = false;
            this.hasLoggedSelectMixShell = false;
            this.hasLoggedFirstFrame = false;
            this.hasLoggedResume = false;
            this.hasLoggedCreateMediaComponent = false;
            this.hasLoggedBindMediaComponent = false;
            this.hasLoggedSelect = false;
            logDebug("updateLaunchFlowObj");
        }
    }

    public final void updateStartPageInfo(String str, String str2, boolean z, boolean z2) {
        int i;
        int i2;
        boolean z3;
        Object obj;
        boolean z4;
        Object obj2;
        Object obj3;
        boolean z5;
        Object obj4;
        Boolean bool;
        Object obj5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                jSONObject.put("type", "medialivechatflow");
                jSONObject.put("source", str2);
                jSONObject.put("page", "media_live_room");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("room_id", str);
                    boolean z6 = true;
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject2.put("has_stream_info", i);
                    if (z2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jSONObject2.put("is_cold_launch", i2);
                    jSONObject2.put("livesdk", MiniPluginInfoHelper.INSTANCE.getVersionName("com.baidu.searchbox.livenps"));
                    Boolean bool2 = this.switchPreloadSplite;
                    String str3 = "1";
                    if (bool2 != null) {
                        if (bool2.booleanValue()) {
                            obj5 = "1";
                        } else {
                            obj5 = "0";
                        }
                        jSONObject2.put("prohibit_preload_splite", obj5);
                    }
                    AbConfigService abService = getAbService();
                    if (abService != null && abService.getSwitch(MiniPluginManager.PROHIBIT_PRE_LOAD_MEDIA_SWITCH, false)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    jSONObject2.put("prohibit_preload_media_business", obj);
                    AbConfigService abService2 = getAbService();
                    if (abService2 != null && abService2.getSwitch(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, false)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        obj2 = "1";
                    } else {
                        obj2 = "0";
                    }
                    jSONObject2.put(MiniPluginManager.LIVE_DELAY_LOAD_MEDIA_SWITCH, obj2);
                    AbConfigService abService3 = getAbService();
                    if (abService3 == null || !abService3.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false)) {
                        z6 = false;
                    }
                    if (z6) {
                        obj3 = "1";
                    } else {
                        obj3 = "0";
                    }
                    jSONObject2.put(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, obj3);
                    AbConfigService abService4 = getAbService();
                    if (abService4 != null) {
                        z5 = abService4.getSwitch("android_live_media_pre_inflate_queue", false);
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        obj4 = "1";
                    } else {
                        obj4 = "0";
                    }
                    jSONObject2.put("android_live_media_pre_inflate_queue", obj4);
                    AbConfigService abService5 = getAbService();
                    if (abService5 != null) {
                        bool = Boolean.valueOf(abService5.getSwitch("android_live_first_disp_notify_sub_thread", false));
                    } else {
                        bool = null;
                    }
                    if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        str3 = "0";
                    }
                    jSONObject2.put("sub_thread_notify_first_dip_switch", str3);
                    logDebug("禁止预加载二级实验 " + z3 + "， 延时加载二级实验： " + z4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "前请求 enter 接口实验 " + z6 + ", 二级预加载打散：" + z5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "播放器子首帧子线程通知：" + bool);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jSONObject.put("ext", jSONObject2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.logStartPageValueJson = jSONObject;
            logDebug("updateStartPageInfo=" + String.valueOf(this.logStartPageValueJson));
        }
    }

    public final void updateStartPageInfoIntentRoomInfo(String str, String str2, boolean z) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048632, this, str, str2, z) == null) && getUbcManager() != null && this.launchFlow != null) {
            JSONObject jSONObject2 = this.logStartPageValueJson;
            if (jSONObject2 != null) {
                jSONObject = jSONObject2.optJSONObject("ext");
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                jSONObject.put("room_type", str);
            }
            if (jSONObject != null) {
                jSONObject.put("room_template", str2);
            }
            if (jSONObject != null) {
                jSONObject.put("first_jump", z ? 1 : 0);
            }
        }
    }
}
