package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends a {
    public static final BdUniqueId eEe = BdUniqueId.gen();
    public final ArrayList<String> eEf = new ArrayList<>();
    public com.baidu.tbadk.a.e eEg;

    public o() {
        this.eEf.add("70_2");
        this.eEf.add("70_3");
        this.eEf.add("70_4");
        this.eEf.add("70_5");
        this.eEf.add("70_6");
        this.eEf.add("71_2");
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
