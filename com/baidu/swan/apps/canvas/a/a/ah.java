package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ah extends a {
    private Paint.Align amU;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, CustomDialogData.POS_LEFT)) {
                    this.amU = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.amU = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, "right")) {
                    this.amU = Paint.Align.RIGHT;
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amU != null) {
            bVar.amc.setTextAlign(this.amU);
        }
    }
}
