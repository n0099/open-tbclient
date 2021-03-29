package com.baidu.bankdetection;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public class BCResult {
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

    private void drawRect(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i6 - i5;
        int i8 = i4 - i3;
        for (int i9 = 0; i9 < i7; i9++) {
            iArr[(i3 * i) + i5 + i9] = -65536;
            iArr[(i4 * i) + i5 + i9] = -65536;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = (i3 + i10) * i;
            iArr[i11 + i5] = -65536;
            iArr[i11 + i6] = -65536;
        }
    }

    public String cardNumberToString() {
        String str = "";
        for (int i = 0; i < this.nTotalRecogNum; i++) {
            str = str + Integer.toString(this.nRecogResultArr[i]);
            if (1 == this.nBlankFlagArr[i]) {
                str = str + " ";
            }
        }
        return str;
    }

    public Bitmap getDstRGBImage(boolean z) {
        int[] iArr = new int[this.nDstWidth * this.nDstHeight];
        for (int i = 0; i < this.nDstWidth * this.nDstHeight; i++) {
            byte[] bArr = this.pbDstImg;
            int i2 = i * 3;
            iArr[i] = (-16777216) | ((bArr[i2 + 0] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
        }
        if (z) {
            for (int i3 = 0; i3 < this.nTotalRecogNum; i3++) {
                drawRect(iArr, this.nDstWidth, this.nDstHeight, this.nLineStart, this.nLineEnd, this.nLeftArr[i3], this.nRightArr[i3]);
            }
        }
        return Bitmap.createBitmap(iArr, this.nDstWidth, this.nDstHeight, Bitmap.Config.ARGB_8888);
    }

    public void saveImage() {
        Log.i("BCResult", "nLineStart = " + this.nLineStart + ", nLineEnd = " + this.nLineEnd);
        int i = this.nDstWidth * this.nDstHeight;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = this.pbDstImg;
            int i3 = i2 * 3;
            iArr[i2] = (bArr[i3 + 2] & 255) | ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i3 + 1] & 255) << 8);
        }
        int i4 = 0;
        while (true) {
            int i5 = this.nDstWidth;
            if (i4 >= i5) {
                break;
            }
            iArr[(this.nLineStart * i5) + i4] = -65536;
            iArr[(this.nLineEnd * i5) + i4] = -65536;
            i4++;
        }
        int i6 = 0;
        while (true) {
            int i7 = this.nLineEnd;
            int i8 = this.nLineStart;
            if (i6 < i7 - i8) {
                int i9 = this.nDstWidth;
                int[] iArr2 = this.nLeftArr;
                iArr[((i8 + i6) * i9) + iArr2[0]] = -65536;
                int[] iArr3 = this.nRightArr;
                iArr[((i8 + i6) * i9) + iArr3[0]] = -65536;
                int i10 = this.nTotalRecogNum;
                iArr[((i8 + i6) * i9) + iArr2[i10 - 1]] = -65536;
                iArr[((i8 + i6) * i9) + iArr3[i10 - 1]] = -65536;
                i6++;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(iArr, this.nDstWidth, this.nDstHeight, Bitmap.Config.ARGB_8888);
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, new FileOutputStream(new File(absolutePath + "/bankcard/card.jpg")));
                    return;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public Bitmap drawRect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = this.nRectArr;
        int i = iArr2[0] < 0 ? 0 : iArr2[0];
        int[] iArr3 = this.nRectArr;
        int i2 = width - 1;
        int i3 = iArr3[1] > i2 ? i2 : iArr3[1];
        int[] iArr4 = this.nRectArr;
        int i4 = iArr4[2] < 0 ? 0 : iArr4[2];
        int[] iArr5 = this.nRectArr;
        int i5 = height - 1;
        drawRect(iArr, width, height, i4, iArr5[3] > i5 ? i5 : iArr5[3], i, i3);
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.RGB_565);
    }
}
