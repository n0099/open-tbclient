package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends a {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    private final ArrayList<String> dTC = new ArrayList<>();
    private com.baidu.tbadk.a.e dTD;

    public f() {
        this.dTC.add("11_8_hot_a");
        this.dTC.add("11_8_hot_b");
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
