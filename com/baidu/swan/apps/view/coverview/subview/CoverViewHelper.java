package com.baidu.swan.apps.view.coverview.subview;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoverViewHelper {
    private static final boolean DEBUG = b.DEBUG;
    protected com.baidu.swan.apps.view.coverview.a bvq;
    private a bvr = new a();

    /* loaded from: classes2.dex */
    public enum Type {
        TEXT,
        IMAGE
    }

    /* loaded from: classes2.dex */
    public static class a {
        public float x;
        public float y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ax(final View view) {
        if (!com.baidu.swan.apps.view.container.b.b.Vg()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.coverview.subview.CoverViewHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CoverViewHelper.this.bvq != null) {
                        CoverViewHelper.this.bvq.a(2, view, null);
                    }
                }
            });
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.view.coverview.subview.CoverViewHelper.2
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        CoverViewHelper.this.bvr.x = motionEvent.getRawX();
                        CoverViewHelper.this.bvr.y = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        if (this.bvq != aVar) {
            this.bvq = aVar;
        }
    }

    public com.baidu.swan.apps.view.coverview.a Vk() {
        return this.bvq;
    }

    public void a(@NonNull View view, @NonNull JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("padding");
        if (optJSONArray != null && optJSONArray.length() == 4) {
            view.setPadding(z.S((float) optJSONArray.optDouble(3, 0.0d)), z.S((float) optJSONArray.optDouble(0, 0.0d)), z.S((float) optJSONArray.optDouble(1, 0.0d)), z.S((float) optJSONArray.optDouble(2, 0.0d)));
        }
    }

    public void b(@NonNull View view, @NonNull JSONObject jSONObject) {
        float a2 = o.a(jSONObject, "opacity", -1.0f);
        if (a2 >= 0.0f && a2 <= 1.0f) {
            view.setAlpha(a2);
        }
    }

    public void c(@NonNull View view, @NonNull JSONObject jSONObject) {
        int i;
        int i2 = 0;
        try {
            i = Color.parseColor(jSONObject.optString("bgColor"));
        } catch (Exception e) {
            c.e("CoverView", "bgColor occurs exception", e);
            i = 0;
        }
        int optInt = jSONObject.optInt("borderWidth");
        try {
            i2 = Color.parseColor(jSONObject.optString("borderColor"));
        } catch (Exception e2) {
            c.e("CoverView", "borderColor occurs exception", e2);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(aO(jSONObject));
        gradientDrawable.setStroke(optInt, i2);
        view.setBackground(gradientDrawable);
    }

    public int aO(@NonNull JSONObject jSONObject) {
        return z.S(jSONObject.optInt("borderRadius"));
    }

    public a getClickPosition() {
        return this.bvr;
    }
}
