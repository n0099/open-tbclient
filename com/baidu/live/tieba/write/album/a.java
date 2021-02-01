package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes11.dex */
public class a extends BdBaseView<BaseActivity> {
    private j bLA;
    private h bLB;
    private AlbumActivity bLp;
    private String bLx;
    private String bLy;
    private String[] bLz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bLx = "tag_image";
        this.bLy = "tag_b_image";
        this.bLp = albumActivity;
    }

    public void Uu() {
        this.bLz = new String[2];
        this.bLA = new j(this.bLp.getPageContext(), this.bLp);
        this.bLz[0] = this.bLx;
        this.bLB = new h(this.bLp.getPageContext(), this.bLp);
        this.bLz[1] = this.bLy;
    }

    public void onChangeSkinType(int i) {
        this.bLA.onChangeSkinType(i);
        this.bLB.onChangeSkinType(i);
    }

    public View Uv() {
        if (this.bLA == null) {
            return null;
        }
        return this.bLA.UM();
    }

    public View Uw() {
        if (this.bLA == null) {
            return null;
        }
        return this.bLA.UQ();
    }

    public View Ux() {
        if (this.bLB == null) {
            return null;
        }
        return this.bLB.UM();
    }

    public View Uy() {
        if (this.bLB == null) {
            return null;
        }
        return this.bLB.UN();
    }

    public View Uz() {
        if (this.bLB == null) {
            return null;
        }
        return this.bLB.Uz();
    }

    public View UA() {
        if (this.bLA == null) {
            return null;
        }
        return this.bLA.Uz();
    }

    public void onDestroy() {
    }

    public h UB() {
        return this.bLB;
    }

    public j UC() {
        return this.bLA;
    }

    public void dn(boolean z) {
        if (this.bLB != null) {
            this.bLB.dn(z);
        }
        if (this.bLA != null) {
            this.bLA.dn(z);
        }
    }
}
