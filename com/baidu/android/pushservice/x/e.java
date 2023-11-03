package com.baidu.android.pushservice.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends g {
    public boolean j;
    public String k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public int p;
    public float q;
    public String r;
    public String s;

    public e(Context context, int i, String str) {
        super(context, i, str);
        this.j = false;
        this.o = false;
    }

    public final boolean a(int i) {
        return (i >> 28) == 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0180, code lost:
        if (r3 > 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019b, code lost:
        if (r3 > 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x019d, code lost:
        r0 = com.baidu.android.pushservice.util.Utility.a(r0, true, r3 * r0.getWidth());
     */
    @Override // com.baidu.android.pushservice.x.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RemoteViews c() {
        String str;
        float f;
        i();
        RemoteViews remoteViews = new RemoteViews(this.c, (int) R.layout.bd_push_notification_double_icon);
        if (h()) {
            if (TextUtils.isEmpty(this.f)) {
                str = Utility.q(this.a);
            } else {
                str = Utility.q(this.a) + "•" + this.f;
            }
            remoteViews.setTextViewText(R.id.bd_push_txv_app_name, str);
            int i = this.h;
            if (i != Integer.MIN_VALUE) {
                remoteViews.setTextColor(R.id.bd_push_txv_app_name, i);
            }
            remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.o(this.a));
        } else {
            int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, this.a.getResources().getDisplayMetrics());
            remoteViews.setViewPadding(R.id.bd_push_container, applyDimension, applyDimension, applyDimension, applyDimension);
            remoteViews.setViewVisibility(R.id.bd_push_lyt_notification_custom_head, 8);
        }
        if (!g()) {
            remoteViews.setViewPadding(R.id.bd_push_container, 0, 0, 0, 0);
        }
        if (j()) {
            int applyDimension2 = (int) TypedValue.applyDimension(1, 4.0f, this.a.getResources().getDisplayMetrics());
            remoteViews.setViewPadding(R.id.bd_push_container, applyDimension2, applyDimension2, applyDimension2, applyDimension2);
            remoteViews.setViewPadding(R.id.bd_push_lyt_notification_custom_head, 0, applyDimension2, 0, 0);
        }
        if (f()) {
            if (!TextUtils.isEmpty(this.s)) {
                remoteViews.setImageViewBitmap(R.id.bd_push_iv_bg, com.baidu.android.pushservice.q.a.a().a(this.s));
            } else if (!TextUtils.isEmpty(this.r)) {
                try {
                    remoteViews.setInt(R.id.bd_push_iv_bg, "setBackgroundColor", Color.parseColor(this.r));
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        Bitmap a = TextUtils.isEmpty(this.g) ? null : com.baidu.android.pushservice.q.a.a().a(this.g);
        if (a == null || this.p != 1) {
            remoteViews.setViewVisibility(R.id.bd_push_left_icon, 8);
        } else {
            float f2 = this.q;
            if (f2 > 0.0f) {
                a = Utility.a(a, true, f2 * a.getWidth());
            }
            remoteViews.setImageViewBitmap(R.id.bd_push_left_icon, a);
        }
        if (!TextUtils.isEmpty(this.d)) {
            remoteViews.setTextViewText(R.id.bd_push_tv_title, this.d);
            int i2 = this.h;
            if (i2 != Integer.MIN_VALUE) {
                remoteViews.setTextColor(R.id.bd_push_tv_title, i2);
            }
            if (this.j) {
                remoteViews.setViewVisibility(R.id.bd_push_iv_title_red_dot, 0);
            }
        }
        if (!TextUtils.isEmpty(this.k)) {
            remoteViews.setTextViewText(R.id.bd_push_tv_msg_hl, this.k);
        }
        if (!TextUtils.isEmpty(this.e)) {
            remoteViews.setTextViewText(R.id.bd_push_tv_msg, this.e);
            int i3 = this.i;
            if (i3 != Integer.MIN_VALUE) {
                remoteViews.setTextColor(R.id.bd_push_tv_msg, i3);
            }
        }
        if (a != null && this.p == 0) {
            f = this.q;
        } else if (!TextUtils.isEmpty(this.n)) {
            a = com.baidu.android.pushservice.q.a.a().a(this.n);
            if (a != null) {
                f = this.q;
            }
            remoteViews.setImageViewBitmap(R.id.bd_push_right_icon, a);
            remoteViews.setViewVisibility(R.id.bd_push_tv_btn_txt, 8);
            remoteViews.setViewVisibility(R.id.bd_push_im_btn_bg, 8);
        } else if (TextUtils.isEmpty(this.l)) {
            remoteViews.setViewVisibility(R.id.bd_push_rl_right_area, 8);
        } else {
            remoteViews.setTextViewText(R.id.bd_push_tv_btn_txt, this.l);
            remoteViews.setViewVisibility(R.id.bd_push_right_icon, 8);
            if (this.o) {
                remoteViews.setViewVisibility(R.id.bd_push_iv_button_red_dot, 0);
            }
            if (!TextUtils.isEmpty(this.m)) {
                Bitmap a2 = Utility.a((int) TypedValue.applyDimension(1, 75.0f, this.a.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, this.a.getResources().getDisplayMetrics()), this.m);
                remoteViews.setImageViewBitmap(R.id.bd_push_im_btn_bg, Utility.a(a2, a2.getHeight() / 2, 0));
            }
        }
        return remoteViews;
    }

    @Override // com.baidu.android.pushservice.x.g
    public boolean e() {
        return (Utility.S(this.a) || Utility.N(this.a) || Utility.M(this.a) || Utility.P(this.a)) ? false : true;
    }

    public void i() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            if (jSONObject.has("title")) {
                String optString = jSONObject.getJSONObject("title").optString("color");
                if (!TextUtils.isEmpty(optString) && f()) {
                    this.h = Color.parseColor(optString);
                }
                this.j = a(jSONObject.getJSONObject("title").optInt("badge"));
            }
            if (jSONObject.has("description")) {
                String optString2 = jSONObject.getJSONObject("description").optString("color");
                if (!TextUtils.isEmpty(optString2) && f()) {
                    this.i = Color.parseColor(optString2);
                }
            }
            if (jSONObject.has("hl")) {
                this.k = jSONObject.getJSONObject("hl").optString("txt");
            }
            if (jSONObject.has(NativeConstants.ID_BUTTON)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(NativeConstants.ID_BUTTON);
                this.l = jSONObject2.optString("txt");
                this.o = a(jSONObject2.optInt("badge"));
                this.m = jSONObject2.optString("bg_color");
                this.n = jSONObject2.optString("img");
            }
            if (jSONObject.has("img")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("img");
                this.p = jSONObject3.optInt("pos");
                this.q = (float) jSONObject3.optDouble("border_radius");
            }
            if (jSONObject.has(NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
                this.r = jSONObject4.optString("color");
                this.s = jSONObject4.optString("url");
            }
        } catch (Exception unused) {
        }
    }

    public final boolean j() {
        return Utility.T(this.a) && Utility.a().contains("12.5.16");
    }
}
