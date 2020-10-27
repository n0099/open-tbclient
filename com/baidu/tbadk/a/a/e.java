package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId eoa = BdUniqueId.gen();
    private final ArrayList<String> eob = new ArrayList<>();
    private com.baidu.tbadk.a.e eoc;

    public e() {
        this.eob.add("11_7_index_a");
        this.eob.add("11_7_index_b");
        this.eob.add("11_7_index_c");
        this.eob.add("11_7_index_d");
        this.eob.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bfE() {
        return eoa;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bfF() {
        return this.eob;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bfG() {
        return this.eoc;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eoc = eVar;
    }
}
