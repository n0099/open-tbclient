package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    public final ArrayList<String> esp = new ArrayList<>();
    public com.baidu.tbadk.a.e esq;

    public l() {
        this.esp.add("70_2");
        this.esp.add("70_3");
        this.esp.add("70_4");
        this.esp.add("70_5");
        this.esp.add("70_6");
        this.esp.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bhy() {
        return eso;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bhz() {
        return this.esp;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bhA() {
        return this.esq;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.esq = eVar;
    }
}
