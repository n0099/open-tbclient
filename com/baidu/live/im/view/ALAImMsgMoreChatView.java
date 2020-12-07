package com.baidu.live.im.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class ALAImMsgMoreChatView extends LinearLayout {
    int bpO;
    TextView bpP;

    public ALAImMsgMoreChatView(Context context) {
        super(context);
        this.bpO = 0;
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpO = 0;
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpO = 0;
        init(context);
    }

    private void init(Context context) {
        inflate(context, a.g.ala_im_msg_more_chat_view, this);
        setVisibility(4);
        setGravity(17);
        setBackgroundResource(a.e.ala_live_im_msg_more_msg_view_bg_shape);
        this.bpP = (TextView) findViewById(a.f.tvAlaImBottomNewMsg);
    }

    public void setNewMessageSize(int i) {
        this.bpO = i;
        this.bpP.setText(i + "条新消息");
    }
}
