package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import androidx.appcompat.widget.ActivityChooserView;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class q extends a {
    private int cMr = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cMs = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cMr = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cMs = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cMr != Integer.MAX_VALUE && this.cMs != Integer.MAX_VALUE) {
            bVar.mPath.moveTo(this.cMr, this.cMs);
        }
    }
}
