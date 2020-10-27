package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bxW;
    private String byd;
    private String bye;
    private String[] byf;
    private j byg;
    private h byh;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.byd = "tag_image";
        this.bye = "tag_b_image";
        this.bxW = albumActivity;
    }

    public void Re() {
        this.byf = new String[2];
        this.byg = new j(this.bxW.getPageContext(), this.bxW);
        this.byf[0] = this.byd;
        this.byh = new h(this.bxW.getPageContext(), this.bxW);
        this.byf[1] = this.bye;
    }

    public void onChangeSkinType(int i) {
        this.byg.onChangeSkinType(i);
        this.byh.onChangeSkinType(i);
    }

    public View Rf() {
        if (this.byg == null) {
            return null;
        }
        return this.byg.Rw();
    }

    public View Rg() {
        if (this.byg == null) {
            return null;
        }
        return this.byg.RA();
    }

    public View Rh() {
        if (this.byh == null) {
            return null;
        }
        return this.byh.Rw();
    }

    public View Ri() {
        if (this.byh == null) {
            return null;
        }
        return this.byh.Rx();
    }

    public View Rj() {
        if (this.byh == null) {
            return null;
        }
        return this.byh.Rj();
    }

    public View Rk() {
        if (this.byg == null) {
            return null;
        }
        return this.byg.Rj();
    }

    public void onDestroy() {
    }

    public h Rl() {
        return this.byh;
    }

    public j Rm() {
        return this.byg;
    }

    public void cJ(boolean z) {
        if (this.byh != null) {
            this.byh.cJ(z);
        }
        if (this.byg != null) {
            this.byg.cJ(z);
        }
    }
}
