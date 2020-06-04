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
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0250a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bzx.get().ND();
    private View bAS;
    private FrameLayout bAU;
    private ImageView bAV;
    private File bAW;
    private String bAX;
    private String bAY;
    private boolean bAZ;
    private String bAn;
    private com.baidu.prologue.b.b bAs;
    private boolean bBa;
    private Bitmap bBb;
    private com.baidu.prologue.business.a.a bBc;
    protected boolean bBd;
    protected boolean bBe;
    private a.InterfaceC0248a bBf;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bAS = null;
        this.bAZ = true;
        this.bBa = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bBb = null;
        this.bBd = true;
        this.bBe = false;
        this.bAs = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bBc.play();
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
            public void N(int i, int i2) {
            }

            @Override // com.baidu.prologue.b.b
            public boolean onError(int i, int i2) {
                d.this.Ou().Oq();
                d.this.Ox();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean O(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.cW(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bBf = new a.InterfaceC0248a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0248a
            public void dT(int i) {
                d.this.Ou().Oq();
            }
        };
    }

    public d q(@NonNull File file) {
        this.bAW = file;
        return this;
    }

    public d gI(String str) {
        this.bAY = str;
        return this;
    }

    public d gJ(String str) {
        this.bAX = str;
        return this;
    }

    public d gK(@NonNull String str) {
        this.bAn = str;
        return this;
    }

    public d cU(boolean z) {
        this.bAZ = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bBc = aVar;
        return this;
    }

    public d cV(boolean z) {
        this.bBa = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Or() {
        this.bAU = (FrameLayout) this.mRootView.findViewById(b.C0249b.video_splash_view_content);
        this.bAS = this.mRootView.findViewById(b.C0249b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0249b.video_mask_view);
        this.bAV = (ImageView) this.mRootView.findViewById(b.C0249b.video_splash_view_bs);
        if (this.bBa) {
            OA();
        }
        OB();
        if (this.bAZ) {
            OC();
        }
    }

    private void OA() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bAW.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bAV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bAV.setImageBitmap(bitmap);
            cW(true);
        }
    }

    private void OB() {
        View rx2 = this.bBc.rx();
        if (rx2 != null && rx2.getParent() != this.bAU) {
            if (rx2.getParent() != null) {
                ((ViewGroup) rx2.getParent()).removeView(rx2);
            }
            int width = this.bAU.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bAU.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bAU.addView(rx2, 1, layoutParams);
        }
    }

    private void OC() {
        if (this.bBc != null) {
            this.bBe = false;
            this.bBc.a(this.bAW, this.bAX, this.bAs, this.bAn, this, this.bBf, this.bAt);
            this.bBc.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void Ow() {
        super.Ow();
        this.bBe = true;
        if (this.bBc != null && this.bBc.Om()) {
            this.bBc.pause();
            this.bBc.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(boolean z) {
        if (z) {
            this.bAV.setVisibility(0);
        } else {
            this.bAV.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View On() {
        return this.bBc != null ? this.bBc.On() : this.bAS;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0250a
    public void gC(String str) {
        this.bAn = str;
    }
}
