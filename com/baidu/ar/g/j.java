package com.baidu.ar.g;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class j {
    public static Bitmap a(int i, int i2, byte[] bArr) {
        if (bArr.length <= 0) {
            return null;
        }
        int[] iArr = new int[bArr.length / 4];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = ((bArr[(i3 * 4) + 0] & 255) << 16) | ((bArr[(i3 * 4) + 3] & 255) << 24) | ((bArr[(i3 * 4) + 1] & 255) << 8) | (bArr[(i3 * 4) + 2] & 255);
        }
        return Bitmap.createBitmap(iArr, 0, i, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static byte[] c(Bitmap bitmap) {
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
