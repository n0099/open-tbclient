package com.baidu.swan.games.bdtls.model;

import com.baidu.swan.games.bdtls.model.Bdtls;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class g {
    private Bdtls.ClientHello dRR;
    private Bdtls.ServerHello dRS;
    private byte[] dRT;

    public g() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!q.l(this.dRR, gVar.dRR) || !q.l(this.dRS, gVar.dRS) || !q.l(this.dRT, gVar.dRT)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls.ClientHello clientHello = this.dRR;
        int hashCode = (clientHello != null ? clientHello.hashCode() : 0) * 31;
        Bdtls.ServerHello serverHello = this.dRS;
        int hashCode2 = ((serverHello != null ? serverHello.hashCode() : 0) + hashCode) * 31;
        byte[] bArr = this.dRT;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.dRR + ", serverHello=" + this.dRS + ", encodeDHPublicKey=" + Arrays.toString(this.dRT) + ")";
    }

    public g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr) {
        this.dRR = clientHello;
        this.dRS = serverHello;
        this.dRT = bArr;
    }

    public /* synthetic */ g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr, int i, o oVar) {
        this((i & 1) != 0 ? null : clientHello, (i & 2) != 0 ? null : serverHello, (i & 4) != 0 ? null : bArr);
    }

    public final void b(Bdtls.ServerHello serverHello) {
        this.dRS = serverHello;
    }
}
