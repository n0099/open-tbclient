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
/* loaded from: classes6.dex */
public class d extends b<com.baidu.prologue.business.b.c> implements a.InterfaceC0328a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.ctd.get().agp();
    private String ctW;
    private View cuE;
    private FrameLayout cuG;
    private ImageView cuH;
    private File cuI;
    private String cuJ;
    private String cuK;
    private boolean cuL;
    private boolean cuM;
    private Bitmap cuN;
    private com.baidu.prologue.business.a.a cuO;
    protected boolean cuP;
    protected boolean cuQ;
    private a.InterfaceC0326a cuR;
    private com.baidu.prologue.b.b cub;
    private View mMaskView;
    private int mVideoHeight;
    private int mVideoWidth;

    public d(@NonNull Context context) {
        super(context);
        this.cuE = null;
        this.cuL = true;
        this.cuM = true;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.cuN = null;
        this.cuP = true;
        this.cuQ = false;
        this.cub = new com.baidu.prologue.b.b() { // from class: com.baidu.prologue.business.c.d.1
            @Override // com.baidu.prologue.b.b
            public void onPrepared() {
                d.this.cuO.play();
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
                d.this.ahe().ahb();
                d.this.ahh();
                return false;
            }

            @Override // com.baidu.prologue.b.b
            public boolean X(int i, int i2) {
                if (i == 3) {
                    d.this.mUiHandler.postDelayed(new Runnable() { // from class: com.baidu.prologue.business.c.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.en(false);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }
        };
        this.cuR = new a.InterfaceC0326a() { // from class: com.baidu.prologue.business.c.d.2
            @Override // com.baidu.prologue.b.a.InterfaceC0326a
            public void hr(int i) {
                d.this.ahe().ahb();
            }
        };
    }

    public d x(@NonNull File file) {
        this.cuI = file;
        return this;
    }

    public d kf(String str) {
        this.cuK = str;
        return this;
    }

    public d kg(String str) {
        this.cuJ = str;
        return this;
    }

    public d kh(@NonNull String str) {
        this.ctW = str;
        return this;
    }

    public d el(boolean z) {
        this.cuL = z;
        return this;
    }

    public d b(@NonNull com.baidu.prologue.business.a.a aVar) {
        this.cuO = aVar;
        return this;
    }

    public d em(boolean z) {
        this.cuM = z;
        return this;
    }

    @Override // com.baidu.prologue.business.c.a
    public int getLayoutId() {
        return b.c.splash_ad_video;
    }

    @Override // com.baidu.prologue.business.c.a
    public void abo() {
        this.cuG = (FrameLayout) this.mRootView.findViewById(b.C0327b.video_splash_view_content);
        this.cuE = this.mRootView.findViewById(b.C0327b.video_splash_clickable);
        this.mMaskView = this.mRootView.findViewById(b.C0327b.video_mask_view);
        this.cuH = (ImageView) this.mRootView.findViewById(b.C0327b.video_splash_view_bs);
        if (this.cuM) {
            ahk();
        }
        ahl();
        if (this.cuL) {
            ahm();
        }
    }

    private void ahk() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.cuI.getAbsolutePath());
            this.mVideoHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            this.mVideoWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            Log.e("SplashVideoViewBuilder", "Video retr fail : " + e.getMessage());
            bitmap = null;
        }
        if (bitmap != null) {
            this.cuH.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cuH.setImageBitmap(bitmap);
            en(true);
        }
    }

    private void ahl() {
        View th = this.cuO.th();
        if (th != null && th.getParent() != this.cuG) {
            if (th.getParent() != null) {
                ((ViewGroup) th.getParent()).removeView(th);
            }
            int width = this.cuG.getWidth();
            if (width <= 0) {
                width = -1;
            }
            int height = this.cuG.getHeight();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(width, height > 0 ? height : -1));
            layoutParams.gravity = 17;
            this.cuG.addView(th, 1, layoutParams);
        }
    }

    private void ahm() {
        if (this.cuO != null) {
            this.cuQ = false;
            this.cuO.a(this.cuI, this.cuJ, this.cub, this.ctW, this, this.cuR, this.cuc);
            this.cuO.prepare();
        }
    }

    @Override // com.baidu.prologue.business.c.b
    public void ahg() {
        super.ahg();
        this.cuQ = true;
        if (this.cuO != null && this.cuO.agY()) {
            this.cuO.pause();
            this.cuO.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(boolean z) {
        if (z) {
            this.cuH.setVisibility(0);
        } else {
            this.cuH.setVisibility(8);
        }
    }

    @Override // com.baidu.prologue.business.c.a
    public View agZ() {
        return this.cuO != null ? this.cuO.agZ() : this.cuE;
    }

    @Override // com.baidu.prologue.business.a.a.InterfaceC0328a
    public void ka(String str) {
        this.ctW = str;
    }
}
