package com.baidu.mobstat;

import com.baidu.mobstat.ce;
import com.baidu.mobstat.cw;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class cj {
    public static int a = 1000;
    public static int b = 64;
    public static final byte[] c = di.a("<policy-file-request/>\u0000");
    public ce.b d = null;
    public cw.a e = null;

    /* loaded from: classes3.dex */
    public enum a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    /* loaded from: classes3.dex */
    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public abstract b a(cy cyVar, df dfVar) throws cp;

    public abstract cz a(cz czVar) throws cp;

    public abstract ByteBuffer a(cw cwVar);

    public abstract List<cw> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cj c();

    public abstract List<cw> c(ByteBuffer byteBuffer) throws cn;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.baidu.mobstat.dc, com.baidu.mobstat.dg] */
    public static da a(ByteBuffer byteBuffer, ce.b bVar) throws cp, cm {
        db dbVar;
        String b2 = b(byteBuffer);
        if (b2 != null) {
            String[] split = b2.split(" ", 3);
            if (split.length == 3) {
                if (bVar == ce.b.CLIENT) {
                    ?? dcVar = new dc();
                    dcVar.a(Short.parseShort(split[1]));
                    dcVar.a(split[2]);
                    dbVar = dcVar;
                } else {
                    db dbVar2 = new db();
                    dbVar2.a(split[1]);
                    dbVar = dbVar2;
                }
                String b3 = b(byteBuffer);
                while (b3 != null && b3.length() > 0) {
                    String[] split2 = b3.split(":", 2);
                    if (split2.length == 2) {
                        dbVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
                        b3 = b(byteBuffer);
                    } else {
                        throw new cp("not an http header");
                    }
                }
                if (b3 != null) {
                    return dbVar;
                }
                throw new cm();
            }
            throw new cp();
        }
        throw new cm(byteBuffer.capacity() + 128);
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
        return di.a(a2.array(), 0, a2.limit());
    }

    public int a(int i) throws cq, cn {
        if (i >= 0) {
            return i;
        }
        throw new cn(1002, "Negative count");
    }

    public dd d(ByteBuffer byteBuffer) throws cp {
        return a(byteBuffer, this.d);
    }

    public List<ByteBuffer> a(dd ddVar, ce.b bVar) {
        return a(ddVar, bVar, true);
    }

    public List<ByteBuffer> a(dd ddVar, ce.b bVar, boolean z) {
        byte[] bArr;
        int length;
        StringBuilder sb = new StringBuilder(100);
        if (ddVar instanceof cy) {
            sb.append("GET ");
            sb.append(((cy) ddVar).a());
            sb.append(" HTTP/1.1");
        } else if (ddVar instanceof df) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((df) ddVar).a());
        } else {
            throw new RuntimeException("unknown role");
        }
        sb.append("\r\n");
        Iterator<String> b2 = ddVar.b();
        while (b2.hasNext()) {
            String next = b2.next();
            String b3 = ddVar.b(next);
            sb.append(next);
            sb.append(": ");
            sb.append(b3);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] b4 = di.b(sb.toString());
        if (z) {
            bArr = ddVar.c();
        } else {
            bArr = null;
        }
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length + b4.length);
        allocate.put(b4);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public void a(ce.b bVar) {
        this.d = bVar;
    }
}
