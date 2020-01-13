package com.baidu.swan.games.bdtls.a;

import com.baidu.swan.games.bdtls.model.h;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class b {
    public static byte[] a(h hVar) {
        if (hVar == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(hVar.akn() + 12 + hVar.ako());
        allocate.put((byte) -27);
        allocate.put((byte) -89);
        if (hVar.akj() == null || hVar.akj().length != 2) {
            return null;
        }
        allocate.put(hVar.akj()[0]);
        allocate.put(hVar.akj()[1]);
        allocate.put(hVar.akl());
        allocate.put(hVar.akm());
        if (hVar.akp() == null || hVar.akp().length == 0) {
            return null;
        }
        int length = hVar.akp().length;
        allocate.put((byte) ((length >> 8) & 255));
        allocate.put((byte) (length & 255));
        if (hVar.getContent() == null || hVar.getContent().length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(hVar.getContent().length);
        }
        if (hVar.akp() != null) {
            allocate.put(hVar.akp());
        }
        if (hVar.getContent() != null) {
            allocate.put(hVar.getContent());
        }
        return allocate.array();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static h G(byte[] bArr) {
        h hVar = null;
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hVar = new h();
                wrap.get();
                wrap.get();
                hVar.b(wrap.get());
                hVar.c(wrap.get());
                int i = wrap.getShort();
                hVar.b((short) i);
                int i2 = wrap.getInt();
                hVar.hv(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hVar.C(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    hVar.setContent(bArr3);
                }
            }
        }
        return hVar;
    }
}
