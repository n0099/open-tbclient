package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    public final ArrayList<String> esp = new ArrayList<>();
    public com.baidu.tbadk.a.e esq;

    public b() {
        this.esp.add("11_9_backuser_a");
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
