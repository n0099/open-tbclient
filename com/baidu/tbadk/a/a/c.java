package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    private final ArrayList<String> eGm = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eGn;

    public c() {
        this.eGm.add("11_10_user_like_tab");
        this.eGm.add("11_10_user_like_tab_a");
        this.eGm.add("11_10_user_like_tab_b");
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
