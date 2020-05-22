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
    private int bOQ;
    private int bOR;
    private String bOS;
    private float bOT;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.bOS = "png";
        this.bOT = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = ag.B((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = ag.B((float) jSONObject.optDouble("y"));
            this.mWidth = ag.B((float) jSONObject.optDouble("width"));
            this.mHeight = ag.B((float) jSONObject.optDouble("height"));
            this.bOQ = ag.B((float) jSONObject.optDouble("destWidth"));
            this.bOR = ag.B((float) jSONObject.optDouble("destHeight"));
            this.bOS = jSONObject.optString("fileType");
            this.bOT = (float) jSONObject.optDouble("quality");
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
            this.bOQ = this.bOQ <= 0 ? this.mWidth : this.bOQ;
            this.bOR = this.bOR <= 0 ? this.mHeight : this.bOR;
            Bitmap createBitmap = Bitmap.createBitmap(this.bOQ, this.bOR, c.getConfig());
            new Canvas(createBitmap).drawBitmap(c, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.bOQ, this.bOR), new Paint());
            Bitmap.CompressFormat compressFormat = UY() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.bOT * 100.0f), fileOutputStream);
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

    public boolean UY() {
        return TextUtils.equals(this.bOS, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
