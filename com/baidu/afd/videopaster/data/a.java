package com.baidu.afd.videopaster.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.lego.card.b.b {
    public String DY;
    public String DZ;
    public int Ea;
    public String Eb;
    public String Ec;
    public String Ed;
    public String Ee;
    public boolean Ef;
    public int Eg;
    public int Eh;
    private b.a Ek;
    public String adid;
    public String extra;
    public String picUrl;
    public String tplName;
    public String videoUrl;
    private int DX = 3;
    public ArrayList<String> Ei = new ArrayList<>();
    public ArrayList<String> Ej = new ArrayList<>();

    public void ay(int i) {
        this.DX = i;
    }

    public boolean isEmpty() {
        return this.DX == 2;
    }

    public int ln() {
        return this.DX;
    }

    public boolean isValid() {
        if (ln() == 0) {
            return this.picUrl != null && (this.picUrl.startsWith("http://") || this.picUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else if (ln() == 1) {
            return this.videoUrl != null && (this.videoUrl.startsWith("http://") || this.videoUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        } else {
            return false;
        }
    }

    public String lo() {
        return StringUtils.isNull(this.Ed) ? TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail) : this.Ed;
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        if (this.Ek == null) {
            this.Ek = new b.a();
            this.Ek.hXM = this.Ei;
            this.Ek.hXN = this.Ej;
        }
        return this.Ek;
    }
}
