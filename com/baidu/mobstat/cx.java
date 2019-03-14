package com.baidu.mobstat;

import com.baidu.mobstat.cw;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class cx implements cv {
    protected static byte[] b = new byte[0];
    private ByteBuffer a;
    protected boolean c;
    protected cw.a d;
    protected boolean e;

    public cx() {
    }

    public cx(cw.a aVar) {
        this.d = aVar;
        this.a = ByteBuffer.wrap(b);
    }

    public cx(cw cwVar) {
        this.c = cwVar.d();
        this.d = cwVar.f();
        this.a = cwVar.c();
        this.e = cwVar.e();
    }

    @Override // com.baidu.mobstat.cw
    public boolean d() {
        return this.c;
    }

    @Override // com.baidu.mobstat.cw
    public cw.a f() {
        return this.d;
    }

    @Override // com.baidu.mobstat.cw
    public boolean e() {
        return this.e;
    }

    @Override // com.baidu.mobstat.cw
    public ByteBuffer c() {
        return this.a;
    }

    @Override // com.baidu.mobstat.cv
    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.mobstat.cv
    public void a(cw.a aVar) {
        this.d = aVar;
    }

    @Override // com.baidu.mobstat.cv
    public void a(ByteBuffer byteBuffer) throws cn {
        this.a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cv
    public void b(boolean z) {
        this.e = z;
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
            this.a.position(this.a.limit());
            this.a.limit(this.a.capacity());
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

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(di.a(new String(this.a.array()))) + "}";
    }
}
