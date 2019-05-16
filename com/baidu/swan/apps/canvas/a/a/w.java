package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float ami;
    private float amj;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.ami = (float) jSONArray.optDouble(0);
            this.amj = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.ami > 0.0f && this.amj > 0.0f) {
            if (bVar.xq() == 0) {
                bVar.bQ(canvas.save());
            }
            canvas.scale(this.ami, this.amj);
        }
    }
}
