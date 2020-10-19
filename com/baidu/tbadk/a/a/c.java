package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId efC = BdUniqueId.gen();
    private final ArrayList<String> efD = new ArrayList<>(3);
    private com.baidu.tbadk.a.e efE;

    public c() {
        this.efD.add("11_10_user_like_tab");
        this.efD.add("11_10_user_like_tab_a");
        this.efD.add("11_10_user_like_tab_b");
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
