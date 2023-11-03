package com.baidu.android.pushservice.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends g {
    public i(Context context, int i, String str) {
        super(context, i, str);
    }

    @Override // com.baidu.android.pushservice.x.g
    public RemoteViews c() {
        String optString;
        Bitmap a;
        try {
            optString = new JSONObject(this.b).optString("url");
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), (int) R.layout.bd_push_layout_customs_notification_picture);
        if (a()) {
            remoteViews.setViewVisibility(R.id.bd_push_lyt_head, 0);
            String q = Utility.q(this.a);
            if (!TextUtils.isEmpty(this.f)) {
                q = q + "•" + this.f;
            }
            remoteViews.setTextViewText(R.id.bd_push_txv_app_name, q);
            remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.o(this.a));
            int i = this.h;
            if (i != Integer.MIN_VALUE) {
                remoteViews.setTextColor(R.id.bd_push_txv_app_name, i);
            }
        }
        if (!TextUtils.isEmpty(optString) && (a = com.baidu.android.pushservice.q.a.a().a(optString)) != null) {
            remoteViews.setImageViewBitmap(R.id.bd_push_img_bg, a);
            return remoteViews;
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        return true;
    }
}
