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
/* loaded from: classes6.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0256a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bEl.get().OJ();
    private View bFG;
    private FrameLayout bFI;
    private ImageView bFJ;
    private File bFK;
    private String bFL;
    private String bFM;
    private boolean bFN;
    private boolean bFO;
    private Bitmap bFP;
    private com.baidu.prologue.business.a.a bFQ;
    protected boolean bFR;
    protected boolean bFS;
    private a.InterfaceC0254a bFT;
    private String bFb;
    private com.baidu.prologue.b.b bFg;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bFG = null;
        this.bFN = true;
        this.bFO = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bFP = null;
        this.bFR = true;
        this.bFS = false;
        this.bFg = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bFQ.play();
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
            public void P(int i, int i2) {
            }

            @Override // com.baidu.prologue.b.b
            public boolean onError(int i, int i2) {
                d.this.PA().Pw();
                d.this.PD();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean Q(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.db(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bFT = new a.InterfaceC0254a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0254a
            public void ee(int i) {
                d.this.PA().Pw();
            }
        };
    }

    public d q(@NonNull File file) {
        this.bFK = file;
        return this;
    }

    public d gQ(String str) {
        this.bFM = str;
        return this;
    }

    public d gR(String str) {
        this.bFL = str;
        return this;
    }

    public d gS(@NonNull String str) {
        this.bFb = str;
        return this;
    }

    public d cZ(boolean z) {
        this.bFN = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bFQ = aVar;
        return this;
    }

    public d da(boolean z) {
        this.bFO = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Px() {
        this.bFI = (FrameLayout) this.mRootView.findViewById(b.C0255b.video_splash_view_content);
        this.bFG = this.mRootView.findViewById(b.C0255b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0255b.video_mask_view);
        this.bFJ = (ImageView) this.mRootView.findViewById(b.C0255b.video_splash_view_bs);
        if (this.bFO) {
            PG();
        }
        PH();
        if (this.bFN) {
            PI();
        }
    }

    private void PG() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bFK.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bFJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bFJ.setImageBitmap(bitmap);
            db(true);
        }
    }

    private void PH() {
        View rO = this.bFQ.rO();
        if (rO != null && rO.getParent() != this.bFI) {
            if (rO.getParent() != null) {
                ((ViewGroup) rO.getParent()).removeView(rO);
            }
            int width = this.bFI.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bFI.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bFI.addView(rO, 1, layoutParams);
        }
    }

    private void PI() {
        if (this.bFQ != null) {
            this.bFS = false;
            this.bFQ.a(this.bFK, this.bFL, this.bFg, this.bFb, this, this.bFT, this.bFh);
            this.bFQ.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void PC() {
        super.PC();
        this.bFS = true;
        if (this.bFQ != null && this.bFQ.Ps()) {
            this.bFQ.pause();
            this.bFQ.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(boolean z) {
        if (z) {
            this.bFJ.setVisibility(0);
        } else {
            this.bFJ.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Pt() {
        return this.bFQ != null ? this.bFQ.Pt() : this.bFG;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0256a
    public void gK(String str) {
        this.bFb = str;
    }
}
