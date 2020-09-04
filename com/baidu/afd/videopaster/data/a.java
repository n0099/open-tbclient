package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String YJ;
    public String YK;
    public int YL;
    public String YM;
    public String YN;
    public String YO;
    public String YP;
    public boolean YQ;
    public int YR;
    public int YS;
    private b.a YV;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int YI = 3;
    public ArrayList<String> YT = new ArrayList<>();
    public ArrayList<String> YU = new ArrayList<>();

    public void aW(int i) {
        this.YI = i;
    }

    public boolean isEmpty() {
        return this.YI == 2;
    }

    public int rO() {
        return this.YI;
    }

    public boolean isValid() {
        if (rO() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (rO() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String rP() {
        return StringUtils.isNull(this.YO) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.YO;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.YV == null) {
            this.YV = new b.a();
            this.YV.jOy = this.YT;
            this.YV.jOz = this.YU;
        }
        return this.YV;
    }
}
