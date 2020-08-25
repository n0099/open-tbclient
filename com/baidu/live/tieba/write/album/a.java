package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes7.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity boI;
    private String boP;
    private String boQ;
    private String[] boR;
    private j boS;
    private h boT;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.boP = "tag_image";
        this.boQ = "tag_b_image";
        this.boI = albumActivity;
    }

    public void OB() {
        this.boR = new String[2];
        this.boS = new j(this.boI.getPageContext(), this.boI);
        this.boR[0] = this.boP;
        this.boT = new h(this.boI.getPageContext(), this.boI);
        this.boR[1] = this.boQ;
    }

    public void onChangeSkinType(int i) {
        this.boS.onChangeSkinType(i);
        this.boT.onChangeSkinType(i);
    }

    public View OC() {
        if (this.boS == null) {
            return null;
        }
        return this.boS.OT();
    }

    public View OD() {
        if (this.boS == null) {
            return null;
        }
        return this.boS.OX();
    }

    public View OE() {
        if (this.boT == null) {
            return null;
        }
        return this.boT.OT();
    }

    public View OF() {
        if (this.boT == null) {
            return null;
        }
        return this.boT.OU();
    }

    public View OG() {
        if (this.boT == null) {
            return null;
        }
        return this.boT.OG();
    }

    public View OH() {
        if (this.boS == null) {
            return null;
        }
        return this.boS.OG();
    }

    public void onDestroy() {
    }

    public h OI() {
        return this.boT;
    }

    public j OJ() {
        return this.boS;
    }

    public void cy(boolean z) {
        if (this.boT != null) {
            this.boT.cy(z);
        }
        if (this.boS != null) {
            this.boS.cy(z);
        }
    }
}
