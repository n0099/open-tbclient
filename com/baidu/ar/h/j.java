package com.baidu.ar.h;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j {
    public static Bitmap a(int i, int i2, byte[] bArr) {
        if (bArr.length <= 0) {
            return null;
        }
        int length = bArr.length / 4;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 4;
            iArr[i3] = ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 0] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8) | (bArr[i4 + 2] & 255);
        }
        return Bitmap.createBitmap(iArr, 0, i, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static byte[] b(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static byte[] c(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
