package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends a {
    public static final BdUniqueId eso = BdUniqueId.gen();
    public final ArrayList<String> esp = new ArrayList<>();
    public com.baidu.tbadk.a.e esq;

    public i() {
        this.esp.add("11_9_pb_gif_size_a");
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
