package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.a.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.a.b {
    public String abe;
    public String abf;
    public int abg;
    public String abh;
    public String abi;
    public String abj;
    public String abk;
    public boolean abl;
    public int abm;
    public int abn;
    private b.a abq;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int abd = 3;
    public ArrayList<String> abo = new ArrayList<>();
    public ArrayList<String> abp = new ArrayList<>();

    public void setAdType(int i) {
        this.abd = i;
    }

    public boolean isEmpty() {
        return this.abd == 2;
    }

    public int rw() {
        return this.abd;
    }

    public boolean isValid() {
        if (rw() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (rw() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String rx() {
        return StringUtils.isNull(this.abj) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.abj;
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.abq == null) {
            this.abq = new b.a();
            this.abq.kXV = this.abo;
            this.abq.kXW = this.abp;
        }
        return this.abq;
    }
}
