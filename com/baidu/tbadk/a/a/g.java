package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId eHM = BdUniqueId.gen();
    private final ArrayList<String> eHN = new ArrayList<>();
    private com.baidu.tbadk.a.e eHO;

    public g() {
        this.eHN.add("11_7_index_a");
        this.eHN.add("11_7_index_b");
        this.eHN.add("11_7_index_c");
        this.eHN.add("11_7_index_d");
        this.eHN.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjF() {
        return eHM;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjG() {
        return this.eHN;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjH() {
        return this.eHO;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eHO = eVar;
    }
}
