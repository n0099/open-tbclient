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
/* loaded from: classes14.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0317a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.cft.get().abk();
    private View cgP;
    private FrameLayout cgR;
    private ImageView cgS;
    private File cgT;
    private String cgU;
    private String cgV;
    private boolean cgW;
    private boolean cgX;
    private Bitmap cgY;
    private com.baidu.prologue.business.a.a cgZ;
    private String cgj;
    private com.baidu.prologue.b.b cgo;
    protected boolean cha;
    protected boolean chb;
    private a.InterfaceC0315a chc;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.cgP = null;
        this.cgW = true;
        this.cgX = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.cgY = null;
        this.cha = true;
        this.chb = false;
        this.cgo = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.cgZ.play();
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
                d.this.abZ().abW();
                d.this.acc();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean U(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dO(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.chc = new a.InterfaceC0315a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0315a
            public void gU(int i) {
                d.this.abZ().abW();
            }
        };
    }

    public d v(@NonNull File file) {
        this.cgT = file;
        return this;
    }

    public d jE(String str) {
        this.cgV = str;
        return this;
    }

    public d jF(String str) {
        this.cgU = str;
        return this;
    }

    public d jG(@NonNull String str) {
        this.cgj = str;
        return this;
    }

    public d dM(boolean z) {
        this.cgW = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.cgZ = aVar;
        return this;
    }

    public d dN(boolean z) {
        this.cgX = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Xh() {
        this.cgR = (FrameLayout) this.mRootView.findViewById(b.C0316b.video_splash_view_content);
        this.cgP = this.mRootView.findViewById(b.C0316b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0316b.video_mask_view);
        this.cgS = (ImageView) this.mRootView.findViewById(b.C0316b.video_splash_view_bs);
        if (this.cgX) {
            acf();
        }
        acg();
        if (this.cgW) {
            ach();
        }
    }

    private void acf() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.cgT.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.cgS.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cgS.setImageBitmap(bitmap);
            dO(true);
        }
    }

    private void acg() {
        View tG = this.cgZ.tG();
        if (tG != null && tG.getParent() != this.cgR) {
            if (tG.getParent() != null) {
                ((ViewGroup) tG.getParent()).removeView(tG);
            }
            int width = this.cgR.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.cgR.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.cgR.addView(tG, 1, layoutParams);
        }
    }

    private void ach() {
        if (this.cgZ != null) {
            this.chb = false;
            this.cgZ.a(this.cgT, this.cgU, this.cgo, this.cgj, this, this.chc, this.cgp);
            this.cgZ.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void acb() {
        super.acb();
        this.chb = true;
        if (this.cgZ != null && this.cgZ.abT()) {
            this.cgZ.pause();
            this.cgZ.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (z) {
            this.cgS.setVisibility(0);
        } else {
            this.cgS.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View abU() {
        return this.cgZ != null ? this.cgZ.abU() : this.cgP;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0317a
    public void jy(String str) {
        this.cgj = str;
    }
}
