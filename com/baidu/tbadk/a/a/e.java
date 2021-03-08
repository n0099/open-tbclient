package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId eHM = BdUniqueId.gen();
    private final ArrayList<String> eHN = new ArrayList<>(2);
    private com.baidu.tbadk.a.e eHO;

    public e() {
        this.eHN.add("12_2_frs_default_sort_a");
        this.eHN.add("12_2_frs_default_sort_b");
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
