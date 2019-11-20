package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String AT;
    public String AU;
    public int AV;
    public String AW;
    public String AX;
    public String AY;
    public String AZ;
    public boolean Ba;
    public int Bb;
    public int Bc;
    private b.a Bf;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int AR = 3;
    public ArrayList<String> Bd = new ArrayList<>();
    public ArrayList<String> Be = new ArrayList<>();

    public void as(int i) {
        this.AR = i;
    }

    public boolean isEmpty() {
        return this.AR == 2;
    }

    public int kG() {
        return this.AR;
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
        return StringUtils.isNull(this.AY) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.AY;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Bf == null) {
            this.Bf = new b.a();
            this.Bf.hed = this.Bd;
            this.Bf.hee = this.Be;
        }
        return this.Bf;
    }
}
