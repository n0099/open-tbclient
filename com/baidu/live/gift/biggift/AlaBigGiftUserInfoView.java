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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView ahX;
    public TextView ahY;
    public TextView ahZ;
    private com.baidu.live.gift.a.c aia;
    private RelativeLayout aib;

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
        this.aib = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.ahX = (HeadImageView) findViewById(a.g.sender_avatar);
        this.ahX.setIsRound(true);
        this.ahX.setAutoChangeStyle(false);
        this.ahX.setDefaultBgResource(a.f.sdk_default_avatar);
        this.ahY = (TextView) findViewById(a.g.sender_name);
        this.ahZ = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.sX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sX() {
        if (this.aia != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aia.userId), this.aia.userName, this.aia.portrait, this.aia.sex, this.aia.alJ, this.aia.location, this.aia.description, 0L, this.aia.fansCount, this.aia.alK, this.aia.userStatus, this.aia.liveId, this.aia.groupId, this.aia.alN, this.aia.alO, this.aia.appId, this.aia.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aia = cVar;
            if (cVar.portrait != null) {
                this.ahX.startLoad(cVar.portrait, 12, false);
            }
            dt(cVar.userName);
            if (cVar.alH != null) {
                this.ahZ.setText(cVar.alH.rD());
            }
        }
    }

    private void dt(String str) {
        this.ahY.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.ahY.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aib.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aib.setLayoutParams(layoutParams);
        }
    }
}
