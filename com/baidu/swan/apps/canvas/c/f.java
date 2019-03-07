package com.baidu.swan.apps.canvas.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.an.x;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a {
    private int alA;
    private int alz;
    private int amq;
    private int amr;
    private String ams;
    private float amt;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.ams = "png";
        this.amt = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alz = x.ad((float) jSONObject.optDouble("x"));
            this.alA = x.ad((float) jSONObject.optDouble("y"));
            this.mWidth = x.ad((float) jSONObject.optDouble("width"));
            this.mHeight = x.ad((float) jSONObject.optDouble("height"));
            this.amq = x.ad((float) jSONObject.optDouble("destWidth"));
            this.amr = x.ad((float) jSONObject.optDouble("destHeight"));
            this.ams = jSONObject.optString("fileType");
            this.amt = (float) jSONObject.optDouble("quality");
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
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
            this.alz = (this.alz < 0 || this.alz >= width) ? 0 : this.alz;
            this.alA = (this.alA < 0 || this.alA >= height) ? 0 : this.alA;
            this.mWidth = (this.mWidth <= 0 || this.alz + this.mWidth > width) ? width - this.alz : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.alA + this.mHeight > height) ? height - this.alA : this.mHeight;
            this.amq = this.amq <= 0 ? this.mWidth : this.amq;
            this.amr = this.amr <= 0 ? this.mHeight : this.amr;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.amq, this.amr, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.alz, this.alA, this.alz + this.mWidth, this.alA + this.mHeight), new Rect(0, 0, this.amq, this.amr), new Paint());
            Bitmap.CompressFormat compressFormat = wE() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.amt * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
            return false;
        } catch (OutOfMemoryError e2) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public boolean wE() {
        return TextUtils.equals(this.ams, "jpg");
    }

    public String wF() {
        return wE() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
