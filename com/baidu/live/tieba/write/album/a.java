package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private String aWb;
    private String aWc;
    private AlbumActivity aWd;
    private String[] aWe;
    private ImageListFragment aWf;
    private AlbumImageBrowseFragment aWg;
    private List<Fragment> mFragments;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aWb = "tag_image";
        this.aWc = "tag_b_image";
        this.aWd = albumActivity;
    }

    public void Fw() {
        this.mFragments = new ArrayList(2);
        this.aWe = new String[2];
        this.aWf = new ImageListFragment();
        this.mFragments.add(this.aWf);
        this.aWe[0] = this.aWb;
        this.aWg = new AlbumImageBrowseFragment();
        this.mFragments.add(this.aWg);
        this.aWe[1] = this.aWc;
    }

    public Fragment dc(int i) {
        if (i < 0 || this.mFragments == null || i >= this.mFragments.size()) {
            return null;
        }
        return this.mFragments.get(i);
    }

    public String dd(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aWe[i];
    }

    public void onChangeSkinType(int i) {
        if (this.mFragments != null && !this.mFragments.isEmpty()) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mFragments.size()) {
                    if (this.mFragments.get(i3) instanceof ImageListFragment) {
                        ((ImageListFragment) this.mFragments.get(i3)).onChangeSkinType(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public View Fx() {
        if (this.aWf == null) {
            return null;
        }
        return this.aWf.FF();
    }

    public View Fy() {
        if (this.aWf == null) {
            return null;
        }
        return this.aWf.FU();
    }

    public View Fz() {
        if (this.aWg == null) {
            return null;
        }
        return this.aWg.FF();
    }

    public View FA() {
        if (this.aWg == null) {
            return null;
        }
        return this.aWg.FG();
    }

    public View FB() {
        if (this.aWg == null) {
            return null;
        }
        return this.aWg.FB();
    }

    public View FC() {
        if (this.aWf == null) {
            return null;
        }
        return this.aWf.FB();
    }

    public void onDestroy() {
    }

    public void bY(boolean z) {
        if (this.aWg != null) {
            this.aWg.bY(z);
        }
        if (this.aWf != null) {
            this.aWf.bY(z);
        }
    }
}
