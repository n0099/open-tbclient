package com.baidu.swan.b.a.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends f {
    public String packageName;

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        this.bQx = com.baidu.swan.apps.swancore.b.gi(TextUtils.equals(this.mFrom, "swangame") ? 1 : 0);
        this.bQz = SwanAppNetworkUtils.Wm().type;
        if (this.bQv == null) {
            this.bQv = new JSONObject();
        }
        try {
            this.bQv.put(Contract.SCHEME_KEY_HOST, com.baidu.swan.apps.w.a.RV().getHostName());
            this.bQv.put("package", this.packageName);
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
            this.bQA = aVar.bQA;
            this.bQB = aVar.bQB;
            this.mScheme = aVar.mScheme;
            this.bQE = aVar.bQE;
            this.bKD = aVar.bKD;
            this.mAppVersion = aVar.mAppVersion;
            this.bQy = aVar.bQy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String nP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
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
            case -451216226:
                if (str.equals("pauseDownload")) {
                    c = 1;
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
                return UgcUBCUtils.UGC_TIME_CANCEL;
            case 4:
                return Config.INPUT_INSTALLED_PKG;
            case 5:
                return "open";
            default:
                return null;
        }
    }
}
