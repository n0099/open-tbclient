package com.baidu.pass.face.platform.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ImageExif {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CameraExif";
    public transient /* synthetic */ FieldHolder $fh;

    public ImageExif() {
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

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0061, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0062, code lost:
        if (r3 <= 8) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0064, code lost:
        r2 = pack(r10, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006b, code lost:
        if (r2 == 1229531648) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0070, code lost:
        if (r2 == 1296891946) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
        if (r2 != 1229531648) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0076, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0077, code lost:
        r2 = pack(r10, r1 + 4, 4, r5) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0080, code lost:
        if (r2 < 10) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0082, code lost:
        if (r2 <= r3) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = pack(r10, r1 - 2, 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008d, code lost:
        r4 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008f, code lost:
        if (r2 <= 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0093, code lost:
        if (r3 < 12) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
        if (pack(r10, r1, 2, r5) != 274) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
        r10 = pack(r10, r1 + 8, 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a3, code lost:
        if (r10 == 3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a6, code lost:
        if (r10 == 6) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a8, code lost:
        if (r10 == 8) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00aa, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ab, code lost:
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ae, code lost:
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b1, code lost:
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b4, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getOrientation(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
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
            return 0;
        }
        return invokeL.intValue;
    }

    public static int pack(byte[] bArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.intValue;
        }
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
