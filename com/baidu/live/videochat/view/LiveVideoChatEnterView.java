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
/* loaded from: classes10.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private Runnable bTA;
    private ImageView bTt;
    private BubbleLayout bTu;
    private TextView bTv;
    private boolean bTw;
    private long bTx;
    private int bTy;
    private int bTz;
    private String mCacheKey;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bTw = false;
        this.bTx = 0L;
        this.mCacheKey = null;
        this.bTy = -1;
        this.bTz = 0;
        this.bTA = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Xm();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTw = false;
        this.bTx = 0L;
        this.mCacheKey = null;
        this.bTy = -1;
        this.bTz = 0;
        this.bTA = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Xm();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTw = false;
        this.bTx = 0L;
        this.mCacheKey = null;
        this.bTy = -1;
        this.bTz = 0;
        this.bTA = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Xm();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bTu = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bTv = (TextView) findViewById(a.f.layout_bubble_text);
        this.bTt = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bTx <= 0) {
            this.bTx = 0L;
        }
        this.bTw = z;
        this.bTx = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bTy = i;
    }

    public void Xm() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bTu != null && this.bTu.getParent() != null) {
            this.bTu.setVisibility(4);
        }
    }
}
