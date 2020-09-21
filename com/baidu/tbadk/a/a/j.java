package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    private final ArrayList<String> dTC = new ArrayList<>(3);
    private com.baidu.tbadk.a.e dTD;

    public j() {
        this.dTC.add("11_9_discover_hot_card");
        this.dTC.add("11_9_discover_hot_card_slogan");
        this.dTC.add("11_9_discover_hot_card_hot_text");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bbd() {
        return dTB;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bbe() {
        return this.dTC;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bbf() {
        return this.dTD;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dTD = eVar;
    }
}
