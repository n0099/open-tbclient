package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class x extends a {
    private i bUb;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bUb = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bUb != null && this.bUb.isValid()) {
            if (this.bUb.WG()) {
                bVar.mFillPaint.setShader(this.bUb.WH());
                return;
            }
            bVar.bTw.setColor(this.bUb.getColor());
            bVar.mFillPaint.setColor(this.bUb.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
