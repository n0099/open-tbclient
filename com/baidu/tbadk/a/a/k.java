package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    public final ArrayList<String> dTC = new ArrayList<>();
    public com.baidu.tbadk.a.e dTD;

    public k() {
        this.dTC.add("70_2");
        this.dTC.add("70_3");
        this.dTC.add("70_4");
        this.dTC.add("70_5");
        this.dTC.add("70_6");
        this.dTC.add("71_2");
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

    public static com.baidu.tbadk.a.e bbg() {
        return com.baidu.tbadk.a.d.j(dTB);
    }

    public static boolean C(String... strArr) {
        return b(bbg(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
