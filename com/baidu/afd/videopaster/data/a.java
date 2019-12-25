package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String DA;
    public String DC;
    public String DD;
    public boolean DE;
    public int DG;
    public int DH;
    private b.a DK;
    public String Dw;
    public String Dx;
    public int Dy;
    public String Dz;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int Dv = 3;
    public ArrayList<String> DI = new ArrayList<>();
    public ArrayList<String> DJ = new ArrayList<>();

    public void av(int i) {
        this.Dv = i;
    }

    public boolean isEmpty() {
        return this.Dv == 2;
    }

    public int kX() {
        return this.Dv;
    }

    public boolean isValid() {
        if (kX() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (kX() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String kY() {
        return StringUtils.isNull(this.DC) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.DC;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.DK == null) {
            this.DK = new b.a();
            this.DK.hSk = this.DI;
            this.DK.hSl = this.DJ;
        }
        return this.DK;
    }
}
