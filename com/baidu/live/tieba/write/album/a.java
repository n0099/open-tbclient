package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private Fragment[] adq;
    private String apn;
    private String apo;
    private AlbumActivity apq;
    private String[] apr;
    private ImageListFragment aps;
    private AlbumImageBrowseFragment apt;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.apn = "tag_image";
        this.apo = "tag_b_image";
        this.apq = albumActivity;
    }

    public void vK() {
        this.adq = new Fragment[2];
        this.apr = new String[2];
        this.aps = new ImageListFragment();
        this.adq[0] = this.aps;
        this.apr[0] = this.apn;
        this.apt = new AlbumImageBrowseFragment();
        this.adq[1] = this.apt;
        this.apr[1] = this.apo;
    }

    public Fragment ce(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.adq[i];
    }

    public String cf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.apr[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.adq.length) {
                if (this.adq[i3] != null && (this.adq[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.adq[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public View vL() {
        if (this.aps == null) {
            return null;
        }
        return this.aps.vT();
    }

    public View vM() {
        if (this.aps == null) {
            return null;
        }
        return this.aps.wi();
    }

    public View vN() {
        if (this.apt == null) {
            return null;
        }
        return this.apt.vT();
    }

    public View vO() {
        if (this.apt == null) {
            return null;
        }
        return this.apt.vU();
    }

    public View vP() {
        if (this.apt == null) {
            return null;
        }
        return this.apt.vP();
    }

    public View vQ() {
        if (this.aps == null) {
            return null;
        }
        return this.aps.vP();
    }

    public void onDestroy() {
    }

    public void aQ(boolean z) {
        if (this.apt != null) {
            this.apt.aQ(z);
        }
        if (this.aps != null) {
            this.aps.aQ(z);
        }
    }
}
