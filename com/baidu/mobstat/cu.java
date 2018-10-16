package com.baidu.mobstat;

import com.baidu.mobstat.cw;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class cu extends cx implements ct {
    static final ByteBuffer a = ByteBuffer.allocate(0);
    private int f;
    private String g;

    public cu() {
        super(cw.a.CLOSING);
        a(true);
    }

    public cu(int i, String str) throws cn {
        super(cw.a.CLOSING);
        a(true);
        a(i, str);
    }

    private void a(int i, String str) throws cn {
        String str2 = str == null ? "" : str;
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i == 1005) {
            if (str2.length() > 0) {
                throw new cn(1002, "A close frame must have a closecode if it has a reason");
            }
        } else if (i > 1011 && i < 3000 && i != 1015) {
            throw new cn(1002, "Trying to send an illegal close code!");
        } else {
            byte[] a2 = di.a(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(a2.length + 2);
            allocate2.put(allocate);
            allocate2.put(a2);
            allocate2.rewind();
            a(allocate2);
        }
    }

    private void g() throws co {
        this.f = 1005;
        ByteBuffer c = super.c();
        c.mark();
        if (c.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(c.getShort());
            allocate.position(0);
            this.f = allocate.getInt();
            if (this.f == 1006 || this.f == 1015 || this.f == 1005 || this.f > 4999 || this.f < 1000 || this.f == 1004) {
                throw new co("closecode must not be sent over the wire: " + this.f);
            }
        }
        c.reset();
    }

    @Override // com.baidu.mobstat.ct
    public int a() {
        return this.f;
    }

    private void h() throws cn {
        if (this.f == 1005) {
            this.g = di.a(super.c());
            return;
        }
        ByteBuffer c = super.c();
        int position = c.position();
        try {
            try {
                c.position(c.position() + 2);
                this.g = di.a(c);
            } catch (IllegalArgumentException e) {
                throw new co(e);
            }
        } finally {
            c.position(position);
        }
    }

    @Override // com.baidu.mobstat.ct
    public String b() {
        return this.g;
    }

    @Override // com.baidu.mobstat.cx
    public String toString() {
        return super.toString() + "code: " + this.f;
    }

    @Override // com.baidu.mobstat.cx, com.baidu.mobstat.cv
    public void a(ByteBuffer byteBuffer) throws cn {
        super.a(byteBuffer);
        g();
        h();
    }

    @Override // com.baidu.mobstat.cx, com.baidu.mobstat.cw
    public ByteBuffer c() {
        return this.f == 1005 ? a : super.c();
    }
}
