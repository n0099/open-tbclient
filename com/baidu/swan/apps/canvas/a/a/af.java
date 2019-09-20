package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class af extends a {
    private ak amD;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        this.amD = new ak(jSONArray);
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amD != null && this.amD.isValid()) {
            bVar.amD = this.amD;
        }
    }
}
