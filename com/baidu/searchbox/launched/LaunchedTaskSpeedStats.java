package com.baidu.searchbox.launched;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchedTaskSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
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
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canStats;
    public long mEndTimeStamp;
    public long mStartTimeStamp;
    public String mUbcFrom;
    public String mUbcPage;
    public String mUbcType;
    public String mUbcValue;
    public Map<String, SpeedStatisticsNode> nodesMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(970388809, "Lcom/baidu/searchbox/launched/LaunchedTaskSpeedStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(970388809, "Lcom/baidu/searchbox/launched/LaunchedTaskSpeedStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public LaunchedTaskSpeedStats() {
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
        this.mStartTimeStamp = 0L;
        this.mEndTimeStamp = 0L;
        this.nodesMap = new HashMap();
    }

    private RuleNode getFeedReadyRuleNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new RuleNode(KEY_FEED_READY) : (RuleNode) invokeV.objValue;
    }

    private RuleNode getHomeResumeRuleNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new RuleNode(KEY_HOME_VIEW_RESUME) : (RuleNode) invokeV.objValue;
    }

    public static LaunchedTaskSpeedStats getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mInstance == null) {
                synchronized (LaunchedTaskSpeedStats.class) {
                    if (mInstance == null) {
                        mInstance = new LaunchedTaskSpeedStats();
                    }
                }
            }
            return mInstance;
        }
        return (LaunchedTaskSpeedStats) invokeV.objValue;
    }

    private JSONObject getNodePart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }

    private JSONObject getSpeedNodeJson(RuleNode ruleNode) {
        InterceptResult invokeL;
        SpeedStatisticsNode speedStatisticsNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, ruleNode)) == null) {
            if (TextUtils.isEmpty(ruleNode.getName()) || (speedStatisticsNode = this.nodesMap.get(ruleNode.getName())) == null) {
                return null;
            }
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
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject getSpeedNodeParts(List<RuleNode> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
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
        return (JSONObject) invokeL.objValue;
    }

    private RuleNode getStatisticsRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            RuleNode ruleNode = new RuleNode("stage");
            ArrayList arrayList = new ArrayList();
            arrayList.add(getUIReadyRuleNode());
            arrayList.add(getHomeResumeRuleNode());
            arrayList.add(getFeedReadyRuleNode());
            ruleNode.setChildParts(arrayList);
            return ruleNode;
        }
        return (RuleNode) invokeV.objValue;
    }

    private RuleNode getUIReadyRuleNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            RuleNode ruleNode = new RuleNode(KEY_UI_READY);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RuleNode(KEY_DELAY_TASK_MANAGER));
            ruleNode.setChildParts(arrayList);
            return ruleNode;
        }
        return (RuleNode) invokeV.objValue;
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.canStats = false;
            this.mUbcFrom = null;
            this.mUbcPage = null;
            this.mUbcType = null;
            this.mUbcValue = null;
            this.nodesMap.clear();
        }
    }

    public void endStatistics() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.canStats) {
            this.mEndTimeStamp = System.currentTimeMillis();
        }
    }

    public void setStatsSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.canStats = z;
        }
    }

    public void setUbcFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mUbcFrom = str;
        }
    }

    public void setUbcPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mUbcPage = str;
        }
    }

    public void setUbcType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mUbcType = str;
        }
    }

    public void setUbcValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mUbcValue = str;
        }
    }

    public void startStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.canStats = true;
            this.mStartTimeStamp = System.currentTimeMillis();
        }
    }

    public void upload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (DEBUG) {
                Log.w(TAG, "endStatistics canStats:" + this.canStats);
            }
            if (this.canStats) {
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
    }
}
