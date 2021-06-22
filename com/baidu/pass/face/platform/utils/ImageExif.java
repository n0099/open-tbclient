package com.baidu.pass.face.platform.utils;

import android.util.Log;
/* loaded from: classes2.dex */
public class ImageExif {
    public static final String TAG = "CameraExif";

    public static int getOrientation(byte[] bArr) {
        int i2;
        int i3;
        if (bArr == null) {
            return 0;
        }
        int i4 = 0;
        while (i4 + 3 < bArr.length) {
            int i5 = i4 + 1;
            if ((bArr[i4] & 255) == 255) {
                int i6 = bArr[i5] & 255;
                if (i6 != 255) {
                    i5++;
                    if (i6 != 216 && i6 != 1) {
                        if (i6 != 217 && i6 != 218) {
                            int pack = pack(bArr, i5, 2, false);
                            if (pack >= 2 && (i3 = i5 + pack) <= bArr.length) {
                                if (i6 == 225 && pack >= 8 && pack(bArr, i5 + 2, 4, false) == 1165519206 && pack(bArr, i5 + 6, 2, false) == 0) {
                                    i4 = i5 + 8;
                                    i2 = pack - 8;
                                    break;
                                }
                                i4 = i3;
                            } else {
                                Log.e("CameraExif", "Invalid length");
                                return 0;
                            }
                        }
                    }
                }
                i4 = i5;
            }
            i4 = i5;
        }
        i2 = 0;
        if (i2 > 8) {
            int pack2 = pack(bArr, i4, 4, false);
            if (pack2 != 1229531648 && pack2 != 1296891946) {
                Log.e("CameraExif", "Invalid byte order");
                return 0;
            }
            boolean z = pack2 == 1229531648;
            int pack3 = pack(bArr, i4 + 4, 4, z) + 2;
            if (pack3 >= 10 && pack3 <= i2) {
                int i7 = i4 + pack3;
                int i8 = i2 - pack3;
                int pack4 = pack(bArr, i7 - 2, 2, z);
                while (true) {
                    int i9 = pack4 - 1;
                    if (pack4 <= 0 || i8 < 12) {
                        break;
                    } else if (pack(bArr, i7, 2, z) == 274) {
                        int pack5 = pack(bArr, i7 + 8, 2, z);
                        if (pack5 != 1) {
                            if (pack5 != 3) {
                                if (pack5 != 6) {
                                    if (pack5 != 8) {
                                        Log.i("CameraExif", "Unsupported orientation");
                                        return 0;
                                    }
                                    return 270;
                                }
                                return 90;
                            }
                            return 180;
                        }
                        return 0;
                    } else {
                        i7 += 12;
                        i8 -= 12;
                        pack4 = i9;
                    }
                }
            } else {
                Log.e("CameraExif", "Invalid offset");
                return 0;
            }
        }
        Log.i("CameraExif", "Orientation not found");
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
            if (i2 >= 0 && bArr != null && i2 < bArr.length) {
                i5 = (i5 << 8) | (bArr[i2] & 255);
            }
            i2 += i4;
            i3 = i6;
        }
    }
}
