package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import androidx.appcompat.widget.ActivityChooserView;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class p extends a {
    private int cHF = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cHG = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cHF = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cHG = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHF != Integer.MAX_VALUE && this.cHG != Integer.MAX_VALUE) {
            bVar.mPath.lineTo(this.cHF, this.cHG);
        }
    }
}
