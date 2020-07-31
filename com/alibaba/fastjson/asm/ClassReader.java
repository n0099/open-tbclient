package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class ClassReader {
    public final byte[] b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private final String[] strings;

    public ClassReader(InputStream inputStream) throws IOException {
        int readUnsignedShort;
        int i = 0;
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
        this.b = byteArrayOutputStream.toByteArray();
        this.items = new int[readUnsignedShort(8)];
        int length = this.items.length;
        this.strings = new String[length];
        int i2 = 1;
        int i3 = 10;
        while (i2 < length) {
            this.items[i2] = i3 + 1;
            switch (this.b[i3]) {
                case 1:
                    readUnsignedShort = readUnsignedShort(i3 + 1) + 3;
                    if (readUnsignedShort <= i) {
                        break;
                    } else {
                        i = readUnsignedShort;
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
                    readUnsignedShort = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 18:
                    readUnsignedShort = 5;
                    break;
                case 5:
                case 6:
                    readUnsignedShort = 9;
                    i2++;
                    break;
                case 15:
                    readUnsignedShort = 4;
                    break;
            }
            i2++;
            i3 = readUnsignedShort + i3;
        }
        this.maxStringLength = i;
        this.header = i3;
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
        int i2 = i + 8;
        int i3 = 0;
        for (int readUnsignedShort2 = readUnsignedShort(i + 6); readUnsignedShort2 > 0; readUnsignedShort2--) {
            String readUTF83 = readUTF8(i2, cArr);
            int readInt = readInt(i2 + 2);
            int i4 = i2 + 6;
            if (readUTF83.equals("Code")) {
                i3 = i4;
            }
            i2 = i4 + readInt;
        }
        MethodCollector visitMethod = typeCollector.visitMethod(readUnsignedShort, readUTF8, readUTF82);
        if (visitMethod != null && i3 != 0) {
            int readInt2 = readInt(i3 + 4) + i3 + 8;
            int i5 = readInt2 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(readInt2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i5 += 8;
            }
            int readUnsignedShort4 = readUnsignedShort(i5);
            int i6 = i5 + 2;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = readUnsignedShort4; i9 > 0; i9--) {
                String readUTF84 = readUTF8(i6, cArr);
                if (readUTF84.equals("LocalVariableTable")) {
                    i7 = i6 + 6;
                } else if (readUTF84.equals("LocalVariableTypeTable")) {
                    i8 = i6 + 6;
                }
                i6 += readInt(i6 + 2) + 6;
            }
            if (i7 != 0) {
                if (i8 != 0) {
                    int readUnsignedShort5 = readUnsignedShort(i8) * 3;
                    int[] iArr = new int[readUnsignedShort5];
                    int i10 = i8 + 2;
                    int i11 = readUnsignedShort5;
                    while (i11 > 0) {
                        int i12 = i11 - 1;
                        iArr[i12] = i10 + 6;
                        int i13 = i12 - 1;
                        iArr[i13] = readUnsignedShort(i10 + 8);
                        i11 = i13 - 1;
                        iArr[i11] = readUnsignedShort(i10);
                        i10 += 10;
                    }
                }
                int i14 = i7 + 2;
                for (int readUnsignedShort6 = readUnsignedShort(i7); readUnsignedShort6 > 0; readUnsignedShort6--) {
                    visitMethod.visitLocalVariable(readUTF8(i14 + 4, cArr), readUnsignedShort(i14 + 8));
                    i14 += 10;
                }
            }
        }
        return i2;
    }

    private int readUnsignedShort(int i) {
        byte[] bArr = this.b;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    private int readInt(int i) {
        byte[] bArr = this.b;
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
        byte[] bArr = this.b;
        char c = 0;
        char c2 = 0;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            switch (c2) {
                case 0:
                    int i7 = b & 255;
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
                    cArr[i5] = (char) ((b & 63) | (c << 6));
                    i3 = i5 + 1;
                    c2 = 0;
                    break;
                case 2:
                    c = (char) ((c << 6) | (b & 63));
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
