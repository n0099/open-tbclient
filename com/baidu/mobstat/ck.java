package com.baidu.mobstat;

import android.support.v4.view.PointerIconCompat;
import com.baidu.mobstat.ce;
import com.baidu.mobstat.cj;
import com.baidu.mobstat.cw;
import com.tencent.connect.common.Constants;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class ck extends cj {
    static final /* synthetic */ boolean f;
    private ByteBuffer g;
    private final Random h = new Random();

    static {
        f = !ck.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends Throwable {
        private int b;

        public a(int i) {
            this.b = i;
        }

        public int a() {
            return this.b;
        }
    }

    @Override // com.baidu.mobstat.cj
    public cj.b a(cy cyVar, df dfVar) throws cp {
        if (!cyVar.c("Sec-WebSocket-Key") || !dfVar.c("Sec-WebSocket-Accept")) {
            return cj.b.NOT_MATCHED;
        }
        if (a(cyVar.b("Sec-WebSocket-Key")).equals(dfVar.b("Sec-WebSocket-Accept"))) {
            return cj.b.MATCHED;
        }
        return cj.b.NOT_MATCHED;
    }

    @Override // com.baidu.mobstat.cj
    public ByteBuffer a(cw cwVar) {
        int i;
        int i2 = 0;
        ByteBuffer c = cwVar.c();
        boolean z = this.d == ce.b.CLIENT;
        if (c.remaining() <= 125) {
            i = 1;
        } else {
            i = c.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate((z ? 4 : 0) + (i > 1 ? i + 1 : i) + 1 + c.remaining());
        allocate.put((byte) (((byte) (cwVar.d() ? -128 : 0)) | a(cwVar.f())));
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

    @Override // com.baidu.mobstat.cj
    public List<cw> a(ByteBuffer byteBuffer, boolean z) {
        cx cxVar = new cx();
        try {
            cxVar.a(byteBuffer);
            cxVar.a(true);
            cxVar.a(cw.a.BINARY);
            cxVar.b(z);
            return Collections.singletonList(cxVar);
        } catch (cn e) {
            throw new cr(e);
        }
    }

    private byte a(cw.a aVar) {
        if (aVar == cw.a.CONTINUOUS) {
            return (byte) 0;
        }
        if (aVar == cw.a.TEXT) {
            return (byte) 1;
        }
        if (aVar == cw.a.BINARY) {
            return (byte) 2;
        }
        if (aVar == cw.a.CLOSING) {
            return (byte) 8;
        }
        if (aVar == cw.a.PING) {
            return (byte) 9;
        }
        if (aVar == cw.a.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + aVar.toString());
    }

    private String a(String str) {
        try {
            return dh.a(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.baidu.mobstat.cj
    public cz a(cz czVar) {
        czVar.a("Upgrade", "websocket");
        czVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
        czVar.a("Sec-WebSocket-Version", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        byte[] bArr = new byte[16];
        this.h.nextBytes(bArr);
        czVar.a("Sec-WebSocket-Key", dh.a(bArr));
        return czVar;
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    private cw.a a(byte b) throws co {
        switch (b) {
            case 0:
                return cw.a.CONTINUOUS;
            case 1:
                return cw.a.TEXT;
            case 2:
                return cw.a.BINARY;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new co("unknow optcode " + ((int) b));
            case 8:
                return cw.a.CLOSING;
            case 9:
                return cw.a.PING;
            case 10:
                return cw.a.PONG;
        }
    }

    @Override // com.baidu.mobstat.cj
    public List<cw> c(ByteBuffer byteBuffer) throws cq, cn {
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

    public cw e(ByteBuffer byteBuffer) throws a, cn {
        byte b;
        cv cxVar;
        int i = 2;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new a(2);
        }
        byte b2 = byteBuffer.get();
        boolean z = (b2 >> 8) != 0;
        if (((byte) ((b2 & Byte.MAX_VALUE) >> 4)) != 0) {
            throw new co("bad rsv " + ((int) b));
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
        int i2 = (byte) (b3 & Byte.MAX_VALUE);
        cw.a a2 = a((byte) (b2 & 15));
        if (!z && (a2 == cw.a.PING || a2 == cw.a.PONG || a2 == cw.a.CLOSING)) {
            throw new co("control frames may no be fragmented");
        }
        if (i2 < 0 || i2 > 125) {
            if (a2 == cw.a.PING || a2 == cw.a.PONG || a2 == cw.a.CLOSING) {
                throw new co("more than 125 octets");
            }
            if (i2 == 126) {
                if (remaining < 4) {
                    throw new a(4);
                }
                i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                i = 4;
            } else if (remaining < 10) {
                throw new a(10);
            } else {
                byte[] bArr = new byte[8];
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr[i3] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                if (longValue <= 2147483647L) {
                    i = 10;
                    i2 = (int) longValue;
                } else {
                    throw new cq("Payloadsize is to big...");
                }
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
        if (a2 == cw.a.CLOSING) {
            cxVar = new cu();
        } else {
            cxVar = new cx();
            cxVar.a(z);
            cxVar.a(a2);
        }
        allocate.flip();
        cxVar.a(allocate);
        if (a2 == cw.a.TEXT && !di.b(cxVar.c())) {
            throw new cn(PointerIconCompat.TYPE_CROSSHAIR);
        }
        return cxVar;
    }

    @Override // com.baidu.mobstat.cj
    public void a() {
        this.g = null;
    }

    @Override // com.baidu.mobstat.cj
    public cj c() {
        return new ck();
    }

    @Override // com.baidu.mobstat.cj
    public cj.a b() {
        return cj.a.TWOWAY;
    }
}
