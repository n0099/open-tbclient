package com.baidu.mobads.cid.cesium.d;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f8177a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i) {
        byte b2;
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i;
        int i5 = 0;
        while (true) {
            byte b3 = bArr[i4 - 1];
            b2 = 10;
            if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                if (b3 != 61) {
                    break;
                }
                i5++;
            }
            i4--;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i4) {
            byte b4 = bArr[i6];
            if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                if (b4 >= 65 && b4 <= 90) {
                    i2 = b4 - 65;
                } else if (b4 >= 97 && b4 <= 122) {
                    i2 = b4 - 71;
                } else if (b4 >= 48 && b4 <= 57) {
                    i2 = b4 + 4;
                } else if (b4 == 43) {
                    i2 = 62;
                } else if (b4 != 47) {
                    return null;
                } else {
                    i2 = 63;
                }
                i7 = ((byte) i2) | (i7 << 6);
                if (i9 % 4 == 3) {
                    int i10 = i8 + 1;
                    bArr2[i8] = (byte) ((16711680 & i7) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((65280 & i7) >> 8);
                    bArr2[i11] = (byte) (i7 & 255);
                    i8 = i11 + 1;
                }
                i9++;
            }
            i6++;
            b2 = 10;
        }
        if (i5 > 0) {
            int i12 = i7 << (i5 * 6);
            int i13 = i8 + 1;
            bArr2[i8] = (byte) ((i12 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
            if (i5 == 1) {
                i8 = i13 + 1;
                bArr2[i13] = (byte) ((i12 & 65280) >> 8);
            } else {
                i8 = i13;
            }
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr2, 0, bArr3, 0, i8);
        return bArr3;
    }
}
