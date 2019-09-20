package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ai extends a {
    private int amF = 0;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "top")) {
                    this.amF = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.amF = 2;
                } else if (TextUtils.equals(optString, "bottom")) {
                    this.amF = 3;
                } else {
                    this.amF = 0;
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        bVar.amF = this.amF;
    }
}
