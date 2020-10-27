package com.baidu.live.yuyingift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aVD;
    public TextView aVE;
    public TextView aVF;
    private RelativeLayout aVH;
    private com.baidu.live.yuyingift.a.c bJW;

    public AlaBigGiftUserInfoView(Context context) {
        super(context);
        init(context);
    }

    public AlaBigGiftUserInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaBigGiftUserInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(a.h.popup_user_info_layout, this);
        this.aVH = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aVD = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aVD.setIsRound(true);
        this.aVD.setAutoChangeStyle(false);
        this.aVD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aVE = (TextView) findViewById(a.g.sender_name);
        this.aVF = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.Ha();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (this.bJW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bJW.userId), this.bJW.userName, this.bJW.portrait, this.bJW.sex, this.bJW.aZL, this.bJW.location, this.bJW.description, 0L, this.bJW.fansCount, this.bJW.aZM, this.bJW.userStatus, this.bJW.liveId, this.bJW.groupId, this.bJW.aZR, this.bJW.aZS, this.bJW.appId, this.bJW.userName, "")));
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bJW = cVar;
            if (cVar.portrait != null) {
                this.aVD.startLoad(cVar.portrait, 12, false);
            }
            he(cVar.userName);
            if (cVar.aZJ != null) {
                this.aVF.setText(cVar.aZJ.Ft());
            }
        }
    }

    private void he(String str) {
        this.aVE.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aVE.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aVH.setLayoutParams(layoutParams);
        }
    }
}
