package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private long beW;
    private Runnable beX;
    private com.baidu.live.yuyingift.dynamicgift.a caH;
    private a caI;
    private b caJ;

    /* loaded from: classes10.dex */
    interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface b {
        void GO();

        void GP();

        void di(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.caJ = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void di(int i) {
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GP() {
                AlaDynamicGiftAnimationView.this.caH.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.beX != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.beX);
                }
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caJ = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void di(int i) {
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GP() {
                AlaDynamicGiftAnimationView.this.caH.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.beX != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.beX);
                }
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caJ = new b() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void di(int i2) {
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.b
            public void GP() {
                AlaDynamicGiftAnimationView.this.caH.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.beX != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.beX);
                }
                if (AlaDynamicGiftAnimationView.this.caI != null) {
                    AlaDynamicGiftAnimationView.this.caI.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.beX = new c(this);
        this.caH = new com.baidu.live.yuyingift.dynamicgift.a();
        this.caH.a(this.caJ);
    }

    public void setScreen(int i, int i2) {
        if (this.caH != null) {
            this.caH.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.caH.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
        if (this.beX != null) {
            mHandler.postDelayed(this.beX, (long) this.caH.GT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bfa;

        public c(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bfa = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bfa != null && (alaDynamicGiftAnimationView = this.bfa.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.caH.GS()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.beW > 4000 && alaDynamicGiftAnimationView.caJ != null) {
                            alaDynamicGiftAnimationView.caJ.GP();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.GN();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.caH.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.caH != null) {
            this.caH.h(canvas);
        }
    }

    public void startAnim() {
        this.beW = System.currentTimeMillis();
        GN();
    }

    public void stopAnim() {
        if (mHandler != null && this.beX != null) {
            mHandler.removeCallbacks(this.beX);
        }
        this.caH.release();
    }

    public void setFrameCallback(a aVar) {
        this.caI = aVar;
    }
}
