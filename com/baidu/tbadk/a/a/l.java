package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends a {
    public static final BdUniqueId eHM = BdUniqueId.gen();
    public final ArrayList<String> eHN = new ArrayList<>();
    public com.baidu.tbadk.a.e eHO;

    public l() {
        this.eHN.add("12_1_pb_a");
        this.eHN.add("12_1_pb_b");
        this.eHN.add("12_1_pb_c");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjF() {
        return eHM;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjG() {
        return this.eHN;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjH() {
        return this.eHO;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eHO = eVar;
    }
}
