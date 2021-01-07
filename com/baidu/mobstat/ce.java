package com.baidu.mobstat;

import com.baidu.mobstat.by;
import com.baidu.mobstat.cd;
import com.baidu.mobstat.cq;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* loaded from: classes15.dex */
public class ce extends cd {
    static final /* synthetic */ boolean f;
    private ByteBuffer g;
    private final Random h = new Random();

    static {
        f = !ce.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        private int f3830b;

        public a(int i) {
            this.f3830b = i;
        }

        public int a() {
            return this.f3830b;
        }
    }

    @Override // com.baidu.mobstat.cd
    public cd.b a(cs csVar, cz czVar) throws cj {
        if (!csVar.c("Sec-WebSocket-Key") || !czVar.c("Sec-WebSocket-Accept")) {
            return cd.b.NOT_MATCHED;
        }
        if (a(csVar.b("Sec-WebSocket-Key")).equals(czVar.b("Sec-WebSocket-Accept"))) {
            return cd.b.MATCHED;
        }
        return cd.b.NOT_MATCHED;
    }

    @Override // com.baidu.mobstat.cd
    public ByteBuffer a(cq cqVar) {
        int i;
        int i2 = 0;
        ByteBuffer c = cqVar.c();
        boolean z = this.d == by.b.CLIENT;
        if (c.remaining() <= 125) {
            i = 1;
        } else {
            i = c.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + c.remaining());
        allocate.put((byte) (((byte) (cqVar.d() ? -128 : 0)) | a(cqVar.f())));
        byte[] a2 = a(c.remaining(), i);
        if (f || a2.length == i) {
            if (i == 1) {
                allocate.put((byte) (a2[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
            } else if (i == 2) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                allocate.put(a2);
            } else if (i == 8) {
                allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
                allocate.put(a2);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.h.nextInt());
                allocate.put(allocate2.array());
                while (c.hasRemaining()) {
                    allocate.put((byte) (c.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(c);
            }
            if (f || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    @Override // com.baidu.mobstat.cd
    public List<cq> a(ByteBuffer byteBuffer, boolean z) {
        cr crVar = new cr();
        try {
            crVar.a(byteBuffer);
            crVar.a(true);
            crVar.a(cq.a.BINARY);
            crVar.b(z);
            return Collections.singletonList(crVar);
        } catch (ch e) {
            throw new cl(e);
        }
    }

    private byte a(cq.a aVar) {
        if (aVar == cq.a.CONTINUOUS) {
            return (byte) 0;
        }
        if (aVar == cq.a.TEXT) {
            return (byte) 1;
        }
        if (aVar == cq.a.BINARY) {
            return (byte) 2;
        }
        if (aVar == cq.a.CLOSING) {
            return (byte) 8;
        }
        if (aVar == cq.a.PING) {
            return (byte) 9;
        }
        if (aVar == cq.a.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + aVar.toString());
    }

    private String a(String str) {
        try {
            return db.a(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.baidu.mobstat.cd
    public ct a(ct ctVar) {
        ctVar.a("Upgrade", "websocket");
        ctVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
        ctVar.a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.h.nextBytes(bArr);
        ctVar.a("Sec-WebSocket-Key", db.a(bArr));
        return ctVar;
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    private cq.a a(byte b2) throws ci {
        switch (b2) {
            case 0:
                return cq.a.CONTINUOUS;
            case 1:
                return cq.a.TEXT;
            case 2:
                return cq.a.BINARY;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new ci("unknow optcode " + ((int) b2));
            case 8:
                return cq.a.CLOSING;
            case 9:
                return cq.a.PING;
            case 10:
                return cq.a.PONG;
        }
    }

    @Override // com.baidu.mobstat.cd
    public List<cq> c(ByteBuffer byteBuffer) throws ck, ch {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.g == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.g.remaining();
                if (remaining2 > remaining) {
                    this.g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.g.duplicate().position(0)));
                this.g = null;
            } catch (a e) {
                this.g.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e.a()));
                if (!f && allocate.limit() <= this.g.limit()) {
                    throw new AssertionError();
                }
                this.g.rewind();
                allocate.put(this.g);
                this.g = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(e(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.g = ByteBuffer.allocate(a(e2.a()));
                this.g.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public cq e(ByteBuffer byteBuffer) throws a, ch {
        byte b2;
        cp crVar;
        int i = 2;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new a(2);
        }
        byte b3 = byteBuffer.get();
        boolean z = (b3 >> 8) != 0;
        if (((byte) ((b3 & Byte.MAX_VALUE) >> 4)) != 0) {
            throw new ci("bad rsv " + ((int) b2));
        }
        byte b4 = byteBuffer.get();
        boolean z2 = (b4 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b4 & Byte.MAX_VALUE);
        cq.a a2 = a((byte) (b3 & 15));
        if (!z && (a2 == cq.a.PING || a2 == cq.a.PONG || a2 == cq.a.CLOSING)) {
            throw new ci("control frames may no be fragmented");
        }
        if (i2 < 0 || i2 > 125) {
            if (a2 == cq.a.PING || a2 == cq.a.PONG || a2 == cq.a.CLOSING) {
                throw new ci("more than 125 octets");
            }
            if (i2 == 126) {
                if (remaining < 4) {
                    throw new a(4);
                }
                i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                i = 4;
            } else {
                i = 10;
                if (remaining < 10) {
                    throw new a(10);
                }
                byte[] bArr = new byte[8];
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr[i3] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                if (longValue > 2147483647L) {
                    throw new ck("Payloadsize is to big...");
                }
                i2 = (int) longValue;
            }
        }
        int i4 = (z2 ? 4 : 0) + i + i2;
        if (remaining < i4) {
            throw new a(i4);
        }
        ByteBuffer allocate = ByteBuffer.allocate(a(i2));
        if (z2) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i5 = 0; i5 < i2; i5++) {
                allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
            }
        } else {
            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
            byteBuffer.position(byteBuffer.position() + allocate.limit());
        }
        if (a2 == cq.a.CLOSING) {
            crVar = new co();
        } else {
            crVar = new cr();
            crVar.a(z);
            crVar.a(a2);
        }
        allocate.flip();
        crVar.a(allocate);
        if (a2 == cq.a.TEXT && !dc.b(crVar.c())) {
            throw new ch(1007);
        }
        return crVar;
    }

    @Override // com.baidu.mobstat.cd
    public void a() {
        this.g = null;
    }

    @Override // com.baidu.mobstat.cd
    public cd c() {
        return new ce();
    }

    @Override // com.baidu.mobstat.cd
    public cd.a b() {
        return cd.a.TWOWAY;
    }
}
