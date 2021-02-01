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
    private RelativeLayout aYA;
    public HeadImageView aYw;
    public TextView aYx;
    public TextView aYy;
    private com.baidu.live.gift.a.c aYz;

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
        this.aYA = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.aYw = (HeadImageView) findViewById(a.f.sender_avatar);
        this.aYw.setIsRound(true);
        this.aYw.setAutoChangeStyle(false);
        this.aYw.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aYx = (TextView) findViewById(a.f.sender_name);
        this.aYy = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.FG();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.aYz != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aYz.userId), this.aYz.userName, this.aYz.portrait, this.aYz.sex, this.aYz.bcQ, this.aYz.location, this.aYz.description, 0L, this.aYz.fansCount, this.aYz.followCount, this.aYz.userStatus, this.aYz.liveId, this.aYz.groupId, this.aYz.bcW, this.aYz.bcX, this.aYz.appId, this.aYz.userName)));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aYz = cVar;
            if (cVar.portrait != null) {
                this.aYw.startLoad(cVar.portrait, 12, false);
            }
            gx(cVar.userName);
            if (cVar.bcO != null) {
                this.aYy.setText(cVar.bcO.DS());
            }
        }
    }

    private void gx(String str) {
        this.aYx.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aYx.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYA.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aYA.setLayoutParams(layoutParams);
        }
    }
}
