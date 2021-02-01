package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ao.ah;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends a {
    private float cKC;
    private int mDstHeight;
    private int mDstWidth;
    private String mFileType;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.mFileType = "png";
        this.cKC = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = ah.P((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = ah.P((float) jSONObject.optDouble("y"));
            this.mWidth = ah.P((float) jSONObject.optDouble("width"));
            this.mHeight = ah.P((float) jSONObject.optDouble("height"));
            this.mDstWidth = ah.P((float) jSONObject.optDouble("destWidth"));
            this.mDstHeight = ah.P((float) jSONObject.optDouble("destHeight"));
            this.mFileType = jSONObject.optString("fileType");
            this.cKC = (float) jSONObject.optDouble("quality");
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public boolean e(View view, String str) {
        boolean z = false;
        if (view == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Bitmap g = ah.g(view, view.getWidth(), view.getHeight());
            int width = g.getWidth();
            int height = g.getHeight();
            this.mX = (this.mX < 0 || this.mX >= width) ? 0 : this.mX;
            this.mY = (this.mY < 0 || this.mY >= height) ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > width) ? width - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > height) ? height - this.mY : this.mHeight;
            this.mDstWidth = this.mDstWidth <= 0 ? this.mWidth : this.mDstWidth;
            this.mDstHeight = this.mDstHeight <= 0 ? this.mHeight : this.mDstHeight;
            Bitmap createBitmap = Bitmap.createBitmap(this.mDstWidth, this.mDstHeight, g.getConfig());
            new Canvas(createBitmap).drawBitmap(g, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.mDstWidth, this.mDstHeight), new Paint());
            Bitmap.CompressFormat compressFormat = akT() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.cKC * 100.0f), fileOutputStream);
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

    public boolean akT() {
        return TextUtils.equals(this.mFileType, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
