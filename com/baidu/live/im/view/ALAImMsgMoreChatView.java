package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class ALAImMsgMoreChatView extends LinearLayout {
    int bkW;
    TextView bkX;

    public ALAImMsgMoreChatView(Context context) {
        super(context);
        this.bkW = 0;
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkW = 0;
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkW = 0;
        init(context);
    }

    private void init(Context context) {
        inflate(context, a.h.ala_im_msg_more_chat_view, this);
        setVisibility(4);
        setGravity(17);
        setBackgroundResource(a.f.ala_live_im_msg_more_msg_view_bg_shape);
        this.bkX = (TextView) findViewById(a.g.tvAlaImBottomNewMsg);
    }

    public void setNewMessageSize(int i) {
        this.bkW = i;
        this.bkX.setText(i + "条新消息");
    }
}
