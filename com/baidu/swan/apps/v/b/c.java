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
    public String apD;
    public SwanCoreVersion aun;
    public ExtensionCore auo;
    public String azB;
    public int azC;
    public int azm;
    public String azs;
    public boolean azt;
    private Bundle azu;
    public String azv;
    public String azw;
    public String azx;
    public String azy;
    public String mAppId;
    public String mFrom;
    public int azz = 0;
    public int azA = 0;

    public void aj(String str, String str2) {
        Fu().putString(str, str2);
    }

    public Bundle Fu() {
        if (this.azu == null) {
            this.azu = new Bundle();
        }
        return this.azu;
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
        intent.putExtra("mPage", cVar.azs);
        intent.putExtra("mIsDebug", cVar.azt);
        intent.putExtra("mExtraData", cVar.azu);
        intent.putExtra("notInHistory", cVar.azx);
        if (!TextUtils.isEmpty(cVar.azw)) {
            intent.putExtra("launchScheme", cVar.azw);
        }
        if (cVar.aun != null) {
            intent.putExtra("swanCoreVersion", cVar.aun);
        }
        if (cVar.auo != null) {
            intent.putExtra("extensionCore", cVar.auo);
        }
        if (!TextUtils.isEmpty(cVar.azy)) {
            intent.putExtra("targetSwanVersion", cVar.azy);
        }
        if (!TextUtils.isEmpty(cVar.azv)) {
            intent.putExtra("mClickId", cVar.azv);
        }
        intent.putExtra("launchFlags", cVar.azm);
        intent.putExtra("swanCoreFallbackCount", cVar.azC);
        intent.putExtra("appFrameType", cVar.azz);
        intent.putExtra("appFrameOrientation", cVar.azA);
        return intent;
    }

    public static c G(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = n.b(intent, "mAppId");
        cVar.mFrom = n.b(intent, "mFrom");
        cVar.azs = n.b(intent, "mPage");
        cVar.azt = n.a(intent, "mIsDebug", false);
        cVar.azu = n.c(intent, "mExtraData");
        cVar.azw = n.b(intent, "launchScheme");
        cVar.azx = n.b(intent, "notInHistory");
        cVar.aun = (SwanCoreVersion) n.d(intent, "swanCoreVersion");
        cVar.auo = (ExtensionCore) n.d(intent, "extensionCore");
        cVar.azy = n.b(intent, "targetSwanVersion");
        cVar.azB = n.b(intent, "remoteDebugUrl");
        cVar.azv = n.b(intent, "mClickId");
        cVar.azm = n.a(intent, "launchFlags", 0);
        cVar.azC = n.a(intent, "swanCoreFallbackCount", 0);
        cVar.azz = n.a(intent, "appFrameType", 0);
        cVar.azA = n.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cG(int i) {
        this.azm |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.azs + "', mIsDebug=" + this.azt + ", mExtraData=" + this.azu + ", mClickId='" + this.azv + "', mLaunchScheme='" + this.azw + "', mNotInHistory='" + this.azx + "'}";
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
