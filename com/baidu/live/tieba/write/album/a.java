package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bHE;
    private String bHL;
    private String bHM;
    private String[] bHN;
    private j bHO;
    private h bHP;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bHL = "tag_image";
        this.bHM = "tag_b_image";
        this.bHE = albumActivity;
    }

    public void VD() {
        this.bHN = new String[2];
        this.bHO = new j(this.bHE.getPageContext(), this.bHE);
        this.bHN[0] = this.bHL;
        this.bHP = new h(this.bHE.getPageContext(), this.bHE);
        this.bHN[1] = this.bHM;
    }

    public void onChangeSkinType(int i) {
        this.bHO.onChangeSkinType(i);
        this.bHP.onChangeSkinType(i);
    }

    public View VE() {
        if (this.bHO == null) {
            return null;
        }
        return this.bHO.VV();
    }

    public View VF() {
        if (this.bHO == null) {
            return null;
        }
        return this.bHO.VZ();
    }

    public View VG() {
        if (this.bHP == null) {
            return null;
        }
        return this.bHP.VV();
    }

    public View VH() {
        if (this.bHP == null) {
            return null;
        }
        return this.bHP.VW();
    }

    public View VI() {
        if (this.bHP == null) {
            return null;
        }
        return this.bHP.VI();
    }

    public View VJ() {
        if (this.bHO == null) {
            return null;
        }
        return this.bHO.VI();
    }

    public void onDestroy() {
    }

    public h VK() {
        return this.bHP;
    }

    public j VL() {
        return this.bHO;
    }

    public void dg(boolean z) {
        if (this.bHP != null) {
            this.bHP.dg(z);
        }
        if (this.bHO != null) {
            this.bHO.dg(z);
        }
    }
}
