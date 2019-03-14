package com.baidu.swan.apps.canvas.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.x;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a {
    private int alA;
    private int alB;
    private int amr;
    private int ams;
    private String amt;
    private float amu;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.amt = "png";
        this.amu = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alA = x.ad((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.alB = x.ad((float) jSONObject.optDouble("y"));
            this.mWidth = x.ad((float) jSONObject.optDouble("width"));
            this.mHeight = x.ad((float) jSONObject.optDouble("height"));
            this.amr = x.ad((float) jSONObject.optDouble("destWidth"));
            this.ams = x.ad((float) jSONObject.optDouble("destHeight"));
            this.amt = jSONObject.optString("fileType");
            this.amu = (float) jSONObject.optDouble("quality");
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
            this.alA = (this.alA < 0 || this.alA >= width) ? 0 : this.alA;
            this.alB = (this.alB < 0 || this.alB >= height) ? 0 : this.alB;
            this.mWidth = (this.mWidth <= 0 || this.alA + this.mWidth > width) ? width - this.alA : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.alB + this.mHeight > height) ? height - this.alB : this.mHeight;
            this.amr = this.amr <= 0 ? this.mWidth : this.amr;
            this.ams = this.ams <= 0 ? this.mHeight : this.ams;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.amr, this.ams, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.alA, this.alB, this.alA + this.mWidth, this.alB + this.mHeight), new Rect(0, 0, this.amr, this.ams), new Paint());
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
            createBitmap2.compress(compressFormat, (int) (this.amu * 100.0f), fileOutputStream);
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

    public boolean wE() {
        return TextUtils.equals(this.amt, "jpg");
    }

    public String wF() {
        return wE() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
