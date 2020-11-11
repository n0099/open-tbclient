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
    private ImageView bKD;
    private BubbleLayout bKE;
    private TextView bKF;
    private boolean bKG;
    private long bKH;
    private String bKI;
    private int bKJ;
    private int bKK;
    private Runnable bKL;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bKG = false;
        this.bKH = 0L;
        this.bKI = null;
        this.bKJ = -1;
        this.bKK = 0;
        this.bKL = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Wt();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKG = false;
        this.bKH = 0L;
        this.bKI = null;
        this.bKJ = -1;
        this.bKK = 0;
        this.bKL = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Wt();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKG = false;
        this.bKH = 0L;
        this.bKI = null;
        this.bKJ = -1;
        this.bKK = 0;
        this.bKL = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Wt();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bKE = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bKF = (TextView) findViewById(a.f.layout_bubble_text);
        this.bKD = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bKH <= 0) {
            this.bKH = 0L;
        }
        this.bKG = z;
        this.bKH = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bKJ = i;
    }

    public void Wt() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bKE != null && this.bKE.getParent() != null) {
            this.bKE.setVisibility(4);
        }
    }
}
