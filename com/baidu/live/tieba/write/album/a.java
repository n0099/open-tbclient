package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private Fragment[] alo;
    private String axf;
    private String axg;
    private AlbumActivity axh;
    private String[] axi;
    private ImageListFragment axj;
    private AlbumImageBrowseFragment axk;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.axf = "tag_image";
        this.axg = "tag_b_image";
        this.axh = albumActivity;
    }

    public void xI() {
        this.alo = new Fragment[2];
        this.axi = new String[2];
        this.axj = new ImageListFragment();
        this.alo[0] = this.axj;
        this.axi[0] = this.axf;
        this.axk = new AlbumImageBrowseFragment();
        this.alo[1] = this.axk;
        this.axi[1] = this.axg;
    }

    public Fragment cw(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.alo[i];
    }

    public String cx(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.axi[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.alo.length) {
                if (this.alo[i3] != null && (this.alo[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.alo[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public View xJ() {
        if (this.axj == null) {
            return null;
        }
        return this.axj.xR();
    }

    public View xK() {
        if (this.axj == null) {
            return null;
        }
        return this.axj.yg();
    }

    public View xL() {
        if (this.axk == null) {
            return null;
        }
        return this.axk.xR();
    }

    public View xM() {
        if (this.axk == null) {
            return null;
        }
        return this.axk.xS();
    }

    public View xN() {
        if (this.axk == null) {
            return null;
        }
        return this.axk.xN();
    }

    public View xO() {
        if (this.axj == null) {
            return null;
        }
        return this.axj.xN();
    }

    public void onDestroy() {
    }

    public void bh(boolean z) {
        if (this.axk != null) {
            this.axk.bh(z);
        }
        if (this.axj != null) {
            this.axj.bh(z);
        }
    }
}
