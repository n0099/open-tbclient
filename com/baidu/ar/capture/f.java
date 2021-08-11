package com.baidu.ar.capture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(AlgoHandleController algoHandleController, Bitmap[] bitmapArr, int i2) {
        InterceptResult invokeLLI;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList;
        int[] iArr;
        int[] iArr2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, algoHandleController, bitmapArr, i2)) == null) {
            long j2 = 0;
            if (bitmapArr == null || bitmapArr.length == 0) {
                return 0L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr3 = new int[bitmapArr.length];
            int[] iArr4 = new int[bitmapArr.length];
            int[] iArr5 = new int[bitmapArr.length];
            ArrayList arrayList2 = new ArrayList();
            int length = bitmapArr.length;
            long j3 = 0;
            int i7 = 0;
            while (i7 < length) {
                Bitmap bitmap = bitmapArr[i7];
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (j3 == j2) {
                    long createHandle = algoHandleController.createHandle();
                    i3 = height;
                    i4 = i7;
                    i5 = length;
                    arrayList = arrayList2;
                    iArr = iArr5;
                    iArr2 = iArr4;
                    algoHandleController.setHandleInput(createHandle, i2, currentTimeMillis, 4, width, i3, false, 0, false, null);
                    j3 = createHandle;
                    i6 = width;
                } else {
                    i3 = height;
                    i4 = i7;
                    i5 = length;
                    arrayList = arrayList2;
                    iArr = iArr5;
                    iArr2 = iArr4;
                    i6 = width;
                }
                iArr3[i4] = i6;
                int i8 = i3;
                int[] iArr6 = iArr2;
                iArr6[i4] = i8;
                iArr[i4] = 2;
                arrayList.add(a(bitmap));
                String str = "image w: " + i6 + " h: " + i8;
                i7 = i4 + 1;
                arrayList2 = arrayList;
                iArr5 = iArr;
                iArr4 = iArr6;
                length = i5;
                j2 = 0;
            }
            ReserveHandleData reserveHandleData = new ReserveHandleData();
            reserveHandleData.setByteDataSize(bitmapArr.length);
            reserveHandleData.setByteWidths(iArr3);
            reserveHandleData.setByteHeights(iArr4);
            reserveHandleData.setByteFormats(iArr5);
            reserveHandleData.setByteArrayListData(arrayList2);
            AlgoHandleAdapter.setHandleReserveData(j3, reserveHandleData);
            return j3;
        }
        return invokeLLI.longValue;
    }

    public static long a(AlgoHandleController algoHandleController, String[] strArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, algoHandleController, strArr, i2)) == null) {
            if (strArr == null || strArr.length == 0) {
                return 0L;
            }
            int length = strArr.length;
            Bitmap[] bitmapArr = new Bitmap[length];
            int length2 = strArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                byte[] decode = Base64.decode(strArr[i3], 0);
                bitmapArr[i3] = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
            long a2 = a(algoHandleController, bitmapArr, i2);
            for (int i4 = 0; i4 < length; i4++) {
                bitmapArr[i4].recycle();
            }
            return a2;
        }
        return invokeLLI.longValue;
    }

    public static byte[] a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) {
            byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight() * 4];
            bitmap.copyPixelsToBuffer(ByteBuffer.wrap(bArr));
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
