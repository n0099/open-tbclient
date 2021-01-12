package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.a.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.a.b {
    public String abb;
    public String abd;
    public int abe;
    public String abf;
    public String abg;
    public String abh;
    public String abi;
    public boolean abj;
    public int abk;
    public int abl;
    private b.a abo;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int aba = 3;
    public ArrayList<String> abm = new ArrayList<>();
    public ArrayList<String> abn = new ArrayList<>();

    public void setAdType(int i) {
        this.aba = i;
    }

    public boolean isEmpty() {
        return this.aba == 2;
    }

    public int rw() {
        return this.aba;
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
        return StringUtils.isNull(this.abh) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.abh;
    }

    @Override // com.baidu.tieba.lego.card.a.b
    public b.a getParallelCharge() {
        if (this.abo == null) {
            this.abo = new b.a();
            this.abo.kTq = this.abm;
            this.abo.kTr = this.abn;
        }
        return this.abo;
    }
}
