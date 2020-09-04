package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes7.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity boL;
    private String boS;
    private String boT;
    private String[] boU;
    private j boV;
    private h boW;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.boS = "tag_image";
        this.boT = "tag_b_image";
        this.boL = albumActivity;
    }

    public void OB() {
        this.boU = new String[2];
        this.boV = new j(this.boL.getPageContext(), this.boL);
        this.boU[0] = this.boS;
        this.boW = new h(this.boL.getPageContext(), this.boL);
        this.boU[1] = this.boT;
    }

    public void onChangeSkinType(int i) {
        this.boV.onChangeSkinType(i);
        this.boW.onChangeSkinType(i);
    }

    public View OC() {
        if (this.boV == null) {
            return null;
        }
        return this.boV.OT();
    }

    public View OD() {
        if (this.boV == null) {
            return null;
        }
        return this.boV.OX();
    }

    public View OE() {
        if (this.boW == null) {
            return null;
        }
        return this.boW.OT();
    }

    public View OF() {
        if (this.boW == null) {
            return null;
        }
        return this.boW.OU();
    }

    public View OG() {
        if (this.boW == null) {
            return null;
        }
        return this.boW.OG();
    }

    public View OH() {
        if (this.boV == null) {
            return null;
        }
        return this.boV.OG();
    }

    public void onDestroy() {
    }

    public h OI() {
        return this.boW;
    }

    public j OJ() {
        return this.boV;
    }

    public void cz(boolean z) {
        if (this.boW != null) {
            this.boW.cz(z);
        }
        if (this.boV != null) {
            this.boV.cz(z);
        }
    }
}
