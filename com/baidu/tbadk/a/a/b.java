package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends a {
    public static final BdUniqueId dRr = BdUniqueId.gen();
    private final ArrayList<String> dRs = new ArrayList<>();
    private com.baidu.tbadk.a.e dRt;

    public b() {
        this.dRs.add("11_7_index_a");
        this.dRs.add("11_7_index_b");
        this.dRs.add("11_7_index_c");
        this.dRs.add("11_7_index_d");
        this.dRs.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRr;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRs;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRt;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRt = eVar;
    }
}
