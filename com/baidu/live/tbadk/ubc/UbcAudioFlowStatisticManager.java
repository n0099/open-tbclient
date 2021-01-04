package com.baidu.live.tbadk.ubc;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UbcAudioFlowStatisticManager {
    public static volatile UbcAudioFlowStatisticManager mInstance = new UbcAudioFlowStatisticManager();
    private String mEntry;
    private HashMap<String, FlowData> mFlowInstanceMap = new HashMap<>();
    private String mLiveId;
    private String mRoomId;
    private IUbcManager mUbcManager;

    public static UbcAudioFlowStatisticManager getInstance() {
        return mInstance;
    }

    private UbcAudioFlowStatisticManager() {
    }

    public void setUbcManager(IUbcManager iUbcManager) {
        this.mUbcManager = iUbcManager;
    }

    public void updateLiveRoom(String str, String str2, String str3) {
        clear();
        this.mLiveId = str;
        this.mRoomId = str2;
        this.mEntry = str3;
    }

    private void clear() {
        this.mLiveId = null;
        this.mEntry = null;
    }

    private String genFlowKey(UbcStatisticItem ubcStatisticItem) {
        return ubcStatisticItem != null ? ubcStatisticItem.getId() : "";
    }

    public void beginFlow(UbcStatisticItem ubcStatisticItem) {
        if (ubcStatisticItem != null && !TextUtils.isEmpty(ubcStatisticItem.getId()) && this.mUbcManager != null) {
            JSONObject genFlowContent = (TextUtils.isEmpty(this.mLiveId) || "0".equals(this.mLiveId)) ? null : genFlowContent(ubcStatisticItem);
            String genFlowKey = genFlowKey(ubcStatisticItem);
            if (this.mFlowInstanceMap.get(genFlowKey) != null) {
                this.mFlowInstanceMap.remove(genFlowKey);
            }
            Object flowBegin = this.mUbcManager.flowBegin(ubcStatisticItem.getId(), genFlowContent);
            if (flowBegin != null) {
                FlowData flowData = new FlowData();
                flowData.item = ubcStatisticItem;
                flowData.flow = flowBegin;
                flowData.formattedValue = genFlowContent;
                flowData.isStarted = true;
                this.mFlowInstanceMap.put(genFlowKey(ubcStatisticItem), flowData);
            }
        }
    }

    public void doSlotStart(UbcStatisticItem ubcStatisticItem, String str, JSONObject jSONObject) {
        if (ubcStatisticItem != null) {
            FlowData flowData = this.mFlowInstanceMap.get(genFlowKey(ubcStatisticItem));
            if (flowData != null && this.mUbcManager != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.mUbcManager.flowStartSlot(flowData.flow, str, jSONObject);
            }
        }
    }

    public void doSlotEnd(UbcStatisticItem ubcStatisticItem, String str) {
        if (ubcStatisticItem != null) {
            FlowData flowData = this.mFlowInstanceMap.get(genFlowKey(ubcStatisticItem));
            if (flowData != null && this.mUbcManager != null) {
                this.mUbcManager.flowEndSlot(flowData.flow, str);
            }
        }
    }

    public void endFlow(UbcStatisticItem ubcStatisticItem) {
        String genFlowKey = genFlowKey(ubcStatisticItem);
        FlowData flowData = this.mFlowInstanceMap.get(genFlowKey);
        if (flowData != null && this.mUbcManager != null) {
            if (flowData.formattedValue == null) {
                flowData.formattedValue = genFlowContent(flowData.item);
            }
            this.mUbcManager.flowSetValueWithDuration(flowData.flow, flowData.formattedValue);
            this.mUbcManager.flowEnd(flowData.flow);
            flowData.isStarted = false;
            this.mFlowInstanceMap.remove(genFlowKey);
        }
    }

    private JSONObject genFlowContent(UbcStatisticItem ubcStatisticItem) {
        return genCommonContent(ubcStatisticItem, true);
    }

    private JSONObject genCommonContent(UbcStatisticItem ubcStatisticItem, boolean z) {
        JSONObject contentExt;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("source", TbConfig.getSubappType());
            jSONObject.put("type", ubcStatisticItem.getContentType());
            jSONObject.put("value", ubcStatisticItem.getContentValue());
            jSONObject.put("page", ubcStatisticItem.getContentPage());
            try {
                if (ubcStatisticItem.getContentExt() == null) {
                    contentExt = new JSONObject();
                } else {
                    contentExt = ubcStatisticItem.getContentExt();
                }
                if (z) {
                    if (!contentExt.has("live_id") && !TextUtils.isEmpty(this.mLiveId) && !"0".equals(this.mLiveId)) {
                        contentExt.put("live_id", this.mLiveId);
                    }
                    if (!contentExt.has("room_id")) {
                        contentExt.put("room_id", this.mRoomId);
                    }
                }
                if (ubcStatisticItem.getLoc() != null) {
                    try {
                        contentExt.put("loc", ubcStatisticItem.getLoc());
                        contentExt.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, ubcStatisticItem.getSubPage());
                        contentExt.put("status", ubcStatisticItem.getStatus());
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
                if (!TextUtils.isEmpty(this.mEntry)) {
                    contentExt.put("entry", this.mEntry);
                }
                if (!contentExt.has(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK)) {
                    contentExt.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
                }
                String baiduSid = ExtraParamsManager.getBaiduSid();
                if (!TextUtils.isEmpty(baiduSid)) {
                    contentExt.put(UbcStatConstant.KEY_CONTENT_EXT_SID, baiduSid);
                }
                jSONObject.put("ext", contentExt);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        } catch (JSONException e3) {
            BdLog.e(e3);
        }
        return jSONObject;
    }

    /* loaded from: classes11.dex */
    private static class FlowData {
        public Object flow;
        public JSONObject formattedValue;
        public boolean isStarted;
        public UbcStatisticItem item;

        private FlowData() {
        }
    }
}
