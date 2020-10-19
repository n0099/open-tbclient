package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId efC = BdUniqueId.gen();
    private final ArrayList<String> efD = new ArrayList<>();
    private com.baidu.tbadk.a.e efE;

    public e() {
        this.efD.add("11_7_index_a");
        this.efD.add("11_7_index_b");
        this.efD.add("11_7_index_c");
        this.efD.add("11_7_index_d");
        this.efD.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bdL() {
        return efC;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bdM() {
        return this.efD;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bdN() {
        return this.efE;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.efE = eVar;
    }
}
