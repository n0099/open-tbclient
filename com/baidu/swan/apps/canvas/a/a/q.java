package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q extends a {
    private int amS = Integer.MAX_VALUE;
    private int amT = Integer.MAX_VALUE;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.amS = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.amT = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amS != Integer.MAX_VALUE && this.amT != Integer.MAX_VALUE) {
            bVar.mPath.moveTo(this.amS, this.amT);
        }
    }
}
