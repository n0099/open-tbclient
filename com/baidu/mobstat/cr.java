package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f9186b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f9187a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9188c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f9189d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9190e;

    public cr() {
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.f9188c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.f9190e = z;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.f9187a;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.f9188c;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.f9190e;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.f9189d;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f9187a.position() + ", len:" + this.f9187a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f9187a.array()))) + "}";
    }

    public cr(cq.a aVar) {
        this.f9189d = aVar;
        this.f9187a = ByteBuffer.wrap(f9186b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.f9189d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.f9187a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f9187a == null) {
            this.f9187a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f9187a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f9187a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f9187a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f9187a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f9187a.capacity());
                this.f9187a.flip();
                allocate.put(this.f9187a);
                allocate.put(c2);
                this.f9187a = allocate;
            } else {
                this.f9187a.put(c2);
            }
            this.f9187a.rewind();
            c2.reset();
        }
        this.f9188c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f9188c = cqVar.d();
        this.f9189d = cqVar.f();
        this.f9187a = cqVar.c();
        this.f9190e = cqVar.e();
    }
}
