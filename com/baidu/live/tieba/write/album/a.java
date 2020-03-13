package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private String aCg;
    private String aCh;
    private AlbumActivity aCi;
    private String[] aCj;
    private ImageListFragment aCk;
    private AlbumImageBrowseFragment aCl;
    private List<Fragment> mFragments;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCg = "tag_image";
        this.aCh = "tag_b_image";
        this.aCi = albumActivity;
    }

    public void Ar() {
        this.mFragments = new ArrayList(2);
        this.aCj = new String[2];
        this.aCk = new ImageListFragment();
        this.mFragments.add(this.aCk);
        this.aCj[0] = this.aCg;
        this.aCl = new AlbumImageBrowseFragment();
        this.mFragments.add(this.aCl);
        this.aCj[1] = this.aCh;
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
        return this.aCj[i];
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

    public View As() {
        if (this.aCk == null) {
            return null;
        }
        return this.aCk.AA();
    }

    public View At() {
        if (this.aCk == null) {
            return null;
        }
        return this.aCk.AP();
    }

    public View Au() {
        if (this.aCl == null) {
            return null;
        }
        return this.aCl.AA();
    }

    public View Av() {
        if (this.aCl == null) {
            return null;
        }
        return this.aCl.AB();
    }

    public View Aw() {
        if (this.aCl == null) {
            return null;
        }
        return this.aCl.Aw();
    }

    public View Ax() {
        if (this.aCk == null) {
            return null;
        }
        return this.aCk.Aw();
    }

    public void onDestroy() {
    }

    public void bt(boolean z) {
        if (this.aCl != null) {
            this.aCl.bt(z);
        }
        if (this.aCk != null) {
            this.aCk.bt(z);
        }
    }
}
