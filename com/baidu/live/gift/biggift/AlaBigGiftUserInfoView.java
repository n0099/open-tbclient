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
    public HeadImageView aAr;
    public TextView aAs;
    public TextView aAt;
    private com.baidu.live.gift.a.c aAu;
    private RelativeLayout aAv;

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
        this.aAv = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aAr = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aAr.setIsRound(true);
        this.aAr.setAutoChangeStyle(false);
        this.aAr.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aAs = (TextView) findViewById(a.g.sender_name);
        this.aAt = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.xq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq() {
        if (this.aAu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aAu.userId), this.aAu.userName, this.aAu.portrait, this.aAu.sex, this.aAu.aDZ, this.aAu.location, this.aAu.description, 0L, this.aAu.fansCount, this.aAu.aEa, this.aAu.userStatus, this.aAu.liveId, this.aAu.groupId, this.aAu.aEd, this.aAu.aEe, this.aAu.appId, this.aAu.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aAu = cVar;
            if (cVar.portrait != null) {
                this.aAr.startLoad(cVar.portrait, 12, false);
            }
            ek(cVar.userName);
            if (cVar.aDX != null) {
                this.aAt.setText(cVar.aDX.vW());
            }
        }
    }

    private void ek(String str) {
        this.aAs.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aAs.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAv.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aAv.setLayoutParams(layoutParams);
        }
    }
}
