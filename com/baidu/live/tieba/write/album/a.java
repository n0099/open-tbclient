package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private String bCD;
    private String bCE;
    private String[] bCF;
    private j bCG;
    private h bCH;
    private AlbumActivity bCw;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bCD = "tag_image";
        this.bCE = "tag_b_image";
        this.bCw = albumActivity;
    }

    public void Td() {
        this.bCF = new String[2];
        this.bCG = new j(this.bCw.getPageContext(), this.bCw);
        this.bCF[0] = this.bCD;
        this.bCH = new h(this.bCw.getPageContext(), this.bCw);
        this.bCF[1] = this.bCE;
    }

    public void onChangeSkinType(int i) {
        this.bCG.onChangeSkinType(i);
        this.bCH.onChangeSkinType(i);
    }

    public View Te() {
        if (this.bCG == null) {
            return null;
        }
        return this.bCG.Tv();
    }

    public View Tf() {
        if (this.bCG == null) {
            return null;
        }
        return this.bCG.Tz();
    }

    public View Tg() {
        if (this.bCH == null) {
            return null;
        }
        return this.bCH.Tv();
    }

    public View Th() {
        if (this.bCH == null) {
            return null;
        }
        return this.bCH.Tw();
    }

    public View Ti() {
        if (this.bCH == null) {
            return null;
        }
        return this.bCH.Ti();
    }

    public View Tj() {
        if (this.bCG == null) {
            return null;
        }
        return this.bCG.Ti();
    }

    public void onDestroy() {
    }

    public h Tk() {
        return this.bCH;
    }

    public j Tl() {
        return this.bCG;
    }

    public void cS(boolean z) {
        if (this.bCH != null) {
            this.bCH.cS(z);
        }
        if (this.bCG != null) {
            this.bCG.cS(z);
        }
    }
}
