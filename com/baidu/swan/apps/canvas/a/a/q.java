package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.support.v7.widget.ActivityChooserView;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q extends a {
    private int alA = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int alB = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.alA = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            this.alB = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alA != Integer.MAX_VALUE && this.alB != Integer.MAX_VALUE) {
            bVar.mPath.moveTo(this.alA, this.alB);
        }
    }
}
