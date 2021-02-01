package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class ALAImMsgMoreChatView extends LinearLayout {
    int bql;
    TextView bqm;

    public ALAImMsgMoreChatView(Context context) {
        super(context);
        this.bql = 0;
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bql = 0;
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bql = 0;
        init(context);
    }

    private void init(Context context) {
        inflate(context, a.g.yuyinala_im_msg_more_chat_view, this);
        setVisibility(4);
        setGravity(17);
        setBackgroundResource(a.e.ala_live_im_msg_more_msg_view_bg_shape);
        this.bqm = (TextView) findViewById(a.f.tvAlaImBottomNewMsg);
    }

    public void setNewMessageSize(int i) {
        this.bql = i;
        if (i > 99) {
            this.bqm.setText("99+条新消息");
        } else {
            this.bqm.setText(i + "条新消息");
        }
    }
}
