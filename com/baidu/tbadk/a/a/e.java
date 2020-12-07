package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId ezr = BdUniqueId.gen();
    private final ArrayList<String> ezs = new ArrayList<>();
    private com.baidu.tbadk.a.e ezt;

    public e() {
        this.ezs.add("11_7_index_a");
        this.ezs.add("11_7_index_b");
        this.ezs.add("11_7_index_c");
        this.ezs.add("11_7_index_d");
        this.ezs.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bkH() {
        return ezr;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bkI() {
        return this.ezs;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bkJ() {
        return this.ezt;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.ezt = eVar;
    }
}
