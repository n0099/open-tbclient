package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
/* loaded from: classes4.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    private static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        switch (i) {
            case 1:
                byte b = byteBuffer.get();
                if ((b >> 2) == -2) {
                    return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
                } else if ((b >> 1) == -2) {
                    if (byteBuffer.remaining() < 5) {
                        return CoderResult.UNDERFLOW;
                    }
                    return lookupN(byteBuffer, 6);
                } else {
                    return CoderResult.malformedForLength(1);
                }
            case 2:
                return CoderResult.malformedForLength(1);
            case 3:
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                return CoderResult.malformedForLength(((b2 == -32 && (b3 & 224) == 128) || isNotContinuation(b3)) ? 1 : 2);
            case 4:
                int i2 = byteBuffer.get() & 255;
                int i3 = byteBuffer.get() & 255;
                return (i2 > 244 || (i2 == 240 && (i3 < 144 || i3 > 191)) || ((i2 == 244 && (i3 & 240) != 128) || isNotContinuation(i3))) ? CoderResult.malformedForLength(1) : isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
            default:
                throw new IllegalStateException();
        }
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i3);
        updatePositions(byteBuffer, i, charBuffer, i2);
        return malformedN;
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        updatePositions(buffer, i, buffer2, i3);
        return (i4 == 0 || i2 - i < i4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    private CoderResult decodeArrayLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i;
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position() + byteBuffer.arrayOffset();
        int limit = byteBuffer.limit() + byteBuffer.arrayOffset();
        char[] array2 = charBuffer.array();
        int arrayOffset = charBuffer.arrayOffset() + charBuffer.position();
        int arrayOffset2 = charBuffer.arrayOffset() + charBuffer.limit();
        int min = arrayOffset + Math.min(limit - position, arrayOffset2 - arrayOffset);
        while (arrayOffset < min && array[position] >= 0) {
            array2[arrayOffset] = (char) array[position];
            arrayOffset++;
            position++;
        }
        while (position < limit) {
            byte b = array[position];
            if (b >= 0) {
                if (arrayOffset >= arrayOffset2) {
                    return xflow(byteBuffer, position, limit, charBuffer, arrayOffset, 1);
                }
                i = arrayOffset + 1;
                array2[arrayOffset] = (char) b;
                position++;
            } else if ((b >> 5) == -2) {
                if (limit - position < 2 || arrayOffset >= arrayOffset2) {
                    return xflow(byteBuffer, position, limit, charBuffer, arrayOffset, 2);
                }
                byte b2 = array[position + 1];
                if (isMalformed2(b, b2)) {
                    return malformed(byteBuffer, position, charBuffer, arrayOffset, 2);
                }
                i = arrayOffset + 1;
                array2[arrayOffset] = (char) (((b << 6) ^ b2) ^ 3968);
                position += 2;
            } else if ((b >> 4) == -2) {
                if (limit - position < 3 || arrayOffset >= arrayOffset2) {
                    return xflow(byteBuffer, position, limit, charBuffer, arrayOffset, 3);
                }
                byte b3 = array[position + 1];
                byte b4 = array[position + 2];
                if (isMalformed3(b, b3, b4)) {
                    return malformed(byteBuffer, position, charBuffer, arrayOffset, 3);
                }
                i = arrayOffset + 1;
                array2[arrayOffset] = (char) ((((b << 12) ^ (b3 << 6)) ^ b4) ^ 8064);
                position += 3;
            } else if ((b >> 3) == -2) {
                if (limit - position < 4 || arrayOffset2 - arrayOffset < 2) {
                    return xflow(byteBuffer, position, limit, charBuffer, arrayOffset, 4);
                }
                byte b5 = array[position + 1];
                byte b6 = array[position + 2];
                byte b7 = array[position + 3];
                int i2 = ((b & 7) << 18) | ((b5 & 63) << 12) | ((b6 & 63) << 6) | (b7 & 63);
                if (isMalformed4(b5, b6, b7) || !Surrogate.neededFor(i2)) {
                    return malformed(byteBuffer, position, charBuffer, arrayOffset, 4);
                }
                int i3 = arrayOffset + 1;
                array2[arrayOffset] = Surrogate.high(i2);
                i = i3 + 1;
                array2[i3] = Surrogate.low(i2);
                position += 4;
            } else {
                return malformed(byteBuffer, position, charBuffer, arrayOffset, 1);
            }
            arrayOffset = i;
        }
        return xflow(byteBuffer, position, limit, charBuffer, arrayOffset, 0);
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }

    static void updatePositions(Buffer buffer, int i, Buffer buffer2, int i2) {
        buffer.position(i);
        buffer2.position(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Surrogate {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        static {
            $assertionsDisabled = !UTF8Decoder.class.desiredAssertionStatus();
        }

        private Surrogate() {
        }

        public static boolean neededFor(int i) {
            return i >= 65536 && i <= 1114111;
        }

        public static char high(int i) {
            if ($assertionsDisabled || neededFor(i)) {
                return (char) (55296 | (((i - 65536) >> 10) & 1023));
            }
            throw new AssertionError();
        }

        public static char low(int i) {
            if ($assertionsDisabled || neededFor(i)) {
                return (char) (56320 | ((i - 65536) & 1023));
            }
            throw new AssertionError();
        }
    }
}
