package com.baidu.searchbox.live.player.ubc;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.service.ILivePageInfoInterface;
import com.baidu.searchbox.live.service.MixRequestServiceLocator;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\bJ\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\rJ#\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J=\u0010#\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u0015H\u0002¢\u0006\u0004\b#\u0010$J7\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010\u0017J'\u0010'\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(J7\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b*\u0010\u0017J\u001f\u0010,\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u0010!J\u001f\u0010/\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b/\u0010\rJ+\u00101\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b3\u0010\rJ\u001f\u00106\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J!\u00108\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b8\u0010\rJ5\u00109\u001a\u00020\u00012&\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0015¢\u0006\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010<R\u0016\u0010A\u001a\u00020@8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020@8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010<Rn\u0010E\u001aZ\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u00150\u0014j,\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0014j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u0015`\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR6\u0010I\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010FR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010<¨\u0006K"}, d2 = {"Lcom/baidu/searchbox/live/player/ubc/MediaLivePlayLogUtils;", "", "clearAll", "()V", "", "key", "", TTDownloadField.TT_FORCE, "createLaunchInfo", "(Ljava/lang/String;Z)Z", "roomId", "slot", "endFlow", "(Ljava/lang/String;Ljava/lang/String;)V", "flowEndSlot", "flowStartSlot", "k", "", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getFlowInfo", "(Ljava/lang/String;)Ljava/util/HashMap;", "getOrCreateFlowInfo", "getRoomId", "()Ljava/lang/String;", "isClosed", "(Ljava/lang/String;)Z", "isFirstJump", "isPlayStage", "msg", "logDebug", "(Ljava/lang/String;)V", "info", "onCreateFlowInfo", "(Ljava/lang/String;Ljava/util/HashMap;)V", "popLaunchInfo", "v", "put", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", MixYYFakeShell.ROOM_ID_YY, "remove", "isFirst", "setFirstJump", "(Ljava/lang/String;Z)V", "setPlayStage", "startPlayerSigleLine", "createIfUnexist", "startSigleLineSlot", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "startSigleSlot", "Lorg/json/JSONObject;", "ext", "toJson", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "updateClickFrom", "updateFlow", "(Ljava/util/HashMap;)V", "K_CLICK_FROM", "Ljava/lang/String;", "K_JUMP_TYPE", "K_PLAY_STAGE", "MEDIA_LIVE_PLUGIN_TAG", "", "V_JUMP_TYPE_FIRST", "I", "V_JUMP_TYPE_SCROLL", "clickFrom", "flowInfo", "Ljava/util/HashMap;", "isDebug", "Z", "launchInfo", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MediaLivePlayLogUtils {
    public static final MediaLivePlayLogUtils INSTANCE = new MediaLivePlayLogUtils();
    public static final String K_CLICK_FROM = "p_click_from";
    public static final String K_JUMP_TYPE = "p_jump_type";
    public static final String K_PLAY_STAGE = "is_play_state";
    public static final String MEDIA_LIVE_PLUGIN_TAG = "lp_playLogUtils";
    public static final int V_JUMP_TYPE_FIRST = 1;
    public static final int V_JUMP_TYPE_SCROLL = 2;
    public static String clickFrom;
    public static final HashMap<String, HashMap<String, Object>> flowInfo;
    public static final boolean isDebug;
    public static HashMap<String, Object> launchInfo;
    public static String roomId;

    static {
        boolean z;
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            z = appInfoService.isDebug();
        } else {
            z = false;
        }
        isDebug = z;
        flowInfo = new HashMap<>();
    }

    public final void clearAll() {
        if (isDebug) {
            logDebug("clear all");
        }
        flowInfo.clear();
    }

    public final String getRoomId() {
        return roomId;
    }

    public static /* synthetic */ boolean createLaunchInfo$default(MediaLivePlayLogUtils mediaLivePlayLogUtils, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return mediaLivePlayLogUtils.createLaunchInfo(str, z);
    }

    public static /* synthetic */ void endFlow$default(MediaLivePlayLogUtils mediaLivePlayLogUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        mediaLivePlayLogUtils.endFlow(str, str2);
    }

    private final void onCreateFlowInfo(String str, HashMap<String, Object> hashMap) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            launchInfo = hashMap;
        } else {
            flowInfo.put(str, hashMap);
        }
    }

    public final void endFlow(String str, String str2) {
        if (isDebug) {
            logDebug("closeFlow " + str + WebvttCueParser.CHAR_SPACE + str2);
        }
        FlowInfoHelper.endFlow(str, getFlowInfo(str), str2);
    }

    public final Object get(String str, String str2) {
        return FlowInfoHelper.get(getFlowInfo(str), str2);
    }

    public final void setFirstJump(String str, boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        put(str, K_JUMP_TYPE, Integer.valueOf(i));
    }

    public final void startSigleSlot(String str, String str2) {
        HashMap<String, Object> flowInfo2 = getFlowInfo(str);
        if (flowInfo2 != null) {
            FlowInfoHelper.startSingleSlot(flowInfo2, str2);
        }
    }

    public final void toJson(String str, JSONObject jSONObject) {
        if (isDebug) {
            logDebug("toJson " + str);
        }
        FlowInfoHelper.toJson(getFlowInfo(str), jSONObject);
    }

    public static /* synthetic */ void startSigleLineSlot$default(MediaLivePlayLogUtils mediaLivePlayLogUtils, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = Boolean.FALSE;
        }
        mediaLivePlayLogUtils.startSigleLineSlot(str, str2, bool);
    }

    private final void updateClickFrom(String str, String str2) {
        boolean z;
        if (clickFrom == null) {
            String str3 = (String) get(str, K_CLICK_FROM);
            clickFrom = str3;
            boolean z2 = false;
            if (str3 != null && str3.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    clickFrom = str2;
                    if (str2 != null) {
                        INSTANCE.put(str, K_CLICK_FROM, str2);
                    }
                }
            }
        }
    }

    public final boolean createLaunchInfo(String str, boolean z) {
        if (isDebug) {
            logDebug("createLaunchInfo " + str + " f: " + z);
        }
        roomId = str;
        boolean z2 = false;
        if (getFlowInfo(str) == null && z) {
            z2 = true;
            getOrCreateFlowInfo(str);
        }
        if (z2) {
            clickFrom = null;
        }
        return z2;
    }

    public final void flowEndSlot(String str, String str2) {
        HashMap<String, Object> flowInfo2 = getFlowInfo(str);
        if (Intrinsics.areEqual((Boolean) FlowInfoHelper.get(flowInfo2, K_PLAY_STAGE), Boolean.TRUE)) {
            logDebug("startSigleLineSlot witch play sate " + str2);
        }
        if (FlowInfoHelper.isFlowClosed(flowInfo2)) {
            logDebug("startPlayerSigleLine witch closed " + str2);
            return;
        }
        if (isDebug) {
            logDebug("flowEndSlot " + str2);
        }
        FlowInfoHelper.startSigleLineSlot(flowInfo2, str2, true);
    }

    public final void flowStartSlot(String str, String str2) {
        HashMap<String, Object> orCreateFlowInfo = getOrCreateFlowInfo(str);
        if (Intrinsics.areEqual((Boolean) FlowInfoHelper.get(orCreateFlowInfo, K_PLAY_STAGE), Boolean.TRUE)) {
            logDebug("startSigleLineSlot witch play sate " + str2);
        }
        if (FlowInfoHelper.isFlowClosed(orCreateFlowInfo)) {
            logDebug("startPlayerSigleLine witch closed " + str2);
            return;
        }
        if (isDebug) {
            logDebug("flowStartSlot " + str + WebvttCueParser.CHAR_SPACE + str2);
        }
        FlowInfoHelper.startSigleLineSlot(orCreateFlowInfo, str2, true);
    }

    public final void startPlayerSigleLine(String str, String str2) {
        if (isDebug) {
            logDebug("staSigLin " + str + ": " + str2);
        }
        HashMap<String, Object> orCreateFlowInfo = getOrCreateFlowInfo(str);
        if (orCreateFlowInfo != null) {
            if (FlowInfoHelper.isFlowClosed(orCreateFlowInfo)) {
                logDebug("startPlayerSigleLine witch closed " + str2);
                return;
            }
            if (isDebug) {
                logDebug("startPlayerSigleLine " + str + WebvttCueParser.CHAR_SPACE + str2);
            }
            FlowInfoHelper.startSigleLineSlot(orCreateFlowInfo, str2, true);
            updateClickFrom(str, str2);
        }
    }

    public final HashMap<String, Object> getFlowInfo(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return launchInfo;
        }
        HashMap<String, Object> hashMap = flowInfo.get(str);
        if (hashMap == null) {
            hashMap = launchInfo;
            launchInfo = null;
            if (hashMap != null) {
                if (isDebug) {
                    MediaLivePlayLogUtils mediaLivePlayLogUtils = INSTANCE;
                    mediaLivePlayLogUtils.logDebug("bind key " + str);
                }
                INSTANCE.onCreateFlowInfo(str, hashMap);
            }
        }
        return hashMap;
    }

    public final boolean isFirstJump(String str) {
        ILivePageInfoInterface iLivePageInfoInterface = (ILivePageInfoInterface) MixRequestServiceLocator.Companion.getGlobalService(ILivePageInfoInterface.class);
        boolean z = false;
        if (iLivePageInfoInterface != null && iLivePageInfoInterface.isInsertVideo()) {
            return false;
        }
        Integer num = (Integer) FlowInfoHelper.get(getFlowInfo(str), K_JUMP_TYPE);
        if (num != null && num.intValue() == 1) {
            z = true;
        }
        if (isDebug) {
            logDebug("isFirstJump " + z);
        }
        return z;
    }

    public final HashMap<String, Object> remove(String str) {
        boolean z;
        if (isDebug) {
            logDebug("remove " + str);
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            HashMap<String, Object> hashMap = launchInfo;
            launchInfo = null;
            return hashMap;
        }
        HashMap<String, Object> remove = flowInfo.remove(str);
        if (remove == null) {
            launchInfo = null;
            return remove;
        }
        return remove;
    }

    public final HashMap<String, Object> getOrCreateFlowInfo(String str) {
        HashMap<String, Object> flowInfo2 = getFlowInfo(str);
        if (flowInfo2 == null) {
            if (isDebug) {
                logDebug("create flow with unexist ...");
            }
            flowInfo2 = FlowInfoHelper.createFlow(str);
            if (flowInfo2 == null) {
                Intrinsics.throwNpe();
            }
            onCreateFlowInfo(str, flowInfo2);
        }
        return flowInfo2;
    }

    public final boolean isClosed(String str) {
        return FlowInfoHelper.isFlowClosed(getFlowInfo(str));
    }

    public final boolean isPlayStage(String str) {
        return Intrinsics.areEqual((Boolean) FlowInfoHelper.get(getFlowInfo(str), K_PLAY_STAGE), Boolean.TRUE);
    }

    public final void logDebug(String str) {
        if (isDebug) {
            Log.d(MEDIA_LIVE_PLUGIN_TAG, str);
        }
    }

    public final HashMap<String, Object> popLaunchInfo(String str) {
        if (isDebug) {
            logDebug("popLaunchInfo " + str);
        }
        return remove(str);
    }

    public final void setPlayStage(String str) {
        put(str, K_PLAY_STAGE, Boolean.TRUE);
    }

    public final void put(String str, String str2, Object obj) {
        HashMap<String, Object> flowInfo2 = getFlowInfo(str);
        if (FlowInfoHelper.isFlowClosed(flowInfo2)) {
            return;
        }
        if (isDebug) {
            logDebug("put " + str + WebvttCueParser.CHAR_SPACE + str2 + '=' + obj);
        }
        FlowInfoHelper.put(flowInfo2, str2, obj);
    }

    public final void startSigleLineSlot(String str, String str2, Boolean bool) {
        HashMap<String, Object> flowInfo2;
        if (isDebug) {
            logDebug("startSigleLineSlot " + str + WebvttCueParser.CHAR_SPACE + str2);
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            flowInfo2 = getOrCreateFlowInfo(str);
        } else {
            flowInfo2 = getFlowInfo(str);
        }
        if (flowInfo2 != null) {
            if (Intrinsics.areEqual((Boolean) FlowInfoHelper.get(flowInfo2, K_PLAY_STAGE), Boolean.TRUE)) {
                logDebug("startSigleLineSlot witch play sate " + str2);
            }
            if (FlowInfoHelper.isFlowClosed(flowInfo2)) {
                logDebug("startPlayerSigleLine witch closed " + str2);
                return;
            }
            FlowInfoHelper.startSigleLineSlot(flowInfo2, str2, true);
            updateClickFrom(str, str2);
        }
    }

    public final void updateFlow(HashMap<String, Object> hashMap) {
        String str;
        String str2;
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("last launchInfo ");
            HashMap<String, Object> hashMap2 = launchInfo;
            if (hashMap2 != null) {
                str = hashMap2.toString();
            } else {
                str = null;
            }
            sb.append(str);
            logDebug(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateLaunchInfo ");
            if (hashMap != null) {
                str2 = hashMap.toString();
            } else {
                str2 = null;
            }
            sb2.append(str2);
            logDebug(sb2.toString());
        }
        if (hashMap == null) {
            return;
        }
        Object obj = FlowInfoHelper.get(hashMap, FlowInfoHelper.KEY_ROOM_ID);
        if (obj != null && (obj instanceof String)) {
            roomId = (String) obj;
        }
        Object remove = FlowInfoHelper.remove(hashMap, FlowInfoHelper.KEY_LAST_SLOT);
        if (remove != null) {
            FlowInfoHelper.put(hashMap, FlowInfoHelper.KEY_LAST_LINK_SLOT_TAG, remove);
        }
        launchInfo = null;
        onCreateFlowInfo(roomId, hashMap);
        updateClickFrom(roomId, "updateFlow");
    }
}
