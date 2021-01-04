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
/* loaded from: classes11.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView bab;
    public TextView bac;
    public TextView bad;
    private com.baidu.live.gift.a.c bae;
    private RelativeLayout baf;

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
        LayoutInflater.from(getContext()).inflate(a.g.popup_user_info_layout, this);
        this.baf = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.bab = (HeadImageView) findViewById(a.f.sender_avatar);
        this.bab.setIsRound(true);
        this.bab.setAutoChangeStyle(false);
        this.bab.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bac = (TextView) findViewById(a.f.sender_name);
        this.bad = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.Il();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        if (this.bae != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bae.userId), this.bae.userName, this.bae.portrait, this.bae.sex, this.bae.bez, this.bae.location, this.bae.description, 0L, this.bae.fansCount, this.bae.followCount, this.bae.userStatus, this.bae.liveId, this.bae.groupId, this.bae.beF, this.bae.beG, this.bae.appId, this.bae.userName)));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.bae = cVar;
            if (cVar.portrait != null) {
                this.bab.startLoad(cVar.portrait, 12, false);
            }
            hl(cVar.userName);
            if (cVar.bex != null) {
                this.bad.setText(cVar.bex.Gy());
            }
        }
    }

    private void hl(String str) {
        this.bac.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.bac.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baf.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.baf.setLayoutParams(layoutParams);
        }
    }
}
