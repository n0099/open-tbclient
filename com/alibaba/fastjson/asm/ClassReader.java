package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class ClassReader {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f1648b;
    public final int header;
    public final int[] items;
    public final int maxStringLength;
    public boolean readAnnotations;
    public final String[] strings;

    public ClassReader(InputStream inputStream, boolean z) throws IOException {
        int i;
        this.readAnnotations = z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f1648b = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[readUnsignedShort(8)];
        this.items = iArr;
        int length = iArr.length;
        this.strings = new String[length];
        int i2 = 10;
        int i3 = 1;
        while (i3 < length) {
            int i4 = i2 + 1;
            this.items[i3] = i4;
            byte b2 = this.f1648b[i2];
            int i5 = 5;
            if (b2 == 1) {
                i5 = readUnsignedShort(i4) + 3;
                if (i5 > i) {
                    i = i5;
                }
            } else if (b2 == 15) {
                i5 = 4;
            } else if (b2 != 18 && b2 != 3 && b2 != 4) {
                if (b2 == 5 || b2 == 6) {
                    i5 = 9;
                    i3++;
                } else {
                    switch (b2) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            i5 = 3;
                            continue;
                    }
                }
            }
            i2 += i5;
            i3++;
        }
        this.maxStringLength = i;
        this.header = i2;
    }

    private int getAttributes() {
        int i = this.header;
        int readUnsignedShort = i + 8 + (readUnsignedShort(i + 6) * 2);
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                readUnsignedShort += readInt(readUnsignedShort + 12) + 6;
            }
            readUnsignedShort += 8;
        }
        int i2 = readUnsignedShort + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i2); readUnsignedShort4 > 0; readUnsignedShort4--) {
            for (int readUnsignedShort5 = readUnsignedShort(i2 + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i2 += readInt(i2 + 12) + 6;
            }
            i2 += 8;
        }
        return i2 + 2;
    }

    private int readInt(int i) {
        byte[] bArr = this.f1648b;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i) {
        int readUnsignedShort = readUnsignedShort(i);
        String readUTF8 = readUTF8(i + 2, cArr);
        String readUTF82 = readUTF8(i + 4, cArr);
        int i2 = i + 8;
        int i3 = 0;
        int i4 = 0;
        for (int readUnsignedShort2 = readUnsignedShort(i + 6); readUnsignedShort2 > 0; readUnsignedShort2--) {
            String readUTF83 = readUTF8(i2, cArr);
            int readInt = readInt(i2 + 2);
            int i5 = i2 + 6;
            if (readUTF83.equals("Code")) {
                i4 = i5;
            }
            i2 = i5 + readInt;
        }
        MethodCollector visitMethod = typeCollector.visitMethod(readUnsignedShort, readUTF8, readUTF82);
        if (visitMethod != null && i4 != 0) {
            int readInt2 = i4 + 8 + readInt(i4 + 4);
            int i6 = readInt2 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(readInt2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i6 += 8;
            }
            int i7 = i6 + 2;
            int i8 = 0;
            for (int readUnsignedShort4 = readUnsignedShort(i6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                String readUTF84 = readUTF8(i7, cArr);
                if (readUTF84.equals("LocalVariableTable")) {
                    i3 = i7 + 6;
                } else if (readUTF84.equals("LocalVariableTypeTable")) {
                    i8 = i7 + 6;
                }
                i7 += readInt(i7 + 2) + 6;
            }
            if (i3 != 0) {
                if (i8 != 0) {
                    int readUnsignedShort5 = readUnsignedShort(i8) * 3;
                    int i9 = i8 + 2;
                    int[] iArr = new int[readUnsignedShort5];
                    while (readUnsignedShort5 > 0) {
                        int i10 = readUnsignedShort5 - 1;
                        iArr[i10] = i9 + 6;
                        int i11 = i10 - 1;
                        iArr[i11] = readUnsignedShort(i9 + 8);
                        readUnsignedShort5 = i11 - 1;
                        iArr[readUnsignedShort5] = readUnsignedShort(i9);
                        i9 += 10;
                    }
                }
                int i12 = i3 + 2;
                for (int readUnsignedShort6 = readUnsignedShort(i3); readUnsignedShort6 > 0; readUnsignedShort6--) {
                    visitMethod.visitLocalVariable(readUTF8(i12 + 4, cArr), readUnsignedShort(i12 + 8));
                    i12 += 10;
                }
            }
        }
        return i2;
    }

    private String readUTF(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.f1648b;
        int i5 = 0;
        char c2 = 0;
        char c3 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (c2 != 0) {
                if (c2 == 1) {
                    cArr[i5] = (char) ((b2 & 63) | (c3 << 6));
                    i5++;
                    c2 = 0;
                } else if (c2 == 2) {
                    i3 = (b2 & 63) | (c3 << 6);
                    c3 = (char) i3;
                    c2 = 1;
                }
                i = i6;
            } else {
                int i7 = b2 & 255;
                if (i7 < 128) {
                    cArr[i5] = (char) i7;
                    i5++;
                } else if (i7 >= 224 || i7 <= 191) {
                    c3 = (char) (i7 & 15);
                    c2 = 2;
                } else {
                    i3 = i7 & 31;
                    c3 = (char) i3;
                    c2 = 1;
                }
                i = i6;
            }
        }
        return new String(cArr, 0, i5);
    }

    private String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = this.strings;
        String str = strArr[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.items[readUnsignedShort];
        String readUTF = readUTF(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = readUTF;
        return readUTF;
    }

    private int readUnsignedShort(int i) {
        byte[] bArr = this.f1648b;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public void accept(TypeCollector typeCollector) {
        int i;
        char[] cArr = new char[this.maxStringLength];
        if (this.readAnnotations) {
            int attributes = getAttributes();
            for (int readUnsignedShort = readUnsignedShort(attributes); readUnsignedShort > 0; readUnsignedShort--) {
                if ("RuntimeVisibleAnnotations".equals(readUTF8(attributes + 2, cArr))) {
                    i = attributes + 8;
                    break;
                }
                attributes += readInt(attributes + 4) + 6;
            }
        }
        i = 0;
        int i2 = this.header;
        int readUnsignedShort2 = readUnsignedShort(i2 + 6);
        int i3 = i2 + 8;
        for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
            i3 += 2;
        }
        int i5 = i3 + 2;
        int i6 = i5;
        for (int readUnsignedShort3 = readUnsignedShort(i3); readUnsignedShort3 > 0; readUnsignedShort3--) {
            i6 += 8;
            for (int readUnsignedShort4 = readUnsignedShort(i6 + 6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i6 += readInt(i6 + 2) + 6;
            }
        }
        int i7 = i6 + 2;
        for (int readUnsignedShort5 = readUnsignedShort(i6); readUnsignedShort5 > 0; readUnsignedShort5--) {
            i7 += 8;
            for (int readUnsignedShort6 = readUnsignedShort(i7 + 6); readUnsignedShort6 > 0; readUnsignedShort6--) {
                i7 += readInt(i7 + 2) + 6;
            }
        }
        int i8 = i7 + 2;
        for (int readUnsignedShort7 = readUnsignedShort(i7); readUnsignedShort7 > 0; readUnsignedShort7--) {
            i8 += readInt(i8 + 2) + 6;
        }
        if (i != 0) {
            int i9 = i + 2;
            for (int readUnsignedShort8 = readUnsignedShort(i); readUnsignedShort8 > 0; readUnsignedShort8--) {
                typeCollector.visitAnnotation(readUTF8(i9, cArr));
            }
        }
        for (int readUnsignedShort9 = readUnsignedShort(i3); readUnsignedShort9 > 0; readUnsignedShort9--) {
            i5 += 8;
            for (int readUnsignedShort10 = readUnsignedShort(i5 + 6); readUnsignedShort10 > 0; readUnsignedShort10--) {
                i5 += readInt(i5 + 2) + 6;
            }
        }
        int i10 = i5 + 2;
        for (int readUnsignedShort11 = readUnsignedShort(i5); readUnsignedShort11 > 0; readUnsignedShort11--) {
            i10 = readMethod(typeCollector, cArr, i10);
        }
    }
}
