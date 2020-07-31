package com.baidu.ala.recorder.video.gles;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class GeneratedTexture {
    private static final int BLACK = 0;
    private static final int BLUE = 16711680;
    private static final int BYTES_PER_PIXEL = 4;
    private static final int CYAN = 16776960;
    private static final int FORMAT = 6408;
    private static final int GREEN = 65280;
    private static final int HALF = Integer.MIN_VALUE;
    private static final int LOW = 1073741824;
    private static final int MAGENTA = 16711935;
    private static final int OPAQUE = -16777216;
    private static final int RED = 255;
    private static final int TEX_SIZE = 64;
    private static final int TRANSP = 0;
    private static final int WHITE = 16777215;
    private static final int YELLOW = 65535;
    private static final int[] GRID = {-16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, 65280, -2147483393, -16777216, InputDeviceCompat.SOURCE_ANY, -65281, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
    private static final ByteBuffer sCoarseImageData = generateCoarseData();
    private static final ByteBuffer sFineImageData = generateFineData();

    /* loaded from: classes7.dex */
    public enum Image {
        COARSE,
        FINE
    }

    public static int createTestTexture(Image image) {
        ByteBuffer byteBuffer;
        switch (image) {
            case COARSE:
                byteBuffer = sCoarseImageData;
                break;
            case FINE:
                byteBuffer = sFineImageData;
                break;
            default:
                throw new RuntimeException("unknown image");
        }
        return GlUtil.createImageTexture(byteBuffer, 64, 64, FORMAT);
    }

    private static ByteBuffer generateCoarseData() {
        byte[] bArr = new byte[16384];
        for (int i = 0; i < bArr.length; i += 4) {
            int i2 = GRID[((((i / 4) / 64) / 16) * 4) + (((i / 4) % 64) / 16)];
            if (i == 0) {
                i2 = -1;
            } else if (i == bArr.length - 4) {
                i2 = -1;
            }
            int i3 = i2 & 255;
            int i4 = (i2 >> 24) & 255;
            float f = i4 / 255.0f;
            bArr[i] = (byte) (i3 * f);
            bArr[i + 1] = (byte) (((i2 >> 8) & 255) * f);
            bArr[i + 2] = (byte) (((i2 >> 16) & 255) * f);
            bArr[i + 3] = (byte) i4;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        return allocateDirect;
    }

    private static ByteBuffer generateFineData() {
        byte[] bArr = new byte[16384];
        checkerPattern(bArr, 0, 0, 32, 32, -16776961, SupportMenu.CATEGORY_MASK, 1);
        checkerPattern(bArr, 32, 32, 64, 64, -16776961, -16711936, 2);
        checkerPattern(bArr, 0, 32, 32, 64, SupportMenu.CATEGORY_MASK, -16711936, 4);
        checkerPattern(bArr, 32, 0, 64, 32, -1, -16777216, 8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        return allocateDirect;
    }

    private static void checkerPattern(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        while (i2 < i4) {
            int i8 = i2 * 64 * 4;
            for (int i9 = i; i9 < i3; i9++) {
                int i10 = i8 + (i9 * 4);
                int i11 = ((i2 & i7) ^ (i9 & i7)) == 0 ? i5 : i6;
                int i12 = i11 & 255;
                int i13 = (i11 >> 24) & 255;
                float f = i13 / 255.0f;
                bArr[i10] = (byte) (i12 * f);
                bArr[i10 + 1] = (byte) (((i11 >> 8) & 255) * f);
                bArr[i10 + 2] = (byte) (((i11 >> 16) & 255) * f);
                bArr[i10 + 3] = (byte) i13;
            }
            i2++;
        }
    }
}
