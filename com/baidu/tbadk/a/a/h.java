package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    public final ArrayList<String> dTC = new ArrayList<>();
    public com.baidu.tbadk.a.e dTD;

    public h() {
        this.dTC.add("11_7_pb_a");
        this.dTC.add("11_7_pb_b");
        this.dTC.add("11_7_pb_c");
        this.dTC.add("11_7_pb_d");
        this.dTC.add("11_7_pb_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bbd() {
        return dTB;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bbe() {
        return this.dTC;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bbf() {
        return this.dTD;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dTD = eVar;
    }
}
