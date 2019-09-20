package com.baidu.swan.apps.v.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public int aAa;
    public String aqb;
    public SwanCoreVersion auL;
    public ExtensionCore auM;
    public int azK;
    public String azQ;
    public boolean azR;
    private Bundle azS;
    public String azT;
    public String azU;
    public String azV;
    public String azW;
    public int azX = 0;
    public int azY = 0;
    public String azZ;
    public String mAppId;
    public String mFrom;

    public void aj(String str, String str2) {
        Fy().putString(str, str2);
    }

    public Bundle Fy() {
        if (this.azS == null) {
            this.azS = new Bundle();
        }
        return this.azS;
    }

    public static Intent c(Context context, c cVar) {
        if (context == null || cVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        intent.putExtra("mAppId", cVar.mAppId);
        intent.putExtra("mFrom", cVar.mFrom);
        intent.putExtra("mPage", cVar.azQ);
        intent.putExtra("mIsDebug", cVar.azR);
        intent.putExtra("mExtraData", cVar.azS);
        intent.putExtra("notInHistory", cVar.azV);
        if (!TextUtils.isEmpty(cVar.azU)) {
            intent.putExtra("launchScheme", cVar.azU);
        }
        if (cVar.auL != null) {
            intent.putExtra("swanCoreVersion", cVar.auL);
        }
        if (cVar.auM != null) {
            intent.putExtra("extensionCore", cVar.auM);
        }
        if (!TextUtils.isEmpty(cVar.azW)) {
            intent.putExtra("targetSwanVersion", cVar.azW);
        }
        if (!TextUtils.isEmpty(cVar.azT)) {
            intent.putExtra("mClickId", cVar.azT);
        }
        intent.putExtra("launchFlags", cVar.azK);
        intent.putExtra("swanCoreFallbackCount", cVar.aAa);
        intent.putExtra("appFrameType", cVar.azX);
        intent.putExtra("appFrameOrientation", cVar.azY);
        return intent;
    }

    public static c G(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = n.b(intent, "mAppId");
        cVar.mFrom = n.b(intent, "mFrom");
        cVar.azQ = n.b(intent, "mPage");
        cVar.azR = n.a(intent, "mIsDebug", false);
        cVar.azS = n.c(intent, "mExtraData");
        cVar.azU = n.b(intent, "launchScheme");
        cVar.azV = n.b(intent, "notInHistory");
        cVar.auL = (SwanCoreVersion) n.d(intent, "swanCoreVersion");
        cVar.auM = (ExtensionCore) n.d(intent, "extensionCore");
        cVar.azW = n.b(intent, "targetSwanVersion");
        cVar.azZ = n.b(intent, "remoteDebugUrl");
        cVar.azT = n.b(intent, "mClickId");
        cVar.azK = n.a(intent, "launchFlags", 0);
        cVar.aAa = n.a(intent, "swanCoreFallbackCount", 0);
        cVar.azX = n.a(intent, "appFrameType", 0);
        cVar.azY = n.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cH(int i) {
        this.azK |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.azQ + "', mIsDebug=" + this.azR + ", mExtraData=" + this.azS + ", mClickId='" + this.azT + "', mLaunchScheme='" + this.azU + "', mNotInHistory='" + this.azV + "'}";
    }

    public static String c(String str, String str2, int i) {
        String str3;
        if (i == 1) {
            str3 = "swangame";
        } else {
            str3 = "swan";
        }
        Uri.Builder builder = new Uri.Builder();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str3).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
        return builder.toString();
    }
}
