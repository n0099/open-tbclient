package com.baidu.searchbox.launched;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchedTaskSpeedStats {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_DELAY_TASK_MANAGER = "delayTask";
    public static final String KEY_FEED_READY = "feedReady";
    public static final String KEY_HOME_VIEW_RESUME = "homeResume";
    public static final String KEY_LAUNCH_DURATION = "duration";
    public static final String KEY_STAGE = "stage";
    public static final String KEY_START_TIME = "starttime";
    public static final String KEY_UI_READY = "uiReady";
    public static final String TAG = "LaunchedTaskSpeedStats";
    public static final String UBC_ID = "848";
    public static LaunchedTaskSpeedStats mInstance;
    public boolean canStats;
    public String mUbcFrom;
    public String mUbcPage;
    public String mUbcType;
    public String mUbcValue;
    public long mStartTimeStamp = 0;
    public long mEndTimeStamp = 0;
    public Map<String, SpeedStatisticsNode> nodesMap = new HashMap();

    private RuleNode getFeedReadyRuleNode() {
        return new RuleNode(KEY_FEED_READY);
    }

    private RuleNode getHomeResumeRuleNode() {
        return new RuleNode(KEY_HOME_VIEW_RESUME);
    }

    public static LaunchedTaskSpeedStats getInstance() {
        if (mInstance == null) {
            synchronized (LaunchedTaskSpeedStats.class) {
                if (mInstance == null) {
                    mInstance = new LaunchedTaskSpeedStats();
                }
            }
        }
        return mInstance;
    }

    private RuleNode getStatisticsRule() {
        RuleNode ruleNode = new RuleNode("stage");
        ArrayList arrayList = new ArrayList();
        arrayList.add(getUIReadyRuleNode());
        arrayList.add(getHomeResumeRuleNode());
        arrayList.add(getFeedReadyRuleNode());
        ruleNode.setChildParts(arrayList);
        return ruleNode;
    }

    private RuleNode getUIReadyRuleNode() {
        RuleNode ruleNode = new RuleNode(KEY_UI_READY);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RuleNode(KEY_DELAY_TASK_MANAGER));
        ruleNode.setChildParts(arrayList);
        return ruleNode;
    }

    private void reset() {
        this.canStats = false;
        this.mUbcFrom = null;
        this.mUbcPage = null;
        this.mUbcType = null;
        this.mUbcValue = null;
        this.nodesMap.clear();
    }

    public void endStatistics() {
        if (!this.canStats) {
            return;
        }
        this.mEndTimeStamp = System.currentTimeMillis();
    }

    public void startStatistics() {
        this.canStats = true;
        this.mStartTimeStamp = System.currentTimeMillis();
    }

    private JSONObject getNodePart() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", this.mEndTimeStamp - this.mStartTimeStamp);
            jSONObject.put(KEY_START_TIME, this.mStartTimeStamp);
            jSONObject.put("stage", getSpeedNodeParts(getStatisticsRule().getChildParts()));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, e.getMessage());
            }
        }
        return jSONObject;
    }

    private JSONObject getSpeedNodeJson(RuleNode ruleNode) {
        SpeedStatisticsNode speedStatisticsNode;
        if (!TextUtils.isEmpty(ruleNode.getName()) && (speedStatisticsNode = this.nodesMap.get(ruleNode.getName())) != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("begin", speedStatisticsNode.getBeginTimestamp());
                jSONObject.put("duration", speedStatisticsNode.getDuration());
                JSONObject speedNodeParts = getSpeedNodeParts(ruleNode.getChildParts());
                if (speedNodeParts != null) {
                    jSONObject.put("part", speedNodeParts);
                }
                return jSONObject;
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e(TAG, e.getMessage());
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    private JSONObject getSpeedNodeParts(List<RuleNode> list) {
        if (list != null && list.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (RuleNode ruleNode : list) {
                JSONObject speedNodeJson = getSpeedNodeJson(ruleNode);
                if (speedNodeJson != null) {
                    try {
                        jSONObject.put(ruleNode.getName(), speedNodeJson);
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.e(TAG, e.getMessage());
                        }
                    }
                }
            }
            return jSONObject;
        }
        return null;
    }

    public void setStatsSwitch(boolean z) {
        this.canStats = z;
    }

    public void setUbcFrom(String str) {
        this.mUbcFrom = str;
    }

    public void setUbcPage(String str) {
        this.mUbcPage = str;
    }

    public void setUbcType(String str) {
        this.mUbcType = str;
    }

    public void setUbcValue(String str) {
        this.mUbcValue = str;
    }

    public void upload() {
        if (DEBUG) {
            Log.w(TAG, "endStatistics canStats:" + this.canStats);
        }
        if (!this.canStats) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.mUbcType);
            jSONObject.put("value", this.mUbcValue);
            jSONObject.put("page", this.mUbcPage);
            jSONObject.put("from", this.mUbcFrom);
            jSONObject.put("ext", getNodePart());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.onEvent(UBC_ID, jSONObject);
        }
        if (DEBUG) {
            Log.e(TAG, "endStatistics ubc:" + jSONObject.toString());
        }
        reset();
    }
}
