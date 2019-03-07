package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Region;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g extends a {
    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        bVar.alh = true;
        canvas.clipPath(bVar.mPath, Region.Op.INTERSECT);
    }
}
