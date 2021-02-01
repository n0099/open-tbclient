package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.a.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.a.b {
    public String aaX;
    public String aaY;
    public int aaZ;
    public String aba;
    public String abb;
    public String abd;
    public String abe;
    public boolean abf;
    public int abg;
    public int abh;
    private b.a abk;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int aaW = 3;
    public ArrayList<String> abi = new ArrayList<>();
    public ArrayList<String> abj = new ArrayList<>();

    public void setAdType(int i) {
        this.aaW = i;
    }

    public boolean isEmpty() {
        return this.aaW == 2;
    }

    public int ru() {
        return this.aaW;
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
        return StringUtils.isNull(this.abd) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.abd;
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.abk == null) {
            this.abk = new b.a();
            this.abk.lbt = this.abi;
            this.abk.lbu = this.abj;
        }
        return this.abk;
    }
}
