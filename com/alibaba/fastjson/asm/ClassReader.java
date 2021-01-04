package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class ClassReader {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f1128b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private final String[] strings;

    public ClassReader(InputStream inputStream) throws IOException {
        int i;
        int i2 = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f1128b = byteArrayOutputStream.toByteArray();
        this.items = new int[readUnsignedShort(8)];
        int length = this.items.length;
        this.strings = new String[length];
        int i3 = 1;
        int i4 = 10;
        while (i3 < length) {
            this.items[i3] = i4 + 1;
            switch (this.f1128b[i4]) {
                case 1:
                    int readUnsignedShort = readUnsignedShort(i4 + 1) + 3;
                    if (readUnsignedShort <= i2) {
                        i = readUnsignedShort;
                        break;
                    } else {
                        i = readUnsignedShort;
                        i2 = readUnsignedShort;
                        break;
                    }
                case 2:
                case 7:
                case 8:
                case 13:
                case 14:
                case 16:
                case 17:
                default:
                    i = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 18:
                    i = 5;
                    break;
                case 5:
                case 6:
                    i = 9;
                    i3++;
                    break;
                case 15:
                    i = 4;
                    break;
            }
            i3++;
            i4 = i + i4;
        }
        this.maxStringLength = i2;
        this.header = i4;
    }

    public void accept(TypeCollector typeCollector) {
        char[] cArr = new char[this.maxStringLength];
        int i = this.header;
        int i2 = this.items[readUnsignedShort(i + 4)];
        int i3 = 0;
        int i4 = i + 8;
        while (i3 < readUnsignedShort(i + 6)) {
            i3++;
            i4 += 2;
        }
        int i5 = i4 + 2;
        for (int readUnsignedShort = readUnsignedShort(i4); readUnsignedShort > 0; readUnsignedShort--) {
            i5 += 8;
            for (int readUnsignedShort2 = readUnsignedShort(i5 + 6); readUnsignedShort2 > 0; readUnsignedShort2--) {
                i5 += readInt(i5 + 2) + 6;
            }
        }
        int readUnsignedShort3 = readUnsignedShort(i5);
        int i6 = i5 + 2;
        for (int i7 = readUnsignedShort3; i7 > 0; i7--) {
            i6 += 8;
            for (int readUnsignedShort4 = readUnsignedShort(i6 + 6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i6 += readInt(i6 + 2) + 6;
            }
        }
        int i8 = i6 + 2;
        for (int readUnsignedShort5 = readUnsignedShort(i6); readUnsignedShort5 > 0; readUnsignedShort5--) {
            i8 += readInt(i8 + 2) + 6;
        }
        int i9 = i4 + 2;
        for (int readUnsignedShort6 = readUnsignedShort(i4); readUnsignedShort6 > 0; readUnsignedShort6--) {
            i9 += 8;
            for (int readUnsignedShort7 = readUnsignedShort(i9 + 6); readUnsignedShort7 > 0; readUnsignedShort7--) {
                i9 += readInt(i9 + 2) + 6;
            }
        }
        int i10 = i9 + 2;
        for (int readUnsignedShort8 = readUnsignedShort(i9); readUnsignedShort8 > 0; readUnsignedShort8--) {
            i10 = readMethod(typeCollector, cArr, i10);
        }
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i) {
        int readUnsignedShort = readUnsignedShort(i);
        String readUTF8 = readUTF8(i + 2, cArr);
        String readUTF82 = readUTF8(i + 4, cArr);
        int readUnsignedShort2 = readUnsignedShort(i + 6);
        int i2 = 0;
        int i3 = i + 8;
        while (readUnsignedShort2 > 0) {
            String readUTF83 = readUTF8(i3, cArr);
            int readInt = readInt(i3 + 2);
            int i4 = i3 + 6;
            if (readUTF83.equals("Code")) {
                i2 = i4;
            }
            readUnsignedShort2--;
            i3 = i4 + readInt;
        }
        MethodCollector visitMethod = typeCollector.visitMethod(readUnsignedShort, readUTF8, readUTF82);
        if (visitMethod != null && i2 != 0) {
            int readInt2 = readInt(i2 + 4) + i2 + 8;
            int i5 = readInt2 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(readInt2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i5 += 8;
            }
            int i6 = i5 + 2;
            int i7 = 0;
            int i8 = 0;
            for (int readUnsignedShort4 = readUnsignedShort(i5); readUnsignedShort4 > 0; readUnsignedShort4--) {
                String readUTF84 = readUTF8(i6, cArr);
                if (readUTF84.equals("LocalVariableTable")) {
                    i8 = i6 + 6;
                } else if (readUTF84.equals("LocalVariableTypeTable")) {
                    i7 = i6 + 6;
                }
                i6 += readInt(i6 + 2) + 6;
            }
            if (i8 != 0) {
                if (i7 != 0) {
                    int readUnsignedShort5 = readUnsignedShort(i7) * 3;
                    int i9 = i7 + 2;
                    int[] iArr = new int[readUnsignedShort5];
                    int i10 = readUnsignedShort5;
                    while (i10 > 0) {
                        int i11 = i10 - 1;
                        iArr[i11] = i9 + 6;
                        int i12 = i11 - 1;
                        iArr[i12] = readUnsignedShort(i9 + 8);
                        i10 = i12 - 1;
                        iArr[i10] = readUnsignedShort(i9);
                        i9 += 10;
                    }
                }
                int i13 = i8 + 2;
                for (int readUnsignedShort6 = readUnsignedShort(i8); readUnsignedShort6 > 0; readUnsignedShort6--) {
                    visitMethod.visitLocalVariable(readUTF8(i13 + 4, cArr), readUnsignedShort(i13 + 8));
                    i13 += 10;
                }
            }
        }
        return i3;
    }

    private int readUnsignedShort(int i) {
        byte[] bArr = this.f1128b;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    private int readInt(int i) {
        byte[] bArr = this.f1128b;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        String str = this.strings[readUnsignedShort];
        if (str == null) {
            int i2 = this.items[readUnsignedShort];
            String[] strArr = this.strings;
            String readUTF = readUTF(i2 + 2, readUnsignedShort(i2), cArr);
            strArr[readUnsignedShort] = readUTF;
            return readUTF;
        }
        return str;
    }

    private String readUTF(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i + i2;
        byte[] bArr = this.f1128b;
        char c = 0;
        char c2 = 0;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            switch (c2) {
                case 0:
                    int i7 = b2 & 255;
                    if (i7 < 128) {
                        i3 = i5 + 1;
                        cArr[i5] = (char) i7;
                        break;
                    } else if (i7 < 224 && i7 > 191) {
                        c = (char) (i7 & 31);
                        c2 = 1;
                        i3 = i5;
                        break;
                    } else {
                        c = (char) (i7 & 15);
                        c2 = 2;
                        i3 = i5;
                        break;
                    }
                case 1:
                    i3 = i5 + 1;
                    cArr[i5] = (char) ((c << 6) | (b2 & 63));
                    c2 = 0;
                    break;
                case 2:
                    c = (char) ((c << 6) | (b2 & 63));
                    c2 = 1;
                    i3 = i5;
                    break;
                default:
                    i3 = i5;
                    break;
            }
            i5 = i3;
            i = i6;
        }
        return new String(cArr, 0, i5);
    }
}
