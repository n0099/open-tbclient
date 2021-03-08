package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes10.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bMP;
    private String bMX;
    private String bMY;
    private String[] bMZ;
    private j bNa;
    private h bNb;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bMX = "tag_image";
        this.bMY = "tag_b_image";
        this.bMP = albumActivity;
    }

    public void Ux() {
        this.bMZ = new String[2];
        this.bNa = new j(this.bMP.getPageContext(), this.bMP);
        this.bMZ[0] = this.bMX;
        this.bNb = new h(this.bMP.getPageContext(), this.bMP);
        this.bMZ[1] = this.bMY;
    }

    public void onChangeSkinType(int i) {
        this.bNa.onChangeSkinType(i);
        this.bNb.onChangeSkinType(i);
    }

    public View Uy() {
        if (this.bNa == null) {
            return null;
        }
        return this.bNa.UP();
    }

    public View Uz() {
        if (this.bNa == null) {
            return null;
        }
        return this.bNa.UT();
    }

    public View UA() {
        if (this.bNb == null) {
            return null;
        }
        return this.bNb.UP();
    }

    public View UB() {
        if (this.bNb == null) {
            return null;
        }
        return this.bNb.UQ();
    }

    public View UC() {
        if (this.bNb == null) {
            return null;
        }
        return this.bNb.UC();
    }

    public View UD() {
        if (this.bNa == null) {
            return null;
        }
        return this.bNa.UC();
    }

    public void onDestroy() {
    }

    public h UE() {
        return this.bNb;
    }

    public j UF() {
        return this.bNa;
    }

    public void dn(boolean z) {
        if (this.bNb != null) {
            this.bNb.dn(z);
        }
        if (this.bNa != null) {
            this.bNa.dn(z);
        }
    }
}
