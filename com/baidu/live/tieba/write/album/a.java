package com.baidu.live.tieba.write.album;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class a extends BdBaseView<BaseActivity> {
    private AlbumActivity bvI;
    private String bvP;
    private String bvQ;
    private String[] bvR;
    private j bvS;
    private h bvT;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bvP = "tag_image";
        this.bvQ = "tag_b_image";
        this.bvI = albumActivity;
    }

    public void Qj() {
        this.bvR = new String[2];
        this.bvS = new j(this.bvI.getPageContext(), this.bvI);
        this.bvR[0] = this.bvP;
        this.bvT = new h(this.bvI.getPageContext(), this.bvI);
        this.bvR[1] = this.bvQ;
    }

    public void onChangeSkinType(int i) {
        this.bvS.onChangeSkinType(i);
        this.bvT.onChangeSkinType(i);
    }

    public View Qk() {
        if (this.bvS == null) {
            return null;
        }
        return this.bvS.QB();
    }

    public View Ql() {
        if (this.bvS == null) {
            return null;
        }
        return this.bvS.QF();
    }

    public View Qm() {
        if (this.bvT == null) {
            return null;
        }
        return this.bvT.QB();
    }

    public View Qn() {
        if (this.bvT == null) {
            return null;
        }
        return this.bvT.QC();
    }

    public View Qo() {
        if (this.bvT == null) {
            return null;
        }
        return this.bvT.Qo();
    }

    public View Qp() {
        if (this.bvS == null) {
            return null;
        }
        return this.bvS.Qo();
    }

    public void onDestroy() {
    }

    public h Qq() {
        return this.bvT;
    }

    public j Qr() {
        return this.bvS;
    }

    public void cD(boolean z) {
        if (this.bvT != null) {
            this.bvT.cD(z);
        }
        if (this.bvS != null) {
            this.bvS.cD(z);
        }
    }
}
