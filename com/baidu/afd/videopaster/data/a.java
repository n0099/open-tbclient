package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String DC;
    public String DD;
    public int DE;
    public String DG;
    public String DH;
    public String DI;
    public String DJ;
    public boolean DK;
    public int DM;
    public int DN;
    private b.a DR;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int DA = 3;
    public ArrayList<String> DO = new ArrayList<>();
    public ArrayList<String> DQ = new ArrayList<>();

    public void av(int i) {
        this.DA = i;
    }

    public boolean isEmpty() {
        return this.DA == 2;
    }

    public int kY() {
        return this.DA;
    }

    public boolean isValid() {
        if (kY() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (kY() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String kZ() {
        return StringUtils.isNull(this.DI) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.DI;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.DR == null) {
            this.DR = new b.a();
            this.DR.hVO = this.DO;
            this.DR.hVP = this.DQ;
        }
        return this.DR;
    }
}
