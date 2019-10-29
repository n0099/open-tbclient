package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private Fragment[] adI;
    private String apG;
    private String apH;
    private AlbumActivity apI;
    private String[] apJ;
    private ImageListFragment apK;
    private AlbumImageBrowseFragment apL;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.apG = "tag_image";
        this.apH = "tag_b_image";
        this.apI = albumActivity;
    }

    public void vJ() {
        this.adI = new Fragment[2];
        this.apJ = new String[2];
        this.apK = new ImageListFragment();
        this.adI[0] = this.apK;
        this.apJ[0] = this.apG;
        this.apL = new AlbumImageBrowseFragment();
        this.adI[1] = this.apL;
        this.apJ[1] = this.apH;
    }

    public Fragment ce(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.adI[i];
    }

    public String cf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.apJ[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.adI.length) {
                if (this.adI[i3] != null && (this.adI[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.adI[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public View vK() {
        if (this.apK == null) {
            return null;
        }
        return this.apK.vS();
    }

    public View vL() {
        if (this.apK == null) {
            return null;
        }
        return this.apK.wh();
    }

    public View vM() {
        if (this.apL == null) {
            return null;
        }
        return this.apL.vS();
    }

    public View vN() {
        if (this.apL == null) {
            return null;
        }
        return this.apL.vT();
    }

    public View vO() {
        if (this.apL == null) {
            return null;
        }
        return this.apL.vO();
    }

    public View vP() {
        if (this.apK == null) {
            return null;
        }
        return this.apK.vO();
    }

    public void onDestroy() {
    }

    public void aQ(boolean z) {
        if (this.apL != null) {
            this.apL.aQ(z);
        }
        if (this.apK != null) {
            this.apK.aQ(z);
        }
    }
}
