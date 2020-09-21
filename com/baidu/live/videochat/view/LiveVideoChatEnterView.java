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
    private TextView bvA;
    private boolean bvB;
    private long bvC;
    private String bvD;
    private int bvE;
    private int bvF;
    private Runnable bvG;
    private ImageView bvy;
    private BubbleLayout bvz;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bvB = false;
        this.bvC = 0L;
        this.bvD = null;
        this.bvE = -1;
        this.bvF = 0;
        this.bvG = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Rc();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvB = false;
        this.bvC = 0L;
        this.bvD = null;
        this.bvE = -1;
        this.bvF = 0;
        this.bvG = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Rc();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvB = false;
        this.bvC = 0L;
        this.bvD = null;
        this.bvE = -1;
        this.bvF = 0;
        this.bvG = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Rc();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bvz = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bvA = (TextView) findViewById(a.g.layout_bubble_text);
        this.bvy = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bvC <= 0) {
            this.bvC = 0L;
        }
        this.bvB = z;
        this.bvC = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bvE = i;
    }

    public void Rc() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bvz != null && this.bvz.getParent() != null) {
            this.bvz.setVisibility(4);
        }
    }
}
