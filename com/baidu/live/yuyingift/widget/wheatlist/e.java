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
    public HeadImageView ccB;
    public TextView ccC;
    public AlaWheatInfoData ccW;
    public TextView ccX;
    public AlaLoadingButton ccY;
    public AlaGiftMicrophoneOpBtn ccZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int Zn() {
        return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zo() {
        this.ccB = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
        this.ccC = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
        this.ccX = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
        this.ccB.setIsRound(true);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zp() {
        this.ccY = (AlaLoadingButton) this.ccw.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
        this.ccZ = (AlaGiftMicrophoneOpBtn) this.ccw.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
        this.ccY.setSelected(true);
        this.ccZ.setSelected(false);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.ccV != null) {
            this.ccW = dVar.ccV;
            this.ccB.startLoad(dVar.ccV.portrait, 12, true);
            this.ccC.setText(dVar.posName);
            this.ccX.setText(dVar.ccV.userName);
        }
    }

    public void dN(boolean z) {
        this.ccZ.setVisibility(z ? 0 : 8);
    }

    public void dO(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ccZ.getLayoutParams();
        if (!z) {
            layoutParams.leftMargin = 0;
            this.ccY.setVisibility(8);
        } else {
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds20);
            this.ccY.setStatus(1);
            this.ccY.setVisibility(0);
        }
        this.ccZ.setLayoutParams(layoutParams);
    }
}
