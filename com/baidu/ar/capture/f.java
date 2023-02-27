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
/* loaded from: classes.dex */
public class f {
    public static long a(AlgoHandleController algoHandleController, Bitmap[] bitmapArr, int i) {
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        int[] iArr;
        int[] iArr2;
        int i5;
        long j = 0;
        if (bitmapArr == null || bitmapArr.length == 0) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr3 = new int[bitmapArr.length];
        int[] iArr4 = new int[bitmapArr.length];
        int[] iArr5 = new int[bitmapArr.length];
        ArrayList arrayList2 = new ArrayList();
        int length = bitmapArr.length;
        long j2 = 0;
        int i6 = 0;
        while (i6 < length) {
            Bitmap bitmap = bitmapArr[i6];
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (j2 == j) {
                long createHandle = algoHandleController.createHandle();
                i2 = height;
                i3 = i6;
                i4 = length;
                arrayList = arrayList2;
                iArr = iArr5;
                iArr2 = iArr4;
                algoHandleController.setHandleInput(createHandle, i, currentTimeMillis, 4, width, i2, false, 0, false, null);
                j2 = createHandle;
                i5 = width;
            } else {
                i2 = height;
                i3 = i6;
                i4 = length;
                arrayList = arrayList2;
                iArr = iArr5;
                iArr2 = iArr4;
                i5 = width;
            }
            iArr3[i3] = i5;
            int i7 = i2;
            int[] iArr6 = iArr2;
            iArr6[i3] = i7;
            iArr[i3] = 2;
            arrayList.add(a(bitmap));
            Log.d("ChildLook", "image w: " + i5 + " h: " + i7);
            i6 = i3 + 1;
            arrayList2 = arrayList;
            iArr5 = iArr;
            iArr4 = iArr6;
            length = i4;
            j = 0;
        }
        ReserveHandleData reserveHandleData = new ReserveHandleData();
        reserveHandleData.setByteDataSize(bitmapArr.length);
        reserveHandleData.setByteWidths(iArr3);
        reserveHandleData.setByteHeights(iArr4);
        reserveHandleData.setByteFormats(iArr5);
        reserveHandleData.setByteArrayListData(arrayList2);
        AlgoHandleAdapter.setHandleReserveData(j2, reserveHandleData);
        return j2;
    }

    public static long a(AlgoHandleController algoHandleController, String[] strArr, int i) {
        if (strArr == null || strArr.length == 0) {
            return 0L;
        }
        int length = strArr.length;
        Bitmap[] bitmapArr = new Bitmap[length];
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            byte[] decode = Base64.decode(strArr[i2], 0);
            bitmapArr[i2] = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        long a = a(algoHandleController, bitmapArr, i);
        for (int i3 = 0; i3 < length; i3++) {
            bitmapArr[i3].recycle();
        }
        return a;
    }

    public static byte[] a(Bitmap bitmap) {
        byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight() * 4];
        bitmap.copyPixelsToBuffer(ByteBuffer.wrap(bArr));
        return bArr;
    }
}
