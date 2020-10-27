package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId eoa = BdUniqueId.gen();
    public final ArrayList<String> eob = new ArrayList<>();
    public com.baidu.tbadk.a.e eoc;

    public k() {
        this.eob.add("70_2");
        this.eob.add("70_3");
        this.eob.add("70_4");
        this.eob.add("70_5");
        this.eob.add("70_6");
        this.eob.add("71_2");
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

    public static com.baidu.tbadk.a.e bfH() {
        return com.baidu.tbadk.a.d.j(eoa);
    }

    public static boolean E(String... strArr) {
        return b(bfH(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
