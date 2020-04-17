package com.baidu.live.tbadk.ubc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcStatisticManager {
    private static final long FLOW_LOOP_DURATION = 60000;
    public static volatile UbcStatisticManager mInstance = new UbcStatisticManager();
    private String mEntry;
    private String mLiveId;
    private IUbcManager mUbcManager;
    private String mVid;
    private HashMap<String, FlowData> mFlowInstanceMap = new HashMap<>();
    private HashMap<String, List<SlotData>> mSlotMap = new HashMap<>();
    private boolean mIsBackGround = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mFlowLoopRunnable = new Runnable() { // from class: com.baidu.live.tbadk.ubc.UbcStatisticManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (!UbcStatisticManager.this.mFlowInstanceMap.isEmpty()) {
                for (Map.Entry entry : UbcStatisticManager.this.mFlowInstanceMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        FlowData flowData = (FlowData) entry.getValue();
                        if (UbcStatisticManager.this.mSlotMap.containsKey(entry.getKey())) {
                            for (SlotData slotData : (List) UbcStatisticManager.this.mSlotMap.get(entry.getKey())) {
                                UbcStatisticManager.this.doSlotEnd((String) entry.getKey(), slotData);
                            }
                        }
                        if (flowData.formattedValue == null) {
                            flowData.formattedValue = UbcStatisticManager.this.genFlowContent(flowData.item);
                        }
                        UbcStatisticManager.this.mUbcManager.flowSetValueWithDuration(flowData.flow, flowData.formattedValue);
                        UbcStatisticManager.this.mUbcManager.flowEnd(flowData.flow);
                        flowData.flow = UbcStatisticManager.this.mUbcManager.flowBegin(flowData.item.getId(), flowData.formattedValue);
                        if (UbcStatisticManager.this.mSlotMap.containsKey(entry.getKey())) {
                            for (SlotData slotData2 : (List) UbcStatisticManager.this.mSlotMap.get(entry.getKey())) {
                                UbcStatisticManager.this.doSlotStart((String) entry.getKey(), slotData2);
                            }
                        }
                    }
                }
            }
            UbcStatisticManager.this.mHandler.removeCallbacks(UbcStatisticManager.this.mFlowLoopRunnable);
            UbcStatisticManager.this.mHandler.postDelayed(UbcStatisticManager.this.mFlowLoopRunnable, UbcStatisticManager.FLOW_LOOP_DURATION);
        }
    };

    public static UbcStatisticManager getInstance() {
        return mInstance;
    }

    private UbcStatisticManager() {
    }

    public void setUbcManager(IUbcManager iUbcManager) {
        this.mUbcManager = iUbcManager;
    }

    public void updateLiveRoom(String str, String str2, String str3) {
        this.mLiveId = str;
        this.mVid = str2;
        this.mEntry = str3;
        this.mHandler.removeCallbacks(this.mFlowLoopRunnable);
        this.mHandler.postDelayed(this.mFlowLoopRunnable, FLOW_LOOP_DURATION);
    }

    public void clear() {
        this.mLiveId = null;
        this.mVid = null;
        this.mEntry = null;
        this.mHandler.removeCallbacks(this.mFlowLoopRunnable);
    }

    public void liveRoomActivityBackgroundSwitch(boolean z) {
        if (this.mIsBackGround != z) {
            this.mIsBackGround = z;
            if (this.mIsBackGround) {
                pauseAllLiveFlowLoop();
            } else {
                resumeAllLiveFlowLoop();
            }
        }
    }

    public void logEvent(UbcStatisticItem ubcStatisticItem) {
        if (ubcStatisticItem != null && !TextUtils.isEmpty(ubcStatisticItem.getId()) && this.mUbcManager != null) {
            this.mUbcManager.onEvent(ubcStatisticItem.getId(), genEventContent(ubcStatisticItem));
        }
    }

    public Object flowBegin(UbcStatisticItem ubcStatisticItem) {
        if (ubcStatisticItem == null || TextUtils.isEmpty(ubcStatisticItem.getId()) || this.mUbcManager == null) {
            return null;
        }
        return this.mUbcManager.flowBegin(ubcStatisticItem.getId(), genFlowContent(ubcStatisticItem));
    }

    public void flowEnd(Object obj, UbcStatisticItem ubcStatisticItem) {
        if (obj != null && this.mUbcManager != null) {
            this.mUbcManager.flowSetValueWithDuration(obj, genFlowContent(ubcStatisticItem));
            this.mUbcManager.flowEnd(obj);
        }
    }

    public void liveRoomFlowBegin(UbcStatisticItem ubcStatisticItem) {
        if (ubcStatisticItem != null && !TextUtils.isEmpty(ubcStatisticItem.getId()) && this.mUbcManager != null) {
            if (this.mFlowInstanceMap.containsKey(genFlowKey(ubcStatisticItem))) {
                endFlowLoop(ubcStatisticItem);
            }
            beginFlowLoop(ubcStatisticItem);
        }
    }

    public void liveRoomFlowEnd(UbcStatisticItem ubcStatisticItem) {
        if (!TextUtils.isEmpty(ubcStatisticItem.getId())) {
            endFlowLoop(ubcStatisticItem);
        }
    }

    private String genFlowKey(UbcStatisticItem ubcStatisticItem) {
        return ubcStatisticItem != null ? ubcStatisticItem.getId() : "";
    }

    private void beginFlowLoop(UbcStatisticItem ubcStatisticItem) {
        if (ubcStatisticItem != null && !TextUtils.isEmpty(ubcStatisticItem.getId()) && this.mUbcManager != null) {
            JSONObject genFlowContent = !TextUtils.isEmpty(this.mLiveId) ? genFlowContent(ubcStatisticItem) : null;
            Object flowBegin = this.mUbcManager.flowBegin(ubcStatisticItem.getId(), genFlowContent);
            if (flowBegin != null) {
                FlowData flowData = new FlowData();
                flowData.item = ubcStatisticItem;
                flowData.flow = flowBegin;
                flowData.formattedValue = genFlowContent;
                this.mFlowInstanceMap.put(genFlowKey(ubcStatisticItem), flowData);
            }
        }
    }

    private void endFlowLoop(UbcStatisticItem ubcStatisticItem) {
        List<SlotData> list;
        String genFlowKey = genFlowKey(ubcStatisticItem);
        FlowData flowData = this.mFlowInstanceMap.get(genFlowKey);
        if (flowData != null && this.mUbcManager != null) {
            if (!this.mSlotMap.containsKey(ubcStatisticItem.getId())) {
                list = null;
            } else {
                list = this.mSlotMap.get(ubcStatisticItem.getId());
            }
            if (list != null) {
                for (SlotData slotData : list) {
                    doSlotEnd(ubcStatisticItem.getId(), slotData);
                }
                list.clear();
            }
            if (flowData.formattedValue == null) {
                flowData.formattedValue = genFlowContent(flowData.item);
            }
            this.mUbcManager.flowSetValueWithDuration(flowData.flow, flowData.formattedValue);
            this.mUbcManager.flowEnd(flowData.flow);
            this.mFlowInstanceMap.remove(genFlowKey);
        }
    }

    public void flowStartSlot(String str, String str2, JSONObject jSONObject) {
        LinkedList linkedList;
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.mSlotMap.containsKey(str)) {
                linkedList = this.mSlotMap.get(str);
            } else {
                LinkedList linkedList2 = new LinkedList();
                this.mSlotMap.put(str, linkedList2);
                linkedList = linkedList2;
            }
            boolean z2 = false;
            Iterator it = linkedList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                SlotData slotData = (SlotData) it.next();
                if (slotData != null && slotData.category.equals(str2)) {
                    z = true;
                }
                z2 = z;
            }
            if (!z) {
                SlotData slotData2 = new SlotData();
                slotData2.category = str2;
                slotData2.option = jSONObject;
                linkedList.add(slotData2);
                doSlotStart(str, slotData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSlotStart(String str, SlotData slotData) {
        FlowData flowData;
        if (slotData != null && (flowData = this.mFlowInstanceMap.get(str)) != null && this.mUbcManager != null) {
            this.mUbcManager.flowStartSlot(flowData.flow, slotData.category, slotData.option);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSlotEnd(String str, SlotData slotData) {
        FlowData flowData;
        if (slotData != null && (flowData = this.mFlowInstanceMap.get(str)) != null && this.mUbcManager != null) {
            this.mUbcManager.flowEndSlot(flowData.flow, slotData.category);
        }
    }

    public void flowEndSlot(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.mSlotMap.containsKey(str)) {
            List<SlotData> list = this.mSlotMap.get(str);
            for (SlotData slotData : list) {
                if (slotData != null && slotData.category.equals(str2)) {
                    doSlotEnd(str, slotData);
                    list.remove(slotData);
                    return;
                }
            }
        }
    }

    private void endAllLiveFlowLoop() {
        pauseAllLiveFlowLoop();
        this.mFlowInstanceMap.clear();
    }

    private void pauseAllLiveFlowLoop() {
        if (!this.mFlowInstanceMap.isEmpty() && this.mUbcManager != null) {
            for (Map.Entry<String, FlowData> entry : this.mFlowInstanceMap.entrySet()) {
                if (entry != null && entry.getValue() != null) {
                    if (this.mSlotMap.containsKey(entry.getKey())) {
                        for (SlotData slotData : this.mSlotMap.get(entry.getKey())) {
                            doSlotEnd(entry.getKey(), slotData);
                        }
                    }
                    if (entry.getValue().formattedValue == null) {
                        entry.getValue().formattedValue = genFlowContent(entry.getValue().item);
                    }
                    this.mUbcManager.flowSetValueWithDuration(entry.getValue().flow, entry.getValue().formattedValue);
                    this.mUbcManager.flowEnd(entry.getValue().flow);
                }
            }
        }
        this.mHandler.removeCallbacks(this.mFlowLoopRunnable);
    }

    private void resumeAllLiveFlowLoop() {
        if (!this.mFlowInstanceMap.isEmpty() && this.mUbcManager != null) {
            for (Map.Entry<String, FlowData> entry : this.mFlowInstanceMap.entrySet()) {
                if (entry != null && entry.getValue() != null && entry.getValue().item != null) {
                    if (entry.getValue().formattedValue == null) {
                        entry.getValue().formattedValue = genFlowContent(entry.getValue().item);
                    }
                    entry.getValue().flow = this.mUbcManager.flowBegin(entry.getValue().item.getId(), entry.getValue().formattedValue);
                    if (this.mSlotMap.containsKey(entry.getKey())) {
                        for (SlotData slotData : this.mSlotMap.get(entry.getKey())) {
                            doSlotStart(entry.getKey(), slotData);
                        }
                    }
                }
            }
        }
        this.mHandler.removeCallbacks(this.mFlowLoopRunnable);
        this.mHandler.postDelayed(this.mFlowLoopRunnable, FLOW_LOOP_DURATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject genFlowContent(UbcStatisticItem ubcStatisticItem) {
        return genCommonContent(ubcStatisticItem, false);
    }

    private JSONObject genEventContent(UbcStatisticItem ubcStatisticItem) {
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
                if (z && jSONObject != null) {
                    if (!contentExt.has("live_id") && !TextUtils.isEmpty(this.mLiveId)) {
                        contentExt.put("live_id", this.mLiveId);
                    }
                    if (!contentExt.has("vid") && !TextUtils.isEmpty(this.mVid)) {
                        contentExt.put("vid", this.mVid);
                    }
                }
                if (!TextUtils.isEmpty(this.mEntry)) {
                    contentExt.put("entry", this.mEntry);
                }
                String baiduSid = ExtraParamsManager.getBaiduSid();
                if (!TextUtils.isEmpty(baiduSid)) {
                    contentExt.put(UbcStatConstant.KEY_CONTENT_EXT_SID, baiduSid);
                }
                jSONObject.put("ext", contentExt);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class FlowData {
        public Object flow;
        public JSONObject formattedValue;
        public UbcStatisticItem item;

        private FlowData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SlotData {
        public String category;
        public JSONObject option;

        private SlotData() {
        }
    }
}
