package com.baidu.live.videochat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class LiveVideoChatPanelView extends FrameLayout {
    private FrameLayout bmr;
    private RelativeLayout bms;
    private ImageView bmt;
    private TextView bmu;
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
        LayoutInflater.from(this.mContext).inflate(a.h.sdk_live_video_chat_panel_view, this);
        this.bmr = (FrameLayout) findViewById(a.g.live_video_chat_panel);
        this.bms = (RelativeLayout) findViewById(a.g.live_video_chat_prepare_layout);
        this.bmt = (ImageView) findViewById(a.g.live_video_chat_prepare_img);
        this.bmu = (TextView) findViewById(a.g.live_video_chat_prepare_txt);
    }

    public View getPanelView() {
        return this;
    }
}
