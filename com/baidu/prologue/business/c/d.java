package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.prologue.b;
import com.baidu.prologue.b.a;
import com.baidu.prologue.business.a.a;
import java.io.File;
/* loaded from: classes9.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0280a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bKm.get().UU();
    private View bLI;
    private FrameLayout bLK;
    private ImageView bLL;
    private File bLM;
    private String bLN;
    private String bLO;
    private boolean bLP;
    private boolean bLQ;
    private Bitmap bLR;
    private com.baidu.prologue.business.a.a bLS;
    protected boolean bLT;
    protected boolean bLU;
    private a.InterfaceC0278a bLV;
    private String bLc;
    private com.baidu.prologue.b.b bLh;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bLI = null;
        this.bLP = true;
        this.bLQ = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bLR = null;
        this.bLT = true;
        this.bLU = false;
        this.bLh = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bLS.play();
            }

            @Override // com.baidu.prologue.b.b
            public void onCompletion() {
            }

            @Override // com.baidu.prologue.b.b
            public void onBufferingUpdate(int i) {
            }

            @Override // com.baidu.prologue.b.b
            public void onSeekComplete() {
            }

            @Override // com.baidu.prologue.b.b
            public void onVideoSizeChanged(int i, int i2) {
            }

            @Override // com.baidu.prologue.b.b
            public boolean onError(int i, int i2) {
                d.this.VK().VG();
                d.this.VN();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean T(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dm(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bLV = new a.InterfaceC0278a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0278a
            public void ga(int i) {
                d.this.VK().VG();
            }
        };
    }

    public d r(@NonNull File file) {
        this.bLM = file;
        return this;
    }

    public d ij(String str) {
        this.bLO = str;
        return this;
    }

    public d ik(String str) {
        this.bLN = str;
        return this;
    }

    public d il(@NonNull String str) {
        this.bLc = str;
        return this;
    }

    public d dk(boolean z) {
        this.bLP = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bLS = aVar;
        return this;
    }

    public d dl(boolean z) {
        this.bLQ = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void VH() {
        this.bLK = (FrameLayout) this.mRootView.findViewById(b.C0279b.video_splash_view_content);
        this.bLI = this.mRootView.findViewById(b.C0279b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0279b.video_mask_view);
        this.bLL = (ImageView) this.mRootView.findViewById(b.C0279b.video_splash_view_bs);
        if (this.bLQ) {
            VQ();
        }
        VR();
        if (this.bLP) {
            VS();
        }
    }

    private void VQ() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bLM.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bLL.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bLL.setImageBitmap(bitmap);
            dm(true);
        }
    }

    private void VR() {
        View tB = this.bLS.tB();
        if (tB != null && tB.getParent() != this.bLK) {
            if (tB.getParent() != null) {
                ((ViewGroup) tB.getParent()).removeView(tB);
            }
            int width = this.bLK.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bLK.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bLK.addView(tB, 1, layoutParams);
        }
    }

    private void VS() {
        if (this.bLS != null) {
            this.bLU = false;
            this.bLS.a(this.bLM, this.bLN, this.bLh, this.bLc, this, this.bLV, this.bLi);
            this.bLS.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void VM() {
        super.VM();
        this.bLU = true;
        if (this.bLS != null && this.bLS.VD()) {
            this.bLS.pause();
            this.bLS.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(boolean z) {
        if (z) {
            this.bLL.setVisibility(0);
        } else {
            this.bLL.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View VE() {
        return this.bLS != null ? this.bLS.VE() : this.bLI;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0280a
    public void id(String str) {
        this.bLc = str;
    }
}
