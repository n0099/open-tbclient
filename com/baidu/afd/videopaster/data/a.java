package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String Ym;
    public String Yn;
    public int Yo;
    public String Yp;
    public String Yq;
    public String Yr;
    public String Ys;
    public boolean Yt;
    public int Yu;
    public int Yv;
    private b.a Yy;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Yl = 3;
    public ArrayList<String> Yw = new ArrayList<>();
    public ArrayList<String> Yx = new ArrayList<>();

    public void aR(int i) {
        this.Yl = i;
    }

    public boolean isEmpty() {
        return this.Yl == 2;
    }

    public int qo() {
        return this.Yl;
    }

    public boolean isValid() {
        if (qo() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (qo() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String qp() {
        return StringUtils.isNull(this.Yr) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Yr;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Yy == null) {
            this.Yy = new b.a();
            this.Yy.jqt = this.Yw;
            this.Yy.jqu = this.Yx;
        }
        return this.Yy;
    }
}
