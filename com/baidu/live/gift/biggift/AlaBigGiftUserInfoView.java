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
import com.baidu.live.gift.a.d;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView XD;
    public TextView XE;
    public TextView XF;
    private d XG;
    private RelativeLayout XH;

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
        this.XH = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.XD = (HeadImageView) findViewById(a.g.sender_avatar);
        this.XD.setIsRound(true);
        this.XD.setAutoChangeStyle(false);
        this.XD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.XE = (TextView) findViewById(a.g.sender_name);
        this.XF = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.pS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.XG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.XG.userId), this.XG.userName, this.XG.portrait, this.XG.sex, this.XG.aaT, this.XG.location, this.XG.description, 0L, this.XG.aaV, this.XG.aaU, this.XG.userStatus, this.XG.liveId, this.XG.groupId, this.XG.aaY, this.XG.aaZ, this.XG.appId, this.XG.userName, "")));
        }
    }

    public void setData(d dVar) {
        if (dVar != null) {
            this.XG = dVar;
            if (dVar.portrait != null) {
                this.XD.startLoad(dVar.portrait, 12, false);
            }
            cp(dVar.userName);
            if (dVar.aaR != null) {
                this.XF.setText(dVar.aaR.pd());
            }
        }
    }

    private void cp(String str) {
        this.XE.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.XE.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.XH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.XH.setLayoutParams(layoutParams);
        }
    }
}
