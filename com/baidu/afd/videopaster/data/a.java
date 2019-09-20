package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String RY;
    public String RZ;
    public int Sa;
    public String Sb;
    public String Sc;
    public String Sd;
    public String Se;
    public boolean Sf;
    public int Sg;
    public int Sh;
    private b.a Sk;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int RX = 3;
    public ArrayList<String> Si = new ArrayList<>();
    public ArrayList<String> Sj = new ArrayList<>();

    public void bd(int i) {
        this.RX = i;
    }

    public boolean isEmpty() {
        return this.RX == 2;
    }

    public int pL() {
        return this.RX;
    }

    public boolean isValid() {
        if (pL() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (pL() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String pM() {
        return StringUtils.isNull(this.Sd) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Sd;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Sk == null) {
            this.Sk = new b.a();
            this.Sk.hgP = this.Si;
            this.Sk.hgQ = this.Sj;
        }
        return this.Sk;
    }
}
