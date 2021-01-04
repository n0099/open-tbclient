package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    public final ArrayList<String> eIQ = new ArrayList<>();
    public com.baidu.tbadk.a.e eIR;

    public o() {
        this.eIQ.add("70_2");
        this.eIQ.add("70_3");
        this.eIQ.add("70_4");
        this.eIQ.add("70_5");
        this.eIQ.add("70_6");
        this.eIQ.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bnb() {
        return eIP;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bnc() {
        return this.eIQ;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bnd() {
        return this.eIR;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eIR = eVar;
    }
}
