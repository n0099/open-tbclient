package com.baidu.android.pushservice.mzproxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.pushservice.f;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MzNotifyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public String f3563a;

    /* renamed from: b  reason: collision with root package name */
    public String f3564b;

    /* renamed from: c  reason: collision with root package name */
    public String f3565c;

    /* renamed from: d  reason: collision with root package name */
    public String f3566d;

    /* renamed from: e  reason: collision with root package name */
    public String f3567e;

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
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (!jSONObject2.isNull("Msgid")) {
                            this.f3563a = jSONObject2.getString("Msgid");
                        }
                        if (!jSONObject2.isNull("msgBody")) {
                            this.f3565c = jSONObject2.getString("msgBody");
                        }
                    }
                    if (!TextUtils.isEmpty(this.f3565c)) {
                        JSONObject jSONObject3 = new JSONObject(this.f3565c);
                        if (!jSONObject3.isNull("custom_content")) {
                            this.f3566d = jSONObject3.getString("custom_content");
                        }
                        if (!jSONObject3.isNull("pkg_content")) {
                            this.f3567e = jSONObject3.getString("pkg_content");
                        }
                        if (!jSONObject3.isNull("mzpri_signinfo")) {
                            this.f3564b = jSONObject3.getString("mzpri_signinfo");
                        }
                    }
                }
                if (f.a(this, this.f3564b, (this.f3563a + this.f3566d).replaceAll("\\\\", ""))) {
                    if (TextUtils.isEmpty(this.f3567e)) {
                        parseUri = new Intent();
                        parseUri.setClassName(getPackageName(), a(this, getPackageName()));
                        parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    } else {
                        parseUri = Intent.parseUri(this.f3567e, 0);
                        parseUri.setPackage(getPackageName());
                        parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    if (!TextUtils.isEmpty(this.f3566d)) {
                        JSONObject jSONObject4 = new JSONObject(this.f3566d);
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
