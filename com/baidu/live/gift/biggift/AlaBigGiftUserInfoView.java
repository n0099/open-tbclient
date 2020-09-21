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
/* loaded from: classes4.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aQX;
    public TextView aQY;
    public TextView aQZ;
    private com.baidu.live.gift.a.c aRa;
    private RelativeLayout aRb;

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
        this.aRb = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aQX = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aQX.setIsRound(true);
        this.aQX.setAutoChangeStyle(false);
        this.aQX.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aQY = (TextView) findViewById(a.g.sender_name);
        this.aQZ = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.FI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FI() {
        if (this.aRa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aRa.userId), this.aRa.userName, this.aRa.portrait, this.aRa.sex, this.aRa.aVf, this.aRa.location, this.aRa.description, 0L, this.aRa.fansCount, this.aRa.aVg, this.aRa.userStatus, this.aRa.liveId, this.aRa.groupId, this.aRa.aVk, this.aRa.aVl, this.aRa.appId, this.aRa.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aRa = cVar;
            if (cVar.portrait != null) {
                this.aQX.startLoad(cVar.portrait, 12, false);
            }
            gF(cVar.userName);
            if (cVar.aVd != null) {
                this.aQZ.setText(cVar.aVd.Ei());
            }
        }
    }

    private void gF(String str) {
        this.aQY.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aQY.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aRb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aRb.setLayoutParams(layoutParams);
        }
    }
}
