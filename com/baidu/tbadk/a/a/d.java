package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends a {
    public static final BdUniqueId efC = BdUniqueId.gen();
    private final ArrayList<String> efD = new ArrayList<>(2);
    private com.baidu.tbadk.a.e efE;

    public d() {
        this.efD.add("11_9_frs_page_guide");
        this.efD.add("11_9_frs_page_guide_a");
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
