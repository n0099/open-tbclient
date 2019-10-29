package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public boolean BA;
    public int BB;
    public int BC;
    private b.a BF;
    public String Bt;
    public String Bu;
    public int Bv;
    public String Bw;
    public String Bx;
    public String By;
    public String Bz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Bs = 3;
    public ArrayList<String> BD = new ArrayList<>();
    public ArrayList<String> BE = new ArrayList<>();

    public void as(int i) {
        this.Bs = i;
    }

    public boolean isEmpty() {
        return this.Bs == 2;
    }

    public int kG() {
        return this.Bs;
    }

    public boolean isValid() {
        if (kG() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (kG() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String kH() {
        return StringUtils.isNull(this.By) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.By;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.BF == null) {
            this.BF = new b.a();
            this.BF.heU = this.BD;
            this.BF.heV = this.BE;
        }
        return this.BF;
    }
}
