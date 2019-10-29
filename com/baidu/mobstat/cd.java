package com.baidu.mobstat;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.mobstat.by;
import com.baidu.mobstat.cq;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class cd {
    public static int a = 1000;
    public static int b = 64;
    public static final byte[] c = dc.a("<policy-file-request/>\u0000");
    protected by.b d = null;
    protected cq.a e = null;

    /* loaded from: classes6.dex */
    public enum a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes6.dex */
    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public abstract b a(cs csVar, cz czVar) throws cj;

    public abstract ct a(ct ctVar) throws cj;

    public abstract ByteBuffer a(cq cqVar);

    public abstract List<cq> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cd c();

    public abstract List<cq> c(ByteBuffer byteBuffer) throws ch;

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

    public static cu a(ByteBuffer byteBuffer, by.b bVar) throws cj, cg {
        da daVar;
        String b2 = b(byteBuffer);
        if (b2 == null) {
            throw new cg(byteBuffer.capacity() + 128);
        }
        String[] split = b2.split(HanziToPinyin.Token.SEPARATOR, 3);
        if (split.length != 3) {
            throw new cj();
        }
        if (bVar == by.b.CLIENT) {
            da cwVar = new cw();
            da daVar2 = cwVar;
            daVar2.a(Short.parseShort(split[1]));
            daVar2.a(split[2]);
            daVar = cwVar;
        } else {
            cv cvVar = new cv();
            cvVar.a(split[1]);
            daVar = cvVar;
        }
        String b3 = b(byteBuffer);
        while (b3 != null && b3.length() > 0) {
            String[] split2 = b3.split(":", 2);
            if (split2.length != 2) {
                throw new cj("not an http header");
            }
            daVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
            b3 = b(byteBuffer);
        }
        if (b3 == null) {
            throw new cg();
        }
        return daVar;
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
            sb.append("HTTP/1.1 101 ").append(((cz) cxVar).a());
        } else {
            throw new RuntimeException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> b2 = cxVar.b();
        while (b2.hasNext()) {
            String next = b2.next();
            String b3 = cxVar.b(next);
            sb.append(next);
            sb.append(": ");
            sb.append(b3);
            sb.append("\r\n");
        }
        sb.append("\r\n");
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

    public cx d(ByteBuffer byteBuffer) throws cj {
        return a(byteBuffer, this.d);
    }

    public int a(int i) throws ck, ch {
        if (i < 0) {
            throw new ch(1002, "Negative count");
        }
        return i;
    }

    public void a(by.b bVar) {
        this.d = bVar;
    }
}
