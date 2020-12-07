package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends a {
    public static final BdUniqueId ezr = BdUniqueId.gen();
    public final ArrayList<String> ezs = new ArrayList<>();
    public com.baidu.tbadk.a.e ezt;

    public j() {
        this.ezs.add("12_1_pb_a");
        this.ezs.add("12_1_pb_b");
        this.ezs.add("12_1_pb_c");
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
