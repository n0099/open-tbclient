package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r extends a {
    public static final BdUniqueId eHM = BdUniqueId.gen();
    private final ArrayList<String> eHN = new ArrayList<>(6);
    private com.baidu.tbadk.a.e eHO;

    public r() {
        this.eHN.add("12_3_video_release");
        this.eHN.add("12_3_video_release_a");
        this.eHN.add("12_3_video_release_b");
        this.eHN.add("12_3_video_release_c");
        this.eHN.add("12_3_video_release_d");
        this.eHN.add("12_3_video_release_e");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId bjF() {
        return eHM;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> bjG() {
        return this.eHN;
    }

    @Override // com.baidu.tbadk.a.a.a
    public com.baidu.tbadk.a.e bjH() {
        return this.eHO;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(com.baidu.tbadk.a.e eVar) {
        this.eHO = eVar;
    }
}
