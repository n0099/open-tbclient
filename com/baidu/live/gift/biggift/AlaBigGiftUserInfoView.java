package com.baidu.live.gift.biggift;

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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes7.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aOT;
    public TextView aOU;
    public TextView aOV;
    private com.baidu.live.gift.a.c aOW;
    private RelativeLayout aOX;

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
        this.aOX = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aOT = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aOT.setIsRound(true);
        this.aOT.setAutoChangeStyle(false);
        this.aOT.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aOU = (TextView) findViewById(a.g.sender_name);
        this.aOV = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.Fi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi() {
        if (this.aOW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOW.userId), this.aOW.userName, this.aOW.portrait, this.aOW.sex, this.aOW.aSS, this.aOW.location, this.aOW.description, 0L, this.aOW.fansCount, this.aOW.aST, this.aOW.userStatus, this.aOW.liveId, this.aOW.groupId, this.aOW.aSW, this.aOW.aSX, this.aOW.appId, this.aOW.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aOW = cVar;
            if (cVar.portrait != null) {
                this.aOT.startLoad(cVar.portrait, 12, false);
            }
            gu(cVar.userName);
            if (cVar.aSQ != null) {
                this.aOV.setText(cVar.aSQ.DS());
            }
        }
    }

    private void gu(String str) {
        this.aOU.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aOU.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aOX.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aOX.setLayoutParams(layoutParams);
        }
    }
}
