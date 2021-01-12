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
/* loaded from: classes10.dex */
public class a extends b {
    public AlphaGradientHListView bWO;
    public AlaGiftMicrophoneOpBtn bWP;
    private List<AlaWheatInfoData> bWQ;
    public c bWR;

    public a(Context context) {
        super(context);
        this.bWQ = new ArrayList();
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return new AlphaGradientHListView(this.mContext);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int Xu() {
        return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Xv() {
        this.bWO = (AlphaGradientHListView) this.contentView;
        this.bWO.setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.bWO.setNeedAlphaShade(true);
        this.bWO.setColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100), this.mContext.getResources().getColor(a.c.sdk_white_alpha0));
        this.bWO.setSelector(new ColorDrawable(0));
        this.bWR = new c(this.mContext);
        this.bWO.setAdapter((ListAdapter) this.bWR);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Xw() {
        this.bWP = (AlaGiftMicrophoneOpBtn) this.bWS.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
        this.bWP.setSelected(true);
    }

    public List<AlaWheatInfoData> getData() {
        this.bWQ.clear();
        if (this.bWR != null && this.bWR.getData() != null) {
            for (d dVar : this.bWR.getData()) {
                this.bWQ.add(dVar.bXr);
            }
        }
        return this.bWQ;
    }

    public void setData(List<d> list) {
        this.bWR.setData(list);
    }
}
