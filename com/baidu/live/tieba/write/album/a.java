package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bEh;
    private String bEo;
    private String bEp;
    private String[] bEq;
    private j bEr;
    private h bEs;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bEo = "tag_image";
        this.bEp = "tag_b_image";
        this.bEh = albumActivity;
    }

    public void TM() {
        this.bEq = new String[2];
        this.bEr = new j(this.bEh.getPageContext(), this.bEh);
        this.bEq[0] = this.bEo;
        this.bEs = new h(this.bEh.getPageContext(), this.bEh);
        this.bEq[1] = this.bEp;
    }

    public void onChangeSkinType(int i) {
        this.bEr.onChangeSkinType(i);
        this.bEs.onChangeSkinType(i);
    }

    public View TN() {
        if (this.bEr == null) {
            return null;
        }
        return this.bEr.Ue();
    }

    public View TO() {
        if (this.bEr == null) {
            return null;
        }
        return this.bEr.Ui();
    }

    public View TP() {
        if (this.bEs == null) {
            return null;
        }
        return this.bEs.Ue();
    }

    public View TQ() {
        if (this.bEs == null) {
            return null;
        }
        return this.bEs.Uf();
    }

    public View TR() {
        if (this.bEs == null) {
            return null;
        }
        return this.bEs.TR();
    }

    public View TS() {
        if (this.bEr == null) {
            return null;
        }
        return this.bEr.TR();
    }

    public void onDestroy() {
    }

    public h TT() {
        return this.bEs;
    }

    public j TU() {
        return this.bEr;
    }

    public void cQ(boolean z) {
        if (this.bEs != null) {
            this.bEs.cQ(z);
        }
        if (this.bEr != null) {
            this.bEr.cQ(z);
        }
    }
}
