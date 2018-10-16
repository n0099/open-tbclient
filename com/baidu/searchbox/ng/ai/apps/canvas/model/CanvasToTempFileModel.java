package com.baidu.searchbox.ng.ai.apps.canvas.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasToTempFileModel extends CanvasBasicModel {
    public static final String IMAGE_EXT_JPG = "jpg";
    public static final String IMAGE_EXT_PNG = "png";
    private static final String KEY_DEST_HEIGHT = "destHeight";
    private static final String KEY_DEST_WIDTH = "destWidth";
    private static final String KEY_FILE_TYPE = "fileType";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_QUALITY = "quality";
    private static final String KEY_WIDTH = "width";
    private static final String KEY_X = "x";
    private static final String KEY_Y = "y";
    public static final int MAX_QUALITY = 100;
    private int mDstHeight;
    private int mDstWidth;
    private String mFileType;
    public int mHeight;
    private float mQuality;
    private int mWidth;
    private int mX;
    private int mY;

    public CanvasToTempFileModel(String str) {
        super(str);
        this.mFileType = IMAGE_EXT_PNG;
        this.mQuality = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mX = AiAppsUIUtils.dp2px((float) jSONObject.optDouble("x"));
            this.mY = AiAppsUIUtils.dp2px((float) jSONObject.optDouble("y"));
            this.mWidth = AiAppsUIUtils.dp2px((float) jSONObject.optDouble("width"));
            this.mHeight = AiAppsUIUtils.dp2px((float) jSONObject.optDouble("height"));
            this.mDstWidth = AiAppsUIUtils.dp2px((float) jSONObject.optDouble(KEY_DEST_WIDTH));
            this.mDstHeight = AiAppsUIUtils.dp2px((float) jSONObject.optDouble(KEY_DEST_HEIGHT));
            this.mFileType = jSONObject.optString("fileType");
            this.mQuality = (float) jSONObject.optDouble(KEY_QUALITY);
        } catch (Exception e) {
        }
    }

    public boolean toTempFilePath(View view, String str) {
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
            this.mDstWidth = this.mDstWidth <= 0 ? this.mWidth : this.mDstWidth;
            this.mDstHeight = this.mDstHeight <= 0 ? this.mHeight : this.mDstHeight;
            Bitmap createBitmap2 = Bitmap.createBitmap(this.mDstWidth, this.mDstHeight, createBitmap.getConfig());
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), new Rect(0, 0, this.mDstWidth, this.mDstHeight), new Paint());
            Bitmap.CompressFormat compressFormat = isJpgFile() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap2.compress(compressFormat, (int) (this.mQuality * 100.0f), fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception | OutOfMemoryError e) {
            return false;
        }
    }

    public boolean isJpgFile() {
        return TextUtils.equals(this.mFileType, IMAGE_EXT_JPG);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel, com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return this.mWidth > 0 && this.mHeight > 0;
    }
}
