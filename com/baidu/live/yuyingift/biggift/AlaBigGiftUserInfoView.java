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
    public HeadImageView aYv;
    public TextView aYw;
    public TextView aYx;
    private RelativeLayout aYz;
    private com.baidu.live.yuyingift.a.c bSY;

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
        this.aYz = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.aYv = (HeadImageView) findViewById(a.f.sender_avatar);
        this.aYv.setIsRound(true);
        this.aYv.setAutoChangeStyle(false);
        this.aYv.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aYw = (TextView) findViewById(a.f.sender_name);
        this.aYx = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.IJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ() {
        if (this.bSY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bSY.userId), this.bSY.userName, this.bSY.portrait, this.bSY.sex, this.bSY.bcP, this.bSY.location, this.bSY.description, 0L, this.bSY.bcR, this.bSY.bcQ, this.bSY.userStatus, this.bSY.liveId, this.bSY.groupId, this.bSY.bcX, this.bSY.bcY, this.bSY.appId, this.bSY.userName, "")));
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bSY = cVar;
            if (cVar.portrait != null) {
                this.aYv.startLoad(cVar.portrait, 12, false);
            }
            hA(cVar.userName);
            if (cVar.bcN != null) {
                this.aYx.setText(cVar.bcN.GY());
            }
        }
    }

    private void hA(String str) {
        this.aYw.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aYw.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYz.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aYz.setLayoutParams(layoutParams);
        }
    }
}
