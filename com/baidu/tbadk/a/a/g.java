package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId eEe = BdUniqueId.gen();
    private final ArrayList<String> eEf = new ArrayList<>();
    private com.baidu.tbadk.a.e eEg;

    public g() {
        this.eEf.add("11_7_index_a");
        this.eEf.add("11_7_index_b");
        this.eEf.add("11_7_index_c");
        this.eEf.add("11_7_index_d");
        this.eEf.add("11_7_index_e");
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
