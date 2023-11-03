package com.baidu.android.pushservice.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends g {
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    public b(Context context, int i, String str) {
        super(context, i, str);
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
    }

    public final RemoteViews a(int i) {
        String str;
        RemoteViews remoteViews = new RemoteViews(this.c, i);
        if (a()) {
            if (TextUtils.isEmpty(this.f)) {
                str = Utility.q(this.a);
            } else {
                str = Utility.q(this.a) + "•" + this.f;
            }
            remoteViews.setTextViewText(R.id.bd_push_txv_app_name, str);
            int i2 = this.h;
            if (i2 != Integer.MIN_VALUE) {
                remoteViews.setTextColor(R.id.bd_push_txv_app_name, i2);
            }
            remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.o(this.a));
            if (!TextUtils.isEmpty(this.m)) {
                remoteViews.setImageViewBitmap(R.id.bd_push_iv_bg, com.baidu.android.pushservice.q.a.a().a(this.m));
            } else if (!TextUtils.isEmpty(this.n)) {
                remoteViews.setInt(R.id.bd_push_iv_bg, "setBackgroundColor", Color.parseColor(this.n));
            }
        } else {
            remoteViews.setViewVisibility(R.id.bd_push_lyt_notification_custom_head, 8);
        }
        if (!g()) {
            remoteViews.setViewPadding(R.id.bd_push_container, 0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(this.d)) {
            remoteViews.setViewVisibility(R.id.bd_push_tv_title, 8);
        } else {
            remoteViews.setTextViewText(R.id.bd_push_tv_title, this.d);
            remoteViews.setTextColor(R.id.bd_push_tv_title, this.h);
        }
        if (TextUtils.isEmpty(this.e)) {
            remoteViews.setViewVisibility(R.id.bd_push_tv_content, 8);
        } else {
            remoteViews.setTextViewText(R.id.bd_push_tv_content, this.e);
            remoteViews.setTextColor(R.id.bd_push_tv_content, this.i);
        }
        if (!TextUtils.isEmpty(this.l)) {
            Bitmap a = com.baidu.android.pushservice.q.a.a().a(this.l);
            if (a != null) {
                remoteViews.setImageViewBitmap(R.id.bd_push_iv_big_image, Utility.a(Utility.a(a, TypedValue.applyDimension(1, 306.0f, this.a.getResources().getDisplayMetrics()), TypedValue.applyDimension(1, 144.0f, this.a.getResources().getDisplayMetrics())), (int) TypedValue.applyDimension(1, 10.0f, this.a.getResources().getDisplayMetrics()), 0));
            } else {
                remoteViews.setViewVisibility(R.id.bd_push_iv_big_image, 8);
            }
        }
        return remoteViews;
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews c() {
        i();
        return a(R.layout.bd_push_notification_big_image);
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews d() {
        return a(R.layout.bd_push_notification_big_image_heads_up);
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        return true;
    }

    public void i() {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            if (jSONObject.has("title") && a()) {
                String optString = jSONObject.getJSONObject("title").optString("color");
                this.j = optString;
                this.h = Color.parseColor(optString);
            }
            if (jSONObject.has("description") && a()) {
                String optString2 = jSONObject.getJSONObject("description").optString("color");
                this.k = optString2;
                this.i = Color.parseColor(optString2);
            }
            if (jSONObject.has(NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
                this.n = jSONObject2.optString("color");
                this.m = jSONObject2.optString("url");
            }
            this.l = jSONObject.optString("big_img");
        } catch (Exception unused) {
        }
    }
}
