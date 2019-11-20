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
    public String aIZ;
    public SwanCoreVersion aNK;
    public ExtensionCore aNL;
    public int aSG;
    public String aSM;
    public boolean aSN;
    private Bundle aSO;
    public String aSP;
    public String aSQ;
    public String aSR;
    public String aSS;
    public int aST = 0;
    public int aSU = 0;
    public String aSV;
    public int aSW;
    public String mAppId;
    public String mFrom;

    public void ar(String str, String str2) {
        Kt().putString(str, str2);
    }

    public Bundle Kt() {
        if (this.aSO == null) {
            this.aSO = new Bundle();
        }
        return this.aSO;
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
        intent.putExtra("mPage", cVar.aSM);
        intent.putExtra("mIsDebug", cVar.aSN);
        intent.putExtra("mExtraData", cVar.aSO);
        intent.putExtra("notInHistory", cVar.aSR);
        if (!TextUtils.isEmpty(cVar.aSQ)) {
            intent.putExtra("launchScheme", cVar.aSQ);
        }
        if (cVar.aNK != null) {
            intent.putExtra("swanCoreVersion", cVar.aNK);
        }
        if (cVar.aNL != null) {
            intent.putExtra("extensionCore", cVar.aNL);
        }
        if (!TextUtils.isEmpty(cVar.aSS)) {
            intent.putExtra("targetSwanVersion", cVar.aSS);
        }
        if (!TextUtils.isEmpty(cVar.aSP)) {
            intent.putExtra("mClickId", cVar.aSP);
        }
        intent.putExtra("launchFlags", cVar.aSG);
        intent.putExtra("swanCoreFallbackCount", cVar.aSW);
        intent.putExtra("appFrameType", cVar.aST);
        intent.putExtra("appFrameOrientation", cVar.aSU);
        return intent;
    }

    public static c M(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = n.a(intent, "mAppId");
        cVar.mFrom = n.a(intent, "mFrom");
        cVar.aSM = n.a(intent, "mPage");
        cVar.aSN = n.a(intent, "mIsDebug", false);
        cVar.aSO = n.b(intent, "mExtraData");
        cVar.aSQ = n.a(intent, "launchScheme");
        cVar.aSR = n.a(intent, "notInHistory");
        cVar.aNK = (SwanCoreVersion) n.c(intent, "swanCoreVersion");
        cVar.aNL = (ExtensionCore) n.c(intent, "extensionCore");
        cVar.aSS = n.a(intent, "targetSwanVersion");
        cVar.aSV = n.a(intent, "remoteDebugUrl");
        cVar.aSP = n.a(intent, "mClickId");
        cVar.aSG = n.a(intent, "launchFlags", 0);
        cVar.aSW = n.a(intent, "swanCoreFallbackCount", 0);
        cVar.aST = n.a(intent, "appFrameType", 0);
        cVar.aSU = n.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c dC(int i) {
        this.aSG |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.aSM + "', mIsDebug=" + this.aSN + ", mExtraData=" + this.aSO + ", mClickId='" + this.aSP + "', mLaunchScheme='" + this.aSQ + "', mNotInHistory='" + this.aSR + "'}";
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
