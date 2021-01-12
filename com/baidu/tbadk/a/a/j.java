package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId eEe = BdUniqueId.gen();
    private final ArrayList<String> eEf = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eEg;

    public j() {
        this.eEf.add("12_2_pb_picpage");
        this.eEf.add("12_2_pb_picpage_a");
        this.eEf.add("12_2_pb_picpage_b");
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
