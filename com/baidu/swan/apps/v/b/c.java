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
    public String aJr;
    public SwanCoreVersion aOc;
    public ExtensionCore aOd;
    public int aSY;
    public String aTe;
    public boolean aTf;
    private Bundle aTg;
    public String aTh;
    public String aTi;
    public String aTj;
    public String aTk;
    public int aTl = 0;
    public int aTm = 0;
    public String aTn;
    public int aTo;
    public String mAppId;
    public String mFrom;

    public void ar(String str, String str2) {
        Ks().putString(str, str2);
    }

    public Bundle Ks() {
        if (this.aTg == null) {
            this.aTg = new Bundle();
        }
        return this.aTg;
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
        intent.putExtra("mPage", cVar.aTe);
        intent.putExtra("mIsDebug", cVar.aTf);
        intent.putExtra("mExtraData", cVar.aTg);
        intent.putExtra("notInHistory", cVar.aTj);
        if (!TextUtils.isEmpty(cVar.aTi)) {
            intent.putExtra("launchScheme", cVar.aTi);
        }
        if (cVar.aOc != null) {
            intent.putExtra("swanCoreVersion", cVar.aOc);
        }
        if (cVar.aOd != null) {
            intent.putExtra("extensionCore", cVar.aOd);
        }
        if (!TextUtils.isEmpty(cVar.aTk)) {
            intent.putExtra("targetSwanVersion", cVar.aTk);
        }
        if (!TextUtils.isEmpty(cVar.aTh)) {
            intent.putExtra("mClickId", cVar.aTh);
        }
        intent.putExtra("launchFlags", cVar.aSY);
        intent.putExtra("swanCoreFallbackCount", cVar.aTo);
        intent.putExtra("appFrameType", cVar.aTl);
        intent.putExtra("appFrameOrientation", cVar.aTm);
        return intent;
    }

    public static c M(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = n.b(intent, "mAppId");
        cVar.mFrom = n.b(intent, "mFrom");
        cVar.aTe = n.b(intent, "mPage");
        cVar.aTf = n.a(intent, "mIsDebug", false);
        cVar.aTg = n.c(intent, "mExtraData");
        cVar.aTi = n.b(intent, "launchScheme");
        cVar.aTj = n.b(intent, "notInHistory");
        cVar.aOc = (SwanCoreVersion) n.d(intent, "swanCoreVersion");
        cVar.aOd = (ExtensionCore) n.d(intent, "extensionCore");
        cVar.aTk = n.b(intent, "targetSwanVersion");
        cVar.aTn = n.b(intent, "remoteDebugUrl");
        cVar.aTh = n.b(intent, "mClickId");
        cVar.aSY = n.a(intent, "launchFlags", 0);
        cVar.aTo = n.a(intent, "swanCoreFallbackCount", 0);
        cVar.aTl = n.a(intent, "appFrameType", 0);
        cVar.aTm = n.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c dC(int i) {
        this.aSY |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.aTe + "', mIsDebug=" + this.aTf + ", mExtraData=" + this.aTg + ", mClickId='" + this.aTh + "', mLaunchScheme='" + this.aTi + "', mNotInHistory='" + this.aTj + "'}";
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
