package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class ALAImMsgMoreChatView extends LinearLayout {
    public ALAImMsgMoreChatView(Context context) {
        super(context);
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ALAImMsgMoreChatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        inflate(context, a.h.yuyinala_im_msg_more_chat_view, this);
        setVisibility(4);
        setGravity(17);
        setBackgroundResource(a.f.ala_live_im_msg_more_msg_view_bg_shape);
    }
}
