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
/* loaded from: classes10.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bOd;
    private BubbleLayout bOe;
    private TextView bOf;
    private boolean bOg;
    private long bOh;
    private int bOi;
    private int bOj;
    private Runnable bOk;
    private String mCacheKey;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bOg = false;
        this.bOh = 0L;
        this.mCacheKey = null;
        this.bOi = -1;
        this.bOj = 0;
        this.bOk = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.VA();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOg = false;
        this.bOh = 0L;
        this.mCacheKey = null;
        this.bOi = -1;
        this.bOj = 0;
        this.bOk = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.VA();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOg = false;
        this.bOh = 0L;
        this.mCacheKey = null;
        this.bOi = -1;
        this.bOj = 0;
        this.bOk = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.VA();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bOe = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bOf = (TextView) findViewById(a.f.layout_bubble_text);
        this.bOd = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bOh <= 0) {
            this.bOh = 0L;
        }
        this.bOg = z;
        this.bOh = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bOi = i;
    }

    public void VA() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bOe != null && this.bOe.getParent() != null) {
            this.bOe.setVisibility(4);
        }
    }
}
