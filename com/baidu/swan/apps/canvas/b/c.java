package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ao.ah;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends a {
    private int cHF;
    private int cHG;
    private int mHeight;
    private int mWidth;

    public c(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cHF = ah.O((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.cHG = ah.O((float) jSONObject.optDouble("y"));
            this.mWidth = ah.O((float) jSONObject.optDouble("width"));
            this.mHeight = ah.O((float) jSONObject.optDouble("height"));
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("canvasGetImageData", "CanvasGetImageData meets json exception", e);
        }
    }

    public JSONObject aw(@NonNull View view) {
        int i;
        int i2;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        String str = "";
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "canvas size is invalid.");
            i = 0;
            i2 = 0;
        } else {
            this.cHF = (this.cHF < 0 || this.cHF >= measuredWidth) ? 0 : this.cHF;
            this.cHG = (this.cHG < 0 || this.cHG >= measuredHeight) ? 0 : this.cHG;
            this.mWidth = (this.mWidth <= 0 || this.cHF + this.mWidth > measuredWidth) ? measuredWidth - this.cHF : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.cHG + this.mHeight > measuredHeight) ? measuredHeight - this.cHG : this.mHeight;
            Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.translate(-this.cHF, -this.cHG);
            view.draw(canvas);
            Bitmap j = j(createBitmap);
            str = Base64.encodeToString(k(j), 2);
            i2 = j.getWidth();
            i = j.getHeight();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i2);
            jSONObject.put("height", i);
            jSONObject.put("data", str);
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("canvasGetImageData", "CanvasGetImageData meets json exception", e);
        }
        return jSONObject;
    }

    @NonNull
    private Bitmap j(@NonNull Bitmap bitmap) {
        float density = 1.0f / ah.getDensity(com.baidu.swan.apps.t.a.awy());
        Matrix matrix = new Matrix();
        matrix.postScale(density, density);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private byte[] k(@NonNull Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int length = iArr.length;
        byte[] bArr = new byte[length * 4];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            bArr[i * 4] = (byte) Color.red(i2);
            bArr[(i * 4) + 1] = (byte) Color.green(i2);
            bArr[(i * 4) + 2] = (byte) Color.blue(i2);
            bArr[(i * 4) + 3] = (byte) Color.alpha(i2);
        }
        return bArr;
    }
}
