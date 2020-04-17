package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Region;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class g extends a {
    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        bVar.bEU = true;
        canvas.clipPath(bVar.mPath, Region.Op.INTERSECT);
    }
}
