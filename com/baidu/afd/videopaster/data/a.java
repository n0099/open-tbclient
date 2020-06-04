package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String XH;
    public String XI;
    public int XJ;
    public String XK;
    public String XL;
    public String XM;
    public String XN;
    public boolean XO;
    public int XP;
    public int XQ;
    private b.a XT;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int XG = 3;
    public ArrayList<String> XR = new ArrayList<>();
    public ArrayList<String> XS = new ArrayList<>();

    public void aL(int i) {
        this.XG = i;
    }

    public boolean isEmpty() {
        return this.XG == 2;
    }

    public int pX() {
        return this.XG;
    }

    public boolean isValid() {
        if (pX() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (pX() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String pY() {
        return StringUtils.isNull(this.XM) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.XM;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.XT == null) {
            this.XT = new b.a();
            this.XT.iZj = this.XR;
            this.XT.iZk = this.XS;
        }
        return this.XT;
    }
}
