package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTM;
    private Bitmap mBitmap;
    private Matrix mMatrix;

    public j(String str) {
        this.bTM = str;
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
    }

    public int WI() {
        try {
            JSONObject jSONObject = new JSONObject(this.bTM);
            int D = com.baidu.swan.apps.aq.ai.D((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            int D2 = com.baidu.swan.apps.aq.ai.D((float) jSONObject.optDouble("y"));
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            if (optInt <= 0 || optInt2 <= 0) {
                return 2002;
            }
            float D3 = com.baidu.swan.apps.aq.ai.D(optInt);
            float D4 = com.baidu.swan.apps.aq.ai.D(optInt2);
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return 2001;
            }
            try {
                byte[] decode = Base64.decode(optString, 2);
                int i = optInt * optInt2 * 4;
                if (decode == null || decode.length != i) {
                    return 2001;
                }
                this.mBitmap = a(n(decode, optInt, optInt2), D3, D4);
                this.mMatrix = new Matrix();
                this.mMatrix.postTranslate(D, D2);
                return 0;
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                return 1001;
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return 1001;
        }
    }

    @NonNull
    private Bitmap n(@NonNull byte[] bArr, int i, int i2) {
        int[] iArr = new int[i * i2];
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 4;
            iArr[i3] = Color.argb(bArr[i4 + 3] & 255, bArr[i4] & 255, bArr[i4 + 1] & 255, bArr[i4 + 2] & 255);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    @NonNull
    private Bitmap a(@NonNull Bitmap bitmap, float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.postScale(f / bitmap.getWidth(), f2 / bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.mBitmap != null && this.mMatrix != null) {
            canvas.drawBitmap(this.mBitmap, this.mMatrix, bVar.mBitmapPaint);
        }
    }
}
