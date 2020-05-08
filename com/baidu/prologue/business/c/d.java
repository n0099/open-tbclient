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
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0217a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.brU.get().Lq();
    private String bsK;
    private com.baidu.prologue.b.b bsP;
    protected boolean btA;
    protected boolean btB;
    private a.InterfaceC0215a btC;
    private View btp;
    private FrameLayout btr;
    private ImageView bts;
    private File btt;
    private String btu;
    private String btv;
    private boolean btw;
    private boolean btx;
    private Bitmap bty;
    private com.baidu.prologue.business.a.a btz;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.btp = null;
        this.btw = true;
        this.btx = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bty = null;
        this.btA = true;
        this.btB = false;
        this.bsP = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.btz.play();
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
                d.this.Mh().Md();
                d.this.Mk();
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
        this.btC = new a.InterfaceC0215a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0215a
            public void dL(int i) {
                d.this.Mh().Md();
            }
        };
    }

    public d m(@NonNull File file) {
        this.btt = file;
        return this;
    }

    public d fW(String str) {
        this.btv = str;
        return this;
    }

    public d fX(String str) {
        this.btu = str;
        return this;
    }

    public d fY(@NonNull String str) {
        this.bsK = str;
        return this;
    }

    public d cI(boolean z) {
        this.btw = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.btz = aVar;
        return this;
    }

    public d cJ(boolean z) {
        this.btx = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Me() {
        this.btr = (FrameLayout) this.mRootView.findViewById(b.C0216b.video_splash_view_content);
        this.btp = this.mRootView.findViewById(b.C0216b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0216b.video_mask_view);
        this.bts = (ImageView) this.mRootView.findViewById(b.C0216b.video_splash_view_bs);
        if (this.btx) {
            Mn();
        }
        Mo();
        if (this.btw) {
            Mp();
        }
    }

    private void Mn() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.btt.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bts.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bts.setImageBitmap(bitmap);
            cK(true);
        }
    }

    private void Mo() {
        View rq = this.btz.rq();
        if (rq != null && rq.getParent() != this.btr) {
            if (rq.getParent() != null) {
                ((ViewGroup) rq.getParent()).removeView(rq);
            }
            int width = this.btr.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.btr.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.btr.addView(rq, 1, layoutParams);
        }
    }

    private void Mp() {
        if (this.btz != null) {
            this.btB = false;
            this.btz.a(this.btt, this.btu, this.bsP, this.bsK, this, this.btC, this.bsQ);
            this.btz.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void Mj() {
        super.Mj();
        this.btB = true;
        if (this.btz != null && this.btz.LZ()) {
            this.btz.pause();
            this.btz.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(boolean z) {
        if (z) {
            this.bts.setVisibility(0);
        } else {
            this.bts.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Ma() {
        return this.btz != null ? this.btz.Ma() : this.btp;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0217a
    public void fQ(String str) {
        this.bsK = str;
    }
}
