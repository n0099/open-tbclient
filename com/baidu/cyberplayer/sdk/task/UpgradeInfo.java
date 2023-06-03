package com.baidu.cyberplayer.sdk.task;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.q;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class UpgradeInfo {
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
        CyberLog.d("UpgradeInfo", "upgrade_key:" + str3);
        CyberLog.d("UpgradeInfo", "upgrade_info:" + cfgValue);
        try {
            JSONObject jSONObject = new JSONObject(cfgValue);
            boolean has = jSONObject.has("local_version");
            boolean has2 = jSONObject.has("upgrade_version");
            if (!has && !has2) {
                return null;
            }
            String string = jSONObject.getString("local_version");
            String string2 = jSONObject.getString("upgrade_version");
            if (!q.d(string)) {
                CyberLog.e("UpgradeInfo", "invalid local_version:" + string);
                return null;
            } else if (!q.d(string2)) {
                CyberLog.e("UpgradeInfo", "invalid upgrade_version:" + string2);
                return null;
            } else {
                boolean has3 = jSONObject.has("download_type");
                boolean has4 = jSONObject.has("extend_info");
                String str4 = TTDownloadField.TT_FORCE;
                if (has3) {
                    z = TextUtils.equals(jSONObject.getString("download_type"), TTDownloadField.TT_FORCE);
                } else {
                    z = false;
                }
                if (has4) {
                    str2 = jSONObject.getString("extend_info");
                } else {
                    str2 = null;
                }
                UpgradeInfo upgradeInfo = new UpgradeInfo(str, string, string2, str2, z);
                CyberLog.d("UpgradeInfo", "resourceName  :" + upgradeInfo.mResourceName);
                CyberLog.d("UpgradeInfo", "LocalVersion  :" + upgradeInfo.mLocalVersion);
                CyberLog.d("UpgradeInfo", "UpgradeVersion:" + upgradeInfo.mUpgradeVersion);
                CyberLog.d("UpgradeInfo", "ExtendInfo    :" + upgradeInfo.mExtInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("UpgradeType   :");
                if (!upgradeInfo.mForceUpgrade) {
                    str4 = NotificationCompat.GROUP_KEY_SILENT;
                }
                sb.append(str4);
                CyberLog.d("UpgradeInfo", sb.toString());
                return upgradeInfo;
            }
        } catch (Exception e) {
            CyberLog.e("UpgradeInfo", "parseUpgradeInfo(" + str + ") exception:" + e);
            return null;
        }
    }
}
