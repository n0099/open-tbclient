package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes10.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bHF;
    private String bHN;
    private String bHO;
    private String[] bHP;
    private j bHQ;
    private h bHR;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bHN = "tag_image";
        this.bHO = "tag_b_image";
        this.bHF = albumActivity;
    }

    public void SN() {
        this.bHP = new String[2];
        this.bHQ = new j(this.bHF.getPageContext(), this.bHF);
        this.bHP[0] = this.bHN;
        this.bHR = new h(this.bHF.getPageContext(), this.bHF);
        this.bHP[1] = this.bHO;
    }

    public void onChangeSkinType(int i) {
        this.bHQ.onChangeSkinType(i);
        this.bHR.onChangeSkinType(i);
    }

    public View SO() {
        if (this.bHQ == null) {
            return null;
        }
        return this.bHQ.Tf();
    }

    public View SP() {
        if (this.bHQ == null) {
            return null;
        }
        return this.bHQ.Tj();
    }

    public View SQ() {
        if (this.bHR == null) {
            return null;
        }
        return this.bHR.Tf();
    }

    public View SR() {
        if (this.bHR == null) {
            return null;
        }
        return this.bHR.Tg();
    }

    public View SS() {
        if (this.bHR == null) {
            return null;
        }
        return this.bHR.SS();
    }

    public View ST() {
        if (this.bHQ == null) {
            return null;
        }
        return this.bHQ.SS();
    }

    public void onDestroy() {
    }

    public h SU() {
        return this.bHR;
    }

    public j SV() {
        return this.bHQ;
    }

    public void df(boolean z) {
        if (this.bHR != null) {
            this.bHR.df(z);
        }
        if (this.bHQ != null) {
            this.bHQ.df(z);
        }
    }
}
