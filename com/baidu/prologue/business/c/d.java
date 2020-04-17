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
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0195a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.brQ.get().Lr();
    private String bsG;
    private com.baidu.prologue.b.b bsL;
    private View btl;
    private FrameLayout btn;
    private ImageView bto;
    private File btp;
    private String btq;
    private String btr;
    private boolean bts;
    private boolean btt;
    private Bitmap btu;
    private com.baidu.prologue.business.a.a btv;
    protected boolean btw;
    protected boolean btx;
    private a.InterfaceC0193a bty;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.btl = null;
        this.bts = true;
        this.btt = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.btu = null;
        this.btw = true;
        this.btx = false;
        this.bsL = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.btv.play();
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
            public void K(int i, int i2) {
            }

            @Override // com.baidu.prologue.b.b
            public boolean onError(int i, int i2) {
                d.this.Mi().Me();
                d.this.Ml();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean L(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.cK(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bty = new a.InterfaceC0193a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0193a
            public void dL(int i) {
                d.this.Mi().Me();
            }
        };
    }

    public d m(@NonNull File file) {
        this.btp = file;
        return this;
    }

    public d fW(String str) {
        this.btr = str;
        return this;
    }

    public d fX(String str) {
        this.btq = str;
        return this;
    }

    public d fY(@NonNull String str) {
        this.bsG = str;
        return this;
    }

    public d cI(boolean z) {
        this.bts = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.btv = aVar;
        return this;
    }

    public d cJ(boolean z) {
        this.btt = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Mf() {
        this.btn = (FrameLayout) this.mRootView.findViewById(b.C0194b.video_splash_view_content);
        this.btl = this.mRootView.findViewById(b.C0194b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0194b.video_mask_view);
        this.bto = (ImageView) this.mRootView.findViewById(b.C0194b.video_splash_view_bs);
        if (this.btt) {
            Mo();
        }
        Mp();
        if (this.bts) {
            Mq();
        }
    }

    private void Mo() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.btp.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bto.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bto.setImageBitmap(bitmap);
            cK(true);
        }
    }

    private void Mp() {
        View rq = this.btv.rq();
        if (rq != null && rq.getParent() != this.btn) {
            if (rq.getParent() != null) {
                ((ViewGroup) rq.getParent()).removeView(rq);
            }
            int width = this.btn.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.btn.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.btn.addView(rq, 1, layoutParams);
        }
    }

    private void Mq() {
        if (this.btv != null) {
            this.btx = false;
            this.btv.a(this.btp, this.btq, this.bsL, this.bsG, this, this.bty, this.bsM);
            this.btv.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void Mk() {
        super.Mk();
        this.btx = true;
        if (this.btv != null && this.btv.Ma()) {
            this.btv.pause();
            this.btv.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(boolean z) {
        if (z) {
            this.bto.setVisibility(0);
        } else {
            this.bto.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Mb() {
        return this.btv != null ? this.btv.Mb() : this.btl;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0195a
    public void fQ(String str) {
        this.bsG = str;
    }
}
