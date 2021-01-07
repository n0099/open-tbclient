package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    private final ArrayList<String> eIQ = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eIR;

    public m() {
        this.eIQ.add("11_9_discover_hot_card");
        this.eIQ.add("11_9_discover_hot_card_slogan");
        this.eIQ.add("11_9_discover_hot_card_hot_text");
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
