package com.baidu.android.pushservice.mzproxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.e;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MzNotifyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24797b;

    /* renamed from: c  reason: collision with root package name */
    public String f24798c;

    /* renamed from: d  reason: collision with root package name */
    public String f24799d;

    /* renamed from: e  reason: collision with root package name */
    public String f24800e;

    public MzNotifyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            if (!jSONObject2.isNull("Msgid")) {
                                this.a = jSONObject2.getString("Msgid");
                            }
                            if (!jSONObject2.isNull("msgBody")) {
                                this.f24798c = jSONObject2.getString("msgBody");
                            }
                        }
                        if (!TextUtils.isEmpty(this.f24798c)) {
                            JSONObject jSONObject3 = new JSONObject(this.f24798c);
                            if (!jSONObject3.isNull("custom_content")) {
                                this.f24799d = jSONObject3.getString("custom_content");
                            }
                            if (!jSONObject3.isNull("pkg_content")) {
                                this.f24800e = jSONObject3.getString("pkg_content");
                            }
                            if (!jSONObject3.isNull("mzpri_signinfo")) {
                                this.f24797b = jSONObject3.getString("mzpri_signinfo");
                            }
                        }
                    }
                    if (e.a(this, this.f24797b, (this.a + this.f24799d).replaceAll("\\\\", ""))) {
                        if (TextUtils.isEmpty(this.f24800e)) {
                            parseUri = new Intent();
                            parseUri.setClassName(getPackageName(), a(this, getPackageName()));
                            parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        } else {
                            parseUri = Intent.parseUri(this.f24800e, 0);
                            parseUri.setPackage(getPackageName());
                            parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        }
                        if (!TextUtils.isEmpty(this.f24799d)) {
                            JSONObject jSONObject4 = new JSONObject(this.f24799d);
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
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
