package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class AppBeforeCreateSpeedStats extends AbstractSpeedStats {
    public static final String APP_ATTACH = "appAttach";
    public static final String APP_RUNTIME_INIT = "appRuntimeInit";
    public static final String INSTALL_CONTENT_PROVIDER = "installContentProvider";
    public static final String MULTIDEX_INSTALL = "multidexInstall";
    public static final String NPS_INIT = "npsInit";
    public static final String TITAN_DETAILS = "titan";
    public static final String TITAN_INIT = "titanInit";
    public long mAttachBaseContextStartTimeStamp = -1;
    public long mMultiDexinstallEndTimeStamp = -1;
    public long mAppRuntimeInitEndTimeStamp = -1;
    public long mAppAttachContextEndTimeStamp = -1;
    public long mAiappsRuntimeEndTimeStamp = -1;
    public long mNpsInitEndTimeStamp = -1;
    public long mTiTanInitEndTimeStamp = -1;
    public long mAppCreateStartTime = -1;
    public Map mTitanDetailsMap = null;

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        return this.mAppCreateStartTime;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        return SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        this.mAttachBaseContextStartTimeStamp = -1L;
        this.mMultiDexinstallEndTimeStamp = -1L;
        this.mAppRuntimeInitEndTimeStamp = -1L;
        this.mAppAttachContextEndTimeStamp = -1L;
        this.mAiappsRuntimeEndTimeStamp = -1L;
        this.mNpsInitEndTimeStamp = -1L;
        this.mNpsInitEndTimeStamp = -1L;
        this.mTitanDetailsMap = null;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsMap(String str, Map<String, String> map) {
        char c;
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        addStatsTimeStamp(i, System.currentTimeMillis());
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
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
}
