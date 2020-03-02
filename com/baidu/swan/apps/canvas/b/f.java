package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.as.af;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends a {
    private int bhu;
    private int bhv;
    private String bhw;
    private float bhx;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.bhw = "png";
        this.bhx = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = af.S((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = af.S((float) jSONObject.optDouble("y"));
            this.mWidth = af.S((float) jSONObject.optDouble("width"));
            this.mHeight = af.S((float) jSONObject.optDouble("height"));
            this.bhu = af.S((float) jSONObject.optDouble("destWidth"));
            this.bhv = af.S((float) jSONObject.optDouble("destHeight"));
            this.bhw = jSONObject.optString("fileType");
            this.bhx = (float) jSONObject.optDouble("quality");
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
            this.mX = (this.mX < 0 || this.mX >= width) ? 0 : this.mX;
            this.mY = (this.mY < 0 || this.mY >= height) ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > width) ? width - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > height) ? height - this.mY : this.mHeight;
            this.bhu = this.bhu <= 0 ? this.mWidth : this.bhu;
            this.bhv = this.bhv <= 0 ? this.mHeight : this.bhv;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.bhu, this.bhv, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.bhu, this.bhv), new Paint());
            Bitmap.CompressFormat compressFormat = Kw() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.bhx * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            com.baidu.swan.d.c.closeSafely(fileOutputStream);
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

    public boolean Kw() {
        return TextUtils.equals(this.bhw, "jpg");
    }

    public String Kx() {
        return Kw() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
