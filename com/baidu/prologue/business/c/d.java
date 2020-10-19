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
/* loaded from: classes19.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0293a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bSV.get().XA();
    private String bTL;
    private com.baidu.prologue.b.b bTQ;
    private Bitmap bUA;
    private com.baidu.prologue.business.a.a bUB;
    protected boolean bUC;
    protected boolean bUD;
    private a.InterfaceC0291a bUE;
    private View bUr;
    private FrameLayout bUt;
    private ImageView bUu;
    private File bUv;
    private String bUw;
    private String bUx;
    private boolean bUy;
    private boolean bUz;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.bUr = null;
        this.bUy = true;
        this.bUz = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.bUA = null;
        this.bUC = true;
        this.bUD = false;
        this.bTQ = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.bUB.play();
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
                d.this.Yq().Ym();
                d.this.Yt();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean T(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dr(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.bUE = new a.InterfaceC0291a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0291a
            public void gD(int i) {
                d.this.Yq().Ym();
            }
        };
    }

    public d v(@NonNull File file) {
        this.bUv = file;
        return this;
    }

    public d je(String str) {
        this.bUx = str;
        return this;
    }

    public d jf(String str) {
        this.bUw = str;
        return this;
    }

    public d jg(@NonNull String str) {
        this.bTL = str;
        return this;
    }

    public d dp(boolean z) {
        this.bUy = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.bUB = aVar;
        return this;
    }

    public d dq(boolean z) {
        this.bUz = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Yn() {
        this.bUt = (FrameLayout) this.mRootView.findViewById(b.C0292b.video_splash_view_content);
        this.bUr = this.mRootView.findViewById(b.C0292b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0292b.video_mask_view);
        this.bUu = (ImageView) this.mRootView.findViewById(b.C0292b.video_splash_view_bs);
        if (this.bUz) {
            Yw();
        }
        Yx();
        if (this.bUy) {
            Yy();
        }
    }

    private void Yw() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.bUv.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.bUu.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bUu.setImageBitmap(bitmap);
            dr(true);
        }
    }

    private void Yx() {
        View tG = this.bUB.tG();
        if (tG != null && tG.getParent() != this.bUt) {
            if (tG.getParent() != null) {
                ((ViewGroup) tG.getParent()).removeView(tG);
            }
            int width = this.bUt.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.bUt.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.bUt.addView(tG, 1, layoutParams);
        }
    }

    private void Yy() {
        if (this.bUB != null) {
            this.bUD = false;
            this.bUB.a(this.bUv, this.bUw, this.bTQ, this.bTL, this, this.bUE, this.bTR);
            this.bUB.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void Ys() {
        super.Ys();
        this.bUD = true;
        if (this.bUB != null && this.bUB.Yj()) {
            this.bUB.pause();
            this.bUB.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (z) {
            this.bUu.setVisibility(0);
        } else {
            this.bUu.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View Yk() {
        return this.bUB != null ? this.bUB.Yk() : this.bUr;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0293a
    public void iY(String str) {
        this.bTL = str;
    }
}
