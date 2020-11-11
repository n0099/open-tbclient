package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId etU = BdUniqueId.gen();
    private final ArrayList<String> etV = new ArrayList<>(3);
    private com.baidu.tbadk.a.e etW;

    public c() {
        this.etV.add("11_10_user_like_tab");
        this.etV.add("11_10_user_like_tab_a");
        this.etV.add("11_10_user_like_tab_b");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bie() {
        return etU;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bif() {
        return this.etV;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e big() {
        return this.etW;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.etW = eVar;
    }
}
