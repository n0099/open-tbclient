package com.baidu.cyberplayer.sdk.task;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class UpgradeInfo {
    public static final String KEY_INT_FORCE_UPGRADE = "force";
    public static final String KEY_STR_EXTEND_INFO = "extend_info";
    public static final String KEY_STR_LOCAL_VERSION = "local_version";
    public static final String KEY_STR_UPGRADE_VERSION = "upgrade_version";
    public static final String TAG = "UpgradeInfo";
    public final String mExtInfo;
    public final boolean mForceUpgrade;
    public final String mLocalVersion;
    public final String mResourceName;
    public final String mUpgradeVersion;

    public UpgradeInfo(String str, String str2, String str3, String str4, boolean z) {
        this.mResourceName = str;
        this.mLocalVersion = str2;
        this.mUpgradeVersion = str3;
        this.mExtInfo = str4;
        this.mForceUpgrade = z;
    }

    public static UpgradeInfo parse(String str) {
        boolean z;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "upgrade_" + str + "_info";
        String cfgValue = CyberCfgManager.getInstance().getCfgValue(str3, "");
        if (TextUtils.isEmpty(cfgValue)) {
            return null;
        }
        CyberLog.d(TAG, "upgrade_key:" + str3);
        CyberLog.d(TAG, "upgrade_info:" + cfgValue);
        try {
            JSONObject jSONObject = new JSONObject(cfgValue);
            boolean has = jSONObject.has(KEY_STR_LOCAL_VERSION);
            boolean has2 = jSONObject.has(KEY_STR_UPGRADE_VERSION);
            if (!has && !has2) {
                return null;
            }
            String string = jSONObject.getString(KEY_STR_LOCAL_VERSION);
            String string2 = jSONObject.getString(KEY_STR_UPGRADE_VERSION);
            if (!Utils.isVaildVersionFormat(string)) {
                CyberLog.e(TAG, "invalid local_version:" + string);
                return null;
            } else if (!Utils.isVaildVersionFormat(string2)) {
                CyberLog.e(TAG, "invalid upgrade_version:" + string2);
                return null;
            } else {
                boolean z2 = true;
                if (CyberCfgManager.getInstance().getCfgBoolValue("enable_first_three_version_check", true) && !Utils.checkFirstThreeVersionMatch(string, string2)) {
                    CyberLog.e(TAG, "first three version not match");
                    return null;
                }
                boolean has3 = jSONObject.has(KEY_INT_FORCE_UPGRADE);
                boolean has4 = jSONObject.has(KEY_STR_EXTEND_INFO);
                if (has3) {
                    if (jSONObject.getInt(KEY_INT_FORCE_UPGRADE) != 1) {
                        z2 = false;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                if (has4) {
                    str2 = jSONObject.getString(KEY_STR_EXTEND_INFO);
                } else {
                    str2 = null;
                }
                UpgradeInfo upgradeInfo = new UpgradeInfo(str, string, string2, str2, z);
                CyberLog.d(TAG, "resourceName  :" + upgradeInfo.mResourceName);
                CyberLog.d(TAG, "LocalVersion  :" + upgradeInfo.mLocalVersion);
                CyberLog.d(TAG, "UpgradeVersion:" + upgradeInfo.mUpgradeVersion);
                CyberLog.d(TAG, "ExtendInfo    :" + upgradeInfo.mExtInfo);
                CyberLog.d(TAG, "forceUpgrade  :" + upgradeInfo.mForceUpgrade);
                return upgradeInfo;
            }
        } catch (Exception e) {
            CyberLog.e(TAG, "parseUpgradeInfo(" + str + ") exception:" + e);
            return null;
        }
    }
}
