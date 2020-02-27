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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView ahN;
    public TextView ahO;
    public TextView ahP;
    private com.baidu.live.gift.a.c ahQ;
    private RelativeLayout ahR;

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
        this.ahR = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.ahN = (HeadImageView) findViewById(a.g.sender_avatar);
        this.ahN.setIsRound(true);
        this.ahN.setAutoChangeStyle(false);
        this.ahN.setDefaultBgResource(a.f.sdk_default_avatar);
        this.ahO = (TextView) findViewById(a.g.sender_name);
        this.ahP = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.sS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS() {
        if (this.ahQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.ahQ.userId), this.ahQ.userName, this.ahQ.portrait, this.ahQ.sex, this.ahQ.aly, this.ahQ.location, this.ahQ.description, 0L, this.ahQ.fansCount, this.ahQ.alz, this.ahQ.userStatus, this.ahQ.liveId, this.ahQ.groupId, this.ahQ.alC, this.ahQ.alD, this.ahQ.appId, this.ahQ.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.ahQ = cVar;
            if (cVar.portrait != null) {
                this.ahN.startLoad(cVar.portrait, 12, false);
            }
            du(cVar.userName);
            if (cVar.alw != null) {
                this.ahP.setText(cVar.alw.ry());
            }
        }
    }

    private void du(String str) {
        this.ahO.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.ahO.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahR.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.ahR.setLayoutParams(layoutParams);
        }
    }
}
