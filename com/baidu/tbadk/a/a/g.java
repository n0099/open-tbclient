package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    private final ArrayList<String> eGm = new ArrayList<>();
    private com.baidu.tbadk.a.e eGn;

    public g() {
        this.eGm.add("11_7_index_a");
        this.eGm.add("11_7_index_b");
        this.eGm.add("11_7_index_c");
        this.eGm.add("11_7_index_d");
        this.eGm.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjD() {
        return eGl;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjE() {
        return this.eGm;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjF() {
        return this.eGn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eGn = eVar;
    }
}
