package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    public final ArrayList<String> eGm = new ArrayList<>();
    public com.baidu.tbadk.a.e eGn;

    public b() {
        this.eGm.add("11_9_backuser_a");
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
