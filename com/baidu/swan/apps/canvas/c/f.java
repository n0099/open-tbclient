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
    private int aGl;
    private int aGm;
    private int aHa;
    private int aHb;
    private String aHc;
    private float aHd;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.aHc = "png";
        this.aHd = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aGl = z.S((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.aGm = z.S((float) jSONObject.optDouble("y"));
            this.mWidth = z.S((float) jSONObject.optDouble("width"));
            this.mHeight = z.S((float) jSONObject.optDouble("height"));
            this.aHa = z.S((float) jSONObject.optDouble("destWidth"));
            this.aHb = z.S((float) jSONObject.optDouble("destHeight"));
            this.aHc = jSONObject.optString("fileType");
            this.aHd = (float) jSONObject.optDouble("quality");
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
            this.aGl = (this.aGl < 0 || this.aGl >= width) ? 0 : this.aGl;
            this.aGm = (this.aGm < 0 || this.aGm >= height) ? 0 : this.aGm;
            this.mWidth = (this.mWidth <= 0 || this.aGl + this.mWidth > width) ? width - this.aGl : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.aGm + this.mHeight > height) ? height - this.aGm : this.mHeight;
            this.aHa = this.aHa <= 0 ? this.mWidth : this.aHa;
            this.aHb = this.aHb <= 0 ? this.mHeight : this.aHb;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.aHa, this.aHb, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.aGl, this.aGm, this.aGl + this.mWidth, this.aGm + this.mHeight), new Rect(0, 0, this.aHa, this.aHb), new Paint());
            Bitmap.CompressFormat compressFormat = CY() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.aHd * 100.0f), fileOutputStream);
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

    public boolean CY() {
        return TextUtils.equals(this.aHc, "jpg");
    }

    public String CZ() {
        return CY() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
