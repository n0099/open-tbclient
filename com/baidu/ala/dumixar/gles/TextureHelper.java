package com.baidu.ala.dumixar.gles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
/* loaded from: classes14.dex */
public class TextureHelper {
    private static boolean DEBUG = false;
    private static final String TAG = "TextureHelper";

    /* loaded from: classes14.dex */
    public static class TextureBean {
        public int textureId = 0;
        public int width = 0;
        public int height = 0;
    }

    public static TextureBean loadTexture(Context context, int i, Bitmap bitmap) {
        TextureBean textureBean = new TextureBean();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            if (DEBUG) {
                Log.w(TAG, "Could not generate a new OpenGL texture object.");
            }
        } else {
            if (bitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
            }
            if (bitmap == null) {
                if (DEBUG) {
                    Log.w(TAG, "Resource ID $resourceId could not be decoded.");
                }
                GLES20.glDeleteTextures(1, iArr, 0);
            } else {
                GLES20.glBindTexture(3553, iArr[0]);
                GLES20.glTexParameteri(3553, 10241, 9987);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 10497);
                GLES20.glTexParameteri(3553, 10243, 10497);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                GLES20.glGenerateMipmap(3553);
                textureBean.width = bitmap.getWidth();
                textureBean.height = bitmap.getHeight();
                bitmap.recycle();
                GLES20.glBindTexture(3553, 0);
                textureBean.textureId = iArr[0];
            }
        }
        return textureBean;
    }
}
