package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public boolean ZA;
    public int ZB;
    public int ZC;
    private b.a ZF;
    public String Zt;
    public String Zu;
    public int Zv;
    public String Zw;
    public String Zx;
    public String Zy;
    public String Zz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Zs = 3;
    public ArrayList<String> ZD = new ArrayList<>();
    public ArrayList<String> ZE = new ArrayList<>();

    public void ba(int i) {
        this.Zs = i;
    }

    public boolean isEmpty() {
        return this.Zs == 2;
    }

    public int rT() {
        return this.Zs;
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
        return StringUtils.isNull(this.Zy) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Zy;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.ZF == null) {
            this.ZF = new b.a();
            this.ZF.kyO = this.ZD;
            this.ZF.kyP = this.ZE;
        }
        return this.ZF;
    }
}
