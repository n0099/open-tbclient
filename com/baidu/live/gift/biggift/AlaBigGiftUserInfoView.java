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
    public HeadImageView aFQ;
    public TextView aFR;
    public TextView aFS;
    private com.baidu.live.gift.a.c aFT;
    private RelativeLayout aFU;

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
        this.aFU = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aFQ = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aFQ.setIsRound(true);
        this.aFQ.setAutoChangeStyle(false);
        this.aFQ.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aFR = (TextView) findViewById(a.g.sender_name);
        this.aFS = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.yD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD() {
        if (this.aFT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aFT.userId), this.aFT.userName, this.aFT.portrait, this.aFT.sex, this.aFT.aJE, this.aFT.location, this.aFT.description, 0L, this.aFT.fansCount, this.aFT.aJF, this.aFT.userStatus, this.aFT.liveId, this.aFT.groupId, this.aFT.aJI, this.aFT.aJJ, this.aFT.appId, this.aFT.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aFT = cVar;
            if (cVar.portrait != null) {
                this.aFQ.startLoad(cVar.portrait, 12, false);
            }
            eU(cVar.userName);
            if (cVar.aJC != null) {
                this.aFS.setText(cVar.aJC.xm());
            }
        }
    }

    private void eU(String str) {
        this.aFR.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aFR.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aFU.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.aFU.setLayoutParams(layoutParams);
        }
    }
}
