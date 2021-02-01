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
    public HeadImageView caZ;
    public TextView cba;
    public AlaWheatInfoData cbv;
    public TextView cbw;
    public AlaLoadingButton cbx;
    public AlaGiftMicrophoneOpBtn cby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected View getContentView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    protected int Zk() {
        return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zl() {
        this.caZ = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
        this.cba = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
        this.cbw = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
        this.caZ.setIsRound(true);
    }

    @Override // com.baidu.live.yuyingift.widget.wheatlist.b
    void Zm() {
        this.cbx = (AlaLoadingButton) this.caU.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
        this.cby = (AlaGiftMicrophoneOpBtn) this.caU.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
        this.cbx.setSelected(true);
        this.cby.setSelected(false);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.cbu != null) {
            this.cbv = dVar.cbu;
            this.caZ.startLoad(dVar.cbu.portrait, 12, true);
            this.cba.setText(dVar.posName);
            this.cbw.setText(dVar.cbu.userName);
        }
    }

    public void dN(boolean z) {
        this.cby.setVisibility(z ? 0 : 8);
    }

    public void dO(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
        if (!z) {
            layoutParams.leftMargin = 0;
            this.cbx.setVisibility(8);
        } else {
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds20);
            this.cbx.setStatus(1);
            this.cbx.setVisibility(0);
        }
        this.cby.setLayoutParams(layoutParams);
    }
}
