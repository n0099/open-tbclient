package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.view.View;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends a {
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public c(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = ah.N((float) jSONObject.optDouble("x"));
            this.mY = ah.N((float) jSONObject.optDouble("y"));
            this.mWidth = ah.N((float) jSONObject.optDouble("width"));
            this.mHeight = ah.N((float) jSONObject.optDouble("height"));
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("canvasGetImageData", "CanvasGetImageData meets json exception", e);
        }
    }

    public JSONObject as(@NonNull View view) {
        int i;
        int i2 = 0;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        String str = "";
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            com.baidu.swan.apps.console.c.d("canvasGetImageData", "canvas size is invalid.");
            i = 0;
        } else {
            this.mX = (this.mX < 0 || this.mX >= measuredWidth) ? 0 : this.mX;
            this.mY = (this.mY < 0 || this.mY >= measuredHeight) ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > measuredWidth) ? measuredWidth - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > measuredHeight) ? measuredHeight - this.mY : this.mHeight;
            Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.translate(-this.mX, -this.mY);
            view.draw(canvas);
            Bitmap i3 = i(createBitmap);
            str = Base64.encodeToString(j(i3), 2);
            i = i3.getWidth();
            i2 = i3.getHeight();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            jSONObject.put("data", str);
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("canvasGetImageData", "CanvasGetImageData meets json exception", e);
        }
        return jSONObject;
    }

    @NonNull
    private Bitmap i(@NonNull Bitmap bitmap) {
        float density = 1.0f / ah.getDensity(com.baidu.swan.apps.t.a.awA());
        Matrix matrix = new Matrix();
        matrix.postScale(density, density);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private byte[] j(@NonNull Bitmap bitmap) {
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
