package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes14.dex */
class f {
    public static long a(AlgoHandleController algoHandleController, Bitmap[] bitmapArr, int i) {
        if (bitmapArr == null || bitmapArr.length == 0) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        int[] iArr = new int[bitmapArr.length];
        int[] iArr2 = new int[bitmapArr.length];
        int[] iArr3 = new int[bitmapArr.length];
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int length = bitmapArr.length;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                ReserveHandleData reserveHandleData = new ReserveHandleData();
                reserveHandleData.setByteDataSize(bitmapArr.length);
                reserveHandleData.setByteWidths(iArr);
                reserveHandleData.setByteHeights(iArr2);
                reserveHandleData.setByteFormats(iArr3);
                reserveHandleData.setByteArrayListData(arrayList);
                AlgoHandleAdapter.setHandleReserveData(j, reserveHandleData);
                return j;
            }
            Bitmap bitmap = bitmapArr[i3];
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (j == 0) {
                j = algoHandleController.createHandle();
                algoHandleController.setHandleInput(j, i, currentTimeMillis, 4, width, height, false, 0, false, null);
            }
            iArr[i3] = width;
            iArr2[i3] = height;
            iArr3[i3] = 2;
            arrayList.add(b(bitmap));
            Log.d("ChildLook", "image w: " + width + " h: " + height);
            i2 = i3 + 1;
        }
    }

    public static long a(AlgoHandleController algoHandleController, String[] strArr, int i) {
        if (strArr == null || strArr.length == 0) {
            return 0L;
        }
        Bitmap[] bitmapArr = new Bitmap[strArr.length];
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte[] decode = Base64.decode(strArr[i2], 0);
            bitmapArr[i2] = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        long a2 = a(algoHandleController, bitmapArr, i);
        for (Bitmap bitmap : bitmapArr) {
            bitmap.recycle();
        }
        return a2;
    }

    private static byte[] b(Bitmap bitmap) {
        byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight() * 4];
        bitmap.copyPixelsToBuffer(ByteBuffer.wrap(bArr));
        return bArr;
    }
}
