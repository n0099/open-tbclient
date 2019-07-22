package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.support.v7.widget.ActivityChooserView;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p extends a {
    private int amu = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int amv = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.amu = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.amv = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amu != Integer.MAX_VALUE && this.amv != Integer.MAX_VALUE) {
            bVar.mPath.lineTo(this.amu, this.amv);
        }
    }
}
