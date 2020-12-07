package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId ezr = BdUniqueId.gen();
    public final ArrayList<String> ezs = new ArrayList<>();
    public com.baidu.tbadk.a.e ezt;

    public h() {
        this.ezs.add("11_7_pb_a");
        this.ezs.add("11_7_pb_b");
        this.ezs.add("11_7_pb_c");
        this.ezs.add("11_7_pb_d");
        this.ezs.add("11_7_pb_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bkH() {
        return ezr;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bkI() {
        return this.ezs;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bkJ() {
        return this.ezt;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.ezt = eVar;
    }
}
