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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bKi.get().UU();
    private String bKY;
    private View bLE;
    private FrameLayout bLG;
    private ImageView bLH;
    private File bLI;
    private String bLJ;
    private String bLK;
    private boolean bLL;
    private boolean bLM;
    private Bitmap bLN;
    private com.baidu.prologue.business.a.a bLO;
    protected boolean bLP;
    protected boolean bLQ;
    private a.InterfaceC0278a bLR;
    private com.baidu.prologue.b.b bLd;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bLE = null;
        this.bLL = true;
        this.bLM = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bLN = null;
        this.bLP = true;
        this.bLQ = false;
        this.bLd = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bLO.play();
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
                            d.this.dl(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bLR = new a.InterfaceC0278a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0278a
            public void ga(int i) {
                d.this.VK().VG();
            }
        };
    }

    public d r(@NonNull File file) {
        this.bLI = file;
        return this;
    }

    public d ii(String str) {
        this.bLK = str;
        return this;
    }

    public d ij(String str) {
        this.bLJ = str;
        return this;
    }

    public d ik(@NonNull String str) {
        this.bKY = str;
        return this;
    }

    public d dj(boolean z) {
        this.bLL = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bLO = aVar;
        return this;
    }

    public d dk(boolean z) {
        this.bLM = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void VH() {
        this.bLG = (FrameLayout) this.mRootView.findViewById(b.C0279b.video_splash_view_content);
        this.bLE = this.mRootView.findViewById(b.C0279b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0279b.video_mask_view);
        this.bLH = (ImageView) this.mRootView.findViewById(b.C0279b.video_splash_view_bs);
        if (this.bLM) {
            VQ();
        }
        VR();
        if (this.bLL) {
            VS();
        }
    }

    private void VQ() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bLI.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bLH.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bLH.setImageBitmap(bitmap);
            dl(true);
        }
    }

    private void VR() {
        View tB = this.bLO.tB();
        if (tB != null && tB.getParent() != this.bLG) {
            if (tB.getParent() != null) {
                ((ViewGroup) tB.getParent()).removeView(tB);
            }
            int width = this.bLG.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bLG.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bLG.addView(tB, 1, layoutParams);
        }
    }

    private void VS() {
        if (this.bLO != null) {
            this.bLQ = false;
            this.bLO.a(this.bLI, this.bLJ, this.bLd, this.bKY, this, this.bLR, this.bLe);
            this.bLO.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void VM() {
        super.VM();
        this.bLQ = true;
        if (this.bLO != null && this.bLO.VD()) {
            this.bLO.pause();
            this.bLO.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(boolean z) {
        if (z) {
            this.bLH.setVisibility(0);
        } else {
            this.bLH.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View VE() {
        return this.bLO != null ? this.bLO.VE() : this.bLE;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0280a
    public void ic(String str) {
        this.bKY = str;
    }
}
