package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId eEe = BdUniqueId.gen();
    public final ArrayList<String> eEf = new ArrayList<>();
    public com.baidu.tbadk.a.e eEg;

    public l() {
        this.eEf.add("12_1_pb_sub_post_a");
        this.eEf.add("12_1_pb_sub_post_b");
        this.eEf.add("12_1_pb_sub_post_c");
        this.eEf.add("12_1_pb_sub_post_d");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bji() {
        return eEe;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjj() {
        return this.eEf;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjk() {
        return this.eEg;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eEg = eVar;
    }
}
