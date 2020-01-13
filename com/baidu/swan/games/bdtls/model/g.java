package com.baidu.swan.games.bdtls.model;

import com.baidu.swan.games.bdtls.model.Bdtls;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class g {
    private Bdtls.ClientHello cgO;
    private Bdtls.ServerHello cgP;
    private byte[] cgQ;

    public g() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!q.h(this.cgO, gVar.cgO) || !q.h(this.cgP, gVar.cgP) || !q.h(this.cgQ, gVar.cgQ)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Bdtls.ClientHello clientHello = this.cgO;
        int hashCode = (clientHello != null ? clientHello.hashCode() : 0) * 31;
        Bdtls.ServerHello serverHello = this.cgP;
        int hashCode2 = ((serverHello != null ? serverHello.hashCode() : 0) + hashCode) * 31;
        byte[] bArr = this.cgQ;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "HandshakeParams(clientHello=" + this.cgO + ", serverHello=" + this.cgP + ", encodeDHPublicKey=" + Arrays.toString(this.cgQ) + ")";
    }

    public g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr) {
        this.cgO = clientHello;
        this.cgP = serverHello;
        this.cgQ = bArr;
    }

    public /* synthetic */ g(Bdtls.ClientHello clientHello, Bdtls.ServerHello serverHello, byte[] bArr, int i, o oVar) {
        this((i & 1) != 0 ? null : clientHello, (i & 2) != 0 ? null : serverHello, (i & 4) != 0 ? null : bArr);
    }

    public final void b(Bdtls.ServerHello serverHello) {
        this.cgP = serverHello;
    }
}
