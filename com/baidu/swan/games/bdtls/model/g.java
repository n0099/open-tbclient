package com.baidu.swan.games.bdtls.model;

import com.baidu.swan.games.bdtls.model.Bdtls;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class g {
    private Bdtls.ClientHello dfk;
    private Bdtls.ServerHello dfl;
    private byte[] dfm;

    public g() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!q.l(this.dfk, gVar.dfk) || !q.l(this.dfl, gVar.dfl) || !q.l(this.dfm, gVar.dfm)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls.ClientHello clientHello = this.dfk;
        int hashCode = (clientHello != null ? clientHello.hashCode() : 0) * 31;
        Bdtls.ServerHello serverHello = this.dfl;
        int hashCode2 = ((serverHello != null ? serverHello.hashCode() : 0) + hashCode) * 31;
        byte[] bArr = this.dfm;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.dfk + ", serverHello=" + this.dfl + ", encodeDHPublicKey=" + Arrays.toString(this.dfm) + ")";
    }

    public g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr) {
        this.dfk = clientHello;
        this.dfl = serverHello;
        this.dfm = bArr;
    }

    public /* synthetic */ g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr, int i, o oVar) {
        this((i & 1) != 0 ? null : clientHello, (i & 2) != 0 ? null : serverHello, (i & 4) != 0 ? null : bArr);
    }

    public final void b(Bdtls.ServerHello serverHello) {
        this.dfl = serverHello;
    }
}
