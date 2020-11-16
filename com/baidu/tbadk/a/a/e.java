package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    private final ArrayList<String> esp = new ArrayList<>();
    private com.baidu.tbadk.a.e esq;

    public e() {
        this.esp.add("11_7_index_a");
        this.esp.add("11_7_index_b");
        this.esp.add("11_7_index_c");
        this.esp.add("11_7_index_d");
        this.esp.add("11_7_index_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bhy() {
        return eso;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bhz() {
        return this.esp;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bhA() {
        return this.esq;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.esq = eVar;
    }
}
