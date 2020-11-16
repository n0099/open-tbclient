package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    private final ArrayList<String> esp = new ArrayList<>(3);
    private com.baidu.tbadk.a.e esq;

    public j() {
        this.esp.add("11_9_discover_hot_card");
        this.esp.add("11_9_discover_hot_card_slogan");
        this.esp.add("11_9_discover_hot_card_hot_text");
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
