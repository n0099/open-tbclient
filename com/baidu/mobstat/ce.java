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
    public static final /* synthetic */ boolean f8831f = !ce.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f8832g;

    /* renamed from: h  reason: collision with root package name */
    public final Random f8833h = new Random();

    /* loaded from: classes2.dex */
    public class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        public int f8835b;

        public a(int i2) {
            this.f8835b = i2;
        }

        public int a() {
            return this.f8835b;
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
        r5.f8832g = r1;
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
            if (this.f8832g == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f8832g.remaining();
                if (remaining2 > remaining) {
                    this.f8832g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f8832g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.f8832g.duplicate().position(0)));
                this.f8832g = null;
            } catch (a e2) {
                this.f8832g.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e2.a()));
                if (!f8831f && allocate.limit() <= this.f8832g.limit()) {
                    throw new AssertionError();
                }
                this.f8832g.rewind();
                allocate.put(this.f8832g);
                this.f8832g = allocate;
            }
        }
    }

    public cq e(ByteBuffer byteBuffer) throws a, ch {
        cp crVar;
        int remaining = byteBuffer.remaining();
        int i2 = 2;
        if (remaining >= 2) {
            byte b2 = byteBuffer.get();
            boolean z = (b2 >> 8) != 0;
            byte b3 = (byte) ((b2 & ByteCompanionObject.MAX_VALUE) >> 4);
            if (b3 == 0) {
                byte b4 = byteBuffer.get();
                boolean z2 = (b4 & ByteCompanionObject.MIN_VALUE) != 0;
                int i3 = (byte) (b4 & ByteCompanionObject.MAX_VALUE);
                cq.a a2 = a((byte) (b2 & 15));
                if (z || !(a2 == cq.a.PING || a2 == cq.a.PONG || a2 == cq.a.CLOSING)) {
                    if (i3 < 0 || i3 > 125) {
                        if (a2 == cq.a.PING || a2 == cq.a.PONG || a2 == cq.a.CLOSING) {
                            throw new ci("more than 125 octets");
                        }
                        if (i3 != 126) {
                            i2 = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i4 = 0; i4 < 8; i4++) {
                                    bArr[i4] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue > 2147483647L) {
                                    throw new ck("Payloadsize is to big...");
                                }
                                i3 = (int) longValue;
                            } else {
                                throw new a(10);
                            }
                        } else if (remaining >= 4) {
                            i3 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                            i2 = 4;
                        } else {
                            throw new a(4);
                        }
                    }
                    int i5 = i2 + (z2 ? 4 : 0) + i3;
                    if (remaining >= i5) {
                        ByteBuffer allocate = ByteBuffer.allocate(a(i3));
                        if (z2) {
                            byte[] bArr2 = new byte[4];
                            byteBuffer.get(bArr2);
                            for (int i6 = 0; i6 < i3; i6++) {
                                allocate.put((byte) (byteBuffer.get() ^ bArr2[i6 % 4]));
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
                    throw new a(i5);
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
        int i2 = 0;
        boolean z = this.f8822d == by.b.CLIENT;
        int i3 = c2.remaining() <= 125 ? 1 : c2.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i3 > 1 ? i3 + 1 : i3) + 1 + (z ? 4 : 0) + c2.remaining());
        byte a2 = a(cqVar.f());
        boolean d2 = cqVar.d();
        byte b2 = ByteCompanionObject.MIN_VALUE;
        allocate.put((byte) (((byte) (d2 ? com.alipay.sdk.encrypt.a.f1885g : 0)) | a2));
        byte[] a3 = a(c2.remaining(), i3);
        if (f8831f || a3.length == i3) {
            if (i3 == 1) {
                byte b3 = a3[0];
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b3 | b2));
            } else if (i3 == 2) {
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b2 | 126));
                allocate.put(a3);
            } else if (i3 == 8) {
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
                allocate2.putInt(this.f8833h.nextInt());
                allocate.put(allocate2.array());
                while (c2.hasRemaining()) {
                    allocate.put((byte) (c2.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(c2);
            }
            if (f8831f || allocate.remaining() == 0) {
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
        this.f8833h.nextBytes(bArr);
        ctVar.a("Sec-WebSocket-Key", db.a(bArr));
        return ctVar;
    }

    private byte[] a(long j, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) (j >>> (i3 - (i4 * 8)));
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
        this.f8832g = null;
    }
}
