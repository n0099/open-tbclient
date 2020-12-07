package com.baidu.live.videochat.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
/* loaded from: classes4.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bOa;
    private BubbleLayout bOb;
    private TextView bOc;
    private boolean bOd;
    private long bOe;
    private String bOf;
    private int bOg;
    private int bOh;
    private Runnable bOi;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bOd = false;
        this.bOe = 0L;
        this.bOf = null;
        this.bOg = -1;
        this.bOh = 0;
        this.bOi = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Yk();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOd = false;
        this.bOe = 0L;
        this.bOf = null;
        this.bOg = -1;
        this.bOh = 0;
        this.bOi = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Yk();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOd = false;
        this.bOe = 0L;
        this.bOf = null;
        this.bOg = -1;
        this.bOh = 0;
        this.bOi = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Yk();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bOb = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bOc = (TextView) findViewById(a.f.layout_bubble_text);
        this.bOa = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bOe <= 0) {
            this.bOe = 0L;
        }
        this.bOd = z;
        this.bOe = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bOg = i;
    }

    public void Yk() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bOb != null && this.bOb.getParent() != null) {
            this.bOb.setVisibility(4);
        }
    }
}
