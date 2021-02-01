package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    public final ArrayList<String> eGm = new ArrayList<>();
    public com.baidu.tbadk.a.e eGn;

    public m() {
        this.eGm.add("12_1_pb_sub_post_a");
        this.eGm.add("12_1_pb_sub_post_b");
        this.eGm.add("12_1_pb_sub_post_c");
        this.eGm.add("12_1_pb_sub_post_d");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjD() {
        return eGl;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjE() {
        return this.eGm;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjF() {
        return this.eGn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eGn = eVar;
    }
}
