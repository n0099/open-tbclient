package com.baidu.tbadk.core.util;

import android.graphics.BitmapFactory;
import android.util.Log;
/* loaded from: classes3.dex */
public class ImageUtil {
    public static final String TAG = "CameraExif";

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public static int exifToDegrees(int i2) {
        if (i2 == 6) {
            return 90;
        }
        if (i2 == 3) {
            return 180;
        }
        return i2 == 8 ? 270 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0066, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0067, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0068, code lost:
        if (r3 <= 8) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006a, code lost:
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0071, code lost:
        if (r2 == 1229531648) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
        if (r2 == 1296891946) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0078, code lost:
        android.util.Log.e(com.baidu.tbadk.core.util.ImageUtil.TAG, "Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007e, code lost:
        if (r2 != 1229531648) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
        r2 = pack(r11, r1 + 4, 4, r6) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
        if (r2 < 10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008d, code lost:
        if (r2 <= r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0090, code lost:
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = pack(r11, r1 - 2, 2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
        r4 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009a, code lost:
        if (r2 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
        if (r3 < 12) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a6, code lost:
        if (pack(r11, r1, 2, r6) != 274) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a8, code lost:
        r11 = pack(r11, r1 + 8, 2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ae, code lost:
        if (r11 == 3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b1, code lost:
        if (r11 == 6) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b3, code lost:
        if (r11 == 8) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b5, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b9, code lost:
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bc, code lost:
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bf, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c5, code lost:
        android.util.Log.e(com.baidu.tbadk.core.util.ImageUtil.TAG, "Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ca, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00cb, code lost:
        android.util.Log.i(com.baidu.tbadk.core.util.ImageUtil.TAG, "Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getOrientation(byte[] bArr) {
        int i2;
        if (bArr == null) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 + 3 >= bArr.length) {
                break;
            }
            int i4 = i3 + 1;
            if ((bArr[i3] & 255) != 255) {
                break;
            }
            int i5 = bArr[i4] & 255;
            if (i5 != 255) {
                i4++;
                if (i5 != 216 && i5 != 1) {
                    if (i5 != 217 && i5 != 218) {
                        int pack = pack(bArr, i4, 2, false);
                        if (pack >= 2 && (i2 = i4 + pack) <= bArr.length) {
                            if (i5 == 225 && pack >= 8 && pack(bArr, i4 + 2, 4, false) == 1165519206 && pack(bArr, i4 + 6, 2, false) == 0) {
                                i3 = i4 + 8;
                                int i6 = pack - 8;
                                break;
                            }
                            i3 = i2;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i3 = i4;
        }
        Log.e(TAG, "Invalid length");
        return 0;
    }

    public static int pack(byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        if (z) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                return i5;
            }
            i5 = (bArr[i2] & 255) | (i5 << 8);
            i2 += i4;
            i3 = i6;
        }
    }
}
