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
/* loaded from: classes11.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    private RelativeLayout aYA;
    public HeadImageView aYw;
    public TextView aYx;
    public TextView aYy;
    private com.baidu.live.yuyingift.a.c bXV;

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
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.FG();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.bXV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bXV.userId), this.bXV.userName, this.bXV.portrait, this.bXV.sex, this.bXV.bcQ, this.bXV.location, this.bXV.description, 0L, this.bXV.fansCount, this.bXV.followCount, this.bXV.userStatus, this.bXV.liveId, this.bXV.groupId, this.bXV.bcW, this.bXV.bcX, this.bXV.appId, this.bXV.userName, "")));
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bXV = cVar;
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
