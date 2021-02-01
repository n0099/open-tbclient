package com.baidu.swan.gamecenter.appmanager.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b extends f {
    public String packageName;

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        this.dLx = com.baidu.swan.apps.swancore.b.jD(TextUtils.equals(this.mFrom, "swangame") ? 1 : 0);
        this.dLz = SwanAppNetworkUtils.aDf().type;
        if (this.dLv == null) {
            this.dLv = new JSONObject();
        }
        try {
            this.dLv.put("host", com.baidu.swan.apps.t.a.axI().getHostName());
            this.dLv.put("package", this.packageName);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.d("SwanAppUBCEvent", "setCommonData: " + aVar.toJsonString());
            }
            this.mFrom = aVar.mFrom;
            this.mAppId = aVar.mAppId;
            this.mSource = aVar.mSource;
            this.dLA = aVar.dLA;
            this.dLC = aVar.dLC;
            this.mScheme = aVar.mScheme;
            this.dLF = aVar.dLF;
            this.dEC = aVar.dEC;
            this.mAppVersion = aVar.mAppVersion;
            this.dLy = aVar.dLy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String vP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1903789791:
                if (str.equals("continueClick")) {
                    c = '\n';
                    break;
                }
                break;
            case -1263222921:
                if (str.equals("openApp")) {
                    c = 5;
                    break;
                }
                break;
            case -625158317:
                if (str.equals("deleteDownload")) {
                    c = 3;
                    break;
                }
                break;
            case -606050596:
                if (str.equals("resumeAllDownload")) {
                    c = 6;
                    break;
                }
                break;
            case -567202649:
                if (str.equals("continue")) {
                    c = '\b';
                    break;
                }
                break;
            case -451216226:
                if (str.equals("pauseDownload")) {
                    c = 1;
                    break;
                }
                break;
            case 66344735:
                if (str.equals("authorizeClick")) {
                    c = '\t';
                    break;
                }
                break;
            case 184711125:
                if (str.equals("resumeDownload")) {
                    c = 2;
                    break;
                }
                break;
            case 900412038:
                if (str.equals("installApp")) {
                    c = 4;
                    break;
                }
                break;
            case 1475610601:
                if (str.equals("authorize")) {
                    c = 7;
                    break;
                }
                break;
            case 1554935562:
                if (str.equals("startDownload")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "start";
            case 1:
                return "pause";
            case 2:
                return "resume";
            case 3:
                return "cancel";
            case 4:
                return Config.INPUT_INSTALLED_PKG;
            case 5:
                return "open";
            case 6:
                return "continue";
            case 7:
                return "authorize";
            case '\b':
                return "guide";
            case '\t':
                return "authorizeclick";
            case '\n':
                return "guideclick";
            default:
                return null;
        }
    }
}
