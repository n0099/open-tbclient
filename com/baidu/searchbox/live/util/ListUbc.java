package com.baidu.searchbox.live.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.LiveSessionService;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ListUbc {
    public static final String FROM = "liveshow";
    public static final String KEY_ID_REACH_LIVEROOM = "4081";
    public static final String UBC_FIRST_JUMP_REQ_END = "enter_live_real_req_end";
    public static final String UBC_FIRST_JUMP_REQ_START = "enter_live_real_req_start";
    public static final String UBC_TYPE_REACH = "reach";
    public static ListUbc instance;
    public UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public LiveSessionService liveSessionService = (LiveSessionService) ServiceManager.getService(LiveSessionService.Companion.getSERVICE_REFERENCE());
    public boolean hasRecordReqStart = false;
    public boolean hasRecordReqEnd = false;

    public static ListUbc getInstance() {
        if (instance == null) {
            synchronized (ListUbc.class) {
                if (instance == null) {
                    instance = new ListUbc();
                }
            }
        }
        return instance;
    }

    public void clearFlag() {
        this.hasRecordReqEnd = false;
        this.hasRecordReqStart = false;
    }

    public String getTopPluginVersion() {
        PluginInvokeService pluginMgrService = MiniPluginManager.INSTANCE.getPluginMgrService();
        if (pluginMgrService != null) {
            return String.valueOf(pluginMgrService.getPluginVersionCode("com.baidu.searchbox.livenps"));
        }
        return "0";
    }

    public void doEnterUbcByRequestEnter(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "enter_live");
            jSONObject.put("value", str2);
            jSONObject.put("source", str5);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str);
            jSONObject2.put("status", str3);
            jSONObject2.put("useCache", 0);
            jSONObject2.put("error", 0);
            if (str4 != null) {
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, str4);
            }
            jSONObject2.put("live_version", getTopPluginVersion());
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.ubc.onEvent("5153", jSONObject);
    }

    public void doEnterUbcByRequestEnterRealNet(String str, String str2, String str3, String str4, String str5) {
        boolean z;
        boolean z2;
        if ("enter_live_real_req_start".equals(str2) && !this.hasRecordReqStart) {
            z = true;
        } else {
            z = false;
        }
        if ("enter_live_real_req_end".equals(str2) && !this.hasRecordReqEnd) {
            z2 = true;
        } else {
            z2 = false;
        }
        LiveSessionService liveSessionService = this.liveSessionService;
        if (liveSessionService != null && liveSessionService.getSessionOrder() < 1 && (z || z2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                jSONObject.put("type", "enter_live");
                jSONObject.put("value", str2);
                jSONObject.put("source", str5);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MixYYFakeShell.ROOM_ID_YY, str);
                jSONObject2.put("status", str3);
                jSONObject2.put("useCache", 0);
                jSONObject2.put("error", 0);
                if (str4 != null) {
                    jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, str4);
                }
                if (this.liveSessionService != null) {
                    jSONObject2.put("zhibo_sessionid", this.liveSessionService.getSessionId());
                }
                jSONObject2.put("live_version", getTopPluginVersion());
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubc.onEvent("5153", jSONObject);
        }
        if ("enter_live_real_req_start".equals(str2)) {
            this.hasRecordReqStart = true;
        }
        if ("enter_live_real_req_end".equals(str2)) {
            this.hasRecordReqEnd = true;
        }
    }

    public void reportReachEvent(@NonNull String str, @NonNull String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (TextUtils.isEmpty(str5)) {
                str5 = StringUtil.NULL_STRING;
            }
            if (str5 != null && str5.trim().length() == 0) {
                str5 = "space";
            }
            jSONObject2.put("from", "liveshow");
            jSONObject2.put("page", str3);
            jSONObject2.put("source", str5);
            jSONObject2.putOpt("type", str2);
            jSONObject2.putOpt("value", str4);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.putOpt("ext", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.ubc.onEvent(str, jSONObject2);
    }
}
