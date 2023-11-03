package com.baidu.android.pushservice.mzproxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.e;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MzNotifyActivity extends Activity {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static String a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                return activityInfo.name;
            }
        }
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent parseUri;
        JSONArray jSONArray;
        super.onCreate(bundle);
        try {
            String stringExtra = getIntent().getStringExtra("extras");
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject("{\"extras\":" + stringExtra + "}");
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (!jSONObject2.isNull("Msgid")) {
                            this.a = jSONObject2.getString("Msgid");
                        }
                        if (!jSONObject2.isNull("msgBody")) {
                            this.c = jSONObject2.getString("msgBody");
                        }
                    }
                    if (!TextUtils.isEmpty(this.c)) {
                        JSONObject jSONObject3 = new JSONObject(this.c);
                        if (!jSONObject3.isNull("custom_content")) {
                            this.d = jSONObject3.getString("custom_content");
                        }
                        if (!jSONObject3.isNull("pkg_content")) {
                            this.e = jSONObject3.getString("pkg_content");
                        }
                        if (!jSONObject3.isNull("mzpri_signinfo")) {
                            this.b = jSONObject3.getString("mzpri_signinfo");
                        }
                    }
                }
                if (e.a(this, this.b, (this.a + this.d).replaceAll("\\\\", ""))) {
                    if (TextUtils.isEmpty(this.e)) {
                        parseUri = new Intent();
                        parseUri.setClassName(getPackageName(), a(this, getPackageName()));
                        parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    } else {
                        parseUri = Intent.parseUri(this.e, 0);
                        parseUri.setPackage(getPackageName());
                        parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    }
                    if (!TextUtils.isEmpty(this.d)) {
                        JSONObject jSONObject4 = new JSONObject(this.d);
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            parseUri.putExtra(next, jSONObject4.optString(next));
                        }
                    }
                    if (getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                        startActivity(parseUri);
                    }
                }
            }
        } catch (Exception unused) {
        }
        finish();
    }
}
