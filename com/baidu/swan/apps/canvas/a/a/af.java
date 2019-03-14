package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class af extends a {
    private ak alk;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        this.alk = new ak(jSONArray);
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alk != null && this.alk.isValid()) {
            bVar.alk = this.alk;
        }
    }
}
