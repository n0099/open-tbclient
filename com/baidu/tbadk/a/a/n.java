package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends a {
    public static final BdUniqueId eHM = BdUniqueId.gen();
    private final ArrayList<String> eHN = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eHO;

    public n() {
        this.eHN.add("11_9_discover_hot_card");
        this.eHN.add("11_9_discover_hot_card_slogan");
        this.eHN.add("11_9_discover_hot_card_hot_text");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjF() {
        return eHM;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjG() {
        return this.eHN;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjH() {
        return this.eHO;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eHO = eVar;
    }
}
