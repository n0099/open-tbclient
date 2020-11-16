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
    public HeadImageView aVk;
    public TextView aVl;
    public TextView aVm;
    private RelativeLayout aVo;
    private com.baidu.live.yuyingift.a.c bNS;

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
        this.aVo = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.aVk = (HeadImageView) findViewById(a.f.sender_avatar);
        this.aVk.setIsRound(true);
        this.aVk.setAutoChangeStyle(false);
        this.aVk.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aVl = (TextView) findViewById(a.f.sender_name);
        this.aVm = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.GS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        if (this.bNS != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bNS.userId), this.bNS.userName, this.bNS.portrait, this.bNS.sex, this.bNS.aZs, this.bNS.location, this.bNS.description, 0L, this.bNS.fansCount, this.bNS.aZt, this.bNS.userStatus, this.bNS.liveId, this.bNS.groupId, this.bNS.aZy, this.bNS.aZz, this.bNS.appId, this.bNS.userName, "")));
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bNS = cVar;
            if (cVar.portrait != null) {
                this.aVk.startLoad(cVar.portrait, 12, false);
            }
            hf(cVar.userName);
            if (cVar.aZq != null) {
                this.aVm.setText(cVar.aZq.Fl());
            }
        }
    }

    private void hf(String str) {
        this.aVl.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aVl.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVo.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aVo.setLayoutParams(layoutParams);
        }
    }
}
