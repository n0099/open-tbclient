package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String TU;
    public String TV;
    public int TW;
    public String TX;
    public String TY;
    public String TZ;
    public String Ua;
    public boolean Ub;
    public int Uc;
    public int Ud;
    private b.a Ug;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int TT = 3;
    public ArrayList<String> Ue = new ArrayList<>();
    public ArrayList<String> Uf = new ArrayList<>();

    public void bl(int i) {
        this.TT = i;
    }

    public boolean isEmpty() {
        return this.TT == 2;
    }

    public int qu() {
        return this.TT;
    }

    public boolean isValid() {
        if (qu() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith("https://"));
        } else if (qu() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith("https://"));
        } else {
            return false;
        }
    }

    public String qv() {
        return StringUtils.isNull(this.TZ) ? TbadkCoreApplication.getInst().getResources().getString(d.j.check_detail) : this.TZ;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Ug == null) {
            this.Ug = new b.a();
            this.Ug.gGG = this.Ue;
            this.Ug.gGH = this.Uf;
        }
        return this.Ug;
    }
}
