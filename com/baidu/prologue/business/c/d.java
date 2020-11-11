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
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0319a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.che.get().abT();
    private String chU;
    private com.baidu.prologue.b.b chZ;
    private View ciB;
    private FrameLayout ciD;
    private ImageView ciE;
    private File ciF;
    private String ciG;
    private String ciH;
    private boolean ciI;
    private boolean ciJ;
    private Bitmap ciK;
    private com.baidu.prologue.business.a.a ciL;
    protected boolean ciM;
    protected boolean ciN;
    private a.InterfaceC0317a ciO;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.ciB = null;
        this.ciI = true;
        this.ciJ = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.ciK = null;
        this.ciM = true;
        this.ciN = false;
        this.chZ = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.ciL.play();
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
                d.this.acI().acF();
                d.this.acL();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean U(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dM(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.ciO = new a.InterfaceC0317a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0317a
            public void gY(int i) {
                d.this.acI().acF();
            }
        };
    }

    public d v(@NonNull File file) {
        this.ciF = file;
        return this;
    }

    public d jK(String str) {
        this.ciH = str;
        return this;
    }

    public d jL(String str) {
        this.ciG = str;
        return this;
    }

    public d jM(@NonNull String str) {
        this.chU = str;
        return this;
    }

    public d dK(boolean z) {
        this.ciI = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.ciL = aVar;
        return this;
    }

    public d dL(boolean z) {
        this.ciJ = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void XQ() {
        this.ciD = (FrameLayout) this.mRootView.findViewById(b.C0318b.video_splash_view_content);
        this.ciB = this.mRootView.findViewById(b.C0318b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0318b.video_mask_view);
        this.ciE = (ImageView) this.mRootView.findViewById(b.C0318b.video_splash_view_bs);
        if (this.ciJ) {
            acO();
        }
        acP();
        if (this.ciI) {
            acQ();
        }
    }

    private void acO() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.ciF.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.ciE.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ciE.setImageBitmap(bitmap);
            dM(true);
        }
    }

    private void acP() {
        View tG = this.ciL.tG();
        if (tG != null && tG.getParent() != this.ciD) {
            if (tG.getParent() != null) {
                ((ViewGroup) tG.getParent()).removeView(tG);
            }
            int width = this.ciD.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.ciD.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.ciD.addView(tG, 1, layoutParams);
        }
    }

    private void acQ() {
        if (this.ciL != null) {
            this.ciN = false;
            this.ciL.a(this.ciF, this.ciG, this.chZ, this.chU, this, this.ciO, this.cia);
            this.ciL.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void acK() {
        super.acK();
        this.ciN = true;
        if (this.ciL != null && this.ciL.acC()) {
            this.ciL.pause();
            this.ciL.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(boolean z) {
        if (z) {
            this.ciE.setVisibility(0);
        } else {
            this.ciE.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View acD() {
        return this.ciL != null ? this.ciL.acD() : this.ciB;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0319a
    public void jE(String str) {
        this.chU = str;
    }
}
