package com.baidu.swan.apps.canvas.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.z;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a {
    private int aFT;
    private int aFU;
    private int aGI;
    private int aGJ;
    private String aGK;
    private float aGL;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.aGK = "png";
        this.aGL = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aFT = z.S((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.aFU = z.S((float) jSONObject.optDouble("y"));
            this.mWidth = z.S((float) jSONObject.optDouble("width"));
            this.mHeight = z.S((float) jSONObject.optDouble("height"));
            this.aGI = z.S((float) jSONObject.optDouble("destWidth"));
            this.aGJ = z.S((float) jSONObject.optDouble("destHeight"));
            this.aGK = jSONObject.optString("fileType");
            this.aGL = (float) jSONObject.optDouble("quality");
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public boolean d(View view, String str) {
        if (view == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            view.destroyDrawingCache();
            int width = createBitmap.getWidth();
            int height = createBitmap.getHeight();
            this.aFT = (this.aFT < 0 || this.aFT >= width) ? 0 : this.aFT;
            this.aFU = (this.aFU < 0 || this.aFU >= height) ? 0 : this.aFU;
            this.mWidth = (this.mWidth <= 0 || this.aFT + this.mWidth > width) ? width - this.aFT : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.aFU + this.mHeight > height) ? height - this.aFU : this.mHeight;
            this.aGI = this.aGI <= 0 ? this.mWidth : this.aGI;
            this.aGJ = this.aGJ <= 0 ? this.mHeight : this.aGJ;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.aGI, this.aGJ, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.aFT, this.aFU, this.aFT + this.mWidth, this.aFU + this.mHeight), new Rect(0, 0, this.aGI, this.aGJ), new Paint());
            Bitmap.CompressFormat compressFormat = CZ() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.aGL * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            return false;
        } catch (OutOfMemoryError e2) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public boolean CZ() {
        return TextUtils.equals(this.aGK, "jpg");
    }

    public String Da() {
        return CZ() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
