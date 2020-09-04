package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId dRr = BdUniqueId.gen();
    public final ArrayList<String> dRs = new ArrayList<>();
    public com.baidu.tbadk.a.e dRt;

    public e() {
        this.dRs.add("11_7_pb_a");
        this.dRs.add("11_7_pb_b");
        this.dRs.add("11_7_pb_c");
        this.dRs.add("11_7_pb_d");
        this.dRs.add("11_7_pb_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRr;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRs;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRt;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRt = eVar;
    }
}
