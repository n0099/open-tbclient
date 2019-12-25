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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaBigGiftUserInfoView extends RelativeLayout {
    public HeadImageView aeW;
    public TextView aeX;
    public TextView aeY;
    private com.baidu.live.gift.a.b aeZ;
    private RelativeLayout afa;

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
        this.afa = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aeW = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aeW.setIsRound(true);
        this.aeW.setAutoChangeStyle(false);
        this.aeW.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aeX = (TextView) findViewById(a.g.sender_name);
        this.aeY = (TextView) findViewById(a.g.gift_name);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.biggift.AlaBigGiftUserInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaBigGiftUserInfoView.this.ru();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru() {
        if (this.aeZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aeZ.userId), this.aeZ.userName, this.aeZ.portrait, this.aeZ.sex, this.aeZ.aiE, this.aeZ.location, this.aeZ.description, 0L, this.aeZ.aiG, this.aeZ.aiF, this.aeZ.userStatus, this.aeZ.liveId, this.aeZ.groupId, this.aeZ.aiJ, this.aeZ.aiK, this.aeZ.appId, this.aeZ.userName, "")));
        }
    }

    public void setData(com.baidu.live.gift.a.b bVar) {
        if (bVar != null) {
            this.aeZ = bVar;
            if (bVar.portrait != null) {
                this.aeW.startLoad(bVar.portrait, 12, false);
            }
            dh(bVar.userName);
            if (bVar.aiC != null) {
                this.aeY.setText(bVar.aiC.qy());
            }
        }
    }

    private void dh(String str) {
        this.aeX.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            this.aeX.setText(str);
        }
    }

    public void setSenderUserInfoMarginLeftZero() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afa.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            this.afa.setLayoutParams(layoutParams);
        }
    }
}
