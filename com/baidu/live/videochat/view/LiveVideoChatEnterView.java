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
    private ImageView bIS;
    private BubbleLayout bIT;
    private TextView bIU;
    private boolean bIV;
    private long bIW;
    private String bIX;
    private int bIY;
    private int bIZ;
    private Runnable bJa;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bIV = false;
        this.bIW = 0L;
        this.bIX = null;
        this.bIY = -1;
        this.bIZ = 0;
        this.bJa = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.VK();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIV = false;
        this.bIW = 0L;
        this.bIX = null;
        this.bIY = -1;
        this.bIZ = 0;
        this.bJa = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.VK();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIV = false;
        this.bIW = 0L;
        this.bIX = null;
        this.bIY = -1;
        this.bIZ = 0;
        this.bJa = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.VK();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bIT = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bIU = (TextView) findViewById(a.f.layout_bubble_text);
        this.bIS = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bIW <= 0) {
            this.bIW = 0L;
        }
        this.bIV = z;
        this.bIW = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bIY = i;
    }

    public void VK() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bIT != null && this.bIT.getParent() != null) {
            this.bIT.setVisibility(4);
        }
    }
}
