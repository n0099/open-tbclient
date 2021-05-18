package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class co extends cr implements cn {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f8876a = ByteBuffer.allocate(0);

    /* renamed from: f  reason: collision with root package name */
    public int f8877f;

    /* renamed from: g  reason: collision with root package name */
    public String f8878g;

    public co() {
        super(cq.a.CLOSING);
        a(true);
    }

    private void a(int i2, String str) throws ch {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i2 == 1015) {
            i2 = 1005;
        } else {
            str2 = str;
        }
        if (i2 == 1005) {
            if (str2.length() > 0) {
                throw new ch(1002, "A close frame must have a closecode if it has a reason");
            }
        } else if (i2 > 1011 && i2 < 3000 && i2 != 1015) {
            throw new ch(1002, "Trying to send an illegal close code!");
        } else {
            byte[] a2 = dc.a(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i2);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(a2.length + 2);
            allocate2.put(allocate);
            allocate2.put(a2);
            allocate2.rewind();
            a(allocate2);
        }
    }

    private void g() throws ci {
        this.f8877f = 1005;
        ByteBuffer c2 = super.c();
        c2.mark();
        if (c2.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(c2.getShort());
            allocate.position(0);
            int i2 = allocate.getInt();
            this.f8877f = i2;
            if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
                throw new ci("closecode must not be sent over the wire: " + this.f8877f);
            }
        }
        c2.reset();
    }

    private void h() throws ch {
        if (this.f8877f == 1005) {
            this.f8878g = dc.a(super.c());
            return;
        }
        ByteBuffer c2 = super.c();
        int position = c2.position();
        try {
            try {
                c2.position(c2.position() + 2);
                this.f8878g = dc.a(c2);
            } catch (IllegalArgumentException e2) {
                throw new ci(e2);
            }
        } finally {
            c2.position(position);
        }
    }

    @Override // com.baidu.mobstat.cn
    public String b() {
        return this.f8878g;
    }

    @Override // com.baidu.mobstat.cr, com.baidu.mobstat.cq
    public ByteBuffer c() {
        if (this.f8877f == 1005) {
            return f8876a;
        }
        return super.c();
    }

    @Override // com.baidu.mobstat.cr
    public String toString() {
        return super.toString() + "code: " + this.f8877f;
    }

    public co(int i2, String str) throws ch {
        super(cq.a.CLOSING);
        a(true);
        a(i2, str);
    }

    @Override // com.baidu.mobstat.cn
    public int a() {
        return this.f8877f;
    }

    @Override // com.baidu.mobstat.cr, com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        super.a(byteBuffer);
        g();
        h();
    }
}
