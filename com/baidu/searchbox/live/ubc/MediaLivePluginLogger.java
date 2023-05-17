package com.baidu.searchbox.live.ubc;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.transition.Transition;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.mix.proxy.LiveMixShellManager;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.service.ILivePageInfoInterface;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.ubc.LiveComponentStatusHelper;
import com.baidu.searchbox.live.util.MiniPluginInfoHelper;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\bH\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008d\u0001B\n\b\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0015JM\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u0015J\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u0015J\r\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u0015J\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001fJ\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u0015J\r\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010\u0015J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\u0015J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\u0015J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u0015J\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\u0015J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\u0015J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u0015J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010\u0015J\r\u0010*\u001a\u00020\u000b¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u0015J\r\u0010,\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\u0015J\r\u0010-\u001a\u00020\u000b¢\u0006\u0004\b-\u0010\u0015J\r\u0010.\u001a\u00020\u000b¢\u0006\u0004\b.\u0010\u0015J\r\u0010/\u001a\u00020\u000b¢\u0006\u0004\b/\u0010\u0015J\r\u00100\u001a\u00020\u000b¢\u0006\u0004\b0\u0010\u0015J\u000f\u00101\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u0010\u0015J\r\u00102\u001a\u00020\u000b¢\u0006\u0004\b2\u0010\u0015J\u0015\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u001fJ\r\u00105\u001a\u00020\u000b¢\u0006\u0004\b5\u0010\u0015J\r\u00106\u001a\u00020\u000b¢\u0006\u0004\b6\u0010\u0015J\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u0010\u0015J\r\u00108\u001a\u00020\u000b¢\u0006\u0004\b8\u0010\u0015J\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010\u0015J\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\u0015J\r\u0010<\u001a\u00020\u000b¢\u0006\u0004\b<\u0010\u0015J\r\u0010=\u001a\u00020\u000b¢\u0006\u0004\b=\u0010\u0015J\r\u0010>\u001a\u00020\u000b¢\u0006\u0004\b>\u0010\u0015J\r\u0010?\u001a\u00020\u000b¢\u0006\u0004\b?\u0010\u0015J\r\u0010@\u001a\u00020\u000b¢\u0006\u0004\b@\u0010\u0015J\r\u0010A\u001a\u00020\u000b¢\u0006\u0004\bA\u0010\u0015J\r\u0010B\u001a\u00020\u000b¢\u0006\u0004\bB\u0010\u0015J\r\u0010C\u001a\u00020\u000b¢\u0006\u0004\bC\u0010\u0015J\r\u0010D\u001a\u00020\u000b¢\u0006\u0004\bD\u0010\u0015J\r\u0010E\u001a\u00020\u000b¢\u0006\u0004\bE\u0010\u0015J\r\u0010F\u001a\u00020\u000b¢\u0006\u0004\bF\u0010\u0015J\r\u0010G\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\u0015J\r\u0010H\u001a\u00020\u000b¢\u0006\u0004\bH\u0010\u0015J\r\u0010I\u001a\u00020\u000b¢\u0006\u0004\bI\u0010\u0015J\r\u0010J\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010\u0015J\u000f\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0004\bK\u0010\u0015J\u0017\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u0004H\u0016¢\u0006\u0004\bM\u0010\u001fJ\u000f\u0010N\u001a\u00020\u000bH\u0002¢\u0006\u0004\bN\u0010\u0015J\u0017\u0010P\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bR\u0010QJ\u001f\u0010S\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bS\u0010\u0011J\u0015\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bV\u0010WJ=\u0010Y\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bY\u0010ZJ5\u0010\\\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010[\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010_R%\u0010f\u001a\n a*\u0004\u0018\u00010`0`8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010kR\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010kR\u0016\u0010n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010kR\u0016\u0010o\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010kR\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010kR\u0016\u0010q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010kR\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010kR\u0016\u0010s\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010kR\u0016\u0010t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010kR\u0016\u0010u\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010kR\u0016\u0010v\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010kR\u0016\u0010w\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010kR\u0016\u0010x\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010kR\u0016\u0010y\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010kR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010kR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0085\u0001R\"\u0010\u008b\u0001\u001a\u00030\u0087\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0001\u0010c\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;", "com/baidu/searchbox/live/ubc/LiveComponentStatusHelper$ILiveComponentLoadFinish", "", "isFromUser", "", "roomId", "source", "hasStream", FlowInfoHelper.KEY_IS_COLDLAUNCH, "roomType", "roomTemplate", "", "createSelectLaunchInfo", "(ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "slotName", "depSlot", "endSlot", "(Ljava/lang/String;Ljava/lang/String;)V", "getSwitchPreloadSplite", "()Ljava/lang/Boolean;", "logBindMediaComponentDataEnd", "()V", "logBindMediaComponentDataStart", "logBindMixShellDataEnd", "logBindMixShellDataStart", "logCreateMediaComponentEnd", "logCreateMediaComponentStart", "logCreateMixShellEnd", "logCreateMixShellStart", "msg", "logDebug", "(Ljava/lang/String;)V", "logDebugE", "logFirstJumpPreEnterParseEnd", "logFirstJumpPreEnterReqStart", "logFirstJumpPreEnterStart", "logFirstJumpPreEnterStartParse", "logGetLiveTypeEndAndItem", "logGetLiveTypeNetEndAndStartParse", "logListBeginGetLiveTypeStart", "logListBeginSlideReqStart", "logListGetLiveTypeStartToSendReqNet", "logListLoadRoomAndNextListAddItem", "logListOnCreateEndAndNextToLoadRoom", "logListOnCreateStart", "logListParseEndAndNextToAddItem", "logListSlideEndAndAddItem", "logListSlideReqNetEndAndStartParse", "logListSlideStartToSendReqNet", "logLiveRoomDrawUIFinish", "logLiveRoomFirstFrame", "leaveFrom", "logLiveRoomLeave", "logLiveRoomPageEndAndPageAttachStart", "logLiveRoomPageEndBindStartLayout", "logLiveRoomPageEndLayoutDrawBottomComponent", "logLiveRoomPageEndLayoutDrawComponent", "logLiveRoomPageEndLayoutDrawIMComponent", "logLiveRoomPageEndLayoutDrawTopComponent", "logLiveRoomPageOnSelect", "logLiveRoomPageResume", "logLiveRoomStartPage", "logMixShellOnSelect", "logPageAfterSelectedEndFetchLiveBeanDispatchStart", "logPageAfterSelectedStartFetchLiveBean", "logPageAttachEndNextToPageOnCreate", "logPageEnterLiveParseEnd", "logPageEnterLiveParseStart", "logPageEnterLiveRoomReqNetEnd", "logPageEnterLiveRoomReqNetEndAndParseStart", "logPageEnterLiveRoomReqNetStart", "logPageOnCreateEnd", "logPageOnCreateStart", "logPageSelectedEnterFetchEnd", "logPageSelectedEnterFetchStart", "onCoreFinished", "componentName", "onFinished", "printFlowEachSlotInfo", "preLoadSwitch", "setSwitchBusinessPreloadSplite", "(Ljava/lang/Boolean;)V", "setSwitchPreloadSplite", "startSlot", "", "flowObj", "updateLaunchFlowObj", "(Ljava/lang/Object;)V", "businessPluginStatus", "updateStartPageInfo", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "firstJump", "updateStartPageInfoIntentRoomInfo", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "UBC_ID_PLUGIN_PAGE_FLOW", "Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "kotlin.jvm.PlatformType", "abService$delegate", "Lkotlin/Lazy;", "getAbService", "()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;", "abService", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "hasLogAddItem", "Z", "hasLoggedBeginGetLiveTypeReqStart", "hasLoggedBeginPreEnterReqStart", "hasLoggedBeginSlideReqStart", "hasLoggedBindMediaComponent", "hasLoggedBindMixShell", "hasLoggedCreateMediaComponent", "hasLoggedCreateMixShell", "hasLoggedFirstFrame", "hasLoggedInit", "hasLoggedResume", "hasLoggedSelect", "hasLoggedSelectMixShell", "hasSendEnterRequest", "isDebug", "Lcom/baidu/ubc/Flow;", "launchFlow", "Lcom/baidu/ubc/Flow;", "Lorg/json/JSONObject;", "logStartPageValueJson", "Lorg/json/JSONObject;", "", "pageLoadStartTime", "J", "preEnterSwitch", "switchBusinessPreloadSplite", "Ljava/lang/Boolean;", "switchPreloadSplite", "Lcom/baidu/ubc/UBCManager;", "ubcManager$delegate", "getUbcManager", "()Lcom/baidu/ubc/UBCManager;", "ubcManager", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MediaLivePluginLogger implements LiveComponentStatusHelper.ILiveComponentLoadFinish {
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
    public static long pageEnterNetDuration;
    public static long pageEnterStartTime;
    public static long pageSelectStartTime;
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
    public Boolean switchBusinessPreloadSplite;
    public Boolean switchPreloadSplite;
    public final Lazy ubcManager$delegate;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MediaLivePluginLogger.class), "ubcManager", "getUbcManager()Lcom/baidu/ubc/UBCManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MediaLivePluginLogger.class), "abService", "getAbService()Lcom/baidu/searchbox/live/interfaces/service/AbConfigService;"))};
    public static final Companion Companion = new Companion(null);
    public static final Lazy instance$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MediaLivePluginLogger>() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$Companion$instance$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MediaLivePluginLogger invoke() {
            MediaLivePluginLogger mediaLivePluginLogger = new MediaLivePluginLogger(null);
            LiveComponentStatusHelper.Companion.getInstance().addComponentFinishCallback(mediaLivePluginLogger);
            return mediaLivePluginLogger;
        }
    });

    private final AbConfigService getAbService() {
        Lazy lazy = this.abService$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (AbConfigService) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UBCManager getUbcManager() {
        Lazy lazy = this.ubcManager$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (UBCManager) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b6\u00107R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0003R\u0016\u0010\u001b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0003R\u0016\u0010\u001e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0003R\u0016\u0010 \u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0003R\u0016\u0010!\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0003R\u0016\u0010\"\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0003R\u0016\u0010#\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0003R\u0016\u0010$\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0003R\u0016\u0010%\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0003R\u0016\u0010&\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0003R\u0016\u0010'\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0003R\u0016\u0010(\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0003R\u0016\u0010)\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0003R\u0016\u0010*\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0003R\u001d\u00100\u001a\u00020+8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103¨\u00068"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger$Companion;", "", "MEDIA_LIVE_PLUGIN_TAG", "Ljava/lang/String;", "PAGE_SELECT_SOURCE", "PAGE_SLOT_BIND_MEDIA_COMPONENT", "PAGE_SLOT_BIND_MIX_SHELL", "PAGE_SLOT_BIND_TO_NOTIFY_SELECT", "PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL", "PAGE_SLOT_CREATE_MEDIA_COMPONENT", "PAGE_SLOT_CREATE_MIX_SHELL", "PAGE_SLOT_DISPATCH_ENTER_ACTION", "PAGE_SLOT_GET_LIVE_TYPE_START", "PAGE_SLOT_GET_LIVE_TYPE_TIME", "PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE", "PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME", "PAGE_SLOT_GET_SLIDE_NET_TIME", "PAGE_SLOT_GET_SLIDE_PARSE_TIME", "PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM", "PAGE_SLOT_LOAD_ROOM", "PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START", "PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM", "PAGE_SLOT_PAGE_AFTER_ENTER_LIVE_PAGE_DRAW", "PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START", "PAGE_SLOT_PAGE_ATTACH_TIME", "PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME", "PAGE_SLOT_PAGE_ATTACH_TO_RESUME", "PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START", "PAGE_SLOT_PAGE_CREATE_TIME", "PAGE_SLOT_PAGE_ENTER_LIVE_NOTIFY_BIND", "PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE", "PAGE_SLOT_PAGE_ENTER_LIVE_REQ_TIME", "PAGE_SLOT_PAGE_INIT", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_BOTTOM", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_IM", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_LAYOUT", "PAGE_SLOT_PAGE_LAYOUT_MANAGER_TOP", "PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE", "PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME", "PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START", "PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_NO", "PAGE_SLOT_PAGE_SELECTED_ENTER_FETCH_PRE", "PAGE_SLOT_PAGE_SELECT_FETCH_START", "Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;", Transition.MATCH_INSTANCE_STR, "", "pageEnterNetDuration", "J", "pageEnterStartTime", "pageSelectStartTime", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/baidu/searchbox/live/ubc/MediaLivePluginLogger;"))};

        public final MediaLivePluginLogger getInstance() {
            Lazy lazy = MediaLivePluginLogger.instance$delegate;
            Companion companion = MediaLivePluginLogger.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (MediaLivePluginLogger) lazy.getValue();
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void logLiveRoomPageEndLayoutDrawBottomComponent() {
        logDebug("logLiveRoomPageEndLayoutDrawBottomComponent");
        if (this.isDebug) {
            long currentTimeMillis = System.currentTimeMillis();
            logDebug("底部bar组件渲染完成了：" + (currentTimeMillis - pageSelectStartTime));
        }
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_BOTTOM);
        }
    }

    private final void logLiveRoomPageEndLayoutDrawIMComponent() {
        logDebug("logLiveRoomPageEndLayoutDrawIMComponent");
        if (this.isDebug) {
            long currentTimeMillis = System.currentTimeMillis();
            logDebug("IM组件渲染完成了：" + (currentTimeMillis - pageSelectStartTime));
        }
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_IM);
        }
    }

    private final void logLiveRoomPageEndLayoutDrawTopComponent() {
        logDebug("logLiveRoomPageEndLayoutDrawTopComponent");
        if (this.isDebug) {
            long currentTimeMillis = System.currentTimeMillis();
            logDebug("顶部bar组件渲染完成了：" + (currentTimeMillis - pageSelectStartTime));
        }
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_LAYOUT_MANAGER_TOP);
        }
    }

    public final void logLiveRoomPageOnSelect() {
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

    public final void logPageAttachEndNextToPageOnCreate() {
        logDebug("logPageAttachEndNextToPageOnCreate");
        if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, "page_attach");
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START, null);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_RESUME, null);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME, null);
        }
    }

    public final void logPageEnterLiveRoomReqNetEnd() {
        logDebug("logPageEnterLiveRoomReqNetEnd");
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null && this.hasSendEnterRequest) {
            if (this.isDebug) {
                pageEnterNetDuration = System.currentTimeMillis() - pageEnterStartTime;
            }
            this.hasSendEnterRequest = false;
            getUbcManager().flowEndSlot(this.launchFlow, "page_enter_live_req");
        }
    }

    public final void logPageEnterLiveRoomReqNetEndAndParseStart() {
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

    public MediaLivePluginLogger() {
        boolean z;
        this.ubcManager$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<UBCManager>() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$ubcManager$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UBCManager invoke() {
                return (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
        });
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            z = appInfoService.isDebug();
        } else {
            z = false;
        }
        this.isDebug = z;
        this.abService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AbConfigService>() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$abService$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AbConfigService invoke() {
                return (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
            }
        });
        AbConfigService abService = getAbService();
        this.preEnterSwitch = abService != null ? abService.getSwitch(MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH, false) : false;
        this.UBC_ID_PLUGIN_PAGE_FLOW = LiveMixShellManager.UBC_ID_PLUGIN_PAGE_FLOW;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public final void logPageAfterSelectedEndFetchLiveBeanDispatchStart() {
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

    public final void logPageAfterSelectedStartFetchLiveBean() {
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

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onCoreFinished() {
        long j;
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

    public /* synthetic */ MediaLivePluginLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void logDebug(String str) {
        if (this.isDebug) {
            Log.d("LIVE_ARCH", str);
        }
    }

    public final void logDebugE(String str) {
        if (this.isDebug) {
            Log.e("LIVE_ARCH", str);
        }
    }

    public final void setSwitchBusinessPreloadSplite(Boolean bool) {
        if (bool != null) {
            this.switchBusinessPreloadSplite = Boolean.valueOf(bool.booleanValue());
        }
    }

    public final void setSwitchPreloadSplite(Boolean bool) {
        if (bool != null) {
            this.switchPreloadSplite = Boolean.valueOf(bool.booleanValue());
        }
    }

    public final Boolean getSwitchPreloadSplite() {
        return this.switchPreloadSplite;
    }

    public final void logBindMediaComponentDataEnd() {
        logDebug("logBindMediaComponentDataEnd");
        if (this.hasLoggedBindMediaComponent && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, "bind_media_component");
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT, null);
        }
    }

    public final void logBindMediaComponentDataStart() {
        logDebug("logBindMediaComponentDataStart");
        if (!this.hasLoggedBindMediaComponent && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, "bind_media_component", null);
            this.hasLoggedBindMediaComponent = true;
        }
    }

    public final void logBindMixShellDataEnd() {
        logDebug("logBindMixShellDataEnd");
        if (this.hasLoggedBindMixShell && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_BIND_MIX_SHELL);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL, null);
        }
    }

    public final void logBindMixShellDataStart() {
        logDebug("logBindMixShellDataStart");
        if (!this.hasLoggedBindMixShell && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_BIND_MIX_SHELL, null);
            this.hasLoggedBindMixShell = true;
        }
    }

    public final void logCreateMediaComponentEnd() {
        logDebug("logCreateMediaComponentEnd");
        if (this.hasLoggedCreateMediaComponent && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, "create_media_component");
        }
    }

    public final void logCreateMediaComponentStart() {
        logDebug("logCreateMediaComponentStart");
        if (!this.hasLoggedCreateMediaComponent && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, "create_media_component", null);
            this.hasLoggedCreateMediaComponent = true;
        }
    }

    public final void logCreateMixShellEnd() {
        logDebug("logCreateMixShellEnd");
        if (this.hasLoggedCreateMixShell && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_CREATE_MIX_SHELL);
        }
    }

    public final void logCreateMixShellStart() {
        logDebug("logCreateMixShellStart");
        if (!this.hasLoggedCreateMixShell && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_CREATE_MIX_SHELL, null);
            this.hasLoggedCreateMixShell = true;
        }
    }

    public final void logFirstJumpPreEnterParseEnd() {
        this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$logFirstJumpPreEnterParseEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                UBCManager ubcManager;
                Flow flow;
                UBCManager ubcManager2;
                Flow flow2;
                MediaLivePluginLogger.this.logDebug("logFirstJumpPreEnterParseEnd");
                z = MediaLivePluginLogger.this.hasLoggedBeginPreEnterReqStart;
                if (!z) {
                    return;
                }
                ubcManager = MediaLivePluginLogger.this.getUbcManager();
                if (ubcManager == null) {
                    return;
                }
                flow = MediaLivePluginLogger.this.launchFlow;
                if (flow == null) {
                    return;
                }
                ubcManager2 = MediaLivePluginLogger.this.getUbcManager();
                flow2 = MediaLivePluginLogger.this.launchFlow;
                ubcManager2.flowEndSlot(flow2, MediaLivePluginLogger.PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE);
            }
        });
    }

    public final void logFirstJumpPreEnterReqStart() {
        logDebug("logFirstJumpPreEnterReqStart");
        if (this.hasLoggedBeginPreEnterReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME, null);
        }
    }

    public final void logFirstJumpPreEnterStart() {
        logDebug("logFirstJumpPreEnterStart");
        if (!this.hasLoggedBeginPreEnterReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_PRE_ENTER_LIVE_START, null);
            this.hasLoggedBeginPreEnterReqStart = true;
        }
    }

    public final void logFirstJumpPreEnterStartParse() {
        this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$logFirstJumpPreEnterStartParse$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                UBCManager ubcManager;
                Flow flow;
                UBCManager ubcManager2;
                Flow flow2;
                UBCManager ubcManager3;
                Flow flow3;
                MediaLivePluginLogger.this.logDebug("logFirstJumpPreEnterStartParse");
                z = MediaLivePluginLogger.this.hasLoggedBeginPreEnterReqStart;
                if (!z) {
                    return;
                }
                ubcManager = MediaLivePluginLogger.this.getUbcManager();
                if (ubcManager == null) {
                    return;
                }
                flow = MediaLivePluginLogger.this.launchFlow;
                if (flow == null) {
                    return;
                }
                ubcManager2 = MediaLivePluginLogger.this.getUbcManager();
                flow2 = MediaLivePluginLogger.this.launchFlow;
                ubcManager2.flowEndSlot(flow2, MediaLivePluginLogger.PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_TIME);
                ubcManager3 = MediaLivePluginLogger.this.getUbcManager();
                flow3 = MediaLivePluginLogger.this.launchFlow;
                ubcManager3.flowStartSlot(flow3, MediaLivePluginLogger.PAGE_SLOT_PAGE_PRE_ENTER_LIVE_REQ_PARSE, null);
            }
        });
    }

    public final void logGetLiveTypeEndAndItem() {
        logDebug("logLiveRoomEndGetLiveTypeTimeAndEndParse");
        if (this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE);
        }
    }

    public final void logGetLiveTypeNetEndAndStartParse() {
        logDebug("logLiveRoomEndGetLiveTypeTimeAndStartParse");
        if (this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, "get_live_type_time");
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_TIME_PARSE, null);
        }
    }

    public final void logListBeginGetLiveTypeStart() {
        logDebug("logListBeginGetLiveTypeStart");
        if (!this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_START, null);
            this.hasLoggedBeginGetLiveTypeReqStart = true;
        }
    }

    public final void logListBeginSlideReqStart() {
        logDebug("logListBeginSlideReqStart");
        if (!this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START, null);
            this.hasLoggedBeginSlideReqStart = true;
        }
    }

    public final void logListGetLiveTypeStartToSendReqNet() {
        logDebug("logListGetLiveTypeStartToSendReqNet");
        if (this.hasLoggedBeginGetLiveTypeReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_LIVE_TYPE_START);
            getUbcManager().flowStartSlot(this.launchFlow, "get_live_type_time", null);
        }
    }

    public final void logListLoadRoomAndNextListAddItem() {
        if (!this.hasLogAddItem && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logListLoadRoomAndNextListAddItem");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_TO_LIST_ADD_ITEM, null);
            this.hasLogAddItem = true;
        }
    }

    public final void logListOnCreateEndAndNextToLoadRoom() {
        if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logListOnCreateEndAndNextToLoadRoom");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM, null);
        }
    }

    public final void logListOnCreateStart() {
        if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logListOnCreateStart");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_LIST_CREATE_TO_LOAD_ROOM, null);
        }
    }

    public final void logListParseEndAndNextToAddItem() {
        logDebug("logListParseEndAndNextToAddItem");
        if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_PARSE_TIME);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME, null);
        }
    }

    public final void logListSlideEndAndAddItem() {
        logDebug("logListSlideEndAndAddItem");
        if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_LIST_TO_ADD_TIME);
        }
    }

    public final void logListSlideReqNetEndAndStartParse() {
        logDebug("logListSlideReqNetEndAndStartParse");
        if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_NET_TIME);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_PARSE_TIME, null);
        }
    }

    public final void logListSlideStartToSendReqNet() {
        logDebug("logListSlideStartToSendReqNet");
        if (this.hasLoggedBeginSlideReqStart && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_LOAD_ROOM_GET_SLIDE_START);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_GET_SLIDE_NET_TIME, null);
        }
    }

    public final void logLiveRoomFirstFrame() {
        logDebug("logLiveRoomFirstFrame");
        if (!this.hasLoggedFirstFrame && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_FIRST_FRAME);
            this.hasLoggedFirstFrame = false;
        }
    }

    public final void logLiveRoomPageEndAndPageAttachStart() {
        logDebug("logLiveRoomPageEndAndPageAttachStart");
        if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, "page_init");
            getUbcManager().flowStartSlot(this.launchFlow, "page_attach", null);
        }
    }

    public final void logLiveRoomPageResume() {
        logDebug("logLiveRoomPageResume");
        if (!this.hasLoggedResume && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_TO_RESUME);
            this.hasLoggedResume = true;
        }
    }

    public final void logLiveRoomStartPage() {
        logDebug("logLiveRoomStartPage");
        if (!this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, "page_init", null);
            this.hasLoggedInit = true;
        }
    }

    public final void logMixShellOnSelect() {
        logDebug("logMixShellOnSelect");
        if (this.isDebug) {
            pageSelectStartTime = System.currentTimeMillis();
        }
        if (!this.hasLoggedSelectMixShell && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_BIND_TO_NOTIFY_SELECT_MIX_SHELL);
            this.hasLoggedSelectMixShell = true;
        }
    }

    public final void logPageEnterLiveParseEnd() {
        logDebug("logPageEnterLiveParseEnd");
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE);
        }
    }

    public final void logPageEnterLiveParseStart() {
        logDebug("logPageEnterLiveParseStart");
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_ENTER_LIVE_REQ_PARSE, null);
        }
    }

    public final void logPageEnterLiveRoomReqNetStart() {
        logDebug("logPageEnterLiveRoomReqNetStart");
        if (this.hasLoggedSelect && getUbcManager() != null && this.launchFlow != null) {
            if (this.isDebug) {
                pageEnterStartTime = System.currentTimeMillis();
            }
            this.hasSendEnterRequest = true;
            getUbcManager().flowStartSlot(this.launchFlow, "page_enter_live_req", null);
        }
    }

    public final void logPageOnCreateEnd() {
        if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            logDebug("logPageOnCreateEnd");
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_TIME);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_END_TO_LIST_ON_CREATE_START, null);
        }
    }

    public final void logPageOnCreateStart() {
        logDebug("logPageOnCreateStart");
        if (this.hasLoggedInit && getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, PAGE_SLOT_PAGE_ATTACH_END_TO_PAGE_ON_CREATE_START);
            getUbcManager().flowStartSlot(this.launchFlow, PAGE_SLOT_PAGE_CREATE_TIME, null);
        }
    }

    public final void logPageSelectedEnterFetchEnd() {
        String str;
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

    public final void logPageSelectedEnterFetchStart() {
        String str;
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

    private final void logLiveRoomDrawUIFinish() {
        String str;
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

    private final void printFlowEachSlotInfo() {
        HashMap<String, Slot> hashMap;
        try {
            Flow flow = this.launchFlow;
            HashMap<String, Slot> hashMap2 = null;
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
                for (Map.Entry<String, Slot> entry : hashMap2.entrySet()) {
                    Slot value = entry.getValue();
                    StringBuilder sb = new StringBuilder();
                    sb.append("阶段耗时 ");
                    sb.append(entry.getKey());
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

    public final void logLiveRoomPageEndBindStartLayout() {
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

    public final void logLiveRoomPageEndLayoutDrawComponent() {
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

    public static /* synthetic */ void updateStartPageInfo$default(MediaLivePluginLogger mediaLivePluginLogger, String str, String str2, boolean z, boolean z2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        mediaLivePluginLogger.updateStartPageInfo(str, str2, z, z2, str3);
    }

    public static /* synthetic */ void updateStartPageInfoIntentRoomInfo$default(MediaLivePluginLogger mediaLivePluginLogger, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        mediaLivePluginLogger.updateStartPageInfoIntentRoomInfo(str, str2, z, str3);
    }

    public final void createSelectLaunchInfo(boolean z, String str, String str2, boolean z2, boolean z3, String str3, String str4) {
        long j;
        if (!z) {
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
            updateStartPageInfo$default(this, str, str2, z2, z3, null, 16, null);
            updateStartPageInfoIntentRoomInfo(str3, str4, !z, str);
        }
    }

    public final void endSlot(final String str, String str2) {
        logDebug("endSlot slotName: " + str);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$endSlot$1
                @Override // java.lang.Runnable
                public final void run() {
                    UBCManager ubcManager;
                    Flow flow;
                    UBCManager ubcManager2;
                    Flow flow2;
                    ubcManager = MediaLivePluginLogger.this.getUbcManager();
                    if (ubcManager == null) {
                        return;
                    }
                    flow = MediaLivePluginLogger.this.launchFlow;
                    if (flow == null) {
                        return;
                    }
                    ubcManager2 = MediaLivePluginLogger.this.getUbcManager();
                    flow2 = MediaLivePluginLogger.this.launchFlow;
                    ubcManager2.flowEndSlot(flow2, str);
                }
            });
        } else if (getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowEndSlot(this.launchFlow, str);
        }
    }

    public final void startSlot(final String str, String str2) {
        logDebug("endSlot slotName: " + str);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.ubc.MediaLivePluginLogger$startSlot$1
                @Override // java.lang.Runnable
                public final void run() {
                    UBCManager ubcManager;
                    Flow flow;
                    UBCManager ubcManager2;
                    Flow flow2;
                    ubcManager = MediaLivePluginLogger.this.getUbcManager();
                    if (ubcManager == null) {
                        return;
                    }
                    flow = MediaLivePluginLogger.this.launchFlow;
                    if (flow == null) {
                        return;
                    }
                    ubcManager2 = MediaLivePluginLogger.this.getUbcManager();
                    flow2 = MediaLivePluginLogger.this.launchFlow;
                    ubcManager2.flowStartSlot(flow2, str, null);
                }
            });
        } else if (getUbcManager() != null && this.launchFlow != null) {
            getUbcManager().flowStartSlot(this.launchFlow, str, null);
        }
    }

    public final void logLiveRoomLeave(String str) {
        JSONObject jSONObject;
        String str2;
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

    @Override // com.baidu.searchbox.live.ubc.LiveComponentStatusHelper.ILiveComponentLoadFinish
    public void onFinished(String str) {
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

    public final void updateLaunchFlowObj(Object obj) {
        long j;
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

    public final void updateStartPageInfo(String str, String str2, boolean z, boolean z2, String str3) {
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
        String str4;
        IntentData schemeIntentData;
        IntentData.SchemeModel model;
        IntentData schemeIntentData2;
        Object obj5;
        Object obj6;
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
                int i3 = 0;
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
                if (z2) {
                    jSONObject2.put("bPluginStatus", str3);
                }
                Boolean bool2 = this.switchPreloadSplite;
                String str5 = "1";
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        obj6 = "1";
                    } else {
                        obj6 = "0";
                    }
                    jSONObject2.put("prohibit_preload_splite", obj6);
                }
                Boolean bool3 = this.switchBusinessPreloadSplite;
                if (bool3 != null) {
                    if (bool3.booleanValue()) {
                        obj5 = "1";
                    } else {
                        obj5 = "0";
                    }
                    jSONObject2.put("business_preload", obj5);
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
                    str5 = "0";
                }
                jSONObject2.put("sub_thread_notify_first_dip_switch", str5);
                ILivePageInfoInterface iLivePageInfoInterface = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
                if (iLivePageInfoInterface == null || (schemeIntentData2 = iLivePageInfoInterface.getSchemeIntentData()) == null || (str4 = schemeIntentData2.getId()) == null) {
                    str4 = "";
                }
                ILivePageInfoInterface iLivePageInfoInterface2 = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
                if (iLivePageInfoInterface2 != null && (schemeIntentData = iLivePageInfoInterface2.getSchemeIntentData()) != null && (model = schemeIntentData.getModel()) != null) {
                    i3 = model.getInterventions();
                }
                if (Intrinsics.areEqual(str4, str)) {
                    jSONObject2.put("ganyu_scene_qufen", i3);
                }
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

    public final void updateStartPageInfoIntentRoomInfo(String str, String str2, boolean z, String str3) {
        JSONObject jSONObject;
        int i;
        IntentData schemeIntentData;
        IntentData.SchemeModel model;
        IntentData schemeIntentData2;
        if (getUbcManager() != null && this.launchFlow != null) {
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
            ILivePageInfoInterface iLivePageInfoInterface = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
            String str4 = (iLivePageInfoInterface == null || (schemeIntentData2 = iLivePageInfoInterface.getSchemeIntentData()) == null || (str4 = schemeIntentData2.getId()) == null) ? "" : "";
            ILivePageInfoInterface iLivePageInfoInterface2 = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
            if (iLivePageInfoInterface2 != null && (schemeIntentData = iLivePageInfoInterface2.getSchemeIntentData()) != null && (model = schemeIntentData.getModel()) != null) {
                i = model.getInterventions();
            } else {
                i = 0;
            }
            if (Intrinsics.areEqual(str4, str3) && jSONObject != null) {
                jSONObject.put("ganyu_scene_qufen", i);
            }
        }
    }
}
