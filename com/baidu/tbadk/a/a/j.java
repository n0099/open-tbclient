package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId eHM = BdUniqueId.gen();
    private final ArrayList<String> eHN = new ArrayList<>(3);
    private com.baidu.tbadk.a.e eHO;

    public j() {
        this.eHN.add("12_2_pb_picpage");
        this.eHN.add("12_2_pb_picpage_a");
        this.eHN.add("12_2_pb_picpage_b");
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
