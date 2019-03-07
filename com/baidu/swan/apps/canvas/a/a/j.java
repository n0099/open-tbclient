package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private int alA;
    private String aly;
    private int alz;
    private Bitmap mBitmap;
    private int mHeight;
    private Matrix mMatrix;
    private int mWidth;

    public j(String str) {
        this.aly = str;
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
    }

    public boolean wB() {
        try {
            JSONObject jSONObject = new JSONObject(this.aly);
            this.alz = com.baidu.swan.apps.an.x.ad((float) jSONObject.optDouble("x"));
            this.alA = com.baidu.swan.apps.an.x.ad((float) jSONObject.optDouble("y"));
            this.mWidth = com.baidu.swan.apps.an.x.ad((float) jSONObject.optDouble("width"));
            this.mHeight = com.baidu.swan.apps.an.x.ad((float) jSONObject.optDouble("height"));
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString)) {
                byte[] decode = Base64.decode(optString, 0);
                this.mBitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                int width = this.mBitmap.getWidth();
                int height = this.mBitmap.getHeight();
                this.alz = this.alz < 0 ? 0 : this.alz;
                this.alA = this.alA < 0 ? 0 : this.alA;
                if (this.mWidth > 0) {
                    width = this.mWidth;
                }
                this.mWidth = width;
                if (this.mHeight > 0) {
                    height = this.mHeight;
                }
                this.mHeight = height;
                this.mMatrix = new Matrix();
                this.mMatrix.postScale(this.mWidth / this.mBitmap.getWidth(), this.mHeight / this.mBitmap.getHeight());
                this.mMatrix.postTranslate(this.alz, this.alA);
            }
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
            return false;
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mBitmap != null && this.mMatrix != null) {
            canvas.drawBitmap(this.mBitmap, this.mMatrix, bVar.mBitmapPaint);
        }
    }
}
