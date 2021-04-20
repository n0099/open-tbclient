package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8761b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f8762a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8763c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f8764d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8765e;

    public cr() {
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.f8763c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.f8765e = z;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.f8762a;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.f8763c;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.f8765e;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.f8764d;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f8762a.position() + ", len:" + this.f8762a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f8762a.array()))) + "}";
    }

    public cr(cq.a aVar) {
        this.f8764d = aVar;
        this.f8762a = ByteBuffer.wrap(f8761b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.f8764d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.f8762a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f8762a == null) {
            this.f8762a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f8762a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f8762a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f8762a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f8762a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f8762a.capacity());
                this.f8762a.flip();
                allocate.put(this.f8762a);
                allocate.put(c2);
                this.f8762a = allocate;
            } else {
                this.f8762a.put(c2);
            }
            this.f8762a.rewind();
            c2.reset();
        }
        this.f8763c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f8763c = cqVar.d();
        this.f8764d = cqVar.f();
        this.f8762a = cqVar.c();
        this.f8765e = cqVar.e();
    }
}
