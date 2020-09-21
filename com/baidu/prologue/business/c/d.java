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
/* loaded from: classes10.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0278a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bMm.get().VD();
    private View bNI;
    private FrameLayout bNK;
    private ImageView bNL;
    private File bNM;
    private String bNN;
    private String bNO;
    private boolean bNP;
    private boolean bNQ;
    private Bitmap bNR;
    private com.baidu.prologue.business.a.a bNS;
    protected boolean bNT;
    protected boolean bNU;
    private a.InterfaceC0276a bNV;
    private String bNc;
    private com.baidu.prologue.b.b bNh;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bNI = null;
        this.bNP = true;
        this.bNQ = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bNR = null;
        this.bNT = true;
        this.bNU = false;
        this.bNh = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bNS.play();
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
                d.this.Wt().Wp();
                d.this.Ww();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean T(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dk(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bNV = new a.InterfaceC0276a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0276a
            public void gj(int i) {
                d.this.Wt().Wp();
            }
        };
    }

    public d r(@NonNull File file) {
        this.bNM = file;
        return this;
    }

    public d iC(String str) {
        this.bNO = str;
        return this;
    }

    public d iD(String str) {
        this.bNN = str;
        return this;
    }

    public d iE(@NonNull String str) {
        this.bNc = str;
        return this;
    }

    public d di(boolean z) {
        this.bNP = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bNS = aVar;
        return this;
    }

    public d dj(boolean z) {
        this.bNQ = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Wq() {
        this.bNK = (FrameLayout) this.mRootView.findViewById(b.C0277b.video_splash_view_content);
        this.bNI = this.mRootView.findViewById(b.C0277b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0277b.video_mask_view);
        this.bNL = (ImageView) this.mRootView.findViewById(b.C0277b.video_splash_view_bs);
        if (this.bNQ) {
            Wz();
        }
        WA();
        if (this.bNP) {
            WB();
        }
    }

    private void Wz() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bNM.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bNL.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bNL.setImageBitmap(bitmap);
            dk(true);
        }
    }

    private void WA() {
        View tG = this.bNS.tG();
        if (tG != null && tG.getParent() != this.bNK) {
            if (tG.getParent() != null) {
                ((ViewGroup) tG.getParent()).removeView(tG);
            }
            int width = this.bNK.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bNK.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bNK.addView(tG, 1, layoutParams);
        }
    }

    private void WB() {
        if (this.bNS != null) {
            this.bNU = false;
            this.bNS.a(this.bNM, this.bNN, this.bNh, this.bNc, this, this.bNV, this.bNi);
            this.bNS.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void Wv() {
        super.Wv();
        this.bNU = true;
        if (this.bNS != null && this.bNS.Wm()) {
            this.bNS.pause();
            this.bNS.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(boolean z) {
        if (z) {
            this.bNL.setVisibility(0);
        } else {
            this.bNL.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Wn() {
        return this.bNS != null ? this.bNS.Wn() : this.bNI;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0278a
    public void iw(String str) {
        this.bNc = str;
    }
}
