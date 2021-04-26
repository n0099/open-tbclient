package com.alibaba.fastjson.util;

import io.flutter.plugin.common.StandardMessageCodec;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
/* loaded from: classes.dex */
public class UTF8Decoder extends CharsetDecoder {
    public static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012f, code lost:
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i2;
        int i3;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int arrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] array2 = charBuffer.array();
        int arrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int arrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int min = Math.min(arrayOffset2 - arrayOffset, arrayOffset4 - arrayOffset3) + arrayOffset3;
        while (arrayOffset3 < min && array[arrayOffset] >= 0) {
            array2[arrayOffset3] = (char) array[arrayOffset];
            arrayOffset3++;
            arrayOffset++;
        }
        int i4 = arrayOffset;
        loop1: while (true) {
            i2 = arrayOffset3;
            while (i4 < arrayOffset2) {
                byte b2 = array[i4];
                if (b2 < 0) {
                    if ((b2 >> 5) == -2) {
                        if (arrayOffset2 - i4 < 2 || i2 >= arrayOffset4) {
                            break loop1;
                        }
                        byte b3 = array[i4 + 1];
                        if (isMalformed2(b2, b3)) {
                            return malformed(byteBuffer, i4, charBuffer, i2, 2);
                        }
                        i3 = i2 + 1;
                        array2[i2] = (char) (((b2 << 6) ^ b3) ^ 3968);
                        i4 += 2;
                    } else if ((b2 >> 4) == -2) {
                        if (arrayOffset2 - i4 < 3 || i2 >= arrayOffset4) {
                            break loop1;
                        }
                        byte b4 = array[i4 + 1];
                        byte b5 = array[i4 + 2];
                        if (isMalformed3(b2, b4, b5)) {
                            return malformed(byteBuffer, i4, charBuffer, i2, 3);
                        }
                        i3 = i2 + 1;
                        array2[i2] = (char) ((((b2 << StandardMessageCodec.LIST) ^ (b4 << 6)) ^ b5) ^ 8064);
                        i4 += 3;
                    } else if ((b2 >> 3) != -2) {
                        return malformed(byteBuffer, i4, charBuffer, i2, 1);
                    } else {
                        if (arrayOffset2 - i4 < 4 || arrayOffset4 - i2 < 2) {
                            break;
                        }
                        byte b6 = array[i4 + 1];
                        byte b7 = array[i4 + 2];
                        byte b8 = array[i4 + 3];
                        int i5 = ((b2 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                        if (isMalformed4(b6, b7, b8) || i5 < 65536 || i5 > 1114111) {
                            break;
                        }
                        int i6 = i2 + 1;
                        int i7 = i5 - 65536;
                        array2[i2] = (char) (((i7 >> 10) & 1023) | 55296);
                        arrayOffset3 = i6 + 1;
                        array2[i6] = (char) ((i7 & 1023) | 56320);
                        i4 += 4;
                    }
                    i2 = i3;
                } else if (i2 >= arrayOffset4) {
                    return xflow(byteBuffer, i4, arrayOffset2, charBuffer, i2, 1);
                } else {
                    arrayOffset3 = i2 + 1;
                    array2[i2] = (char) b2;
                    i4++;
                }
            }
            return xflow(byteBuffer, i4, arrayOffset2, charBuffer, i2, 0);
        }
        return malformed(byteBuffer, i4, charBuffer, i2, 4);
    }

    public static boolean isMalformed2(int i2, int i3) {
        return (i2 & 30) == 0 || (i3 & 192) != 128;
    }

    public static boolean isMalformed3(int i2, int i3, int i4) {
        return ((i2 != -32 || (i3 & 224) != 128) && (i3 & 192) == 128 && (i4 & 192) == 128) ? false : true;
    }

    public static boolean isMalformed4(int i2, int i3, int i4) {
        return ((i2 & 192) == 128 && (i3 & 192) == 128 && (i4 & 192) == 128) ? false : true;
    }

    public static boolean isNotContinuation(int i2) {
        return (i2 & 192) != 128;
    }

    public static CoderResult lookupN(ByteBuffer byteBuffer, int i2) {
        for (int i3 = 1; i3 < i2; i3++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i3);
            }
        }
        return CoderResult.malformedForLength(i2);
    }

    public static CoderResult malformed(ByteBuffer byteBuffer, int i2, CharBuffer charBuffer, int i3, int i4) {
        byteBuffer.position(i2 - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i4);
        byteBuffer.position(i2);
        charBuffer.position(i3);
        return malformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i2) {
        int i3 = 1;
        if (i2 == 1) {
            byte b2 = byteBuffer.get();
            if ((b2 >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            } else if ((b2 >> 1) == -2) {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            } else {
                return CoderResult.malformedForLength(1);
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                if ((b3 != -32 || (b4 & 224) != 128) && !isNotContinuation(b4)) {
                    i3 = 2;
                }
                return CoderResult.malformedForLength(i3);
            } else if (i2 == 4) {
                int i4 = byteBuffer.get() & 255;
                int i5 = byteBuffer.get() & 255;
                if (i4 > 244 || ((i4 == 240 && (i5 < 144 || i5 > 191)) || ((i4 == 244 && (i5 & 240) != 128) || isNotContinuation(i5)))) {
                    return CoderResult.malformedForLength(1);
                }
                return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
            } else {
                throw new IllegalStateException();
            }
        } else {
            return CoderResult.malformedForLength(1);
        }
    }

    public static CoderResult xflow(Buffer buffer, int i2, int i3, Buffer buffer2, int i4, int i5) {
        buffer.position(i2);
        buffer2.position(i4);
        return (i5 == 0 || i3 - i2 < i5) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
