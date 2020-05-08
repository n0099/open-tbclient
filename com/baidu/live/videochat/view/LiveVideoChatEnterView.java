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
    private ImageView aZD;
    private BubbleLayout aZE;
    private TextView aZF;
    private boolean aZG;
    private long aZH;
    private String aZI;
    private int aZJ;
    private int aZK;
    private Runnable aZL;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.aZG = false;
        this.aZH = 0L;
        this.aZI = null;
        this.aZJ = -1;
        this.aZK = 0;
        this.aZL = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Hp();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZG = false;
        this.aZH = 0L;
        this.aZI = null;
        this.aZJ = -1;
        this.aZK = 0;
        this.aZL = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Hp();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZG = false;
        this.aZH = 0L;
        this.aZI = null;
        this.aZJ = -1;
        this.aZK = 0;
        this.aZL = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Hp();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.aZE = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.aZF = (TextView) findViewById(a.g.layout_bubble_text);
        this.aZD = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.aZH <= 0) {
            this.aZH = 0L;
        }
        this.aZG = z;
        this.aZH = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.aZJ = i;
    }

    public void Hp() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZE != null && this.aZE.getParent() != null) {
            this.aZE.setVisibility(4);
        }
    }
}
