package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.ag;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends a {
    private int bTE;
    private int bTF;
    private String bTG;
    private float bTH;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.bTG = "png";
        this.bTH = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = ag.D((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = ag.D((float) jSONObject.optDouble("y"));
            this.mWidth = ag.D((float) jSONObject.optDouble("width"));
            this.mHeight = ag.D((float) jSONObject.optDouble("height"));
            this.bTE = ag.D((float) jSONObject.optDouble("destWidth"));
            this.bTF = ag.D((float) jSONObject.optDouble("destHeight"));
            this.bTG = jSONObject.optString("fileType");
            this.bTH = (float) jSONObject.optDouble("quality");
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
            Bitmap c = ag.c(view, view.getWidth(), view.getHeight());
            int width = c.getWidth();
            int height = c.getHeight();
            this.mX = (this.mX < 0 || this.mX >= width) ? 0 : this.mX;
            this.mY = (this.mY < 0 || this.mY >= height) ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > width) ? width - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > height) ? height - this.mY : this.mHeight;
            this.bTE = this.bTE <= 0 ? this.mWidth : this.bTE;
            this.bTF = this.bTF <= 0 ? this.mHeight : this.bTF;
            Bitmap createBitmap = Bitmap.createBitmap(this.bTE, this.bTF, c.getConfig());
            new Canvas(createBitmap).drawBitmap(c, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.bTE, this.bTF), new Paint());
            Bitmap.CompressFormat compressFormat = We() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.bTH * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            com.baidu.swan.e.d.closeSafely(fileOutputStream);
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

    public boolean We() {
        return TextUtils.equals(this.bTG, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
