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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public SwanCoreVersion atp;
    public ExtensionCore atq;
    public String axG;
    public String axH;
    private Bundle axP;
    public String axQ;
    public boolean axR;
    public String axS;
    public String axV;
    public int axY;
    public String ayb;
    public int aye;
    public String mAppId;
    public String mFrom;
    public int axW = 0;
    public int ayd = 0;

    public void al(String str, String str2) {
        DC().putString(str, str2);
    }

    public Bundle DC() {
        if (this.axP == null) {
            this.axP = new Bundle();
        }
        return this.axP;
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
        intent.putExtra("mPage", cVar.axH);
        intent.putExtra("mIsDebug", cVar.axR);
        intent.putExtra("mExtraData", cVar.axP);
        intent.putExtra("notInHistory", cVar.axS);
        if (!TextUtils.isEmpty(cVar.axG)) {
            intent.putExtra("launchScheme", cVar.axG);
        }
        if (cVar.atp != null) {
            intent.putExtra("swanCoreVersion", cVar.atp);
        }
        if (cVar.atq != null) {
            intent.putExtra("extensionCore", cVar.atq);
        }
        if (!TextUtils.isEmpty(cVar.axV)) {
            intent.putExtra("targetSwanVersion", cVar.axV);
        }
        if (!TextUtils.isEmpty(cVar.axQ)) {
            intent.putExtra("mClickId", cVar.axQ);
        }
        intent.putExtra("launchFlags", cVar.axY);
        intent.putExtra("swanCoreFallbackCount", cVar.aye);
        intent.putExtra("appFrameType", cVar.axW);
        intent.putExtra("appFrameOrientation", cVar.ayd);
        return intent;
    }

    public static c H(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = m.a(intent, "mAppId");
        cVar.mFrom = m.a(intent, "mFrom");
        cVar.axH = m.a(intent, "mPage");
        cVar.axR = m.a(intent, "mIsDebug", false);
        cVar.axP = m.b(intent, "mExtraData");
        cVar.axG = m.a(intent, "launchScheme");
        cVar.axS = m.a(intent, "notInHistory");
        cVar.atp = (SwanCoreVersion) m.c(intent, "swanCoreVersion");
        cVar.atq = (ExtensionCore) m.c(intent, "extensionCore");
        cVar.axV = m.a(intent, "targetSwanVersion");
        cVar.ayb = m.a(intent, "remoteDebugUrl");
        cVar.axQ = m.a(intent, "mClickId");
        cVar.axY = m.a(intent, "launchFlags", 0);
        cVar.aye = m.a(intent, "swanCoreFallbackCount", 0);
        cVar.axW = m.a(intent, "appFrameType", 0);
        cVar.ayd = m.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cE(int i) {
        this.axY |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.axH + "', mIsDebug=" + this.axR + ", mExtraData=" + this.axP + ", mClickId='" + this.axQ + "', mLaunchScheme='" + this.axG + "', mNotInHistory='" + this.axS + "'}";
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
