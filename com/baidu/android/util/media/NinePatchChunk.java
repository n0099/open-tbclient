package com.baidu.android.util.media;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes15.dex */
public class NinePatchChunk {
    public int[] mColor;
    public int[] mDivX;
    public int[] mDivY;
    public Rect mPaddings = new Rect();

    private static void readIntArray(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }

    private static void checkDivCount(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static NinePatchChunk deserialize(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        order.get();
        NinePatchChunk ninePatchChunk = new NinePatchChunk();
        ninePatchChunk.mDivX = new int[order.get()];
        ninePatchChunk.mDivY = new int[order.get()];
        ninePatchChunk.mColor = new int[order.get()];
        checkDivCount(ninePatchChunk.mDivX.length);
        checkDivCount(ninePatchChunk.mDivY.length);
        order.getInt();
        order.getInt();
        ninePatchChunk.mPaddings.left = order.getInt();
        ninePatchChunk.mPaddings.right = order.getInt();
        ninePatchChunk.mPaddings.top = order.getInt();
        ninePatchChunk.mPaddings.bottom = order.getInt();
        order.getInt();
        readIntArray(ninePatchChunk.mDivX, order);
        readIntArray(ninePatchChunk.mDivY, order);
        readIntArray(ninePatchChunk.mColor, order);
        return ninePatchChunk;
    }
}
