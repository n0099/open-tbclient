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
    private int alR;
    private int alS;
    private int amI;
    private int amJ;
    private String amK;
    private float amL;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.amK = "png";
        this.amL = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alR = z.ad((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.alS = z.ad((float) jSONObject.optDouble("y"));
            this.mWidth = z.ad((float) jSONObject.optDouble("width"));
            this.mHeight = z.ad((float) jSONObject.optDouble("height"));
            this.amI = z.ad((float) jSONObject.optDouble("destWidth"));
            this.amJ = z.ad((float) jSONObject.optDouble("destHeight"));
            this.amK = jSONObject.optString("fileType");
            this.amL = (float) jSONObject.optDouble("quality");
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
            this.alR = (this.alR < 0 || this.alR >= width) ? 0 : this.alR;
            this.alS = (this.alS < 0 || this.alS >= height) ? 0 : this.alS;
            this.mWidth = (this.mWidth <= 0 || this.alR + this.mWidth > width) ? width - this.alR : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.alS + this.mHeight > height) ? height - this.alS : this.mHeight;
            this.amI = this.amI <= 0 ? this.mWidth : this.amI;
            this.amJ = this.amJ <= 0 ? this.mHeight : this.amJ;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.amI, this.amJ, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.alR, this.alS, this.alR + this.mWidth, this.alS + this.mHeight), new Rect(0, 0, this.amI, this.amJ), new Paint());
            Bitmap.CompressFormat compressFormat = xv() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.amL * 100.0f), fileOutputStream);
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

    public boolean xv() {
        return TextUtils.equals(this.amK, "jpg");
    }

    public String xw() {
        return xv() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
