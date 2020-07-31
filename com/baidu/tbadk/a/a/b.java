package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends a {
    public static final BdUniqueId dIg = BdUniqueId.gen();
    private final ArrayList<String> dIh = new ArrayList<>();
    private com.baidu.tbadk.a.e dIi;

    public b() {
        this.dIh.add("11_7_index_a");
        this.dIh.add("11_7_index_b");
        this.dIh.add("11_7_index_c");
        this.dIh.add("11_7_index_d");
        this.dIh.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId aRS() {
        return dIg;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> aRT() {
        return this.dIh;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e aRU() {
        return this.dIi;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dIi = eVar;
    }
}
