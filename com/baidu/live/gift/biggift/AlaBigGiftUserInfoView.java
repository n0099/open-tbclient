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
    public HeadImageView aVk;
    public TextView aVl;
    public TextView aVm;
    private com.baidu.live.gift.a.c aVn;
    private RelativeLayout aVo;

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
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.GS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        if (this.aVn != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVn.userId), this.aVn.userName, this.aVn.portrait, this.aVn.sex, this.aVn.aZs, this.aVn.location, this.aVn.description, 0L, this.aVn.fansCount, this.aVn.aZt, this.aVn.userStatus, this.aVn.liveId, this.aVn.groupId, this.aVn.aZy, this.aVn.aZz, this.aVn.appId, this.aVn.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aVn = cVar;
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
