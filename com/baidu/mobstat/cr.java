package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class cr implements cp {
    protected static byte[] b = new byte[0];
    private ByteBuffer a;
    protected boolean c;
    protected cq.a d;
    protected boolean e;

    public cr() {
    }

    public cr(cq.a aVar) {
        this.d = aVar;
        this.a = ByteBuffer.wrap(b);
    }

    public cr(cq cqVar) {
        this.c = cqVar.d();
        this.d = cqVar.f();
        this.a = cqVar.c();
        this.e = cqVar.e();
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.c;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.d;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.e;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.a;
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c = cqVar.c();
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
        this.c = cqVar.d();
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.a.array()))) + "}";
    }
}
