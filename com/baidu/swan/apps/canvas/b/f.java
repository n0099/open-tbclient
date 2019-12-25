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
/* loaded from: classes9.dex */
public class f extends a {
    private int bcp;
    private int bcq;
    private String bcr;
    private float bcs;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.bcr = "png";
        this.bcs = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = af.T((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = af.T((float) jSONObject.optDouble("y"));
            this.mWidth = af.T((float) jSONObject.optDouble("width"));
            this.mHeight = af.T((float) jSONObject.optDouble("height"));
            this.bcp = af.T((float) jSONObject.optDouble("destWidth"));
            this.bcq = af.T((float) jSONObject.optDouble("destHeight"));
            this.bcr = jSONObject.optString("fileType");
            this.bcs = (float) jSONObject.optDouble("quality");
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
            this.bcp = this.bcp <= 0 ? this.mWidth : this.bcp;
            this.bcq = this.bcq <= 0 ? this.mHeight : this.bcq;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.bcp, this.bcq, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.bcp, this.bcq), new Paint());
            Bitmap.CompressFormat compressFormat = HJ() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.bcs * 100.0f), fileOutputStream);
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

    public boolean HJ() {
        return TextUtils.equals(this.bcr, "jpg");
    }

    public String HK() {
        return HJ() ? "jpg" : "png";
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
