package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseActivity> {
    private String bdD;
    private String bdE;
    private String[] bdF;
    private j bdG;
    private h bdH;
    private AlbumActivity bdw;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bdD = "tag_image";
        this.bdE = "tag_b_image";
        this.bdw = albumActivity;
    }

    public void Hp() {
        this.bdF = new String[2];
        this.bdG = new j(this.bdw.getPageContext(), this.bdw);
        this.bdF[0] = this.bdD;
        this.bdH = new h(this.bdw.getPageContext(), this.bdw);
        this.bdF[1] = this.bdE;
    }

    public void onChangeSkinType(int i) {
        this.bdG.onChangeSkinType(i);
        this.bdH.onChangeSkinType(i);
    }

    public View Hq() {
        if (this.bdG == null) {
            return null;
        }
        return this.bdG.HI();
    }

    public View Hr() {
        if (this.bdG == null) {
            return null;
        }
        return this.bdG.HM();
    }

    public View Hs() {
        if (this.bdH == null) {
            return null;
        }
        return this.bdH.HI();
    }

    public View Ht() {
        if (this.bdH == null) {
            return null;
        }
        return this.bdH.HJ();
    }

    public View Hu() {
        if (this.bdH == null) {
            return null;
        }
        return this.bdH.Hu();
    }

    public View Hv() {
        if (this.bdG == null) {
            return null;
        }
        return this.bdG.Hu();
    }

    public void onDestroy() {
    }

    public h Hw() {
        return this.bdH;
    }

    public j Hx() {
        return this.bdG;
    }

    public void ci(boolean z) {
        if (this.bdH != null) {
            this.bdH.ci(z);
        }
        if (this.bdG != null) {
            this.bdG.ci(z);
        }
    }
}
