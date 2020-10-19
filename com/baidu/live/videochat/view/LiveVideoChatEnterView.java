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
    private ImageView bCb;
    private BubbleLayout bCc;
    private TextView bCd;
    private boolean bCe;
    private long bCf;
    private String bCg;
    private int bCh;
    private int bCi;
    private Runnable bCj;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bCe = false;
        this.bCf = 0L;
        this.bCg = null;
        this.bCh = -1;
        this.bCi = 0;
        this.bCj = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.SU();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCe = false;
        this.bCf = 0L;
        this.bCg = null;
        this.bCh = -1;
        this.bCi = 0;
        this.bCj = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.SU();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCe = false;
        this.bCf = 0L;
        this.bCg = null;
        this.bCh = -1;
        this.bCi = 0;
        this.bCj = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.SU();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bCc = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bCd = (TextView) findViewById(a.g.layout_bubble_text);
        this.bCb = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bCf <= 0) {
            this.bCf = 0L;
        }
        this.bCe = z;
        this.bCf = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bCh = i;
    }

    public void SU() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bCc != null && this.bCc.getParent() != null) {
            this.bCc.setVisibility(4);
        }
    }
}
