package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId eoa = BdUniqueId.gen();
    public final ArrayList<String> eob = new ArrayList<>();
    public com.baidu.tbadk.a.e eoc;

    public h() {
        this.eob.add("11_7_pb_a");
        this.eob.add("11_7_pb_b");
        this.eob.add("11_7_pb_c");
        this.eob.add("11_7_pb_d");
        this.eob.add("11_7_pb_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bfE() {
        return eoa;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bfF() {
        return this.eob;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bfG() {
        return this.eoc;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eoc = eVar;
    }
}
