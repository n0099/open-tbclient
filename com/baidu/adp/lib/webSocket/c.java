package com.baidu.adp.lib.webSocket;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends OutputStream {
    private final int oU;
    private final int oV;
    private ByteBuffer oW;

    public c() {
        this(AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED);
    }

    public c(int i, int i2) {
        this.oU = i;
        this.oV = i2;
        this.oW = ByteBuffer.allocateDirect(this.oU);
        this.oW.clear();
    }

    public ByteBuffer fN() {
        return this.oW;
    }

    public Buffer flip() {
        return this.oW.flip();
    }

    public Buffer clear() {
        return this.oW.clear();
    }

    public int remaining() {
        return this.oW.remaining();
    }

    public synchronized void aa(int i) {
        if (i > this.oW.capacity()) {
            ByteBuffer byteBuffer = this.oW;
            int position = this.oW.position();
            this.oW = ByteBuffer.allocateDirect(((i / this.oV) + 1) * this.oV);
            byteBuffer.clear();
            this.oW.clear();
            this.oW.put(byteBuffer);
            this.oW.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.oW.position() + 1 > this.oW.capacity()) {
            aa(this.oW.capacity() + 1);
        }
        this.oW.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.oW.position() + i2 > this.oW.capacity()) {
            aa(this.oW.capacity() + i2);
        }
        this.oW.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void fO() {
        write(13);
        write(10);
    }
}
