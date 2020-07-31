package com.baidu.live.tbadk.ubc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.framework.task.MessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.sapi2.SapiContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UbcStatisticManager {
    private static final long FLOW_LOOP_DURATION = 60000;
    public static volatile UbcStatisticManager mInstance = new UbcStatisticManager();
    private String mEntry;
    private String mLiveId;
    private String mRoomId;
    private IUbcManager mUbcManager;
    private String mVid;
    private HashMap<String, FlowData> mFlowInstanceMap = new HashMap<>();
    private HashMap<String, List<SlotData>> mSlotMap = new HashMap<>();
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

    public void updateLiveRoom(String str, String str2, String str3, String str4) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.mVid = str3;
        this.mEntry = str4;
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
        if (z) {
            pauseAllLiveFlowLoop();
        } else {
            resumeAllLiveFlowLoop();
        }
    }

    public void logEvent(UbcStatisticItem ubcStatisticItem) {
        if (ubcStatisticItem != null && !TextUtils.isEmpty(ubcStatisticItem.getId()) && this.mUbcManager != null) {
            this.mUbcManager.onEvent(ubcStatisticItem.getId(), genEventContent(ubcStatisticItem));
        }
    }

    public void logSendRequest(UbcStatisticItem ubcStatisticItem) {
        logSendRequest(ubcStatisticItem, true, true);
    }

    public void logSendRequest(final UbcStatisticItem ubcStatisticItem, boolean z, boolean z2) {
        JSONObject contentExt;
        if (!BdUtilHelper.isMainThread()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.live.tbadk.ubc.UbcStatisticManager.2
                @Override // java.lang.Runnable
                public void run() {
                    UbcStatisticManager.this.logSendRequest(ubcStatisticItem);
                }
            });
        } else if (ubcStatisticItem != null && !TextUtils.isEmpty(ubcStatisticItem.getId()) && this.mUbcManager != null) {
            JSONObject genStatisticContent = genStatisticContent(ubcStatisticItem);
            try {
                if (ubcStatisticItem.getContentExt() == null) {
                    contentExt = new JSONObject();
                } else {
                    contentExt = ubcStatisticItem.getContentExt();
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject();
                    fillCommonParams(jSONObject);
                    contentExt.put("common", jSONObject);
                }
                if (z2) {
                    JSONObject jSONObject2 = new JSONObject();
                    fillLiveParams(jSONObject2, ubcStatisticItem);
                    contentExt.put(UbcStatConstant.KEY_CONTENT_ROOM, jSONObject2);
                }
                genStatisticContent.put("ext", contentExt);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            this.mUbcManager.onEvent(ubcStatisticItem.getId(), genStatisticContent);
        }
    }

    public void logSendResponse(UbcStatisticItem ubcStatisticItem, HttpResponsedMessage httpResponsedMessage, boolean z) {
        logSendResponse(ubcStatisticItem, httpResponsedMessage, z, true);
    }

    public void logSendResponse(final UbcStatisticItem ubcStatisticItem, final HttpResponsedMessage httpResponsedMessage, final boolean z, final boolean z2) {
        JSONObject contentExt;
        if (!BdUtilHelper.isMainThread()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.live.tbadk.ubc.UbcStatisticManager.3
                @Override // java.lang.Runnable
                public void run() {
                    UbcStatisticManager.this.logSendResponse(ubcStatisticItem, httpResponsedMessage, z, z2);
                }
            });
        } else if (ubcStatisticItem != null) {
            JSONObject genStatisticContent = genStatisticContent(ubcStatisticItem);
            try {
                if (ubcStatisticItem.getContentExt() == null) {
                    contentExt = new JSONObject();
                } else {
                    contentExt = ubcStatisticItem.getContentExt();
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject();
                    fillCommonParams(jSONObject);
                    contentExt.put("common", jSONObject);
                }
                if (z2) {
                    JSONObject jSONObject2 = new JSONObject();
                    fillLiveParams(jSONObject2, ubcStatisticItem);
                    contentExt.put(UbcStatConstant.KEY_CONTENT_ROOM, jSONObject2);
                }
                if (httpResponsedMessage != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    fillNetParams(httpResponsedMessage, jSONObject3);
                    contentExt.put("request", jSONObject3);
                }
                genStatisticContent.put("ext", contentExt);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            if (this.mUbcManager != null) {
                this.mUbcManager.onEvent(ubcStatisticItem.getId(), genStatisticContent);
            }
        }
    }

    public void debugStat(UbcDebugItem ubcDebugItem) {
        if (ubcDebugItem != null && !TextUtils.isEmpty(ubcDebugItem.statId) && !TextUtils.isEmpty(ubcDebugItem.statCode) && this.mUbcManager != null) {
            this.mUbcManager.onEvent(UbcStatConstant.DEBUG_EVENT_ID, genDebugContent(ubcDebugItem, null, "stat"));
        }
    }

    public void debugException(UbcDebugItem ubcDebugItem, String str) {
        if (ubcDebugItem != null && !TextUtils.isEmpty(str)) {
            if (ubcDebugItem.otherExt == null) {
                ubcDebugItem.otherExt = new JSONObject();
            }
            try {
                ubcDebugItem.otherExt.put("exc_id", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.mUbcManager != null) {
                this.mUbcManager.onEvent(UbcStatConstant.DEBUG_EVENT_ID, genDebugContent(ubcDebugItem, null, "exception"));
            }
        }
    }

    public void debugRequest(UbcDebugItem ubcDebugItem, HttpResponsedMessage httpResponsedMessage) {
        if (ubcDebugItem != null && httpResponsedMessage != null) {
            if (ubcDebugItem.otherExt == null) {
                ubcDebugItem.otherExt = new JSONObject();
            }
            if (this.mUbcManager != null) {
                this.mUbcManager.onEvent(UbcStatConstant.DEBUG_EVENT_ID, genDebugContent(ubcDebugItem, httpResponsedMessage, "request"));
            }
        }
    }

    private JSONObject genStatisticContent(UbcStatisticItem ubcStatisticItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", UbcStatConstant.KEY_STATISTIC_FROM);
            jSONObject.put("source", TbConfig.getSubappType());
            jSONObject.put("type", ubcStatisticItem.getContentType());
            jSONObject.put("value", ubcStatisticItem.getContentValue());
            jSONObject.put("page", ubcStatisticItem.getContentPage());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return jSONObject;
    }

    private void fillLiveParams(JSONObject jSONObject, UbcStatisticItem ubcStatisticItem) {
        if (!jSONObject.has("live_id") && !TextUtils.isEmpty(this.mLiveId)) {
            fillJson(jSONObject, "live_id", this.mLiveId);
        }
        if (!jSONObject.has("room_id")) {
            fillJson(jSONObject, "room_id", this.mRoomId);
        }
        if (!jSONObject.has("vid") && !TextUtils.isEmpty(this.mVid)) {
            fillJson(jSONObject, "vid", this.mVid);
        }
        if (!TextUtils.isEmpty(this.mEntry)) {
            fillJson(jSONObject, "entry", this.mEntry);
        }
        if (!jSONObject.has(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK)) {
            fillJson(jSONObject, UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
        }
        String baiduSid = ExtraParamsManager.getBaiduSid();
        if (!TextUtils.isEmpty(baiduSid)) {
            fillJson(jSONObject, UbcStatConstant.KEY_CONTENT_EXT_SID, baiduSid);
        }
        if (ubcStatisticItem != null && ubcStatisticItem.getLoc() != null) {
            try {
                jSONObject.put("loc", ubcStatisticItem.getLoc());
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, ubcStatisticItem.getSubPage());
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
    }

    private void fillCommonParams(JSONObject jSONObject) {
        fillJson(jSONObject, SapiContext.KEY_SDK_VERSION, TbConfig.SDK_VERSION);
        fillJson(jSONObject, "client_ip", SharedPrefHelper.getInstance().getString(SharedPrefConfig.KEY_SYNC_CLIENT_IP, ""));
        fillJson(jSONObject, "timestamp", "" + System.currentTimeMillis());
    }

    private void fillNetParams(HttpResponsedMessage httpResponsedMessage, JSONObject jSONObject) {
        if (httpResponsedMessage != null && jSONObject != null) {
            MessageTask findTask = MessageManager.getInstance().findTask(httpResponsedMessage.getCmd());
            if (findTask instanceof HttpMessageTask) {
                try {
                    URI uri = new URI(((HttpMessageTask) findTask).getUrl());
                    if (uri != null) {
                        fillJson(jSONObject, "path", uri.getPath());
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            if (httpResponsedMessage.getOrginalMessage() != null) {
                fillJson(jSONObject, "start_time", String.valueOf(httpResponsedMessage.getOrginalMessage().getStartTime()));
            }
            fillJson(jSONObject, "res_time", String.valueOf(httpResponsedMessage.getResponseTime()));
            fillJson(jSONObject, "http_sc", String.valueOf(httpResponsedMessage.getStatusCode()));
            fillJson(jSONObject, "err_code", String.valueOf(httpResponsedMessage.getError()));
            fillJson(jSONObject, "network_error", httpResponsedMessage.getException());
            fillJson(jSONObject, "err_msg", httpResponsedMessage.getErrorString());
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                fillJson(jSONObject, "logid", String.valueOf(((JsonHttpResponsedMessage) httpResponsedMessage).getLogId()));
            }
            fillJson(jSONObject, "client_ip", SharedPrefHelper.getInstance().getString(SharedPrefConfig.KEY_SYNC_CLIENT_IP, ""));
            if (!TextUtils.isEmpty(httpResponsedMessage.getRealHost())) {
                fillJson(jSONObject, "httpdns_ip", httpResponsedMessage.getRealHost());
            }
            fillJson(jSONObject, "net_type", String.valueOf(BdNetTypeUtil.netType()));
        }
    }

    private void fillJson(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && str != null && str2 != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
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
            JSONObject genFlowContent = (TextUtils.isEmpty(this.mLiveId) || "0".equals(this.mLiveId)) ? null : genFlowContent(ubcStatisticItem);
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
            flowData.isStarted = false;
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
                    entry.getValue().isStarted = false;
                }
            }
        }
        this.mHandler.removeCallbacks(this.mFlowLoopRunnable);
    }

    private void resumeAllLiveFlowLoop() {
        if (!this.mFlowInstanceMap.isEmpty() && this.mUbcManager != null) {
            for (Map.Entry<String, FlowData> entry : this.mFlowInstanceMap.entrySet()) {
                if (entry != null && entry.getValue() != null && entry.getValue().item != null && !entry.getValue().isStarted) {
                    if (entry.getValue().formattedValue == null) {
                        entry.getValue().formattedValue = genFlowContent(entry.getValue().item);
                    }
                    entry.getValue().flow = this.mUbcManager.flowBegin(entry.getValue().item.getId(), entry.getValue().formattedValue);
                    entry.getValue().isStarted = true;
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
        return genCommonContent(ubcStatisticItem, true);
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
                if (z) {
                    if (!contentExt.has("live_id") && !TextUtils.isEmpty(this.mLiveId) && !"0".equals(this.mLiveId)) {
                        contentExt.put("live_id", this.mLiveId);
                    }
                    if (!contentExt.has("room_id")) {
                        contentExt.put("room_id", this.mRoomId);
                    }
                    if (!contentExt.has("vid") && !TextUtils.isEmpty(this.mVid)) {
                        contentExt.put("vid", this.mVid);
                    }
                }
                if (ubcStatisticItem.getLoc() != null) {
                    try {
                        contentExt.put("loc", ubcStatisticItem.getLoc());
                        contentExt.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, ubcStatisticItem.getSubPage());
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

    private JSONObject genDebugContent(UbcDebugItem ubcDebugItem, HttpResponsedMessage httpResponsedMessage, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (ubcDebugItem != null) {
            try {
                jSONObject2.put("from", UbcStatConstant.DEBUG_VALUE_CONTENT_FROM);
                jSONObject2.put("source", TbConfig.getSubappType());
                jSONObject2.put("type", str);
                jSONObject2.put("value", ubcDebugItem.value);
                jSONObject2.put("page", ubcDebugItem.page);
                try {
                    if (ubcDebugItem.otherExt == null) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = ubcDebugItem.otherExt;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    fillCommonParams(jSONObject3);
                    jSONObject.put("common", jSONObject3);
                    JSONObject jSONObject4 = new JSONObject();
                    fillLiveParams(jSONObject4, null);
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_ROOM, jSONObject4);
                    fillNetParams(httpResponsedMessage, ubcDebugItem.otherExt);
                    jSONObject2.put("ext", jSONObject);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class FlowData {
        public Object flow;
        public JSONObject formattedValue;
        public boolean isStarted;
        public UbcStatisticItem item;

        private FlowData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SlotData {
        public String category;
        public JSONObject option;

        private SlotData() {
        }
    }
}
