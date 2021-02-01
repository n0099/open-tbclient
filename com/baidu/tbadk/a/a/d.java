package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    private final ArrayList<String> eGm = new ArrayList<>(2);
    private com.baidu.tbadk.a.e eGn;

    public d() {
        this.eGm.add("11_9_frs_page_guide");
        this.eGm.add("11_9_frs_page_guide_a");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjD() {
        return eGl;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjE() {
        return this.eGm;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjF() {
        return this.eGn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eGn = eVar;
    }
}
