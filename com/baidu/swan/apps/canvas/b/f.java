package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.ao.ah;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends a {
    private int cMY;
    private int cMZ;
    private int cMr;
    private int cMs;
    private float cNa;
    private String mFileType;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.mFileType = "png";
        this.cNa = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cMr = ah.O((float) jSONObject.optDouble("x"));
            this.cMs = ah.O((float) jSONObject.optDouble("y"));
            this.mWidth = ah.O((float) jSONObject.optDouble("width"));
            this.mHeight = ah.O((float) jSONObject.optDouble("height"));
            this.cMY = ah.O((float) jSONObject.optDouble("destWidth"));
            this.cMZ = ah.O((float) jSONObject.optDouble("destHeight"));
            this.mFileType = jSONObject.optString("fileType");
            this.cNa = (float) jSONObject.optDouble("quality");
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public boolean d(View view, String str) {
        boolean z = false;
        if (view == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Bitmap g = ah.g(view, view.getWidth(), view.getHeight());
            int width = g.getWidth();
            int height = g.getHeight();
            this.cMr = (this.cMr < 0 || this.cMr >= width) ? 0 : this.cMr;
            this.cMs = (this.cMs < 0 || this.cMs >= height) ? 0 : this.cMs;
            this.mWidth = (this.mWidth <= 0 || this.cMr + this.mWidth > width) ? width - this.cMr : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.cMs + this.mHeight > height) ? height - this.cMs : this.mHeight;
            this.cMY = this.cMY <= 0 ? this.mWidth : this.cMY;
            this.cMZ = this.cMZ <= 0 ? this.mHeight : this.cMZ;
            Bitmap createBitmap = Bitmap.createBitmap(this.cMY, this.cMZ, g.getConfig());
            new Canvas(createBitmap).drawBitmap(g, new Rect(this.cMr, this.cMs, this.cMr + this.mWidth, this.cMs + this.mHeight), new Rect(0, 0, this.cMY, this.cMZ), new Paint());
            Bitmap.CompressFormat compressFormat = aop() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.cNa * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            z = true;
            return true;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
                return z;
            }
            return z;
        } catch (OutOfMemoryError e2) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e2.printStackTrace();
                return z;
            }
            return z;
        }
    }

    public boolean aop() {
        return TextUtils.equals(this.mFileType, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
