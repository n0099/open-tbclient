package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends a {
    public static final BdUniqueId dRr = BdUniqueId.gen();
    public final ArrayList<String> dRs = new ArrayList<>();
    public com.baidu.tbadk.a.e dRt;

    public f() {
        this.dRs.add("70_2");
        this.dRs.add("70_3");
        this.dRs.add("70_4");
        this.dRs.add("70_5");
        this.dRs.add("70_6");
        this.dRs.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRr;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRs;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRt;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRt = eVar;
    }

    public static com.baidu.tbadk.a.e bam() {
        return com.baidu.tbadk.a.d.j(dRr);
    }

    public static boolean C(String... strArr) {
        return b(bam(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
