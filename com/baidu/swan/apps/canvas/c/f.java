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
    private int amS;
    private int amT;
    private int anJ;
    private int anK;
    private String anL;
    private float anM;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.anL = "png";
        this.anM = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.amS = z.ad((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.amT = z.ad((float) jSONObject.optDouble("y"));
            this.mWidth = z.ad((float) jSONObject.optDouble("width"));
            this.mHeight = z.ad((float) jSONObject.optDouble("height"));
            this.anJ = z.ad((float) jSONObject.optDouble("destWidth"));
            this.anK = z.ad((float) jSONObject.optDouble("destHeight"));
            this.anL = jSONObject.optString("fileType");
            this.anM = (float) jSONObject.optDouble("quality");
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
            this.amS = (this.amS < 0 || this.amS >= width) ? 0 : this.amS;
            this.amT = (this.amT < 0 || this.amT >= height) ? 0 : this.amT;
            this.mWidth = (this.mWidth <= 0 || this.amS + this.mWidth > width) ? width - this.amS : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.amT + this.mHeight > height) ? height - this.amT : this.mHeight;
            this.anJ = this.anJ <= 0 ? this.mWidth : this.anJ;
            this.anK = this.anK <= 0 ? this.mHeight : this.anK;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.anJ, this.anK, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.amS, this.amT, this.amS + this.mWidth, this.amT + this.mHeight), new Rect(0, 0, this.anJ, this.anK), new Paint());
            Bitmap.CompressFormat compressFormat = yd() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.anM * 100.0f), fileOutputStream);
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

    public boolean yd() {
        return TextUtils.equals(this.anL, "jpg");
    }

    public String ye() {
        return yd() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
