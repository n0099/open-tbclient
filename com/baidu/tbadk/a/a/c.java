package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends a {
    public static final BdUniqueId dRn = BdUniqueId.gen();
    private final ArrayList<String> dRo = new ArrayList<>();
    private com.baidu.tbadk.a.e dRp;

    public c() {
        this.dRo.add("11_8_hot_a");
        this.dRo.add("11_8_hot_b");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRo;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRp;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRp = eVar;
    }
}
