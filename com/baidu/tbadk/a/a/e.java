package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a {
    public static final BdUniqueId dIg = BdUniqueId.gen();
    public final ArrayList<String> dIh = new ArrayList<>();
    public com.baidu.tbadk.a.e dIi;

    public e() {
        this.dIh.add("70_2");
        this.dIh.add("70_3");
        this.dIh.add("70_4");
        this.dIh.add("70_5");
        this.dIh.add("70_6");
        this.dIh.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId aRS() {
        return dIg;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> aRT() {
        return this.dIh;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e aRU() {
        return this.dIi;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.dIi = eVar;
    }

    public static com.baidu.tbadk.a.e aRV() {
        return com.baidu.tbadk.a.d.j(dIg);
    }

    public static boolean B(String... strArr) {
        return b(aRV(), strArr);
    }

    public static boolean b(com.baidu.tbadk.a.e eVar, String... strArr) {
        return com.baidu.tbadk.a.d.a(eVar, strArr);
    }
}
