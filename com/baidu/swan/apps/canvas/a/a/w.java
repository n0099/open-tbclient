package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class w extends a {
    private float cHO;
    private float cHP;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cHO = (float) jSONArray.optDouble(0);
            this.cHP = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akq() == 0) {
            bVar.gl(canvas.save());
        }
        canvas.scale(this.cHO, this.cHP);
    }
}
