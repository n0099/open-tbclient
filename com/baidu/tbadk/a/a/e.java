package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId etU = BdUniqueId.gen();
    private final ArrayList<String> etV = new ArrayList<>();
    private com.baidu.tbadk.a.e etW;

    public e() {
        this.etV.add("11_7_index_a");
        this.etV.add("11_7_index_b");
        this.etV.add("11_7_index_c");
        this.etV.add("11_7_index_d");
        this.etV.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bie() {
        return etU;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bif() {
        return this.etV;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e big() {
        return this.etW;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.etW = eVar;
    }
}
