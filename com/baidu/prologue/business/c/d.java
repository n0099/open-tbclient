package com.baidu.prologue.business.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.prologue.b;
import com.baidu.prologue.b.a;
import com.baidu.prologue.business.a.a;
import java.io.File;
/* loaded from: classes5.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0311a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.cop.get().acv();
    private View cpM;
    private FrameLayout cpO;
    private ImageView cpP;
    private File cpQ;
    private String cpR;
    private String cpS;
    private boolean cpT;
    private boolean cpU;
    private Bitmap cpV;
    private com.baidu.prologue.business.a.a cpW;
    protected boolean cpX;
    protected boolean cpY;
    private a.InterfaceC0309a cpZ;
    private String cpf;
    private com.baidu.prologue.b.b cpk;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.cpM = null;
        this.cpT = true;
        this.cpU = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.cpV = null;
        this.cpX = true;
        this.cpY = false;
        this.cpk = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.cpW.play();
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
            public boolean W(int i, int i2) {
                d.this.adk().adh();
                d.this.adn();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean X(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.ej(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.cpZ = new a.InterfaceC0309a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0309a
            public void fK(int i) {
                d.this.adk().adh();
            }
        };
    }

    public d w(@NonNull File file) {
        this.cpQ = file;
        return this;
    }

    public d iU(String str) {
        this.cpS = str;
        return this;
    }

    public d iV(String str) {
        this.cpR = str;
        return this;
    }

    public d iW(@NonNull String str) {
        this.cpf = str;
        return this;
    }

    public d eh(boolean z) {
        this.cpT = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.cpW = aVar;
        return this;
    }

    public d ei(boolean z) {
        this.cpU = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void Xv() {
        this.cpO = (FrameLayout) this.mRootView.findViewById(b.C0310b.video_splash_view_content);
        this.cpM = this.mRootView.findViewById(b.C0310b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0310b.video_mask_view);
        this.cpP = (ImageView) this.mRootView.findViewById(b.C0310b.video_splash_view_bs);
        if (this.cpU) {
            adq();
        }
        adr();
        if (this.cpT) {
            ads();
        }
    }

    private void adq() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.cpQ.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.cpP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cpP.setImageBitmap(bitmap);
            ej(true);
        }
    }

    private void adr() {
        View sW = this.cpW.sW();
        if (sW != null && sW.getParent() != this.cpO) {
            if (sW.getParent() != null) {
                ((ViewGroup) sW.getParent()).removeView(sW);
            }
            int width = this.cpO.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.cpO.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.cpO.addView(sW, 1, layoutParams);
        }
    }

    private void ads() {
        if (this.cpW != null) {
            this.cpY = false;
            this.cpW.a(this.cpQ, this.cpR, this.cpk, this.cpf, this, this.cpZ, this.cpl);
            this.cpW.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void adm() {
        super.adm();
        this.cpY = true;
        if (this.cpW != null && this.cpW.ade()) {
            this.cpW.pause();
            this.cpW.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej(boolean z) {
        if (z) {
            this.cpP.setVisibility(0);
        } else {
            this.cpP.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View adf() {
        return this.cpW != null ? this.cpW.adf() : this.cpM;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0311a
    public void iP(String str) {
        this.cpf = str;
    }
}
