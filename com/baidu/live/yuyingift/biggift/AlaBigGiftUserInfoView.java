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
/* loaded from: classes4.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aWV;
    public TextView aWW;
    public TextView aWX;
    private RelativeLayout aWZ;
    private com.baidu.live.yuyingift.a.c bPC;

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
        this.aWZ = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.aWV = (HeadImageView) findViewById(a.f.sender_avatar);
        this.aWV.setIsRound(true);
        this.aWV.setAutoChangeStyle(false);
        this.aWV.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aWW = (TextView) findViewById(a.f.sender_name);
        this.aWX = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.HB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bPC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bPC.userId), this.bPC.userName, this.bPC.portrait, this.bPC.sex, this.bPC.bbe, this.bPC.location, this.bPC.description, 0L, this.bPC.fansCount, this.bPC.bbf, this.bPC.userStatus, this.bPC.liveId, this.bPC.groupId, this.bPC.bbk, this.bPC.bbl, this.bPC.appId, this.bPC.userName, "")));
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bPC = cVar;
            if (cVar.portrait != null) {
                this.aWV.startLoad(cVar.portrait, 12, false);
            }
            hl(cVar.userName);
            if (cVar.bbc != null) {
                this.aWX.setText(cVar.bbc.FU());
            }
        }
    }

    private void hl(String str) {
        this.aWW.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aWW.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aWZ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aWZ.setLayoutParams(layoutParams);
        }
    }
}
