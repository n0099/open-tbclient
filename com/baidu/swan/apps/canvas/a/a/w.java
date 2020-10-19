package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class w extends a {
    private float coc;
    private float cod;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.coc = (float) jSONArray.optDouble(0);
            this.cod = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.agf() == 0) {
            bVar.hj(canvas.save());
        }
        canvas.scale(this.coc, this.cod);
    }
}
