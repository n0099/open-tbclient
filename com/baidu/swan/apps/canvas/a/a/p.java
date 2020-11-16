package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.support.v7.widget.ActivityChooserView;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class p extends a {
    private int mX = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int mY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.mX = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
            this.mY = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mX != Integer.MAX_VALUE && this.mY != Integer.MAX_VALUE) {
            bVar.mPath.lineTo(this.mX, this.mY);
        }
    }
}
