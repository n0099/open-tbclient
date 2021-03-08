package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.a.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.a.b {
    public String acA;
    public String acB;
    public boolean acC;
    public int acD;
    public int acE;
    private b.a acH;
    public String acu;
    public String acv;
    public int acx;
    public String acy;
    public String acz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int acs = 3;
    public ArrayList<String> acF = new ArrayList<>();
    public ArrayList<String> acG = new ArrayList<>();

    public void setAdType(int i) {
        this.acs = i;
    }

    public boolean isEmpty() {
        return this.acs == 2;
    }

    public int ru() {
        return this.acs;
    }

    public boolean isValid() {
        if (ru() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (ru() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String rv() {
        return StringUtils.isNull(this.acA) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.acA;
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.acH == null) {
            this.acH = new b.a();
            this.acH.ldK = this.acF;
            this.acH.ldL = this.acG;
        }
        return this.acH;
    }
}
