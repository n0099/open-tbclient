package com.baidu.ar.util;

import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class ImageUtils {
    public static boolean saveYUVImage2Jpg(String str, byte[] bArr, int i, int i2) {
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 80, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
