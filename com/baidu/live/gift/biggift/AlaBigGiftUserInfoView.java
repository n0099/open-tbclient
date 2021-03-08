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
/* loaded from: classes10.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aZW;
    public TextView aZX;
    public TextView aZY;
    private com.baidu.live.gift.a.c aZZ;
    private RelativeLayout baa;

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
        this.baa = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.aZW = (HeadImageView) findViewById(a.f.sender_avatar);
        this.aZW.setIsRound(true);
        this.aZW.setAutoChangeStyle(false);
        this.aZW.setDefaultBgResource(a.e.sdk_default_avatar);
        this.aZX = (TextView) findViewById(a.f.sender_name);
        this.aZY = (TextView) findViewById(a.f.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.FJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (this.aZZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aZZ.userId), this.aZZ.userName, this.aZZ.portrait, this.aZZ.sex, this.aZZ.ber, this.aZZ.location, this.aZZ.description, 0L, this.aZZ.fansCount, this.aZZ.followCount, this.aZZ.userStatus, this.aZZ.liveId, this.aZZ.groupId, this.aZZ.bey, this.aZZ.bez, this.aZZ.appId, this.aZZ.userName)));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aZZ = cVar;
            if (cVar.portrait != null) {
                this.aZW.startLoad(cVar.portrait, 12, false);
            }
            gD(cVar.userName);
            if (cVar.bep != null) {
                this.aZY.setText(cVar.bep.DV());
            }
        }
    }

    private void gD(String str) {
        this.aZX.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aZX.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baa.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.baa.setLayoutParams(layoutParams);
        }
    }
}
