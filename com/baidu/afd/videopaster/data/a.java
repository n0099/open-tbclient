package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String Zb;
    public String Zc;
    public int Ze;
    public String Zf;
    public String Zg;
    public String Zh;
    public String Zi;
    public boolean Zj;
    public int Zk;
    public int Zl;
    private b.a Zo;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Za = 3;
    public ArrayList<String> Zm = new ArrayList<>();
    public ArrayList<String> Zn = new ArrayList<>();

    public void ba(int i) {
        this.Za = i;
    }

    public boolean isEmpty() {
        return this.Za == 2;
    }

    public int rT() {
        return this.Za;
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
        return StringUtils.isNull(this.Zh) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Zh;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Zo == null) {
            this.Zo = new b.a();
            this.Zo.jXb = this.Zm;
            this.Zo.jXc = this.Zn;
        }
        return this.Zo;
    }
}
