package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends a {
    public static final BdUniqueId dRn = BdUniqueId.gen();
    public final ArrayList<String> dRo = new ArrayList<>();
    public com.baidu.tbadk.a.e dRp;

    public e() {
        this.dRo.add("11_7_pb_a");
        this.dRo.add("11_7_pb_b");
        this.dRo.add("11_7_pb_c");
        this.dRo.add("11_7_pb_d");
        this.dRo.add("11_7_pb_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRo;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRp;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRp = eVar;
    }
}
