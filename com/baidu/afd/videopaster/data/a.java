package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String aaA;
    public boolean aaB;
    public int aaC;
    public int aaD;
    private b.a aaG;
    public String aau;
    public String aav;
    public int aaw;
    public String aax;
    public String aay;
    public String aaz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int aat = 3;
    public ArrayList<String> aaE = new ArrayList<>();
    public ArrayList<String> aaF = new ArrayList<>();

    public void be(int i) {
        this.aat = i;
    }

    public boolean isEmpty() {
        return this.aat == 2;
    }

    public int rV() {
        return this.aat;
    }

    public boolean isValid() {
        if (rV() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (rV() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String rW() {
        return StringUtils.isNull(this.aaz) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.aaz;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.aaG == null) {
            this.aaG = new b.a();
            this.aaG.kSp = this.aaE;
            this.aaG.kSq = this.aaF;
        }
        return this.aaG;
    }
}
