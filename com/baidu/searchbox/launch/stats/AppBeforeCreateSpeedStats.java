package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AppBeforeCreateSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_ATTACH = "appAttach";
    public static final String APP_RUNTIME_INIT = "appRuntimeInit";
    public static final String INSTALL_CONTENT_PROVIDER = "installContentProvider";
    public static final String MULTIDEX_INSTALL = "multidexInstall";
    public static final String NPS_INIT = "npsInit";
    public static final String TITAN_DETAILS = "titan";
    public static final String TITAN_INIT = "titanInit";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAiappsRuntimeEndTimeStamp;
    public long mAppAttachContextEndTimeStamp;
    public long mAppCreateStartTime;
    public long mAppRuntimeInitEndTimeStamp;
    public long mAttachBaseContextStartTimeStamp;
    public long mMultiDexinstallEndTimeStamp;
    public long mNpsInitEndTimeStamp;
    public long mTiTanInitEndTimeStamp;
    public Map mTitanDetailsMap;

    public AppBeforeCreateSpeedStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAttachBaseContextStartTimeStamp = -1L;
        this.mMultiDexinstallEndTimeStamp = -1L;
        this.mAppRuntimeInitEndTimeStamp = -1L;
        this.mAppAttachContextEndTimeStamp = -1L;
        this.mAiappsRuntimeEndTimeStamp = -1L;
        this.mNpsInitEndTimeStamp = -1L;
        this.mTiTanInitEndTimeStamp = -1L;
        this.mAppCreateStartTime = -1L;
        this.mTitanDetailsMap = null;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsMap(String str, Map<String, String> map) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) {
            super.addStatsMap(str, map);
            if (str.hashCode() == 110371084 && str.equals(TITAN_DETAILS)) {
                c = 0;
            } else {
                c = 65535;
            }
            if (c == 0) {
                this.mTitanDetailsMap = map;
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            addStatsTimeStamp(i, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            if (i != 2000) {
                switch (i) {
                    case 1002:
                        this.mAttachBaseContextStartTimeStamp = j;
                        return;
                    case 1003:
                        this.mMultiDexinstallEndTimeStamp = j;
                        return;
                    case 1004:
                        this.mAiappsRuntimeEndTimeStamp = j;
                        return;
                    default:
                        switch (i) {
                            case 1010:
                                this.mAppAttachContextEndTimeStamp = j;
                                return;
                            case 1011:
                                this.mNpsInitEndTimeStamp = j;
                                return;
                            case 1012:
                                this.mTiTanInitEndTimeStamp = j;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.mAppCreateStartTime = j;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAppCreateStartTime;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mAttachBaseContextStartTimeStamp = -1L;
            this.mMultiDexinstallEndTimeStamp = -1L;
            this.mAppRuntimeInitEndTimeStamp = -1L;
            this.mAppAttachContextEndTimeStamp = -1L;
            this.mAiappsRuntimeEndTimeStamp = -1L;
            this.mNpsInitEndTimeStamp = -1L;
            this.mNpsInitEndTimeStamp = -1L;
            this.mTitanDetailsMap = null;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return true;
            }
            long appLaunchStartTimeStamp = SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
            long j = this.mAppCreateStartTime;
            long j2 = j - appLaunchStartTimeStamp;
            long j3 = this.mAttachBaseContextStartTimeStamp;
            long j4 = j3 - appLaunchStartTimeStamp;
            long j5 = this.mMultiDexinstallEndTimeStamp;
            long j6 = j5 - j3;
            long j7 = this.mAiappsRuntimeEndTimeStamp;
            long j8 = j7 - j5;
            long j9 = this.mNpsInitEndTimeStamp;
            long j10 = j9 - j7;
            long j11 = this.mTiTanInitEndTimeStamp - j9;
            long j12 = this.mAppAttachContextEndTimeStamp;
            long j13 = j12 - j3;
            long j14 = j - j12;
            if (j2 >= 0 && j2 <= 60000 && j4 >= 0 && j4 <= 60000 && j6 >= 0 && j6 <= 60000 && j8 >= 0 && j8 <= 60000 && j11 >= 0 && j11 <= 60000 && j10 >= 0 && j10 <= 60000 && j14 >= 0 && j14 <= 60000) {
                HashMap hashMap = new HashMap();
                hashMap.put(APP_ATTACH, String.valueOf(j13));
                hashMap.put(MULTIDEX_INSTALL, String.valueOf(j6));
                hashMap.put(APP_RUNTIME_INIT, String.valueOf(j8));
                hashMap.put(TITAN_INIT, String.valueOf(j11));
                hashMap.put(NPS_INIT, String.valueOf(j10));
                hashMap.put(INSTALL_CONTENT_PROVIDER, String.valueOf(j14));
                JSONObject jsonData = SpeedStatsUtils.getJsonData(j2, hashMap);
                if (jsonData != null) {
                    try {
                        jSONObject.put(SpeedStatsMainTable.BEFORE_APP_CREATE_STAGE, jsonData);
                        return true;
                    } catch (JSONException e) {
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                            return true;
                        }
                        return true;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
