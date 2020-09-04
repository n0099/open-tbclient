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
/* loaded from: classes7.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bsj;
    private BubbleLayout bsk;
    private TextView bsl;
    private boolean bsm;
    private long bsn;
    private String bso;
    private int bsp;
    private int bsq;
    private Runnable bsr;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bsm = false;
        this.bsn = 0L;
        this.bso = null;
        this.bsp = -1;
        this.bsq = 0;
        this.bsr = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Qu();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsm = false;
        this.bsn = 0L;
        this.bso = null;
        this.bsp = -1;
        this.bsq = 0;
        this.bsr = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Qu();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsm = false;
        this.bsn = 0L;
        this.bso = null;
        this.bsp = -1;
        this.bsq = 0;
        this.bsr = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Qu();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bsk = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bsl = (TextView) findViewById(a.g.layout_bubble_text);
        this.bsj = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bsn <= 0) {
            this.bsn = 0L;
        }
        this.bsm = z;
        this.bsn = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bsp = i;
    }

    public void Qu() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bsk != null && this.bsk.getParent() != null) {
            this.bsk.setVisibility(4);
        }
    }
}
