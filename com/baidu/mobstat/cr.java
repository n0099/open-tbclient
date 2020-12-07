package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class cr implements cp {
    protected static byte[] b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f2611a;
    protected boolean c;
    protected cq.a d;
    protected boolean e;

    public cr() {
    }

    public cr(cq.a aVar) {
        this.d = aVar;
        this.f2611a = ByteBuffer.wrap(b);
    }

    public cr(cq cqVar) {
        this.c = cqVar.d();
        this.d = cqVar.f();
        this.f2611a = cqVar.c();
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
        return this.f2611a;
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
        this.f2611a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c = cqVar.c();
        if (this.f2611a == null) {
            this.f2611a = ByteBuffer.allocate(c.remaining());
            c.mark();
            this.f2611a.put(c);
            c.reset();
        } else {
            c.mark();
            this.f2611a.position(this.f2611a.limit());
            this.f2611a.limit(this.f2611a.capacity());
            if (c.remaining() > this.f2611a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + this.f2611a.capacity());
                this.f2611a.flip();
                allocate.put(this.f2611a);
                allocate.put(c);
                this.f2611a = allocate;
            } else {
                this.f2611a.put(c);
            }
            this.f2611a.rewind();
            c.reset();
        }
        this.c = cqVar.d();
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f2611a.position() + ", len:" + this.f2611a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f2611a.array()))) + "}";
    }
}
