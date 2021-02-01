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
/* loaded from: classes11.dex */
public class LiveVideoChatEnterView extends RelativeLayout {
    private ImageView bRT;
    private BubbleLayout bRU;
    private TextView bRV;
    private boolean bRW;
    private long bRX;
    private int bRY;
    private int bRZ;
    private Runnable bSa;
    private String mCacheKey;
    private CharSequence mContentText;
    private Handler mHandler;

    public LiveVideoChatEnterView(Context context) {
        super(context);
        this.bRW = false;
        this.bRX = 0L;
        this.mCacheKey = null;
        this.bRY = -1;
        this.bRZ = 0;
        this.bSa = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Xj();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRW = false;
        this.bRX = 0L;
        this.mCacheKey = null;
        this.bRY = -1;
        this.bRZ = 0;
        this.bSa = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Xj();
            }
        };
        init(context);
    }

    public LiveVideoChatEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRW = false;
        this.bRX = 0L;
        this.mCacheKey = null;
        this.bRY = -1;
        this.bRZ = 0;
        this.bSa = new Runnable() { // from class: com.baidu.live.videochat.view.LiveVideoChatEnterView.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoChatEnterView.this.Xj();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.sdk_live_video_chat_enter_view, this);
        this.bRU = (BubbleLayout) findViewById(a.f.layout_bubble);
        this.bRV = (TextView) findViewById(a.f.layout_bubble_text);
        this.bRT = (ImageView) findViewById(a.f.live_video_chat_enter);
    }

    public View getEnterView() {
        return this;
    }

    public void setBubbleText(CharSequence charSequence) {
        this.mContentText = charSequence;
    }

    public void setAutoHideBubble(boolean z, long j) {
        if (this.bRX <= 0) {
            this.bRX = 0L;
        }
        this.bRW = z;
        this.bRX = j;
    }

    public void setMaxShowTime(int i) {
        if (i < 0) {
            i = -1;
        }
        this.bRY = i;
    }

    public void Xj() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bRU != null && this.bRU.getParent() != null) {
            this.bRU.setVisibility(4);
        }
    }
}
