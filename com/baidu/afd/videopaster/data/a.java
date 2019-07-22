package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String RZ;
    public String Sa;
    public int Sb;
    public String Sc;
    public String Sd;
    public String Se;
    public String Sf;
    public boolean Sg;
    public int Sh;
    public int Si;
    private b.a Sl;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int RY = 3;
    public ArrayList<String> Sj = new ArrayList<>();
    public ArrayList<String> Sk = new ArrayList<>();

    public void bd(int i) {
        this.RY = i;
    }

    public boolean isEmpty() {
        return this.RY == 2;
    }

    public int pK() {
        return this.RY;
    }

    public boolean isValid() {
        if (pK() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (pK() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String pL() {
        return StringUtils.isNull(this.Se) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Se;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Sl == null) {
            this.Sl = new b.a();
            this.Sl.hed = this.Sj;
            this.Sl.hee = this.Sk;
        }
        return this.Sl;
    }
}
