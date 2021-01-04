package com.baidu.live.videochat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class LiveVideoChatPanelView extends FrameLayout {
    private FrameLayout bSY;
    private RelativeLayout bSZ;
    private ImageView bTa;
    private TextView bTb;
    private Context mContext;

    public LiveVideoChatPanelView(@NonNull Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public LiveVideoChatPanelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public LiveVideoChatPanelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.sdk_live_video_chat_panel_view, this);
        this.bSY = (FrameLayout) findViewById(a.f.live_video_chat_panel);
        this.bSZ = (RelativeLayout) findViewById(a.f.live_video_chat_prepare_layout);
        this.bTa = (ImageView) findViewById(a.f.live_video_chat_prepare_img);
        this.bTb = (TextView) findViewById(a.f.live_video_chat_prepare_txt);
    }

    public View getPanelView() {
        return this;
    }
}
