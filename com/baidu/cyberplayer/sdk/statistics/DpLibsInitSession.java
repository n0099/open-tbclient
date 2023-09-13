package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DpLibsInitSession {
    public static final String TAG = "DpLibsInitSession";
    public ArrayList<DpStatDataList> mActions = new ArrayList<>();
    public DpStatDataList mCommonDataList;

    public DpLibsInitSession(Context context) {
        String networkStatisticsNoOperator = DpNetworkUtils.getNetworkStatisticsNoOperator(context);
        DpStatDataList dpStatDataList = new DpStatDataList(DpStatConstants.SESSION_TYPE_DP_INIT_COMMON);
        this.mCommonDataList = dpStatDataList;
        dpStatDataList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "timestamp", System.currentTimeMillis()));
        this.mCommonDataList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "CPU", Utils.getCpuType()));
        this.mCommonDataList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "network", networkStatisticsNoOperator));
    }

    private JSONObject toJson(JSONObject jSONObject) throws JSONException {
        this.mCommonDataList.toJson(jSONObject);
        JSONArray jSONArray = new JSONArray();
        int size = this.mActions.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject2 = new JSONObject();
            this.mActions.get(i).toJson(jSONObject2);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("data", jSONArray);
        return jSONObject;
    }

    public static void uploadSession(Context context, int i, HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            DpLibsInitSession dpLibsInitSession = new DpLibsInitSession(context);
            dpLibsInitSession.add(i, hashMap);
            dpLibsInitSession.upload();
            if (!hashMap.containsKey(CloudStabilityUBCUtils.KEY_ERROR_CODE) && hashMap.get("loadcode").equals("0")) {
                CyberLog.y(DpStatConstants.SERVER_TYPE_DUPLAYER_INIT, "Install Success");
            } else {
                CyberLog.y(DpStatConstants.SERVER_TYPE_DUPLAYER_INIT, dpLibsInitSession.getInitSessionForUBC());
            }
        }
    }

    public void add(int i, String str, String str2) {
        if (24323 == i) {
            this.mCommonDataList.add(new DpStatItem((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, str, str2));
            return;
        }
        DpStatItem dpStatItem = new DpStatItem(i, str, str2);
        int size = this.mActions.size();
        for (int i2 = 0; i2 < size; i2++) {
            DpStatDataList dpStatDataList = this.mActions.get(i2);
            if (dpStatDataList != null && dpStatDataList.type() == i) {
                dpStatDataList.add(dpStatItem);
                return;
            }
        }
        DpStatDataList dpStatDataList2 = new DpStatDataList(i);
        dpStatDataList2.add(dpStatItem);
        this.mActions.add(dpStatDataList2);
    }

    public void add(int i, HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                add(i, entry.getKey(), entry.getValue());
            }
        }
    }

    public void doStatistics(int i, String str, String str2, String str3, String str4) {
        add(i, "url", str);
        add(i, "so_name", str2);
        add(i, "status", str3);
        add(i, "detail", str4);
    }

    public String getInitSessionForUBC() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            DpInitKernelSession.getInstance().toJson(jSONObject);
            jSONObject.remove("abtest_sid");
            jSONObject.remove("app_name");
            jSONObject.remove("app_version");
            jSONObject.remove("cuid");
            jSONObject.remove("network");
            jSONObject.put(DpStatConstants.KEY_CORE_VERSION, CyberVersion.getCoreVersionInternal());
            toJson(jSONObject);
            jSONObject2.put("items", jSONObject);
            jSONObject3.put("ext", jSONObject2);
            jSONObject3.put("from", "cyber");
            jSONObject3.put("page", "vod");
            return jSONObject3.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            DpInitKernelSession.getInstance().toJson(jSONObject);
            jSONObject.put(DpStatConstants.KEY_CORE_VERSION, CyberVersion.getCoreVersionInternal());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            toJson(jSONObject2);
            jSONArray.put(jSONObject2);
            jSONObject.put("items", jSONArray);
            String jSONObject3 = jSONObject.toString();
            jSONObject.remove("cuid");
            CyberLog.i(TAG, "session=" + jSONObject.toString());
            return jSONObject3;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void upload() {
        DpSessionDatasUploader.getInstance().uploadLibInitSession(toJson(), "sailor_monitor");
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_GRAY_RELEASE_SOLE_UBCID, CyberPlayerManager.getAppID().equals("com.baidu.searchbox")) && Utils.isGrayRelease(CyberPlayerManager.getAppVerionName())) {
            UbcSessionUploader.getInstance().upload(getInitSessionForUBC(), "ubc", -1012);
            return;
        }
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_INIT_SESSION_UBC, true)) {
            UbcSessionUploader.getInstance().upload(getInitSessionForUBC(), "ubc", -1010);
        }
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_CYBER_DOWN_INIT_SESSION_UBCID, true) && CyberVersion.isLaterDownCyber()) {
            UbcSessionUploader.getInstance().upload(getInitSessionForUBC(), "ubc", -1012);
        }
    }
}
