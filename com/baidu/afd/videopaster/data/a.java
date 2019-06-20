package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String RE;
    public String RF;
    public int RG;
    public String RH;
    public String RI;
    public String RJ;
    public String RK;
    public boolean RL;
    public int RO;
    public int RP;
    private b.a RT;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int RD = 3;
    public ArrayList<String> RQ = new ArrayList<>();
    public ArrayList<String> RR = new ArrayList<>();

    public void bd(int i) {
        this.RD = i;
    }

    public boolean isEmpty() {
        return this.RD == 2;
    }

    public int pp() {
        return this.RD;
    }

    public boolean isValid() {
        if (pp() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith("https://"));
        } else if (pp() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith("https://"));
        } else {
            return false;
        }
    }

    public String pq() {
        return StringUtils.isNull(this.RJ) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.RJ;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.RT == null) {
            this.RT = new b.a();
            this.RT.gXS = this.RQ;
            this.RT.gXT = this.RR;
        }
        return this.RT;
    }
}
