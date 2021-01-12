package com.baidu.live.yuyingift.biggift;

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
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aVo;
    public TextView aVp;
    public TextView aVq;
    private RelativeLayout aVs;
    private com.baidu.live.yuyingift.a.c bTW;

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
        this.aVs = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.aVo = (HeadImageView) findViewById(a.f.sender_avatar);
        this.aVo.setIsRound(true);
        this.aVo.setAutoChangeStyle(false);
        this.aVo.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aVp = (TextView) findViewById(a.f.sender_name);
        this.aVq = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.Eq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        if (this.bTW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bTW.userId), this.bTW.userName, this.bTW.portrait, this.bTW.sex, this.bTW.aZJ, this.bTW.location, this.bTW.description, 0L, this.bTW.fansCount, this.bTW.followCount, this.bTW.userStatus, this.bTW.liveId, this.bTW.groupId, this.bTW.aZP, this.bTW.aZQ, this.bTW.appId, this.bTW.userName, "")));
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bTW = cVar;
            if (cVar.portrait != null) {
                this.aVo.startLoad(cVar.portrait, 12, false);
            }
            fZ(cVar.userName);
            if (cVar.aZH != null) {
                this.aVq.setText(cVar.aZH.CD());
            }
        }
    }

    private void fZ(String str) {
        this.aVp.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aVp.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVs.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aVs.setLayoutParams(layoutParams);
        }
    }
}
