package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    protected static byte[] f3835b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f3836a;
    protected boolean c;
    protected cq.a d;
    protected boolean e;

    public cr() {
    }

    public cr(cq.a aVar) {
        this.d = aVar;
        this.f3836a = ByteBuffer.wrap(f3835b);
    }

    public cr(cq cqVar) {
        this.c = cqVar.d();
        this.d = cqVar.f();
        this.f3836a = cqVar.c();
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
        return this.f3836a;
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
        this.f3836a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c = cqVar.c();
        if (this.f3836a == null) {
            this.f3836a = ByteBuffer.allocate(c.remaining());
            c.mark();
            this.f3836a.put(c);
            c.reset();
        } else {
            c.mark();
            this.f3836a.position(this.f3836a.limit());
            this.f3836a.limit(this.f3836a.capacity());
            if (c.remaining() > this.f3836a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + this.f3836a.capacity());
                this.f3836a.flip();
                allocate.put(this.f3836a);
                allocate.put(c);
                this.f3836a = allocate;
            } else {
                this.f3836a.put(c);
            }
            this.f3836a.rewind();
            c.reset();
        }
        this.c = cqVar.d();
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f3836a.position() + ", len:" + this.f3836a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f3836a.array()))) + "}";
    }
}
