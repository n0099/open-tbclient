package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId etU = BdUniqueId.gen();
    public final ArrayList<String> etV = new ArrayList<>();
    public com.baidu.tbadk.a.e etW;

    public k() {
        this.etV.add("70_2");
        this.etV.add("70_3");
        this.etV.add("70_4");
        this.etV.add("70_5");
        this.etV.add("70_6");
        this.etV.add("71_2");
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

    public static com.baidu.tbadk.a.e bih() {
        return com.baidu.tbadk.a.d.j(etU);
    }

    public static boolean E(String... strArr) {
        return b(bih(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
