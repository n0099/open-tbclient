package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends a {
    public static final BdUniqueId ezr = BdUniqueId.gen();
    public final ArrayList<String> ezs = new ArrayList<>();
    public com.baidu.tbadk.a.e ezt;

    public n() {
        this.ezs.add("70_2");
        this.ezs.add("70_3");
        this.ezs.add("70_4");
        this.ezs.add("70_5");
        this.ezs.add("70_6");
        this.ezs.add("71_2");
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
