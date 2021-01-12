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
/* loaded from: classes8.dex */
public class f extends a {
    private int cHF;
    private int cHG;
    private int cIm;
    private int cIn;
    private float cIo;
    private String mFileType;
    public int mHeight;
    private int mWidth;

    public f(String str) {
        super(str);
        this.mFileType = "png";
        this.cIo = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cHF = ah.O((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.cHG = ah.O((float) jSONObject.optDouble("y"));
            this.mWidth = ah.O((float) jSONObject.optDouble("width"));
            this.mHeight = ah.O((float) jSONObject.optDouble("height"));
            this.cIm = ah.O((float) jSONObject.optDouble("destWidth"));
            this.cIn = ah.O((float) jSONObject.optDouble("destHeight"));
            this.mFileType = jSONObject.optString("fileType");
            this.cIo = (float) jSONObject.optDouble("quality");
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
            this.cHF = (this.cHF < 0 || this.cHF >= width) ? 0 : this.cHF;
            this.cHG = (this.cHG < 0 || this.cHG >= height) ? 0 : this.cHG;
            this.mWidth = (this.mWidth <= 0 || this.cHF + this.mWidth > width) ? width - this.cHF : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.cHG + this.mHeight > height) ? height - this.cHG : this.mHeight;
            this.cIm = this.cIm <= 0 ? this.mWidth : this.cIm;
            this.cIn = this.cIn <= 0 ? this.mHeight : this.cIn;
            Bitmap createBitmap = Bitmap.createBitmap(this.cIm, this.cIn, g.getConfig());
            new Canvas(createBitmap).drawBitmap(g, new Rect(this.cHF, this.cHG, this.cHF + this.mWidth, this.cHG + this.mHeight), new Rect(0, 0, this.cIm, this.cIn), new Paint());
            Bitmap.CompressFormat compressFormat = akv() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.cIo * 100.0f), fileOutputStream);
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

    public boolean akv() {
        return TextUtils.equals(this.mFileType, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
