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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView afF;
    public TextView afG;
    public TextView afH;
    private com.baidu.live.gift.a.c afI;
    private RelativeLayout afJ;

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
        this.afJ = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.afF = (HeadImageView) findViewById(a.g.sender_avatar);
        this.afF.setIsRound(true);
        this.afF.setAutoChangeStyle(false);
        this.afF.setDefaultBgResource(a.f.sdk_default_avatar);
        this.afG = (TextView) findViewById(a.g.sender_name);
        this.afH = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.rH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH() {
        if (this.afI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.afI.userId), this.afI.userName, this.afI.portrait, this.afI.sex, this.afI.ajq, this.afI.location, this.afI.description, 0L, this.afI.fansCount, this.afI.ajr, this.afI.userStatus, this.afI.liveId, this.afI.groupId, this.afI.aju, this.afI.ajv, this.afI.appId, this.afI.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.afI = cVar;
            if (cVar.portrait != null) {
                this.afF.startLoad(cVar.portrait, 12, false);
            }
            dj(cVar.userName);
            if (cVar.ajo != null) {
                this.afH.setText(cVar.ajo.qF());
            }
        }
    }

    private void dj(String str) {
        this.afG.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.afG.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afJ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.afJ.setLayoutParams(layoutParams);
        }
    }
}
