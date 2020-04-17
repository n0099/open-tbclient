package com.baidu.browser.sailor.util;

import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes11.dex */
public class a {
    static final /* synthetic */ boolean a;

    /* renamed from: com.baidu.browser.sailor.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static abstract class AbstractC0069a {
        public byte[] a;
        public int b;

        AbstractC0069a() {
        }
    }

    /* loaded from: classes11.dex */
    static class b extends AbstractC0069a {
        static final /* synthetic */ boolean j;
        private static final byte[] k;
        private static final byte[] l;
        final byte[] c;
        int d;
        int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        final byte[] i;

        static {
            j = !a.class.desiredAssertionStatus();
            k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            l = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public b() {
            this.a = null;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = l;
            this.c = new byte[2];
            this.d = 0;
            this.e = this.g ? 19 : -1;
        }
    }

    static {
        a = !a.class.desiredAssertionStatus();
    }

    private a() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static byte[] a(byte[] bArr) {
        int i;
        int i2;
        int i3;
        byte b2;
        byte b3;
        int i4;
        byte b4;
        int i5;
        int length = bArr.length;
        b bVar = new b();
        int i6 = (length / 3) * 4;
        if (!bVar.f) {
            switch (length % 3) {
                case 1:
                    i6 += 2;
                    break;
                case 2:
                    i6 += 3;
                    break;
            }
        } else if (length % 3 > 0) {
            i6 += 4;
        }
        if (bVar.g && length > 0) {
            i6 += (bVar.h ? 2 : 1) * (((length - 1) / 57) + 1);
        }
        bVar.a = new byte[i6];
        byte[] bArr2 = bVar.i;
        byte[] bArr3 = bVar.a;
        int i7 = 0;
        int i8 = bVar.e;
        int i9 = 0;
        int i10 = length + 0;
        int i11 = -1;
        switch (bVar.d) {
            case 0:
                i = -1;
                break;
            case 1:
                if (2 <= i10) {
                    int i12 = ((bVar.c[0] & 255) << 16) | ((bArr[0] & 255) << 8);
                    i9 = 2;
                    bVar.d = 0;
                    i = i12 | (bArr[1] & 255);
                    break;
                }
                i = i11;
                break;
            case 2:
                if (i10 > 0) {
                    i9 = 1;
                    i11 = ((bVar.c[0] & 255) << 16) | ((bVar.c[1] & 255) << 8) | (bArr[0] & 255);
                    bVar.d = 0;
                }
                i = i11;
                break;
            default:
                i = i11;
                break;
        }
        if (i != -1) {
            bArr3[0] = bArr2[(i >> 18) & 63];
            bArr3[1] = bArr2[(i >> 12) & 63];
            bArr3[2] = bArr2[(i >> 6) & 63];
            int i13 = 4;
            bArr3[3] = bArr2[i & 63];
            int i14 = i8 - 1;
            if (i14 == 0) {
                if (bVar.h) {
                    i13 = 5;
                    bArr3[4] = 13;
                }
                i7 = i13 + 1;
                bArr3[i13] = 10;
                i2 = 19;
            } else {
                i2 = i14;
                i7 = 4;
            }
        } else {
            i2 = i8;
        }
        while (i9 + 3 <= i10) {
            int i15 = ((bArr[i9] & 255) << 16) | ((bArr[i9 + 1] & 255) << 8) | (bArr[i9 + 2] & 255);
            bArr3[i7] = bArr2[(i15 >> 18) & 63];
            bArr3[i7 + 1] = bArr2[(i15 >> 12) & 63];
            bArr3[i7 + 2] = bArr2[(i15 >> 6) & 63];
            bArr3[i7 + 3] = bArr2[i15 & 63];
            i9 += 3;
            int i16 = i7 + 4;
            int i17 = i2 - 1;
            if (i17 == 0) {
                if (bVar.h) {
                    i5 = i16 + 1;
                    bArr3[i16] = 13;
                } else {
                    i5 = i16;
                }
                i7 = i5 + 1;
                bArr3[i5] = 10;
                i2 = 19;
            } else {
                i2 = i17;
                i7 = i16;
            }
        }
        if (i9 - bVar.d == i10 - 1) {
            int i18 = 0;
            if (bVar.d > 0) {
                i18 = 1;
                b4 = bVar.c[0];
            } else {
                b4 = bArr[i9];
                i9++;
            }
            int i19 = (b4 & 255) << 4;
            bVar.d -= i18;
            int i20 = i7 + 1;
            bArr3[i7] = bArr2[(i19 >> 6) & 63];
            int i21 = i20 + 1;
            bArr3[i20] = bArr2[i19 & 63];
            if (bVar.f) {
                int i22 = i21 + 1;
                bArr3[i21] = 61;
                i21 = i22 + 1;
                bArr3[i22] = 61;
            }
            if (bVar.g) {
                if (bVar.h) {
                    bArr3[i21] = 13;
                    i21++;
                }
                bArr3[i21] = 10;
                i21++;
            }
            i7 = i21;
        } else if (i9 - bVar.d == i10 - 2) {
            int i23 = 0;
            if (bVar.d > 1) {
                i23 = 1;
                b2 = bVar.c[0];
            } else {
                b2 = bArr[i9];
                i9++;
            }
            int i24 = (b2 & 255) << 10;
            if (bVar.d > 0) {
                b3 = bVar.c[i23];
                i23++;
            } else {
                b3 = bArr[i9];
                i9++;
            }
            int i25 = ((b3 & 255) << 2) | i24;
            bVar.d -= i23;
            int i26 = i7 + 1;
            bArr3[i7] = bArr2[(i25 >> 12) & 63];
            int i27 = i26 + 1;
            bArr3[i26] = bArr2[(i25 >> 6) & 63];
            int i28 = i27 + 1;
            bArr3[i27] = bArr2[i25 & 63];
            if (bVar.f) {
                i4 = i28 + 1;
                bArr3[i28] = 61;
            } else {
                i4 = i28;
            }
            if (bVar.g) {
                if (bVar.h) {
                    bArr3[i4] = 13;
                    i4++;
                }
                bArr3[i4] = 10;
                i4++;
            }
            i7 = i4;
        } else if (bVar.g && i7 > 0 && i2 != 19) {
            if (bVar.h) {
                i3 = i7 + 1;
                bArr3[i7] = 13;
            } else {
                i3 = i7;
            }
            i7 = i3 + 1;
            bArr3[i3] = 10;
        }
        if (b.j || bVar.d == 0) {
            if (b.j || i9 == i10) {
                bVar.b = i7;
                bVar.e = i2;
                if (a || bVar.b == i6) {
                    return bVar.a;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
}
