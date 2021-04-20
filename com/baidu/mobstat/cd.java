package com.baidu.mobstat;

import com.android.internal.http.multipart.Part;
import com.baidu.mobstat.by;
import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class cd {

    /* renamed from: a  reason: collision with root package name */
    public static int f8732a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static int f8733b = 64;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f8734c = dc.a("<policy-file-request/>\u0000");

    /* renamed from: d  reason: collision with root package name */
    public by.b f8735d = null;

    /* renamed from: e  reason: collision with root package name */
    public cq.a f8736e = null;

    /* loaded from: classes2.dex */
    public enum a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes2.dex */
    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        ByteBuffer a2 = a(byteBuffer);
        if (a2 == null) {
            return null;
        }
        return dc.a(a2.array(), 0, a2.limit());
    }

    public abstract b a(cs csVar, cz czVar) throws cj;

    public abstract ct a(ct ctVar) throws cj;

    public abstract ByteBuffer a(cq cqVar);

    public abstract List<cq> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cd c();

    public abstract List<cq> c(ByteBuffer byteBuffer) throws ch;

    public cx d(ByteBuffer byteBuffer) throws cj {
        return a(byteBuffer, this.f8735d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.baidu.mobstat.da, com.baidu.mobstat.cw] */
    public static cu a(ByteBuffer byteBuffer, by.b bVar) throws cj, cg {
        cv cvVar;
        String b2 = b(byteBuffer);
        if (b2 != null) {
            String[] split = b2.split(" ", 3);
            if (split.length == 3) {
                if (bVar == by.b.CLIENT) {
                    ?? cwVar = new cw();
                    cwVar.a(Short.parseShort(split[1]));
                    cwVar.a(split[2]);
                    cvVar = cwVar;
                } else {
                    cv cvVar2 = new cv();
                    cvVar2.a(split[1]);
                    cvVar = cvVar2;
                }
                String b3 = b(byteBuffer);
                while (b3 != null && b3.length() > 0) {
                    String[] split2 = b3.split(":", 2);
                    if (split2.length == 2) {
                        cvVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
                        b3 = b(byteBuffer);
                    } else {
                        throw new cj("not an http header");
                    }
                }
                if (b3 != null) {
                    return cvVar;
                }
                throw new cg();
            }
            throw new cj();
        }
        throw new cg(byteBuffer.capacity() + 128);
    }

    public List<ByteBuffer> a(cx cxVar, by.b bVar) {
        return a(cxVar, bVar, true);
    }

    public List<ByteBuffer> a(cx cxVar, by.b bVar, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (cxVar instanceof cs) {
            sb.append("GET ");
            sb.append(((cs) cxVar).a());
            sb.append(" HTTP/1.1");
        } else if (cxVar instanceof cz) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((cz) cxVar).a());
        } else {
            throw new RuntimeException("unknown role");
        }
        sb.append(Part.CRLF);
        Iterator<String> b2 = cxVar.b();
        while (b2.hasNext()) {
            String next = b2.next();
            String b3 = cxVar.b(next);
            sb.append(next);
            sb.append(": ");
            sb.append(b3);
            sb.append(Part.CRLF);
        }
        sb.append(Part.CRLF);
        byte[] b4 = dc.b(sb.toString());
        byte[] c2 = z ? cxVar.c() : null;
        ByteBuffer allocate = ByteBuffer.allocate((c2 == null ? 0 : c2.length) + b4.length);
        allocate.put(b4);
        if (c2 != null) {
            allocate.put(c2);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public int a(int i) throws ck, ch {
        if (i >= 0) {
            return i;
        }
        throw new ch(1002, "Negative count");
    }

    public void a(by.b bVar) {
        this.f8735d = bVar;
    }
}
