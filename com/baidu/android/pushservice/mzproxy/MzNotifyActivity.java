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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MzNotifyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f3613a;

    /* renamed from: b  reason: collision with root package name */
    public String f3614b;

    /* renamed from: c  reason: collision with root package name */
    public String f3615c;

    /* renamed from: d  reason: collision with root package name */
    public String f3616d;

    /* renamed from: e  reason: collision with root package name */
    public String f3617e;

    public MzNotifyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent parseUri;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                String stringExtra = getIntent().getStringExtra("extras");
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject("{\"extras\":" + stringExtra + "}");
                    if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            if (!jSONObject2.isNull("Msgid")) {
                                this.f3613a = jSONObject2.getString("Msgid");
                            }
                            if (!jSONObject2.isNull("msgBody")) {
                                this.f3615c = jSONObject2.getString("msgBody");
                            }
                        }
                        if (!TextUtils.isEmpty(this.f3615c)) {
                            JSONObject jSONObject3 = new JSONObject(this.f3615c);
                            if (!jSONObject3.isNull("custom_content")) {
                                this.f3616d = jSONObject3.getString("custom_content");
                            }
                            if (!jSONObject3.isNull("pkg_content")) {
                                this.f3617e = jSONObject3.getString("pkg_content");
                            }
                            if (!jSONObject3.isNull("mzpri_signinfo")) {
                                this.f3614b = jSONObject3.getString("mzpri_signinfo");
                            }
                        }
                    }
                    if (f.a(this, this.f3614b, (this.f3613a + this.f3616d).replaceAll("\\\\", ""))) {
                        if (TextUtils.isEmpty(this.f3617e)) {
                            parseUri = new Intent();
                            parseUri.setClassName(getPackageName(), a(this, getPackageName()));
                            parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        } else {
                            parseUri = Intent.parseUri(this.f3617e, 0);
                            parseUri.setPackage(getPackageName());
                            parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        }
                        if (!TextUtils.isEmpty(this.f3616d)) {
                            JSONObject jSONObject4 = new JSONObject(this.f3616d);
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
}
