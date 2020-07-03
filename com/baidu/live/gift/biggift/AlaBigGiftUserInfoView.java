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
/* loaded from: classes3.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aIm;
    public TextView aIn;
    public TextView aIo;
    private com.baidu.live.gift.a.c aIp;
    private RelativeLayout aIq;

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
        this.aIq = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aIm = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aIm.setIsRound(true);
        this.aIm.setAutoChangeStyle(false);
        this.aIm.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aIn = (TextView) findViewById(a.g.sender_name);
        this.aIo = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.zd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd() {
        if (this.aIp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aIp.userId), this.aIp.userName, this.aIp.portrait, this.aIp.sex, this.aIp.aMk, this.aIp.location, this.aIp.description, 0L, this.aIp.fansCount, this.aIp.aMl, this.aIp.userStatus, this.aIp.liveId, this.aIp.groupId, this.aIp.aMo, this.aIp.aMp, this.aIp.appId, this.aIp.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aIp = cVar;
            if (cVar.portrait != null) {
                this.aIm.startLoad(cVar.portrait, 12, false);
            }
            fa(cVar.userName);
            if (cVar.aMi != null) {
                this.aIo.setText(cVar.aMi.xN());
            }
        }
    }

    private void fa(String str) {
        this.aIn.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aIn.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIq.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aIq.setLayoutParams(layoutParams);
        }
    }
}
