package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cr implements cp {

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f9187b = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f9188a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9189c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f9190d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9191e;

    public cr() {
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        this.f9189c = z;
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        this.f9191e = z;
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        return this.f9188a;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        return this.f9189c;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        return this.f9191e;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        return this.f9190d;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f9188a.position() + ", len:" + this.f9188a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f9188a.array()))) + "}";
    }

    public cr(cq.a aVar) {
        this.f9190d = aVar;
        this.f9188a = ByteBuffer.wrap(f9187b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        this.f9190d = aVar;
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        this.f9188a = byteBuffer;
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f9188a == null) {
            this.f9188a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f9188a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f9188a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f9188a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f9188a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f9188a.capacity());
                this.f9188a.flip();
                allocate.put(this.f9188a);
                allocate.put(c2);
                this.f9188a = allocate;
            } else {
                this.f9188a.put(c2);
            }
            this.f9188a.rewind();
            c2.reset();
        }
        this.f9189c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f9189c = cqVar.d();
        this.f9190d = cqVar.f();
        this.f9188a = cqVar.c();
        this.f9191e = cqVar.e();
    }
}
