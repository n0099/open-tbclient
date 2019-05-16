package com.baidu.mobstat;

import com.baidu.mobstat.ce;
import com.baidu.mobstat.cw;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class cj {
    public static int a = 1000;
    public static int b = 64;
    public static final byte[] c = di.a("<policy-file-request/>\u0000");
    protected ce.b d = null;
    protected cw.a e = null;

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

    public abstract b a(cy cyVar, df dfVar) throws cp;

    public abstract cz a(cz czVar) throws cp;

    public abstract ByteBuffer a(cw cwVar);

    public abstract List<cw> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cj c();

    public abstract List<cw> c(ByteBuffer byteBuffer) throws cn;

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

    public static da a(ByteBuffer byteBuffer, ce.b bVar) throws cp, cm {
        dg dgVar;
        String b2 = b(byteBuffer);
        if (b2 == null) {
            throw new cm(byteBuffer.capacity() + 128);
        }
        String[] split = b2.split(" ", 3);
        if (split.length != 3) {
            throw new cp();
        }
        if (bVar == ce.b.CLIENT) {
            dg dcVar = new dc();
            dg dgVar2 = dcVar;
            dgVar2.a(Short.parseShort(split[1]));
            dgVar2.a(split[2]);
            dgVar = dcVar;
        } else {
            db dbVar = new db();
            dbVar.a(split[1]);
            dgVar = dbVar;
        }
        String b3 = b(byteBuffer);
        while (b3 != null && b3.length() > 0) {
            String[] split2 = b3.split(":", 2);
            if (split2.length != 2) {
                throw new cp("not an http header");
            }
            dgVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
            b3 = b(byteBuffer);
        }
        if (b3 == null) {
            throw new cm();
        }
        return dgVar;
    }

    public List<ByteBuffer> a(dd ddVar, ce.b bVar) {
        return a(ddVar, bVar, true);
    }

    public List<ByteBuffer> a(dd ddVar, ce.b bVar, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (ddVar instanceof cy) {
            sb.append("GET ");
            sb.append(((cy) ddVar).a());
            sb.append(" HTTP/1.1");
        } else if (ddVar instanceof df) {
            sb.append("HTTP/1.1 101 ").append(((df) ddVar).a());
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
        byte[] c2 = z ? ddVar.c() : null;
        ByteBuffer allocate = ByteBuffer.allocate((c2 == null ? 0 : c2.length) + b4.length);
        allocate.put(b4);
        if (c2 != null) {
            allocate.put(c2);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public dd d(ByteBuffer byteBuffer) throws cp {
        return a(byteBuffer, this.d);
    }

    public int a(int i) throws cq, cn {
        if (i < 0) {
            throw new cn(1002, "Negative count");
        }
        return i;
    }

    public void a(ce.b bVar) {
        this.d = bVar;
    }
}
