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
    private TextView aZA;
    private boolean aZB;
    private long aZC;
    private String aZD;
    private int aZE;
    private int aZF;
    private Runnable aZG;
    private ImageView aZy;
    private BubbleLayout aZz;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.aZB = false;
        this.aZC = 0L;
        this.aZD = null;
        this.aZE = -1;
        this.aZF = 0;
        this.aZG = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Hq();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZB = false;
        this.aZC = 0L;
        this.aZD = null;
        this.aZE = -1;
        this.aZF = 0;
        this.aZG = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Hq();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZB = false;
        this.aZC = 0L;
        this.aZD = null;
        this.aZE = -1;
        this.aZF = 0;
        this.aZG = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Hq();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.aZz = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.aZA = (TextView) findViewById(a.g.layout_bubble_text);
        this.aZy = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.aZC <= 0) {
            this.aZC = 0L;
        }
        this.aZB = z;
        this.aZC = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.aZE = i;
    }

    public void Hq() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZz != null && this.aZz.getParent() != null) {
            this.aZz.setVisibility(4);
        }
    }
}
