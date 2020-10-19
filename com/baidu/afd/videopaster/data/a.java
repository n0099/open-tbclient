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
    public int ZB;
    private b.a ZE;
    public String Zs;
    public String Zt;
    public int Zu;
    public String Zv;
    public String Zw;
    public String Zx;
    public String Zy;
    public boolean Zz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Zr = 3;
    public ArrayList<String> ZC = new ArrayList<>();
    public ArrayList<String> ZD = new ArrayList<>();

    public void ba(int i) {
        this.Zr = i;
    }

    public boolean isEmpty() {
        return this.Zr == 2;
    }

    public int rT() {
        return this.Zr;
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
        return StringUtils.isNull(this.Zx) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Zx;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.ZE == null) {
            this.ZE = new b.a();
            this.ZE.kmr = this.ZC;
            this.ZE.kms = this.ZD;
        }
        return this.ZE;
    }
}
