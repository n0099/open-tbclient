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
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class ce extends cd {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f8744f = !ce.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f8745g;

    /* renamed from: h  reason: collision with root package name */
    public final Random f8746h = new Random();

    /* loaded from: classes2.dex */
    public class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        public int f8748b;

        public a(int i) {
            this.f8748b = i;
        }

        public int a() {
            return this.f8748b;
        }
    }

    @Override // com.baidu.mobstat.cd
    public cd.b a(cs csVar, cz czVar) throws cj {
        if (csVar.c("Sec-WebSocket-Key") && czVar.c("Sec-WebSocket-Accept")) {
            if (a(csVar.b("Sec-WebSocket-Key")).equals(czVar.b("Sec-WebSocket-Accept"))) {
                return cd.b.MATCHED;
            }
            return cd.b.NOT_MATCHED;
        }
        return cd.b.NOT_MATCHED;
    }

    @Override // com.baidu.mobstat.cd
    public cd.a b() {
        return cd.a.TWOWAY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009a, code lost:
        if (r6.hasRemaining() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009c, code lost:
        r6.mark();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009f, code lost:
        r0.add(e(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
        r6.reset();
        r1 = java.nio.ByteBuffer.allocate(a(r1.a()));
        r5.f8745g = r1;
        r1.put(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bc, code lost:
        return r0;
     */
    @Override // com.baidu.mobstat.cd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<cq> c(ByteBuffer byteBuffer) throws ck, ch {
        while (true) {
            LinkedList linkedList = new LinkedList();
            if (this.f8745g == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f8745g.remaining();
                if (remaining2 > remaining) {
                    this.f8745g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f8745g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.f8745g.duplicate().position(0)));
                this.f8745g = null;
            } catch (a e2) {
                this.f8745g.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e2.a()));
                if (!f8744f && allocate.limit() <= this.f8745g.limit()) {
                    throw new AssertionError();
                }
                this.f8745g.rewind();
                allocate.put(this.f8745g);
                this.f8745g = allocate;
            }
        }
    }

    public cq e(ByteBuffer byteBuffer) throws a, ch {
        cp crVar;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining >= 2) {
            byte b2 = byteBuffer.get();
            boolean z = (b2 >> 8) != 0;
            byte b3 = (byte) ((b2 & ByteCompanionObject.MAX_VALUE) >> 4);
            if (b3 == 0) {
                byte b4 = byteBuffer.get();
                boolean z2 = (b4 & ByteCompanionObject.MIN_VALUE) != 0;
                int i2 = (byte) (b4 & ByteCompanionObject.MAX_VALUE);
                cq.a a2 = a((byte) (b2 & 15));
                if (z || !(a2 == cq.a.PING || a2 == cq.a.PONG || a2 == cq.a.CLOSING)) {
                    if (i2 < 0 || i2 > 125) {
                        if (a2 == cq.a.PING || a2 == cq.a.PONG || a2 == cq.a.CLOSING) {
                            throw new ci("more than 125 octets");
                        }
                        if (i2 != 126) {
                            i = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i3 = 0; i3 < 8; i3++) {
                                    bArr[i3] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue > 2147483647L) {
                                    throw new ck("Payloadsize is to big...");
                                }
                                i2 = (int) longValue;
                            } else {
                                throw new a(10);
                            }
                        } else if (remaining >= 4) {
                            i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                            i = 4;
                        } else {
                            throw new a(4);
                        }
                    }
                    int i4 = i + (z2 ? 4 : 0) + i2;
                    if (remaining >= i4) {
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
                        if (a2 != cq.a.TEXT || dc.b(crVar.c())) {
                            return crVar;
                        }
                        throw new ch(1007);
                    }
                    throw new a(i4);
                }
                throw new ci("control frames may no be fragmented");
            }
            throw new ci("bad rsv " + ((int) b3));
        }
        throw new a(2);
    }

    @Override // com.baidu.mobstat.cd
    public ByteBuffer a(cq cqVar) {
        ByteBuffer c2 = cqVar.c();
        int i = 0;
        boolean z = this.f8735d == by.b.CLIENT;
        int i2 = c2.remaining() <= 125 ? 1 : c2.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0) + c2.remaining());
        byte a2 = a(cqVar.f());
        boolean d2 = cqVar.d();
        byte b2 = ByteCompanionObject.MIN_VALUE;
        allocate.put((byte) (((byte) (d2 ? com.alipay.sdk.encrypt.a.f1921g : 0)) | a2));
        byte[] a3 = a(c2.remaining(), i2);
        if (f8744f || a3.length == i2) {
            if (i2 == 1) {
                byte b3 = a3[0];
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b3 | b2));
            } else if (i2 == 2) {
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b2 | 126));
                allocate.put(a3);
            } else if (i2 == 8) {
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b2 | ByteCompanionObject.MAX_VALUE));
                allocate.put(a3);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.f8746h.nextInt());
                allocate.put(allocate2.array());
                while (c2.hasRemaining()) {
                    allocate.put((byte) (c2.get() ^ allocate2.get(i % 4)));
                    i++;
                }
            } else {
                allocate.put(c2);
            }
            if (f8744f || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    @Override // com.baidu.mobstat.cd
    public cd c() {
        return new ce();
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
        } catch (ch e2) {
            throw new cl(e2);
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
            return db.a(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.baidu.mobstat.cd
    public ct a(ct ctVar) {
        ctVar.a("Upgrade", "websocket");
        ctVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
        ctVar.a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.f8746h.nextBytes(bArr);
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
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 != 2) {
                    switch (b2) {
                        case 8:
                            return cq.a.CLOSING;
                        case 9:
                            return cq.a.PING;
                        case 10:
                            return cq.a.PONG;
                        default:
                            throw new ci("unknow optcode " + ((int) b2));
                    }
                }
                return cq.a.BINARY;
            }
            return cq.a.TEXT;
        }
        return cq.a.CONTINUOUS;
    }

    @Override // com.baidu.mobstat.cd
    public void a() {
        this.f8745g = null;
    }
}
