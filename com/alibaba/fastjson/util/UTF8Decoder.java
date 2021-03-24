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

    /* loaded from: classes.dex */
    public static class Surrogate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        public static char high(int i) {
            return (char) ((((i - 65536) >> 10) & 1023) | 55296);
        }

        public static char low(int i) {
            return (char) (((i - 65536) & 1023) | 56320);
        }

        public static boolean neededFor(int i) {
            return i >= 65536 && i <= 1114111;
        }
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0123, code lost:
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i;
        int i2;
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
        int i3 = arrayOffset;
        loop1: while (true) {
            i = arrayOffset3;
            while (i3 < arrayOffset2) {
                byte b2 = array[i3];
                if (b2 < 0) {
                    if ((b2 >> 5) == -2) {
                        if (arrayOffset2 - i3 < 2 || i >= arrayOffset4) {
                            break loop1;
                        }
                        byte b3 = array[i3 + 1];
                        if (isMalformed2(b2, b3)) {
                            return malformed(byteBuffer, i3, charBuffer, i, 2);
                        }
                        i2 = i + 1;
                        array2[i] = (char) (((b2 << 6) ^ b3) ^ 3968);
                        i3 += 2;
                    } else if ((b2 >> 4) == -2) {
                        if (arrayOffset2 - i3 < 3 || i >= arrayOffset4) {
                            break loop1;
                        }
                        byte b4 = array[i3 + 1];
                        byte b5 = array[i3 + 2];
                        if (isMalformed3(b2, b4, b5)) {
                            return malformed(byteBuffer, i3, charBuffer, i, 3);
                        }
                        i2 = i + 1;
                        array2[i] = (char) ((((b2 << StandardMessageCodec.LIST) ^ (b4 << 6)) ^ b5) ^ 8064);
                        i3 += 3;
                    } else if ((b2 >> 3) != -2) {
                        return malformed(byteBuffer, i3, charBuffer, i, 1);
                    } else {
                        if (arrayOffset2 - i3 < 4 || arrayOffset4 - i < 2) {
                            break loop1;
                        }
                        byte b6 = array[i3 + 1];
                        byte b7 = array[i3 + 2];
                        byte b8 = array[i3 + 3];
                        int i4 = ((b2 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                        if (isMalformed4(b6, b7, b8) || !Surrogate.neededFor(i4)) {
                            break loop1;
                        }
                        int i5 = i + 1;
                        array2[i] = Surrogate.high(i4);
                        i2 = i5 + 1;
                        array2[i5] = Surrogate.low(i4);
                        i3 += 4;
                    }
                    i = i2;
                } else if (i >= arrayOffset4) {
                    return xflow(byteBuffer, i3, arrayOffset2, charBuffer, i, 1);
                } else {
                    arrayOffset3 = i + 1;
                    array2[i] = (char) b2;
                    i3++;
                }
            }
            return xflow(byteBuffer, i3, arrayOffset2, charBuffer, i, 0);
        }
        return malformed(byteBuffer, i3, charBuffer, i, 4);
    }

    public static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    public static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    public static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    public static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    public static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    public static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i3);
        updatePositions(byteBuffer, i, charBuffer, i2);
        return malformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
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
        } else if (i != 2) {
            if (i == 3) {
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                if ((b3 != -32 || (b4 & 224) != 128) && !isNotContinuation(b4)) {
                    i2 = 2;
                }
                return CoderResult.malformedForLength(i2);
            } else if (i == 4) {
                int i3 = byteBuffer.get() & 255;
                int i4 = byteBuffer.get() & 255;
                if (i3 > 244 || ((i3 == 240 && (i4 < 144 || i4 > 191)) || ((i3 == 244 && (i4 & 240) != 128) || isNotContinuation(i4)))) {
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

    public static void updatePositions(Buffer buffer, int i, Buffer buffer2, int i2) {
        buffer.position(i);
        buffer2.position(i2);
    }

    public static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        updatePositions(buffer, i, buffer2, i3);
        return (i4 == 0 || i2 - i < i4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
