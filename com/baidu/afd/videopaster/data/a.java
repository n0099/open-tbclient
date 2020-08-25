package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String YH;
    public String YI;
    public int YJ;
    public String YK;
    public String YL;
    public String YM;
    public String YN;
    public boolean YO;
    public int YP;
    public int YQ;
    private b.a YT;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int YG = 3;
    public ArrayList<String> YR = new ArrayList<>();
    public ArrayList<String> YS = new ArrayList<>();

    public void aW(int i) {
        this.YG = i;
    }

    public boolean isEmpty() {
        return this.YG == 2;
    }

    public int rO() {
        return this.YG;
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
        return StringUtils.isNull(this.YM) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.YM;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.YT == null) {
            this.YT = new b.a();
            this.YT.jOs = this.YR;
            this.YT.jOt = this.YS;
        }
        return this.YT;
    }
}
