package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.view.AlaLoadingButton;
import com.baidu.live.yuyingift.widget.panel.AlaGiftMicrophoneOpBtn;
/* loaded from: classes10.dex */
public class e extends b {
    public HeadImageView bWX;
    public TextView bWY;
    public AlaWheatInfoData bXs;
    public TextView bXt;
    public AlaLoadingButton bXu;
    public AlaGiftMicrophoneOpBtn bXv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int Xu() {
        return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Xv() {
        this.bWX = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
        this.bWY = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
        this.bXt = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
        this.bWX.setIsRound(true);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Xw() {
        this.bXu = (AlaLoadingButton) this.bWS.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
        this.bXv = (AlaGiftMicrophoneOpBtn) this.bWS.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
        this.bXu.setSelected(true);
        this.bXv.setSelected(false);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.bXr != null) {
            this.bXs = dVar.bXr;
            this.bWX.startLoad(dVar.bXr.portrait, 12, true);
            this.bWY.setText(dVar.posName);
            this.bXt.setText(dVar.bXr.userName);
        }
    }

    public void dF(boolean z) {
        this.bXv.setVisibility(z ? 0 : 8);
    }

    public void dG(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bXv.getLayoutParams();
        if (!z) {
            layoutParams.leftMargin = 0;
            this.bXu.setVisibility(8);
        } else {
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds20);
            this.bXu.setStatus(1);
            this.bXu.setVisibility(0);
        }
        this.bXv.setLayoutParams(layoutParams);
    }
}
