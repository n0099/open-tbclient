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
    public HeadImageView Xl;
    public TextView Xm;
    public TextView Xn;
    private d Xo;
    private RelativeLayout Xp;

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
        this.Xp = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.Xl = (HeadImageView) findViewById(a.g.sender_avatar);
        this.Xl.setIsRound(true);
        this.Xl.setAutoChangeStyle(false);
        this.Xl.setDefaultBgResource(a.f.sdk_default_avatar);
        this.Xm = (TextView) findViewById(a.g.sender_name);
        this.Xn = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.pS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.Xo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.Xo.userId), this.Xo.userName, this.Xo.portrait, this.Xo.sex, this.Xo.aaB, this.Xo.location, this.Xo.description, 0L, this.Xo.aaD, this.Xo.aaC, this.Xo.userStatus, this.Xo.liveId, this.Xo.groupId, this.Xo.aaG, this.Xo.aaH, this.Xo.appId, this.Xo.userName, "")));
        }
    }

    public void setData(d dVar) {
        if (dVar != null) {
            this.Xo = dVar;
            if (dVar.portrait != null) {
                this.Xl.startLoad(dVar.portrait, 12, false);
            }
            cp(dVar.userName);
            if (dVar.aaz != null) {
                this.Xn.setText(dVar.aaz.pd());
            }
        }
    }

    private void cp(String str) {
        this.Xm.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.Xm.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Xp.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.Xp.setLayoutParams(layoutParams);
        }
    }
}
