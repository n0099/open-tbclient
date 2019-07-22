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
    private int amu;
    private int amv;
    private int anl;
    private int anm;
    private String ann;
    private float ano;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.ann = "png";
        this.ano = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.amu = z.ad((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.amv = z.ad((float) jSONObject.optDouble("y"));
            this.mWidth = z.ad((float) jSONObject.optDouble("width"));
            this.mHeight = z.ad((float) jSONObject.optDouble("height"));
            this.anl = z.ad((float) jSONObject.optDouble("destWidth"));
            this.anm = z.ad((float) jSONObject.optDouble("destHeight"));
            this.ann = jSONObject.optString("fileType");
            this.ano = (float) jSONObject.optDouble("quality");
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
            this.amu = (this.amu < 0 || this.amu >= width) ? 0 : this.amu;
            this.amv = (this.amv < 0 || this.amv >= height) ? 0 : this.amv;
            this.mWidth = (this.mWidth <= 0 || this.amu + this.mWidth > width) ? width - this.amu : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.amv + this.mHeight > height) ? height - this.amv : this.mHeight;
            this.anl = this.anl <= 0 ? this.mWidth : this.anl;
            this.anm = this.anm <= 0 ? this.mHeight : this.anm;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.anl, this.anm, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.amu, this.amv, this.amu + this.mWidth, this.amv + this.mHeight), new Rect(0, 0, this.anl, this.anm), new Paint());
            Bitmap.CompressFormat compressFormat = xZ() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.ano * 100.0f), fileOutputStream);
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

    public boolean xZ() {
        return TextUtils.equals(this.ann, "jpg");
    }

    public String ya() {
        return xZ() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
