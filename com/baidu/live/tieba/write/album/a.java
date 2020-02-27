package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private String aCe;
    private String aCf;
    private AlbumActivity aCg;
    private String[] aCh;
    private ImageListFragment aCi;
    private AlbumImageBrowseFragment aCj;
    private List<Fragment> mFragments;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCe = "tag_image";
        this.aCf = "tag_b_image";
        this.aCg = albumActivity;
    }

    public void Ap() {
        this.mFragments = new ArrayList(2);
        this.aCh = new String[2];
        this.aCi = new ImageListFragment();
        this.mFragments.add(this.aCi);
        this.aCh[0] = this.aCe;
        this.aCj = new AlbumImageBrowseFragment();
        this.mFragments.add(this.aCj);
        this.aCh[1] = this.aCf;
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
        return this.aCh[i];
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

    public View Aq() {
        if (this.aCi == null) {
            return null;
        }
        return this.aCi.Ay();
    }

    public View Ar() {
        if (this.aCi == null) {
            return null;
        }
        return this.aCi.AN();
    }

    public View As() {
        if (this.aCj == null) {
            return null;
        }
        return this.aCj.Ay();
    }

    public View At() {
        if (this.aCj == null) {
            return null;
        }
        return this.aCj.Az();
    }

    public View Au() {
        if (this.aCj == null) {
            return null;
        }
        return this.aCj.Au();
    }

    public View Av() {
        if (this.aCi == null) {
            return null;
        }
        return this.aCi.Au();
    }

    public void onDestroy() {
    }

    public void bt(boolean z) {
        if (this.aCj != null) {
            this.aCj.bt(z);
        }
        if (this.aCi != null) {
            this.aCi.bt(z);
        }
    }
}
