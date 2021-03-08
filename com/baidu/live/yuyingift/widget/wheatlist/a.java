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
    public AlphaGradientHListView ccr;
    public AlaGiftMicrophoneOpBtn cct;
    private List<AlaWheatInfoData> ccu;
    public c ccv;

    public a(Context context) {
        super(context);
        this.ccu = new ArrayList();
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return new AlphaGradientHListView(this.mContext);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int Zn() {
        return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zo() {
        this.ccr = (AlphaGradientHListView) this.contentView;
        this.ccr.setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.ccr.setNeedAlphaShade(true);
        this.ccr.setColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100), this.mContext.getResources().getColor(a.c.sdk_white_alpha0));
        this.ccr.setSelector(new ColorDrawable(0));
        this.ccv = new c(this.mContext);
        this.ccr.setAdapter((ListAdapter) this.ccv);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zp() {
        this.cct = (AlaGiftMicrophoneOpBtn) this.ccw.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
        this.cct.setSelected(true);
    }

    public List<AlaWheatInfoData> getData() {
        this.ccu.clear();
        if (this.ccv != null && this.ccv.getData() != null) {
            for (d dVar : this.ccv.getData()) {
                this.ccu.add(dVar.ccV);
            }
        }
        return this.ccu;
    }

    public void setData(List<d> list) {
        this.ccv.setData(list);
    }
}
