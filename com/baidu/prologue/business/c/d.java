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
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0307a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.cbs.get().Zu();
    private View ccP;
    private FrameLayout ccR;
    private ImageView ccS;
    private File ccT;
    private String ccU;
    private String ccV;
    private boolean ccW;
    private boolean ccX;
    private Bitmap ccY;
    private com.baidu.prologue.business.a.a ccZ;
    private String cci;
    private com.baidu.prologue.b.b ccn;
    protected boolean cda;
    protected boolean cdb;
    private a.InterfaceC0305a cdc;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.ccP = null;
        this.ccW = true;
        this.ccX = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.ccY = null;
        this.cda = true;
        this.cdb = false;
        this.ccn = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.ccZ.play();
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
                d.this.aaj().aag();
                d.this.aam();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean U(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.dF(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.cdc = new a.InterfaceC0305a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0305a
            public void gO(int i) {
                d.this.aaj().aag();
            }
        };
    }

    public d v(@NonNull File file) {
        this.ccT = file;
        return this;
    }

    public d jx(String str) {
        this.ccV = str;
        return this;
    }

    public d jy(String str) {
        this.ccU = str;
        return this;
    }

    public d jz(@NonNull String str) {
        this.cci = str;
        return this;
    }

    public d dD(boolean z) {
        this.ccW = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.ccZ = aVar;
        return this;
    }

    public d dE(boolean z) {
        this.ccX = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Vr() {
        this.ccR = (FrameLayout) this.mRootView.findViewById(b.C0306b.video_splash_view_content);
        this.ccP = this.mRootView.findViewById(b.C0306b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0306b.video_mask_view);
        this.ccS = (ImageView) this.mRootView.findViewById(b.C0306b.video_splash_view_bs);
        if (this.ccX) {
            aap();
        }
        aaq();
        if (this.ccW) {
            aar();
        }
    }

    private void aap() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.ccT.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.ccS.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ccS.setImageBitmap(bitmap);
            dF(true);
        }
    }

    private void aaq() {
        View tG = this.ccZ.tG();
        if (tG != null && tG.getParent() != this.ccR) {
            if (tG.getParent() != null) {
                ((ViewGroup) tG.getParent()).removeView(tG);
            }
            int width = this.ccR.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.ccR.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.ccR.addView(tG, 1, layoutParams);
        }
    }

    private void aar() {
        if (this.ccZ != null) {
            this.cdb = false;
            this.ccZ.a(this.ccT, this.ccU, this.ccn, this.cci, this, this.cdc, this.cco);
            this.ccZ.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void aal() {
        super.aal();
        this.cdb = true;
        if (this.ccZ != null && this.ccZ.aad()) {
            this.ccZ.pause();
            this.ccZ.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(boolean z) {
        if (z) {
            this.ccS.setVisibility(0);
        } else {
            this.ccS.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View aae() {
        return this.ccZ != null ? this.ccZ.aae() : this.ccP;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0307a
    public void jr(String str) {
        this.cci = str;
    }
}
