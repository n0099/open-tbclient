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
    public HeadImageView aOV;
    public TextView aOW;
    public TextView aOX;
    private com.baidu.live.gift.a.c aOY;
    private RelativeLayout aOZ;

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
        this.aOZ = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aOV = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aOV.setIsRound(true);
        this.aOV.setAutoChangeStyle(false);
        this.aOV.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aOW = (TextView) findViewById(a.g.sender_name);
        this.aOX = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.Fi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi() {
        if (this.aOY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOY.userId), this.aOY.userName, this.aOY.portrait, this.aOY.sex, this.aOY.aSU, this.aOY.location, this.aOY.description, 0L, this.aOY.fansCount, this.aOY.aSV, this.aOY.userStatus, this.aOY.liveId, this.aOY.groupId, this.aOY.aSY, this.aOY.aSZ, this.aOY.appId, this.aOY.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aOY = cVar;
            if (cVar.portrait != null) {
                this.aOV.startLoad(cVar.portrait, 12, false);
            }
            gv(cVar.userName);
            if (cVar.aSS != null) {
                this.aOX.setText(cVar.aSS.DS());
            }
        }
    }

    private void gv(String str) {
        this.aOW.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aOW.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aOZ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aOZ.setLayoutParams(layoutParams);
        }
    }
}
