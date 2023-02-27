package com.baidu.mobstat;

import com.baidu.mobstat.cw;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cx implements cv {
    public static byte[] b = new byte[0];
    public ByteBuffer a;
    public boolean c;
    public cw.a d;
    public boolean e;

    public cx() {
    }

    @Override // com.baidu.mobstat.cw
    public ByteBuffer c() {
        return this.a;
    }

    @Override // com.baidu.mobstat.cw
    public boolean d() {
        return this.c;
    }

    @Override // com.baidu.mobstat.cw
    public boolean e() {
        return this.e;
    }

    @Override // com.baidu.mobstat.cw
    public cw.a f() {
        return this.d;
    }

    public cx(cw.a aVar) {
        this.d = aVar;
        this.a = ByteBuffer.wrap(b);
    }

    @Override // com.baidu.mobstat.cv
    public void a(cw.a aVar) {
        this.d = aVar;
    }

    @Override // com.baidu.mobstat.cv
    public void b(boolean z) {
        this.e = z;
    }

    public cx(cw cwVar) {
        this.c = cwVar.d();
        this.d = cwVar.f();
        this.a = cwVar.c();
        this.e = cwVar.e();
    }

    @Override // com.baidu.mobstat.cv
    public void a(ByteBuffer byteBuffer) throws cn {
        this.a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cw
    public void a(cw cwVar) throws co {
        ByteBuffer c = cwVar.c();
        if (this.a == null) {
            this.a = ByteBuffer.allocate(c.remaining());
            c.mark();
            this.a.put(c);
            c.reset();
        } else {
            c.mark();
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c.remaining() > this.a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + this.a.capacity());
                this.a.flip();
                allocate.put(this.a);
                allocate.put(c);
                this.a = allocate;
            } else {
                this.a.put(c);
            }
            this.a.rewind();
            c.reset();
        }
        this.c = cwVar.d();
    }

    @Override // com.baidu.mobstat.cv
    public void a(boolean z) {
        this.c = z;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(di.a(new String(this.a.array()))) + "}";
    }
}
