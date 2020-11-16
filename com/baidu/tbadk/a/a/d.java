package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    private final ArrayList<String> esp = new ArrayList<>(2);
    private com.baidu.tbadk.a.e esq;

    public d() {
        this.esp.add("11_9_frs_page_guide");
        this.esp.add("11_9_frs_page_guide_a");
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
