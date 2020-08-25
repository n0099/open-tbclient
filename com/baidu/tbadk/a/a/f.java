package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class f extends a {
    public static final BdUniqueId dRn = BdUniqueId.gen();
    public final ArrayList<String> dRo = new ArrayList<>();
    public com.baidu.tbadk.a.e dRp;

    public f() {
        this.dRo.add("70_2");
        this.dRo.add("70_3");
        this.dRo.add("70_4");
        this.dRo.add("70_5");
        this.dRo.add("70_6");
        this.dRo.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId baj() {
        return dRn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bak() {
        return this.dRo;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bal() {
        return this.dRp;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dRp = eVar;
    }

    public static com.baidu.tbadk.a.e bam() {
        return com.baidu.tbadk.a.d.j(dRn);
    }

    public static boolean C(String... strArr) {
        return b(bam(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
