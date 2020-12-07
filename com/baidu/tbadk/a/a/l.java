package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId ezr = BdUniqueId.gen();
    private final ArrayList<String> ezs = new ArrayList<>(3);
    private com.baidu.tbadk.a.e ezt;

    public l() {
        this.ezs.add("11_9_discover_hot_card");
        this.ezs.add("11_9_discover_hot_card_slogan");
        this.ezs.add("11_9_discover_hot_card_hot_text");
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
