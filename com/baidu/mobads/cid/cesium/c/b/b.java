package com.baidu.mobads.cid.cesium.c.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f8150a = c(new byte[]{Constants.SHORT_PING_CMD_TYPE, 120, 112, 97, 110, 100, 32, 51, 50, UtilsBlink.VER_TYPE_SEPARATOR, 98, 121, 116, Constants.SHORT_PING_CMD_TYPE, 32, 107});

    /* renamed from: b  reason: collision with root package name */
    public final int f8151b;

    public b(int i) {
        this.f8151b = i;
    }

    public static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer2.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer a2 = a(bArr, bArr2, this.f8151b + i2);
            if (i2 == i - 1) {
                a.a(byteBuffer, byteBuffer2, a2, remaining % 64);
            } else {
                a.a(byteBuffer, byteBuffer2, a2, 64);
            }
        }
    }

    public static void a(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    public static void a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = a(iArr[i2] ^ iArr[i3], 7);
    }

    public static void a(int[] iArr, int[] iArr2) {
        int[] iArr3 = f8150a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, f8150a.length, 8);
    }

    public static int[] c(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public int a() {
        return 12;
    }

    public ByteBuffer a(byte[] bArr, byte[] bArr2, int i) {
        int[] a2 = a(c(bArr), c(bArr2), i);
        int[] iArr = (int[]) a2.clone();
        a(iArr);
        for (int i2 = 0; i2 < a2.length; i2++) {
            a2[i2] = a2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(a2, 0, 16);
        return order;
    }

    public void a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("data output is too small");
        }
        if (bArr2 == null) {
            bArr2 = new byte[a()];
            new Random().nextBytes(bArr2);
        }
        byteBuffer.put(bArr2);
        a(bArr2, com.baidu.mobads.cid.cesium.c.c.b.a(), byteBuffer, ByteBuffer.wrap(bArr));
    }

    public byte[] a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= a()) {
            byte[] bArr = new byte[a()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            a(bArr, com.baidu.mobads.cid.cesium.c.c.b.b(), allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    public byte[] a(byte[] bArr) {
        return a(bArr, (byte[]) null);
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= Integer.MAX_VALUE - a()) {
            ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
            a(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too long");
    }

    public int[] a(int[] iArr, int[] iArr2, int i) {
        if (iArr.length == a() / 4) {
            int[] iArr3 = new int[16];
            a(iArr3, iArr2);
            iArr3[12] = i;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
    }

    public byte[] b(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }
}
