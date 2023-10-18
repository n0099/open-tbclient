package com.baidu.searchbox.live.ubc;

import android.util.Log;
import androidx.transition.Transition;
import com.baidu.cyberplayer.sdk.task.UpgradeInfo;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.player.ubc.MediaLivePlayLogUtils;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 3:\u00013B\t\b\u0002¢\u0006\u0004\b2\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\nJ\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\nJ\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\nJ\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\nJ\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\nJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\nJ\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\nJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\nJ7\u0010#\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\"2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b#\u0010$J'\u0010&\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLivePlayLogger;", "", MixYYFakeShell.ROOM_ID_YY, "slot", "", "onlyAppend", "", "addSigleLineSlot", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "close", "()V", "key", UpgradeInfo.KEY_INT_FORCE_UPGRADE, "createLaunchInfo", "(Ljava/lang/String;Z)Z", "k", "", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "msg", "logDebug", "(Ljava/lang/String;)V", "logLiveRoomEndSlideParseAddItem", "logLiveRoomFirstFrame", "logLiveRoomPageCreate", "logLiveRoomPageEndEnterLiveReqStartParse", "logLiveRoomPageEndPageInitStartAttach", "logLiveRoomPageOnSelect", "logLiveRoomPageResume", "logLiveRoomPageStartEnterLiveReq", "logLiveRoomStartGetLiveTypeTime", "logLiveRoomStartPage", "logStartCreateMediaComponent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "popLaunchInfo", "(Ljava/lang/String;)Ljava/util/HashMap;", "v", "put", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "createIfUnexist", "startLaunchInfoSigleLine", "(Ljava/lang/String;Ljava/lang/String;Z)V", "info", "updateLaunchInfo", "(Ljava/lang/Object;)V", "isDebug", "Z", "roomId", "Ljava/lang/String;", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MediaLivePlayLogger {
    public static final String KEY_CAN_PRE_PLAY = "canPrePlay";
    public static final String K_ITEM_POS = "item_pos";
    public static final String MEDIA_LIVE_PLUGIN_TAG = "MEDIA_LIVE_PLAYER";
    public static final String PAGE_SLOT_BIND_MEDIA_COMPONENT = "bind_media_component";
    public static final String PAGE_SLOT_CREATE = "page_create";
    public static final String PAGE_SLOT_CREATE_MEDIA_COMPONENT = "create_media_component";
    public static final String PAGE_SLOT_DISPATCH_ENTER_ACTION = "dispatch_enter";
    public static final String PAGE_SLOT_FIRST_FRAME = "page_first_frame";
    public static final String PAGE_SLOT_GET_LIVE_TYPE_TIME = "get_live_type_time";
    public static final String PAGE_SLOT_PAGE_ATTACH = "page_attach";
    public static final String PAGE_SLOT_PAGE_ENTER_LIVE_REQ = "page_enter_live_req";
    public static final String PAGE_SLOT_PAGE_INIT = "page_init";
    public static final String PAGE_SLOT_PAGE_SELECT = "page_select";
    public static final String PAGE_SLOT_PAGE_SEND_ENTER_REQ = "page_send_enter_req";
    public static final String PAGE_SLOT_RESUME = "page_resume";
    public static final String SLOT_PLUGIN1_ATTA_P2 = "p1_atta_p2";
    public static final String SLOT_PLUGIN1_PLAY = "p1_toplay";
    public final boolean isDebug;
    public String roomId;
    public static final Companion Companion = new Companion(null);
    public static final Lazy instance$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MediaLivePlayLogger>() { // from class: com.baidu.searchbox.live.ubc.MediaLivePlayLogger$Companion$instance$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MediaLivePlayLogger invoke() {
            return new MediaLivePlayLogger(null);
        }
    });

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u001d\u0010\u0019\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/ubc/MediaLivePlayLogger$Companion;", "", "KEY_CAN_PRE_PLAY", "Ljava/lang/String;", "K_ITEM_POS", "MEDIA_LIVE_PLUGIN_TAG", "PAGE_SLOT_BIND_MEDIA_COMPONENT", "PAGE_SLOT_CREATE", "PAGE_SLOT_CREATE_MEDIA_COMPONENT", "PAGE_SLOT_DISPATCH_ENTER_ACTION", "PAGE_SLOT_FIRST_FRAME", "PAGE_SLOT_GET_LIVE_TYPE_TIME", "PAGE_SLOT_PAGE_ATTACH", "PAGE_SLOT_PAGE_ENTER_LIVE_REQ", "PAGE_SLOT_PAGE_INIT", "PAGE_SLOT_PAGE_SELECT", "PAGE_SLOT_PAGE_SEND_ENTER_REQ", "PAGE_SLOT_RESUME", "SLOT_PLUGIN1_ATTA_P2", "SLOT_PLUGIN1_PLAY", "Lcom/baidu/searchbox/live/ubc/MediaLivePlayLogger;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/baidu/searchbox/live/ubc/MediaLivePlayLogger;", Transition.MATCH_INSTANCE_STR, "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/baidu/searchbox/live/ubc/MediaLivePlayLogger;"))};

        public final MediaLivePlayLogger getInstance() {
            Lazy lazy = MediaLivePlayLogger.instance$delegate;
            Companion companion = MediaLivePlayLogger.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (MediaLivePlayLogger) lazy.getValue();
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MediaLivePlayLogger() {
        boolean z;
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            z = appInfoService.isDebug();
        } else {
            z = false;
        }
        this.isDebug = z;
    }

    public final void close() {
        MediaLivePlayLogUtils.endFlow$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, null, 2, null);
    }

    public final void logLiveRoomEndSlideParseAddItem() {
        if (this.isDebug) {
            logDebug("logLiveRoomEndSlideParseAddItem");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, PAGE_SLOT_DISPATCH_ENTER_ACTION, null, 4, null);
    }

    public final void logLiveRoomFirstFrame() {
        if (this.isDebug) {
            logDebug("logLiveRoomFirstFrame");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, PAGE_SLOT_FIRST_FRAME, null, 4, null);
    }

    public final void logLiveRoomPageCreate() {
        if (this.isDebug) {
            logDebug(PAGE_SLOT_CREATE);
        }
        MediaLivePlayLogUtils.INSTANCE.startSigleLineSlot(this.roomId, PAGE_SLOT_CREATE, Boolean.TRUE);
        MediaLivePlayLogUtils.INSTANCE.setFirstJump(this.roomId, true);
    }

    public final void logLiveRoomPageEndEnterLiveReqStartParse() {
        if (this.isDebug) {
            logDebug("logLiveRoomPageEndEnterLiveReqStartParse");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, "page_enter_live_req", null, 4, null);
    }

    public final void logLiveRoomPageEndPageInitStartAttach() {
        if (this.isDebug) {
            logDebug("page_attach");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, "page_attach", null, 4, null);
    }

    public final void logLiveRoomPageOnSelect() {
        if (this.isDebug) {
            logDebug("logLiveRoomPageOnSelect");
        }
    }

    public final void logLiveRoomPageResume() {
        if (this.isDebug) {
            logDebug(PAGE_SLOT_RESUME);
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, PAGE_SLOT_RESUME, null, 4, null);
    }

    public final void logLiveRoomPageStartEnterLiveReq() {
        if (this.isDebug) {
            logDebug("logLiveRoomPageStartEnterLiveReq");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, PAGE_SLOT_PAGE_SEND_ENTER_REQ, null, 4, null);
    }

    public final void logLiveRoomStartGetLiveTypeTime() {
        if (this.isDebug) {
            logDebug("logLiveRoomStartGetLiveTypeTime");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, "get_live_type_time", null, 4, null);
    }

    public final void logLiveRoomStartPage() {
        if (this.isDebug) {
            logDebug("logLiveRoomStartPage");
        }
        MediaLivePlayLogUtils.INSTANCE.startSigleLineSlot(this.roomId, "page_init", Boolean.TRUE);
    }

    public final void logStartCreateMediaComponent() {
        if (this.isDebug) {
            logDebug("create_media_component");
        }
        MediaLivePlayLogUtils.startSigleLineSlot$default(MediaLivePlayLogUtils.INSTANCE, this.roomId, "create_media_component", null, 4, null);
    }

    public /* synthetic */ MediaLivePlayLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void logDebug(String str) {
        if (this.isDebug) {
            Log.d(MEDIA_LIVE_PLUGIN_TAG, str);
        }
    }

    public final HashMap<String, Object> popLaunchInfo(String str) {
        if (this.isDebug) {
            logDebug("popLaunchInfo");
        }
        if (str == null) {
            str = this.roomId;
        }
        this.roomId = str;
        return MediaLivePlayLogUtils.INSTANCE.popLaunchInfo(str);
    }

    public final void updateLaunchInfo(Object obj) {
        MediaLivePlayLogUtils mediaLivePlayLogUtils = MediaLivePlayLogUtils.INSTANCE;
        if (!(obj instanceof HashMap)) {
            obj = null;
        }
        mediaLivePlayLogUtils.updateFlow((HashMap) obj);
        this.roomId = MediaLivePlayLogUtils.INSTANCE.getRoomId();
    }

    public static /* synthetic */ void addSigleLineSlot$default(MediaLivePlayLogger mediaLivePlayLogger, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = Boolean.TRUE;
        }
        mediaLivePlayLogger.addSigleLineSlot(str, str2, bool);
    }

    public static /* synthetic */ void startLaunchInfoSigleLine$default(MediaLivePlayLogger mediaLivePlayLogger, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        mediaLivePlayLogger.startLaunchInfoSigleLine(str, str2, z);
    }

    public static /* synthetic */ boolean createLaunchInfo$default(MediaLivePlayLogger mediaLivePlayLogger, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return mediaLivePlayLogger.createLaunchInfo(str, z);
    }

    public final void addSigleLineSlot(String str, String str2, Boolean bool) {
        String str3;
        if (this.isDebug) {
            logDebug("addSigleLineSlot " + str + WebvttCueParser.CHAR_SPACE + str2);
        }
        if (str != null) {
            str3 = str;
        } else {
            str3 = this.roomId;
        }
        this.roomId = str3;
        MediaLivePlayLogUtils.INSTANCE.startSigleLineSlot(str, str2, bool);
    }

    public final void put(String str, String str2, Object obj) {
        if (str == null) {
            str = this.roomId;
        }
        this.roomId = str;
        MediaLivePlayLogUtils.INSTANCE.put(str, str2, obj);
    }

    public final void startLaunchInfoSigleLine(String str, String str2, boolean z) {
        String str3;
        if (str != null) {
            str3 = str;
        } else {
            str3 = this.roomId;
        }
        this.roomId = str3;
        logDebug("staSigLin " + str + ": " + str2);
        MediaLivePlayLogUtils.INSTANCE.startSigleLineSlot(this.roomId, str2, Boolean.valueOf(z));
    }

    public final boolean createLaunchInfo(String str, boolean z) {
        this.roomId = str;
        return MediaLivePlayLogUtils.INSTANCE.createLaunchInfo(str, z);
    }

    public final Object get(String str, String str2) {
        if (str == null) {
            str = this.roomId;
        }
        this.roomId = str;
        return MediaLivePlayLogUtils.INSTANCE.get(str, str2);
    }
}
