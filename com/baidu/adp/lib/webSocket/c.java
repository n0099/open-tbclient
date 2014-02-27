package com.baidu.adp.lib.webSocket;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class c extends OutputStream {
    private final int a;
    private final int b;
    private ByteBuffer c;

    public c() {
        this(AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED);
    }

    public c(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = ByteBuffer.allocateDirect(this.a);
        this.c.clear();
    }

    public final ByteBuffer a() {
        return this.c;
    }

    public final Buffer b() {
        return this.c.flip();
    }

    public final Buffer c() {
        return this.c.clear();
    }

    public final int d() {
        return this.c.remaining();
    }

    private synchronized void a(int i) {
        if (i > this.c.capacity()) {
            ByteBuffer byteBuffer = this.c;
            int position = this.c.position();
            this.c = ByteBuffer.allocateDirect(((i / this.b) + 1) * this.b);
            byteBuffer.clear();
            this.c.clear();
            this.c.put(byteBuffer);
            this.c.position(position);
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        if (this.c.position() + 1 > this.c.capacity()) {
            a(this.c.capacity() + 1);
        }
        this.c.put((byte) i);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (this.c.position() + i2 > this.c.capacity()) {
            a(this.c.capacity() + i2);
        }
        this.c.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final synchronized void a(String str) {
        write(str.getBytes("UTF-8"));
    }

    public final synchronized void e() {
        write(13);
        write(10);
    }
}
