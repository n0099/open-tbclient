package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    private final ArrayList<String> eIQ = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eIR;

    public f() {
        this.eIQ.add("12_2_frs_default_tab_a");
        this.eIQ.add("12_2_frs_default_tab_b");
        this.eIQ.add("12_2_frs_default_tab_c");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bnb() {
        return eIP;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bnc() {
        return this.eIQ;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bnd() {
        return this.eIR;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eIR = eVar;
    }
}
