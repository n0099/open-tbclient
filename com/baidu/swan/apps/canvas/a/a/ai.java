package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ai extends a {
    private int alm = 0;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "top")) {
                    this.alm = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.alm = 2;
                } else if (TextUtils.equals(optString, "bottom")) {
                    this.alm = 3;
                } else {
                    this.alm = 0;
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        bVar.alm = this.alm;
    }
}
