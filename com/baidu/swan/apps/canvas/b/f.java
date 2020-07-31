package com.baidu.swan.apps.canvas.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.ai;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends a {
    private int bUw;
    private int bUx;
    private String bUy;
    private float bUz;
    public int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public f(String str) {
        super(str);
        this.bUy = "png";
        this.bUz = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = ai.D((float) jSONObject.optDouble(Config.EVENT_HEAT_X));
            this.mY = ai.D((float) jSONObject.optDouble("y"));
            this.mWidth = ai.D((float) jSONObject.optDouble("width"));
            this.mHeight = ai.D((float) jSONObject.optDouble("height"));
            this.bUw = ai.D((float) jSONObject.optDouble("destWidth"));
            this.bUx = ai.D((float) jSONObject.optDouble("destHeight"));
            this.bUy = jSONObject.optString("fileType");
            this.bUz = (float) jSONObject.optDouble("quality");
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
            Bitmap d = ai.d(view, view.getWidth(), view.getHeight());
            int width = d.getWidth();
            int height = d.getHeight();
            this.mX = (this.mX < 0 || this.mX >= width) ? 0 : this.mX;
            this.mY = (this.mY < 0 || this.mY >= height) ? 0 : this.mY;
            this.mWidth = (this.mWidth <= 0 || this.mX + this.mWidth > width) ? width - this.mX : this.mWidth;
            this.mHeight = (this.mHeight <= 0 || this.mY + this.mHeight > height) ? height - this.mY : this.mHeight;
            this.bUw = this.bUw <= 0 ? this.mWidth : this.bUw;
            this.bUx = this.bUx <= 0 ? this.mHeight : this.bUx;
            Bitmap createBitmap = Bitmap.createBitmap(this.bUw, this.bUx, d.getConfig());
            new Canvas(createBitmap).drawBitmap(d, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.bUw, this.bUx), new Paint());
            Bitmap.CompressFormat compressFormat = WL() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(compressFormat, (int) (this.bUz * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            com.baidu.swan.d.d.closeSafely(fileOutputStream);
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

    public boolean WL() {
        return TextUtils.equals(this.bUy, "jpg");
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
