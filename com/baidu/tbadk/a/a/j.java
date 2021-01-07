package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    private final ArrayList<String> eIQ = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eIR;

    public j() {
        this.eIQ.add("12_2_pb_picpage");
        this.eIQ.add("12_2_pb_picpage_a");
        this.eIQ.add("12_2_pb_picpage_b");
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
