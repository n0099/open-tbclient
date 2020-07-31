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
/* loaded from: classes8.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0259a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bEI.get().OY();
    private com.baidu.prologue.b.b bFD;
    private String bFy;
    private View bGe;
    private FrameLayout bGg;
    private ImageView bGh;
    private File bGi;
    private String bGj;
    private String bGk;
    private boolean bGl;
    private boolean bGm;
    private Bitmap bGn;
    private com.baidu.prologue.business.a.a bGo;
    protected boolean bGp;
    protected boolean bGq;
    private a.InterfaceC0257a bGr;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bGe = null;
        this.bGl = true;
        this.bGm = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bGn = null;
        this.bGp = true;
        this.bGq = false;
        this.bFD = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bGo.play();
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
                d.this.PP().PL();
                d.this.PS();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean Q(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dd(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bGr = new a.InterfaceC0257a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0257a
            public void ee(int i) {
                d.this.PP().PL();
            }
        };
    }

    public d q(@NonNull File file) {
        this.bGi = file;
        return this;
    }

    public d gO(String str) {
        this.bGk = str;
        return this;
    }

    public d gP(String str) {
        this.bGj = str;
        return this;
    }

    public d gQ(@NonNull String str) {
        this.bFy = str;
        return this;
    }

    public d db(boolean z) {
        this.bGl = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bGo = aVar;
        return this;
    }

    public d dc(boolean z) {
        this.bGm = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void PM() {
        this.bGg = (FrameLayout) this.mRootView.findViewById(b.C0258b.video_splash_view_content);
        this.bGe = this.mRootView.findViewById(b.C0258b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0258b.video_mask_view);
        this.bGh = (ImageView) this.mRootView.findViewById(b.C0258b.video_splash_view_bs);
        if (this.bGm) {
            PV();
        }
        PW();
        if (this.bGl) {
            PX();
        }
    }

    private void PV() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bGi.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bGh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bGh.setImageBitmap(bitmap);
            dd(true);
        }
    }

    private void PW() {
        View rQ = this.bGo.rQ();
        if (rQ != null && rQ.getParent() != this.bGg) {
            if (rQ.getParent() != null) {
                ((ViewGroup) rQ.getParent()).removeView(rQ);
            }
            int width = this.bGg.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bGg.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bGg.addView(rQ, 1, layoutParams);
        }
    }

    private void PX() {
        if (this.bGo != null) {
            this.bGq = false;
            this.bGo.a(this.bGi, this.bGj, this.bFD, this.bFy, this, this.bGr, this.bFE);
            this.bGo.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void PR() {
        super.PR();
        this.bGq = true;
        if (this.bGo != null && this.bGo.PH()) {
            this.bGo.pause();
            this.bGo.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(boolean z) {
        if (z) {
            this.bGh.setVisibility(0);
        } else {
            this.bGh.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View PI() {
        return this.bGo != null ? this.bGo.PI() : this.bGe;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0259a
    public void gI(String str) {
        this.bFy = str;
    }
}
