package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    private final ArrayList<String> eIQ = new ArrayList<>();
    private com.baidu.tbadk.a.e eIR;

    public h() {
        this.eIQ.add("11_8_hot_a");
        this.eIQ.add("11_8_hot_b");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bnc() {
        return eIP;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bnd() {
        return this.eIQ;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bne() {
        return this.eIR;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eIR = eVar;
    }
}
