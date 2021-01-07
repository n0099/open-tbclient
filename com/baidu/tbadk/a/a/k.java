package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    public final ArrayList<String> eIQ = new ArrayList<>();
    public com.baidu.tbadk.a.e eIR;

    public k() {
        this.eIQ.add("12_1_pb_a");
        this.eIQ.add("12_1_pb_b");
        this.eIQ.add("12_1_pb_c");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bnc() {
        return eIP;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bnd() {
        return this.eIQ;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bne() {
        return this.eIR;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eIR = eVar;
    }
}
