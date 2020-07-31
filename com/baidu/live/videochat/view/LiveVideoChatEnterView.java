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
    private ImageView bmB;
    private BubbleLayout bmC;
    private TextView bmD;
    private boolean bmE;
    private long bmF;
    private String bmG;
    private int bmH;
    private int bmI;
    private Runnable bmJ;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bmE = false;
        this.bmF = 0L;
        this.bmG = null;
        this.bmH = -1;
        this.bmI = 0;
        this.bmJ = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.KC();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmE = false;
        this.bmF = 0L;
        this.bmG = null;
        this.bmH = -1;
        this.bmI = 0;
        this.bmJ = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.KC();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmE = false;
        this.bmF = 0L;
        this.bmG = null;
        this.bmH = -1;
        this.bmI = 0;
        this.bmJ = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.KC();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bmC = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bmD = (TextView) findViewById(a.g.layout_bubble_text);
        this.bmB = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bmF <= 0) {
            this.bmF = 0L;
        }
        this.bmE = z;
        this.bmF = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bmH = i;
    }

    public void KC() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bmC != null && this.bmC.getParent() != null) {
            this.bmC.setVisibility(4);
        }
    }
}
