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
    private ImageView bEX;
    private BubbleLayout bEY;
    private TextView bEZ;
    private boolean bFa;
    private long bFb;
    private String bFc;
    private int bFd;
    private int bFe;
    private Runnable bFf;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bFa = false;
        this.bFb = 0L;
        this.bFc = null;
        this.bFd = -1;
        this.bFe = 0;
        this.bFf = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.TT();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFa = false;
        this.bFb = 0L;
        this.bFc = null;
        this.bFd = -1;
        this.bFe = 0;
        this.bFf = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.TT();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFa = false;
        this.bFb = 0L;
        this.bFc = null;
        this.bFd = -1;
        this.bFe = 0;
        this.bFf = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.TT();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bEY = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bEZ = (TextView) findViewById(a.g.layout_bubble_text);
        this.bEX = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bFb <= 0) {
            this.bFb = 0L;
        }
        this.bFa = z;
        this.bFb = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bFd = i;
    }

    public void TT() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bEY != null && this.bEY.getParent() != null) {
            this.bEY.setVisibility(4);
        }
    }
}
