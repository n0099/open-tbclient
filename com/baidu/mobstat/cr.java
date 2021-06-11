package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8848b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f8849a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8850c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f8851d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8852e;

    public cr() {
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.f8850c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.f8852e = z;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.f8849a;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.f8850c;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.f8852e;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.f8851d;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f8849a.position() + ", len:" + this.f8849a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f8849a.array()))) + "}";
    }

    public cr(cq.a aVar) {
        this.f8851d = aVar;
        this.f8849a = ByteBuffer.wrap(f8848b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.f8851d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.f8849a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f8849a == null) {
            this.f8849a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f8849a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f8849a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f8849a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f8849a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f8849a.capacity());
                this.f8849a.flip();
                allocate.put(this.f8849a);
                allocate.put(c2);
                this.f8849a = allocate;
            } else {
                this.f8849a.put(c2);
            }
            this.f8849a.rewind();
            c2.reset();
        }
        this.f8850c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f8850c = cqVar.d();
        this.f8851d = cqVar.f();
        this.f8849a = cqVar.c();
        this.f8852e = cqVar.e();
    }
}
