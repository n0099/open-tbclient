package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public int XA;
    public int XB;
    private b.a XE;
    public String Xs;
    public String Xt;
    public int Xu;
    public String Xv;
    public String Xw;
    public String Xx;
    public String Xy;
    public boolean Xz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Xr = 3;
    public ArrayList<String> XC = new ArrayList<>();
    public ArrayList<String> XD = new ArrayList<>();

    public void aK(int i) {
        this.Xr = i;
    }

    public boolean isEmpty() {
        return this.Xr == 2;
    }

    public int pR() {
        return this.Xr;
    }

    public boolean isValid() {
        if (pR() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (pR() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String pS() {
        return StringUtils.isNull(this.Xx) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Xx;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.XE == null) {
            this.XE = new b.a();
            this.XE.iJw = this.XC;
            this.XE.iJx = this.XD;
        }
        return this.XE;
    }
}
