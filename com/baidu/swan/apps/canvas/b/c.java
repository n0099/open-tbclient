package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.as.af;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public c(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = af.S((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = af.S((float) jSONObject.optDouble("y"));
            this.mWidth = af.S((float) jSONObject.optDouble("width"));
            this.mHeight = af.S((float) jSONObject.optDouble("height"));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "CanvasGetImageData meets json exception");
        }
    }

    public JSONObject af(@NonNull View view) {
        String str;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.mX >= measuredWidth || this.mY >= measuredHeight) {
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "x or y is out of canvas.");
            str = "";
        } else {
            this.mX = this.mX < 0 ? 0 : this.mX;
            this.mY = this.mY < 0 ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > measuredWidth) ? measuredWidth - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > measuredHeight) ? measuredHeight - this.mY : this.mHeight;
            Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.translate(-this.mX, -this.mY);
            view.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            com.baidu.swan.d.c.closeSafely(byteArrayOutputStream);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", af.U(this.mWidth));
            jSONObject.put("height", af.U(this.mHeight));
            jSONObject.put("data", str);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "CanvasGetImageData meets json exception");
        }
        return jSONObject;
    }
}
