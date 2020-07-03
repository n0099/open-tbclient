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
/* loaded from: classes3.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bmg;
    private BubbleLayout bmh;
    private TextView bmi;
    private boolean bmj;
    private long bmk;
    private String bml;
    private int bmm;
    private int bmn;
    private Runnable bmo;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bmj = false;
        this.bmk = 0L;
        this.bml = null;
        this.bmm = -1;
        this.bmn = 0;
        this.bmo = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Kv();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmj = false;
        this.bmk = 0L;
        this.bml = null;
        this.bmm = -1;
        this.bmn = 0;
        this.bmo = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Kv();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmj = false;
        this.bmk = 0L;
        this.bml = null;
        this.bmm = -1;
        this.bmn = 0;
        this.bmo = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Kv();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.sdk_live_video_chat_enter_view, this);
        this.bmh = (BubbleLayout) findViewById(a.g.layout_bubble);
        this.bmi = (TextView) findViewById(a.g.layout_bubble_text);
        this.bmg = (ImageView) findViewById(a.g.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bmk <= 0) {
            this.bmk = 0L;
        }
        this.bmj = z;
        this.bmk = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bmm = i;
    }

    public void Kv() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bmh != null && this.bmh.getParent() != null) {
            this.bmh.setVisibility(4);
        }
    }
}
