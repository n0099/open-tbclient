package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8886b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f8887a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8888c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f8889d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8890e;

    public cr() {
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.f8888c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.f8890e = z;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.f8887a;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.f8888c;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.f8890e;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.f8889d;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f8887a.position() + ", len:" + this.f8887a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f8887a.array()))) + "}";
    }

    public cr(cq.a aVar) {
        this.f8889d = aVar;
        this.f8887a = ByteBuffer.wrap(f8886b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.f8889d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.f8887a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f8887a == null) {
            this.f8887a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f8887a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f8887a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f8887a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f8887a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f8887a.capacity());
                this.f8887a.flip();
                allocate.put(this.f8887a);
                allocate.put(c2);
                this.f8887a = allocate;
            } else {
                this.f8887a.put(c2);
            }
            this.f8887a.rewind();
            c2.reset();
        }
        this.f8888c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f8888c = cqVar.d();
        this.f8889d = cqVar.f();
        this.f8887a = cqVar.c();
        this.f8890e = cqVar.e();
    }
}
