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
    public HeadImageView aUi;
    public TextView aUj;
    public TextView aUk;
    private com.baidu.live.gift.a.c aUl;
    private RelativeLayout aUm;

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
        this.aUm = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aUi = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aUi.setIsRound(true);
        this.aUi.setAutoChangeStyle(false);
        this.aUi.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aUj = (TextView) findViewById(a.g.sender_name);
        this.aUk = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.GE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        if (this.aUl != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aUl.userId), this.aUl.userName, this.aUl.portrait, this.aUl.sex, this.aUl.aYq, this.aUl.location, this.aUl.description, 0L, this.aUl.fansCount, this.aUl.aYr, this.aUl.userStatus, this.aUl.liveId, this.aUl.groupId, this.aUl.aYv, this.aUl.aYw, this.aUl.appId, this.aUl.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aUl = cVar;
            if (cVar.portrait != null) {
                this.aUi.startLoad(cVar.portrait, 12, false);
            }
            gT(cVar.userName);
            if (cVar.aYo != null) {
                this.aUk.setText(cVar.aYo.Fe());
            }
        }
    }

    private void gT(String str) {
        this.aUj.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aUj.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aUm.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aUm.setLayoutParams(layoutParams);
        }
    }
}
