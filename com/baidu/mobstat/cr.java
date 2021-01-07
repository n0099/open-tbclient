package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    protected static byte[] f3836b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f3837a;
    protected boolean c;
    protected cq.a d;
    protected boolean e;

    public cr() {
    }

    public cr(cq.a aVar) {
        this.d = aVar;
        this.f3837a = ByteBuffer.wrap(f3836b);
    }

    public cr(cq cqVar) {
        this.c = cqVar.d();
        this.d = cqVar.f();
        this.f3837a = cqVar.c();
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
        return this.f3837a;
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
        this.f3837a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c = cqVar.c();
        if (this.f3837a == null) {
            this.f3837a = ByteBuffer.allocate(c.remaining());
            c.mark();
            this.f3837a.put(c);
            c.reset();
        } else {
            c.mark();
            this.f3837a.position(this.f3837a.limit());
            this.f3837a.limit(this.f3837a.capacity());
            if (c.remaining() > this.f3837a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + this.f3837a.capacity());
                this.f3837a.flip();
                allocate.put(this.f3837a);
                allocate.put(c);
                this.f3837a = allocate;
            } else {
                this.f3837a.put(c);
            }
            this.f3837a.rewind();
            c.reset();
        }
        this.c = cqVar.d();
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f3837a.position() + ", len:" + this.f3837a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f3837a.array()))) + "}";
    }
}
