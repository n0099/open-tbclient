package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes3.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity biJ;
    private String biQ;
    private String biR;
    private String[] biS;
    private j biT;
    private h biU;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.biQ = "tag_image";
        this.biR = "tag_b_image";
        this.biJ = albumActivity;
    }

    public void IC() {
        this.biS = new String[2];
        this.biT = new j(this.biJ.getPageContext(), this.biJ);
        this.biS[0] = this.biQ;
        this.biU = new h(this.biJ.getPageContext(), this.biJ);
        this.biS[1] = this.biR;
    }

    public void onChangeSkinType(int i) {
        this.biT.onChangeSkinType(i);
        this.biU.onChangeSkinType(i);
    }

    public View ID() {
        if (this.biT == null) {
            return null;
        }
        return this.biT.IV();
    }

    public View IE() {
        if (this.biT == null) {
            return null;
        }
        return this.biT.IZ();
    }

    public View IF() {
        if (this.biU == null) {
            return null;
        }
        return this.biU.IV();
    }

    public View IG() {
        if (this.biU == null) {
            return null;
        }
        return this.biU.IW();
    }

    public View IH() {
        if (this.biU == null) {
            return null;
        }
        return this.biU.IH();
    }

    public View II() {
        if (this.biT == null) {
            return null;
        }
        return this.biT.IH();
    }

    public void onDestroy() {
    }

    public h IJ() {
        return this.biU;
    }

    public j IK() {
        return this.biT;
    }

    public void cn(boolean z) {
        if (this.biU != null) {
            this.biU.cn(z);
        }
        if (this.biT != null) {
            this.biT.cn(z);
        }
    }
}
