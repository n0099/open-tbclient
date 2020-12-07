package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.ap.ah;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends a {
    private int cHC;
    private int cHD;
    private int cIh;
    private int cIi;
    private float cIj;
    private String mFileType;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.mFileType = "png";
        this.cIj = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cHC = ah.M((float) jSONObject.optDouble("x"));
            this.cHD = ah.M((float) jSONObject.optDouble("y"));
            this.mWidth = ah.M((float) jSONObject.optDouble("width"));
            this.mHeight = ah.M((float) jSONObject.optDouble("height"));
            this.cIh = ah.M((float) jSONObject.optDouble("destWidth"));
            this.cIi = ah.M((float) jSONObject.optDouble("destHeight"));
            this.mFileType = jSONObject.optString("fileType");
            this.cIj = (float) jSONObject.optDouble("quality");
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
            Bitmap c = ah.c(view, view.getWidth(), view.getHeight());
            int width = c.getWidth();
            int height = c.getHeight();
            this.cHC = (this.cHC < 0 || this.cHC >= width) ? 0 : this.cHC;
            this.cHD = (this.cHD < 0 || this.cHD >= height) ? 0 : this.cHD;
            this.mWidth = (this.mWidth <= 0 || this.cHC + this.mWidth > width) ? width - this.cHC : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.cHD + this.mHeight > height) ? height - this.cHD : this.mHeight;
            this.cIh = this.cIh <= 0 ? this.mWidth : this.cIh;
            this.cIi = this.cIi <= 0 ? this.mHeight : this.cIi;
            Bitmap createBitmap = Bitmap.createBitmap(this.cIh, this.cIi, c.getConfig());
            new Canvas(createBitmap).drawBitmap(c, new Rect(this.cHC, this.cHD, this.cHC + this.mWidth, this.cHD + this.mHeight), new Rect(0, 0, this.cIh, this.cIi), new Paint());
            Bitmap.CompressFormat compressFormat = anf() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.cIj * 100.0f), fileOutputStream);
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

    public boolean anf() {
        return TextUtils.equals(this.mFileType, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
