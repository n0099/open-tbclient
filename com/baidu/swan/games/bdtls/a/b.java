package com.baidu.swan.games.bdtls.a;

import com.baidu.swan.games.bdtls.model.h;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class b {
    public static byte[] a(h hVar) {
        if (hVar == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(hVar.ayH() + 12 + hVar.ayI());
        allocate.put((byte) -27);
        allocate.put((byte) -89);
        if (hVar.ayD() == null || hVar.ayD().length != 2) {
            return null;
        }
        allocate.put(hVar.ayD()[0]);
        allocate.put(hVar.ayD()[1]);
        allocate.put(hVar.ayF());
        allocate.put(hVar.ayG());
        if (hVar.ayJ() == null || hVar.ayJ().length == 0) {
            return null;
        }
        int length = hVar.ayJ().length;
        allocate.put((byte) ((length >> 8) & 255));
        allocate.put((byte) (length & 255));
        if (hVar.getContent() == null || hVar.getContent().length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(hVar.getContent().length);
        }
        if (hVar.ayJ() != null) {
            allocate.put(hVar.ayJ());
        }
        if (hVar.getContent() != null) {
            allocate.put(hVar.getContent());
        }
        return allocate.array();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static h U(byte[] bArr) {
        h hVar = null;
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hVar = new h();
                wrap.get();
                wrap.get();
                hVar.c(wrap.get());
                hVar.d(wrap.get());
                int i = wrap.getShort();
                hVar.c((short) i);
                int i2 = wrap.getInt();
                hVar.ik(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hVar.Q(bArr2);
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
