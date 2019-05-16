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
    public String aoZ;
    public SwanCoreVersion atK;
    public ExtensionCore atL;
    public int ayF;
    public String ayL;
    public boolean ayM;
    private Bundle ayN;
    public String ayO;
    public String ayP;
    public String ayQ;
    public String ayR;
    public int ayS = 0;
    public int ayT = 0;
    public String ayU;
    public int ayV;
    public String mAppId;
    public String mFrom;

    public void aj(String str, String str2) {
        EK().putString(str, str2);
    }

    public Bundle EK() {
        if (this.ayN == null) {
            this.ayN = new Bundle();
        }
        return this.ayN;
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
        intent.putExtra("mPage", cVar.ayL);
        intent.putExtra("mIsDebug", cVar.ayM);
        intent.putExtra("mExtraData", cVar.ayN);
        intent.putExtra("notInHistory", cVar.ayQ);
        if (!TextUtils.isEmpty(cVar.ayP)) {
            intent.putExtra("launchScheme", cVar.ayP);
        }
        if (cVar.atK != null) {
            intent.putExtra("swanCoreVersion", cVar.atK);
        }
        if (cVar.atL != null) {
            intent.putExtra("extensionCore", cVar.atL);
        }
        if (!TextUtils.isEmpty(cVar.ayR)) {
            intent.putExtra("targetSwanVersion", cVar.ayR);
        }
        if (!TextUtils.isEmpty(cVar.ayO)) {
            intent.putExtra("mClickId", cVar.ayO);
        }
        intent.putExtra("launchFlags", cVar.ayF);
        intent.putExtra("swanCoreFallbackCount", cVar.ayV);
        intent.putExtra("appFrameType", cVar.ayS);
        intent.putExtra("appFrameOrientation", cVar.ayT);
        return intent;
    }

    public static c G(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = n.b(intent, "mAppId");
        cVar.mFrom = n.b(intent, "mFrom");
        cVar.ayL = n.b(intent, "mPage");
        cVar.ayM = n.a(intent, "mIsDebug", false);
        cVar.ayN = n.c(intent, "mExtraData");
        cVar.ayP = n.b(intent, "launchScheme");
        cVar.ayQ = n.b(intent, "notInHistory");
        cVar.atK = (SwanCoreVersion) n.d(intent, "swanCoreVersion");
        cVar.atL = (ExtensionCore) n.d(intent, "extensionCore");
        cVar.ayR = n.b(intent, "targetSwanVersion");
        cVar.ayU = n.b(intent, "remoteDebugUrl");
        cVar.ayO = n.b(intent, "mClickId");
        cVar.ayF = n.a(intent, "launchFlags", 0);
        cVar.ayV = n.a(intent, "swanCoreFallbackCount", 0);
        cVar.ayS = n.a(intent, "appFrameType", 0);
        cVar.ayT = n.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cF(int i) {
        this.ayF |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.ayL + "', mIsDebug=" + this.ayM + ", mExtraData=" + this.ayN + ", mClickId='" + this.ayO + "', mLaunchScheme='" + this.ayP + "', mNotInHistory='" + this.ayQ + "'}";
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
