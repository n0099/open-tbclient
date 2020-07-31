package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bjd;
    private String bjk;
    private String bjl;
    private String[] bjm;
    private j bjn;
    private h bjo;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bjk = "tag_image";
        this.bjl = "tag_b_image";
        this.bjd = albumActivity;
    }

    public void II() {
        this.bjm = new String[2];
        this.bjn = new j(this.bjd.getPageContext(), this.bjd);
        this.bjm[0] = this.bjk;
        this.bjo = new h(this.bjd.getPageContext(), this.bjd);
        this.bjm[1] = this.bjl;
    }

    public void onChangeSkinType(int i) {
        this.bjn.onChangeSkinType(i);
        this.bjo.onChangeSkinType(i);
    }

    public View IJ() {
        if (this.bjn == null) {
            return null;
        }
        return this.bjn.Jb();
    }

    public View IK() {
        if (this.bjn == null) {
            return null;
        }
        return this.bjn.Jf();
    }

    public View IL() {
        if (this.bjo == null) {
            return null;
        }
        return this.bjo.Jb();
    }

    public View IM() {
        if (this.bjo == null) {
            return null;
        }
        return this.bjo.Jc();
    }

    public View IN() {
        if (this.bjo == null) {
            return null;
        }
        return this.bjo.IN();
    }

    public View IO() {
        if (this.bjn == null) {
            return null;
        }
        return this.bjn.IN();
    }

    public void onDestroy() {
    }

    public h IP() {
        return this.bjo;
    }

    public j IQ() {
        return this.bjn;
    }

    public void cp(boolean z) {
        if (this.bjo != null) {
            this.bjo.cp(z);
        }
        if (this.bjn != null) {
            this.bjn.cp(z);
        }
    }
}
