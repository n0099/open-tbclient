package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class q extends a {
    private int mX = Integer.MAX_VALUE;
    private int mY = Integer.MAX_VALUE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.mX = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(0));
            this.mY = com.baidu.swan.apps.ao.ah.T((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mX != Integer.MAX_VALUE && this.mY != Integer.MAX_VALUE) {
            bVar.mPath.moveTo(this.mX, this.mY);
        }
    }
}
