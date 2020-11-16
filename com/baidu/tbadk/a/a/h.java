package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    public final ArrayList<String> esp = new ArrayList<>();
    public com.baidu.tbadk.a.e esq;

    public h() {
        this.esp.add("11_7_pb_a");
        this.esp.add("11_7_pb_b");
        this.esp.add("11_7_pb_c");
        this.esp.add("11_7_pb_d");
        this.esp.add("11_7_pb_e");
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
