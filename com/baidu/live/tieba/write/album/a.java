package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity brU;
    private String bsb;
    private String bsc;
    private String[] bsd;
    private j bse;
    private h bsf;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bsb = "tag_image";
        this.bsc = "tag_b_image";
        this.brU = albumActivity;
    }

    public void Pe() {
        this.bsd = new String[2];
        this.bse = new j(this.brU.getPageContext(), this.brU);
        this.bsd[0] = this.bsb;
        this.bsf = new h(this.brU.getPageContext(), this.brU);
        this.bsd[1] = this.bsc;
    }

    public void onChangeSkinType(int i) {
        this.bse.onChangeSkinType(i);
        this.bsf.onChangeSkinType(i);
    }

    public View Pf() {
        if (this.bse == null) {
            return null;
        }
        return this.bse.Pw();
    }

    public View Pg() {
        if (this.bse == null) {
            return null;
        }
        return this.bse.PA();
    }

    public View Ph() {
        if (this.bsf == null) {
            return null;
        }
        return this.bsf.Pw();
    }

    public View Pi() {
        if (this.bsf == null) {
            return null;
        }
        return this.bsf.Px();
    }

    public View Pj() {
        if (this.bsf == null) {
            return null;
        }
        return this.bsf.Pj();
    }

    public View Pk() {
        if (this.bse == null) {
            return null;
        }
        return this.bse.Pj();
    }

    public void onDestroy() {
    }

    public h Pl() {
        return this.bsf;
    }

    public j Pm() {
        return this.bse;
    }

    public void cA(boolean z) {
        if (this.bsf != null) {
            this.bsf.cA(z);
        }
        if (this.bse != null) {
            this.bse.cA(z);
        }
    }
}
