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
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public SwanCoreVersion atv;
    public ExtensionCore atw;
    public String axL;
    public String axM;
    private Bundle axU;
    public String axV;
    public boolean axW;
    public String axX;
    public String aya;
    public int ayd;
    public String ayg;
    public int ayj;
    public String mAppId;
    public String mFrom;
    public int ayb = 0;
    public int ayi = 0;

    public void al(String str, String str2) {
        DA().putString(str, str2);
    }

    public Bundle DA() {
        if (this.axU == null) {
            this.axU = new Bundle();
        }
        return this.axU;
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
        intent.putExtra("mPage", cVar.axM);
        intent.putExtra("mIsDebug", cVar.axW);
        intent.putExtra("mExtraData", cVar.axU);
        intent.putExtra("notInHistory", cVar.axX);
        if (!TextUtils.isEmpty(cVar.axL)) {
            intent.putExtra("launchScheme", cVar.axL);
        }
        if (cVar.atv != null) {
            intent.putExtra("swanCoreVersion", cVar.atv);
        }
        if (cVar.atw != null) {
            intent.putExtra("extensionCore", cVar.atw);
        }
        if (!TextUtils.isEmpty(cVar.aya)) {
            intent.putExtra("targetSwanVersion", cVar.aya);
        }
        if (!TextUtils.isEmpty(cVar.axV)) {
            intent.putExtra("mClickId", cVar.axV);
        }
        intent.putExtra("launchFlags", cVar.ayd);
        intent.putExtra("swanCoreFallbackCount", cVar.ayj);
        intent.putExtra("appFrameType", cVar.ayb);
        intent.putExtra("appFrameOrientation", cVar.ayi);
        return intent;
    }

    public static c H(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = m.a(intent, "mAppId");
        cVar.mFrom = m.a(intent, "mFrom");
        cVar.axM = m.a(intent, "mPage");
        cVar.axW = m.a(intent, "mIsDebug", false);
        cVar.axU = m.b(intent, "mExtraData");
        cVar.axL = m.a(intent, "launchScheme");
        cVar.axX = m.a(intent, "notInHistory");
        cVar.atv = (SwanCoreVersion) m.c(intent, "swanCoreVersion");
        cVar.atw = (ExtensionCore) m.c(intent, "extensionCore");
        cVar.aya = m.a(intent, "targetSwanVersion");
        cVar.ayg = m.a(intent, "remoteDebugUrl");
        cVar.axV = m.a(intent, "mClickId");
        cVar.ayd = m.a(intent, "launchFlags", 0);
        cVar.ayj = m.a(intent, "swanCoreFallbackCount", 0);
        cVar.ayb = m.a(intent, "appFrameType", 0);
        cVar.ayi = m.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cD(int i) {
        this.ayd |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.axM + "', mIsDebug=" + this.axW + ", mExtraData=" + this.axU + ", mClickId='" + this.axV + "', mLaunchScheme='" + this.axL + "', mNotInHistory='" + this.axX + "'}";
    }

    public static String d(String str, String str2, int i) {
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
