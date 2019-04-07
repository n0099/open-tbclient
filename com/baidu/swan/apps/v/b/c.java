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
    public SwanCoreVersion atu;
    public ExtensionCore atv;
    public String axK;
    public String axL;
    private Bundle axT;
    public String axU;
    public boolean axV;
    public String axW;
    public String axZ;
    public int ayc;
    public String ayf;
    public int ayi;
    public String mAppId;
    public String mFrom;
    public int aya = 0;
    public int ayh = 0;

    public void al(String str, String str2) {
        DA().putString(str, str2);
    }

    public Bundle DA() {
        if (this.axT == null) {
            this.axT = new Bundle();
        }
        return this.axT;
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
        intent.putExtra("mPage", cVar.axL);
        intent.putExtra("mIsDebug", cVar.axV);
        intent.putExtra("mExtraData", cVar.axT);
        intent.putExtra("notInHistory", cVar.axW);
        if (!TextUtils.isEmpty(cVar.axK)) {
            intent.putExtra("launchScheme", cVar.axK);
        }
        if (cVar.atu != null) {
            intent.putExtra("swanCoreVersion", cVar.atu);
        }
        if (cVar.atv != null) {
            intent.putExtra("extensionCore", cVar.atv);
        }
        if (!TextUtils.isEmpty(cVar.axZ)) {
            intent.putExtra("targetSwanVersion", cVar.axZ);
        }
        if (!TextUtils.isEmpty(cVar.axU)) {
            intent.putExtra("mClickId", cVar.axU);
        }
        intent.putExtra("launchFlags", cVar.ayc);
        intent.putExtra("swanCoreFallbackCount", cVar.ayi);
        intent.putExtra("appFrameType", cVar.aya);
        intent.putExtra("appFrameOrientation", cVar.ayh);
        return intent;
    }

    public static c H(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = m.a(intent, "mAppId");
        cVar.mFrom = m.a(intent, "mFrom");
        cVar.axL = m.a(intent, "mPage");
        cVar.axV = m.a(intent, "mIsDebug", false);
        cVar.axT = m.b(intent, "mExtraData");
        cVar.axK = m.a(intent, "launchScheme");
        cVar.axW = m.a(intent, "notInHistory");
        cVar.atu = (SwanCoreVersion) m.c(intent, "swanCoreVersion");
        cVar.atv = (ExtensionCore) m.c(intent, "extensionCore");
        cVar.axZ = m.a(intent, "targetSwanVersion");
        cVar.ayf = m.a(intent, "remoteDebugUrl");
        cVar.axU = m.a(intent, "mClickId");
        cVar.ayc = m.a(intent, "launchFlags", 0);
        cVar.ayi = m.a(intent, "swanCoreFallbackCount", 0);
        cVar.aya = m.a(intent, "appFrameType", 0);
        cVar.ayh = m.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cD(int i) {
        this.ayc |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.axL + "', mIsDebug=" + this.axV + ", mExtraData=" + this.axT + ", mClickId='" + this.axU + "', mLaunchScheme='" + this.axK + "', mNotInHistory='" + this.axW + "'}";
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
