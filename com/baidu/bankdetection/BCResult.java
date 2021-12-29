package com.baidu.bankdetection;

import android.graphics.Bitmap;
import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/* loaded from: classes10.dex */
public class BCResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean bFlag;
    public int[] nBlankFlagArr;
    public int nDstHeight;
    public int nDstWidth;
    public int[] nLeftArr;
    public int nLineEnd;
    public int nLineStart;
    public int[] nRecogResultArr;
    public int[] nRectArr;
    public int[] nRightArr;
    public int nTotalRecogNum;
    public byte[] pbDstImg;

    public BCResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void drawRect(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{iArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            int i8 = i7 - i6;
            int i9 = i5 - i4;
            for (int i10 = 0; i10 < i8; i10++) {
                iArr[(i4 * i2) + i6 + i10] = -65536;
                iArr[(i5 * i2) + i6 + i10] = -65536;
            }
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = (i4 + i11) * i2;
                iArr[i12 + i6] = -65536;
                iArr[i12 + i7] = -65536;
            }
        }
    }

    public String cardNumberToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            for (int i2 = 0; i2 < this.nTotalRecogNum; i2++) {
                str = str + Integer.toString(this.nRecogResultArr[i2]);
                if (1 == this.nBlankFlagArr[i2]) {
                    str = str + " ";
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public Bitmap getDstRGBImage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            int[] iArr = new int[this.nDstWidth * this.nDstHeight];
            for (int i2 = 0; i2 < this.nDstWidth * this.nDstHeight; i2++) {
                byte[] bArr = this.pbDstImg;
                int i3 = i2 * 3;
                iArr[i2] = (-16777216) | ((bArr[i3 + 0] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
            }
            if (z) {
                for (int i4 = 0; i4 < this.nTotalRecogNum; i4++) {
                    drawRect(iArr, this.nDstWidth, this.nDstHeight, this.nLineStart, this.nLineEnd, this.nLeftArr[i4], this.nRightArr[i4]);
                }
            }
            return Bitmap.createBitmap(iArr, this.nDstWidth, this.nDstHeight, Bitmap.Config.ARGB_8888);
        }
        return (Bitmap) invokeZ.objValue;
    }

    public void saveImage() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        String str = "nLineStart = " + this.nLineStart + ", nLineEnd = " + this.nLineEnd;
        int i2 = this.nDstWidth * this.nDstHeight;
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = this.pbDstImg;
            int i4 = i3 * 3;
            iArr[i3] = (bArr[i4 + 2] & 255) | ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i4 + 1] & 255) << 8);
        }
        int i5 = 0;
        while (true) {
            int i6 = this.nDstWidth;
            if (i5 >= i6) {
                break;
            }
            iArr[(this.nLineStart * i6) + i5] = -65536;
            iArr[(this.nLineEnd * i6) + i5] = -65536;
            i5++;
        }
        int i7 = 0;
        while (true) {
            int i8 = this.nLineEnd;
            int i9 = this.nLineStart;
            if (i7 < i8 - i9) {
                int i10 = this.nDstWidth;
                int[] iArr2 = this.nLeftArr;
                iArr[((i9 + i7) * i10) + iArr2[0]] = -65536;
                int[] iArr3 = this.nRightArr;
                iArr[((i9 + i7) * i10) + iArr3[0]] = -65536;
                int i11 = this.nTotalRecogNum;
                iArr[((i9 + i7) * i10) + iArr2[i11 - 1]] = -65536;
                iArr[((i9 + i7) * i10) + iArr3[i11 - 1]] = -65536;
                i7++;
            } else {
                try {
                    Bitmap.createBitmap(iArr, this.nDstWidth, this.nDstHeight, Bitmap.Config.ARGB_8888).compress(Bitmap.CompressFormat.JPEG, 90, new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/bankcard/card.jpg")));
                    return;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public Bitmap drawRect(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int[] iArr2 = this.nRectArr;
            int i2 = iArr2[0] < 0 ? 0 : iArr2[0];
            int[] iArr3 = this.nRectArr;
            int i3 = width - 1;
            int i4 = iArr3[1] > i3 ? i3 : iArr3[1];
            int[] iArr4 = this.nRectArr;
            int i5 = iArr4[2] < 0 ? 0 : iArr4[2];
            int[] iArr5 = this.nRectArr;
            int i6 = height - 1;
            drawRect(iArr, width, height, i5, iArr5[3] > i6 ? i6 : iArr5[3], i2, i4);
            return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.RGB_565);
        }
        return (Bitmap) invokeL.objValue;
    }
}
