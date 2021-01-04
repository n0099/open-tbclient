package com.baidu.browser.sailor.util;

import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1647a;

    /* renamed from: com.baidu.browser.sailor.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static abstract class AbstractC0087a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f1648a;

        /* renamed from: b  reason: collision with root package name */
        public int f1649b;

        AbstractC0087a() {
        }
    }

    /* loaded from: classes4.dex */
    static class b extends AbstractC0087a {
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
            this.f1648a = null;
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
        f1647a = !a.class.desiredAssertionStatus();
    }

    private a() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static byte[] a(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        byte b2;
        byte b3;
        int i5;
        int i6;
        byte b4;
        int i7;
        int i8 = 1;
        int length = bArr.length;
        b bVar = new b();
        int i9 = (length / 3) * 4;
        if (!bVar.f) {
            switch (length % 3) {
                case 1:
                    i9 += 2;
                    break;
                case 2:
                    i9 += 3;
                    break;
            }
        } else if (length % 3 > 0) {
            i9 += 4;
        }
        if (bVar.g && length > 0) {
            i9 += (bVar.h ? 2 : 1) * (((length - 1) / 57) + 1);
        }
        bVar.f1648a = new byte[i9];
        byte[] bArr2 = bVar.i;
        byte[] bArr3 = bVar.f1648a;
        int i10 = bVar.e;
        int i11 = length + 0;
        switch (bVar.d) {
            case 0:
                i = 0;
                i2 = -1;
                break;
            case 1:
                if (2 <= i11) {
                    int i12 = ((bVar.c[0] & 255) << 16) | ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                    bVar.d = 0;
                    i = 2;
                    i2 = i12;
                    break;
                }
                i = 0;
                i2 = -1;
                break;
            case 2:
                if (i11 > 0) {
                    int i13 = ((bVar.c[0] & 255) << 16) | ((bVar.c[1] & 255) << 8) | (bArr[0] & 255);
                    bVar.d = 0;
                    i = 1;
                    i2 = i13;
                    break;
                }
                i = 0;
                i2 = -1;
                break;
            default:
                i = 0;
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            bArr3[0] = bArr2[(i2 >> 18) & 63];
            bArr3[1] = bArr2[(i2 >> 12) & 63];
            bArr3[2] = bArr2[(i2 >> 6) & 63];
            int i14 = 4;
            bArr3[3] = bArr2[i2 & 63];
            int i15 = i10 - 1;
            if (i15 == 0) {
                if (bVar.h) {
                    i14 = 5;
                    bArr3[4] = 13;
                }
                i3 = i14 + 1;
                bArr3[i14] = 10;
                i10 = 19;
            } else {
                i10 = i15;
                i3 = 4;
            }
        } else {
            i3 = 0;
        }
        while (i + 3 <= i11) {
            int i16 = ((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255);
            bArr3[i3] = bArr2[(i16 >> 18) & 63];
            bArr3[i3 + 1] = bArr2[(i16 >> 12) & 63];
            bArr3[i3 + 2] = bArr2[(i16 >> 6) & 63];
            bArr3[i3 + 3] = bArr2[i16 & 63];
            i += 3;
            int i17 = i3 + 4;
            int i18 = i10 - 1;
            if (i18 == 0) {
                if (bVar.h) {
                    i7 = i17 + 1;
                    bArr3[i17] = 13;
                } else {
                    i7 = i17;
                }
                i3 = i7 + 1;
                bArr3[i7] = 10;
                i10 = 19;
            } else {
                i10 = i18;
                i3 = i17;
            }
        }
        if (i - bVar.d == i11 - 1) {
            if (bVar.d > 0) {
                b4 = bVar.c[0];
                i6 = i;
            } else {
                i6 = i + 1;
                b4 = bArr[i];
                i8 = 0;
            }
            int i19 = (b4 & 255) << 4;
            bVar.d -= i8;
            int i20 = i3 + 1;
            bArr3[i3] = bArr2[(i19 >> 6) & 63];
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
            i = i6;
            i3 = i21;
        } else if (i - bVar.d == i11 - 2) {
            if (bVar.d > 1) {
                b2 = bVar.c[0];
            } else {
                b2 = bArr[i];
                i8 = 0;
                i++;
            }
            int i23 = (b2 & 255) << 10;
            if (bVar.d > 0) {
                b3 = bVar.c[i8];
                i8++;
            } else {
                b3 = bArr[i];
                i++;
            }
            int i24 = ((b3 & 255) << 2) | i23;
            bVar.d -= i8;
            int i25 = i3 + 1;
            bArr3[i3] = bArr2[(i24 >> 12) & 63];
            int i26 = i25 + 1;
            bArr3[i25] = bArr2[(i24 >> 6) & 63];
            int i27 = i26 + 1;
            bArr3[i26] = bArr2[i24 & 63];
            if (bVar.f) {
                i5 = i27 + 1;
                bArr3[i27] = 61;
            } else {
                i5 = i27;
            }
            if (bVar.g) {
                if (bVar.h) {
                    bArr3[i5] = 13;
                    i5++;
                }
                bArr3[i5] = 10;
                i5++;
            }
            i3 = i5;
        } else if (bVar.g && i3 > 0 && i10 != 19) {
            if (bVar.h) {
                i4 = i3 + 1;
                bArr3[i3] = 13;
            } else {
                i4 = i3;
            }
            i3 = i4 + 1;
            bArr3[i4] = 10;
        }
        if (b.j || bVar.d == 0) {
            if (b.j || i == i11) {
                bVar.f1649b = i3;
                bVar.e = i10;
                if (f1647a || bVar.f1649b == i9) {
                    return bVar.f1648a;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
}
