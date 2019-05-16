package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String RF;
    public String RG;
    public int RH;
    public String RI;
    public String RJ;
    public String RK;
    public String RL;
    public boolean RO;
    public int RP;
    public int RQ;
    private b.a RU;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int RE = 3;
    public ArrayList<String> RR = new ArrayList<>();
    public ArrayList<String> RT = new ArrayList<>();

    public void bd(int i) {
        this.RE = i;
    }

    public boolean isEmpty() {
        return this.RE == 2;
    }

    public int pp() {
        return this.RE;
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
        return StringUtils.isNull(this.RK) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.RK;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.RU == null) {
            this.RU = new b.a();
            this.RU.gXO = this.RR;
            this.RU.gXP = this.RT;
        }
        return this.RU;
    }
}
