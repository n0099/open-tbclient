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
    public SwanCoreVersion atq;
    public ExtensionCore atr;
    public String axH;
    public String axI;
    private Bundle axQ;
    public String axR;
    public boolean axS;
    public String axT;
    public String axW;
    public int axZ;
    public String ayc;
    public int ayf;
    public String mAppId;
    public String mFrom;
    public int axX = 0;
    public int aye = 0;

    public void al(String str, String str2) {
        DC().putString(str, str2);
    }

    public Bundle DC() {
        if (this.axQ == null) {
            this.axQ = new Bundle();
        }
        return this.axQ;
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
        intent.putExtra("mPage", cVar.axI);
        intent.putExtra("mIsDebug", cVar.axS);
        intent.putExtra("mExtraData", cVar.axQ);
        intent.putExtra("notInHistory", cVar.axT);
        if (!TextUtils.isEmpty(cVar.axH)) {
            intent.putExtra("launchScheme", cVar.axH);
        }
        if (cVar.atq != null) {
            intent.putExtra("swanCoreVersion", cVar.atq);
        }
        if (cVar.atr != null) {
            intent.putExtra("extensionCore", cVar.atr);
        }
        if (!TextUtils.isEmpty(cVar.axW)) {
            intent.putExtra("targetSwanVersion", cVar.axW);
        }
        if (!TextUtils.isEmpty(cVar.axR)) {
            intent.putExtra("mClickId", cVar.axR);
        }
        intent.putExtra("launchFlags", cVar.axZ);
        intent.putExtra("swanCoreFallbackCount", cVar.ayf);
        intent.putExtra("appFrameType", cVar.axX);
        intent.putExtra("appFrameOrientation", cVar.aye);
        return intent;
    }

    public static c H(Intent intent) {
        if (intent == null) {
            return null;
        }
        c cVar = new c();
        cVar.mAppId = m.a(intent, "mAppId");
        cVar.mFrom = m.a(intent, "mFrom");
        cVar.axI = m.a(intent, "mPage");
        cVar.axS = m.a(intent, "mIsDebug", false);
        cVar.axQ = m.b(intent, "mExtraData");
        cVar.axH = m.a(intent, "launchScheme");
        cVar.axT = m.a(intent, "notInHistory");
        cVar.atq = (SwanCoreVersion) m.c(intent, "swanCoreVersion");
        cVar.atr = (ExtensionCore) m.c(intent, "extensionCore");
        cVar.axW = m.a(intent, "targetSwanVersion");
        cVar.ayc = m.a(intent, "remoteDebugUrl");
        cVar.axR = m.a(intent, "mClickId");
        cVar.axZ = m.a(intent, "launchFlags", 0);
        cVar.ayf = m.a(intent, "swanCoreFallbackCount", 0);
        cVar.axX = m.a(intent, "appFrameType", 0);
        cVar.aye = m.a(intent, "appFrameOrientation", 0);
        return cVar;
    }

    @NonNull
    public c cE(int i) {
        this.axZ |= i;
        return this;
    }

    public String toString() {
        return "SwanAppLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.axI + "', mIsDebug=" + this.axS + ", mExtraData=" + this.axQ + ", mClickId='" + this.axR + "', mLaunchScheme='" + this.axH + "', mNotInHistory='" + this.axT + "'}";
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
