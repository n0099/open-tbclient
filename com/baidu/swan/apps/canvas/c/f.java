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
    private int alF;
    private int alG;
    private int amw;
    private int amx;
    private String amy;
    private float amz;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.amy = "png";
        this.amz = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.alF = x.ad((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.alG = x.ad((float) jSONObject.optDouble("y"));
            this.mWidth = x.ad((float) jSONObject.optDouble("width"));
            this.mHeight = x.ad((float) jSONObject.optDouble("height"));
            this.amw = x.ad((float) jSONObject.optDouble("destWidth"));
            this.amx = x.ad((float) jSONObject.optDouble("destHeight"));
            this.amy = jSONObject.optString("fileType");
            this.amz = (float) jSONObject.optDouble("quality");
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
            this.alF = (this.alF < 0 || this.alF >= width) ? 0 : this.alF;
            this.alG = (this.alG < 0 || this.alG >= height) ? 0 : this.alG;
            this.mWidth = (this.mWidth <= 0 || this.alF + this.mWidth > width) ? width - this.alF : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.alG + this.mHeight > height) ? height - this.alG : this.mHeight;
            this.amw = this.amw <= 0 ? this.mWidth : this.amw;
            this.amx = this.amx <= 0 ? this.mHeight : this.amx;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.amw, this.amx, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.alF, this.alG, this.alF + this.mWidth, this.alG + this.mHeight), new Rect(0, 0, this.amw, this.amx), new Paint());
            Bitmap.CompressFormat compressFormat = wD() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.amz * 100.0f), fileOutputStream);
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

    public boolean wD() {
        return TextUtils.equals(this.amy, "jpg");
    }

    public String wE() {
        return wD() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
