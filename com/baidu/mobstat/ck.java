package com.baidu.mobstat;

import com.baidu.mobstat.ce;
import com.baidu.mobstat.cj;
import com.baidu.mobstat.cw;
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
public class ck extends cj {
    public static final /* synthetic */ boolean f = !ck.class.desiredAssertionStatus();
    public ByteBuffer g;
    public final Random h = new Random();

    /* loaded from: classes2.dex */
    public class a extends Throwable {
        public int b;

        public a(int i) {
            this.b = i;
        }

        public int a() {
            return this.b;
        }
    }

    @Override // com.baidu.mobstat.cj
    public void a() {
        this.g = null;
    }

    @Override // com.baidu.mobstat.cj
    public cj.a b() {
        return cj.a.TWOWAY;
    }

    @Override // com.baidu.mobstat.cj
    public cj c() {
        return new ck();
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

    private cw.a a(byte b) throws co {
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    switch (b) {
                        case 8:
                            return cw.a.CLOSING;
                        case 9:
                            return cw.a.PING;
                        case 10:
                            return cw.a.PONG;
                        default:
                            throw new co("unknow optcode " + ((int) b));
                    }
                }
                return cw.a.BINARY;
            }
            return cw.a.TEXT;
        }
        return cw.a.CONTINUOUS;
    }

    private String a(String str) {
        try {
            return dh.a(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    @Override // com.baidu.mobstat.cj
    public cj.b a(cy cyVar, df dfVar) throws cp {
        if (cyVar.c("Sec-WebSocket-Key") && dfVar.c("Sec-WebSocket-Accept")) {
            if (a(cyVar.b("Sec-WebSocket-Key")).equals(dfVar.b("Sec-WebSocket-Accept"))) {
                return cj.b.MATCHED;
            }
            return cj.b.NOT_MATCHED;
        }
        return cj.b.NOT_MATCHED;
    }

    @Override // com.baidu.mobstat.cj
    public cz a(cz czVar) {
        czVar.a("Upgrade", "websocket");
        czVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
        czVar.a("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.h.nextBytes(bArr);
        czVar.a("Sec-WebSocket-Key", dh.a(bArr));
        return czVar;
    }

    @Override // com.baidu.mobstat.cj
    public ByteBuffer a(cw cwVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        ByteBuffer c = cwVar.c();
        int i5 = 0;
        if (this.d == ce.b.CLIENT) {
            z = true;
        } else {
            z = false;
        }
        if (c.remaining() <= 125) {
            i = 1;
        } else if (c.remaining() <= 65535) {
            i = 2;
        } else {
            i = 8;
        }
        if (i > 1) {
            i2 = i + 1;
        } else {
            i2 = i;
        }
        int i6 = i2 + 1;
        if (z) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i6 + i3 + c.remaining());
        byte a2 = a(cwVar.f());
        byte b = Byte.MIN_VALUE;
        if (cwVar.d()) {
            i4 = -128;
        } else {
            i4 = 0;
        }
        allocate.put((byte) (((byte) i4) | a2));
        byte[] a3 = a(c.remaining(), i);
        if (!f && a3.length != i) {
            throw new AssertionError();
        }
        if (i == 1) {
            byte b2 = a3[0];
            if (!z) {
                b = 0;
            }
            allocate.put((byte) (b2 | b));
        } else if (i == 2) {
            if (!z) {
                b = 0;
            }
            allocate.put((byte) (b | 126));
            allocate.put(a3);
        } else if (i == 8) {
            if (!z) {
                b = 0;
            }
            allocate.put((byte) (b | ByteCompanionObject.MAX_VALUE));
            allocate.put(a3);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.h.nextInt());
            allocate.put(allocate2.array());
            while (c.hasRemaining()) {
                allocate.put((byte) (c.get() ^ allocate2.get(i5 % 4)));
                i5++;
            }
        } else {
            allocate.put(c);
        }
        if (!f && allocate.remaining() != 0) {
            throw new AssertionError(allocate.remaining());
        }
        allocate.flip();
        return allocate;
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
        r5.g = r1;
        r1.put(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bc, code lost:
        return r0;
     */
    @Override // com.baidu.mobstat.cj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<cw> c(ByteBuffer byteBuffer) throws cq, cn {
        while (true) {
            LinkedList linkedList = new LinkedList();
            if (this.g == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.g.remaining();
                if (remaining2 > remaining) {
                    this.g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
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
    }

    public cw e(ByteBuffer byteBuffer) throws a, cn {
        boolean z;
        boolean z2;
        int i;
        cv cxVar;
        int remaining = byteBuffer.remaining();
        int i2 = 2;
        if (remaining >= 2) {
            byte b = byteBuffer.get();
            if ((b >> 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            byte b2 = (byte) ((b & ByteCompanionObject.MAX_VALUE) >> 4);
            if (b2 == 0) {
                byte b3 = byteBuffer.get();
                if ((b3 & Byte.MIN_VALUE) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i3 = (byte) (b3 & ByteCompanionObject.MAX_VALUE);
                cw.a a2 = a((byte) (b & 15));
                if (!z && (a2 == cw.a.PING || a2 == cw.a.PONG || a2 == cw.a.CLOSING)) {
                    throw new co("control frames may no be fragmented");
                }
                if (i3 < 0 || i3 > 125) {
                    if (a2 != cw.a.PING && a2 != cw.a.PONG && a2 != cw.a.CLOSING) {
                        if (i3 == 126) {
                            if (remaining >= 4) {
                                i3 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                                i2 = 4;
                            } else {
                                throw new a(4);
                            }
                        } else {
                            i2 = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i4 = 0; i4 < 8; i4++) {
                                    bArr[i4] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue <= 2147483647L) {
                                    i3 = (int) longValue;
                                } else {
                                    throw new cq("Payloadsize is to big...");
                                }
                            } else {
                                throw new a(10);
                            }
                        }
                    } else {
                        throw new co("more than 125 octets");
                    }
                }
                if (z2) {
                    i = 4;
                } else {
                    i = 0;
                }
                int i5 = i2 + i + i3;
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
                        throw new cn(1007);
                    }
                    return cxVar;
                }
                throw new a(i5);
            }
            throw new co("bad rsv " + ((int) b2));
        }
        throw new a(2);
    }
}
