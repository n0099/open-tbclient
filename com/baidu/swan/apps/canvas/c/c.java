package com.baidu.swan.apps.canvas.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.z;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a {
    private int aGl;
    private int aGm;
    private int mHeight;
    private int mWidth;

    public c(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aGl = z.S((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.aGm = z.S((float) jSONObject.optDouble("y"));
            this.mWidth = z.S((float) jSONObject.optDouble("width"));
            this.mHeight = z.S((float) jSONObject.optDouble("height"));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "CanvasGetImageData meets json exception");
        }
    }

    public JSONObject V(@NonNull View view) {
        String str;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.aGl >= measuredWidth || this.aGm >= measuredHeight) {
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "x or y is out of canvas.");
            str = "";
        } else {
            this.aGl = this.aGl < 0 ? 0 : this.aGl;
            this.aGm = this.aGm < 0 ? 0 : this.aGm;
            this.mWidth = (this.mWidth <= 0 || this.aGl + this.mWidth > measuredWidth) ? measuredWidth - this.aGl : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.aGm + this.mHeight > measuredHeight) ? measuredHeight - this.aGm : this.mHeight;
            Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.translate(-this.aGl, -this.aGm);
            view.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.d("canvasGetImageData", "CanvasGetImageData meets IOException while closing stream");
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", z.U(this.mWidth));
            jSONObject.put("height", z.U(this.mHeight));
            jSONObject.put("data", str);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "CanvasGetImageData meets json exception");
        }
        return jSONObject;
    }
}
