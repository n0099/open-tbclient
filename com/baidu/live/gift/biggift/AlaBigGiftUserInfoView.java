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
    public HeadImageView aJI;
    public TextView aJJ;
    public TextView aJK;
    private com.baidu.live.gift.a.c aJL;
    private RelativeLayout aJM;

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
        this.aJM = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aJI = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aJI.setIsRound(true);
        this.aJI.setAutoChangeStyle(false);
        this.aJI.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aJJ = (TextView) findViewById(a.g.sender_name);
        this.aJK = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.zF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF() {
        if (this.aJL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aJL.userId), this.aJL.userName, this.aJL.portrait, this.aJL.sex, this.aJL.aNF, this.aJL.location, this.aJL.description, 0L, this.aJL.fansCount, this.aJL.aNG, this.aJL.userStatus, this.aJL.liveId, this.aJL.groupId, this.aJL.aNJ, this.aJL.aNK, this.aJL.appId, this.aJL.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aJL = cVar;
            if (cVar.portrait != null) {
                this.aJI.startLoad(cVar.portrait, 12, false);
            }
            eZ(cVar.userName);
            if (cVar.aND != null) {
                this.aJK.setText(cVar.aND.yp());
            }
        }
    }

    private void eZ(String str) {
        this.aJJ.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aJJ.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aJM.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aJM.setLayoutParams(layoutParams);
        }
    }
}
