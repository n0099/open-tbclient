package com.baidu.swan.games.bdtls.a;

import com.baidu.swan.games.bdtls.model.h;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class b {
    public static byte[] a(h hVar) {
        if (hVar == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(hVar.auU() + 12 + hVar.auV());
        allocate.put((byte) -27);
        allocate.put((byte) -89);
        if (hVar.auQ() == null || hVar.auQ().length != 2) {
            return null;
        }
        allocate.put(hVar.auQ()[0]);
        allocate.put(hVar.auQ()[1]);
        allocate.put(hVar.auS());
        allocate.put(hVar.auT());
        if (hVar.auW() == null || hVar.auW().length == 0) {
            return null;
        }
        int length = hVar.auW().length;
        allocate.put((byte) ((length >> 8) & 255));
        allocate.put((byte) (length & 255));
        if (hVar.getContent() == null || hVar.getContent().length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(hVar.getContent().length);
        }
        if (hVar.auW() != null) {
            allocate.put(hVar.auW());
        }
        if (hVar.getContent() != null) {
            allocate.put(hVar.getContent());
        }
        return allocate.array();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static h N(byte[] bArr) {
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
                hVar.c((short) i);
                int i2 = wrap.getInt();
                hVar.hT(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hVar.J(bArr2);
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
