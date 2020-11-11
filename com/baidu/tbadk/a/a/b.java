package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends a {
    public static final BdUniqueId etU = BdUniqueId.gen();
    public final ArrayList<String> etV = new ArrayList<>();
    public com.baidu.tbadk.a.e etW;

    public b() {
        this.etV.add("11_9_backuser_a");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bie() {
        return etU;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bif() {
        return this.etV;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e big() {
        return this.etW;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.etW = eVar;
    }
}
