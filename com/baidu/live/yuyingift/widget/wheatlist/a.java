package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.live.yuyingift.widget.panel.AlaGiftMicrophoneOpBtn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends b {
    public AlphaGradientHListView cbB;
    public AlaGiftMicrophoneOpBtn cbC;
    private List<AlaWheatInfoData> cbD;
    public c cbE;

    public a(Context context) {
        super(context);
        this.cbD = new ArrayList();
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return new AlphaGradientHListView(this.mContext);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int abn() {
        return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void abo() {
        this.cbB = (AlphaGradientHListView) this.contentView;
        this.cbB.setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.cbB.setNeedAlphaShade(true);
        this.cbB.setColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100), this.mContext.getResources().getColor(a.c.sdk_white_alpha0));
        this.cbB.setSelector(new ColorDrawable(0));
        this.cbE = new c(this.mContext);
        this.cbB.setAdapter((ListAdapter) this.cbE);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void abp() {
        this.cbC = (AlaGiftMicrophoneOpBtn) this.cbF.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
        this.cbC.setSelected(true);
    }

    public List<AlaWheatInfoData> getData() {
        this.cbD.clear();
        if (this.cbE != null && this.cbE.getData() != null) {
            for (d dVar : this.cbE.getData()) {
                this.cbD.add(dVar.cce);
            }
        }
        return this.cbD;
    }

    public void setData(List<d> list) {
        this.cbE.setData(list);
    }
}
