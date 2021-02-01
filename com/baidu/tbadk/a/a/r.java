package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r extends a {
    public static final BdUniqueId eGl = BdUniqueId.gen();
    private final ArrayList<String> eGm = new ArrayList<>(6);
    private com.baidu.tbadk.a.e eGn;

    public r() {
        this.eGm.add("12_3_video_release");
        this.eGm.add("12_3_video_release_a");
        this.eGm.add("12_3_video_release_b");
        this.eGm.add("12_3_video_release_c");
        this.eGm.add("12_3_video_release_d");
        this.eGm.add("12_3_video_release_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjD() {
        return eGl;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjE() {
        return this.eGm;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjF() {
        return this.eGn;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eGn = eVar;
    }
}
