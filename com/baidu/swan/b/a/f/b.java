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
/* loaded from: classes10.dex */
public class b extends f {
    public String packageName;

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        this.bRh = com.baidu.swan.apps.swancore.b.gj(TextUtils.equals(this.mFrom, "swangame") ? 1 : 0);
        this.bRj = SwanAppNetworkUtils.WJ().type;
        if (this.bRf == null) {
            this.bRf = new JSONObject();
        }
        try {
            this.bRf.put(Contract.SCHEME_KEY_HOST, com.baidu.swan.apps.w.a.Sr().getHostName());
            this.bRf.put("package", this.packageName);
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
            this.bRk = aVar.bRk;
            this.bRl = aVar.bRl;
            this.mScheme = aVar.mScheme;
            this.bRo = aVar.bRo;
            this.bLn = aVar.bLn;
            this.mAppVersion = aVar.mAppVersion;
            this.bRi = aVar.bRi;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String nS(String str) {
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
