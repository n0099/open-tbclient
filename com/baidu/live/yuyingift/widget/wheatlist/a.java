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
    public AlphaGradientHListView caQ;
    public AlaGiftMicrophoneOpBtn caR;
    private List<AlaWheatInfoData> caS;
    public c caT;

    public a(Context context) {
        super(context);
        this.caS = new ArrayList();
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return new AlphaGradientHListView(this.mContext);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int Zk() {
        return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zl() {
        this.caQ = (AlphaGradientHListView) this.contentView;
        this.caQ.setShadowWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.caQ.setNeedAlphaShade(true);
        this.caQ.setColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100), this.mContext.getResources().getColor(a.c.sdk_white_alpha0));
        this.caQ.setSelector(new ColorDrawable(0));
        this.caT = new c(this.mContext);
        this.caQ.setAdapter((ListAdapter) this.caT);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zm() {
        this.caR = (AlaGiftMicrophoneOpBtn) this.caU.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
        this.caR.setSelected(true);
    }

    public List<AlaWheatInfoData> getData() {
        this.caS.clear();
        if (this.caT != null && this.caT.getData() != null) {
            for (d dVar : this.caT.getData()) {
                this.caS.add(dVar.cbu);
            }
        }
        return this.caS;
    }

    public void setData(List<d> list) {
        this.caT.setData(list);
    }
}
