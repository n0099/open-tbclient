package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private String aCf;
    private String aCg;
    private AlbumActivity aCh;
    private String[] aCi;
    private ImageListFragment aCj;
    private AlbumImageBrowseFragment aCk;
    private List<Fragment> mFragments;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCf = "tag_image";
        this.aCg = "tag_b_image";
        this.aCh = albumActivity;
    }

    public void Ar() {
        this.mFragments = new ArrayList(2);
        this.aCi = new String[2];
        this.aCj = new ImageListFragment();
        this.mFragments.add(this.aCj);
        this.aCi[0] = this.aCf;
        this.aCk = new AlbumImageBrowseFragment();
        this.mFragments.add(this.aCk);
        this.aCi[1] = this.aCg;
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
        return this.aCi[i];
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
        if (this.aCj == null) {
            return null;
        }
        return this.aCj.AA();
    }

    public View At() {
        if (this.aCj == null) {
            return null;
        }
        return this.aCj.AP();
    }

    public View Au() {
        if (this.aCk == null) {
            return null;
        }
        return this.aCk.AA();
    }

    public View Av() {
        if (this.aCk == null) {
            return null;
        }
        return this.aCk.AB();
    }

    public View Aw() {
        if (this.aCk == null) {
            return null;
        }
        return this.aCk.Aw();
    }

    public View Ax() {
        if (this.aCj == null) {
            return null;
        }
        return this.aCj.Aw();
    }

    public void onDestroy() {
    }

    public void bt(boolean z) {
        if (this.aCk != null) {
            this.aCk.bt(z);
        }
        if (this.aCj != null) {
            this.aCj.bt(z);
        }
    }
}
