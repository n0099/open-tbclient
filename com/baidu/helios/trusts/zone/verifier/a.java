package com.baidu.helios.trusts.zone.verifier;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes10.dex */
abstract class a {
    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int i2 = i(allocate);
        if (i2 != -1) {
            allocate.position(i2);
            ByteBuffer slice = allocate.slice();
            slice.order(ByteOrder.LITTLE_ENDIAN);
            return Pair.create(slice, Long.valueOf(capacity + i2));
        }
        return null;
    }

    private static void a(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt(byteBuffer.position() + i, (int) j);
    }

    public static void b(ByteBuffer byteBuffer, long j) {
        d(byteBuffer);
        a(byteBuffer, byteBuffer.position() + 16, j);
    }

    public static final boolean b(RandomAccessFile randomAccessFile, long j) {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == 1347094023;
    }

    private static int c(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    private static long d(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    private static void d(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> e(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a = a(randomAccessFile, 0);
        return a == null ? a(randomAccessFile, 65535) : a;
    }

    private static int i(ByteBuffer byteBuffer) {
        d(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int min = Math.min(capacity - 22, 65535);
        int i = capacity - 22;
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && c(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static long j(ByteBuffer byteBuffer) {
        d(byteBuffer);
        return d(byteBuffer, byteBuffer.position() + 16);
    }

    public static long k(ByteBuffer byteBuffer) {
        d(byteBuffer);
        return d(byteBuffer, byteBuffer.position() + 12);
    }
}
