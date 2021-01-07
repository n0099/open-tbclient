package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes11.dex */
public class a extends BdBaseView<BaseActivity> {
    private String bMA;
    private String[] bMB;
    private j bMC;
    private h bMD;
    private AlbumActivity bMr;
    private String bMz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bMz = "tag_image";
        this.bMA = "tag_b_image";
        this.bMr = albumActivity;
    }

    public void WG() {
        this.bMB = new String[2];
        this.bMC = new j(this.bMr.getPageContext(), this.bMr);
        this.bMB[0] = this.bMz;
        this.bMD = new h(this.bMr.getPageContext(), this.bMr);
        this.bMB[1] = this.bMA;
    }

    public void onChangeSkinType(int i) {
        this.bMC.onChangeSkinType(i);
        this.bMD.onChangeSkinType(i);
    }

    public View WH() {
        if (this.bMC == null) {
            return null;
        }
        return this.bMC.WY();
    }

    public View WI() {
        if (this.bMC == null) {
            return null;
        }
        return this.bMC.Xc();
    }

    public View WJ() {
        if (this.bMD == null) {
            return null;
        }
        return this.bMD.WY();
    }

    public View WK() {
        if (this.bMD == null) {
            return null;
        }
        return this.bMD.WZ();
    }

    public View WL() {
        if (this.bMD == null) {
            return null;
        }
        return this.bMD.WL();
    }

    public View WM() {
        if (this.bMC == null) {
            return null;
        }
        return this.bMC.WL();
    }

    public void onDestroy() {
    }

    public h WN() {
        return this.bMD;
    }

    public j WO() {
        return this.bMC;
    }

    public void dj(boolean z) {
        if (this.bMD != null) {
            this.bMD.dj(z);
        }
        if (this.bMC != null) {
            this.bMC.dj(z);
        }
    }
}
