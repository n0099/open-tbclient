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
/* loaded from: classes14.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0328a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.clZ.get().aes();
    private String cmQ;
    private com.baidu.prologue.b.b cmV;
    private ImageView cnA;
    private File cnB;
    private String cnC;
    private String cnD;
    private boolean cnE;
    private boolean cnF;
    private Bitmap cnG;
    private com.baidu.prologue.business.a.a cnH;
    protected boolean cnI;
    protected boolean cnJ;
    private a.InterfaceC0326a cnK;
    private View cnx;
    private FrameLayout cnz;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.cnx = null;
        this.cnE = true;
        this.cnF = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.cnG = null;
        this.cnI = true;
        this.cnJ = false;
        this.cmV = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.cnH.play();
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
                d.this.afh().afe();
                d.this.afk();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean W(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.ee(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.cnK = new a.InterfaceC0326a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0326a
            public void hs(int i) {
                d.this.afh().afe();
            }
        };
    }

    public d t(@NonNull File file) {
        this.cnB = file;
        return this;
    }

    public d kl(String str) {
        this.cnD = str;
        return this;
    }

    public d km(String str) {
        this.cnC = str;
        return this;
    }

    public d kn(@NonNull String str) {
        this.cmQ = str;
        return this;
    }

    public d ec(boolean z) {
        this.cnE = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.cnH = aVar;
        return this;
    }

    public d ed(boolean z) {
        this.cnF = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void ZG() {
        this.cnz = (FrameLayout) this.mRootView.findViewById(b.C0327b.video_splash_view_content);
        this.cnx = this.mRootView.findViewById(b.C0327b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0327b.video_mask_view);
        this.cnA = (ImageView) this.mRootView.findViewById(b.C0327b.video_splash_view_bs);
        if (this.cnF) {
            afn();
        }
        afo();
        if (this.cnE) {
            afp();
        }
    }

    private void afn() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.cnB.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.cnA.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cnA.setImageBitmap(bitmap);
            ee(true);
        }
    }

    private void afo() {
        View tJ = this.cnH.tJ();
        if (tJ != null && tJ.getParent() != this.cnz) {
            if (tJ.getParent() != null) {
                ((ViewGroup) tJ.getParent()).removeView(tJ);
            }
            int width = this.cnz.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.cnz.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.cnz.addView(tJ, 1, layoutParams);
        }
    }

    private void afp() {
        if (this.cnH != null) {
            this.cnJ = false;
            this.cnH.a(this.cnB, this.cnC, this.cmV, this.cmQ, this, this.cnK, this.cmW);
            this.cnH.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void afj() {
        super.afj();
        this.cnJ = true;
        if (this.cnH != null && this.cnH.afb()) {
            this.cnH.pause();
            this.cnH.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(boolean z) {
        if (z) {
            this.cnA.setVisibility(0);
        } else {
            this.cnA.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View afc() {
        return this.cnH != null ? this.cnH.afc() : this.cnx;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0328a
    public void kf(String str) {
        this.cmQ = str;
    }
}
