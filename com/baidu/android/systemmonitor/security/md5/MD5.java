package com.baidu.android.systemmonitor.security.md5;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
public class MD5 {
    static byte[] c = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static boolean d = false;
    private static boolean e = true;
    private static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    a a;
    a b;

    public MD5() {
        if (e) {
            c();
        }
        a();
    }

    private native void Transform_native(int[] iArr, byte[] bArr, int i, int i2);

    public static String a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i + 1;
            cArr[i] = f[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = f[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    private void a(a aVar, byte[] bArr, int i, int[] iArr) {
        int i2 = aVar.a[0];
        int i3 = aVar.a[1];
        int i4 = aVar.a[2];
        int i5 = aVar.a[3];
        a(bArr, i, iArr);
        int i6 = i2 + ((((i3 & i4) | ((i3 ^ (-1)) & i5)) + iArr[0]) - 680876936);
        int i7 = ((i6 >>> 25) | (i6 << 7)) + i3;
        int i8 = i5 + ((((i7 & i3) | ((i7 ^ (-1)) & i4)) + iArr[1]) - 389564586);
        int i9 = ((i8 >>> 20) | (i8 << 12)) + i7;
        int i10 = i4 + ((i9 & i7) | ((i9 ^ (-1)) & i3)) + iArr[2] + 606105819;
        int i11 = ((i10 >>> 15) | (i10 << 17)) + i9;
        int i12 = i3 + ((((i11 & i9) | ((i11 ^ (-1)) & i7)) + iArr[3]) - 1044525330);
        int i13 = ((i12 >>> 10) | (i12 << 22)) + i11;
        int i14 = i7 + ((((i13 & i11) | ((i13 ^ (-1)) & i9)) + iArr[4]) - 176418897);
        int i15 = ((i14 >>> 25) | (i14 << 7)) + i13;
        int i16 = i9 + ((i15 & i13) | ((i15 ^ (-1)) & i11)) + iArr[5] + 1200080426;
        int i17 = ((i16 >>> 20) | (i16 << 12)) + i15;
        int i18 = i11 + ((((i17 & i15) | ((i17 ^ (-1)) & i13)) + iArr[6]) - 1473231341);
        int i19 = ((i18 >>> 15) | (i18 << 17)) + i17;
        int i20 = i13 + ((((i19 & i17) | ((i19 ^ (-1)) & i15)) + iArr[7]) - 45705983);
        int i21 = ((i20 >>> 10) | (i20 << 22)) + i19;
        int i22 = i15 + ((i21 & i19) | ((i21 ^ (-1)) & i17)) + iArr[8] + 1770035416;
        int i23 = ((i22 >>> 25) | (i22 << 7)) + i21;
        int i24 = i17 + ((((i23 & i21) | ((i23 ^ (-1)) & i19)) + iArr[9]) - 1958414417);
        int i25 = ((i24 >>> 20) | (i24 << 12)) + i23;
        int i26 = i19 + ((((i25 & i23) | ((i25 ^ (-1)) & i21)) + iArr[10]) - 42063);
        int i27 = ((i26 >>> 15) | (i26 << 17)) + i25;
        int i28 = i21 + ((((i27 & i25) | ((i27 ^ (-1)) & i23)) + iArr[11]) - 1990404162);
        int i29 = ((i28 >>> 10) | (i28 << 22)) + i27;
        int i30 = i23 + ((i29 & i27) | ((i29 ^ (-1)) & i25)) + iArr[12] + 1804603682;
        int i31 = ((i30 >>> 25) | (i30 << 7)) + i29;
        int i32 = i25 + ((((i31 & i29) | ((i31 ^ (-1)) & i27)) + iArr[13]) - 40341101);
        int i33 = ((i32 >>> 20) | (i32 << 12)) + i31;
        int i34 = i27 + ((((i33 & i31) | ((i33 ^ (-1)) & i29)) + iArr[14]) - 1502002290);
        int i35 = ((i34 >>> 15) | (i34 << 17)) + i33;
        int i36 = i29 + ((i35 & i33) | ((i35 ^ (-1)) & i31)) + iArr[15] + 1236535329;
        int i37 = ((i36 >>> 10) | (i36 << 22)) + i35;
        int i38 = i31 + ((((i37 & i33) | ((i33 ^ (-1)) & i35)) + iArr[1]) - 165796510);
        int i39 = ((i38 >>> 27) | (i38 << 5)) + i37;
        int i40 = i33 + ((((i39 & i35) | ((i35 ^ (-1)) & i37)) + iArr[6]) - 1069501632);
        int i41 = ((i40 >>> 23) | (i40 << 9)) + i39;
        int i42 = i35 + ((i41 & i37) | ((i37 ^ (-1)) & i39)) + iArr[11] + 643717713;
        int i43 = ((i42 >>> 18) | (i42 << 14)) + i41;
        int i44 = i37 + ((((i43 & i39) | ((i39 ^ (-1)) & i41)) + iArr[0]) - 373897302);
        int i45 = ((i44 >>> 12) | (i44 << 20)) + i43;
        int i46 = i39 + ((((i45 & i41) | ((i41 ^ (-1)) & i43)) + iArr[5]) - 701558691);
        int i47 = ((i46 >>> 27) | (i46 << 5)) + i45;
        int i48 = i41 + ((i47 & i43) | ((i43 ^ (-1)) & i45)) + iArr[10] + 38016083;
        int i49 = ((i48 >>> 23) | (i48 << 9)) + i47;
        int i50 = i43 + ((((i49 & i45) | ((i45 ^ (-1)) & i47)) + iArr[15]) - 660478335);
        int i51 = ((i50 >>> 18) | (i50 << 14)) + i49;
        int i52 = i45 + ((((i51 & i47) | ((i47 ^ (-1)) & i49)) + iArr[4]) - 405537848);
        int i53 = ((i52 >>> 12) | (i52 << 20)) + i51;
        int i54 = i47 + ((i53 & i49) | ((i49 ^ (-1)) & i51)) + iArr[9] + 568446438;
        int i55 = ((i54 >>> 27) | (i54 << 5)) + i53;
        int i56 = i49 + ((((i55 & i51) | ((i51 ^ (-1)) & i53)) + iArr[14]) - 1019803690);
        int i57 = ((i56 >>> 23) | (i56 << 9)) + i55;
        int i58 = i51 + ((((i57 & i53) | ((i53 ^ (-1)) & i55)) + iArr[3]) - 187363961);
        int i59 = ((i58 >>> 18) | (i58 << 14)) + i57;
        int i60 = i53 + ((i59 & i55) | ((i55 ^ (-1)) & i57)) + iArr[8] + 1163531501;
        int i61 = ((i60 >>> 12) | (i60 << 20)) + i59;
        int i62 = i55 + ((((i61 & i57) | ((i57 ^ (-1)) & i59)) + iArr[13]) - 1444681467);
        int i63 = ((i62 >>> 27) | (i62 << 5)) + i61;
        int i64 = i57 + ((((i63 & i59) | ((i59 ^ (-1)) & i61)) + iArr[2]) - 51403784);
        int i65 = ((i64 >>> 23) | (i64 << 9)) + i63;
        int i66 = i59 + ((i65 & i61) | ((i61 ^ (-1)) & i63)) + iArr[7] + 1735328473;
        int i67 = ((i66 >>> 18) | (i66 << 14)) + i65;
        int i68 = i61 + ((((i67 & i63) | ((i63 ^ (-1)) & i65)) + iArr[12]) - 1926607734);
        int i69 = ((i68 >>> 12) | (i68 << 20)) + i67;
        int i70 = i63 + ((((i69 ^ i67) ^ i65) + iArr[5]) - 378558);
        int i71 = ((i70 >>> 28) | (i70 << 4)) + i69;
        int i72 = i65 + ((((i71 ^ i69) ^ i67) + iArr[8]) - 2022574463);
        int i73 = ((i72 >>> 21) | (i72 << 11)) + i71;
        int i74 = i67 + ((i73 ^ i71) ^ i69) + iArr[11] + 1839030562;
        int i75 = ((i74 >>> 16) | (i74 << 16)) + i73;
        int i76 = i69 + ((((i75 ^ i73) ^ i71) + iArr[14]) - 35309556);
        int i77 = ((i76 >>> 9) | (i76 << 23)) + i75;
        int i78 = i71 + ((((i77 ^ i75) ^ i73) + iArr[1]) - 1530992060);
        int i79 = ((i78 >>> 28) | (i78 << 4)) + i77;
        int i80 = i73 + ((i79 ^ i77) ^ i75) + iArr[4] + 1272893353;
        int i81 = ((i80 >>> 21) | (i80 << 11)) + i79;
        int i82 = i75 + ((((i81 ^ i79) ^ i77) + iArr[7]) - 155497632);
        int i83 = ((i82 >>> 16) | (i82 << 16)) + i81;
        int i84 = i77 + ((((i83 ^ i81) ^ i79) + iArr[10]) - 1094730640);
        int i85 = ((i84 >>> 9) | (i84 << 23)) + i83;
        int i86 = i79 + ((i85 ^ i83) ^ i81) + iArr[13] + 681279174;
        int i87 = ((i86 >>> 28) | (i86 << 4)) + i85;
        int i88 = i81 + ((((i87 ^ i85) ^ i83) + iArr[0]) - 358537222);
        int i89 = ((i88 >>> 21) | (i88 << 11)) + i87;
        int i90 = i83 + ((((i89 ^ i87) ^ i85) + iArr[3]) - 722521979);
        int i91 = ((i90 >>> 16) | (i90 << 16)) + i89;
        int i92 = i85 + ((i91 ^ i89) ^ i87) + iArr[6] + 76029189;
        int i93 = ((i92 >>> 9) | (i92 << 23)) + i91;
        int i94 = i87 + ((((i93 ^ i91) ^ i89) + iArr[9]) - 640364487);
        int i95 = ((i94 >>> 28) | (i94 << 4)) + i93;
        int i96 = i89 + ((((i95 ^ i93) ^ i91) + iArr[12]) - 421815835);
        int i97 = ((i96 >>> 21) | (i96 << 11)) + i95;
        int i98 = i91 + ((i97 ^ i95) ^ i93) + iArr[15] + 530742520;
        int i99 = ((i98 >>> 16) | (i98 << 16)) + i97;
        int i100 = i93 + ((((i99 ^ i97) ^ i95) + iArr[2]) - 995338651);
        int i101 = ((i100 >>> 9) | (i100 << 23)) + i99;
        int i102 = i95 + (((((i97 ^ (-1)) | i101) ^ i99) + iArr[0]) - 198630844);
        int i103 = ((i102 >>> 26) | (i102 << 6)) + i101;
        int i104 = i97 + (((i99 ^ (-1)) | i103) ^ i101) + iArr[7] + 1126891415;
        int i105 = ((i104 >>> 22) | (i104 << 10)) + i103;
        int i106 = i99 + (((((i101 ^ (-1)) | i105) ^ i103) + iArr[14]) - 1416354905);
        int i107 = ((i106 >>> 17) | (i106 << 15)) + i105;
        int i108 = i101 + (((((i103 ^ (-1)) | i107) ^ i105) + iArr[5]) - 57434055);
        int i109 = ((i108 >>> 11) | (i108 << 21)) + i107;
        int i110 = i103 + (((i105 ^ (-1)) | i109) ^ i107) + iArr[12] + 1700485571;
        int i111 = ((i110 >>> 26) | (i110 << 6)) + i109;
        int i112 = i105 + (((((i107 ^ (-1)) | i111) ^ i109) + iArr[3]) - 1894986606);
        int i113 = ((i112 >>> 22) | (i112 << 10)) + i111;
        int i114 = i107 + (((((i109 ^ (-1)) | i113) ^ i111) + iArr[10]) - 1051523);
        int i115 = ((i114 >>> 17) | (i114 << 15)) + i113;
        int i116 = i109 + (((((i111 ^ (-1)) | i115) ^ i113) + iArr[1]) - 2054922799);
        int i117 = ((i116 >>> 11) | (i116 << 21)) + i115;
        int i118 = i111 + (((i113 ^ (-1)) | i117) ^ i115) + iArr[8] + 1873313359;
        int i119 = ((i118 >>> 26) | (i118 << 6)) + i117;
        int i120 = i113 + (((((i115 ^ (-1)) | i119) ^ i117) + iArr[15]) - 30611744);
        int i121 = ((i120 >>> 22) | (i120 << 10)) + i119;
        int i122 = i115 + (((((i117 ^ (-1)) | i121) ^ i119) + iArr[6]) - 1560198380);
        int i123 = ((i122 >>> 17) | (i122 << 15)) + i121;
        int i124 = i117 + (((i119 ^ (-1)) | i123) ^ i121) + iArr[13] + 1309151649;
        int i125 = ((i124 >>> 11) | (i124 << 21)) + i123;
        int i126 = i119 + (((((i121 ^ (-1)) | i125) ^ i123) + iArr[4]) - 145523070);
        int i127 = ((i126 >>> 26) | (i126 << 6)) + i125;
        int i128 = i121 + (((((i123 ^ (-1)) | i127) ^ i125) + iArr[11]) - 1120210379);
        int i129 = ((i128 >>> 22) | (i128 << 10)) + i127;
        int i130 = i123 + (((i125 ^ (-1)) | i129) ^ i127) + iArr[2] + 718787259;
        int i131 = ((i130 >>> 17) | (i130 << 15)) + i129;
        int i132 = i125 + (((((i127 ^ (-1)) | i131) ^ i129) + iArr[9]) - 343485551);
        int[] iArr2 = aVar.a;
        iArr2[0] = i127 + iArr2[0];
        int[] iArr3 = aVar.a;
        iArr3[1] = ((i132 >>> 11) | (i132 << 21)) + i131 + iArr3[1];
        int[] iArr4 = aVar.a;
        iArr4[2] = iArr4[2] + i131;
        int[] iArr5 = aVar.a;
        iArr5[3] = iArr5[3] + i129;
    }

    private void a(byte[] bArr, int i, int[] iArr) {
        iArr[0] = (bArr[i] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 3] << 24);
        iArr[1] = (bArr[i + 4] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 5] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 6] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 7] << 24);
        iArr[2] = (bArr[i + 8] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 9] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 10] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 11] << 24);
        iArr[3] = (bArr[i + 12] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 13] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 14] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 15] << 24);
        iArr[4] = (bArr[i + 16] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 17] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 18] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 19] << 24);
        iArr[5] = (bArr[i + 20] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 21] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 22] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 23] << 24);
        iArr[6] = (bArr[i + 24] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 25] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 26] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 27] << 24);
        iArr[7] = (bArr[i + 28] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 29] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 30] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 31] << 24);
        iArr[8] = (bArr[i + 32] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 33] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 34] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 35] << 24);
        iArr[9] = (bArr[i + 36] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 37] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 38] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 39] << 24);
        iArr[10] = (bArr[i + 40] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 41] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 42] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 43] << 24);
        iArr[11] = (bArr[i + 44] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 45] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 46] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 47] << 24);
        iArr[12] = (bArr[i + 48] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 49] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 50] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 51] << 24);
        iArr[13] = (bArr[i + 52] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 53] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 54] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 55] << 24);
        iArr[14] = (bArr[i + 56] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 57] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 58] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 59] << 24);
        iArr[15] = (bArr[i + 60] & MotionEventCompat.ACTION_MASK) | ((bArr[i + 61] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i + 62] & MotionEventCompat.ACTION_MASK) << 16) | (bArr[i + 63] << 24);
    }

    public static byte[] a(File file) {
        b bVar;
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        try {
            long length = file.length();
            long j = length >= 512 ? length : 512L;
            byte[] bArr = new byte[(int) (j <= 65536 ? j : 65536L)];
            bVar = new b(new FileInputStream(file));
            do {
                try {
                } catch (IOException e2) {
                    e = e2;
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Exception e3) {
                            throw e;
                        }
                    }
                    throw e;
                }
            } while (bVar.read(bArr) != -1);
            bVar.close();
            return bVar.a();
        } catch (IOException e4) {
            e = e4;
            bVar = null;
        }
    }

    private byte[] a(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) (iArr[i2] & MotionEventCompat.ACTION_MASK);
            bArr[i3 + 1] = (byte) ((iArr[i2] >>> 8) & MotionEventCompat.ACTION_MASK);
            bArr[i3 + 2] = (byte) ((iArr[i2] >>> 16) & MotionEventCompat.ACTION_MASK);
            bArr[i3 + 3] = (byte) ((iArr[i2] >>> 24) & MotionEventCompat.ACTION_MASK);
            i2++;
        }
        return bArr;
    }

    private static synchronized void c() {
        synchronized (MD5.class) {
            if (e) {
                d = d();
                e = false;
            }
        }
    }

    private static synchronized boolean d() {
        boolean z = false;
        synchronized (MD5.class) {
            try {
                System.loadLibrary("BdMoplusMD5_V1");
                z = true;
            } catch (Error e2) {
            } catch (Exception e3) {
            }
        }
        return z;
    }

    public synchronized void a() {
        this.a = new a();
        this.b = null;
    }

    public void a(byte b) {
        a(new byte[]{b}, 1);
    }

    public void a(int i) {
        a((byte) (i & MotionEventCompat.ACTION_MASK));
    }

    public void a(a aVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.b = null;
        if (i2 - i > bArr.length) {
            i2 = bArr.length - i;
        }
        int i4 = (int) (aVar.b & 63);
        aVar.b += i2;
        int i5 = 64 - i4;
        if (i2 >= i5) {
            if (d) {
                if (i5 == 64) {
                    i5 = 0;
                } else {
                    for (int i6 = 0; i6 < i5; i6++) {
                        aVar.c[i6 + i4] = bArr[i6 + i];
                    }
                    Transform_native(aVar.a, aVar.c, 0, 64);
                }
                int i7 = (((i2 - i5) / 64) * 64) + i5;
                int i8 = i5 + i;
                int i9 = i2 - i5;
                while (i9 > 65536) {
                    Transform_native(aVar.a, bArr, i8, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED);
                    i9 -= AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
                    i8 += AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
                }
                Transform_native(aVar.a, bArr, i8, i9);
                i5 = i7;
            } else {
                int[] iArr = new int[16];
                if (i5 == 64) {
                    i5 = 0;
                } else {
                    for (int i10 = 0; i10 < i5; i10++) {
                        aVar.c[i10 + i4] = bArr[i10 + i];
                    }
                    a(aVar, aVar.c, 0, iArr);
                }
                while (i5 + 63 < i2) {
                    a(aVar, bArr, i5 + i, iArr);
                    i5 += 64;
                }
            }
            i4 = 0;
            i3 = i5;
        }
        if (i3 < i2) {
            for (int i11 = i3; i11 < i2; i11++) {
                aVar.c[(i4 + i11) - i3] = bArr[i11 + i];
            }
        }
    }

    public void a(byte[] bArr, int i) {
        a(this.a, bArr, 0, i);
    }

    public void a(byte[] bArr, int i, int i2) {
        a(this.a, bArr, i, i2);
    }

    public synchronized byte[] b() {
        if (this.b == null) {
            a aVar = new a(this.a);
            byte[] a = a(new int[]{(int) (aVar.b << 3), (int) (aVar.b >> 29)}, 8);
            int i = (int) (aVar.b & 63);
            a(aVar, c, 0, i < 56 ? 56 - i : 120 - i);
            a(aVar, a, 0, 8);
            this.b = aVar;
        }
        return a(this.b.a, 16);
    }
}
