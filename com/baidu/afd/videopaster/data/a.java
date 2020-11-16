package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public int ZA;
    public String ZB;
    public String ZC;
    public String ZD;
    public String ZE;
    public boolean ZF;
    public int ZG;
    public int ZH;
    private b.a ZK;
    public String Zy;
    public String Zz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Zx = 3;
    public ArrayList<String> ZI = new ArrayList<>();
    public ArrayList<String> ZJ = new ArrayList<>();

    public void ba(int i) {
        this.Zx = i;
    }

    public boolean isEmpty() {
        return this.Zx == 2;
    }

    public int rT() {
        return this.Zx;
    }

    public boolean isValid() {
        if (rT() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (rT() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String rU() {
        return StringUtils.isNull(this.ZD) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.ZD;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.ZK == null) {
            this.ZK = new b.a();
            this.ZK.kEX = this.ZI;
            this.ZK.kEY = this.ZJ;
        }
        return this.ZK;
    }
}
