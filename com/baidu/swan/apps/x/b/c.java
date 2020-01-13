package com.baidu.swan.apps.x.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.x.b.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class c<SelfT extends c<SelfT>> extends e<SelfT> {

    /* loaded from: classes10.dex */
    public static final class a extends c<a> {
        @Override // com.baidu.swan.apps.x.b.c, com.baidu.swan.apps.x.b.a.c
        public /* synthetic */ com.baidu.swan.apps.x.b.a.c B(Bundle bundle) {
            return super.B(bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: Tq */
        public a Tp() {
            return this;
        }
    }

    public static Intent a(Context context, c cVar) {
        if (context == null || cVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        intent.putExtras(cVar.toBundle());
        return intent;
    }

    public static c C(Bundle bundle) {
        a aVar = new a();
        aVar.B(bundle);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: D */
    public SelfT B(Bundle bundle) {
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        return (SelfT) super.B(bundle);
    }

    @Override // com.baidu.swan.apps.x.b.a.c
    public String toString() {
        return "SwanAppLaunchParams{appId='" + getAppId() + "', from='" + Tt() + "', page='" + getPage() + "', isDebug=" + isDebug() + ", extraData=" + Ty() + ", clickId='" + TA() + "', launchScheme='" + Tv() + "', notInHistory='" + TB() + "'}";
    }

    public static String g(String str, String str2, int i) {
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

    public static String b(String str, int i, JSONObject jSONObject) {
        String str2;
        if (i == 1) {
            str2 = "swangame";
        } else {
            str2 = "swan";
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str2).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
        return builder.toString();
    }
}
