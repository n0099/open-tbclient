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
    public HeadImageView aYv;
    public TextView aYw;
    public TextView aYx;
    private com.baidu.live.gift.a.c aYy;
    private RelativeLayout aYz;

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
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.IJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ() {
        if (this.aYy != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aYy.userId), this.aYy.userName, this.aYy.portrait, this.aYy.sex, this.aYy.bcP, this.aYy.location, this.aYy.description, 0L, this.aYy.bcR, this.aYy.bcQ, this.aYy.userStatus, this.aYy.liveId, this.aYy.groupId, this.aYy.bcX, this.aYy.bcY, this.aYy.appId, this.aYy.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aYy = cVar;
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
