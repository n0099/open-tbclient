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
/* loaded from: classes11.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bSP;
    private BubbleLayout bSQ;
    private TextView bSR;
    private boolean bSS;
    private long bST;
    private int bSU;
    private int bSV;
    private Runnable bSW;
    private String mCacheKey;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bSS = false;
        this.bST = 0L;
        this.mCacheKey = null;
        this.bSU = -1;
        this.bSV = 0;
        this.bSW = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Zs();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSS = false;
        this.bST = 0L;
        this.mCacheKey = null;
        this.bSU = -1;
        this.bSV = 0;
        this.bSW = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Zs();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bSS = false;
        this.bST = 0L;
        this.mCacheKey = null;
        this.bSU = -1;
        this.bSV = 0;
        this.bSW = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Zs();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bSQ = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bSR = (TextView) findViewById(a.f.layout_bubble_text);
        this.bSP = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bST <= 0) {
            this.bST = 0L;
        }
        this.bSS = z;
        this.bST = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bSU = i;
    }

    public void Zs() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bSQ != null && this.bSQ.getParent() != null) {
            this.bSQ.setVisibility(4);
        }
    }
}
