package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.support.v7.widget.ActivityChooserView;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class q extends a {
    private int cHC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cHD = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cHC = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            this.cHD = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHC != Integer.MAX_VALUE && this.cHD != Integer.MAX_VALUE) {
            bVar.mPath.moveTo(this.cHC, this.cHD);
        }
    }
}
