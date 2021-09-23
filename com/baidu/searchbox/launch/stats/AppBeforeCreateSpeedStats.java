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
/* loaded from: classes5.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) {
            super.addStatsMap(str, map);
            if (((str.hashCode() == 110371084 && str.equals(TITAN_DETAILS)) ? (char) 0 : (char) 65535) != 0) {
                return;
            }
            this.mTitanDetailsMap = map;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            addStatsTimeStamp(i2, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppCreateStartTime : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp() : invokeV.longValue;
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
            long j2 = this.mAppCreateStartTime;
            long j3 = j2 - appLaunchStartTimeStamp;
            long j4 = this.mAttachBaseContextStartTimeStamp;
            long j5 = j4 - appLaunchStartTimeStamp;
            long j6 = this.mMultiDexinstallEndTimeStamp;
            long j7 = j6 - j4;
            long j8 = this.mAiappsRuntimeEndTimeStamp;
            long j9 = j8 - j6;
            long j10 = this.mNpsInitEndTimeStamp;
            long j11 = j10 - j8;
            long j12 = this.mTiTanInitEndTimeStamp - j10;
            long j13 = this.mAppAttachContextEndTimeStamp;
            long j14 = j13 - j4;
            long j15 = j2 - j13;
            if (j3 < 0 || j3 > 60000 || j5 < 0 || j5 > 60000 || j7 < 0 || j7 > 60000 || j9 < 0 || j9 > 60000 || j12 < 0 || j12 > 60000 || j11 < 0 || j11 > 60000 || j15 < 0 || j15 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(APP_ATTACH, String.valueOf(j14));
            hashMap.put(MULTIDEX_INSTALL, String.valueOf(j7));
            hashMap.put(APP_RUNTIME_INIT, String.valueOf(j9));
            hashMap.put(TITAN_INIT, String.valueOf(j12));
            hashMap.put(NPS_INIT, String.valueOf(j11));
            hashMap.put(INSTALL_CONTENT_PROVIDER, String.valueOf(j15));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j3, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.BEFORE_APP_CREATE_STAGE, jsonData);
                    return true;
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
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
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            if (i2 != 2000) {
                switch (i2) {
                    case 1002:
                        this.mAttachBaseContextStartTimeStamp = j2;
                        return;
                    case 1003:
                        this.mMultiDexinstallEndTimeStamp = j2;
                        return;
                    case 1004:
                        this.mAiappsRuntimeEndTimeStamp = j2;
                        return;
                    default:
                        switch (i2) {
                            case 1010:
                                this.mAppAttachContextEndTimeStamp = j2;
                                return;
                            case 1011:
                                this.mNpsInitEndTimeStamp = j2;
                                return;
                            case 1012:
                                this.mTiTanInitEndTimeStamp = j2;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.mAppCreateStartTime = j2;
        }
    }
}
