package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId eEe = BdUniqueId.gen();
    private final ArrayList<String> eEf = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eEg;

    public c() {
        this.eEf.add("11_10_user_like_tab");
        this.eEf.add("11_10_user_like_tab_a");
        this.eEf.add("11_10_user_like_tab_b");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bji() {
        return eEe;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjj() {
        return this.eEf;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjk() {
        return this.eEg;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eEg = eVar;
    }
}
