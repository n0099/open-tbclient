package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private String aWg;
    private String aWh;
    private AlbumActivity aWi;
    private String[] aWj;
    private ImageListFragment aWk;
    private AlbumImageBrowseFragment aWl;
    private List<Fragment> mFragments;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aWg = "tag_image";
        this.aWh = "tag_b_image";
        this.aWi = albumActivity;
    }

    public void Fv() {
        this.mFragments = new ArrayList(2);
        this.aWj = new String[2];
        this.aWk = new ImageListFragment();
        this.mFragments.add(this.aWk);
        this.aWj[0] = this.aWg;
        this.aWl = new AlbumImageBrowseFragment();
        this.mFragments.add(this.aWl);
        this.aWj[1] = this.aWh;
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
        return this.aWj[i];
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

    public View Fw() {
        if (this.aWk == null) {
            return null;
        }
        return this.aWk.FE();
    }

    public View Fx() {
        if (this.aWk == null) {
            return null;
        }
        return this.aWk.FT();
    }

    public View Fy() {
        if (this.aWl == null) {
            return null;
        }
        return this.aWl.FE();
    }

    public View Fz() {
        if (this.aWl == null) {
            return null;
        }
        return this.aWl.FF();
    }

    public View FA() {
        if (this.aWl == null) {
            return null;
        }
        return this.aWl.FA();
    }

    public View FB() {
        if (this.aWk == null) {
            return null;
        }
        return this.aWk.FA();
    }

    public void onDestroy() {
    }

    public void bY(boolean z) {
        if (this.aWl != null) {
            this.aWl.bY(z);
        }
        if (this.aWk != null) {
            this.aWk.bY(z);
        }
    }
}
