package com.baidu.swan.games.bdtls.model;

import com.baidu.swan.games.bdtls.model.Bdtls;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class g {
    private Bdtls.ServerHello cZA;
    private byte[] cZB;
    private Bdtls.ClientHello cZz;

    public g() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!q.l(this.cZz, gVar.cZz) || !q.l(this.cZA, gVar.cZA) || !q.l(this.cZB, gVar.cZB)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls.ClientHello clientHello = this.cZz;
        int hashCode = (clientHello != null ? clientHello.hashCode() : 0) * 31;
        Bdtls.ServerHello serverHello = this.cZA;
        int hashCode2 = ((serverHello != null ? serverHello.hashCode() : 0) + hashCode) * 31;
        byte[] bArr = this.cZB;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.cZz + ", serverHello=" + this.cZA + ", encodeDHPublicKey=" + Arrays.toString(this.cZB) + ")";
    }

    public g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr) {
        this.cZz = clientHello;
        this.cZA = serverHello;
        this.cZB = bArr;
    }

    public /* synthetic */ g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr, int i, o oVar) {
        this((i & 1) != 0 ? null : clientHello, (i & 2) != 0 ? null : serverHello, (i & 4) != 0 ? null : bArr);
    }

    public final void b(Bdtls.ServerHello serverHello) {
        this.cZA = serverHello;
    }
}
