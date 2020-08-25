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
    private ImageView bsg;
    private BubbleLayout bsh;
    private TextView bsi;
    private boolean bsj;
    private long bsk;
    private String bsl;
    private int bsm;
    private int bsn;
    private Runnable bso;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bsj = false;
        this.bsk = 0L;
        this.bsl = null;
        this.bsm = -1;
        this.bsn = 0;
        this.bso = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Qu();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsj = false;
        this.bsk = 0L;
        this.bsl = null;
        this.bsm = -1;
        this.bsn = 0;
        this.bso = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Qu();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsj = false;
        this.bsk = 0L;
        this.bsl = null;
        this.bsm = -1;
        this.bsn = 0;
        this.bso = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Qu();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bsh = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bsi = (TextView) findViewById(a.g.layout_bubble_text);
        this.bsg = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bsk <= 0) {
            this.bsk = 0L;
        }
        this.bsj = z;
        this.bsk = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bsm = i;
    }

    public void Qu() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bsh != null && this.bsh.getParent() != null) {
            this.bsh.setVisibility(4);
        }
    }
}
