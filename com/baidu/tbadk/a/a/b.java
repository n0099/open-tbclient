package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends a {
    public static final BdUniqueId dRn = BdUniqueId.gen();
    private final ArrayList<String> dRo = new ArrayList<>();
    private com.baidu.tbadk.a.e dRp;

    public b() {
        this.dRo.add("11_7_index_a");
        this.dRo.add("11_7_index_b");
        this.dRo.add("11_7_index_c");
        this.dRo.add("11_7_index_d");
        this.dRo.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRo;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRp;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRp = eVar;
    }
}
