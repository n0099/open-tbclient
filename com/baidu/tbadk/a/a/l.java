package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId eIP = BdUniqueId.gen();
    public final ArrayList<String> eIQ = new ArrayList<>();
    public com.baidu.tbadk.a.e eIR;

    public l() {
        this.eIQ.add("12_1_pb_sub_post_a");
        this.eIQ.add("12_1_pb_sub_post_b");
        this.eIQ.add("12_1_pb_sub_post_c");
        this.eIQ.add("12_1_pb_sub_post_d");
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
