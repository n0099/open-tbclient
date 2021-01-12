package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId eEe = BdUniqueId.gen();
    private final ArrayList<String> eEf = new ArrayList<>(2);
    private com.baidu.tbadk.a.e eEg;

    public e() {
        this.eEf.add("12_2_frs_default_sort_a");
        this.eEf.add("12_2_frs_default_sort_b");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bji() {
        return eEe;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjj() {
        return this.eEf;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjk() {
        return this.eEg;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eEg = eVar;
    }
}
