package com.baidu.live.videochat.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bha;
    private BubbleLayout bhb;
    private TextView bhc;
    private boolean bhd;
    private long bhe;
    private String bhf;
    private int bhg;
    private int bhh;
    private Runnable bhi;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bhd = false;
        this.bhe = 0L;
        this.bhf = null;
        this.bhg = -1;
        this.bhh = 0;
        this.bhi = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Ji();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhd = false;
        this.bhe = 0L;
        this.bhf = null;
        this.bhg = -1;
        this.bhh = 0;
        this.bhi = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Ji();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhd = false;
        this.bhe = 0L;
        this.bhf = null;
        this.bhg = -1;
        this.bhh = 0;
        this.bhi = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Ji();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bhb = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bhc = (TextView) findViewById(a.g.layout_bubble_text);
        this.bha = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bhe <= 0) {
            this.bhe = 0L;
        }
        this.bhd = z;
        this.bhe = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bhg = i;
    }

    public void Ji() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bhb != null && this.bhb.getParent() != null) {
            this.bhb.setVisibility(4);
        }
    }
}
