package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f9074b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f9075a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9076c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f9077d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9078e;

    public cr() {
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.f9076c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.f9078e = z;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.f9075a;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.f9076c;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.f9078e;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.f9077d;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f9075a.position() + ", len:" + this.f9075a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f9075a.array()))) + "}";
    }

    public cr(cq.a aVar) {
        this.f9077d = aVar;
        this.f9075a = ByteBuffer.wrap(f9074b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.f9077d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.f9075a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f9075a == null) {
            this.f9075a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f9075a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f9075a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f9075a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f9075a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f9075a.capacity());
                this.f9075a.flip();
                allocate.put(this.f9075a);
                allocate.put(c2);
                this.f9075a = allocate;
            } else {
                this.f9075a.put(c2);
            }
            this.f9075a.rewind();
            c2.reset();
        }
        this.f9076c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f9076c = cqVar.d();
        this.f9077d = cqVar.f();
        this.f9075a = cqVar.c();
        this.f9078e = cqVar.e();
    }
}
