package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId efC = BdUniqueId.gen();
    private final ArrayList<String> efD = new ArrayList<>(3);
    private com.baidu.tbadk.a.e efE;

    public j() {
        this.efD.add("11_9_discover_hot_card");
        this.efD.add("11_9_discover_hot_card_slogan");
        this.efD.add("11_9_discover_hot_card_hot_text");
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
