package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class t extends a {
    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        bVar.acK();
        try {
            canvas.restore();
        } catch (IllegalStateException e) {
            com.baidu.swan.apps.console.c.e("Canvas", "Underflow in restore - more restores than saves, please check", e);
        }
    }
}
