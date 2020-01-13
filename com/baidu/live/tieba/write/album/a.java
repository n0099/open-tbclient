package com.baidu.live.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends BdBaseView<BaseFragmentActivity> {
    private Fragment[] amb;
    private String axO;
    private String axP;
    private AlbumActivity axQ;
    private String[] axR;
    private ImageListFragment axS;
    private AlbumImageBrowseFragment axT;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.axO = "tag_image";
        this.axP = "tag_b_image";
        this.axQ = albumActivity;
    }

    public void xY() {
        this.amb = new Fragment[2];
        this.axR = new String[2];
        this.axS = new ImageListFragment();
        this.amb[0] = this.axS;
        this.axR[0] = this.axO;
        this.axT = new AlbumImageBrowseFragment();
        this.amb[1] = this.axT;
        this.axR[1] = this.axP;
    }

    public Fragment cx(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.amb[i];
    }

    public String cy(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.axR[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.amb.length) {
                if (this.amb[i3] != null && (this.amb[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.amb[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public View xZ() {
        if (this.axS == null) {
            return null;
        }
        return this.axS.yh();
    }

    public View ya() {
        if (this.axS == null) {
            return null;
        }
        return this.axS.yw();
    }

    public View yb() {
        if (this.axT == null) {
            return null;
        }
        return this.axT.yh();
    }

    public View yc() {
        if (this.axT == null) {
            return null;
        }
        return this.axT.yi();
    }

    public View yd() {
        if (this.axT == null) {
            return null;
        }
        return this.axT.yd();
    }

    public View ye() {
        if (this.axS == null) {
            return null;
        }
        return this.axS.yd();
    }

    public void onDestroy() {
    }

    public void bl(boolean z) {
        if (this.axT != null) {
            this.axT.bl(z);
        }
        if (this.axS != null) {
            this.axS.bl(z);
        }
    }
}
