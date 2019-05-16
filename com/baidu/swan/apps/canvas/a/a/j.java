package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String alQ;
    private int alR;
    private int alS;
    private Bitmap mBitmap;
    private int mHeight;
    private Matrix mMatrix;
    private int mWidth;

    public j(String str) {
        this.alQ = str;
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
    }

    public boolean xs() {
        try {
            JSONObject jSONObject = new JSONObject(this.alQ);
            this.alR = com.baidu.swan.apps.an.z.ad((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.alS = com.baidu.swan.apps.an.z.ad((float) jSONObject.optDouble("y"));
            this.mWidth = com.baidu.swan.apps.an.z.ad((float) jSONObject.optDouble("width"));
            this.mHeight = com.baidu.swan.apps.an.z.ad((float) jSONObject.optDouble("height"));
            String optString = jSONObject.optString("data");
            boolean z = !TextUtils.isEmpty(optString);
            if (z) {
                try {
                    byte[] decode = Base64.decode(optString, 2);
                    this.mBitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    int width = this.mBitmap.getWidth();
                    int height = this.mBitmap.getHeight();
                    this.alR = this.alR < 0 ? 0 : this.alR;
                    this.alS = this.alS >= 0 ? this.alS : 0;
                    this.mWidth = this.mWidth <= 0 ? width : this.mWidth;
                    this.mHeight = this.mHeight <= 0 ? height : this.mHeight;
                    this.mMatrix = new Matrix();
                    this.mMatrix.postScale(this.mWidth / this.mBitmap.getWidth(), this.mHeight / this.mBitmap.getHeight());
                    this.mMatrix.postTranslate(this.alR, this.alS);
                    return z;
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                    return z;
                }
            }
            return z;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
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
