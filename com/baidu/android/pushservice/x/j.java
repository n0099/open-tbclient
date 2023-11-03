package com.baidu.android.pushservice.x;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends g {
    public j(Context context, int i, String str) {
        super(context, i, str);
    }

    @Override // com.baidu.android.pushservice.x.g
    public String b() {
        int i;
        if (!Utility.N(this.a) || (i = Build.VERSION.SDK_INT) < 26 || i > 29) {
            return super.b();
        }
        com.baidu.android.pushservice.a0.h.a(this.a, "com.baidu.android.pushservice.push.importance_low", "云推送静默", 1);
        return "com.baidu.android.pushservice.push.importance_low";
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews c() {
        String str;
        String str2 = "";
        int i = (Utility.S(this.a) || (Utility.M(this.a) && Build.VERSION.SDK_INT <= 30)) ? R.layout.bd_push_notification_red_env_style_vivo : R.layout.bd_push_notification_red_env_style;
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            str = jSONObject.optString("title");
            try {
                str2 = jSONObject.optString("appname");
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = this.a.getResources().getString(R.string.bd_push_red_envelope);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Utility.q(this.a);
        }
        if (Utility.R(this.a)) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), i);
            remoteViews.setTextViewText(R.id.bd_push_title, str);
            remoteViews.setTextViewText(R.id.bd_push_tv_app_name, str2);
            if (Utility.S(this.a)) {
                remoteViews.setImageViewBitmap(R.id.bd_push_iv_bg, Utility.a(100, 100, "#FF9C34"));
            }
            return remoteViews;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        return Utility.F(this.a);
    }
}
