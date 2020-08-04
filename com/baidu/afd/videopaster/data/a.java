package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String Yb;
    public String Yc;
    public int Ye;
    public String Yf;
    public String Yg;
    public String Yh;
    public String Yi;
    public boolean Yj;
    public int Yk;
    public int Yl;
    private b.a Yo;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Ya = 3;
    public ArrayList<String> Ym = new ArrayList<>();
    public ArrayList<String> Yn = new ArrayList<>();

    public void aT(int i) {
        this.Ya = i;
    }

    public boolean isEmpty() {
        return this.Ya == 2;
    }

    public int qp() {
        return this.Ya;
    }

    public boolean isValid() {
        if (qp() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (qp() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String qq() {
        return StringUtils.isNull(this.Yh) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Yh;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Yo == null) {
            this.Yo = new b.a();
            this.Yo.jyY = this.Ym;
            this.Yo.jyZ = this.Yn;
        }
        return this.Yo;
    }
}
