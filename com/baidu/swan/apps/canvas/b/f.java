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
/* loaded from: classes3.dex */
public class f extends a {
    private int ccj;
    private int cck;
    private String ccl;
    private float ccm;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.ccl = "png";
        this.ccm = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = ah.H((float) jSONObject.optDouble("x"));
            this.mY = ah.H((float) jSONObject.optDouble("y"));
            this.mWidth = ah.H((float) jSONObject.optDouble("width"));
            this.mHeight = ah.H((float) jSONObject.optDouble("height"));
            this.ccj = ah.H((float) jSONObject.optDouble("destWidth"));
            this.cck = ah.H((float) jSONObject.optDouble("destHeight"));
            this.ccl = jSONObject.optString("fileType");
            this.ccm = (float) jSONObject.optDouble("quality");
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
            this.mX = (this.mX < 0 || this.mX >= width) ? 0 : this.mX;
            this.mY = (this.mY < 0 || this.mY >= height) ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > width) ? width - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > height) ? height - this.mY : this.mHeight;
            this.ccj = this.ccj <= 0 ? this.mWidth : this.ccj;
            this.cck = this.cck <= 0 ? this.mHeight : this.cck;
            Bitmap createBitmap = Bitmap.createBitmap(this.ccj, this.cck, c.getConfig());
            new Canvas(createBitmap).drawBitmap(c, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.ccj, this.cck), new Paint());
            Bitmap.CompressFormat compressFormat = adA() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.ccm * 100.0f), fileOutputStream);
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

    public boolean adA() {
        return TextUtils.equals(this.ccl, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
