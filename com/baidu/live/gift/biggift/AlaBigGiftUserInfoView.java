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
    private com.baidu.live.gift.a.c aAA;
    private RelativeLayout aAB;
    public HeadImageView aAx;
    public TextView aAy;
    public TextView aAz;

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
        this.aAB = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aAx = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aAx.setIsRound(true);
        this.aAx.setAutoChangeStyle(false);
        this.aAx.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aAy = (TextView) findViewById(a.g.sender_name);
        this.aAz = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.xp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp() {
        if (this.aAA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aAA.userId), this.aAA.userName, this.aAA.portrait, this.aAA.sex, this.aAA.aEf, this.aAA.location, this.aAA.description, 0L, this.aAA.fansCount, this.aAA.aEg, this.aAA.userStatus, this.aAA.liveId, this.aAA.groupId, this.aAA.aEj, this.aAA.aEk, this.aAA.appId, this.aAA.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aAA = cVar;
            if (cVar.portrait != null) {
                this.aAx.startLoad(cVar.portrait, 12, false);
            }
            ek(cVar.userName);
            if (cVar.aEd != null) {
                this.aAz.setText(cVar.aEd.vV());
            }
        }
    }

    private void ek(String str) {
        this.aAy.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aAy.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAB.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aAB.setLayoutParams(layoutParams);
        }
    }
}
