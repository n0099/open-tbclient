package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId efC = BdUniqueId.gen();
    public final ArrayList<String> efD = new ArrayList<>();
    public com.baidu.tbadk.a.e efE;

    public h() {
        this.efD.add("11_7_pb_a");
        this.efD.add("11_7_pb_b");
        this.efD.add("11_7_pb_c");
        this.efD.add("11_7_pb_d");
        this.efD.add("11_7_pb_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bdL() {
        return efC;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bdM() {
        return this.efD;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bdN() {
        return this.efE;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.efE = eVar;
    }
}
