package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private String aCu;
    private String aCv;
    private AlbumActivity aCw;
    private String[] aCx;
    private ImageListFragment aCy;
    private AlbumImageBrowseFragment aCz;
    private List<Fragment> mFragments;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCu = "tag_image";
        this.aCv = "tag_b_image";
        this.aCw = albumActivity;
    }

    public void Ay() {
        this.mFragments = new ArrayList(2);
        this.aCx = new String[2];
        this.aCy = new ImageListFragment();
        this.mFragments.add(this.aCy);
        this.aCx[0] = this.aCu;
        this.aCz = new AlbumImageBrowseFragment();
        this.mFragments.add(this.aCz);
        this.aCx[1] = this.aCv;
    }

    public Fragment cN(int i) {
        if (i < 0 || this.mFragments == null || i >= this.mFragments.size()) {
            return null;
        }
        return this.mFragments.get(i);
    }

    public String cO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aCx[i];
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

    public View Az() {
        if (this.aCy == null) {
            return null;
        }
        return this.aCy.AH();
    }

    public View AA() {
        if (this.aCy == null) {
            return null;
        }
        return this.aCy.AW();
    }

    public View AB() {
        if (this.aCz == null) {
            return null;
        }
        return this.aCz.AH();
    }

    public View AC() {
        if (this.aCz == null) {
            return null;
        }
        return this.aCz.AI();
    }

    public View AD() {
        if (this.aCz == null) {
            return null;
        }
        return this.aCz.AD();
    }

    public View AE() {
        if (this.aCy == null) {
            return null;
        }
        return this.aCy.AD();
    }

    public void onDestroy() {
    }

    public void bu(boolean z) {
        if (this.aCz != null) {
            this.aCz.bu(z);
        }
        if (this.aCy != null) {
            this.aCy.bu(z);
        }
    }
}
