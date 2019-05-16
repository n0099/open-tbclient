package com.baidu.swan.impl.map.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class b {
    public static Bitmap G(String str, boolean z) {
        Bitmap bitmap = null;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            String a = com.baidu.swan.apps.storage.b.a(str, Lq, Lq.getVersion());
            if (!TextUtils.isEmpty(a)) {
                bitmap = kg(a);
            }
        }
        if (bitmap == null && z) {
            Bitmap decodeResource = BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.pin_red);
            com.baidu.swan.apps.console.c.w("map", "file not exist, use default");
            return decodeResource;
        }
        return bitmap;
    }

    public static Bitmap c(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
            bitmap2 = null;
        }
        return bitmap2;
    }

    private static Bitmap kg(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, new BitmapFactory.Options());
            com.baidu.swan.c.a.c(fileInputStream);
            return decodeStream;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}
