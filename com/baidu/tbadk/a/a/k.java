package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a {
    public static final BdUniqueId efC = BdUniqueId.gen();
    public final ArrayList<String> efD = new ArrayList<>();
    public com.baidu.tbadk.a.e efE;

    public k() {
        this.efD.add("70_2");
        this.efD.add("70_3");
        this.efD.add("70_4");
        this.efD.add("70_5");
        this.efD.add("70_6");
        this.efD.add("71_2");
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

    public static com.baidu.tbadk.a.e bdO() {
        return com.baidu.tbadk.a.d.j(efC);
    }

    public static boolean D(String... strArr) {
        return b(bdO(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
