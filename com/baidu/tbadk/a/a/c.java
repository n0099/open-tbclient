package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    private final ArrayList<String> dTC = new ArrayList<>(2);
    private com.baidu.tbadk.a.e dTD;

    public c() {
        this.dTC.add("11_9_user_like");
        this.dTC.add("11_9_user_like_a");
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
