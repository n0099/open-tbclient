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
/* loaded from: classes11.dex */
public class e extends b {
    public HeadImageView cbK;
    public TextView cbL;
    public AlaWheatInfoData ccf;
    public TextView ccg;
    public AlaLoadingButton cch;
    public AlaGiftMicrophoneOpBtn cci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int abn() {
        return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void abo() {
        this.cbK = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
        this.cbL = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
        this.ccg = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
        this.cbK.setIsRound(true);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void abp() {
        this.cch = (AlaLoadingButton) this.cbF.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
        this.cci = (AlaGiftMicrophoneOpBtn) this.cbF.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
        this.cch.setSelected(true);
        this.cci.setSelected(false);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.cce != null) {
            this.ccf = dVar.cce;
            this.cbK.startLoad(dVar.cce.portrait, 12, true);
            this.cbL.setText(dVar.posName);
            this.ccg.setText(dVar.cce.userName);
        }
    }

    public void dJ(boolean z) {
        this.cci.setVisibility(z ? 0 : 8);
    }

    public void dK(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cci.getLayoutParams();
        if (!z) {
            layoutParams.leftMargin = 0;
            this.cch.setVisibility(8);
        } else {
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds20);
            this.cch.setStatus(1);
            this.cch.setVisibility(0);
        }
        this.cci.setLayoutParams(layoutParams);
    }
}
