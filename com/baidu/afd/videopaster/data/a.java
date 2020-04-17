package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    private b.a XB;
    public String Xp;
    public String Xq;
    public int Xr;
    public String Xs;
    public String Xt;
    public String Xu;
    public String Xv;
    public boolean Xw;
    public int Xx;
    public int Xy;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Xo = 3;
    public ArrayList<String> Xz = new ArrayList<>();
    public ArrayList<String> XA = new ArrayList<>();

    public void aK(int i) {
        this.Xo = i;
    }

    public boolean isEmpty() {
        return this.Xo == 2;
    }

    public int pR() {
        return this.Xo;
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
        return StringUtils.isNull(this.Xu) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Xu;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.XB == null) {
            this.XB = new b.a();
            this.XB.iJs = this.Xz;
            this.XB.iJt = this.XA;
        }
        return this.XB;
    }
}
