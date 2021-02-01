package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    public final ArrayList<String> eGm = new ArrayList<>();
    public com.baidu.tbadk.a.e eGn;

    public q() {
        this.eGm.add("70_2");
        this.eGm.add("70_3");
        this.eGm.add("70_4");
        this.eGm.add("70_5");
        this.eGm.add("70_6");
        this.eGm.add("71_2");
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
