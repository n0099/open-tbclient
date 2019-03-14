package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String TV;
    public String TW;
    public int TX;
    public String TY;
    public String TZ;
    public String Ua;
    public String Ub;
    public boolean Uc;
    public int Ud;
    public int Ue;
    private b.a Uh;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int TU = 3;
    public ArrayList<String> Uf = new ArrayList<>();
    public ArrayList<String> Ug = new ArrayList<>();

    public void bl(int i) {
        this.TU = i;
    }

    public boolean isEmpty() {
        return this.TU == 2;
    }

    public int qu() {
        return this.TU;
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
        return StringUtils.isNull(this.Ua) ? TbadkCoreApplication.getInst().getResources().getString(d.j.check_detail) : this.Ua;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Uh == null) {
            this.Uh = new b.a();
            this.Uh.gGG = this.Uf;
            this.Uh.gGH = this.Ug;
        }
        return this.Uh;
    }
}
